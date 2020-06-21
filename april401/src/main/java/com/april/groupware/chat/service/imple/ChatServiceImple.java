package com.april.groupware.chat.service.imple;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.april.groupware.chat.service.ChatDao;
import com.april.groupware.chat.service.ChatService;
import com.april.groupware.chat.service.ChatVO;
import com.april.groupware.cmn.DTO;

@Service
public class ChatServiceImple implements ChatService {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
		 
	@Autowired
	private ChatDao dao;
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
		
	public ChatServiceImple() {}


	@Override
	public DTO doSelectOne(DTO dto) {
		ChatVO outVO = (ChatVO) dao.doSelectOne(dto);
		return outVO;
	}


	@Override
	public List<?> doRetrieve(DTO dto) {
		return dao.doRetrieve(dto);
	}


	@Override
	public int doInsert(DTO dto) {
		return dao.doInsert(dto);
	}

	
	
	
	
	public DTO doSelectOne(ChatVO user) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<?> doRetrieve(ChatVO user) {
		// TODO Auto-generated method stub
		return null;
	}


	public int doInsert(ChatVO user) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	}

