package com.april.groupware.org.service.imple;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.april.groupware.cmn.DTO;
import com.april.groupware.org.service.OrgDao;
import com.april.groupware.org.service.OrgService;
import com.april.groupware.org.service.OrgVO;


@Service
public class OrgServiceImple implements OrgService {
    private final Logger  LOG = LoggerFactory.getLogger(this.getClass());
    
	@Autowired
	OrgDao  dao;
	
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
		// dao.doUpdateReadCnt(dto);
		
		OrgVO outVO = (OrgVO) dao.doSelectOne(dto);
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
