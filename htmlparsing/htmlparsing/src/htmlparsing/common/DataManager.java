package htmlparsing.common;

public class DataManager {
	public String TAG = this.getClass().getSimpleName();
	private static DataManager instance;
	private Thread mDataLoader = null;
	private static final int DATA_LOADER_SLEEP = 1000;
	
	public DataManager() {
	}

	public static DataManager createInstance() {
		if (instance == null) {
			instance = new DataManager();
			init();
		}
		return instance;
	}

	public static DataManager getInstance() {
		if (instance == null) {
			createInstance();
		}
		return instance;
	}

	private static void init() {
	}

	public void startService() {
		if (mDataLoader == null) {
			mDataLoader = new DataLoader();
//			mDataLoader.setDaemon(true);
		}
		if (!mDataLoader.isAlive()) {
			mDataLoader.start();
		}
	}
	
	/*
	 * DataLoader class
	 * 
	 * */
	public class DataLoader extends Thread {
//		private boolean m_bIsWorking = true;

//		public void kill() {
//			m_bIsWorking = false;
//		}

		public void run() {

			while(true) {
				
				try {
					sleep(DATA_LOADER_SLEEP);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}//end while

		}//end run

	}//end DataWorker class
	
}
