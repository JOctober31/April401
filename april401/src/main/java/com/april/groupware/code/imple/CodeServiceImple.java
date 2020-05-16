package com.april.groupware.code.imple;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.april.groupware.cmn.DTO;
import com.april.groupware.code.service.CodeDao;
import com.april.groupware.code.service.CodeService;

@Repository
public class CodeServiceImple implements CodeService {
	Logger LOG = LoggerFactory.getLogger(CodeServiceImple.class);
	
	@Autowired
	CodeDao dao;
	
	@Override
	public List<?> doRetrieve(DTO dto) {
		return dao.doRetrieve(dto);
	}

}
