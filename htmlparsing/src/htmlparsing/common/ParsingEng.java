package htmlparsing.common;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ParsingEng {
	public String TAG = this.getClass().getSimpleName();
	private static ParsingEng instance;

	public ParsingEng() {
	}

	public static ParsingEng createInstance() {
		if (instance == null) {
			instance = new ParsingEng();
			init();
		}
		return instance;
	}

	public static ParsingEng getInstance() {
		if (instance == null) {
			createInstance();
		}
		return instance;
	}

	private static void init() {
	}

	public void startService() {
		englishDicHtml();
	}
	
	private void englishDicHtml() {
		String url = "https://www.dictionary.com/browse/a"; 
		Document doc = null;

		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for(Element e : doc.select("button")) {
			e.remove();
		}
		
		
		Elements title = doc.select("section > h1");
		for(Element e : title) {
			System.out.println(e.text());
		}
		
		Elements contents = doc.select("section > div");
		for(Element e : contents) {
			System.out.println(e.text());
		}
		
		
	}

}
