<%--
/**
  * Class Name : chat_list
  * Description : 단체 채팅방 01
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
<%@page import="com.april.groupware.chat.service.ChatVO"%>
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

<body data-theme-version="light" data-layout="vertical" data-nav-headerbg="color_1" data-headerbg="color_1" data-sidebar-style="full" data-sibebarbg="color_1" data-sidebar-position="static" data-header-position="static" data-container="wide" direction="ltr">
	<!--*******************
        Preloader start
    ********************-->
	<div id="preloader" style="display: none;">
		<div class="loader">
			<svg class="circular" viewBox="25 25 50 50">
                <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="3" stroke-miterlimit="10"></circle>
            </svg>
		</div>
	</div>
	<!--*******************
        Preloader end
    ********************-->
	<!--**********************************
        Main wrapper start
    ***********************************-->
	<div id="main-wrapper" class="show">
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
		<div class="content-body" style="min-height: 1099px;">
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
				<div class="row-justify-content-center h-100">	
					<div class="col-lg-7">
						<div class="card text-center">
							<div class="card-body" style="padding-left:60px; padding-right:60px; ">
								 <h5 class="card-title">April 커뮤니티</h5>
								 <hr>	
 								 <br>
								 <fieldset>									   						
						        	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12" style="padding-left: 0px; padding-right: 0px;">
										<div id="messageBox" readonly="true">
										
										
										</div>
									</div>
                                	<hr>
                                	<div id="container">
                                    	<input onkeyup="enterkey();" type="text" id="inputMessage" value="" class="form-control bg-transparent">
                                    	<br><br>
                                    
                                    	<input type="submit" onclick="send()" class="btn btn-primary" value="보내기">
							     	</div>
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
	<script src="/groupware/views/plugins/common/common.min.js"></script>
	<script src="/groupware/views/js/custom.min.js"></script>
	<script src="/groupware/views/js/settings.js"></script>
	<script src="/groupware/views/js/gleek.js"></script>
	<script src="/groupware/views/js/styleSwitcher.js"></script>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	

	<script type="text/javascript">
        var textarea = document.getElementById("messageBox");
        var webSocket = new WebSocket('ws://211.238.142.146:8080/groupware/groupchat02.do');
        var inputMessage = document.getElementById('inputMessage');

        
    webSocket.onopen = function(event) {
      onOpen(event)
    };
    webSocket.onmessage = function(event) {
      onMessage(event)
    };
    webSocket.onerror = function(event) {
        onError(event)
      };

	
    function onMessage(e){
  		var chatMsg = event.data;
  		var date = new Date();
  		var dateInfo = date.getHours() + ":" + date.getMinutes() + ":" + date.getSeconds();
  		if(chatMsg.substring(0,6) == 'server'){
  			var $chat = $("<div class='chat notice'>" + chatMsg + "</div>");
  			$('#messageBox').append($chat);
  		}else{
  			var $chat = $("<div class='chat-box' style='text-align:left;'><div class='chat'>" 
  		  			+ chatMsg + "</div><div class='chat-info chat-box'>"
  		  			+ dateInfo +"</div></div>");
  			$('#messageBox').append($chat);
  		}
  		

  		$('#messageBox').scrollTop($('#messageBox')[0].scrollHeight+20);
  	}
  	
    function onOpen(event) {
        //textarea.value += userName+" 님이 대화에 참여하셨습니다 \n";
    	//textarea.value += "님이 대화에 참여하셨습니다 \n";
    }
    
    function onError(event) {
      alert("서버 접속에 문제가 있습니다"+ "( problem occured: " + event.data + " )");
    }


    
    function send() {
    	var chatMsg = inputMessage.value;
    	if(chatMsg == ''){
			return;
		}
    	var date = new Date();
		var dateInfo = date.getHours() + ":" 
					 + date.getMinutes() + ":" 
					 + date.getSeconds();
		var $chat = $("<div class='my-chat-box' style='text-align:right;'><div class='chat my-chat'>" 
					+ chatMsg + "</div><div class='chat-info' style='font-size:10px;'>"
					+ dateInfo +"</div></div>");
		$('#messageBox').append($chat);
	    //textarea.value += "나 : " + inputMessage.value + "\n";
        //webSocket.send(inputMessage.value);
        //inputMessage.value = "";
		webSocket.send(chatMsg);
		inputMessage.value = "";
		$('#messageBox').scrollTop($('#messageBox')[0].scrollHeight+20);
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
