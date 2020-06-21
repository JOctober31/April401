<%--
/**
  * Class Name : chat_list
  * Description : 채팅 메인페이지 사원목록 조회
  * http://localhost:8080/groupware/chat/do_retrieve.do?pageNum=1&pageSize=10&searchDiv=&searchWord= 
  * Modification Information
  *
  *   수정일                   수정자                      수정내용
  *  -------    --------    ---------------------------
  *  2020.5.7.           	 최초 생성
  *
  * 
  *
  * Copyright (C) 2009 by KandJang  All right reserved.
  */
--%>
<%@page import="com.april.groupware.cmn.StringUtil"%>
<%@page import="com.april.groupware.cmn.SearchVO"%>
<%@page import="com.april.groupware.chat.service.ChatVO"%>
<%@page import="com.april.groupware.code.service.CodeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/views/common/common.jsp"%>
<%
	//페이지 사이즈
String pageSize = "10";
//페이지 num
String pageNum = "1";
//검색구분
String searchDiv = "";
//검색어
String searchWord = "";

SearchVO search = (SearchVO) request.getAttribute("vo");
if (null != search) {
	pageSize = String.valueOf(search.getPageSize());
	pageNum = String.valueOf(search.getPageNum());
	searchDiv = search.getSearchDiv();
	searchWord = search.getSearchWord();
}

List<CodeVO> searchList = (List<CodeVO>) request.getAttribute("searchList");
//out.print("searchList:"+searchList);
for (CodeVO vo : searchList) {
	//out.print(vo.toString()+"<br/>");
}

//pageSizeList
List<CodeVO> pageSizeList = (List<CodeVO>) request.getAttribute("pageSizeList");
//out.print("pageSizeList:"+pageSizeList);
for (CodeVO vo : pageSizeList) {
	//out.print(vo.toString()+"<br/>");
}

int totalCnt = 0;

totalCnt = (Integer) request.getAttribute("totalCnt");
//out.print("totalCnt:"+totalCnt);

//paging
String url = H_PATH + "/chat/do_retrieve.do";
String scriptName = "doSeachPage";
int maxNum = 0;//총글수
int currPageNo = 1;//현재페이지 
int rowPerPage = 10;
int bottomCount = 5;//바닫에 page

if (null != search) {
	currPageNo = search.getPageNum();
	rowPerPage = search.getPageSize();
	maxNum = totalCnt;
}
//--paging
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Quixlab - Bootstrap Admin Dashboard Template by
	Themefisher.com</title>
<!-- Favicon icon -->
<link rel="icon" type="image/png" sizes="16x16"
	href="${hContext}/views/images/favicon.png">
<!-- Custom Stylesheet -->
<link href="${hContext}/views/css/style.css" rel="stylesheet">

</head>

<body>

	<!--*******************
        Preloader start
    ********************-->
	<div id="preloader">
		<div class="loader">
			<svg class="circular" viewBox="25 25 50 50">
                <circle class="path" cx="50" cy="50" r="20" fill="none"
					stroke-width="3" stroke-miterlimit="10" />
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
			<div class="brand-logo">
				<a href="index.html"> <b class="logo-abbr"><img
						src="${aprilContext}/views/images/logo.png" alt=""> </b> <span
					class="logo-compact"><img
						src="${aprilContext}/views/images/logo-compact.png" alt=""></span>
					<span class="brand-title"> <img
						src="${aprilContext}/views/images/logo-text.png" alt="">
				</span>
				</a>
			</div>
		</div>
		<!--**********************************
            Nav header end
        ***********************************-->

		<!--**********************************
            Header start
        ***********************************-->
		<div class="header">
			<%@ include file="/common/april_header.jsp"%>
		</div>
		<!--**********************************
            Header end ti-comment-alt
        ***********************************-->

		<!--**********************************
            Sidebar start
        ***********************************-->
		<div class="nk-sidebar">
			<%@ include file="/common/april_sidebar.jsp"%>
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
						<li class="breadcrumb-item"><a href="javascript:void(0)">Dashboard</a></li>
						<li class="breadcrumb-item active"><a
							href="javascript:void(0)">Home</a></li>
					</ol>
				</div>
			</div>
			<!-- row -->
			<div class="container-fluid">
				<div class="row">
					<!-- 본인 정보란 -->
					<div class="col-lg-6">
						<div class="card" style="margin-bottom: 0px;">
							<div class="card-body"
								style="padding: 20px; padding-bottom: 38px;">
								<div class="media align-items-center mb-4" style="padding-left: 20px; margin-bottom: 0px;">
									<img class="mr-3" src="${hContext}/views/images/avatar/11.png"
										width="80" height="80" alt="">
									<div class="media-body" style="padding-left: 20px;">
										<table>
											<tbody>
												<tr>
													<td><strong class="text-dark mr-4">&emsp;이름</strong><span>${user.name }</span></td>
												</tr>
												<tr>
													<td class="mb-1"><strong class="text-dark mr-4">&emsp;부서</strong><span>${user.deptNm }</span></td>
												</tr>
												<tr>
													<td class="mb-1"><strong class="text-dark mr-4">&emsp;직급</strong><span>${user.position }</span></td>
												</tr>
												<tr>
													<td class="mb-1"><strong class="text-dark mr-4">&ensp;Email</strong><span>${user.email }</span></td>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- /본인 정보란 -->
					<!-- 채팅방 -->
					<div class="col-lg-3">
						<div class="card text-center">
							<div class="card-body">
								<h5 class="card-title">인사팀</h5>
								<p class="card-text">인사팀 채팅방입니다</p>
								<a href="${hContext}/chat/groupchat02.do"
									class="btn btn-primary">참여하기</a>
							</div>
						</div>
					</div>
					<!-- //채팅방  -->
					<!-- 채팅방 -->
					<div class="col-lg-3">
						<div class="card text-center">
							<div class="card-body">
								<h5 class="card-title">개발팀</h5>
								<p class="card-text">테스트 중입니다</p>
								<a href="${hContext}/chat/groupcha02t.do"
									class="btn btn-primary">참여하기</a>
							</div>
						</div>
					</div>
					<!-- //채팅방  -->
				</div>
				<!-- /row -->

				<!-- /부서검색박스 -->
				<div class="row">
					<div class="col-lg-6">
						<div class="card" style="margin-bottom: 20px;">
							<div class="card-body" style="padding: 20px;">
								<!-- 부서검색박스 -->
								<form action="${hContext}/chat/do_retrieve.do" name="dNameForm"
									method="get" class="form-inline" onchange="doRetrieve();"
									style="padding-left: 5%; padding-top: 10px; padding-bottom: 10px;">
									<strong class="text-dark mr-3">부서 선택&ensp;</strong> <input
										type="hidden" name="pageSize" id="pageSize"
										value="${vo.pageSize }" /> <input type="hidden"
										name="pageNum" id="pageNum" value="${vo.pageNum }" /> <input
										type="hidden" name="searchWord" id="searchWord" />
									<%=StringUtil.makeSelectBox(searchList, "searchDiv", searchDiv, true)%>
								</form>
								<!-- /부서검색박스 -->
								<!-- 사원목록테이블 -->
								<div class="table-responsive">
									<table id="listTable"
										class="table header-border table-hover verticle-middle">
										<!-- hidden-sm hidden-xs 숨기기 -->
										<thead>
											<tr>
												<th class="text-center">이름</th>
												<th class="text-center">부서</th>
												<th class="text-center">직급</th>
											</tr>
										</thead>
										<tbody>
											<c:choose>
												<c:when test="${list.size()>0 }">
													<c:forEach var="vo" items="${list }">
														<tr style="text-align: center;">
														    <input type="hidden" id="id" name="id" value="${vo.id}" />
															<td style="display: none;"><c:out value="${vo.id}" />
															<td class="text-center"><c:out value="${vo.name }" />
															<td class="text-center"><c:out value="${vo.dept_Nm }" />
															<td class="text-center hidden-sm hidden-xs  "><c:out value="${vo.position }" />
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
								</div>
								<!-- pagenation -->
								<nav>
									<ul class="pagination justify-content-center">
										<div class="text-center"
											style="margin-top: 10px; margin-bottom: 10px;">
											<%=StringUtil.renderPaging(maxNum, currPageNo, rowPerPage, bottomCount, url, scriptName)%>
										</div>
									</ul>
								</nav>
								<!--// pagenation -->
							</div>
						</div>
						<!-- /사원목록테이블 -->
					</div>

					<!-- 채팅방 -->
					<div class="col-lg-3">
						<div class="card text-center">
							<div class="card-body">
								<h5 class="card-title">운영팀</h5>
								<p class="card-text">운영팀 채팅방입니다</p>
								<a href="${hContext}/chat/groupchat02.do"
									class="btn btn-primary">참여하기</a>
							</div>
						</div>
						<div class="card text-center">
							<div class="card-body">
								<h5 class="card-title">스쿠버다이빙 동호회</h5>
								<p class="card-text">바다를 사랑하는 사람들</p>
								<a href="${hContext}/chat/groupchat03.do"
									class="btn btn-success text-white">참여하기</a>
							</div>
						</div>
						<div class="card text-center">
							<div class="card-body">
								<h5 class="card-title">사이클링 동호회</h5>
								<p class="card-text">서울 위주에서 모이며 소규모로 모여 달리는 사이클링 모임입니다</p>
								<a href="${hContext}/chat/groupchat03.do"
									class="btn btn-success text-white">참여하기</a>
							</div>
						</div>
					</div>
					<!-- //채팅방  -->
					<!-- 채팅방 -->
					<div class="col-lg-3">
						<div class="card text-center">
							<div class="card-body">
								<h5 class="card-title">영업팀</h5>
								<p class="card-text">영업팀 채팅방입니다</p>
								<a href="${hContext}/chat/groupchat02.do"
									class="btn btn-primary">참여하기</a>
							</div>
						</div>
						<div class="card text-center">
							<div class="card-body">
								<h5 class="card-title">문사모</h5>
								<p class="card-text">문화를 사랑하는 사람들이 삼삼오오 모여 연극, 뮤지컬, 공연을 즐기는
									모임입니다</p>
								<a href="${hContext}/chat/groupchat03.do"
									class="btn btn-success text-white">참여하기</a>
							</div>
						</div>
					</div>
					<!-- //채팅방  -->
				</div>
				<!-- //row2 -->
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
		<%@ include file="/common/april_footer.jsp"%>
	</div>
	<!--**********************************
            Footer end
        ***********************************-->
	<!--**********************************
        Main wrapper end
    ***********************************-->
	<!--**********************************
        Scripts
    ***********************************-->
	<script src="${hContext}/views/plugins/common/common.min.js"></script>
	<script src="${hContext}/views/js/custom.min.js"></script>
	<script src="${hContext}/views/js/settings.js"></script>
	<script src="${hContext}/views/js/gleek.js"></script>
	<script src="${hContext}/views/js/styleSwitcher.js"></script>
	<%-- <script src="${hContext}/views/js/swiper.jquery.js"></script> --%>

	<script type="text/javascript">

	
	
		//--셀렉트박스 list 중 하나 선택했을 때 메일 읽기 페이지로 넘어가기
		function doRetrieve() {
			//console.log($("#dNameList option:selected").val());
			//console.log("doRetrieve");
			var frm = document.dNameForm;
			frm.searchDiv.value = $("#searchDiv option:selected").val();
			/* frm.searchWord.value = ""; 
			frm.pageSize.value = 10;
			frm.pageNum.value = 1;  */
			frm.action = "${hContext}/chat/do_retrieve.do";
			frm.submit();
		}

		function doSeachPage(url, no) {
			console.log("#url:" + url);
			console.log("#no:" + no);

			var frm = document.dNameForm;
			frm.pageNum.value = no;
			frm.action = url;
			frm.submit();
		}
	
		//--사원목록에서 하나를 선택했을 때 해당 사원의 정보를 띄움
		 $("#listTable>tbody").on("click", "tr", function() {
			console.log("#listTable>tbody");
			var trs = $(this);
			var tds = trs.children();
			var id = tds.eq(0).text();
			console.log("id = " + id);
			location.href = "${hContext}/chat/do_selectOne.do?id=" + id;

		});
 		//끝
 		
	</script>
</body>
</html>