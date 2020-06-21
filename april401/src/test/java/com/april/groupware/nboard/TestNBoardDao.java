package com.april.groupware.nboard;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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
import com.april.groupware.nboard.service.NBoardVO;
import com.april.groupware.nboard.service.imple.NBoardDaoImple;


@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		                           "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
                                   })
public class TestNBoardDao {

	private final Logger  LOG = LoggerFactory.getLogger(TestNBoardDao.class);
	
	@Autowired
	WebApplicationContext  webApplicationContext;

	NBoardVO nboard01;
	NBoardVO nboard02;
	NBoardVO nboard03;
	NBoardVO nboard04;
	
	@Autowired
	NBoardDaoImple  dao;
	
	//전체삭제, 등록, 단건조회, 수정
	@Test
//	@Ignore
	public void addAndGet() {
		//1.전체 삭제		
		//2.추가		
		//3.단건조회		
		//4.수정		
		//5.비교
		
		//1.전체 삭제		
		dao.doDeleteAll();
		
		//2.추가:3건		
		int flag = dao.doInsert(nboard01);
		flag += dao.doInsert(nboard02);
		flag += dao.doInsert(nboard03);
		
		assertThat(flag, is(3));
		//3.단건조회:board01		
		NBoardVO vsVO = (NBoardVO) dao.doSelectOneTitle(nboard01);
		//4.수정		
		vsVO.setNbCategory("new");
		vsVO.setNbTitle(vsVO.getNbTitle()+"_U");
		vsVO.setNbContents(vsVO.getNbContents()+"_U");
		vsVO.setRegId("update_user");
		//4.1 수정
		flag = dao.doUpdate(vsVO);
		assertThat(flag, is(1));
		//4.2.단건조회
		NBoardVO orgVO = (NBoardVO) dao.doSelectOne(vsVO);
		
	}
	
	
	//목록조회
	@Test
	@Ignore
	public void doRetrieve() {
		//삭제
		dao.doDeleteAll();
		
		//등록
		int flag = dao.doInsert(nboard01);
		flag += dao.doInsert(nboard02);
		flag += dao.doInsert(nboard03);
		SearchVO  searchVO = new SearchVO(10,1,"10","게시");
		List<NBoardVO> list = (List<NBoardVO>) dao.doRetrieve(searchVO);
		
		for(NBoardVO vo: list) {
			LOG.debug(vo.toString());
		}
	}
	
	
	//단건삭제
	@Test
	@Ignore
	public void doDelete() {
		//1.전체 삭제		
		dao.doDeleteAll();

		//2.추가:3건		
		int flag = dao.doInsert(nboard01);
		flag += dao.doInsert(nboard02);
		flag += dao.doInsert(nboard03);
		assertThat(flag, is(3));
		
		NBoardVO vsVO = (NBoardVO) dao.doSelectOneTitle(nboard01);
//		
//		//3. 단건 삭제
		dao.doDelete(vsVO);
	}
	
	
	//등록
	@Test
	@Ignore
	public void doInsert() {
		
		//1. 삭제
		dao.doDeleteAll();
		
		//2. 입력
		int flag = dao.doInsert(nboard01);
		flag += dao.doInsert(nboard02);
		flag += dao.doInsert(nboard03);
		
		LOG.debug("-------------------------");
		LOG.debug("-flag : " + flag);
		LOG.debug("-------------------------");
		assertThat(flag, is(3));
		
		//3. 조회
		NBoardVO vsVO  = (NBoardVO) dao.doSelectOneTitle(nboard01);
		LOG.debug("-------------------------");
		LOG.debug("-vsVO : " + vsVO);
		LOG.debug("-------------------------");

	}
	
	@Before
	public void setUp() throws Exception {
		LOG.debug("^^^^^^^^^^^");
		LOG.debug("^WebApplicationContext^"+webApplicationContext);
		LOG.debug("^^^^^^^^^^^");
		nboard01=new NBoardVO(1,"게시글말머리01","게시글제목01","J01_내요오오오옹","","","",0,"작성자01","","20200510","");
		nboard02=new NBoardVO(2,"게시글말머리02","게시글제목02","J02_내요오오오옹","","","",0,"작성자02","","20200510","");
		nboard03=new NBoardVO(3,"게시글말머리03","게시글제목03","J03_내요오오오옹","","","",0,"작성자03","","20200510","");
	
		nboard04=new NBoardVO(4,"게시글말머리04","게시글제목04","J04_내요오오오옹","","","",0,"작성자04","","20200510","");

	}

	@After
	public void tearDown() throws Exception {
		LOG.debug("^^^^^^^^^^^");
		LOG.debug("^tearDown^");
		LOG.debug("^^^^^^^^^^^");		
	}

	
	

}
