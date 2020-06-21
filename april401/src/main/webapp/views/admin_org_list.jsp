<%--
  /**
  * Class Name : nboard_list.jsp
  * Description : 전사 게시판 목록
    http://localhost:8080/groupware/admin/do_retrieve.do?pageNum=1&pageSize=10&searchDiv=&searchWord=
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
    /* out.print("search:"+search); */
    
    List<CodeVO> searchList = (List<CodeVO>) request.getAttribute("searchList");

    //pageSizeList
    List<CodeVO> pageSizeList = (List<CodeVO>) request.getAttribute("pageSizeList");

    
    int totalCnt = 0;
    
    totalCnt = (Integer) request.getAttribute("totalCnt");
  /*   out.print("totalCnt:"+totalCnt); */

    //paging
    String url = H_PATH+"/admin/do_retrieve.do";
    String scriptName = "doSeachPage";
    int maxNum =0;//총글수
    int currPageNo=1;//현재페이지 
    int rowPerPage=10;
    int bottomCount=5;//바닥에 page
    
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
    
    
   <!--  font style -->
    <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500&display=swap" rel="stylesheet">
	<style type="text/css">
	h4 {
		font-family: 'Noto Sans KR', sans-serif;
	}
	
	a {
		font-family: 'Noto Sans KR', sans-serif;
	}
	
	#page-color-font a {
		font-family: 'Do Hyeon', sans-serif;
		font-size: 1.2em;
		color: #7571f9;
	}
	</style>

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
				<a> <b class="logo-abbr"><img
						src="${hContext}/views/images/logo.png" alt=""> </b> <span
					class="logo-compact"><img
						src="${hContext}/views/images/logo-compact.png" alt=""></span> <span
					class="brand-title"> <img
						src="${hContext}/views/images/april_logo.png" alt="">
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
        <script type="text/javascript">
      	function goRetrieve() {
 			location.href = "${hContext}/admin/do_retrieve.do?pageNum=1&pageSize=10&searchDiv=&searchWord=";
 		}
        </script>
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
                        <li class="breadcrumb-item"><a href="javascript:void(0)">관리자 페이지</a></li>
                        <li class="breadcrumb-item active"><a href="javascript:void(0)">조직 데이터 목록</a></li>
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
                                    <h4>조직 데이터</h4><hr/>
                                </div>

                                
        <!-- 검색영역 -->
        <div class="row">
            <div class="col-md-12">
                <form action="${hContext}/admin/do_retrieve.do" class="form-inline" style="text-align: center;" 
                        name="searchFrm" method="get">
                    <input type="hidden" name="pageNum" id="pageNum" value="${vo.pageNum }">
                    <input type="hidden" name="id" id="id" />
                       
                        <div class="btn-group mr-2 mb-2">
                        <%=StringUtil.makeSelectBox(pageSizeList, "pageSize", pageSize, false)%>&nbsp;&nbsp;
                        </div>
                     	 <div class="btn-group mr-2 mb-2">
                        <%=StringUtil.makeSelectBox(searchList, "searchDiv", searchDiv, true)%>&nbsp;&nbsp;
                        </div>
                        
                        <input type="text" style="height: 12px;" class="form-control"  id="searchWord" name="searchWord" placeholder="검색어" value="${vo.searchWord }">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   
                        <button style="margin-right:0.5em; text-align:center; height: 40px;" class="btn btn-primary" type="button" onclick="doRetrieve();">조회</button> 
                        <button style="margin-right:0.5em; text-align:center; height: 40px;" class="btn btn-danger" type="button" onclick="doInsertView();">등록</button>
                        <button style="margin-right:0.5em; text-align:center; height: 40px;" class="btn btn-success" type="button" disabled="disabled">사원수 ${totalCnt } 명</button>
                     </div>   
                </form>
            </div>
        </div>
        <!--// 검색영역 -->

           <!-- 게시글 목록 -->
         <div class="table-responsive">
           <table class="table" id="listTable">
               <thead>
                   <tr>
                       <th class="text-center">아이디</th>
                       <th class="text-center">부서명</th>
                       <th class="text-center">이름</th>
                       <th class="text-center">직급</th>
                       <th class="text-center">입사일</th>
                       <th class="text-center">등록일</th>
                   </tr>
               </thead>
               <tbody>
                    <c:choose>
                        <c:when test="${list.size()>0 }">
                            <c:forEach var="vo" items="${list }">
                                <tr>
                                    <td class="text-center"><c:out value="${vo.id }" /></td>
                                    <td class="text-center"><c:out value="${vo.deptNm }" /></td>
                                    <td class="text-center"><c:out value="${vo.name }" /></td>
                                    <td class="text-center"><c:out value="${vo.position }" /></td>
                                    <td class="text-center"><c:out value="${vo.hiredate }" /></td>
                                    <td class="text-center"><c:out value="${vo.regDate }" /></td>
                                    <td style="display: none;"><c:out value="${vo.id }" /></td>
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
                    <div class="text-center">
                    	<div id="page-color-font">
			        	    <%=StringUtil.orgRenderPaging(maxNum, currPageNo, rowPerPage, bottomCount, url, scriptName) %>
			            </div>
			        </div>
                 </ul>
             </nav> 
         <!--// pagenation -->
         <!-- </div> -->
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

    //등록으로 화면 이동.
        function doInsertView() {
            console.log("doInsertView");
            location.href='${hContext}/views/admin_org_write.jsp';
        }

        function doSeachPage(url,no){
            console.log("#url:"+url);
            console.log("#no:" + no);
            
            var frm = document.searchFrm;
            frm.pageNum.value = no;
            frm.action = url;
            frm.submit();

        }

        function doRetrieve() {
            console.log("doRetrieve");
            var frm = document.searchFrm;
            frm.pageNum.value = "1";
            frm.action = "${hContext}/admin/do_retrieve.do";
            frm.submit();
        }

        $("#searchWord").on("keypress", function(e) {
            console.log("#searchWord");
            console.log("#searchWord:" + e.which);
            if (e.which == 13) {
                doRetrieve();
            }
        });

        //selecOne
        $("#listTable>tbody").on("click","tr",function(){
            // $(".sung").on("click",function(){
                 //console.log("sung #listTable>tbody");
                 var trs = $(this);
                 var tds = trs.children();
                 var id = tds.eq(0).text();
                 console.log("id:"+id);
                 //board/do_selectone.do
                 var frm = document.searchFrm;
                 frm.id.value = id;
                 frm.action = "${hContext}/admin/do_selectone.do";
                 frm.submit();
                 
                 //get location.href="getURL"            
                 //location.href="${hContext}/admin/do_selectone.do?id="+id;
                 
             });


    
    </script>
</body>

</html>