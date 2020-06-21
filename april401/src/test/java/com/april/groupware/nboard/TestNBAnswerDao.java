package com.april.groupware.nboard;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;

import com.april.groupware.cmn.SearchVO;
import com.april.groupware.nboard.service.NBAnswerVO;
import com.april.groupware.nboard.service.imple.NBAnswerDaoImple;


@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		                           "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
                                   })
public class TestNBAnswerDao {

	private final Logger  LOG = LoggerFactory.getLogger(TestNBAnswerDao.class);
	
	@Autowired
	WebApplicationContext  webApplicationContext;

	NBAnswerVO answer01;
	NBAnswerVO answer02;
	NBAnswerVO answer03;
	NBAnswerVO answer04;
	
	@Autowired
	NBAnswerDaoImple  dao;
	
	
	//목록조회
	@Test
	@Ignore
	public void doRetrieve() {
		SearchVO  searchVO = new SearchVO(10,1);
		List<NBAnswerVO> list = (List<NBAnswerVO>) dao.doRetrieve(searchVO);

		for(NBAnswerVO vo: list) {
			LOG.debug(vo.toString());
		}
	}
	
	//단건삭제
	@Test
	@Ignore
	public void doDelete() {
		
		answer01.setAwNo(52); //테스트시 값 셋팅 새로해야함
		dao.doDelete(answer01);
	
	}
	
	
	//등록
	@Test
	@Ignore
	public void doInsert() {
		
		//1. 삭제
		dao.doDeleteAll();
		
		//2. 입력
		int flag = dao.doInsert(answer01);
		flag += dao.doInsert(answer02);
		flag += dao.doInsert(answer03);
		
		LOG.debug("-------------------------");
		LOG.debug("-flag : " + flag);
		LOG.debug("-------------------------");
//		assertThat(flag, is(3));
		
//		//3. 조회
//		NBoardVO vsVO  = (NBoardVO) dao.doSelectOneTitle(nboard01);
//		LOG.debug("-------------------------");
//		LOG.debug("-vsVO : " + vsVO);
//		LOG.debug("-------------------------");

	}
	
	@Before
	public void setUp() throws Exception {
		LOG.debug("^^^^^^^^^^^");
		LOG.debug("^WebApplicationContext^"+webApplicationContext);
		LOG.debug("^^^^^^^^^^^");
		answer01=new NBAnswerVO(1,1041,"댓글 내용 Test01","등록자01","","20200501","");
		answer02=new NBAnswerVO(2,1041,"댓글 내용 Test02","등록자02","","20200501","");			
		answer03=new NBAnswerVO(3,1041,"댓글 내용 Test03","등록자03","","20200501","");			
		answer04=new NBAnswerVO(4,1041,"댓글 내용 Test04","등록자04","","20200501","");			

	}

	@After
	public void tearDown() throws Exception {
		LOG.debug("^^^^^^^^^^^");
		LOG.debug("^tearDown^");
		LOG.debug("^^^^^^^^^^^");		
	}

	
	

}
