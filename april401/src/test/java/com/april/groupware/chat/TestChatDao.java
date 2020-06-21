package com.april.groupware.chat;

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

import com.april.groupware.chat.service.ChatDao;
import com.april.groupware.chat.service.ChatVO;
import com.april.groupware.cmn.SearchVO;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
									"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
public class TestChatDao {
	private final Logger LOG = LoggerFactory.getLogger(TestChatDao.class);

	@Autowired
	WebApplicationContext webApplicationContext;

	@Autowired
	ChatDao dao;

	ChatVO user01;
	ChatVO user02;
	ChatVO user03;

	@Before
	public void setUp() throws Exception {
		LOG.debug("^^^^^^^^^^^^^^^^");
		LOG.debug("^WebApplicationContext^" + webApplicationContext);
		LOG.debug("^^^^^^^^^^^^^^^^");

		user01 = new ChatVO("id01", "영업", "김사원", "사원");
		user02 = new ChatVO("id02", "개발", "김대리", "대리");
		user03 = new ChatVO("id03", "개발", "김과장", "과장");
	}

//---------------------------------------------------	
//	@Ignore
	@Test
	public void doRetrieve() {
		// Str searchDiv, Str searchWord, int pageSize, int pageNum, Str searchStartDate, Str searchEndDate
		SearchVO inVO = new SearchVO("20", "", 10, 1, "", "");
		List<ChatVO> list = (List<ChatVO>) dao.doRetrieve(inVO);

		for (ChatVO outVO : list) {
			LOG.debug(outVO.toString());
		}

		// assertThat(list.size(), is(1));

	}
//---------------------------------------------------	
//---------------------------------------------------
	@Ignore
	@Test
	public void doSelectOne() {

		ChatVO userVO = (ChatVO) dao.doSelectOne(user02);
		
	}
//---------------------------------------------------	
//---------------------------------------------------
	@Ignore
	@Test
	public void doInsert() {
		// ------------------------------
		// 1. 기존 데이터 삭제
		// 2. 입력
		// 3. count로 건수 확인
		// ------------------------------

		int flag = dao.doInsert(user03);
		assertThat(flag, is(1));

	}
//---------------------------------------------------
//---------------------------------------------------
	@After
	public void tearDown() throws Exception {

	}
//---------------------------------------------------
}
