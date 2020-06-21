package com.april.groupware.todo.service.imple;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.april.groupware.cmn.DTO;
import com.april.groupware.todo.service.TodoDao;
import com.april.groupware.todo.service.TodoService;

@Service
public class TodoServiceImple implements TodoService {
    private final Logger  LOG = LoggerFactory.getLogger(this.getClass());
    
	@Autowired
	TodoDao  dao;
	
	@Override
	public int doInsert(DTO dto) {
		
		return dao.doInsert(dto);
	}

	@Override
	public int doUpdate(DTO dto) {
		return dao.doUpdate(dto);
	}


	@Override
	public int doDelete(DTO dto) {
		return dao.doDelete(dto);
	}

	@Override
	public List<?> doRetrieve(DTO dto) {
		return dao.doRetrieve(dto);
	}

	@Override
	public List<?> getAll(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DTO doSelectOne(DTO dto) {
		return dao.doSelectOne(dto);
	}

}
