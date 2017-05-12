package kr.or.dgit.erp.dao;

import java.util.List;
import java.util.Map;

import kr.or.dgit.erp.dto.Title;

public interface TitleMapper {
	int insertTitle(Title title);
	int updateTitle(Title title);
	
	List<Title> selectTitle();
	Title selectOne(Map<String, Object> param);
}
