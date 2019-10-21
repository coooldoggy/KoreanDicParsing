package htmlparsing.data;

import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;

public class SafeQueue {
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Queue<DataPack> mMsgQ = new LinkedList();
	
	public SafeQueue() {
		
	}
	
	public void setQueue(int datatype, Object object) {
		synchronized(mMsgQ) {
			DataPack datapack = new DataPack();
			datapack.datatype = datatype;
			datapack.data = object;
			mMsgQ.offer((DataPack)datapack);
		}
	}
	
	public void setQueue(int datatype, Socket socket, byte[] buf) {
		synchronized(mMsgQ) {
			DataPack datapack = new DataPack();
			datapack.datatype = datatype;
			datapack.socket = socket;
			datapack.buf = buf;
			mMsgQ.offer((DataPack)datapack);
		}
	}
	
	public void setQueue(int datatype, Object object, Object object2) {
		synchronized(mMsgQ) {
			DataPack datapack = new DataPack();
			datapack.datatype = datatype;
			datapack.data = object;
			datapack.data2 = object2;
			mMsgQ.offer((DataPack)datapack);
		}
	}
	
	public void setQueue(int datatype, Object object, Object object2, Object object3) {
		synchronized(mMsgQ) {
			DataPack datapack = new DataPack();
			datapack.datatype = datatype;
			datapack.data = object;
			datapack.data2 = object2;
			datapack.data3 = object3;
			mMsgQ.offer((DataPack)datapack);
		}
	}
	
	public void setQueue(int datatype, Object object, Object object2, Object object3, Object object4) {
		synchronized(mMsgQ) {
			DataPack datapack = new DataPack();
			datapack.datatype = datatype;
			datapack.data = object;
			datapack.data2 = object2;
			datapack.data3 = object3;
			datapack.data4 = object4;
			mMsgQ.offer((DataPack)datapack);
		}
	}
	
	public void setQueue(int datatype, Socket socket, Object object, Object object2) {
		synchronized(mMsgQ) {
			DataPack datapack = new DataPack();
			datapack.datatype = datatype;
			datapack.socket = socket;
			datapack.data = object;
			datapack.data2 = object2;
			mMsgQ.offer((DataPack)datapack);
		}
	}
	
	public void setQueue(int datatype, String deviceid, Object object, Object object2, Socket socket, String ip, int port) {
		synchronized(mMsgQ) {
			DataPack datapack = new DataPack();
			datapack.datatype = datatype;
			datapack.deviceid = deviceid;
			datapack.data = object;
			datapack.data2 = object2;
			datapack.socket = socket;
			datapack.ip = ip;
			datapack.port = port;
			mMsgQ.offer((DataPack)datapack);
		}
	}
	
	public DataPack getQueue() {
		synchronized(mMsgQ) {
			return mMsgQ.peek();
		}
	}
	
	public DataPack[] getQueues() {
		DataPack[] objects = null;
		synchronized(mMsgQ) {
			objects = mMsgQ.toArray(new DataPack[mMsgQ.size()]);
			return objects;
		}
	}
	
	public DataPack[] popQueues(int size) {
		DataPack[] objects = new DataPack[size];
		for(int i=0; i<size; i++) {
			objects[i] = null;
		}
		
		int count = 0;
		synchronized(mMsgQ) {
			while(true) {
				if(count >= size)
					break;
				DataPack datapack = mMsgQ.poll();
				if(datapack == null)
					break;
				objects[count] = datapack;
				count++;
			}//end while
			return objects;
		}
	}
	
	public DataPack[] popQueues() {
		DataPack[] objects = null;
		synchronized(mMsgQ) {
			objects = mMsgQ.toArray(new DataPack[mMsgQ.size()]);
			mMsgQ.clear();
			return objects;
		}
	}
	
	public DataPack popQueue() {
		synchronized(mMsgQ) {
			return mMsgQ.poll();
		}
	}
	
	public int getSize() {
		synchronized(mMsgQ) {
			return mMsgQ.size();
		}
	}
}
