package kr.or.dgit.erp.dto;

public class Title {
	private int Tcode;
	private String Tname;
	
	public Title() {}

	public Title(int tcode) {
		Tcode = tcode;
	}
	

	public Title(String tname) {
		Tname = tname;
	}

	public Title(int tcode, String tname) {
		Tcode = tcode;
		Tname = tname;
	}

	public int getTcode() {
		return Tcode;
	}

	public void setTcode(int tcode) {
		Tcode = tcode;
	}

	public String getTname() {
		return Tname;
	}

	public void setTname(String tname) {
		Tname = tname;
	}

	@Override
	public String toString() {
		return String.format("%s",Tname);
	}

	public Object[] toArray() {
		return new Object[]{String.format("T%03d", Tcode),Tname};
	}
	
	
	
}
