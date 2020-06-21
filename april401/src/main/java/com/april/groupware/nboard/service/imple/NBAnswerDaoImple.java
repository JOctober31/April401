package com.april.groupware.nboard.service.imple;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.april.groupware.cmn.DTO;
import com.april.groupware.nboard.service.NBAnswerDao;
import com.april.groupware.nboard.service.NBAnswerVO;
import com.april.groupware.nboard.service.NBoardVO;


/**
 * @author 양은영
 *
 */
@Repository
public class NBAnswerDaoImple implements NBAnswerDao {

	//Logger
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	private final String NAMESPACE= "com.april.groupware.nbanswer";
	
	@Override
	public int doUpdateReadCnt(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int doInsert(DTO dto) {
		NBAnswerVO inVO = (NBAnswerVO) dto;
		
		LOG.debug("1= DaoImple doInsert=============================");
		LOG.debug("1=inVO="+inVO);
		LOG.debug("1==============================");
		
		// namespace+id = com.april.groupware.nbanswer.doInsert 
		String statement = NAMESPACE+".doInsert";
		LOG.debug("2= DaoImple doInsert=============================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2==============================");	
		
		int  flag = this.sqlSessionTemplate.insert(statement, inVO);
		LOG.debug("3= DapImple doInsert=============================");
		LOG.debug("3=flag="+flag);
		LOG.debug("3==============================");			
		
		return flag;
	}

	@Override
	public int doUpdate(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int doDelete(DTO dto) {
		NBAnswerVO inVO = (NBAnswerVO) dto;
		
		LOG.debug("1= DaoImple doDelete=============================");
		LOG.debug("1=inVO="+inVO);
		LOG.debug("1==============================");
		
		// namespace+id = com.april.groupware.nbanswer.doDelete 
		String statement = NAMESPACE+".doDelete";
		LOG.debug("2= DaoImple doDelete=============================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2==============================");	
		
		int  flag = this.sqlSessionTemplate.delete(statement, inVO);
		LOG.debug("3= DaoImple doDelete=============================");
		LOG.debug("3=flag="+flag);
		LOG.debug("3==============================");			
		
		return flag;
	}
	
	//전체 삭제
	public void doDeleteAll() {
		LOG.debug("1= DapImple doDeleteAll=============================");
		LOG.debug("1=");
		LOG.debug("1==============================");

		// namespace+id = com.april.groupware.nbanswer.doDeleteAll 
		//com.sist.ehr.board.doDeleteAll
		String statement = NAMESPACE+".doDeleteAll";
		LOG.debug("2= DapImple doDeleteAll=============================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2==============================");	

		int  flag = this.sqlSessionTemplate.delete(statement);
		LOG.debug("3= DapImple doDeleteAll=============================");
		LOG.debug("3=flag="+flag);
		LOG.debug("3==============================");	
	}

	@Override
	public List<?> doRetrieve(DTO dto) {
//		SearchVO inVO = (SearchVO) dto;
		NBAnswerVO inVO = (NBAnswerVO) dto;
		
		LOG.debug("1= DapImple doRetrieve=============================");
		LOG.debug("1=inVO="+inVO);
		LOG.debug("1==============================");
		
		// namespace+id = com.april.groupware.nbanswer.doRetrieve 
		String statement = NAMESPACE+".doRetrieve";
		LOG.debug("2= DapImple doRetrieve=============================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2==============================");	
		
		List<NBAnswerVO> outList = this.sqlSessionTemplate.selectList(statement, inVO);
		LOG.debug("3= DapImple doRetrieve=============================");
		LOG.debug("3=outList="+outList);
		LOG.debug("3==============================");			
		
		return outList;
	}
	
	@Override
	public DTO doSelectOne(DTO dto) {
		NBoardVO inVO = (NBoardVO) dto;
		
		LOG.debug("1= DapImple doSelectOne=============================");
		LOG.debug("1=inVO="+inVO);
		LOG.debug("1==============================");
		
		// namespace+id = com.april.groupware.nbanswer.doSelectOne 
		String statement = NAMESPACE+".doSelectOne";
		LOG.debug("2= DapImple doSelectOne=============================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2==============================");	
		
		NBoardVO outVO = this.sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("3= DapImple doSelectOne=============================");
		LOG.debug("3=outVO="+outVO);
		LOG.debug("3==============================");			
		
		return outVO;
	}

	@Override
	public List<?> getAll(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
