package kr.or.dgit.erp.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.erp.dao.DepartmentMapper;
import kr.or.dgit.erp.dao.DepartmentMapperImpl;
import kr.or.dgit.erp.dao.TitleMapper;
import kr.or.dgit.erp.dao.TitleMapperImpl;
import kr.or.dgit.erp.dto.Department;
import kr.or.dgit.erp.dto.Title;
import kr.or.dgit.erp.util.MybatisSqlSessionFactory;

public class DepartmentService {
	private static final DepartmentService instance = new DepartmentService();

	public DepartmentService() {}

	public static DepartmentService getInstance() {
		return instance;
	}
	
	public int insertDept(Department department){
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			DepartmentMapper departmentMapper = new DepartmentMapperImpl(sqlSession);
			int res = departmentMapper.insertDept(department);
			sqlSession.commit();
			return res;
		}
	}
	
	public int updateDept(Department department){
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			DepartmentMapper departmentMapper = new DepartmentMapperImpl(sqlSession);
			int res = departmentMapper.updateDept(department);
			sqlSession.commit();
			return res;
		}
	}
	
	public List<Department> selectDept(){
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			DepartmentMapper departmentMapper = new DepartmentMapperImpl(sqlSession);
			return departmentMapper.selectDept();
		}
	}
	
	public Department selectOneDept(Map<String, Object> param){
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			DepartmentMapper departmentMapper = new DepartmentMapperImpl(sqlSession);
			return departmentMapper.selectOneDept(param);
		}
	}
}
