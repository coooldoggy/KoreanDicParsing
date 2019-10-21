package htmlparsing.data;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;


public class DBInfo {
	public String mJDBCURL;
	public String mUserID;
	public String mUserPW;
	public String mDBName;
	public Connection[] mConnections;
	public Statement[] mStatements;

	public DBInfo() {
		mJDBCURL = "";
		mUserID = "";
		mUserPW = "";
		mDBName = "";
		mConnections = null;
		mStatements = null;
	}
}
