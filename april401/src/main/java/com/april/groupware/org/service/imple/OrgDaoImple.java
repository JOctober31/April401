/**
 * <pre>
 * com.april.groupware.attendance.imple
 * Class Name : UserUpdateDaoImple.java
 * Description : 
 * Modification Information
 * 
 * 수정일         수정자        수정내용
 * ------------ ----------- -------------------------------
 * 2020-05-02           최초생성
 *
 * @author 쌍용교육센터 E반 April
 * @since 2020-05-02 
 * @version 1.0
 * 
 *  Copyright (C) by April All right reserved.
 * </pre>
 */
package com.april.groupware.org.service.imple;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.april.groupware.cmn.DTO;
import com.april.groupware.cmn.SearchVO;
import com.april.groupware.org.service.OrgDao;
import com.april.groupware.org.service.OrgVO;

/**
 * @author JUHEE 
 *
 */
@Repository
public class OrgDaoImple implements OrgDao {
	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	private final String NAMESPACE= "com.april.groupware.org";
	
	
	@Override
	public int doInsert(DTO dto) {
		OrgVO inVO = (OrgVO) dto;
		
		LOG.debug("1==============================");
		LOG.debug("1=inVO="+inVO);
		LOG.debug("1==============================");
		
		// namespace+id = com.sist.ehr.board.doInsert 
		String statement = NAMESPACE+".doInsert";
		LOG.debug("2==============================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2==============================");	
		
		int  flag = this.sqlSessionTemplate.insert(statement, inVO);
		LOG.debug("3==============================");
		LOG.debug("3=flag="+flag);
		LOG.debug("3==============================");			
		
		return flag;
	}

	
	public int doUpdateReadCnt(DTO dto) {
		OrgVO inVO = (OrgVO) dto;
		
		LOG.debug("1==============================");
		LOG.debug("1=inVO="+inVO);
		LOG.debug("1==============================");
		
		// namespace+id = com.sist.ehr.board.doInsert 
		String statement = NAMESPACE+".doUpdateReadCnt";
		LOG.debug("2==============================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2==============================");	
		
		int  flag = this.sqlSessionTemplate.update(statement, inVO);
		LOG.debug("3==============================");
		LOG.debug("3=flag="+flag);
		LOG.debug("3==============================");			
		
		return flag;
	}
	
	@Override
	public int doUpdate(DTO dto) {
		OrgVO inVO = (OrgVO) dto;
		
		LOG.debug("1==============================");
		LOG.debug("1=inVO="+inVO);
		LOG.debug("1==============================");
		
		// namespace+id = com.sist.ehr.board.doInsert 
		String statement = NAMESPACE+".doUpdate";
		LOG.debug("2==============================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2==============================");	
		
		int  flag = this.sqlSessionTemplate.update(statement, inVO);
		LOG.debug("3==============================");
		LOG.debug("3=flag="+flag);
		LOG.debug("3==============================");			
		
		return flag;
	}
	
	
	public DTO doSelectOneTitle(DTO dto) {
		OrgVO inVO = (OrgVO) dto;
		
		LOG.debug("1==============================");
		LOG.debug("1=inVO="+inVO);
		LOG.debug("1==============================");
		
		// namespace+id = com.sist.ehr.board.doInsert 
		String statement = NAMESPACE+".doSelectOneTitle";
		LOG.debug("2==============================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2==============================");	
		
		OrgVO outVO = this.sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("3==============================");
		LOG.debug("3=outVO="+outVO);
		LOG.debug("3==============================");			
		
		return outVO;
	}
	
	@Override
	public DTO doSelectOne(DTO dto) {
		OrgVO inVO = (OrgVO) dto;
		
		LOG.debug("1==============================");
		LOG.debug("1=inVO="+inVO);
		LOG.debug("1==============================");
		
		// namespace+id = com.sist.ehr.board.doInsert 
		String statement = NAMESPACE+".doSelectOne";
		LOG.debug("2==============================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2==============================");	
		
		OrgVO outVO = this.sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("3==============================");
		LOG.debug("3=outVO="+outVO);
		LOG.debug("3==============================");			
		
		return outVO;
	}

	public void doDeleteAll() {
		
		LOG.debug("1==============================");
		LOG.debug("1=");
		LOG.debug("1==============================");
		
		// namespace+id = com.sist.ehr.board.doInsert 
		//com.sist.ehr.board.doDeleteAll
		String statement = NAMESPACE+".doDeleteAll";
		LOG.debug("2==============================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2==============================");	
		
		int  flag = this.sqlSessionTemplate.delete(statement);
		LOG.debug("3==============================");
		LOG.debug("3=flag="+flag);
		LOG.debug("3==============================");	
	}
	
	
	@Override
	public int doDelete(DTO dto) {
		OrgVO inVO = (OrgVO) dto;
		
		LOG.debug("1==============================");
		LOG.debug("1=inVO="+inVO);
		LOG.debug("1==============================");
		
		// namespace+id = com.sist.ehr.board.doInsert 
		String statement = NAMESPACE+".doDelete";
		LOG.debug("2==============================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2==============================");	
		
		int  flag = this.sqlSessionTemplate.delete(statement, inVO);
		LOG.debug("3==============================");
		LOG.debug("3=flag="+flag);
		LOG.debug("3==============================");			
		
		return flag;
	}

	@Override
	public List<?> doRetrieve(DTO dto) {
		SearchVO inVO = (SearchVO) dto;
		
		LOG.debug("1==============================");
		LOG.debug("1=inVO="+inVO);
		LOG.debug("1==============================");
		
		// namespace+id = com.sist.ehr.board.doInsert 
		String statement = NAMESPACE+".doRetrieve";
		LOG.debug("2==============================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2==============================");	
		
		List<OrgVO> outList = this.sqlSessionTemplate.selectList(statement, inVO);
		LOG.debug("3==============================");
		LOG.debug("3=outList="+outList);
		LOG.debug("3==============================");			
		
		return outList;
	}

	@Override
	public List<?> getAll(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
