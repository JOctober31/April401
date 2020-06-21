<%--
/**
  * Class Name : chat_list
  * Description : 1:1 채티방
  * http://localhost:8080/groupware/chat/chat.do 
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
<%@page import="com.april.groupware.member.service.UserVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/views/common/common.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Quixlab - Bootstrap Admin Dashboard Template by Themefisher.com</title>
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
                <a href="index.html">
                    <b class="logo-abbr"><img src="${aprilContext}/views/images/logo.png" alt=""> </b>
                    <span class="logo-compact"><img src="${aprilContext}/views/images/logo-compact.png" alt=""></span>
                    <span class="brand-title">
                        <img src="${aprilContext}/views/images/logo-text.png" alt="">
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
						<li class="breadcrumb-item active"><a
							href="javascript:void(0)">Home</a></li>
					</ol>
				</div>
			</div>
			<!-- row -->
			
			<div class="container-fluid">
				<div class="row-center" >	
					<div class="col-lg-8" >
						<div class="card text-center" >
							<div class="card-body" style="padding-left:60px; padding-right:60px; ">
								<h5 class="card-title"><c:out value="${vo.name }"></c:out>
														<input type="hidden" value="${vo.id }"> </h5>
 								 <br/>
								 <fieldset>								
						        	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="padding-left: 0px; padding-right: 0px;">
										<textarea class="form-control" name="messageBox" id="messageBox" 
												  readonly="true" rows="21" >
										</textarea>
									</div>
                                	<hr/>
                                    	<input onkeyup="enterkey();" type="text" id="inputMessage" class="form-control bg-transparent" >
                                    <br/><br/>
                                    <input type="submit" onclick="send()" class="btn btn-primary" value="보내기"  />
							     </fieldset>
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
        var textarea = document.getElementById("messageBox");
        var webSocket = new WebSocket('ws://localhost:8080/groupware/broadcasting.do');
        var inputMessage = document.getElementById('inputMessage');
        /* var userName = document.getElementById('userName').value;
        console.log("userName" + userName); */
        
    webSocket.onopen = function(event) {
      onOpen(event)
    };
    webSocket.onmessage = function(event) {
      onMessage(event)
    };
    function onMessage(event) {
        textarea.value += "${vo.name } 님 : " + event.data + "\n";
    }
    function onOpen(event) {
        //textarea.value += userName+" 님이 대화에 참여하셨습니다 \n";
    	textarea.value += "${user.name}님이 대화에 참여하셨습니다 \n";
    }
    webSocket.onerror = function(event) {
        onError(event)
      };
    function onError(event) {
      alert("서버 접속에 문제가 있습니다"+ "( problem: " + event.data + " )");
    }
    function send() {
        textarea.value += "나 : " + inputMessage.value + "\n";
        webSocket.send(inputMessage.value);
        inputMessage.value = "";
    }

    //엔터키 누르면 바로 메세지 보내기
    function enterkey() {
        if (window.event.keyCode == 13) {
        	send();
        }
	}

  </script>
  
</body>
</html>