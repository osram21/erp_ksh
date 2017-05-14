package kr.or.dgit.erp.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Employee {
	private int Eno;
	private String Ename;
	private int Salary;
	private Department department;
	private Boolean gender;
	private Date JoinDate;
	private Title title;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public Employee() {}

	public Employee(int eno) {
		Eno = eno;
	}

	public Employee(int eno, String ename, int salary, Department department, Boolean gender, Date joinDate,
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

	public Date getJoinDate() {
		return JoinDate;
	}

	public void setJoinDate(Date joinDate) {
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
				String.format("%s(%d층)", department.getDname(),department.getFloor()),sdf.format(JoinDate)};
	
	}
	
	
}
