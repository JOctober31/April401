package com.april.groupware.org.web;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.april.groupware.cmn.MessageVO;
import com.april.groupware.cmn.SearchVO;
import com.april.groupware.cmn.StringUtil;
import com.april.groupware.code.service.CodeService;
import com.april.groupware.code.service.CodeVO;
import com.april.groupware.org.service.OrgService;
import com.april.groupware.org.service.OrgVO;
import com.google.gson.Gson;


@Controller
public class OrgController {
Logger  LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	OrgService orgService;
	
	@Autowired
	CodeService codeService;
	
	@Autowired
	MessageSource messageSource;
	
	//목록조회
	@RequestMapping(value = "admin/do_retrieve.do",method = RequestMethod.GET)
	public String doRetrieve(SearchVO  search,Model model) {
		//param 기본값 처리
		if(search.getPageNum()==0) {
			search.setPageNum(1);
		}
		
		if(search.getPageSize()==0) {
			search.setPageSize(10);
		}
		
		
		search.setSearchDiv(StringUtil.nvl(search.getSearchDiv()));
		search.setSearchWord(StringUtil.nvl(search.getSearchWord().trim()));
		
		LOG.debug("1=====OrgContoller=doRetrieve===========");
		LOG.debug("1=param="+search);
		LOG.debug("1=================");
		//검색조건 화면으로 전달.
		model.addAttribute("vo", search);
		//TODO: codeTable : 검색조건,페이지 사이즈
		//검색조건
		CodeVO  code=new CodeVO();
		code.setCodeTypeId("ORG_SEARCH");
		List<CodeVO> searchList=(List<CodeVO>) this.codeService.doRetrieve(code);
		LOG.debug("1.1=searchList="+searchList);
		model.addAttribute("searchList", searchList);
		
		//페이지 사이즈: PAGE_SIZE
		code.setCodeTypeId("PAGE_SIZE");
		List<CodeVO> pageSizeList=(List<CodeVO>) this.codeService.doRetrieve(code);
		LOG.debug("1.1=pageSizeList="+pageSizeList);
		model.addAttribute("pageSizeList", pageSizeList);
		
		
		List<OrgVO> list = (List<OrgVO>) this.orgService.doRetrieve(search);
		//조회결과 화면 전달
		model.addAttribute("list", list);
		for(OrgVO vo:list) {
			LOG.debug("1.1=out="+vo);
		}
		
		//총건수
		int totalCnt = 0;
		if(null !=list &&  list.size()>0) {
			totalCnt = list.get(0).getTotalCnt();
		}
		
		LOG.debug("1.2======OrgContoller=doRetrieve===========");
		LOG.debug("1.2=totalCnt="+totalCnt);
		LOG.debug("1.2=================");
		//조회결과 화면 전달
		model.addAttribute("totalCnt", totalCnt);
		return "views/admin_org_list";
	}
	
	//수정
	@RequestMapping(value = "admin/do_update.do",method = RequestMethod.POST ,produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String doUpdate(OrgVO  orgVO,Locale locale,Model model,SearchVO  search) {
		LOG.debug("1===OrgContoller=수정=============");
		LOG.debug("1=param="+orgVO);
		LOG.debug("1=================");
		
		List<OrgVO> list = (List<OrgVO>) this.orgService.doRetrieve(search);
		//조회결과 화면 전달
		model.addAttribute("list", list);
		for(OrgVO vo:list) {
			LOG.debug("1.1=out="+vo);
		}
				
		if( null == orgVO.getId()) {		

			throw new IllegalArgumentException("ID를 확인 하세요.");			
		}
		
		int flag = this.orgService.doUpdate(orgVO);
		
		MessageVO message=new MessageVO();
		
		if(flag>0) {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("수정 성공.");
		}else {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("수정 실패.");			
		}
		
		Gson gson=new Gson();
		String jsonStr = gson.toJson(message);
		LOG.debug("1.2==OrgContoller= 수정 ==============");
		LOG.debug("1.2=jsonStr="+jsonStr);
		LOG.debug("1.2=================");
		
		
		return jsonStr;
	}
	
	@RequestMapping(value = "admin/do_insert_view.do",method = RequestMethod.GET)
	public String doInsertView(Locale locale) {
		
		LOG.debug("1=================");
		LOG.debug("1=admin/admin_org_write");
		LOG.debug("1=================");
		return "views/admin_org_write";
	}
	
	//삭제
	@RequestMapping(value = "admin/do_delete.do",method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doDelete(OrgVO  orgVO,Locale locale) {
		//param orgVO_id
		LOG.debug("1======OrgContoller==doDelete=========");
		LOG.debug("1=param="+orgVO);
		LOG.debug("1=================");
		
		if( null == orgVO.getId()) {

			throw new IllegalArgumentException("ID를 확인 하세요.");			
		}		
		
		int flag = this.orgService.doDelete(orgVO);
		MessageVO message=new MessageVO();
		//삭제 성공
		if(flag>0) {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("삭제 되었습니다.");
		//실패	
		}else {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("삭제 실패.");			
		}
		
		Gson gson=new Gson();
		String gsonStr = gson.toJson(message);
		
		LOG.debug("1======OrgContoller==doDelete=========");
		LOG.debug("1=gsonStr="+gsonStr);
		LOG.debug("1=================");	
		
		
		return gsonStr;
	}
	
	//단건조회 - 상세페이지 조회
	@RequestMapping(value = "admin/do_selectone.do",method = RequestMethod.GET)
	public String doSelectOne(OrgVO  orgVO,Locale locale,Model model) {
		//param ID
		LOG.debug("1=====OrgContoller=doSelectOne===========");
		LOG.debug("1=param="+orgVO);
		LOG.debug("1=================");
		
		if( null == orgVO.getId()) {

			throw new IllegalArgumentException("ID를 확인 하세요.");			
		}
		
		OrgVO  outVO =(OrgVO) this.orgService.doSelectOne(orgVO);
		LOG.debug("1.1.======OrgContoller=doSelectOne==========");
		LOG.debug("1.1=outVO="+outVO);
		LOG.debug("1.1=================");	
		model.addAttribute("vo", outVO);
		
		return "views/admin_org_mng"; // views/norgVO_read.jsp
	}
	

	//등록
	@RequestMapping(value = "admin/do_insert.do",method = RequestMethod.POST ,produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String doInsert(OrgVO norgVO,Locale locale) {
		LOG.debug("1====OrgContoller=doInsert============");
		LOG.debug("1=param="+norgVO);
		LOG.debug("1=================");
		
		int flag = this.orgService.doInsert(norgVO);
		
		MessageVO message=new MessageVO();
		
		if(flag>0) {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("등록 성공.");
		}else {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("등록 실패.");			
		}
		
		Gson gson=new Gson();
		String jsonStr = gson.toJson(message);
		LOG.debug("1.2====OrgContoller=doInsert============");
		LOG.debug("1.2=jsonStr="+jsonStr);
		LOG.debug("1.2=================");		
		return jsonStr;
	}
}
