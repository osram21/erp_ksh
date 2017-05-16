package kr.or.dgit.erp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.erp.dto.Employee;

public class EmployeeMapperImpl implements EmployeeMapper {
	protected String namespace = "kr.or.dgit.erp.dao.EmployeeMapper.";
	private static final Log log = LogFactory.getLog(EmployeeMapper.class);
	private SqlSession sqlSession;
	
	public EmployeeMapperImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int insertEmp(Employee employee) {
		log.debug("insertEmp");
		return sqlSession.insert(namespace+"insertEmp", employee);
	}

	@Override
	public List<Employee> selectEmp() {
		log.debug("selectEmp");
		return sqlSession.selectList(namespace+"selectEmp");
	}

	@Override
	public int updateEmp(Employee employee) {
		log.debug("updateEmp");
		return sqlSession.update(namespace+"updateEmp",employee);
	}

	@Override
	public int deleteEmp(Employee employee) {
		log.debug("deleteEmp");
		return sqlSession.delete(namespace+"deleteEmp",employee);
	}

	@Override
	public Employee selectEmpOne(Map<String, Object> param) {
		log.debug("selectEmpOne");
		return sqlSession.selectOne(namespace+"selectEmpOne",param);
	}

}
