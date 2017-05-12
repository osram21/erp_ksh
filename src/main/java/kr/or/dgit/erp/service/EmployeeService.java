package kr.or.dgit.erp.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.erp.dao.DepartmentMapper;
import kr.or.dgit.erp.dao.DepartmentMapperImpl;
import kr.or.dgit.erp.dao.EmployeeMapper;
import kr.or.dgit.erp.dao.EmployeeMapperImpl;
import kr.or.dgit.erp.dto.Department;
import kr.or.dgit.erp.dto.Employee;
import kr.or.dgit.erp.util.MybatisSqlSessionFactory;

public class EmployeeService {
	private static final EmployeeService instance = new EmployeeService();

	private EmployeeService() {}

	public static EmployeeService getInstance() {
		return instance;
	}
	
	public int insertEmp(Employee employee){
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			EmployeeMapper employeeMapper = new EmployeeMapperImpl(sqlSession);
			int res = employeeMapper.insertEmp(employee);
			sqlSession.commit();
			return res;
		}
	}
	
	public List<Employee> selectEmp(){
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			EmployeeMapper employeeMapper = new EmployeeMapperImpl(sqlSession);
			return employeeMapper.selectEmp();
		}
	}
}
