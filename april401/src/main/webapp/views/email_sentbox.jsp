<%--
  /**
  * Class Name : 
  * Description : 
  * Modification Information
  *
  *   수정일                   수정자                      수정내용
  *  -------    --------    ---------------------------
  *  2020. 5. 7.            최초 생성
  *
  * author 실행환경 개발팀
  * since 2009.01.06
  *
  * http://localhost:8080/groupware/mail/do_retrieveSent.do?pageNum=1&pageSize=10&searchDiv=&searchWord=kimmj
  *
  * Copyright (C) 2009 by KandJang  All right reserved.
  */
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.april.groupware.cmn.StringUtil"%>
<%@page import="com.april.groupware.cmn.SearchVO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/common/common.jsp"%>
<c:set var="aprilContext" value="${pageContext.request.contextPath }"></c:set>
<%
	//페이지 사이즈
String pageSize = "10";

//페이지 num
String pageNum = "1";

//검색구분
String searchDiv = "";

//검색어
String searchWord = "kimmj";

SearchVO search = (SearchVO) request.getAttribute("vo");
if (search != null) {
	pageSize = String.valueOf(search.getPageSize());
	pageNum = String.valueOf(search.getPageNum());
	searchDiv = String.valueOf(search.getSearchDiv());
	searchWord = String.valueOf(search.getSearchWord());

}
//out.print("search: "+search);

int totalCnt = 0;
totalCnt = (Integer) request.getAttribute("totalCnt");
//out.print("**totalCnt**"+totalCnt);

//paging (StringUtil render참고)
//int maxNum_i, int currPageNoIn_i, int rowsPerPage_i, int bottomCount_i, String url_i, String scriptName_i
String url = H_PATH + "/mail/do_retrieveSent.do"; //H_PATH: common.jsp에 있음(ehr)
String scriptName = "doSearchPage";
int maxNum = 0; //총글수
int currPageNo = 1; //현재 페이지
int rowPerPage = 10;
int bottomCount = 7; //바닥에 보여지는 글 수

if (search != null) {
	currPageNo = search.getPageNum();
	rowPerPage = search.getPageSize();
	maxNum = totalCnt;
}
//--//paging
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>메일</title>
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="${aprilContext}/views/images/favicon.png">
    <!-- Custom Stylesheet -->
    <link href="${aprilContext}/views/css/style.css" rel="stylesheet">

</head>

<body>

    <!--*******************
        Preloader start
    ********************-->
    <div id="preloader">
        <div class="loader">
            <svg class="circular" viewBox="25 25 50 50">
                <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="3" stroke-miterlimit="10" />
            </svg>
        </div>
    </div>
    <!--*******************
        Preloader end
    ********************-->

    
    <!--**********************************
        Main wrapper start
    ***********************************-->
    <div id="main-wrapper">

        <!--**********************************
            Nav header start
        ***********************************-->
        <div class="nav-header">
            <%@ include file="/common/april_logo.jsp" %>
        </div>
        <!--**********************************
            Nav header end
        ***********************************-->

        <!--**********************************
            Header start
        ***********************************-->
        <div class="header">  
        	<%@ include file="/common/april_header.jsp" %>  
        </div>
        <!--**********************************
            Header end ti-comment-alt
        ***********************************-->

        <!--**********************************
            Sidebar start
        ***********************************-->
        <div class="nk-sidebar">        
        	<%@ include file="/common/april_sidebar.jsp" %>   
        </div>
        <!--**********************************
            Sidebar end
        ***********************************-->

        <!--**********************************
            Content body start
        ***********************************-->
        <div class="content-body">

            <div class="row page-titles mx-0">
                <div class="col p-md-0">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="javascript:void(0)">Apps</a></li>
                        <li class="breadcrumb-item active"><a href="javascript:void(0)">메일</a></li>
                    </ol>
                </div>
            </div>
            <!-- row -->

            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="email-left-box">
                                	<a href="${aprilContext}/views/email_compose.jsp" class="btn btn-primary btn-block">메일 쓰기</a>
                                    <div class="mail-list mt-4">
                                    	<a href="${aprilContext}/mail/do_retrieve.do?pageNum=1&pageSize=10&searchDiv=&searchWord=${user.id}" class="list-group-item border-0 p-r-0"><i class="fa fa-inbox font-18 align-middle mr-2"></i> 
	                                    	<b>받은 메일함</b> 
	                                    	<span class="badge badge-primary badge-sm float-right m-t-5"><c:out value="${count}"></c:out></span> 
                                    	</a>
                                        <a href="${aprilContext}/mail/do_retrieveSent.do?pageNum=1&pageSize=10&searchDiv=&searchWord=${user.id}" class="list-group-item border-0 text-primary p-r-0"><i class="fa fa-paper-plane font-18 align-middle mr-2"></i>보낸 메일함</a>  
                                        <!-- 
                                        <a href="#" class="list-group-item border-0 p-r-0"><i class="mdi mdi-file-document-box font-18 align-middle mr-2"></i>Draft</a>
                                         -->
                                        <a href="${aprilContext}/mail/do_retrieveTrash.do?pageNum=1&pageSize=10&searchDiv=&searchWord=${user.id}" class="list-group-item border-0 p-r-0"><i class="fa fa-trash font-18 align-middle mr-2"></i>휴지통</a>
                                    </div>
                                    <!-- 
                                    <h5 class="mt-5 m-b-10">카테고리</h5>
                                    <div class="list-group mail-list">
                                    	<a href="#" class="list-group-item border-0"><span class="fa fa-briefcase f-s-14 mr-2"></span>Work</a>  
                                    	<a href="#" class="list-group-item border-0"><span class="fa fa-sellsy f-s-14 mr-2"></span>Private</a>  
                                    	<a href="#" class="list-group-item border-0"><span class="fa fa-ticket f-s-14 mr-2"></span>Support</a>  
                                    	<a href="#" class="list-group-item border-0"><span class="fa fa-tags f-s-14 mr-2"></span>Social</a>
                                    </div>
                                     -->
                                </div>
                                <div class="email-right-box">
                                    <div role="toolbar" class="toolbar">
                                    	<!-- <div class="btn-group">
                                        	<button type="button" class="btn btn-light"><i class="fa fa-mail-reply font-18 align-middle mr-2"></i>답장</button>
                                        	<button type="button" class="btn btn-light"><i class="fa fa-trash font-18 align-middle mr-2"></i>삭제</button>
                                        	<button type="button" class="btn btn-light"><i class="fa fa-mail-forward font-18 align-middle mr-2"></i>전달</button>
                                        	<button type="button" class="btn btn-light"><i class="fa fa-envelope-open font-18 align-middle mr-2"></i>읽음</button>
                                        	<button aria-expanded="false" data-toggle="dropdown" class="btn btn-dark dropdown-toggle" type="button">More <span class="caret m-l-5"></span>
                                            </button>
                                    	</div> -->
										<table class="table table-striped table-bordered sung">
										<!-- hidden-sm hidden-xs 숨기기 -->
											<thead class="bg-primary" style="text-align: center; color:white;">
												<th width="15%" style="">작성일</th>
												<th width="10%" >수신자</th>
												<th width="55%">제목</th>
												<th width="10%">읽음 여부</th>
											</thead>
										</table>
                                    </div>
                                    <hr>
                                    <div class="email-list m-t-15">
                                    	<form action="" name="mailFrm">
											<input type="hidden" name="pageNum" id="pageNum" value="${vo.pageNum}" />
											<input type="hidden" id="searchWord" name="searchWord"value="kimmj" />
											<table id="listTable" class="table table-striped table-bordered">
												
												<tbody>
													<c:choose>
														<c:when test="${list.size()>0 }">
															<c:forEach var="vo" items="${list}">
																<tr style="text-align: center;">
																	<td width="15%"><c:out value="${vo.recDate}"></c:out></td>
																	<td width="10%"><c:out value="${vo.recipient}"></c:out></td>
																	<td width="55%" style="text-align: left;"><c:out value="${vo.title}"></c:out></td>
																	<td width="10%">
																		<c:choose>
																				<c:when test="${vo.read =='9'}">
																					<c:out value="읽음"></c:out>
																				</c:when>
																				<c:otherwise>
																					<c:out value="읽지 않음"></c:out>
																				</c:otherwise>
																		</c:choose>
																	</td>
																	<td style="display: none;"><c:out value="${vo.mailId}" />
																		<input type="hidden" id="mailId" name="mailId" value="${vo.mailId}" />
																	</td>
																</tr>
															</c:forEach>
														</c:when>
														<c:otherwise>
															<tr>
																<td class="text-center">No data found.</td>
															</tr>
														</c:otherwise>
													</c:choose>
												</tbody>
											</table>
										</form>
                                    </div>
                                    <!-- panel -->
                                    <!-- pagenation -->
									<div class="text-center">
										<%=StringUtil.renderPaging(maxNum, currPageNo, rowPerPage, bottomCount, url, scriptName)%>
									</div>
									<!--// pagenation -->
                                    <!-- <div class="row">
                                        <div class="col-7">
                                            <div class="text-left">1 - 20 of 568</div>
                                        </div>
                                        <div class="col-5">
                                            <div class="btn-group float-right">
                                                <button class="btn btn-gradient" type="button"><i class="fa fa-angle-left"></i>
                                                </button>
                                                <button class="btn btn-dark" type="button"><i class="fa fa-angle-right"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </div> -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- #/ container -->
        </div>
        <!--**********************************
            Content body end
        ***********************************-->
        
        
        <!--**********************************
            Footer start
        ***********************************-->
        <div class="footer">
            <%@ include file="/common/april_footer.jsp" %>
        </div>
        <!--**********************************
            Footer end
        ***********************************-->
    </div>
    <!--**********************************
        Main wrapper end
    ***********************************-->

    <!--**********************************
        Scripts
    ***********************************-->
    <script src="${aprilContext}/views/plugins/common/common.min.js"></script>
    <script src="${aprilContext}/views/js/custom.min.js"></script>
    <script src="${aprilContext}/views/js/settings.js"></script>
    <script src="${aprilContext}/views/js/gleek.js"></script>
    <script src="${aprilContext}/views/js/styleSwitcher.js"></script>
    
    <script type="text/javascript">

    function doRetrieve() {
		var searchWord = "";
		//location.href = "${aprilContext}/mail/do_retrieve.do?pageNum=1&pageSize=10&searchDiv=&searchWord="+ searchWord;
		location.href = "${aprilContext}/mail/do_retrieve.do?pageNum=1&pageSize=10&searchDiv=&searchWord=${user.id}";
	}

	
    function doSearchPage(url,no){
        var frm = document.mailFrm;
        frm.pageNum.value= no;
        frm.action= url;
        console.log("no: "+no);
        console.log("url: "+url);
        frm.submit();
    }
    
    //--메일 list 중 하나 선택했을 때 메일 읽기 페이지로 넘어가는 기능 Start
	$("#listTable").on("click","tr",function() {
		//console.log("haha #listTable>tbody");
		var trs = $(this);
		var tds = trs.children();
		var mailId = tds.eq(4).text();
		console.log("mailId = " + mailId);
		location.href = "${aprilContext}/mail/do_selectOneSent.do?mailId="+ mailId;

		//console.log("mailId = "+mailId);
		//$("#mailIdInput").val(mailId);
		//var frm = document.mailFrm;
		//console.log("mailIdInput.val() = "+$("#mailIdInput").val());
		////frm.mailId.value = mailId;
		//frm.action="${aprilContext}/mail/do_selectOne.do?mailId="+mailId;
		//frm.submit();

	});
	//--메일 list 중 하나 선택했을 때 메일 읽기 페이지로 넘어가는 기능 End
	
    </script>

</body>

</html>