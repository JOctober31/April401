package com.april.groupware.reserve.web;

import java.util.List;

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
import com.april.groupware.code.service.CodeService;
import com.april.groupware.reserve.service.ReservationVO;
import com.april.groupware.reserve.service.ReserveDao;
import com.google.gson.Gson;

@Controller
public class ReservationController {
	private final Logger LOG = LoggerFactory.getLogger(ReservationController.class);
	
	@Autowired
	ReserveDao reserveDao;
	
	@Autowired
	CodeService codeService;
	
	@RequestMapping(value="reserve/do_insert.do", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	@ResponseBody
	public String doInsert(ReservationVO reserveVO) {
		LOG.debug("====================");
		LOG.debug("=doInsert user= : "+reserveVO);
		LOG.debug("====================");
		
		int flag = reserveDao.doInsert(reserveVO);
		LOG.debug("====================");
		LOG.debug("=doInsert flag= : "+flag);
		LOG.debug("====================");
		
		MessageVO message = new MessageVO();
		
		message.setMsgId(String.valueOf(flag));
		
		if(flag == 1) {
			message.setMsgMsg(reserveVO.getRsvNo()+"예약 성공");
		} else {
			message.setMsgMsg(reserveVO.getRsvNo()+"예약 실패");
		}
		
		//Json(Gson)
		Gson gson = new Gson();
		String json = gson.toJson(message);
		
		LOG.debug("====================");
		LOG.debug("=doInsert json= : "+json);
		LOG.debug("====================");
		
		return json;
	}
	
	@RequestMapping(value="reserve/do_update.do", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	@ResponseBody
	public String doUpdate(ReservationVO reserveVO) {
		LOG.debug("====================");
		LOG.debug("=doUpdate user= : "+reserveVO);
		LOG.debug("====================");
		
		if(reserveVO.getRegId() == null) {
			throw new IllegalArgumentException("ID를 입력하세요");
		}
		
		if(reserveVO.getRsvNo() == null) {
			throw new IllegalArgumentException("예약 번호를 입력하세요");
		}
		
		int flag = reserveDao.doUpdate(reserveVO);
		LOG.debug("====================");
		LOG.debug("=doUpdate flag= : "+flag);
		LOG.debug("====================");
		
		MessageVO message = new MessageVO();
		
		message.setMsgId(String.valueOf(flag));
		
		if(flag == 1) {
			message.setMsgMsg(reserveVO.getRsvNo()+"예약 수정 성공");
		} else {
			message.setMsgMsg(reserveVO.getRsvNo()+"예약 수정 실패");
		}
		
		//Json(Gson)
		Gson gson = new Gson();
		String json = gson.toJson(message);
		
		LOG.debug("====================");
		LOG.debug("=doUpdate json= : "+json);
		LOG.debug("====================");
		
		return json;
	}
	
	@RequestMapping(value="reserve/do_delete.do", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	@ResponseBody
	public String doDelete(ReservationVO reserveVO) {
		LOG.debug("====================");
		LOG.debug("=doDelete user= : "+reserveVO);
		LOG.debug("====================");
		
		if(reserveVO.getRsvNo() == null) {
			throw new IllegalArgumentException("예약 번호를 입력하세요");
		}
		
		int flag = reserveDao.doDelete(reserveVO);
		LOG.debug("====================");
		LOG.debug("=doDelete flag= : "+flag);
		LOG.debug("====================");
		
		MessageVO message = new MessageVO();
		
		message.setMsgId(String.valueOf(flag));
		
		if(flag > 0) {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("삭제 성공");
		} else {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("삭제 실패");
		}
		
		//Json(Gson)
		Gson gson = new Gson();
		String json = gson.toJson(message);
		
		LOG.debug("====================");
		LOG.debug("=doDelete json= : "+json);
		LOG.debug("====================");
		
		return json;
	}
	
	@RequestMapping(value="reserve/do_select_one.do", method=RequestMethod.POST, produces="application/json; charset=UTF-8")
	@ResponseBody
	public String doSelectOne(ReservationVO reserveVO) {
		LOG.debug("====================");
		LOG.debug("=doSelectOne user= : "+reserveVO);
		LOG.debug("====================");
		
		ReservationVO outVO = (ReservationVO) reserveDao.doSelectOne(reserveVO);
		LOG.debug("====================");
		LOG.debug("=doSelectOne outVO= : "+outVO);
		LOG.debug("====================");
		
		//Json(Gson)
		Gson gson = new Gson();
		String json = gson.toJson(outVO);
		
		LOG.debug("====================");
		LOG.debug("=doSelectOne json= : "+json);
		LOG.debug("====================");
		
		return json;
	}
	
	@RequestMapping(value="reserve/do_retrieve.do", method=RequestMethod.GET, produces = "application/json; charset=UTF-8")
	public String doRetrieve(SearchVO search, Model model) {
		//검색 조건
		if(search.getPageNum() == 0) {
			search.setPageNum(1);
		}
		
		if(search.getPageSize() == 0) {
			search.setPageSize(10);
		}

		//검색구분, 검색어
		search.setSearchDiv(StringUtil.nvl(search.getSearchDiv()));
		search.setSearchWord(StringUtil.nvl(search.getSearchWord().trim()));
		search.setSearchStartDate(StringUtil.nvl(search.getSearchStartDate()));
		search.setSearchEndDate(StringUtil.nvl(search.getSearchEndDate()));

		model.addAttribute("searchList", search);
		LOG.debug("1.1====================");
		LOG.debug("1.1=search= : "+search);
		LOG.debug("1.1====================");
		
		List<ReservationVO> list = (List<ReservationVO>) reserveDao.doRetrieve(search);
		LOG.debug("1.2====================");
		for(ReservationVO vo : list) {
			LOG.debug("list : "+vo);
		}
		LOG.debug("1.2====================");
		
		model.addAttribute("list", list);
		
		//총 게시글수
		int totalCnt = 0;
		if(list != null && list.size()>0) {
			totalCnt = list.get(0).getTotalCnt();
		}
		
		model.addAttribute("totalCnt", totalCnt);
		
		int maxPageNo = ((totalCnt - 1) / search.getPageSize()) + 1;
		
		model.addAttribute("maxPageNo", maxPageNo);
		model.addAttribute("pageNum", search.getPageNum());
		
		Gson gson = new Gson();
		String json = gson.toJson(list);
		LOG.debug("====================");
		LOG.debug("=json="+json);
		LOG.debug("====================");
		
		//"member/member_mng" -> "/(root)" + "member/member_mng" + ".jsp"
//		return json;
		
//		model.addAttribute("vo", search);
		
//		//검색 조건
//		CodeVO code = new CodeVO();
//		
//		//RESERVE_SEARCH
////		code.setCodeTypeId("BOARD_SEARCH");
//		code.setCodeTypeId("RESERVE_SEARCH");
//		List<CodeVO> searchList = (List<CodeVO>) this.codeService.doRetrieve(code);
//		LOG.debug("======================");
//		LOG.debug("=searchList= : "+searchList);
//		LOG.debug("======================");
//		model.addAttribute("searchList", searchList);
//		
//		//PAGE_SIZE
//		code.setCodeTypeId("PAGE_SIZE");
//		List<CodeVO> pageSizeList = (List<CodeVO>) this.codeService.doRetrieve(code);
//		LOG.debug("======================");
//		LOG.debug("=pageSizeList= : "+pageSizeList);
//		LOG.debug("======================");
//		model.addAttribute("pageSizeList", pageSizeList);
//		
//		
//		List<ReservationVO> list = (List<ReservationVO>) this.reserveDao.doRetrieve(search);
//		model.addAttribute("list", list);
//		
//		for (ReservationVO ReservationVO : list) {
//			LOG.debug("outVO : "+ReservationVO);
//		}
//		
//		//총 게시글 수
//		int totalCnt = 0;
//		if(list != null && list.size() > 0) {
//			totalCnt = list.get(0).getTotalCnt();
//		}
//		
//		LOG.debug("======================");
//		LOG.debug("=totalCnt= : "+totalCnt);
//		LOG.debug("======================");
//		
//		model.addAttribute("totalCnt", totalCnt);
		
		return "views/reservation";
	}
	
}
