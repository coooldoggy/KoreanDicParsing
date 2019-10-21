package htmlparsing.common;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;



public class ParsingKor {
	public String TAG = this.getClass().getSimpleName();
	private static ParsingKor instance;
	private Thread mDataLoader = null;
	private static boolean islastdata = true;
	private static int randtime = 1;
	private static int DATA_LOADER_SLEEP = 1000;
	
	public ParsingKor() {
	}

	public static ParsingKor createInstance() {
		if (instance == null) {
			instance = new ParsingKor();
			init();
		}
		return instance;
	}

	public static ParsingKor getInstance() {
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
			mDataLoader.setDaemon(true);
		}
		if (!mDataLoader.isAlive()) {
			mDataLoader.start();
		}
	}

	private void koreanDicHtml()  {
		int i = 1;
		int count = 0;
		while (islastdata) {
			String url = "http://stdweb2.korean.go.kr/search/View.jsp?idx=" + i;
			Document doc = null;

			try {
				doc = Jsoup.connect(url).get();
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (doc.select("font").size() > 0 && i < 519210) {
				for (Element e : doc.select("font")) {
					System.out.println(e.text());
				}
			} else {
				if (count > 1000) {
					islastdata = false;
				}
				count++;
			}
			i++;
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

//			while(m_bIsWorking) {
			while(true) {
				koreanDicHtml();


				try {
					
					randtime = (int) (Math.random() * 10) + 1;
					sleep(DATA_LOADER_SLEEP * randtime);
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("" + DATA_LOADER_SLEEP * randtime);

			}//end while

		}//end run

	}//end DataWorker class
}
