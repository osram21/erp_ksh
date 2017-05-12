package kr.or.dgit.erp.dto;

public class Employee {
	private int Eno;
	private String Ename;
	private int Salary;
	private Department department;
	private Boolean gender;
	private String JoinDate;
	private Title title;
	
	public Employee() {}

	public Employee(int eno) {
		Eno = eno;
	}

	public Employee(int eno, String ename, int salary, Department department, Boolean gender, String joinDate,
			Title title) {
		Eno = eno;
		Ename = ename;
		Salary = salary;
		this.department = department;
		this.gender = gender;
		JoinDate = joinDate;
		this.title = title;
	}

	public int getEno() {
		return Eno;
	}

	public void setEno(int eno) {
		Eno = eno;
	}

	public String getEname() {
		return Ename;
	}

	public void setEname(String ename) {
		Ename = ename;
	}

	public int getSalary() {
		return Salary;
	}

	public void setSalary(int salary) {
		Salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public String getJoinDate() {
		return JoinDate;
	}

	public void setJoinDate(String joinDate) {
		JoinDate = joinDate;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return String.format("%s, %s, %s, %s, %s, %s, %s",
				Eno, Ename, Salary, department, gender, JoinDate, title);
	}

	public Object[] toArray() {
		return new Object[]{String.format("E%06d", Eno),Ename,String.format("%s", title.getTname()),Salary,gender?"남자":"여자",
				String.format("%s(%d층)", department.getDname(),department.getFloor()),JoinDate};
	}
	
	
}
