<%--
  /**
  * Class Name : nboard_read_update.jsp
  * Description : 관리자만 접근 가능 - 게시판 상세페이지 수정
  * Modification Information
  *
  *   수정일                   수정자                      수정내용
  *  -------    --------    ---------------------------
  *  2020. 5. 21.            최초 생성
  *
  * author 실행환경 개발팀
  * since 2009.01.06
  *
  * Copyright (C) 2009 by KandJang  All right reserved.
  */
--%>

<%@page import="com.april.groupware.member.service.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib  prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/common/common.jsp"%>
<%
    //session
    UserVO userInfo = (UserVO) session.getAttribute("user");
    String auth = userInfo.getAuth();
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>전사게시판_상세페이지</title>
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
                        <li class="breadcrumb-item"><a href="javascript:void(0)">Dashboard</a></li>
                        <li class="breadcrumb-item active"><a href="javascript:void(0)">Home</a></li>
                    </ol>
                </div>
            </div>
            <!-- row -->

            <div class="container-fluid">
            <div class="bootstrap-label">
            <div class="toolbar" role="toolbar">
              <span style="font-size:1.7em; text-align:center; line-height:30px; height: 40px; width: 150px;" class="label label-info" >전사게시판</span>
            </div>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="email-box">
                                    <div class="toolbar" role="toolbar">
                                        <div class="btn-group" style="float:right;">
	                                      <!-- 마지막에 풀기 -->
	                                      <c:choose>
                                            <c:when test="${9 eq user.auth}">
	                                          <input type="button" style="margin:0.2em; height: 30px; width: 100px; text-align:center;" 
	                                                 class="label label-pill label-danger"
	                                                 value="수정(관리자)" id="update_btn" />
	                                        </c:when>
                                          </c:choose>
	                                          <input type="text" style="margin:0.2em; height: 30px; width: 100px; text-align:center;" class="label label-pill label-success" 
	                                                 id="nbNo" name="nbNo" value="글번호  ${vo.nbNo }"  readonly="readonly"/>
	                                          <input type="text" style="margin:0.2em; height: 30px; width: 100px; text-align:center;" class="label label-pill label-success"
	                                                 value="조회수 ${vo.readCnt }"  readonly="readonly" id="readCnt" name="readCnt"/>
	                                          <span style="margin:0.2em; height: 30px; width: 100px; text-align:center;" class="label label-pill label-success">댓글 000</span>
	                                          <input type="button" style="margin:0.2em; height: 30px; width: 100px; text-align:center;" class="label label-pill label-success"
	                                                 value="글 목록" id="list_btn" onclick="goRetrieve();" />
                                        </div>
                                    </div>
                                    <!-- 게시글 내용 영역 -->
                                    <form>
                                    <div class="read-content">
                                    <div class="media mb-4 mt-1">
                                        <!-- 카테고리 -->
                                        <div>
                                         <select id="category" name="category" style="font-size: 14px; color:white; background-color: #7571f9; padding: 7px; width: 150px">
                                            <option value="">카테고리 선택</option>
                                            <option value="중요 공지">중요 공지</option>
                                            <option value="April 소식">April 소식</option>
                                            <option value="IT 뉴스">IT 뉴스</option>
                                            <option value="식단표">식단표</option>
                                            <option value="분실물">분실물</option>
                                         </select>
                                         </div>
                                         &nbsp;&nbsp;
                                    
                                            <%-- <div class="media" style="display: flex; padding-right: 1em;">
                                                ${vo.nbCategory }
                                            </div> --%>
                                                <div class="media-body" style="margin: 0; padding: 0;">
                                                    <input type="text" class="form-control m-0 text-primary" style="font-weight: bolder;"
                                                    value="${vo.nbTitle }" placeholder="수정할 제목을 입력하세요"
                                                    id="nbTitle" name="nbTitle"/>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="media pt-3">
                                            <img class="mr-3 rounded-circle" src="${hContext}/views/images/avatar/1.jpg">
                                            <div class="media-body">
                                                <h5 class="m-b-3"> 등록 : ${vo.regId } </h5>
                                                <p class="m-b-2"> 등록일 : ${vo.regDate }</p>
                                            </div>
                                        </div>
	                                            <!-- 수정시 수정자 아이디/수정일 -->
	                                            <%-- <p class="m-b-2" > 수정자 ${user.deptNm } ${user.position } ${user.name }</p> --%>
	                                            <input type="hidden" id="modId" name="modId" value="${user.id }">
                                        <hr>
                                        <div class="form-group">
								           <label for="contents" class="col-sm-2 control-label">수정 내용</label>
								           <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
								             <textarea class="form-control" name="nbContents" id="nbContents" rows="15" 
								             placeholder="수정 내용">${vo.nbContents}</textarea>
								           </div>
								         </div> 
                                        <hr>
                                        <h6 class="p-t-15"><i class="fa fa-download mb-2"></i> Attachments <span>(3)</span></h6>
                                        <div class="row m-b-30">
                                            <div class="col-auto"><a href="#" class="text-muted">My-Photo.png</a>
                                            </div>
                                            <div class="col-auto"><a href="#" class="text-muted">My-File.docx</a>
                                            </div>
                                            <div class="col-auto"><a href="#" class="text-muted">My-Resume.pdf</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                      </form>
                                      <!-- // 게시글 내용 영역 -->
                        
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
    function goRetrieve(){
        location.href="${hContext}/nboard/do_retrieve.do?pageNum=1&nbNo=&pageSize=10&searchDiv=&searchWord=";
        //location.href="${hContext}/nboard/nboard_list.jsp";
    }

    // 수정하기 - 관리자만 보여짐
    $("#update_btn").on("click",function(){

	    	//category 카테고리 미입력시
	        var category = document.getElementById("category")  
	
	        var ckCategory = $("select[name=category] option:selected").val();
	        if(null==ckCategory || ckCategory.length<=1){
	            $("#category").focus();
	            alert("카테고리를 선택하세요.");
	            return;
	         }

            var nbTitle = $("#nbTitle").val().trim();
            if(null == nbTitle || nbTitle.length<=1){
                $("#nbTitle").focus();
                alert("제목을 입력하세요.");
                return;
            }           
            var nbContents = $("#nbContents").val().trim();
            if(null == nbContents || nbContents.length <=1){
                $("#nbContents").focus();
                alert("내용을 입력하세요.");
                return;
            }    
            var nbNo =  ${vo.nbNo };   
            //var modId = ${user.id }; modId  
            var modId = $("#modId").val().trim();  
                        
            if(false==confirm("수정 하시겠습니까?"))return;

            $.ajax({
                       type:"POST",
                       url:"${hContext}/nboard/do_update.do",
                       dataType:"html", 
                       data:{
                    	        "nbNo":nbNo,
                    	        "nbCategory":category.options[category.selectedIndex].value,
                                "nbTitle":nbTitle,
                                "nbContents":nbContents,
                                "modId":modId
                            },
                       success:function(data){ //성공
                        //alert(data);
                        //{"msgId":"1","msgMsg":"삭제 되었습니다.","num":0,"totalCnt":0}
                        var jData = JSON.parse(data);
                        if(null !=jData && jData.msgId=="1"){
                            alert(jData.msgMsg);
                            //목록화면으로 이동
                            goRetrieve();
                        }else{
                            alert(jData.msgMsg);
                            
                        }
                   
                   },
                   error:function(xhr,status,error){
                       alert("error:"+error);
                   },
                   complete:function(data){
                   
                   }   
                   
           });//--ajax
        });
        

    </script>
</body>

</html>