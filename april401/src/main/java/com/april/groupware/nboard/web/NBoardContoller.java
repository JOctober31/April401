package com.april.groupware.nboard.web;

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
import com.april.groupware.nboard.service.NBAnswerService;
import com.april.groupware.nboard.service.NBAnswerVO;
import com.april.groupware.nboard.service.NBoardService;
import com.april.groupware.nboard.service.NBoardVO;
import com.google.gson.Gson;


@Controller
public class NBoardContoller {
Logger  LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	NBoardService boardService;
	
	@Autowired
	NBAnswerService answerService;
	
	@Autowired
	CodeService codeService;
	
	@Autowired
	MessageSource messageSource;
	
	//목록조회
	@RequestMapping(value = "nboard/do_retrieve.do",method = RequestMethod.GET)
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
		
		LOG.debug("1=====NBoardContoller=doRetrieve===========");
		LOG.debug("1=param="+search);
		LOG.debug("1=================");
		//검색조건 화면으로 전달.
		model.addAttribute("vo", search);
		//TODO: codeTable : 검색조건,페이지 사이즈
		//검색조건
		CodeVO  code=new CodeVO();
		code.setCodeTypeId("BOARD_SEARCH");
		List<CodeVO> searchList=(List<CodeVO>) this.codeService.doRetrieve(code);
		LOG.debug("1.1=searchList="+searchList);
		model.addAttribute("searchList", searchList);
		
		//페이지 사이즈: PAGE_SIZE
		code.setCodeTypeId("PAGE_SIZE");
		List<CodeVO> pageSizeList=(List<CodeVO>) this.codeService.doRetrieve(code);
		LOG.debug("1.1=pageSizeList="+pageSizeList);
		model.addAttribute("pageSizeList", pageSizeList);
		
		
		List<NBoardVO> list = (List<NBoardVO>) this.boardService.doRetrieve(search);
		//조회결과 화면 전달
		model.addAttribute("list", list);
		for(NBoardVO vo:list) {
			LOG.debug("1.1=out="+vo);
		}
		
		//총건수
		int totalCnt = 0;
		if(null !=list &&  list.size()>0) {
			totalCnt = list.get(0).getTotalCnt();
		}
		
		LOG.debug("1.2======NBoardContoller=doRetrieve===========");
		LOG.debug("1.2=totalCnt="+totalCnt);
		LOG.debug("1.2=================");
		//조회결과 화면 전달
		model.addAttribute("totalCnt", totalCnt);
		return "views/nboard_list";// "/board/board_list.jsp
	}
	
	//수정
	@RequestMapping(value = "nboard/do_update.do",method = RequestMethod.POST
			,produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String doUpdate(NBoardVO  board,Locale locale,Model model,SearchVO  search) {
		LOG.debug("1===NBoardContoller=수정=============");
		LOG.debug("1=param="+board);
		LOG.debug("1=================");
		
		List<NBoardVO> list = (List<NBoardVO>) this.boardService.doRetrieve(search);
		//조회결과 화면 전달
		model.addAttribute("list", list);
		for(NBoardVO vo:list) {
			LOG.debug("1.1=out="+vo);
		}
				
		if( 0 == board.getNbNo()) {		

			throw new IllegalArgumentException("게시글 번호를 확인 하세요.");			
		}
		
		int flag = this.boardService.doUpdate(board);
		
		MessageVO message=new MessageVO();
		
		if(flag>0) {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("성공적으로 수정되었습니다.");
		}else {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("수정에 실패하였습니다.");			
		}
		
		Gson gson=new Gson();
		String jsonStr = gson.toJson(message);
		LOG.debug("1.2==NBoardContoller= 수정 ==============");
		LOG.debug("1.2=jsonStr="+jsonStr);
		LOG.debug("1.2=================");
		
		
		return jsonStr;
	}
	
	//삭제
	@RequestMapping(value = "nboard/do_delete.do",method = RequestMethod.POST
			,produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String doDelete(NBoardVO  board,Locale locale) {
		//param board_id
		LOG.debug("1======NBoardContoller==doDelete=========");
		LOG.debug("1=param="+board);
		LOG.debug("1=================");
		
		if( 0 == board.getNbNo()) {		

			throw new IllegalArgumentException("게시글 번호를 확인 하세요.");			
		}		
		
		int flag = this.boardService.doDelete(board);
		MessageVO message=new MessageVO();
		//삭제 성공
		if(flag>0) {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("삭제 되었습니다.");
		//실패	
		}else {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("삭제에 실패하였습니다.");			
		}
		
		Gson gson=new Gson();
		String gsonStr = gson.toJson(message);
		
		LOG.debug("1======NBoardContoller==doDelete=========");
		LOG.debug("1=gsonStr="+gsonStr);
		LOG.debug("1=================");	
		
		
		return gsonStr;
	}
	
	//단건조회 - 상세페이지 조회
	@RequestMapping(value = "nboard/do_selectone.do",method = RequestMethod.GET)
	public String doSelectOne(NBoardVO  board,Locale locale,Model model) {
		//param NbNo
		LOG.debug("1=====NBoardContoller=doSelectOne===========");
		LOG.debug("1=param="+board);
		LOG.debug("1=================");
		
		if( 0 == board.getNbNo()) {		

			throw new IllegalArgumentException("게시글 번호를 확인 하세요.");			
		}
		
		NBoardVO  outVO =(NBoardVO) this.boardService.doSelectOne(board);
		LOG.debug("1.1.======NBoardContoller=doSelectOne==========");
		LOG.debug("1.1=outVO="+outVO);
		LOG.debug("1.1=================");	
		model.addAttribute("vo", outVO);
		
		//------------------------------------------------------------------
		LOG.debug("=====NBAnswerContoller [doRetrieve] Start=====");
		//param 기본값 처리
//		if(search.getPageNum()==0) {
//			search.setPageNum(1);
//		}
//		
//		if(search.getPageSize()==0) {
//			search.setPageSize(10);
//		}
		
//		//검색구분
//		search.setSearchDiv(StringUtil.nvl(search.getSearchDiv()));
//		//검색어
//		search.setSearchWord(StringUtil.nvl(search.getSearchWord().trim()));
		
//		LOG.debug("** param : "+search);
		//검색조건 화면으로 전달.
//		model.addAttribute("aw", search);
		NBAnswerVO aw = new NBAnswerVO();
		aw.setNbNo(board.getNbNo());
		
		List<NBAnswerVO> list = (List<NBAnswerVO>) this.answerService.doRetrieve(aw);
		//조회결과 화면 전달
		model.addAttribute("list", list);
		for(NBAnswerVO vo:list) {
			LOG.debug("** list : "+vo);
		}
		
		//총건수
		int totalCnt = 0;
		if(null !=list &&  list.size()>0) {
//			totalCnt = list.get(0).getTotalCnt();
			
		}
		LOG.debug("** totalCnt : "+totalCnt);
		
		//조회결과 화면 전달
		model.addAttribute("totalCnt", totalCnt);
		
		LOG.debug("=====NBAnswerContoller [doRetrieve] End=====");
		
		//------------------------------------------------------------------
		
		return "views/nboard_read"; // views/nboard_read.jsp
	}
	
	//단건조회 - 수정페이지 이동 http://localhost:8080/groupware/nboard/do_selectone_update.do?nbNo=1041&readCnt=%EC%A1%B0%ED%9A%8C%EC%88%98+83
		@RequestMapping(value = "nboard/do_selectone_update.do",method = RequestMethod.GET)
		public String doSelectOneUpdate(NBoardVO  board,Locale locale,Model model) {
			//param NbNo
			LOG.debug("1=====NBoardContoller=doSelectOneUpdate===========");
			LOG.debug("1=param="+board);
			LOG.debug("1=================");
			
			if( 0 == board.getNbNo()) {		

				throw new IllegalArgumentException("게시글 번호를 확인 하세요.");			
			}
			
			NBoardVO  outVO =(NBoardVO) this.boardService.doSelectOne(board);
			LOG.debug("1.1.==NBoardContoller=doSelectOneUpdate==============");
			LOG.debug("1.1=outVO="+outVO);
			LOG.debug("1.1=================");	
			model.addAttribute("vo", outVO);
			
			return "views/nboard_read_update"; // views/nboard_read.jsp
		}
	
	//수정화면으로 이동
//	@RequestMapping(value = "nboard/do_update_view.do",method = RequestMethod.GET)
//	public String doUpdateView(Locale locale) {
//		
//		LOG.debug("1=================");
//		LOG.debug("1=views/nboard_read_update");
//		LOG.debug("1=================");
//		return "views/nboard_read_update";// nboard_read_update.jsp
//	}
	
	//등록
	@RequestMapping(value = "nboard/do_insert.do",method = RequestMethod.POST
			,produces = "application/json; charset=UTF-8")
	@ResponseBody
	public String doInsert(NBoardVO nboard,Locale locale) {
		LOG.debug("1====NBoardContoller=doInsert============");
		LOG.debug("1=param="+nboard);
		LOG.debug("1=================");
		
		int flag = this.boardService.doInsert(nboard);
		
		MessageVO message=new MessageVO();
		
		if(flag>0) {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("성공적으로 등록되었습니다.");
		}else {
			message.setMsgId(String.valueOf(flag));
			message.setMsgMsg("등록에 실패하였습니다.");			
		}
		
		Gson gson=new Gson();
		String jsonStr = gson.toJson(message);
		LOG.debug("1.2====NBoardContoller=doInsert============");
		LOG.debug("1.2=jsonStr="+jsonStr);
		LOG.debug("1.2=================");		
		return jsonStr;
	}
}
