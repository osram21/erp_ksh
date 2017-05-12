package kr.or.dgit.erp.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.erp.dto.Department;

public interface DepartmentMapper {
	int insertDept(Department department);
	int updateDept(Department department);
	
	List<Department> selectDept();
	Department selectOneDept(Map<String, Object> param);
}
