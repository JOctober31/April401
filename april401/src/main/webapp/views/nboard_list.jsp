<%--
  /**
  * Class Name : nboard_list.jsp
  * Description : 전사 게시판 목록
    http://localhost:8080/groupware/nboard/do_retrieve.do?pageNum=1&pageSize=10&searchDiv=&searchWord=
  * Modification Information
  *
  *
  *   수정일                   수정자                      수정내용
  *  -------    --------    ---------------------------
  *
  * author 실행환경 개발팀
  * since 2009.01.06
  *
  * Copyright (C) 2009 by KandJang  All right reserved.
  */
--%>
<%@page import="com.april.groupware.member.service.UserVO"%>
<%@page import="com.april.groupware.cmn.StringUtil"%>
<%@page import="com.april.groupware.cmn.SearchVO"%>
<%@page import="com.april.groupware.code.service.CodeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/common/common.jsp"%>
<%
    //session
    /* UserVO userInfo = (UserVO) session.getAttribute("user");
    String auth = userInfo.getAuth();
    String id = userInfo.getId();
    out.print("auth : "+auth + " | ");
    out.print("id : "+id + " | "); */

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
    //out.print("search:"+search);
    
    List<CodeVO> searchList = (List<CodeVO>) request.getAttribute("searchList");
   // out.print("searchList:"+searchList);
   //     for(CodeVO vo:searchList){
   //        out.print(vo.toString()+"<br/>");
   //     } 
    
    //pageSizeList
    List<CodeVO> pageSizeList = (List<CodeVO>) request.getAttribute("pageSizeList");
   // out.print("pageSizeList:"+pageSizeList);
   //      for(CodeVO vo:pageSizeList){
   //         out.print(vo.toString()+"<br/>");
   //     }   
    
    int totalCnt = 0;
    
    totalCnt = (Integer) request.getAttribute("totalCnt");
    //out.print("totalCnt:"+totalCnt);

    //paging
    String url = H_PATH+"/nboard/do_retrieve.do";
    String scriptName = "doSeachPage";
    int maxNum =0;//총글수
    int currPageNo=1;//현재페이지 
    int rowPerPage=10;
    int bottomCount=10;//바닥에 page
    
    if(null !=search){
        currPageNo = search.getPageNum();
        rowPerPage = search.getPageSize();
        maxNum     = totalCnt;
    }
    //--paging

%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>April Groupware</title>
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="${hContext}/views/images/favicon.png">
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
            <div class="brand-logo">
                <a>
                    <b class="logo-abbr"><img src="${hContext}/views/images/logo.png" alt=""> </b>
                    <span class="logo-compact"><img src="${hContext}/views/images/logo-compact.png" alt=""></span>
                    <span class="brand-title">
                        <img src="${hContext}/views/images/april_logo.png" alt="">
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
                        <li class="breadcrumb-item"><a href="javascript:void(0)">커뮤니티</a></li>
                        <li class="breadcrumb-item active"><a href="javascript:void(0)">전사게시판</a></li>
                    </ol>
                </div>
            </div>
            <!-- row -->

            <div class="container-fluid">
	            <div class="bootstrap-label">
	               <div class="row">
	                    <div class="col-lg-12">
	                        <div class="card">
	                            <div class="card-body">
	                            <div class="card-title">
	                                <h4>전사게시판</h4><hr/>
	                            </div>
	                            
						        <!-- 검색영역 -->
	                            <div>
							        <div class="row">
							        	<div class="col-md-4"></div>
							            <div class="col-md-8">
							                <form action="${hContext}/nboard/do_retrieve.do" name="searchFrm" method="get">
							                    <input type="hidden" name="pageNum" id="pageNum" value="${vo.pageNum }">
							                    <input type="hidden" name="nbNo" id="nbNo" />
						                    	<div class="form-inline">
						                    		<div class="btn-group mr-2 mb-2">
									                    <!-- PageSize -->
								                        <%=StringUtil.makeSelectBox(pageSizeList, "pageSize", pageSize, false)%>
								                        &nbsp;&nbsp;
								                        <!-- SearchDiv -->
								                        <%=StringUtil.makeSelectBox(searchList, "searchDiv", searchDiv, true)%>
								                        &nbsp;&nbsp;
								                        <!-- 검색 -->
								                        <input type="text" style="height: 40;" class="form-control"  id="searchWord" name="searchWord" placeholder="검색어" value="${vo.searchWord }">
						                        		&nbsp;
						                        	</div>
						                        	<div class="mr-2 mb-2">
								                        <button style="text-align:center; height: 40px;" class="btn btn-primary" type="button" onclick="doRetrieve();">검색</button> 
														<!-- <button style="margin-right:0.5em; text-align:center; height: 40px;" 
			                                			class="btn mb-1 btn-light" type="button" onclick="doRetrieve();">조회</button> -->
							                        </div>
												</div>
							                </form>
										</div>
										<div class="col-md-11">
	                						<div class="form-inline mr-2 mb-2">
					                     		<button style="height: 40px; align-self: right;" class="btn btn-light" type="button" disabled="disabled">게시글 수 ${totalCnt }개</button>
					                     	</div>
										</div>
										<div class="col-md-1">
	                						<div class="form-inline mr-2 mb-2">
						                        <c:choose>
						                           <c:when test="${9 eq user.auth}">
						                              <button style="margin-left:1.5em; height: 40px;" class="btn btn-danger" type="button" onclick="doInsertView();">글작성</button>
						                           </c:when>
						                       </c:choose>
						                    </div>
						                </div>
						            </div>
						        </div>
						        <!--// 검색영역 -->
	
						        <!-- 게시글 목록 -->
								<div class="table-responsive">
									<table class="table header-border table-hover verticle-middle" id="listTable">
									<!-- <table class="table" id="listTable"> -->
										<thead class="bg-primary" style="text-align: center; color:white;">
											<tr>
						                       <th class="text-center" width="120">글번호</th>
						                       <th class="text-center" width="150">분류</th>
						                       <th class="text-center" width="800">제목</th>
						                       <th class="text-center">작성자</th>
						                       <th class="text-center">작성일</th>
						                       <th class="text-center">조회수</th>
						                    </tr>
						               </thead>
						               <tbody>
						                    <c:choose>
						                        <c:when test="${list.size()>0 }">
						                            <c:forEach var="vo" items="${list }">
						                                <tr>
						                                    <td class="text-center hidden-sm hidden-xs"><c:out value="${vo.nbNo }" /></td>
						                                    <td class="text-center"><c:out value="${vo.nbCategory }" /></td>
						                                    <td class="text-left"><c:out value="${vo.nbTitle }" /></td>
						                                    <td class="text-center"><c:out value="${vo.regId }" /></td>
						                                    <td class="text-center hidden-sm hidden-xs"><c:out value="${vo.regDate }" /></td>
						                                    <td class="text-center hidden-sm hidden-xs"><c:out value="${vo.readCnt }" /></td>
						                                </tr>
						                            </c:forEach>
						                        </c:when>
						                        <c:otherwise>
						                            <tr>
						                                <td class="text-center" colspan="99">데이터를 찾을 수 없습니다.</td>
						                            </tr>
						                        </c:otherwise>
						                    </c:choose>
										</tbody>
									</table>
								</div>
						         
								<!-- pagination -->
								<nav>
									<ul class="pagination justify-content-center">
										<div id="page-color-font">
										<%=StringUtil.orgRenderPaging(maxNum, currPageNo, rowPerPage, bottomCount, url, scriptName) %>
										</div>
									</ul>
								</nav> 
								<!--//pagination -->
								
								<!-- //게시글 목록 -->
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
    <script src="${hContext}/views/plugins/common/common.min.js"></script>
    <script src="${hContext}/views/js/custom.min.js"></script>
    <script src="${hContext}/views/js/settings.js"></script>
    <script src="${hContext}/views/js/gleek.js"></script>
    <script src="${hContext}/views/js/styleSwitcher.js"></script>
    <script type="text/javascript">


    function doRetrieve() {
        console.log("doRetrieve");
        var frm = document.searchFrm;
        frm.pageNum.value = "1";
        frm.action = "${hContext}/nboard/do_retrieve.do";
        frm.submit();
    }
    
    //등록으로 화면 이동.
        function doInsertView() {
            console.log("doInsertView");
            location.href='${hContext}/views/nboard_wirte.jsp';
        }

        function doSeachPage(url,no){
            console.log("#url:"+url);
            console.log("#no:" + no);
            
            var frm = document.searchFrm;
            frm.pageNum.value = no;
            frm.action = url;
            frm.submit();

        }


        //selecOne
        $("#listTable>tbody").on("click","tr",function(){
            // $(".sung").on("click",function(){
                 //console.log("sung #listTable>tbody");
                 var trs = $(this);
                 var tds = trs.children();
                 var nbNo = tds.eq(0).text().trim();
                 console.log("nbNo:"+nbNo);
                 //board/do_selectone.do
                 var frm = document.searchFrm;
                 frm.nbNo.value = nbNo.trim();
                 frm.action = "${hContext}/nboard/do_selectone.do";
                 frm.submit();
                 
                 //get location.href="getURL"            
                 //location.href="${hContext}/nboard/do_selectone.do?nbNo="+nbNo;
                 
             });

        
    </script>
</body>

</html>