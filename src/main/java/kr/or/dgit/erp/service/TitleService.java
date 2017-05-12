package kr.or.dgit.erp.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.erp.dao.TitleMapper;
import kr.or.dgit.erp.dao.TitleMapperImpl;
import kr.or.dgit.erp.dto.Title;
import kr.or.dgit.erp.util.MybatisSqlSessionFactory;

public class TitleService {
	private static final TitleService instance = new TitleService();

	public TitleService() {}

	public static TitleService getInstance() {
		return instance;
	}
	
	public int insertTitle(Title title){
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			TitleMapper titleMapper = new TitleMapperImpl(sqlSession);
			int res = titleMapper.insertTitle(title);
			sqlSession.commit();
			return res;
		}
	}
	
	public int updateTitle(Title title){
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			TitleMapper titleMapper = new TitleMapperImpl(sqlSession);
			int res = titleMapper.updateTitle(title);
			sqlSession.commit();
			return res;
		}
	}
	
	public List<Title> selectTitle(){
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			TitleMapper titleMapper = new TitleMapperImpl(sqlSession);
			return titleMapper.selectTitle();
		}
	}
	
	public Title selectOne(Map<String, Object> param){
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			TitleMapper titleMapper = new TitleMapperImpl(sqlSession);
			return titleMapper.selectOne(param);
		}
	}
}
