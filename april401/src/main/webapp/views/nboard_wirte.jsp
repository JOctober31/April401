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
    <title>Quixlab - Bootstrap Admin Dashboard Template by Themefisher.com</title>
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="images/favicon.png">
    <!-- Custom Stylesheet -->
    <link href="css/style.css" rel="stylesheet">

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
                <div class="row">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="card-title">
                                  <h4>전사 게시판 - 게시글 작성</h4><hr/>
                                </div>
                                <div class="email-box">
                                    <div class="compose-content mt-5">
                                        <form action="${hContext}/nboard/do_retrieve.do" name="mngFrm" id="mngFrm" method="post">
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
                                                                                 <!-- // 카테고리 -->
                                                                                                제목                                                    
                                          <input type="text" class="form-control bg-transparent"
                                                      id="nbTitle" name="nbTitle" placeholder="제목을 입력하세요." value="${vo.nbTitle }">
                                            </div>
                                            <div class="form-group">
                                                                                                            내용
                                                <textarea class="textarea_editor form-control bg-light" rows="15" 
                                                          placeholder="내용을 입력하세요." name="nbContents" id="nbContents">${vo.nbContents}</textarea>
                                            </div>
                                            <div class="form-group">
                                                                                                        등록자 
                                               <input type="text" class="form-control bg-transparent"
                                                      id="regId" name="regId" value="${user.id}" readonly="readonly">
                                               <%-- <input type="text" class="form-control bg-transparent" placeholder="등록자"
                                                      id="regId" name="regId" placeholder="등록자를 입력하세요." value="${vo.regId }"> --%>
                                            </div>
                                        </form>
                                        
                                    </div>
                                    <div class="text-center m-t-15">
                                      <c:choose>
                                        <c:when test="${9 eq user.auth}">
	                                        <button class="btn btn-primary m-b-30 m-t-15 f-s-14 p-l-20 p-r-20 m-r-10" 
	                                                type="button" id="insert_btn">
	                                                <i class="fa fa-paper-plane m-r-5"></i> 글 등록</button>
	                                        <button class="btn btn-dark m-b-30 m-t-15 f-s-14 p-l-20 p-r-20" type="button"
	                                                onclick="goRetrieve();" id="list_btn">
	                                                <i class="ti-close m-r-5 f-s-12"></i> 작성 취소</button>
                                        </c:when>
                                      </c:choose>
                                    </div>
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
    
     <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
     <!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
    <script src="${hContext}/resources/js/jquery-migrate-1.4.1.js"></script>
    
    <script src="plugins/common/common.min.js"></script>
    <script src="js/custom.min.js"></script>
    <script src="js/settings.js"></script>
    <script src="js/gleek.js"></script>
    <script src="js/styleSwitcher.js"></script>
    
    <script type="text/javascript">
    function goRetrieve(){
            location.href="${hContext}/nboard/do_retrieve.do?pageNum=1&nbNo=&pageSize=10&searchDiv=&searchWord=";
            //location.href="${hContext}/nboard/nboard_list.jsp";
        }

        $("#insert_btn").on("click",function(){

        	//category 카테고리 미입력시
        	var category = document.getElementById("category")  
        	//alert('선택된 옵션 value 값=' + category.options[category.selectedIndex].value);  

            var ckCategory = $("select[name=category] option:selected").val();
            if(null==ckCategory || ckCategory.length<=1){
                $("#category").focus();
                alert("카테고리를 선택하세요.");
                return;
             }

                	
            //nbTitle 제목 미입력시 
        	var nbTitle = $("#nbTitle").val().trim();
            if(null==nbTitle || nbTitle.length<=1){
               $("#nbTitle").focus();
               alert("제목을 입력하세요.");
               return;
            }

            //nbContents 내용 미입력시 
            var nbContents = $("#nbContents").val().trim();
            if(null==nbContents || nbContents.length<=1){
               $("#nbContents").focus();
               alert("내용을 입력하세요.");
               return;
            }

            //regId 작성자 미입력시 
            var regId = $("#regId").val().trim();
            if(null==regId || regId.length<=1){
               $("#regId").focus();
               alert("아이디를 입력하세요.");
               return;
            }

            if(false==confirm("등록하시겠습니까?")) return;
            
          //ajax
            $.ajax({
               type:"POST",
               url:"${hContext }/nboard/do_insert.do",
               dataType:"html", 
               data:{"nbCategory":category.options[category.selectedIndex].value,
                     "nbTitle":nbTitle,
            	     "nbContents":nbContents,
            	     "regId":regId
               },
               success:function(data){ //성공
                  //{"msgId":"1","msgMsg":"삭제 되었습니다.","num":0,"totalCnt":0}
                  //alert(data);

                  var jData = JSON.parse(data);
                  if(null != jData && jData.msgId=="1"){
                     alert(jData.msgMsg);
                     //목록 화면으로 이동
                     goRetrieve();
                  }else{
                     alert(jData.msgMsg);
                  }
               },
               error:function(xhr,status,error){
                  //{"msgId":"0","msgMsg":"삭제 실패.","num":0,"totalCnt":0}
                  alert("error:"+error);
               },
               complete:function(data){
               
               }   
            
            });//--ajax  
         }); //--insert_btn

        	
        </script>
    </body>

</html>