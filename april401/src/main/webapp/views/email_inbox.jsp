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
  * http://localhost:8080/groupware/mail/do_retrieve.do?pageNum=1&pageSize=10&searchDiv=&searchWord=honggd01
  *
  * Copyright (C) 2009 by KandJang  All right reserved.
  */
--%>
<%@page import="com.april.groupware.member.service.UserVO"%>
<%@page import="com.april.groupware.cmn.StringUtil"%>
<%@page import="com.april.groupware.cmn.SearchVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

UserVO userVO = (UserVO)session.getAttribute("user");

//검색어
String searchWord = userVO.getId();

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
String url = H_PATH + "/mail/do_retrieve.do"; //H_PATH: common.jsp에 있음(ehr)
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
<link rel="icon" type="image/png" sizes="16x16"
	href="${aprilContext}/views/images/favicon.png">
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
			<%@ include file="/common/april_logo.jsp" %>
			<%-- <div class="brand-logo">
                <a>
                    <b class="logo-abbr"><img src="${hContext}/views/images/logo.png" alt=""> </b>
                    <span class="logo-compact"><img src="${hContext}/views/images/logo-compact.png" alt=""></span>
                    <span class="brand-title">
                        <img src="${hContext}/views/images/april_logo.png" alt="">
                    </span>
                </a>
            </div> --%>
			<%-- <div class="brand-logo">
				<a href="index.html"> <b class="logo-abbr"><img
						src="${aprilContext}/views/images/logo.png" alt=""> </b> <span
					class="logo-compact"><img
						src="${aprilContext}/views/images/logo-compact.png" alt=""></span>
					<span class="brand-title"> <img
						src="${aprilContext}/views/images/logo-text.png" alt="">
				</span>
				</a>
			</div> --%>
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
						<li class="breadcrumb-item active"><a
							href="javascript:doRetrieve();">메일</a></li>
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
									<a href="${aprilContext}/views/email_compose.jsp"
										class="btn btn-primary btn-block">메일 쓰기</a>
									<div class="mail-list mt-4">
										<a href="${aprilContext}/mail/do_retrieve.do?pageNum=1&pageSize=10&searchDiv=&searchWord=${user.id}"
											class="list-group-item border-0 text-primary p-r-0"><i
											class="fa fa-inbox font-18 align-middle mr-2"></i> <b>받은
												메일함</b> <span
											class="badge badge-primary badge-sm float-right m-t-5"><c:out value="${count}"></c:out></span>
										</a> <a href="${aprilContext}/mail/do_retrieveSent.do?pageNum=1&pageSize=10&searchDiv=&searchWord=${user.id}"
											class="list-group-item border-0 p-r-0"><i
											class="fa fa-paper-plane font-18 align-middle mr-2"></i>보낸
											메일함</a> 
										<!-- 
                                        <a href="#" class="list-group-item border-0 p-r-0"><i class="mdi mdi-file-document-box font-18 align-middle mr-2"></i>Draft</a>
                                         -->
										<a href="${aprilContext}/mail/do_retrieveTrash.do?pageNum=1&pageSize=10&searchDiv=&searchWord=${user.id}" class="list-group-item border-0 p-r-0"><i
											class="fa fa-trash font-18 align-middle mr-2"></i>휴지통</a>
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
										<div class="btn-group">
											<button type="button" id="resend_btn" class="btn btn-light">
												<i class="fa fa-mail-reply font-18 align-middle mr-2"></i>답장
											</button>
											<button type="button" id="delete_btn" class="btn btn-light">
												<i class="fa fa-trash font-18 align-middle mr-2"></i>삭제
											</button>
											<button type="button" id="read" class="btn btn-light">
												<i class="fa fa-envelope-open font-18 align-middle mr-2"></i>읽음
											</button>
											<!-- 
                                        	<button aria-expanded="false" data-toggle="dropdown" class="btn btn-dark dropdown-toggle" type="button">More <span class="caret m-l-5"></span>
                                            </button>
                                            <div class="dropdown-menu"><span class="dropdown-header">More Option :</span>  
                                            	<a href="javascript: void(0);" class="dropdown-item">Mark as Unread</a>  
                                            	<a href="javascript: void(0);" class="dropdown-item">Add to Tasks</a>  
                                            	<a href="javascript: void(0);" class="dropdown-item">Add Star</a>  
                                            	<a href="javascript: void(0);" class="dropdown-item">Mute</a>
                                            </div>
                                        	 -->
										</div>
									</div>
									<hr>
									<div class="email-list m-t-15">
										<form action="" name="mailFrm">
											<input type="hidden" name="pageNum" id="pageNum" value="${vo.pageNum}" />
											<input type="hidden" id="searchWord" name="searchWord" value="${user.id}" />
											<table id="listTable"
												class="table table-striped table-bordered">
												<tbody>
													<c:choose>
														<c:when test="${list.size()>0 }">
															<c:forEach var="vo" items="${list}">
																<tr style="text-align: center;">
																	<td width="3%"><input type="checkbox" onclick="event.cancelBubble=true" name="checkbox" value="${vo.mailId}">
																	</td>
																	<td width="4%">
																		<c:choose>
																			<c:when test="${vo.read =='9'}">
																				<i class="fa fa-envelope-open-o font-18 align-middle mr-10"></i>
																			</c:when>
																			<c:otherwise>
																				<i class="fa fa-envelope font-18 align-middle mr-10" style="color: #7571F9"></i>
																			</c:otherwise>
																		</c:choose>
																	</td>
																	<td width="10%">
																		<c:choose>
																			<c:when test="${vo.read =='9'}">
																				<c:out value="${vo.sender}" />
																			</c:when>
																			<c:otherwise>
																				<b style="color: #7571F9"><c:out
																						value="${vo.sender}" /></b>
																			</c:otherwise>
																		</c:choose></td>
																	<td width="55%" style="text-align: left;">
																		<c:choose>
																			<c:when test="${vo.read =='9'}">
																				<c:out value="${vo.title}" />
																			</c:when>
																			<c:otherwise>
																				<b style="color: #7571F9"><c:out
																						value="${vo.title}" /></b>
																			</c:otherwise>
																		</c:choose></td>
																	<td width="15%">
																		<c:choose>
																			<c:when test="${vo.read =='9'}">
																				<c:out value="${vo.recDate}" />
																			</c:when>
																			<c:otherwise>
																				<b style="color: #7571F9"><c:out
																						value="${vo.recDate}" /></b>
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
										<!-- 
                                    	<div class="message">
                                            <a href="email-read.html">
                                                <div class="col-mail col-mail-1">
                                                    <div class="email-checkbox">
                                                        <input type="checkbox" id="chk2">
                                                        <label class="toggle" for="chk2"></label>
                                                    </div>
                                                    <span class="star-toggle ti-star"></span>
                                                </div>
                                                <div class="col-mail col-mail-2">
                                                    <div class="subject">Ingredia Nutrisha, A collection of textile samples lay spread out on the table - Samsa was a travelling salesman - and above it there hung a picture</div>
                                                    <div class="date">11:49 am</div>
                                                </div>
                                            </a>
                                        </div>
                                    	 -->
										<!-- 
                                        <div class="message">
                                            <a href="email-read.html">
                                                <div class="col-mail col-mail-1">
                                                    <div class="email-checkbox">
                                                        <input type="checkbox" id="chk2">
                                                        <label class="toggle" for="chk2"></label>
                                                    </div>
                                                    <span class="star-toggle ti-star"></span>
                                                </div>
                                                <div class="col-mail col-mail-2">
                                                    <div class="subject">Ingredia Nutrisha, A collection of textile samples lay spread out on the table - Samsa was a travelling salesman - and above it there hung a picture</div>
                                                    <div class="date">11:49 am</div>
                                                </div>
                                            </a>
                                        </div>
                                        <div class="message">
                                            <a href="email-read.html">
                                                <div class="col-mail col-mail-1">
                                                    <div class="email-checkbox">
                                                        <input type="checkbox" id="chk3">
                                                        <label class="toggle" for="chk3"></label>
                                                    </div><span class="star-toggle ti-star"></span>
                                                </div>
                                                <div class="col-mail col-mail-2">
                                                    <div class="subject">Almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar.</div>
                                                    <div class="date">11:49 am</div>
                                                </div>
                                            </a>
                                        </div>
                                        <div class="message">
                                            <a href="email-read.html">
                                                <div class="col-mail col-mail-1">
                                                    <div class="email-checkbox">
                                                        <input type="checkbox" id="chk4">
                                                        <label class="toggle" for="chk4"></label>
                                                    </div><span class="star-toggle ti-star"></span>
                                                </div>
                                                <div class="col-mail col-mail-2">
                                                    <div class="subject">Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of</div>
                                                    <div class="date">11:49 am</div>
                                                </div>
                                            </a>
                                        </div>
                                        <div class="message">
                                            <a href="email-read.html">
                                                <div class="col-mail col-mail-1">
                                                    <div class="email-checkbox">
                                                        <input type="checkbox" id="chk5">
                                                        <label class="toggle" for="chk5"></label>
                                                    </div><span class="star-toggle ti-star"></span>
                                                </div>
                                                <div class="col-mail col-mail-2">
                                                    <div class="subject">Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of</div>
                                                    <div class="date">11:49 am</div>
                                                </div>
                                            </a>
                                        </div>
                                        <div class="message">
                                            <a href="email-read.html">
                                                <div class="col-mail col-mail-1">
                                                    <div class="email-checkbox">
                                                        <input type="checkbox" id="chk6">
                                                        <label class="toggle" for="chk6"></label>
                                                    </div><span class="star-toggle ti-star"></span>
                                                </div>
                                                <div class="col-mail col-mail-2">
                                                    <div class="subject">Ingredia Nutrisha, A collection of textile samples lay spread out on the table - Samsa was a travelling salesman - and above it there hung a picture</div>
                                                    <div class="date">11:49 am</div>
                                                </div>
                                            </a>
                                        </div>
                                        <div class="message">
                                            <a href="email-read.html">
                                                <div class="col-mail col-mail-1">
                                                    <div class="email-checkbox">
                                                        <input type="checkbox" id="chk7">
                                                        <label class="toggle" for="chk7"></label>
                                                    </div><span class="star-toggle ti-star"></span>
                                                </div>
                                                <div class="col-mail col-mail-2">
                                                    <div class="subject">Almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar.</div>
                                                    <div class="date">11:49 am</div>
                                                </div>
                                            </a>
                                        </div>
                                        <div class="message">
                                            <a href="email-read.html">
                                                <div class="col-mail col-mail-1">
                                                    <div class="email-checkbox">
                                                        <input type="checkbox" id="chk8">
                                                        <label class="toggle" for="chk8"></label>
                                                    </div><span class="star-toggle ti-star"></span>
                                                </div>
                                                <div class="col-mail col-mail-2">
                                                    <div class="subject">Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of</div>
                                                    <div class="date">11:49 am</div>
                                                </div>
                                            </a>
                                        </div>
                                        <div class="message unread">
                                            <a href="email-read.html">
                                                <div class="col-mail col-mail-1">
                                                    <div class="email-checkbox">
                                                        <input type="checkbox" id="chk9">
                                                        <label class="toggle" for="chk9"></label>
                                                    </div><span class="star-toggle ti-star"></span>
                                                </div>
                                                <div class="col-mail col-mail-2">
                                                    <div class="subject">Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of</div>
                                                    <div class="date">11:49 am</div>
                                                </div>
                                            </a>
                                        </div>
                                        <div class="message unread">
                                            <a href="email-read.html">
                                                <div class="col-mail col-mail-1">
                                                    <div class="email-checkbox">
                                                        <input type="checkbox" id="chk10">
                                                        <label class="toggle" for="chk10"></label>
                                                    </div><span class="star-toggle ti-star"></span>
                                                </div>
                                                <div class="col-mail col-mail-2">
                                                    <div class="subject">Ingredia Nutrisha, A collection of textile samples lay spread out on the table - Samsa was a travelling salesman - and above it there hung a picture</div>
                                                    <div class="date">11:49 am</div>
                                                </div>
                                            </a>
                                        </div>
                                        <div class="message">
                                            <a href="email-read.html">
                                                <div class="col-mail col-mail-1">
                                                    <div class="email-checkbox">
                                                        <input type="checkbox" id="chk11">
                                                        <label class="toggle" for="chk11"></label>
                                                    </div><span class="star-toggle ti-star"></span>
                                                </div>
                                                <div class="col-mail col-mail-2">
                                                    <div class="subject">Almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar.</div>
                                                    <div class="date">11:49 am</div>
                                                </div>
                                            </a>
                                        </div>
                                        <div class="message">
                                            <a href="email-read.html">
                                                <div class="col-mail col-mail-1">
                                                    <div class="email-checkbox">
                                                        <input type="checkbox" id="chk12">
                                                        <label class="toggle" for="chk12"></label>
                                                    </div><span class="star-toggle ti-star"></span>
                                                </div>
                                                <div class="col-mail col-mail-2">
                                                    <div class="subject">Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of</div>
                                                    <div class="date">11:49 am</div>
                                                </div>
                                            </a>
                                        </div>
                                        <div class="message">
                                            <a href="email-read.html">
                                                <div class="col-mail col-mail-1">
                                                    <div class="email-checkbox">
                                                        <input type="checkbox" id="chk13">
                                                        <label class="toggle" for="chk13"></label>
                                                    </div><span class="star-toggle ti-star"></span>
                                                </div>
                                                <div class="col-mail col-mail-2">
                                                    <div class="subject">Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of</div>
                                                    <div class="date">11:49 am</div>
                                                </div>
                                            </a>
                                        </div>
                                        <div class="message">
                                            <a href="email-read.html">
                                                <div class="col-mail col-mail-1">
                                                    <div class="email-checkbox">
                                                        <input type="checkbox" id="chk14">
                                                        <label class="toggle" for="chk14"></label>
                                                    </div><span class="star-toggle ti-star"></span>
                                                </div>
                                                <div class="col-mail col-mail-2">
                                                    <div class="subject">Ingredia Nutrisha, A collection of textile samples lay spread out on the table - Samsa was a travelling salesman - and above it there hung a picture</div>
                                                    <div class="date">11:49 am</div>
                                                </div>
                                            </a>
                                        </div>
                                        <div class="message unread">
                                            <a href="email-read.html">
                                                <div class="col-mail col-mail-1">
                                                    <div class="email-checkbox">
                                                        <input type="checkbox" id="chk15">
                                                        <label class="toggle" for="chk15"></label>
                                                    </div><span class="star-toggle ti-star"></span>
                                                </div>
                                                <div class="col-mail col-mail-2">
                                                    <div class="subject">Almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar.</div>
                                                    <div class="date">11:49 am</div>
                                                </div>
                                            </a>
                                        </div>
                                        <div class="message">
                                            <a href="email-read.html">
                                                <div class="col-mail col-mail-1">
                                                    <div class="email-checkbox">
                                                        <input type="checkbox" id="chk16">
                                                        <label class="toggle" for="chk16"></label>
                                                    </div><span class="star-toggle ti-star"></span>
                                                </div>
                                                <div class="col-mail col-mail-2">
                                                    <div class="subject">Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of</div>
                                                    <div class="date">11:49 am</div>
                                                </div>
                                            </a>
                                        </div>
                                        <div class="message">
                                            <a href="email-read.html">
                                                <div class="col-mail col-mail-1">
                                                    <div class="email-checkbox">
                                                        <input type="checkbox" id="chk17">
                                                        <label class="toggle" for="chk17"></label>
                                                    </div><span class="star-toggle ti-star"></span>
                                                </div>
                                                <div class="col-mail col-mail-2">
                                                    <div class="subject">Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of</div>
                                                    <div class="date">11:49 am</div>
                                                </div>
                                            </a>
                                        </div>
                                        <div class="message">
                                            <a href="email-read.html">
                                                <div class="col-mail col-mail-1">
                                                    <div class="email-checkbox">
                                                        <input type="checkbox" id="chk18">
                                                        <label class="toggle" for="chk18"></label>
                                                    </div><span class="star-toggle ti-star"></span>
                                                </div>
                                                <div class="col-mail col-mail-2">
                                                    <div class="subject">Ingredia Nutrisha, A collection of textile samples lay spread out on the table - Samsa was a travelling salesman - and above it there hung a picture</div>
                                                    <div class="date">11:49 am</div>
                                                </div>
                                            </a>
                                        </div>
                                        <div class="message">
                                            <a href="email-read.html">
                                                <div class="col-mail col-mail-1">
                                                    <div class="email-checkbox">
                                                        <input type="checkbox" id="chk19">
                                                        <label class="toggle" for="chk19"></label>
                                                    </div><span class="star-toggle ti-star"></span>
                                                </div>
                                                <div class="col-mail col-mail-2">
                                                    <div class="subject">Almost unorthographic life One day however a small line of blind text by the name of Lorem Ipsum decided to leave for the far World of Grammar.</div>
                                                    <div class="date">11:49 am</div>
                                                </div>
                                            </a>
                                        </div>
                                        <div class="message unread">
                                            <a href="email-read.html">
                                                <div class="col-mail col-mail-1">
                                                    <div class="email-checkbox">
                                                        <input type="checkbox" id="chk20">
                                                        <label class="toggle" for="chk20"></label>
                                                    </div><span class="star-toggle ti-star"></span>
                                                </div>
                                                <div class="col-mail col-mail-2">
                                                    <div class="subject">Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of</div>
                                                    <div class="date">11:49 am</div>
                                                </div>
                                            </a>
                                        </div>
                                        <div class="message">
                                            <a href="email-read.html">
                                                <div class="col-mail col-mail-1">
                                                    <div class="email-checkbox">
                                                        <input type="checkbox" id="chk21">
                                                        <label class="toggle" for="chk21"></label>
                                                    </div><span class="star-toggle ti-star"></span>
                                                </div>
                                                <div class="col-mail col-mail-2">
                                                    <div class="subject">Even the all-powerful Pointing has no control about the blind texts it is an almost unorthographic life One day however a small line of blind text by the name of</div>
                                                    <div class="date">11:49 am</div>
                                                </div>
                                            </a>
                                        </div>
                                         -->

									</div>
									<!-- panel -->
									<!-- pagenation -->
									<div class="text-center">
										<%=StringUtil.renderPaging(maxNum, currPageNo, rowPerPage, bottomCount, url, scriptName)%>
									</div>
									<!--// pagenation -->
									<!-- 
                                    <div class="row">
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
                                    </div>
                                    -->

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
			var searchWord = ${user.id};
			location.href = "${aprilContext}/mail/do_retrieve.do?pageNum=1&pageSize=10&searchDiv=&searchWord="+searchWord;
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
			var mailId = tds.eq(5).text();
			console.log("mailId = " + mailId);
			location.href = "${aprilContext}/mail/do_selectOne.do?mailId="+ mailId;

			//console.log("mailId = "+mailId);
			//$("#mailIdInput").val(mailId);
			//var frm = document.mailFrm;
			//console.log("mailIdInput.val() = "+$("#mailIdInput").val());
			////frm.mailId.value = mailId;
			//frm.action="${aprilContext}/mail/do_selectOne.do?mailId="+mailId;
			//frm.submit();

		});
		//--메일 list 중 하나 선택했을 때 메일 읽기 페이지로 넘어가는 기능 End

		//--삭제 btn Start
		$("#delete_btn").on("click",function() {
			var checkbox = document
					.getElementsByName("checkbox");
			var checkLength = checkbox.length;
			//console.log("checkbox.value : "+checkbox.value);

			if (!confirm("선택한 메일을 삭제하시겠습니까?"))
				return;

			var cnt = 0;
			var cntCh = 0;
			for (var i = 0; i < checkLength; i++) {
				if (checkbox[i].checked == true) {
					var mailId = checkbox[i].value;
					console.log("mailId : " + mailId);
					cntCh += 1;

					//ajax
					$.ajax({
						type : "POST",
						url : "${pageContext.request.contextPath }/mail/do_updateDisable.do",
						dataType : "html",
						async : false,
						data : {
							"mailId" : mailId
						},
						success : function(data) { //성공
							//{"msgId":"1","msgMsg":"삭제 되었습니다.","num":0,"totalCnt":0}
							//alert(data);

							var jData = JSON.parse(data);
							if (null != jData&& jData.msgId == "1") {
								//alert(data);
								cnt += 1;
							} else {

							}
						},
						error : function(xhr, status,error) {
							//{"msgId":"0","msgMsg":"삭제 실패.","num":0,"totalCnt":0}
							alert("error:" + error);
						},
						complete : function(data) {

						}

					});//--ajax
				}//--if
			}//--for

			if (cntCh == 0) {//선택된 게 없을 때
				alert("삭제할 메일을 선택해 주십시오.");
				return;
			}

			//console.log("cnt : "+cnt);
			//console.log("cntCh : "+cntCh);
			if (cnt == cntCh) {
				alert(cnt + "건의 메일이 삭제되었습니다.");
			} else {
				alert("삭제 실패하였습니다.");
			}

			//현재 페이지 새로 고침
			window.location.reload();

		});
		//--삭제 btn End

		//--답장 btn Start
		$("#resend_btn").on("click",function() {
			var checkbox = document.getElementsByName("checkbox");
			var checkLength = checkbox.length;
			var cnt = 0; //체크된 개수 셀 변수
			var checkMailId; //체크된 값 불러오기
			for (var i = 0; i < checkLength; i++) {
				if (checkbox[i].checked == true) {
					cnt += 1;
					checkMailId = checkbox[i].value;
					console.log("checkMailId : " + checkMailId);
				}
			}
			if (cnt == 1) {
				if (!confirm("선택하신 메일을 답장하시겠습니까?")) return;
				location.href = "${aprilContext}/mail/do_selectOneResend.do?mailId=" + checkMailId;
			} else if (cnt > 1) {
				alert("하나의 메일만 선택해 주세요.");
				return;
			} else {
				alert("답장할 메일을 선택해 주세요.");
				return;
			}

		});
		//--답장 btn End

		//--읽음 btn Start
		$("#read").on("click",function() {
			var checkbox = document.getElementsByName("checkbox");
			var checkLength = checkbox.length;
	
			if (!confirm("읽음 처리 하시겠습니까?"))
				return;
	
			var cnt = 0;
			var cntCh = 0;
			for (var i = 0; i < checkLength; i++) {
				if (checkbox[i].checked == true) {
					var mailId = checkbox[i].value;
					//var evelope = "evelope"+i;
					console.log("mailId : " + mailId);
					cntCh += 1;
	
					//ajax
					$.ajax({
						type : "POST",
						url : "${pageContext.request.contextPath }/mail/do_updateRead.do",
						dataType : "html",
						async : false,
						data : {
							"mailId" : mailId
						},
						success : function(data) { //성공
							//{"msgId":"1","msgMsg":"삭제 되었습니다.","num":0,"totalCnt":0}
							//alert(data);

							var jData = JSON.parse(data);
							if (null != jData&& jData.msgId == "1") {
								//alert(data);
								cnt += 1;
								//documnet.getElementById('evelope'+i).setAttribute('class','fa fa-envelope-open font-18 align-middle mr-10');
							} else {

							}
						},
						error : function(xhr, status,error) {
							//{"msgId":"0","msgMsg":"삭제 실패.","num":0,"totalCnt":0}
							alert("error:" + error);
						},
						complete : function(data) {

						}

					});//--ajax
				}//--if
			}//--for
	
			if (cntCh == 0) {//선택된 게 없을 때
				alert("읽음 처리 할 메일을 선택해 주십시오.");
				return;
			}
	
			//console.log("cnt : "+cnt);
			//console.log("cntCh : "+cntCh);
			if (cnt == cntCh) {
				alert(cnt + "건의 메일이 읽음 처리 되었습니다.");
			} else {
				alert("읽음 처리 실패하였습니다.");
			}
	
			//현재 페이지 새로 고침
			window.location.reload();
	
		});
		//--읽음 btn End
	</script>

</body>

</html>