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
	

	
	
	@RequestMapping(value = "admin/do_retrieve.do",method = RequestMethod.GET)
	public String doRetrieve(SearchVO search, Model model) {
		// param 기본값 처리
		if (search.getPageNum() == 0) {
			search.setPageNum(1);
		}

		if (search.getPageSize() == 0) {
			search.setPageSize(10);
		}

		search.setSearchDiv(StringUtil.nvl(search.getSearchDiv()));
		search.setSearchWord(StringUtil.nvl(search.getSearchWord().trim()));

		LOG.debug("1=================");
		LOG.debug("1=param=" + search);
		LOG.debug("1=================");

		// 검색조건 화면으로 전달.
		model.addAttribute("vo", search);
		// TODO: codeTable : 검색조건,페이지 사이즈
		// 검색조건

		CodeVO code = new CodeVO();
		code.setCodeTypeId("ORG_SEARCH");
		List<CodeVO> searchList = (List<CodeVO>) this.codeService.doRetrieve(code);
		LOG.debug("1.1=searchList=" + searchList);
		model.addAttribute("searchList", searchList);

		// 페이지 사이즈: PAGE_SIZE
		code.setCodeTypeId("PAGE_SIZE");
		List<CodeVO> pageSizeList = (List<CodeVO>) this.codeService.doRetrieve(code);
		LOG.debug("1.1=pageSizeList=" + pageSizeList);
		model.addAttribute("pageSizeList", pageSizeList);

		List<OrgVO> list = (List<OrgVO>) this.orgService.doRetrieve(search);
		// 조회결과 화면 전달
		model.addAttribute("list", list);
		for (OrgVO vo : list) {
			LOG.debug("1.1=out=★★★★★★★★" + vo);
		}

		// 총건수
		int totalCnt = 0;
		if (null != list && list.size() > 0) {
			totalCnt = list.get(0).getTotalCnt();
		}

		LOG.debug("1.2=================");
		LOG.debug("1.2=totalCnt=" + totalCnt);
		LOG.debug("1.2=================");
		// 조회결과 화면 전달
		model.addAttribute("totalCnt", totalCnt);
		return "views/admin_test_list";// "/board/board_list.jsp
	   }
	
	
	
		/*
		 * @RequestMapping(value = "admin/do_update.do",method = RequestMethod.POST
		 * ,produces = "application/json; charset=UTF-8")
		 * 
		 * @ResponseBody public String doUpdate(OrgVO orgVO,Locale locale) {
		 * LOG.debug("1================="); LOG.debug("1=param="+orgVO);
		 * LOG.debug("1=================");
		 * 
		 * if( null == orgVO.getId()) { throw new
		 * IllegalArgumentException("orgVO_ID를 확인 하세요."); } int flag =
		 * this.orgService.doUpdate(orgVO);
		 * 
		 * MessageVO message=new MessageVO();
		 * 
		 * if(flag>0) { message.setMsgId(String.valueOf(flag));
		 * message.setMsgMsg("수정 성공."); }else { message.setMsgId(String.valueOf(flag));
		 * message.setMsgMsg("수정 실패."); }
		 * 
		 * Gson gson=new Gson(); String jsonStr = gson.toJson(message);
		 * LOG.debug("1.2================="); LOG.debug("1.2=jsonStr="+jsonStr);
		 * LOG.debug("1.2================="); return jsonStr; }
		 */
	
	/**
	 * 
	 * @param orgVO
	 * @return json
	 * 
	 */
	
	/*
	 * @RequestMapping(value="admin/do_select_one.do", method=RequestMethod.POST,
	 * produces="application/json; charset=UTF-8")
	 * 
	 * @ResponseBody public String doSelectOne(OrgVO orgVO) {
	 * LOG.debug("===================="); LOG.debug("=doSelectOne user= : "+orgVO);
	 * LOG.debug("====================");
	 * 
	 * if(orgVO.getId() == null) { throw new IllegalArgumentException("ID를 입력하세요");
	 * }
	 * 
	 * OrgVO outVO = (OrgVO) orgService.doSelectOne(orgVO);
	 * LOG.debug("===================="); LOG.debug("=doSelectOne outVO= : "+outVO);
	 * LOG.debug("====================");
	 * 
	 * //Json(Gson) Gson gson = new Gson(); String jsonStr = gson.toJson(outVO);
	 * 
	 * LOG.debug("====================");
	 * LOG.debug("=doSelectOne jsonStr=:"+jsonStr);
	 * LOG.debug("====================");
	 * 
	 * return jsonStr; }
	 */

	
	/*
	 * @RequestMapping(value = "admin/do_insert.do",method =
	 * RequestMethod.POST,produces = "application/json; charset=UTF-8")
	 * 
	 * @ResponseBody public String doInsert(OrgVO orgVO,Locale locale) {
	 * LOG.debug("1================="); LOG.debug("1=param="+orgVO);
	 * LOG.debug("1=================");
	 * 
	 * 
	 * int flag = this.orgService.doInsert(orgVO);
	 * 
	 * MessageVO message=new MessageVO();
	 * 
	 * if(flag>0) { message.setMsgId(String.valueOf(flag));
	 * message.setMsgMsg("등록 성공."); }else { message.setMsgId(String.valueOf(flag));
	 * message.setMsgMsg("등록 실패."); }
	 * 
	 * Gson gson=new Gson(); String jsonStr = gson.toJson(message);
	 * LOG.debug("1.2================="); LOG.debug("1.2=jsonStr="+jsonStr);
	 * LOG.debug("1.2================="); return jsonStr; }
	 */
	
	
	
}














