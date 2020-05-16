package com.april.groupware.code.imple;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.april.groupware.cmn.DTO;
import com.april.groupware.code.service.CodeDao;
import com.april.groupware.code.service.CodeVO;

@Repository
public class CodeDaoImple implements CodeDao {
	Logger LOG = LoggerFactory.getLogger(CodeDaoImple.class);
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	private final String NAME_SPACE = "com.april.groupware.code";
	
	@Override
	public List<?> doRetrieve(DTO dto) {
		LOG.debug("=====================");
		LOG.debug("=doRetrieve=");
		LOG.debug("=====================");
		
		//Param
		CodeVO inVO = (CodeVO) dto;
		LOG.debug("=====================");
		LOG.debug("=inVO= : "+inVO);
		LOG.debug("=====================");
		
		//SQL-Query
		String statement = NAME_SPACE+".doRetrieve";
		LOG.debug("=====================");
		LOG.debug("=statement= : "+statement);
		LOG.debug("=====================");
		
		//Call - sqlSessionTemplate
		List<CodeVO> outList = this.sqlSessionTemplate.selectList(statement, inVO);
		LOG.debug("=====================");
		LOG.debug("=outList= : "+outList);
		LOG.debug("=====================");
		
		return outList;
	}

}
