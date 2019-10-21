package htmlparsing.data;

import java.net.Socket;

import htmlparsing.def.Def;



/*
 * inner Message Data Structure
 * 
 * 
 * */
public class DataPack {
	/** 
	 * datatype : DATA_TYPE_INSTREAM (Object : InputStream class type)
	 * datatype : DATA_TYPE_UNKNOWN or DATA_TYPE_DELETE or DATA_TYPE_ADD or DATA_TYPE_UPDATE
	 *            (Object : SDInfo class type)
	 * */
	public int datatype;
	public Object data;
	public Object data2;
	public Object data3;
	public Object data4;
	public int index;
	public int subindex;
	public String ip;
	public int port;
	public Socket socket;
	public String deviceid;
	public byte[] buf;
	
	public DataPack() {
		this.datatype = Def.DATA_TYPE_UNKNOWN;
		this.data = null;
		this.data2 = null;
		this.data3 = null;
		this.data4 = null;
		this.index = -1;
		this.subindex = -1;
		this.ip = "";
		this.port = 0;
		this.socket = null;
		this.deviceid = "";
	}
	
	public DataPack(DataPack dataPack) {
		this.datatype = dataPack.datatype;
		this.data = dataPack.data;
		this.data2 = dataPack.data2;
		this.data3 = dataPack.data3;
		this.data4 = dataPack.data4;
		this.index = dataPack.index;
		this.subindex = dataPack.subindex;
		this.ip = dataPack.ip;
		this.port = dataPack.port;
		this.socket = dataPack.socket;
		this.deviceid = dataPack.deviceid;
	}

}

