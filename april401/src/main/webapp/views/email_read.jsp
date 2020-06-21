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
                        <li class="breadcrumb-item active"><a href="javascript:void(0)">메일</a></li>
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
                                <a href="${aprilContext}/views/email_compose.jsp" class="btn btn-primary btn-block">메일 쓰기</a>
                                    <div class="mail-list mt-4">
                                    	<a href="${aprilContext}/mail/do_retrieve.do?pageNum=1&pageSize=10&searchDiv=&searchWord=${user.id}" class="list-group-item border-0 text-primary p-r-0"><i class="fa fa-inbox font-18 align-middle mr-2"></i> <b>받은 메일함</b> <span class="badge badge-primary badge-sm float-right m-t-5"><c:out value="${count}"></c:out></span> </a>
                                        <a href="${aprilContext}/mail/do_retrieveSent.do?pageNum=1&pageSize=10&searchDiv=&searchWord=${user.id}" class="list-group-item border-0 p-r-0"><i class="fa fa-paper-plane font-18 align-middle mr-2"></i>보낸 메일함</a>  
                                        <!-- 
                                        <a href="#" class="list-group-item border-0 p-r-0"><i class="mdi mdi-file-document-box font-18 align-middle mr-2"></i>Draft</a>
                                         -->
                                        <a href="${aprilContext}/mail/do_retrieveTrash.do?pageNum=1&pageSize=10&searchDiv=&searchWord=${user.id}" class="list-group-item border-0 p-r-0"><i class="fa fa-trash font-18 align-middle mr-2"></i>휴지통</a>
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
                                    	<div role="toolbar" class="toolbar">
	                                        <div class="btn-group">
	                                        	<button type="button" id="reSend_btn" class="btn btn-light"><i class="fa fa-mail-reply font-18 align-middle mr-2"></i>답장</button>
	                                        	<button type="button" id="delete_btn" class="btn btn-light"><i class="fa fa-trash font-18 align-middle mr-2"></i>삭제</button>
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
                                    
	                                    <!-- 
	                                    <div class="btn-group m-b-20">
	                                        <button class="btn btn-primary m-b-30 m-t-15 f-s-14 p-l-20 p-r-20 m-r-10" type="button"><i class="fa fa-paper-plane m-r-5"></i> 보내기</button>
	                                        <button class="btn btn-dark m-b-30 m-t-15 f-s-14 p-l-20 p-r-20" type="button"><i class="ti-close m-r-5 f-s-12"></i> 다시 쓰기</button>
                                    	</div>
	                                     -->
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
                                        <form action="" id="readFrm" method="get">
                                        	<input type="hidden" id="mailId" name="mailId" value="${vo.mailId}">
                                        	<input type="hidden" id="sender" name="sender" value="${vo.sender}">
                                        	<input type="hidden" id="recipient" name="recipient" value="${vo.recipient}">
                                        	<input type="hidden" id="contents" name="contents" value="${vo.contents}">
                                        	<input type="hidden" id="title" name="title" value="${vo.title}">
                                        	<div class="media mb-4 mt-1">
	                                            <div class="media-body"><span class="float-right"><c:out value="${vo.recDate}"></c:out></span>
	                                                <h2 class="m-0 text-primary"><c:out value="${vo.title}" /></h2>
	                                            </div>
                                        	</div>
                                            <div class="form-group">
                                            	<h5 class="m-b-20">보낸 사람 &nbsp;&nbsp;&nbsp;&nbsp;</h5> 
                                                <input type="text" id="sender" value="${vo.sender}" class="form-control bg-transparent" readonly="readonly">
                                            </div>
                                            <div class="form-group">
                                            	<h5 class="m-b-20">받는 사람</h5>
                                                <input type="text" id="recipient" value="${vo.recipient}" class="form-control bg-transparent" readonly="readonly">
                                            </div>
                                            <!-- <h6 class="p-t-15"><i class="fa fa-download mb-2"></i> 첨부파일 <span>(3)</span></h6>
	                                        <div class="row m-b-30">
	                                            <div class="col-auto"><a href="#" class="text-muted">My-Photo.png</a>
	                                            </div>
	                                            <div class="col-auto"><a href="#" class="text-muted">My-File.docx</a>
	                                            </div>
	                                            <div class="col-auto"><a href="#" class="text-muted">My-Resume.pdf</a>
	                                            </div>
	                                        </div> -->
	                                        <hr>
                                            <div class="form-group">
                                                <textarea id="contents" class="textarea_editor form-control bg-light" rows="15" readonly="readonly"><c:out value="${vo.contents}" /></textarea>
                                            </div>
                                        </form>
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

    //--받은 메일함 클릭시 function Start
	function doRetrieve(){
    	var searchWord = ${user.id};
    	location.href = "${aprilContext}/mail/do_retrieve.do?pageNum=1&pageSize=10&searchDiv=&searchWord="+searchWord;
    }
	//--받은 메일함 클릭시 function End
	
	//--답장 btn Start
	$("#reSend_btn").on("click",function(){

		if(!confirm("답장하시겠습니까?")) return;

		var mailId = $("#mailId").val();
		location.href = "${aprilContext}/mail/do_selectOneResend.do?mailId="+mailId;
		
	});
	//--답장 btn End
	
	//--삭제 btn Start
	$("#delete_btn").on("click",function(){
		if(!confirm("삭제하시겠습니까?")) return;
		var mailId = $("#mailId").val();

		//ajax
		$.ajax({
			type:"POST",
			url:"${pageContext.request.contextPath }/mail/do_updateDisable.do",
			dataType:"html", 
			data:{"mailId":mailId
			},
			success:function(data){ //성공
				//{"msgId":"1","msgMsg":"삭제 되었습니다.","num":0,"totalCnt":0}
				//alert(data);

				var jData = JSON.parse(data);
				if(null != jData && jData.msgId=="1"){
					alert(jData.msgMsg);
					//메일 목록 화면으로 이동
					doRetrieve();
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
	//--삭제 btn End
	
	
    </script>

</body>

</html>