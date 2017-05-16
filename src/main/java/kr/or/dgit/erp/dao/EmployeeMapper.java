package kr.or.dgit.erp.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.erp.dto.Employee;

public interface EmployeeMapper {
	int insertEmp(Employee employee);
	int updateEmp(Employee employee);
	int deleteEmp(Employee employee);
	List<Employee> selectEmp();
	Employee selectEmpOne(Map<String, Object>param);
}
