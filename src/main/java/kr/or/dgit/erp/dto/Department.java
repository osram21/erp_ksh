package kr.or.dgit.erp.dto;

public class Department {
	private int Dcode;
	private String Dname;
	private int Floor;
	
	public Department() {}

	public Department(int dcode) {
		Dcode = dcode;
	}
	
	public Department(String dname) {
		Dname = dname;
	}

	public Department(int dcode, String dname, int floor) {
		Dcode = dcode;
		Dname = dname;
		Floor = floor;
	}

	public int getDcode() {
		return Dcode;
	}

	public void setDcode(int dcode) {
		Dcode = dcode;
	}

	public String getDname() {
		return Dname;
	}

	public void setDname(String dname) {
		Dname = dname;
	}

	public int getFloor() {
		return Floor;
	}

	public void setFloor(int floor) {
		Floor = floor;
	}

	@Override
	public String toString() {
		return String.format("%s(%s층)",Dname, Floor);
	}

	public Object[] toArray() {
		return new Object[]{String.format("D%03d",Dcode),Dname,Floor};
	}
}
