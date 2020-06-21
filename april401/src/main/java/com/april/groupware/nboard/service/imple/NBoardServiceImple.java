package com.april.groupware.nboard.service.imple;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.april.groupware.cmn.DTO;
import com.april.groupware.nboard.service.NBoardDao;
import com.april.groupware.nboard.service.NBoardService;
import com.april.groupware.nboard.service.NBoardVO;

@Service
public class NBoardServiceImple implements NBoardService {
    private final Logger  LOG = LoggerFactory.getLogger(this.getClass());
    
	@Autowired
	NBoardDao  dao;
	
	@Override
	public int doInsert(DTO dto) {
		
		return dao.doInsert(dto);
	}

	@Override
	public int doUpdate(DTO dto) {
		return dao.doUpdate(dto);
	}

	@Override
	public DTO doSelectOne(DTO dto) {
		//조회 countUpdate:cookie에 
		dao.doUpdateReadCnt(dto);
		
		NBoardVO outVO = (NBoardVO) dao.doSelectOne(dto);
		

		return outVO;
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

}
