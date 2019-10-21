package htmlparsing.common;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import htmlparsing.data.DataPack;
import htmlparsing.data.DicData;
import htmlparsing.util.UUtils;

public class ParsingKor {
	public String TAG = this.getClass().getSimpleName();
	private static ParsingKor instance;
	private Thread mDataLoader = null;
	private static boolean islastdata = true;
	private static int randtime;
	private static int DATA_LOADER_SLEEP = 1000;
	private ArrayList<DicData> malDicdata = new ArrayList<DicData>();

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
			// mDataLoader.setDaemon(true);
		}
		if (!mDataLoader.isAlive()) {
			mDataLoader.start();
		}
	}

	public void setDicData(DicData data) {
		DicData dicdata = new DicData();
		dicdata.setData(data.getData());
		dicdata.setContents(data.getContents());
		dicdata.setUsage(data.getUsage());
		String time = UUtils.getCurrentDateTimeEx();
		time = time.substring(0, 10);
		dicdata.setRegdate(time);

		DataPack datapack = new DataPack();
		datapack.data = dicdata;
		DBManager.getInstance().setDataQ(datapack);
	}

	public ArrayList<DicData> getMalDicdata() {
		return malDicdata;
	}

	public void setMalDicdata(ArrayList<DicData> malDicdata) {
		this.malDicdata = malDicdata;
	}

	private void koreanDicHtml() {
		DicData dicdata = null;
		int i = 0;
		int count = 0;
		while (islastdata) {
			String url = "http://stdweb2.korean.go.kr/search/View.jsp?idx=" + i;
			Document doc = null;

			try {
				doc = Jsoup.connect(url).get();

				doc.select("span.korean-webfont").remove();

			} catch (IOException e) {
				e.printStackTrace();
			}

			if (doc.select("font").size() > 0) {
				dicdata = new DicData();
				String usage = "";
				String contents = "";

				Elements e = doc.select("span.word_title");
				// System.out.println(e + "td.pb10");
				Elements d = doc.select("div.list");
				Elements usetitle = doc.select("#use_title");
				List<String> ldata = e.eachText();
				List<String> lusage = usetitle.eachText();
				List<String> lcontents = d.eachText();

				// name , contents
				for (int j = 0; j < ldata.size(); j++) {
					String full = ldata.get(j);
					dicdata.setData(full);

				}
				for (int k = 0; k < lusage.size(); k++) {
					usage = lusage.get(k);
					usage = usage.replaceAll("\'", " ");
					dicdata.setUsage(usage);

				}
				for (int l = 0; l < lcontents.size(); l++) {
					contents = lcontents.get(l);

					// 한자 정규식 탐색
					String regEx = ".*[\u2e80-\u2eff\u31c0-\u31ef\u3200-\u32ff\u3400-\u4dbf\u4e00-\u9fbf\uf900-\ufaff].*";

					if (contents.matches(regEx)) {
						// (괄호안 데이터 삭제하는 정규 식)
						contents = contents.replaceAll("\\s*\\([^\\)]*\\)\\s*", " ");

					}

					dicdata.setContents(contents);
					setDicData(dicdata);
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
	 */
	public class DataLoader extends Thread {
		private boolean m_bIsWorking = true;

		public void kill() {
			m_bIsWorking = false;
		}

		public void run() {
			while (m_bIsWorking) {
				while (true) {
					koreanDicHtml();
					try {
						randtime = (int) (Math.random() * 10) + 1;
						sleep(DATA_LOADER_SLEEP * randtime);
					} catch (Exception e) {
						System.out.println(e.getMessage());

					}
				} // end while

			} // end run

		}// end DataWorker class
	}

}
