package com.april.groupware.chat.service.imple;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.april.groupware.chat.service.UserDao;
import com.april.groupware.chat.service.UserService;
import com.april.groupware.chat.service.UserVO;
import com.april.groupware.cmn.DTO;

@Service
public class UserServiceImple implements UserService {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
		
	@Autowired
	private UserDao userdao;
	
	 
	
	//JDBCTemplate
	@Autowired
	private JdbcTemplate jdbcTemplate;
		
	public UserServiceImple() {}

	
	public DTO doSelectOne(UserVO user) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<?> doRetrieve(UserVO user) {
		// TODO Auto-generated method stub
		return null;
	}


	public int doInsert(UserVO user) {
		// TODO Auto-generated method stub
		return 0;
	}


	
	
	
	@Override
	public DTO doSelectOne(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<?> doRetrieve(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int doInsert(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}


	
	}

