package kr.or.dgit.erp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.erp.dto.Department;

public class DepartmentMapperImpl implements DepartmentMapper {
	protected String namespace = "kr.or.dgit.erp.dao.DepartmentMapper.";
	private static final Log log = LogFactory.getLog(DepartmentMapper.class);
	private SqlSession sqlSession;
	
	public DepartmentMapperImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	@Override
	public int insertDept(Department department) {
		log.debug("insertDept");
		return sqlSession.insert(namespace+"insertDept", department);
	}

	@Override
	public int updateDept(Department department) {
		log.debug("updateDept");
		return sqlSession.update(namespace+"updateDept",department);
	}

	@Override
	public List<Department> selectDept() {
		log.debug("selectDept");
		return sqlSession.selectList(namespace+"selectDept");
	}

	@Override
	public Department selectOneDept(Map<String, Object> param) {
		log.debug("selectOneDept");
		return sqlSession.selectOne(namespace+"selectOneDept",param);
	}
	
	@Override
	public int deleteDept(Department department) {
		log.debug("deleteDept");
		return sqlSession.delete(namespace+"deleteDept",department);
	}
	
	@Override
	public Department selectDeptbyName(Department department) {
		log.debug("selectDeptbyName");
		return sqlSession.selectOne(namespace+"selectDeptbyName",department);
	}

}
