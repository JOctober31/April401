package com.april.groupware.dash.web;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.april.groupware.cmn.SearchVO;
import com.april.groupware.code.service.CodeService;
import com.april.groupware.code.service.CodeVO;
import com.april.groupware.dash.service.DashDeptVO;
import com.april.groupware.dash.service.DashNBoardVO;
import com.april.groupware.dash.service.DashTodoService;
import com.april.groupware.dash.service.DashTodoVO;

@Controller
public class DashController {

	Logger  LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	DashTodoService dashTodoService;
	
	@Autowired
	CodeService codeService;
	

	@RequestMapping(value = "dash/do_selectone.do", method = RequestMethod.GET)
	public String doSelectOne(DashTodoVO dashTodoVO, DashDeptVO dashDeptVO,SearchVO  search, Model model) {
		// param board_id
		LOG.debug("1=================");
		LOG.debug("1=param="+dashTodoVO);

		dashTodoVO.setDeptNm("인사");
		DashTodoVO  hrVO =(DashTodoVO) this.dashTodoService.doSelectOne(dashTodoVO);
		
		dashTodoVO.setDeptNm("영업");
		DashTodoVO  salseVO =(DashTodoVO) this.dashTodoService.doSelectOne(dashTodoVO);
		
		dashTodoVO.setDeptNm("운영");
		DashTodoVO  operVO =(DashTodoVO) this.dashTodoService.doSelectOne(dashTodoVO);
		
		dashTodoVO.setDeptNm("개발");
		DashTodoVO  devVO =(DashTodoVO) this.dashTodoService.doSelectOne(dashTodoVO);
		
		
		LOG.debug("1.1.부서별 메인 프로젝트");
		LOG.debug("1.1=hrVO="+hrVO);
		LOG.debug("1.1=salseVO="+salseVO);
		LOG.debug("1.1=operVO="+operVO);
		LOG.debug("1.1=devVO="+devVO);
		LOG.debug("1.1=================");	
		
		model.addAttribute("hrVO", hrVO);
		model.addAttribute("salseVO", salseVO);
		model.addAttribute("operVO", operVO);
		model.addAttribute("devVO", devVO);
		
		
		// 2. 부서별 실적
		dashDeptVO.setDeptNm("인사");
		DashDeptVO dhrVO =(DashDeptVO) this.dashTodoService.doDeptSelectOne(dashDeptVO);
		dhrVO.setDeptNm("인사");
		
		dashDeptVO.setDeptNm("영업");
		DashDeptVO  dsalseVO =(DashDeptVO) this.dashTodoService.doDeptSelectOne(dashDeptVO);
		dsalseVO.setDeptNm("영업");
		
		dashDeptVO.setDeptNm("운영");
		DashDeptVO  doperVO =(DashDeptVO) this.dashTodoService.doDeptSelectOne(dashDeptVO);
		doperVO.setDeptNm("운영");
		
		dashDeptVO.setDeptNm("개발");
		DashDeptVO  ddevVO =(DashDeptVO) this.dashTodoService.doDeptSelectOne(dashDeptVO);
		ddevVO.setDeptNm("개발");
		
		LOG.debug("1.1.부서별 메인 프로젝트");
		LOG.debug("1.1=dhrVO="+dhrVO);
		LOG.debug("1.1=dsalseVO="+dsalseVO);
		LOG.debug("1.1=doperVO="+doperVO);
		LOG.debug("1.1=ddevVO="+ddevVO);
		LOG.debug("1.1=================");	
		
		model.addAttribute("dhrVO", dhrVO);
		model.addAttribute("dsalseVO", dsalseVO);
		model.addAttribute("doperVO", doperVO);
		model.addAttribute("ddevVO", ddevVO);
		
		
		
		
		// 3. 전사게시판 목록 리스트  최근10
		if (search.getPageNum() == 0) {
			search.setPageNum(1);
		}

		if (search.getPageSize() == 0) {
			search.setPageSize(10);
		}

		search.setSearchDiv("");
		search.setSearchWord("");

		LOG.debug("1=====DashNBoardVOContoller=doRetrieve===========");
		LOG.debug("1=param=" + search);
		LOG.debug("1=================");
		// 검색조건 화면으로 전달.
		model.addAttribute("vo", search);
		// TODO: codeTable : 검색조건,페이지 사이즈
		// 검색조건
		CodeVO code = new CodeVO();
		code.setCodeTypeId("BOARD_SEARCH");
		List<CodeVO> searchList = (List<CodeVO>) this.codeService.doRetrieve(code);
		LOG.debug("1.1=searchList=" + searchList);
		model.addAttribute("searchList", searchList);

		// 페이지 사이즈: PAGE_SIZE
		code.setCodeTypeId("PAGE_SIZE");
		List<CodeVO> pageSizeList = (List<CodeVO>) this.codeService.doRetrieve(code);
		LOG.debug("1.1=pageSizeList=" + pageSizeList);
		model.addAttribute("pageSizeList", pageSizeList);

		List<DashNBoardVO> dashNbList = (List<DashNBoardVO>) this.dashTodoService.doRetrieve(search);
		// 조회결과 화면 전달
		model.addAttribute("dashNbList", dashNbList);
		for (DashNBoardVO vo : dashNbList) {
			LOG.debug("1.1=out=" + vo);
		}

		return "views/admin_dashboard";
	}
	
}