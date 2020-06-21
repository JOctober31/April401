/**
 * 
 */
package com.april.groupware.todo.service.imple;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.april.groupware.cmn.DTO;
import com.april.groupware.cmn.SearchVO;
import com.april.groupware.todo.service.TodoDao;
import com.april.groupware.todo.service.TodoVO;

/**
 * @author sist
 *
 */
@Repository
public class TodoDaoImpl implements TodoDao {
	Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	private final  String NAMESPACE= "com.april.groupware.todo.service";
	
	@Override
	public int doInsert(DTO dto) {
		TodoVO inVO =(TodoVO) dto;
		
		LOG.debug("1===========================");
		LOG.debug("1=inVO="+inVO);
		LOG.debug("1===========================");
		
		//namespace+id = com.sist.ehr.board.doInsert
		String statement = NAMESPACE+".doInsert";
		LOG.debug("2===========================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2===========================");
		
		int flag = this.sqlSessionTemplate.insert(statement, inVO);
		LOG.debug("3===========================");
		LOG.debug("3=flag="+flag);
		LOG.debug("3===========================");
		
		return flag;
	}

	@Override
	public int doUpdate(DTO dto) {
	TodoVO inVO = (TodoVO) dto;
		
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


	public void doDeleteAll() {
		
		LOG.debug("1===========================");
		LOG.debug("1=inVO=");
		LOG.debug("1===========================");
		
		//namespace+id = com.sist.ehr.board.doDelete
		String statement = NAMESPACE+".doDeleteAll";
		LOG.debug("2===========================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2===========================");
		
		int flag = this.sqlSessionTemplate.delete(statement);
		LOG.debug("3===========================");
		LOG.debug("3=flag="+flag);
		LOG.debug("3===========================");
		
	}
	
	@Override
	public int doDelete(DTO dto) {
	TodoVO inVO =(TodoVO) dto;
		
		LOG.debug("1===========================");
		LOG.debug("1=inVO="+inVO);
		LOG.debug("1===========================");
		
		//namespace+id = com.sist.ehr.board.doDelete
		String statement = NAMESPACE+".doDelete";
		LOG.debug("2===========================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2===========================");
		
		int flag = this.sqlSessionTemplate.delete(statement, inVO);
		LOG.debug("3===========================");
		LOG.debug("3=flag="+flag);
		LOG.debug("3===========================");
		
		return flag;
	}

	public DTO doSelectOneTitle(DTO dto) {
		TodoVO inVO = (TodoVO) dto;
		
		LOG.debug("1==============================");
		LOG.debug("1=inVO="+inVO);
		LOG.debug("1==============================");
		
		// namespace+id = com.sist.ehr.board.doInsert 
		String statement = NAMESPACE+".doSelectOneTitle";
		LOG.debug("2==============================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2==============================");	
		
		TodoVO outVO = this.sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("3==============================");
		LOG.debug("3=outVO="+outVO);
		LOG.debug("3==============================");			
		
		return outVO;
	}
	
	@Override
	public DTO doSelectOne(DTO dto) {
		TodoVO inVO = (TodoVO) dto;
		
		LOG.debug("1==============================");
		LOG.debug("1=inVO="+inVO);
		LOG.debug("1==============================");
		
		// namespace+id = com.sist.ehr.board.doInsert 
		String statement = NAMESPACE+".doSelectOne";
		LOG.debug("2==============================");
		LOG.debug("2=statement="+statement);
		LOG.debug("2==============================");	
		
		TodoVO outVO = this.sqlSessionTemplate.selectOne(statement, inVO);
		LOG.debug("3==============================");
		LOG.debug("3=outVO="+outVO);
		LOG.debug("3==============================");			
		
		return outVO;
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
		
		List<TodoVO> outList = this.sqlSessionTemplate.selectList(statement, inVO);
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
