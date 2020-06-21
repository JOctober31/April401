/**
 * <pre>
 * com.april.groupware
 * Class Name : TestUserUpdateDao.java
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
package com.april.groupware.mail;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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

import com.april.groupware.mail.service.MailService;
import com.april.groupware.mail.service.MailVO;

/**
 * @author MINJI
 *
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
public class TestMailService {
	private final Logger LOG = LoggerFactory.getLogger(TestMailService.class);

	@Autowired
	WebApplicationContext webApplicationContext;

	@Autowired
	MailService mailService;

	// 참조 없는 거
	MailVO mail01;
	MailVO mail02;

	// 참조 있는 거
	MailVO mail03;
	MailVO mail04;

	/**
	 * Method Name:setUp 
	 * 작성일: 2020. 5. 8. 
	 * 작성자: MINJI 설명:
	 * 
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		LOG.debug("======================");
		LOG.debug("WebApplicationContext : " + webApplicationContext);
		LOG.debug("======================");

//		String mailId, String category, String sender, String senderId, String senDate, String title,
//		String fileId, String contents, String receiver, String receiverId, String recDate, String disableYn,
//		String read

		// 참조 없는 메일
		mail01 = new MailVO("", "mail", "김민지", "kimmj", "", "제목01", "", "내용01", "홍길동01", "", "", "N", "0","");
		mail02 = new MailVO("", "mail", "김민지", "kimmj", "", "제목02", "", "내용02", "홍길동02", "", "", "N", "0","");
		// 참조 있는 메일
		mail03 = new MailVO("", "mail", "김민지", "kimmj", "", "제목03", "", "내용03", "홍길동01,홍길동02", "", "", "N", "0","");
		mail04 = new MailVO("", "mail", "김민지", "kimmj", "", "제목04", "", "내용04", "홍길동01,홍길동02,홍길동03", "", "", "N", "0","");

	}

	/**
	 * Method Name:tearDown 
	 * 작성일: 2020. 5. 8. 
	 * 작성자: MINJI 
	 * 설명:
	 * 
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Method Name : doInsert 
	 * 작성일: 2020. 5. 14. 
	 * 작성자: MINJI 
	 * 설명: 메일 보내기 클릭 시 doInsert
	 * 
	 * @throws java.lang.Exception
	 */
	@Test
	@Ignore
	public void doInsert() {
		// -----------------------------------
		// 1. 모두삭제 (이건 나중에 doDelete 만들고 나서)
		// 2. 등록
		// 3. 값 확인
		// -----------------------------------

		// 2. 등록
		int flag = this.mailService.doInsert(mail01);
		flag += this.mailService.doInsert(mail02);
		flag += this.mailService.doInsert(mail03);
		flag += this.mailService.doInsert(mail04);

		// 3. 값 확인
		assertThat(flag, is(7));
	}

	/**
	 * Method Name : doRetrieve 
	 * 작성일: 2020. 5. 16. 
	 * 작성자: MINJI 
	 * 설명: 메일 목록 조회
	 * 
	 * @throws java.lang.Exception
	 */
	@Test
	@Ignore
	public void doRetrieve() {
		// 검색
		//String searchDiv, String searchWord, int pageSize, int pageNum
		//SearchVO inVO = new SearchVO("", "honggd02", 10, 1);
//		List<MailVO> list = (List<MailVO>) mailService.doRetrieve(inVO);
//
//		for (MailVO outVO : list) {
//			LOG.debug(outVO.toString());
//		}
//
//		assertThat(list.size(), is(3));
	}
	
	/**
	 * Method Name : doSelectOne 
	 * 작성일: 2020. 5. 18. 
	 * 작성자: MINJI 
	 * 설명: 메일 단건 조회
	 * 
	 * @throws java.lang.Exception
	 */
	@Test
	@Ignore
	public void doSelectOne() {
		MailVO inVO = new MailVO("M20200515_39", "", "", "", "", "", "", "", "", "", "", "", "","");
		MailVO outVO = (MailVO) mailService.doSelectOne(inVO);
		LOG.debug("=doSelectOne=");
		LOG.debug("=outVO="+outVO);
		LOG.debug("=doSelectOne=");
	}
	
	/**
	 * Method Name : doSelectOne 
	 * 작성일: 2020. 5. 19. 
	 * 작성자: MINJI 
	 * 설명: disableYN Update
	 * 
	 * @throws java.lang.Exception
	 */
	@Test
	//@Ignore
	public void doUpdateDisable() {
		MailVO inVO = new MailVO("M20200515_40", "", "", "", "", "", "", "", "", "", "", "", "","");
		int flag = mailService.doUpdateDisable(inVO);
		assertThat(flag, is(1));
	}

}
