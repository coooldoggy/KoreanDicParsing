package htmlparsing.common;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import htmlparsing.data.DBInfo;
import htmlparsing.data.DataPack;
import htmlparsing.data.DicData;
import htmlparsing.data.SafeQueue;
import htmlparsing.util.Logger;


public class DBManager {
	public String TAG = this.getClass().getSimpleName() + " ";
	private static DBManager instance;

	private static final int DB_WORKER_SLEEP = 10;

	private Thread mDBWorker = null;
	private volatile SafeQueue mWriteQ = new SafeQueue();

	private DBInfo[] maDBInfo = new DBInfo[1];

	private String qt = "'";

	public DBManager() {
	}

	public static DBManager createInstance() {
		if (null == instance) {
			instance = new DBManager();
			instance.init();
		}
		return instance;
	}

	public static DBManager getInstance() {
		return instance;
	}

	private void init() {
		DBInfo dbinfo = new DBInfo();
		dbinfo.mDBName = ConfigManager.DB_NAME_APP;
		dbinfo.mJDBCURL = "jdbc:mysql://" + ConfigManager.DB_IP + ":" + ConfigManager.DB_PORT + "/" + dbinfo.mDBName + "?useUnicode=true&characterEncoding=utf-8";
		dbinfo.mUserID = ConfigManager.DB_USER;
		dbinfo.mUserPW = ConfigManager.DB_PWD;
		maDBInfo[0] = dbinfo;

		for (int i = 0; i < maDBInfo.length; i++) {
			openDB(maDBInfo[i]);
		}

		if (mDBWorker == null) {
			mDBWorker = new DBWorker();
		}
		if (!mDBWorker.isAlive()) {
			mDBWorker.setName(TAG + "-DBWorker");
			mDBWorker.start();
			Logger.d(TAG, "init() Thread Start! id=" + mDBWorker.getId() + " name=" + mDBWorker.getName());
		}
		
		// DB open 종료 후 DataManager 서비스 가동
		DataManager.createInstance();
		DataManager.getInstance().startService();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		destroy();
		super.finalize();
	}
	
	public boolean isUse() {
		boolean result = true;
		
		try {
			for (int i = 0; i < maDBInfo.length; i++) {
				if(maDBInfo[i] == null) {
					result = false;
					break;
				}
				for (int j = 0; j < maDBInfo[i].mStatements.length; j++) {
					if(maDBInfo[i].mStatements[j] == null) {
						result = false;
						break;
					}
					if(maDBInfo[i].mStatements[j].isClosed()) {
						result = false;
						break;
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = false;
		}
		
		return result;
	}

	public void destroy() {
		if (mDBWorker == null) {
			Logger.d(TAG, "destroy() Thread Destroy! id=" + mDBWorker.getId() + " name=" + mDBWorker.getName());
			((DBWorker) mDBWorker).kill();
			mDBWorker = null;
			// UUtils.sleep(Def.THREAD_KILL_SLEEP_TIME);
		}
		for (int i = 0; i < maDBInfo.length; i++) {
			closeDB(maDBInfo[i]);
		}
	}
	
	public void openDB() {
		for (int i = 0; i < maDBInfo.length; i++) {
			openDB(maDBInfo[i]);
		}
	}

	private boolean openDB(DBInfo dbinfo) {
		try {
			Class.forName(ConfigManager.DB_CLASS);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		if (ConfigManager.DB_NAME_APP.equals(dbinfo.mDBName)) {
			dbinfo.mConnections = new Connection[1];
			dbinfo.mStatements = new Statement[1];
		}

		if (dbinfo.mConnections == null) {
			// error
			Logger.e(TAG, "openDB(), Null is DB Connection Value!, dbname=" + dbinfo.mDBName);
			return false;
		} else {
			for (int i = 0; i < dbinfo.mConnections.length; i++) {
				try {
					dbinfo.mConnections[i] = (Connection) DriverManager.getConnection(dbinfo.mJDBCURL, dbinfo.mUserID,
							dbinfo.mUserPW);
					dbinfo.mStatements[i] = (Statement) dbinfo.mConnections[i].createStatement();
					dbinfo.mStatements[i].execute("use " + dbinfo.mDBName);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					Logger.e(TAG, "openDB(), DB Connection Failed!, dbname=" + dbinfo.mDBName);
					return false;
				} // end try
			} // end for
		} // end if

		Logger.d(TAG, "openDB(), DB Open Success!, dbname=" + dbinfo.mDBName);

		return true;
	}

	private void closeDB(DBInfo dbinfo) {
		Logger.d(TAG, "closeDB() call!");
		if (dbinfo.mStatements == null) {
			return;
		}

		try {
			for (int i = 0; i < dbinfo.mStatements.length; i++) {
				if (dbinfo.mStatements[i] != null)
					dbinfo.mStatements[i].close();
				dbinfo.mStatements[i] = null;
			}
			for (int i = 0; i < dbinfo.mConnections.length; i++) {
				if (dbinfo.mConnections[i] != null)
					dbinfo.mConnections[i].close();
				dbinfo.mConnections[i] = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		dbinfo.mStatements = null;
		dbinfo.mConnections = null;
	}
	
	public void setDataQ(DataPack datapack) {
		mWriteQ.setQueue(datapack.datatype, datapack.data, datapack.data2);
	}

	public void insertData(DicData dicdata) {
		int dbindex = 0;
		int sessionindex = 0;
		
		java.sql.Connection conn = null;
		
		// read table basecode
		if(maDBInfo[dbindex] == null) {
			// error
			Logger.e(TAG, "insertData(), Null is DB Resource!");
			return;
		}
		DBInfo dbinfo = maDBInfo[dbindex];
		
		if(dbinfo.mStatements == null || dbinfo.mStatements[sessionindex] == null) {
			// error
			Logger.e(TAG, "insertData(), Null is Statements!, dbname=" + dbinfo.mDBName);
			return;
		}
		
		try {
			conn = dbinfo.mStatements[sessionindex].getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(conn == null) {
			return;
		}
		
		dicdata.setContents(dicdata.getContents().replace("¶", ""));
		dicdata.setUsage(dicdata.getUsage().replace("¶", ""));
		dicdata.setContents(dicdata.getContents().replace("「", ""));
		dicdata.setUsage(dicdata.getUsage().replace("「", ""));
		dicdata.setContents(dicdata.getContents().replace("」", ","));
		dicdata.setUsage(dicdata.getUsage().replace("」", ","));
		
//		if(dicdata.getData().contains("\\")) {
//			dicdata.setData(dicdata.getData().replaceAll("\\", "\'"));
//		}
//		
//		if(dicdata.getContents().contains("\\")) {
//			dicdata.getContents().
//		}
		
		try
	    {
//			String query = "insert into krdictemp (word, contents, usage) values (?,?,?)";
			String query = "insert into krdictemp values (?,?,?,?,?)";
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, null);
			preparedStatement.setString(2, dicdata.getData());
			preparedStatement.setString(3, dicdata.getContents());
			preparedStatement.setString(4, dicdata.getUsage());
			preparedStatement.setString(5, dicdata.getRegdate());
			preparedStatement.execute();
	    }
	    catch (Exception e) {
	    	closeDB(dbinfo);
			openDB(dbinfo);
	    	Logger.e(TAG, "insertData(), error=" + e.getMessage() + "data=" + dicdata.getData() + ", " + dicdata.getContents() + ", " + dicdata.getUsage());
	    }
	}
	
	// DBWorker class
	private class DBWorker extends Thread {

		private boolean m_bIsWorking = true;

		public void kill() {
			m_bIsWorking = false;
		}

		public void run() {

			while(m_bIsWorking) {
				
			if(mWriteQ.getSize() > 0) {
				Object[] datapacks = (Object[])mWriteQ.popQueues();
				for(int i = 0; i < datapacks.length; i ++) {
					DataPack datapack = (DataPack)datapacks[i];
					DicData dicdata = null;
					dicdata = (DicData)datapack.data;
					insertData(dicdata);
				}
			}
			
			try {
				sleep(DB_WORKER_SLEEP);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}//end while

		}// end run

	}// end DataWorker class

}