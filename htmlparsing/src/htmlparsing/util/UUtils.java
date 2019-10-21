package htmlparsing.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Properties;


public class UUtils {

	public static byte[] getClearByte(int length) {
		byte[] temp = new byte[length];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = 0x20;			// set space 
		}
		return temp;
	}

	/*
	 * return : 1 byte unit type size
	 */
	public static int getTypeSize(@SuppressWarnings("rawtypes") Class classtype) {
		int size = 0;
		int eightbit = 8;

		if (classtype.equals(Short.TYPE)) {
			size = Short.SIZE / eightbit;
		} else if (classtype.equals(Integer.TYPE)) {
			size = Integer.SIZE / eightbit;
		} else if (classtype.equals(Long.TYPE)) {
			size = Long.SIZE / eightbit;
		} else if (classtype.equals(Float.TYPE)) {
			size = Float.SIZE / eightbit;
		} else if (classtype.equals(Double.TYPE)) {
			size = Double.SIZE / eightbit;
		} else if (classtype.equals(Byte.TYPE)) {
			size = Byte.SIZE / eightbit;
		}

		return size;
	}

	public static void sleep(long millisec) {
		try {
			Thread.sleep(millisec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getCurrentDateTime() {
		String datetime, date, time;
		datetime = Time.currentYMDHMS();
		date = datetime.substring(0, 8);
		time = datetime.substring(8, datetime.length());
		datetime = date.substring(0, 4) + "-" + date.substring(4, 6) + "-"
				+ date.substring(6, 8) + " ";
		datetime += time.substring(0, 2) + ":" + time.substring(2, 4) + ":"
				+ time.substring(4, 6);
		return datetime;
	}

	public static String getCurrentDateTimeEx() {
		String datetime, date, time;
		datetime = Time.currentYMDHMS();
		date = datetime.substring(0, 8);
		time = datetime.substring(8, datetime.length());
		datetime = date.substring(0, 4) + date.substring(4, 6)
				+ date.substring(6, 8);
		datetime += time.substring(0, 2) + time.substring(2, 4)
				+ time.substring(4, 6);
		return datetime;
	}

	public static long getTimeInMillis() {
		Calendar calendar = Calendar.getInstance();
		return calendar.getTimeInMillis();
	}

	public static String getCurrentDate() {
		String datetime, date;
		datetime = Time.currentYMDHMS();
		date = datetime.substring(0, 8);
		return date;
	}

	public static String getCurrentTime() {
		String datetime, time;
		datetime = Time.currentYMDHMS();
		time = datetime.substring(8, datetime.length());
		return time;
	}

	public static boolean isNumeric(String str) {
		if ("".equals(str.trim()))
			return false;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) < '0' || str.charAt(i) > '9') {
				return false;
			}
		}
		return true;
	}

	public static Properties readProperties(String filename) {
		Properties props = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filename);
			props.load(new InputStreamReader(fis));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return props;
	}
	
//	public static ArrayList<BaseObject> divideArrayData(int offset, int size, ArrayList<BaseObject> alsourcedata) {
//		ArrayList<BaseObject> result = new ArrayList<BaseObject>();
//		if(alsourcedata == null)
//			return result;
//		int index = offset;
//		int count = 0;
//		while(true) {
//			if(index >= alsourcedata.size())
//				break;
//			if(count >= size)
//				break;
//			result.add(alsourcedata.get(index));
//			index++;
//			count++;
//		}
//		return result;
//	}
	
//	public static int getOnePacketSendSize(ArrayList<BaseObject> albo) {
//		int result = 0;
//		if(albo == null || albo.size() <= 0)
//			return result;
//		
//		BaseObject bo = albo.get(0);
//		
//		switch(bo.classtype) {
//		case Def.CLASS_BASECODE :
//			break;
//		case Def.CLASS_CATEGORY :
//			break;
//		case Def.CLASS_COUPON_PUBLISH :
//			break;
//		case Def.CLASS_COUPONINFO :
//			break;
//		case Def.CLASS_FENCINGAREA_RECT :
//			
//			
//			break;
//		}
//		
//		return result;
//	}
	
	public static int sumStringArraySize(int[] adata) {
		int result = 0;
		if(adata == null || adata.length <= 0)
			return result;
		for(int i=0; i<adata.length; i++) {
			result += adata[i];
		}
		return result;
	}

}
