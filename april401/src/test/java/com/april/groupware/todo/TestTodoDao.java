package com.april.groupware.todo;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.april.groupware.todo.service.TodoVO;
import com.april.groupware.todo.service.imple.TodoDaoImpl;
import com.april.groupware.cmn.SearchVO;



@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		                           "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
                                   })
public class TestTodoDao {

	private final Logger  LOG = LoggerFactory.getLogger(TestTodoDao.class);
	
	@Autowired
	WebApplicationContext  webApplicationContext;

	TodoVO board01;
	TodoVO board02;
	TodoVO board03;
	
	TodoVO board04;	
	
	@Autowired
	TodoDaoImpl  dao;
	
	
	@Test
	@Ignore
	public void doRetrieve() {
		//1.전체 삭제
		//2.추가:3건
		//3.목록조회:3건
		
		dao.doDeleteAll();
		
		int flag = dao.doInsert(board01);
		flag += dao.doInsert(board02);
		flag += dao.doInsert(board03);
		assertThat(flag, is(3));
		
		SearchVO  searchVO=new SearchVO(10,1,"10","_124");
		List<TodoVO> list =   (List<TodoVO>) dao.doRetrieve(searchVO);
		
		assertThat(list.size(), is(3));
		for(TodoVO vo: list) {
			LOG.debug(vo.toString());
		}
				
	}
	
	@Test
	public void addAndGet() {
		//1.전체 삭제		
		//2.추가		
		//3.단건조회		
		//4.수정		
		//5.비교
		
		//1.전체 삭제		
		dao.doDeleteAll();
		
		//2.추가:3건		
		int flag = dao.doInsert(board01);
		flag += dao.doInsert(board02);
		flag += dao.doInsert(board03);
		
		assertThat(flag, is(3));
		//3.단건조회:board01		
		TodoVO vsVO = (TodoVO) dao.doSelectOneTitle(board01);
		//4.수정		
		vsVO.setDeptNm(vsVO.getDeptNm()+"_U");
		vsVO.setpTitle(vsVO.getpTitle()+"_U");
		vsVO.setpType(vsVO.getpType()+"_U");
		vsVO.setCustomer(vsVO.getCustomer()+"_U");
		vsVO.setTaskContents(vsVO.getTaskContents()+"_U");
		vsVO.setArea(vsVO.getArea()+"_U");
		vsVO.setWorkingForm(vsVO.getWorkingForm()+"_U");
		vsVO.setModId(vsVO.getModId()+"_U");
		//4.1 수정
		flag = dao.doUpdate(vsVO);
		assertThat(flag, is(1));
		//4.2.단건조회
		TodoVO orgVO = (TodoVO) dao.doSelectOne(vsVO);
	}
	
	
	
	@Test
	@Ignore
	public void doInsert() {
		//1. 삭제
		
//		dao.doDelete(board01);
//		dao.doDelete(board02);
//		dao.doDelete(board03);
		
//	dao.doDeleteAll();
		
		
		//2. 입력
		int flag = dao.doInsert(board01);
		flag += dao.doInsert(board02);
		flag += dao.doInsert(board03);
		LOG.debug("--------------");
		LOG.debug("flag:"+flag);
		LOG.debug("--------------");
		
		assertThat(flag, is(3));
		
	}
	
	@Before
	public void setUp() throws Exception {
		LOG.debug("^^^^^^^^^^^");
		LOG.debug("^WebApplicationContext^"+webApplicationContext);
		LOG.debug("^^^^^^^^^^^");
		board01=new TodoVO("1234_124","운영","PM작업","MAIN","무림","잘하고 있습니다","서울","외근","1234_124","1234_124","","");
		board02=new TodoVO("5678_124","개발","PM작업","MAIN","무림","잘하고 있습니다","서울","외근","5678_124","5678_124","","");
		board03=new TodoVO("9876_124","회계","PM작업","MAIN","무림","잘하고 있습니다","서울","외근","9876_124","9876_124","","");
		
		board04=new TodoVO("1234_124","운영","PM작업","MAIN","무림","잘하고 있습니다","서울","외근","1234_124","1234_124","","");
		
	}

	@After
	public void tearDown() throws Exception {
		LOG.debug("^^^^^^^^^^^");
		LOG.debug("^tearDown^");
		LOG.debug("^^^^^^^^^^^");		
	}
			
	
	@Test
	@Ignore
	public void test() {
		LOG.debug("=====================");
		LOG.debug("=test()=");
		LOG.debug("=====================");
		
		
		LOG.debug("=====================");
		LOG.debug("=dao()="+dao);
		LOG.debug("=====================");		
		
		assertNotNull(dao);
		assertThat(1, is(1));
		
	}
	

}
