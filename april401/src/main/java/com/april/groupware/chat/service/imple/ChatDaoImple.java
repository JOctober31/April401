package com.april.groupware.chat.service.imple;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.april.groupware.chat.service.ChatDao;
import com.april.groupware.chat.service.ChatVO;
import com.april.groupware.cmn.DTO;
import com.april.groupware.cmn.SearchVO;

@Repository
public class ChatDaoImple implements ChatDao {
 
	//Logger
	Logger LOG = LoggerFactory.getLogger(this.getClass());
		
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	private final String NAMESPACE = "com.april.groupware.chat";
	
	public DTO doSelectOne(DTO dto) {
		ChatVO inVO = (ChatVO) dto;
		
		LOG.debug("1=======================");
		LOG.debug("1=inVO : "+inVO);
		LOG.debug("1=======================");
		
		String statement = NAMESPACE+".doSelectOne";
		LOG.debug("2=======================");
		LOG.debug("2=statement : "+statement);
		LOG.debug("2=======================");
		
		ChatVO outVO = this.sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("3=======================");
		LOG.debug("3=outVO : "+outVO);
		LOG.debug("3=======================");
		
		
		return outVO;
	}


	@Override
	public List<?> doRetrieve(DTO dto) {
		SearchVO inVO = (SearchVO) dto;
		
		LOG.debug("1=======================");
		LOG.debug("1=inVO : "+inVO);
		LOG.debug("1=======================");
		
		String statement = NAMESPACE+".doRetrieve";
		LOG.debug("2=======================");
		LOG.debug("2=statement : "+statement);
		LOG.debug("2=======================");	
		
		List<ChatVO> outList = this.sqlSessionTemplate.selectList(statement, inVO);
		LOG.debug("3=======================");
		LOG.debug("3=outList : "+outList);
		LOG.debug("3=======================");			
		
		return outList;
	}


	@Override
	public List<?> getAll(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int doInsert(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	}

