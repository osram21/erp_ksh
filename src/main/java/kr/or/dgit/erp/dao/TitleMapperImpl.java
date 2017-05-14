package kr.or.dgit.erp.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.erp.dto.Title;

public class TitleMapperImpl implements TitleMapper {
	protected String namespace = "kr.or.dgit.erp.dao.TitleMapper.";
	private static final Log log = LogFactory.getLog(TitleMapper.class);
	private SqlSession sqlSession;
	
	public TitleMapperImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int insertTitle(Title title) {
		log.debug("insertTitle");
		return sqlSession.insert(namespace+"insertTitle", title);
	}

	@Override
	public int updateTitle(Title title) {
		log.debug("updateTitle");
		return sqlSession.update(namespace+"updateTitle",title);
	}

	@Override
	public List<Title> selectTitle() {
		log.debug("selectTitle");
		return sqlSession.selectList(namespace+"selectTitle");
	}

	@Override
	public Title selectByOne(Map<String,Object>param) {
		log.debug("selectByOne");
		return sqlSession.selectOne(namespace+"selectByOne",param);
	}

	@Override
	public int deleteTitle(Title title) {
		log.debug("deleteTitle");		
		return sqlSession.delete(namespace+"deleteTitle",title);
	}

	@Override
	public Title selectTitlebyName(Title title) {
		log.debug("selectTitlebyName");
		return sqlSession.selectOne(namespace+"selectTitlebyName",title);
	}

}
