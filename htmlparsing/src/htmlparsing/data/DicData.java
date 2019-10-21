package htmlparsing.data;


public class DicData {
	private String data;
	private String contents;
	private String usage;
	private String regdate;
	
	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public DicData() {
		
	}

	@Override
	public String toString() {
		return "DicData [data=" + data + ", contents=" + contents + ", usage=" + usage + "]";
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getUsage() {
		return usage;
	}

	public void setUsage(String usage) {
		this.usage = usage;
	}

	
	
}
