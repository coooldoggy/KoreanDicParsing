package htmlparsing.htmlparsingmain;

import htmlparsing.common.DataManager;
import htmlparsing.common.ParsingKor;

public class htmlparsingmain {

	public static void main(String[] args) {

		DataManager.createInstance();
		DataManager.getInstance().startService();

		ParsingKor.createInstance();
		ParsingKor.getInstance().startService();

		// ParsingEng.createInstance();
		// ParsingEng.getInstance().startService();

	}

}
