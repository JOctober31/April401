package com.april.groupware.dash.service.imple;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.april.groupware.cmn.DTO;
import com.april.groupware.dash.service.DashDeptVO;
import com.april.groupware.dash.service.DashTodoDao;
import com.april.groupware.dash.service.DashTodoService;
import com.april.groupware.dash.service.DashTodoVO;

@Service
public class DashTodoServiceImple implements DashTodoService {
    private final Logger  LOG = LoggerFactory.getLogger(this.getClass());
    
	@Autowired
	DashTodoDao  dao;
	
	@Override
	public DTO doSelectOne(DTO dto) {
		
		DashTodoVO outVO = (DashTodoVO) dao.doSelectOne(dto);
		return outVO;
	}

	@Override
	public DTO doDeptSelectOne(DTO dto) {
		DashDeptVO outVO = (DashDeptVO) dao.doDeptSelectOne(dto);
		return outVO;
	}

	@Override
	public List<?> doRetrieve(DTO dto) {
		return dao.doRetrieve(dto);
	}
	

}
