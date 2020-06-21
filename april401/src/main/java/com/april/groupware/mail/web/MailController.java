package com.april.groupware.mail.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.april.groupware.cmn.MessageVO;
import com.april.groupware.cmn.SearchVO;
import com.april.groupware.cmn.StringUtil;
import com.april.groupware.mail.service.MailService;
import com.april.groupware.mail.service.MailVO;
import com.google.gson.Gson;

@Controller
public class MailController {

	Logger  LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	MailService mailService;
	
	/**
	 * Method Name : doInsert 
	 * 작성일: 2020. 5. 14. 
	 * 작성자: MINJI 
	 * 설명: 메일 보내기 클릭 시 doInsert
	 * 
	 * @throws java.lang.Exception
	 */
	@RequestMapping(value = "mail/do_insert.do",method = RequestMethod.POST
			,produces = "application/json; charset=UTF-8")
	@ResponseBody 
	public String doInsert(MailVO mail) {
		LOG.debug("=====MailController [doInsert] Start=====");
		
		LOG.debug("** param : "+mail);
		
		int flag = this.mailService.doInsert(mail);
		
		MessageVO message=new MessageVO();
		
		if(flag>0) {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("메일 전송 성공.");
		}else {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("메일 전송 실패.");			
		}
		
		Gson gson=new Gson();
		String jsonStr = gson.toJson(message);
		LOG.debug("** jsonStr"+jsonStr);
		
		LOG.debug("=====MailController [doInsert] End=====");
		
		return jsonStr;
	}
	
	/**
	 * Method Name : doRetrieve 
	 * 작성일: 2020. 5. 16. 
	 * 수정일: 2020. 5. 22
	 * 작성자: MINJI 
	 * 설명: 메일 목록 조회 + 알림 목록 조회
	 * 
	 * @throws java.lang.Exception
	 */
	@RequestMapping(value = "mail/do_retrieve.do",method = RequestMethod.GET)
	public String doRetrieve(SearchVO search, Model model) {
		
		LOG.debug("=====MailController [doRetrieve] Start=====");
		//param 기본값 처리
		if(search.getPageNum()==0) {
			search.setPageNum(1);
		}
		
		if(search.getPageSize()==0) {
			search.setPageSize(10);
		}
		
		//검색구분
		search.setSearchDiv(StringUtil.nvl(search.getSearchDiv()));
		//검색어
		search.setSearchWord(StringUtil.nvl(search.getSearchWord().trim()));
		
		LOG.debug("** param : "+search);
		//검색조건 화면으로 전달.
		model.addAttribute("vo", search);
		
		//페이징한 list
		List<MailVO> list = (List<MailVO>) this.mailService.doRetrieve(search);
		
		//조회결과 화면 전달
		model.addAttribute("list", list);
		for(MailVO vo:list) {
			LOG.debug("** list : "+vo);
		}
		
		//총건수
		int totalCnt = 0;
		
		if(null !=list &&  list.size()>0) {
			totalCnt = list.get(0).getTotalCnt();
		}
		LOG.debug("** totalCnt : "+totalCnt);
		
		//조회결과 화면 전달
		model.addAttribute("totalCnt", totalCnt);
		
		LOG.debug("=====MailController [doRetrieve] End=====");
		
		return "views/email_inbox";// "/board/board_list.jsp
		
	}
	
	/**
	 * Method Name : doSelectOne 
	 * 작성일: 2020. 5. 18. 
	 * 작성자: MINJI 
	 * 설명: 메일 단건 조회
	 * 
	 * @throws java.lang.Exception
	 */
	@RequestMapping(value = "mail/do_selectOne.do",method = RequestMethod.GET)
	public String doSelectOne(HttpServletRequest req,MailVO mail,Model model) {
		
		LOG.debug("=====MailController [doSelectOne] Start=====");
		//param board_id
		LOG.debug("** param : "+mail);
		req.getParameter("mailIdInput");
		if( null == mail.getMailId() || "".equals(mail.getMailId())) {		

			throw new IllegalArgumentException("mail_ID를 확인 하세요.");			
		}
		
		MailVO  outVO =(MailVO) this.mailService.doSelectOne(mail);
		LOG.debug("** outVO : "+outVO);
		model.addAttribute("vo", outVO);
		
		LOG.debug("=====MailController [doSelectOne] End=====");
		
		return "views/email_read";
	}
	
	/**
	 * Method Name : doSelectOneSent 
	 * 작성일: 2020. 5. 21. 
	 * 작성자: MINJI 
	 * 설명: 보낸 메일 단건 조회
	 * 
	 * @throws java.lang.Exception
	 */
	@RequestMapping(value = "mail/do_selectOneSent.do",method = RequestMethod.GET)
	public String doSelectOneSent(MailVO mail,Model model) {
		
		LOG.debug("=====MailController [doSelectOneSent] Start=====");
		//param board_id
		LOG.debug("** param : "+mail);
		if( null == mail.getMailId() || "".equals(mail.getMailId())) {		

			throw new IllegalArgumentException("mail_ID를 확인 하세요.");			
		}
		
		MailVO  outVO =(MailVO) this.mailService.doSelectOneSent(mail);
		LOG.debug("** outVO : "+outVO);
		model.addAttribute("vo", outVO);
		
		LOG.debug("=====MailController [doSelectOneSent] End=====");
		
		return "views/email_readSent";
	}
	
	/**
	 * Method Name : doSelectOneResend 
	 * 작성일: 2020. 5. 19. 
	 * 작성자: MINJI 
	 * 설명: 메일 답장 단건 조회 
	 * 
	 * @throws java.lang.Exception
	 */
	@RequestMapping(value = "mail/do_selectOneResend.do",method = RequestMethod.GET)
	public String doSelectOneResend(MailVO mail,Model model) {
		
		LOG.debug("=====MailController [doSelectOne] Start=====");
		//param board_id
		LOG.debug("** param : "+mail);
		if( null == mail.getMailId() || "".equals(mail.getMailId())) {		

			throw new IllegalArgumentException("mail_ID를 확인 하세요.");			
		}
		
		MailVO  outVO =(MailVO) this.mailService.doSelectOne(mail);
		LOG.debug("** outVO : "+outVO);
		outVO.setTitle("[답장] "+outVO.getTitle());
		outVO.setContents("\n"+"-------------------------------[원본 내용] 발신자 : "+outVO.getSender() + " | 수신자 : " + outVO.getRecipient()
						+" | 수신일 : "+outVO.getRecDate()+" -------------------------------\n"+outVO.getContents()+"\n--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		LOG.debug("** outVO[답장] : "+outVO);
		model.addAttribute("vo", outVO);
		
		LOG.debug("=====MailController [doSelectOne] End=====");
		
		return "views/email_compose";
	}
	
	/**
	 * Method Name : doUpdateDisable 
	 * 작성일: 2020. 5. 19. 
	 * 작성자: MINJI 
	 * 설명: DisableYN -> Y 수정
	 * 
	 * @throws java.lang.Exception
	 */
	@RequestMapping(value = "mail/do_updateDisable.do",method = RequestMethod.POST
			,produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String doUpdateDisable(MailVO  mail) {
		
		LOG.debug("=====MailController [doUpdateDisable] Start=====");
		
		LOG.debug("** param : "+mail);
				
		if( null == mail.getMailId() || "".equals(mail.getMailId())) {		

			throw new IllegalArgumentException("mail_ID를 확인 하세요.");			
		}
		
		int flag = this.mailService.doUpdateDisable(mail);
		
		MessageVO message=new MessageVO();
		
		if(flag>0) {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("삭제를 성공하였습니다.");
		}else {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("삭제를 실패하였습니다.");			
		}
		
		Gson gson=new Gson();
		String jsonStr = gson.toJson(message);
		LOG.debug("** jsonStr="+jsonStr);
		
		LOG.debug("=====MailController [doUpdateDisable] End=====");
		
		return jsonStr;
	}
	
	/**
	 * Method Name : doUpdateRead 
	 * 작성일: 2020. 5. 20. 
	 * 작성자: MINJI 
	 * 설명: read 0 -> 9 수정
	 * 
	 * @throws java.lang.Exception
	 */
	@RequestMapping(value = "mail/do_updateRead.do",method = RequestMethod.POST
			,produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String doUpdateRead(MailVO  mail) {
		
		LOG.debug("=====MailController [doUpdateRead] Start=====");
		
		LOG.debug("** param : "+mail);
				
		if( null == mail.getMailId() || "".equals(mail.getMailId())) {		

			throw new IllegalArgumentException("mail_ID를 확인 하세요.");			
		}
		
		int flag = this.mailService.doUpdateRead(mail);
		
		MessageVO message=new MessageVO();
		
		if(flag>0) {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("읽음 처리 하였습니다.");
		}else {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("읽음 처리 실패하였습니다.");			
		}
		
		Gson gson=new Gson();
		String jsonStr = gson.toJson(message);
		LOG.debug("** jsonStr="+jsonStr);
		
		LOG.debug("=====MailController [doUpdateRead] End=====");
		
		return jsonStr;
	}
	
	/**
	 * Method Name : doRetrieveSent 
	 * 작성일: 2020. 5. 21. 
	 * 작성자: MINJI 
	 * 설명: 메일 목록 조회
	 * 
	 * @throws java.lang.Exception
	 */
	@RequestMapping(value = "mail/do_retrieveSent.do",method = RequestMethod.GET)
	public String doRetrieveSent(SearchVO search, Model model) {
		
		LOG.debug("=====MailController [doRetrieve] Start=====");
		//param 기본값 처리
		if(search.getPageNum()==0) {
			search.setPageNum(1);
		}
		
		if(search.getPageSize()==0) {
			search.setPageSize(10);
		}
		
		//검색구분
		search.setSearchDiv(StringUtil.nvl(search.getSearchDiv()));
		//검색어
		search.setSearchWord(StringUtil.nvl(search.getSearchWord().trim()));
		
		LOG.debug("** param : "+search);
		//검색조건 화면으로 전달.
		model.addAttribute("vo", search);
		
		List<MailVO> list = (List<MailVO>) this.mailService.doRetrieveSent(search);
		//조회결과 화면 전달
		model.addAttribute("list", list);
		for(MailVO vo:list) {
			LOG.debug("** list : "+vo);
		}
		
		//총건수
		int totalCnt = 0;
		if(null !=list &&  list.size()>0) {
			totalCnt = list.get(0).getTotalCnt();
		}
		LOG.debug("** totalCnt : "+totalCnt);
		
		//조회결과 화면 전달
		model.addAttribute("totalCnt", totalCnt);
		
		LOG.debug("=====MailController [doRetrieve] End=====");
		
		return "views/email_sentbox";// "/board/board_list.jsp
		
	}
	
	/**
	 * Method Name : doRetrieveTrash 
	 * 작성일: 2020. 5. 21. 
	 * 작성자: MINJI 
	 * 설명: 메일 목록 조회
	 * 
	 * @throws java.lang.Exception
	 */
	@RequestMapping(value = "mail/do_retrieveTrash.do",method = RequestMethod.GET)
	public String doRetrieveTrash(SearchVO search, Model model) {
		
		LOG.debug("=====MailController [doRetrieveTrash] Start=====");
		//param 기본값 처리
		if(search.getPageNum()==0) {
			search.setPageNum(1);
		}
		
		if(search.getPageSize()==0) {
			search.setPageSize(10);
		}
		
		//검색구분
		search.setSearchDiv(StringUtil.nvl(search.getSearchDiv()));
		//검색어
		search.setSearchWord(StringUtil.nvl(search.getSearchWord().trim()));
		
		LOG.debug("** param : "+search);
		//검색조건 화면으로 전달.
		model.addAttribute("vo", search);
		
		List<MailVO> list = (List<MailVO>) this.mailService.doRetrieveTrash(search);
		//조회결과 화면 전달
		model.addAttribute("list", list);
		for(MailVO vo:list) {
			LOG.debug("** list : "+vo);
		}
		
		//총건수
		int totalCnt = 0;
		if(null !=list &&  list.size()>0) {
			totalCnt = list.get(0).getTotalCnt();
		}
		LOG.debug("** totalCnt : "+totalCnt);
		
		//조회결과 화면 전달
		model.addAttribute("totalCnt", totalCnt);
		
		LOG.debug("=====MailController [doRetrieveTrash] End=====");
		
		return "views/email_trashbox";// "/board/board_list.jsp
		
	}
}














