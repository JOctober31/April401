package com.april.groupware.code.service.imple;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.april.groupware.cmn.DTO;
import com.april.groupware.code.service.CodeDao;
import com.april.groupware.code.service.CodeService;

@Service
public class CodeServiceImple implements CodeService {
	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CodeDao  dao;
	
	@Override
	public List<?> doRetrieve(DTO dto) {
		return dao.doRetrieve(dto);
	}

}
