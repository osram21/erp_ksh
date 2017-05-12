package kr.or.dgit.erp.dao;

import java.util.List;

import kr.or.dgit.erp.dto.Employee;

public interface EmployeeMapper {
	int insertEmp(Employee employee);
	List<Employee> selectEmp();
}
