package htmlparsing.htmlparsingmain;

import htmlparsing.common.DataManager;
import htmlparsing.common.ParsingKor;

public class htmlparsingmain {
	
	public static void main(String[] args) {
		
		//data read - > 객체를 만든다 (name, contents) -> DBmanager Q에 넣는다 
		//DBManager Thread 에서 50ms 마다 Q에서 꺼내서 DB insert (중복 상관없음 , trim ...)
		
		DataManager.createInstance();
		
		ParsingKor.createInstance();
		ParsingKor.getInstance().startService();
		
	}
	
}
