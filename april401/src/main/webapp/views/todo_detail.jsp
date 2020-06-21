<%--
  /**
  * Class Name : 
  * Description : 
  * Modification Information
  *
  *   수정일                   수정자                      수정내용
  *  -------    --------    ---------------------------
  *  2020. 4. 24.            최초 생성
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
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Quixlab - Bootstrap Admin Dashboard Template by Themefisher.com</title>
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
                <div class="row justify-content-center">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="form-validation">
                                    <form class="form-valide" action="${hContext}/todo/do_retrieve.do"  name="mngFrm" method="post">
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="id">아이디 <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="id" name="id"  value="${todovo.id }" readonly="readonly" placeholder="아이디">
                                            </div>
                                        </div>
                                           <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for=deptNm>부서 명 <span class="text-danger" >*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="deptNm" name="deptNm" value="${todovo.deptNm }" readonly="readonly" placeholder="부서 명을 입력하세요" >
                                            </div>
                                        </div>
                                         <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for=pTitle>프로젝트 명 <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                 <input type="text" class="form-control" id="pTitle" name="pTitle"  value="${todovo.pTitle }" placeholder="프로젝트 명을 입력하세요">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="pType">프로젝트 타입 <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                 <input type="text" class="form-control" id="pType" name="pType"  value="${todovo.pType }" placeholder="프로젝트 타입을 입력하세요">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="taskContents">업무 내용 <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                            <input type="text" class="form-control" id="taskContents" name="taskContents"  value="${todovo.taskContents }" placeholder="업무 내용을 입력하세요">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="customer">고객사<span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="customer" name="customer" value="${todovo.customer }" placeholder="고객사를 입력하세요">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="area">지역<span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="area" name="area" value="${todovo.area }" placeholder="지역을 입력하세요">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="workingForm">근무형태<span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="workingForm" name="workingForm" value="${todovo.workingForm }" placeholder="근무형태를 입력하세요">
                                            </div>
                                        </div>
                                         <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="modId"><span class="text-danger"></span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type=hidden class="form-control" id="modId" name="modId" value="${user.id }" placeholder="수정자를 입력하세요">
                                            </div>
                                        </div>
                                        <div class="row text-right">
										    <label for="title" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label"></label>
										    <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
										    	<input  type="button" class="btn btn-primary btn-sm" onclick="goRetrieve();"  value="목록" id="list_btn" />
												<input  type="button" class="btn btn-primary btn-sm" value="수정" id="update_btn" />
												<input  type="button" class="btn btn-primary btn-sm" value="삭제" id="delete_btn" />
											</div>
										</div>
                                    </form>
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

    <script src="${hContext}/views/plugins/validation/jquery.validate.min.js"></script>
    <script src="${hContext}/views/plugins/validation/jquery.validate-init.js"></script>



    <script type="text/javascript">
    
        function goRetrieve(){
        	location.href="${hContext}/todo/do_retrieve.do?pageNum=1&pageSize=10&searchDiv=&searchWord="
        }

        $("#update_btn").on("click",function(){
        	var id = $("#id").val().trim();
            if(null == id || id.length<=1){
            	$("#id").focus();
                alert("아이디를 입력하세요.");
                return;
            }
        	
        	var deptNm = $("#deptNm").val().trim();
            if(null == deptNm || deptNm.length<=1){
                $("#deptNm").focus();
                alert("부서명을 선택하세요.");
                return;
            }        	
        	var pTitle = $("#pTitle").val().trim();
            if(null == pTitle || pTitle.length <=1){
                $("#pTitle").focus();
                alert("프로젝트 명을 입력하세요.");
                return;
            }         	
        	var pType = $("#pType").val().trim();
            if(null == pType || pType.length<=1){
                $("#pType").focus();
                alert("프로젝트 타입을 선택하세요.");
                return;
            }
            var customer = $("#customer").val().trim();
            if(null == customer || customer.length<=1){
                $("#customer").focus();
                alert("고객사를 입력하세요.");
                return;
            }
            var taskContents = $("#taskContents").val().trim();
            if(null == taskContents || taskContents.length<=1){
                $("#taskContents").focus();
                alert("내용을 입력하세요.");
                return;
            }
            var area = $("#area").val().trim();
            if(null == area || area.length<=1){
                $("#area").focus();
                alert("근무 지역을 입력하세요.");
                return;
            }
            var workingForm = $("#workingForm").val().trim();
            if(null == workingForm || workingForm.length<=1){
                $("#workingForm").focus();
                alert("근무 형태를 입력하세요.");
                return;
            }
            var modId = $("#modId").val().trim();
            if(null == modId || modId.length<=1){
                $("#modId").focus();
                alert("수정자를 입력하세요.");
                return;
            }
            
            if(false==confirm("수정 하시겠습니까?"))return;

            $.ajax({
                       type:"POST",
                       url:"${hContext}/todo/do_update.do",
                       dataType:"html", 
                       data:{
	                    	   "id":id,
	                           "deptNm":deptNm,
	                           "pTitle":pTitle,
	                           "pType":pType,
	                           "customer":customer,
	                           "taskContents":taskContents,
	                           "area":area,
	                           "workingForm":workingForm,
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
        
        
        $("#delete_btn").on("click",function(){
            console.log("delete_btn");
            var id = $("#id").val().trim();
            console.log("id:"+id);

            if(false==confirm("삭제 하시겠습니까?"))return;

            $.ajax({
	            	   type:"POST",
	            	   url:"${hContext}/todo/do_delete.do",
	            	   dataType:"html", 
	            	   data:{"id":id  },
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




