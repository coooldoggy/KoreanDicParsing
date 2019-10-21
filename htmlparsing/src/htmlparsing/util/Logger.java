package htmlparsing.util;

import java.nio.ByteBuffer;

public class Logger {
	private static int mType = 1;	// (0:run, 1:debug, 2:simulator)
	
	public static int getType() {
		return mType;
	}

	/*
	 * @param type=0:run, 1:debug, 2:simulator
	 * 
	 * */
	public static void setType(int type) {
		mType = type;
	}

	// debug log
	public static void d(String tag, String data) {
		if(getType() == 1) {
			System.out.println("[D] " + UUtils.getCurrentDateTime() + " " + tag + " " + data);
		}
	}
	
	// error log
	public static void e(String tag, String data) {
		System.out.println("[E] " + UUtils.getCurrentDateTime() + " " + tag + " " + data);
	}
	
	// info log
	public static void i(String tag, String data) {
		System.out.println("[I] " + UUtils.getCurrentDateTime() + " " + tag + " " + data);
	}
	
	// warning log
	public static void w(String tag, String data) {
		System.out.println("[W] " + UUtils.getCurrentDateTime() + " " + tag + " " + data);
	}
	
	// simulator log
	public static void s(String tag, String data) {
		if(getType() == 2)
			System.out.println("[S] " + UUtils.getCurrentDateTime() + " " + tag + " " + data);
	}
	
	public static char forDigit(int i, int j) {
		if (i >= j || i < 0) {
			return '\0';
		}
		if (j < 2 || j > 36) {
			return '\0';
		}
		if (i < 10) {
			return (char) (48 + i);
		} else {
			return (char) (87 + i);
		}
	}
	
	public static boolean isInvalidCharacter(char c) {
		return (c < ' ') || (c > '}');
	}
		
	public static void printHex(String title, ByteBuffer input, int inOff, int len) {
		printHex("UNKNOWN Class Name", "UNKNOWN Method Name", title, input, inOff, len);
	}
	
	public static void printHex(String clsName, String methodName, String title, ByteBuffer input, int inOff, int len) {
		int _tmpPos = input.position();
		
		input.rewind();
		
		byte[] _tmp = new byte[len];
				
		input.get(_tmp);				
		input.position(_tmpPos);
		
		printHex(clsName, methodName, title, _tmp, inOff, len);
		
		_tmp = null;
	}

	public static void printHex(byte[] input) {
		printHex("UNKNOWN Class Name", "UNKNOWN Method Name", input);
	}
	
	/**
	 * 특정 위치부터 byte array의 HEX 및 character값을 화면에 출력한다.
	 * 
	 * @param title
	 *            출력데이터의 이름
	 * @param input
	 *            입력데이터
	 * @param inOff
	 *            입력데이터에서 출력할 시작위치
	 * @param len
	 *            출력할 길이
	 */
	public static void printHex(String title, byte[] input, int inOff, int len) {		
		printHex("UNKNOWN Class Name", "UNKNOWN Method Name", title, input, inOff, len);
	}
	
	public static void printHex(String clsName, String methodName, String title, byte[] input, int inOff, int len) {
		print(clsName, methodName, "[" + title + "] " + len + "bytes");
		
		byte[] tmp = new byte[len];
		System.arraycopy(input, inOff, tmp, 0, len);
		printHex(clsName, methodName, tmp);	
	}
	
	public static void printHex(String clsName, String methodName, byte[] input) {
		int length = input.length;
		int line = length / 16;
		
		print(clsName, methodName, "00 01 02 03 04 05 06 07 08 09 10 11 12 13 14 15    0123456789abcdef");
		print(clsName, methodName, "===============================================    ================");
		
		for (int i = 0; i <= line; i++) {
			StringBuffer d = new StringBuffer(83);
			int column = Math.min(16, (length - i * 16));
			for (int j = 0; j < column; j++) {
				char hi = forDigit(input[i * 16 + j] >> 4 & 0x0F, 16);
				char lo = forDigit(input[i * 16 + j] & 0x0F, 16);
				d.append(Character.toUpperCase(hi));
				d.append(Character.toUpperCase(lo));
				d.append(':');
			}
			for (int j = 16; j >= column; j--) {
				d.append("   ");
			} 
			for (int j = 0; j < column; j++) {
				char tmp = (char) input[i * 16 + j];
				if (isInvalidCharacter(tmp)) {
					d.append('.');
				} else {
					d.append((char) input[i * 16 + j]);
				}
			}
			
			print(clsName, methodName, d.toString());
		}
	}
	
	public static void print(String logData) {
		print("UNKNOWN Method Name", logData);
	}
	
	public static void print(String methodName, String logData) {
		print("UNKNOWN Class Name", methodName, logData);
	}
	
	public static void print(String clsName, String methodName, String logData) {
		System.out.println("[D] " + clsName + "[" + methodName + "] " + logData);
	}
	
}
