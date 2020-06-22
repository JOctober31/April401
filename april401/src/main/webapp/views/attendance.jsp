<%--
 /**
  * Class Name : attendance.jsp
  * Description : 근태 관리 페이지
  * http://localhost:8080/groupware/attend/do_select_one.do?id=kimjh1
  * Modification Information
  *
  * 수정일			수정자		수정내용
  * ------------    --------    ---------------------------
  * 2020. 4. 24.	이지은		최초 생성
  *
  * author 실행환경 개발팀
  * since 2009.01.06
  *
  * Copyright (C) 2009 by KandJang  All right reserved.
  */
--%>
<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/common/common.jsp"%>

<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>Quixlab - Bootstrap Admin Dashboard Template by Themefisher.com</title>
    
    <!-- Favicon icon -->
    <link rel="icon" type="${aprilContext}/views/image/png" sizes="16x16" href="${aprilContext}/views/images/favicon.png">
    
    <!-- Custom Stylesheet -->
    <link href="${aprilContext}/views/plugins/fullcalendar/css/fullcalendar.min.css" rel="stylesheet">
    <link href="${aprilContext}/views/css/style.css" rel="stylesheet">
</head>

<body onload="realtimeClock()">

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
                    <b class="logo-abbr"><img src="${hContext}/views/images/logo.png" alt=""></b>
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
                        <li class="breadcrumb-item"><a href="javascript:void(0)">마이페이지</a></li>
                        <li class="breadcrumb-item active"><a href="javascript:void(0)">근태 관리</a></li>
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
                                    <h4>근태 관리</h4>
                                </div>
                                <div class="row">
                                    <div class="text-center col-lg-3 mt-1">
                                    
                                    	<!-- <div class="col-lg-2"> -->
                                    	<!-- 시계 -->
                                    	<table class="table table-bordered verticle-middle">
                                    		<tr>
	                                    		<td>
		                                    		<form name="rtcForm">
														<h5>
															<input type="text" name="dayInput" class="text-center" size="20" readonly="readonly" style="border:none" /><br/>
															<input type="text" name="timeInput" class="text-center" size="20" readonly="readonly" style="border:none" />
														</h5>
													</form>
												</td>
											</tr>
										<!-- </div> -->
                                    	</table>
                                    	<!-- //시계 -->
                                    	
                                    	<!-- 출근, 조퇴, 퇴근 버튼 -->
                                        <!-- <a href="#" data-toggle="modal" data-target="#add-category" class="btn btn-primary btn-block"><i class="ti-plus f-s-12 m-r-5"></i> Create New</a> -->
                                    	<%-- <button type="button" name="attenance_btn" id="attenance_btn" class="btn btn-outline-primary">출근</button> --%>
                                    	<button type="button" name="early_leave_btn" id="early_leave_btn" class="btn btn-outline-primary">조퇴</button>
                                    	<button type="button" name="leave_work_btn" id="leave_work_btn" class="btn btn-outline-primary">퇴근</button>
                                    	<!--// 출근, 조퇴, 퇴근 버튼 -->
                                    	
                                    	<form action="${aprilContext}/attend/do_insert.do" name="attend_form" method="post">
                                    		<%-- <input type="hidden" name="id" id="id" value="kimjh1"> --%>
                                    		<input type="hidden" name="id" id="id" value="${user.id}"> 
                                    		<input type="hidden" name="attendTime" id="attendTime" value="">
                                    		<input type="hidden" name="attendYN" id="attendYN" value="1">
                                    		<input type="hidden" name="leaveYN" id="leaveYN" value="0">
                                    		<input type="hidden" name="state" id="state" value="0">
                                    		<!-- <input type="hidden" name="regId" id="regId" value="kimjh1">
                                    		<input type="hidden" name="modId" id="modId" value="kimjh1"> -->
                                    		<input type="hidden" name="regId" id="regId" value="${user.id}">
                                    		<input type="hidden" name="modId" id="modId" value="${user.id}">
                                    	</form>
                                    </div>
                                    
                                    <div class="col-md-8">
	                                    <!-- 월별 근태 조회 -->
                                    	<form action="${aprilContext}/attend/do_get_all.do" method="get" name="search_form">
	                                    	<table class="verticle-middle">
		                                    	<tr>
		                                    		<td><select name="year" id="year" class="form-control"></select>&nbsp;</td>
		                                    		<td>년&nbsp;&nbsp;</td>
		                                    		<td><select name="month" id="month" class="form-control"></select>&nbsp;</td>
		                                    		<td>월&nbsp;&nbsp;</td>
		                                    		<!-- <button style="margin-right:0.5em; text-align:center; height: 40px;" class="btn btn-primary" type="button" onclick="doRetrieve();">조회</button> -->
		                                    		<td><button type="submit" name="search_btn" id="search_btn" style="margin-bottom:20px;" class="btn btn-primary">조회</button></td>
		                                    	</tr>
	                                    	</table>
                                    	</form>
                                    	<c:choose>
                                    	<c:when test="${attendVO.size() > 0}">
                                    	<input type="hidden" name="getYear" id="getYear" value="${attendVO.get(attendVO.size()-1).year}" />
						    			<input type="hidden" name="getMonth" id="getMonth" value="${attendVO.get(attendVO.size()-1).month}" />
						    			</c:when>
						    			<c:otherwise>
						    			</c:otherwise>
						    			</c:choose>
						    			<!-- //월별 근태 조회 -->
                                    
                                    <!-- table-striped -->
                                    <table class="table table-bordered verticle-middle table-hover">
						    		    <!-- hidden-sm hidden-xs 숨기기 -->
						    			<thead class="bg-primary" style="text-align: center; color:white;">
						    				<tr>
							    				<th style="display:none;">순서</th>
							    				<th style="display:none;">아이디</th>
							    				<th class="text-center">출근일</th>
							    				<th class="text-center">출근시간</th>
							    				<th class="text-center">출근여부</th>
							    				<th class="text-center">퇴근시간</th>
							    				<th class="text-center">퇴근여부</th>
							    				<th class="text-center">출결상태</th>
							    				<th class="text-center">근무시간</th>
							    				<th class="text-center">누적 근무시간</th>
						    				</tr>
						    			</thead>
						    			<tbody>
						    				<c:choose>
						    					<c:when test="${attendanceList.size()>0}">
						    						<c:forEach var="vo" items="${attendanceList}">
								    					<tr>
									    					<td style="display:none;"><c:out value="${vo.seq}" /></td>
									    					<td style="display:none;"><c:out value="${vo.id}" /></td>
									    					<td class="text-center"><c:out value="${vo.regDate}" /></td>
									    					<td class="text-center"><c:out value="${vo.attendTime}" /></td>
									    					<td class="text-center"><c:out value="${vo.attendYN}" /></td>
									    					<td class="text-center"><c:out value="${vo.leaveTime}" /></td>
									    					<td class="text-center"><c:out value="${vo.leaveYN}" /></td>
									    					<td class="text-center"><c:out value="${vo.state}" /></td>
									    					<td class="text-center"><c:out value="${vo.workTime}" /></td>
									    					<td class="text-center"><c:out value="${vo.workTimeSum}" /></td>
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
						    		<!-- // -->
                                    
                                    
                                    <!-- BEGIN MODAL -->
                                    <div class="modal fade none-border" id="event-modal">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h4 class="modal-title"><strong>Add New Event</strong></h4>
                                                </div>
                                                <div class="modal-body"></div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-default waves-effect" data-dismiss="modal">Close</button>
                                                    <button type="button" class="btn btn-success save-event waves-effect waves-light">Create event</button>
                                                    <button type="button" class="btn btn-danger delete-event waves-effect waves-light" data-dismiss="modal">Delete</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- Modal Add Category -->
                                    <div class="modal fade none-border" id="add-category">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h4 class="modal-title"><strong>Add a category</strong></h4>
                                                </div>
                                                <div class="modal-body">
                                                    <form>
                                                        <div class="row">
                                                            <div class="col-md-6">
                                                                <label class="control-label">Category Name</label>
                                                                <input class="form-control form-white" placeholder="Enter name" type="text" name="category-name">
                                                            </div>
                                                            <div class="col-md-6">
                                                                <label class="control-label">Choose Category Color</label>
                                                                <select class="form-control form-white" data-placeholder="Choose a color..." name="category-color">
                                                                    <option value="success">Success</option>
                                                                    <option value="danger">Danger</option>
                                                                    <option value="info">Info</option>
                                                                    <option value="pink">Pink</option>
                                                                    <option value="primary">Primary</option>
                                                                    <option value="warning">Warning</option>
                                                                </select>
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>
                                                <div class="modal-footer">
                                                    <button type="button" class="btn btn-default waves-effect" data-dismiss="modal">Close</button>
                                                    <button type="button" class="btn btn-danger waves-effect waves-light save-category" data-dismiss="modal">Save</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- END MODAL -->
                                    
                                </div>
                            </div>
                        </div>
                        <!-- /# card -->
                    </div>
                    <!-- /# column -->
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
    
    <script src="${aprilContext}/views/plugins/jqueryui/js/jquery-ui.min.js"></script>
    <script src="${aprilContext}/views/plugins/moment/moment.min.js"></script>
    <script src="${aprilContext}/views/plugins/fullcalendar/js/fullcalendar.min.js"></script>
    <script src="${aprilContext}/views/js/plugins-init/fullcalendar-init.js"></script>
    
    <script type="text/javascript">
		function goAttend() {
			//location.href="${aprilContext}/attend/do_select_one.do?id=kimjh1";
	    	location.href="${aprilContext}/attend/do_select_one.do";
	    }
	    
	    $(document).ready(function(){
	        setDateBox();
	    });

	    //년, 월 표시 - Selectbox
	    function setDateBox(){
	        var date = new Date();
	        var now_year = date.getFullYear();
	        var now_month = (date.getMonth()+1)>9? (date.getMonth()+1) : "0"+(date.getMonth()+1);
	        
	        //$("#year").append("<option value=''>"+now_year+"</option>");
	        //올해 기준으로 -1년부터 +5년을 보여줌
	        for(var y = (now_year-5); y <= (now_year+5); y++){
	            $("#year").append("<option value='"+ y +"'>"+ y +"</option>");
	        }
	        
	        //$("#month").append("<option value=''>"+now_month+"</option>");
	        for(var i = 1; i <= 12; i++){
		        //1~9까지는 앞에 0을 붙임 ex) 01, 02, ...
	        	var sm = i > 9 ? i : "0"+i ;
	            $("#month").append("<option value='"+ sm +"'>"+ sm +"</option>");
	        }

			var getYear = $("#getYear").val();
			var getMonth = $("#getMonth").val();

			if(getYear > 0 && getMonth > 0) {
				//현재 연도, 월을 selected
		        //jQuery("#year > option[value="+now_year+"]").attr("selected", "true");
		        //jQuery("#month > option[value="+now_month+"]").attr("selected", "true");
		        jQuery("#year > option[value="+getYear+"]").attr("selected", "true");
		        jQuery("#month > option[value="+getMonth+"]").attr("selected", "true");
			} else {
				alert("해당 날짜에 출퇴근 기록이 없습니다.");
				jQuery("#year > option[value="+now_year+"]").attr("selected", "true");
		        jQuery("#month > option[value="+now_month+"]").attr("selected", "true");
				goAttend();
			}
	        /* if(null !=list) {
				for(CodeVO vo :list) {
					sb.append("\t\t<option value='"+vo.getCodeId()+"'  ");
					if(selectNm.equals(vo.getCodeId())) {
						sb.append("selected");
					}
					
					sb.append(">");
					sb.append(vo.getCodeNm());
					sb.append("</option>\n");
				}
			}
			sb.append("</select> \n"); */
	        
	    }
		//--년, 월 표시 - Selectbox

		//조회
		//$("#search_btn").on("click", function(){
			//console.log("#search_btn");

			////포맷
			//var date = new Date();
			////연도
			//var y = $('#year :selected').val();
			////월
			//var m = $('#month :selected').val();
			////오늘 날짜 
			//var searchDate = y+"/"+m+"/01";
			////오늘 날짜
			//console.log(searchDate);

			//ajax
			//$.ajax({
			//	type:"POST",
			//	url:"${aprilContext}/attend/do_get_all.do",
			//	dataType:"html",
	        //    data:{
	        //    	"searchDate" : searchDate
	        //    },
			//	success:function(data) {
			//		console.log("data : "+data);
			//		var parseData = $.parseJSON(data);
			//		location.href="${aprilContext}/attend/do_select_one.do?id=kimjh1"+"&searchDate="+searchDate;
			//		//성공
			//		if(parseData.msgId=="1") {
			//			alert(parseData.msgMsg);
			//		//실패
			//		} else {
			//			alert(parseData.msgMsg);
			//		}
			//	},
			//	error:function(xhr, status, error) {
			//		console.log("error:"+error);
			//	},
			//	complete:function(data) {
			//		
			//	}
			//}); //--ajax
		//});
		
		//조퇴 버튼 
		$("#early_leave_btn").on("click", function(){
			console.log("#early_leave_btn");

			var date = new Date();
			var leaveTime = date.getHours();
			
			//ajax
			$.ajax({
				type:"POST",
				url:"${aprilContext}/attend/early_leave.do",
				dataType:"html",
	            data:{
	            	"seq" : "",
                    "id" : $("#id").val(),
                    "leaveTime" : leaveTime,
					"attendYN" : $("#attendYN").val(),
					"leaveYN" : $("#leaveYN").val(),
					"state" : $("#state").val(),
					"regId" : $("#id").val(),
					"modId" : $("#id").val()
	            },
				success:function(data) {
					console.log("data : "+data);
					goAttend();
					
					var parseData = $.parseJSON(data);
					//성공
					if(parseData.msgId=="1") {
						alert(parseData.msgMsg);
					//실패
					} else {
						alert(parseData.msgMsg);
					}
				},
				error:function(xhr, status, error) {
					alert("error:"+error);
				},
				complete:function(data) {
					
				}
			}); //--ajax
		});
	
		//퇴근 버튼
		$("#leave_work_btn").on("click", function(){
			console.log("#leave_work_btn");

			var date = new Date();
			var leaveTime = date.getHours();
			
			//ajax
			$.ajax({
				type:"POST",
				url:"${aprilContext}/attend/leave_update.do",
				dataType:"html",
	            data:{
	            	"seq" : "",
                    "id" : $("#id").val(),
                    "leaveTime" : leaveTime,
					"attendYN" : $("#attendYN").val(),
					"leaveYN" : $("#leaveYN").val(),
					"state" : $("#state").val(),
					"regId" : $("#id").val(),
					"modId" : $("#id").val()
	            },
				success:function(data) {
					console.log("data : "+data);
					goAttend();
					
					var parseData = $.parseJSON(data);
					//성공
					if(parseData.msgId=="1") {
						alert(parseData.msgMsg);
					//실패
					} else {
						alert(parseData.msgMsg);
					}
				},
				error:function(xhr, status, error) {
					alert("error:"+error);
				},
				complete:function(data) {
					
				}
			}); //--ajax
		});

		//출근 버튼 : 하루에 한 번만 누를 수 있어야 함
		//state : 0-디폴트, 1-지각
		//$("#attenance_btn").on("click", function(){
		//	console.log("#attenance_btn");
        //
		//	var date = new Date();
		//	var attendTime = date.getHours();
		//	
		//	//ajax
		//	$.ajax({
		//		type:"POST",
		//		url:"${aprilContext}/attend/do_insert.do",
		//		dataType:"html",
	    //        data:{
	    //        	"seq" : "",
        //            "id" : $("#id").val(),
		//			"attendTime" : attendTime,
		//			"attendYN" : $("#attendYN").val(),
		//			"leaveYN" : $("#leaveYN").val(),
		//			"state" : $("#state").val(),
		//			"regId" : $("#id").val(),
		//			"modId" : $("#id").val()
	    //        },
		//		success:function(data) {
		//			console.log("data : "+data);
		//			goAttend();
		//			
		//			var parseData = $.parseJSON(data);
		//			//성공
		//			if(parseData.msgId=="1") {
		//				alert(parseData.msgMsg);
		//				doRetrieve();
		//			//실패 - 이미 출근 버튼을 누름
		//			} else if(parseData.msgId=="2") {
		//				alert(parseData.msgMsg);
		//			//실패
		//			} else {
		//				alert(parseData.msgMsg);
		//			}
		//		},
		//		error:function(xhr, status, error) {
		//			console.log("error:"+error);
		//		},
		//		complete:function(data) {
		//			
		//		}
		//	}); //--ajax
		//});
		
		//실시간 시계
		function realtimeClock() {
		  document.rtcForm.dayInput.value = getDayStamp();
		  document.rtcForm.timeInput.value = getTimeStamp();
		  setTimeout("realtimeClock()", 1000);
		}
		
		function getDayStamp() { // 24시간제
		  var d = new Date();
		
		  var s =
		    leadingZeros(d.getFullYear(), 4) + '년 ' +
		    leadingZeros(d.getMonth() + 1, 2) + '월  ' +
		    leadingZeros(d.getDate(), 2) + '일 ';

		  return s;
		}

		function getTimeStamp() { // 24시간제
		  var d = new Date();
			
		  var s =
		    leadingZeros(d.getHours(), 2) + '시 ' +
		    leadingZeros(d.getMinutes(), 2) + '분 ' +
		    leadingZeros(d.getSeconds(), 2) + '초';

		  return s;
		}
		
		function leadingZeros(n, digits) {
		  var zero = '';
		  n = n.toString();
		
		  if (n.length < digits) {
		    for (i = 0; i < digits - n.length; i++)
		      zero += '0';
		  }
		  return zero + n;
		} //--실시간 시계
	</script>
</body>

</html>