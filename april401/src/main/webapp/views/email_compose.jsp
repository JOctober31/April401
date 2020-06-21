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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set  var="aprilContext" value="${pageContext.request.contextPath }"></c:set> 
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
<%
    // 인코딩
    request.setCharacterEncoding("euc-kr");
%>
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
                        <li class="breadcrumb-item active"><a href="javascript:doRetrieve();">메일</a></li>
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
                                <a href="${aprilContext}/views/email_compose.jsp" onclick="exitPage();" class="btn btn-primary btn-block">메일 쓰기</a>
                                    <div class="mail-list mt-4">
                                    	<a href="${aprilContext}/mail/do_retrieve.do?pageNum=1&pageSize=10&searchDiv=&searchWord=${user.id}" onclick="exitPage();" class="list-group-item border-0 text-primary p-r-0">
                                    		<i class="fa fa-inbox font-18 align-middle mr-2"></i> 
                                    		<b>받은 메일함</b> 
                                    		<span class="badge badge-primary badge-sm float-right m-t-5"><c:out value="${count}"></c:out></span> 
                                    	</a>
                                        <a href="${aprilContext}/mail/do_retrieveSent.do?pageNum=1&pageSize=10&searchDiv=&searchWord=${user.id}" onclick="exitPage();" class="list-group-item border-0 p-r-0">
                                        	<i class="fa fa-paper-plane font-18 align-middle mr-2"></i>보낸 메일함
                                        </a>  
                                        <!-- 
                                        <a href="#" class="list-group-item border-0 p-r-0"><i class="mdi mdi-file-document-box font-18 align-middle mr-2"></i>Draft</a>
                                         -->
                                        <a href="${aprilContext}/mail/do_retrieveTrash.do?pageNum=1&pageSize=10&searchDiv=&searchWord=${user.id}" onclick="exitPage();" class="list-group-item border-0 p-r-0"><i class="fa fa-trash font-18 align-middle mr-2"></i>휴지통</a>
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
                                    <div class="toolbar" role="toolbar">
                                    	<div class="btn-group m-b-20">
	                                        <button id="mailSend_btn" class="btn btn-primary m-b-30 m-t-15 f-s-14 p-l-20 p-r-20 m-r-10" type="button"><i class="fa fa-paper-plane m-r-5"></i> 보내기</button>
	                                        <button id="rewrite_btn" class="btn btn-dark m-b-30 m-t-15 f-s-14 p-l-20 p-r-20" type="button"><i class="ti-close m-r-5 f-s-12"></i> 다시 쓰기</button>
                                    	</div>
                                    	<!-- 
                                    	<div class="btn-group m-b-20">
                                            <button type="button" class="btn btn-light"><i class="fa fa-archive"></i></button>
                                            <button type="button" class="btn btn-light"><i class="fa fa-exclamation-circle"></i></button>
                                            <button type="button" class="btn btn-light"><i class="fa fa-trash"></i></button>
                                        </div>
                                        <div class="btn-group m-b-20">
                                            <button type="button" class="btn btn-light dropdown-toggle" data-toggle="dropdown"><i class="fa fa-folder"></i>  <b class="caret m-l-5"></b>
                                            </button>
                                            <div class="dropdown-menu"><span class="dropdown-header">Move to</span>  <a class="dropdown-item" href="javascript: void(0);">Social</a>  <a class="dropdown-item" href="javascript: void(0);">Promotions</a>  <a class="dropdown-item" href="javascript: void(0);">Updates</a> 
                                                <a class="dropdown-item" href="javascript: void(0);">Forums</a>
                                            </div>
                                        </div>
                                        <div class="btn-group m-b-20">
                                            <button type="button" class="btn btn-light dropdown-toggle" data-toggle="dropdown"><i class="fa fa-tag"></i>  <b class="caret m-l-5"></b>
                                            </button>
                                            <div class="dropdown-menu"><span class="dropdown-header">Label as:</span>  <a class="dropdown-item" href="javascript: void(0);">Updates</a>  <a class="dropdown-item" href="javascript: void(0);">Social</a>  <a class="dropdown-item" href="javascript: void(0);">Promotions</a> 
                                                <a class="dropdown-item" href="javascript: void(0);">Forums</a>
                                            </div>
                                        </div>
                                        <div class="btn-group m-b-20">
                                            <button type="button" class="btn btn-light dropdown-toggle" data-toggle="dropdown">More <span class="caret m-l-5"></span>
                                            </button>
                                            <div class="dropdown-menu"><span class="dropdown-header">More Option :</span>  <a class="dropdown-item" href="javascript: void(0);">Mark as Unread</a>  <a class="dropdown-item" href="javascript: void(0);">Add to Tasks</a>  <a class="dropdown-item"
                                                href="javascript: void(0);">Add Star</a>  <a class="dropdown-item" href="javascript: void(0);">Mute</a>
                                            </div>
                                        </div>
                                    	 -->
                                    </div>
                                    <div class="compose-content mt-5">
                                           <div class="form-group">
                                           	<h5 class="m-b-20">받는 사람 &nbsp;&nbsp;&nbsp;&nbsp;<input type="checkbox" id="checkMe">&nbsp;&nbsp;나에게</h5> 
                                               <input type="text" id="recipient" name="recipient" value="${vo.sender}" class="form-control bg-transparent" placeholder=" 받는 사람">
                                               <input type="hidden" id="sender" value="${user.name}" class="form-control bg-transparent" placeholder=" 보내는 사람">
                                               <input type="hidden" id="senderId" value="${user.id}" class="form-control bg-transparent" placeholder=" 보내는 사람ID">
                                           </div>
                                           <div class="form-group">
                                           	<h5 class="m-b-20">참조</h5>
                                               <input type="text" id="recipient_add" class="form-control bg-transparent" placeholder=" 참조">
                                           </div>
                                           <div class="form-group">
                                           	<h5 class="m-b-20">제목</h5>
                                               <input type="text" id="title" value="${vo.title}" class="form-control bg-transparent" placeholder=" 제목">
                                           </div>
                                           <%-- <h5 class="m-b-20"><i class="fa fa-paperclip m-r-5 f-s-18"></i> 첨부 파일</h5>
                                           <hr>
										   <form class="form-horizontal" action="${hContext}/file/do_insert.do" method="post" enctype="multipart/form-data">
											   <div class="form-group">
												   <label for="inputEmail3" class="col-lg-2 col-md-2 col-sm-2 col-xs-2 control-label">File1</label>
												   <div class="col-lg-10 col-md-10 col-sm-10 col-xs-10">
													   <input type="file" id="fileUp" class="form-control" name="file01" placeholder="파일01">
												   </div>
											   </div>
										   </form>
										   <hr> --%>
                                           <!-- <div class="form-group">
                                               <div class="fallback">
                                                   <input class="l-border-1" id="fileUp" name="file" type="file" multiple="multiple">
                                               </div>
                                           </div> -->
                                           <div class="form-group">
                                               <textarea id="contents" class="textarea_editor form-control bg-light" rows="15" ><c:out value="${vo.contents}"/></textarea>
                                           </div>
                                        <!-- 
                                        <h5 class="m-b-20"><i class="fa fa-paperclip m-r-5 f-s-18"></i> Attatchment</h5>
                                        <form action="#" class="dropzone">
                                            <div class="form-group">
                                                <div class="fallback">
                                                    <input class="l-border-1" name="file" type="file" multiple="multiple">
                                                </div>
                                            </div>
                                        </form>
                                         -->
                                        
                                    </div>
                                    <!-- 
                                    <div class="text-left m-t-15">
                                     	 <button class="btn btn-primary m-b-30 m-t-15 f-s-14 p-l-20 p-r-20 m-r-10" type="button"><i class="fa fa-paper-plane m-r-5"></i> Send</button>
                                     	 <button class="btn btn-dark m-b-30 m-t-15 f-s-14 p-l-20 p-r-20" type="button"><i class="ti-close m-r-5 f-s-12"></i> Discard</button>
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

	//--전역 변수--
	//받는 사람
	var recipient;
	//참조
	var recipient_add;
	//제목
	var title;
	//내용
	var contents;
	//보내는 사람(나중에 session하면 다시 코딩)
	var sender;
	//보내는 사람 ID
	var senderId; 
	//카테고리
	var category = "mail";
	//삭제 여부
	var disableYn = "N";
	//Read
	var read = "0";
	//--전역 변수 끝--
	
	//--받은 메일함 클릭시 function Start
	function doRetrieve(){
    	var searchWord = ${user.id};
    	location.href = "${aprilContext}/mail/do_retrieve.do?pageNum=1&pageSize=10&searchDiv=&searchWord="+searchWord;
    }
	//--받은 메일함 클릭시 function End
	
	//--이 화면에서 나가기 function Start
	function exitPage(){
		if(!confirm("이 화면에서 나가시겠습니까?")) return;
		doRetrieve();
	}
	//--이 화면에서 나가기 function End
	
	//--checkbox(나에게) 클릭시 이벤트 발생 Start
	$("#checkMe").change(function(){
		var name = ${user.name};
		if($("#checkMe").is(":checked")){
			//alert("checkbox check!");
			$("#recipient").val(name);
		}else{
			//alert("checkbox uncheck!");
			$("#recipient").val("");
		}
	});
	//--checkbox(나에게) 클릭시 이벤트 발생 End
	
	//--다시쓰기 Btn Start
	$("#rewrite_btn").on("click",function(){

		if(!confirm("다시 작성하시겠습니까?")) return;

		$("#recipient").val("");
		$("#recipient_add").val("");
		$("#title").val("");
		$("#contents").val("");

		alert("초기화 되었습니다.");		
	});	
	//--다시쓰기 Btn End
	
	//--메일 보내기 Btn Start
	$("#mailSend_btn").on("click",function(){
		//받는 사람 
		recipient = $("#recipient").val().trim();
		if(null==recipient || recipient.length<1){
			$("#recipient").focus();
			alert("받는 사람을 입력하세요.");
			return;
		}

		//참조
		recipient_add = $("#recipient_add").val().trim();
		console.log("recipient_add : "+recipient_add);
		if(recipient_add !== "" || recipient_add.length>1){
			//참조값이 있으면 ,붙이고 recipient값으로 넘겨주기
			recipient = recipient+","+recipient_add;
			console.log("recipient : "+recipient);
		}

		//제목
		title = $("#title").val().trim();
		if(null==title || title.length<1){
			if(confirm("'제목 없음'으로 보내겠습니까?")){
				title = "제목 없음";
			}else{
				$("#title").focus();
				return;
			}
		}

		//내용
		contents = $("#contents").val();
		if(null==contents || contents.length<1){
			if(confirm("'내용 없음'으로 보내겠습니까?")){
				contents = "내용 없음";
			}else{
				$("#contents").focus();
				return;
			}
		}

		//보내는 사람(나중에 session하면 다시 코딩)
		sender = $("#sender").val().trim();
		senderId = $("#senderId").val().trim();

		if(false==confirm("메일을 전송하시겠습니까?")) return;

		//ajax
		$.ajax({
			type:"POST",
			url:"${pageContext.request.contextPath }/mail/do_insert.do",
			dataType:"html", 
			data:{"recipient":recipient,
				  "title":title,
				  "contents":contents,
				  "sender":sender,
				  "senderId":senderId,
				  "category":category,
				  "disableYn":disableYn,
				  "read":read
			},
			success:function(data){ //성공
				//{"msgId":"1","msgMsg":"삭제 되었습니다.","num":0,"totalCnt":0}
				//alert(data);

				var jData = JSON.parse(data);
				if(null != jData && jData.msgId=="1"){
					alert(jData.msgMsg);
					//메일 목록 화면으로 이동
					location.href = "${aprilContext}/mail/do_retrieve.do?pageNum=1&pageSize=10&searchDiv=&searchWord=${user.id}"
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
	});
	//--메일 보내기 Btn End

	</script>

</body>

</html>