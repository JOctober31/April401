<%--
 /**
  * Class Name : reservation.jsp
  * Description : 회의실 예약 페이지
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="aprilContext" value="${pageContext.request.contextPath}"></c:set>

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
            <div class="header-content clearfix">
                
                <div class="nav-control">
                    <div class="hamburger">
                        <span class="toggle-icon"><i class="icon-menu"></i></span>
                    </div>
                </div>
                <div class="header-left">
                    <div class="input-group icons">
                        <div class="input-group-prepend">
                            <span class="input-group-text bg-transparent border-0 pr-2 pr-sm-3" id="basic-addon1"><i class="mdi mdi-magnify"></i></span>
                        </div>
                        <input type="search" class="form-control" placeholder="Search Dashboard" aria-label="Search Dashboard">
                        <div class="drop-down d-md-none">
							<form action="#">
								<input type="text" class="form-control" placeholder="Search">
							</form>
                        </div>
                    </div>
                </div>
                <div class="header-right">
                    <ul class="clearfix">
                        <li class="icons dropdown"><a href="javascript:void(0)" data-toggle="dropdown">
                                <i class="mdi mdi-email-outline"></i>
                                <span class="badge gradient-1 badge-pill badge-primary">3</span>
                            </a>
                            <div class="drop-down animated fadeIn dropdown-menu">
                                <div class="dropdown-content-heading d-flex justify-content-between">
                                    <span class="">3 New Messages</span>  
                                    
                                </div>
                                <div class="dropdown-content-body">
                                    <ul>
                                        <li class="notification-unread">
                                            <a href="javascript:void()">
                                                <img class="float-left mr-3 avatar-img" src="${aprilContext}/views/images/avatar/1.jpg" alt="">
                                                <div class="notification-content">
                                                    <div class="notification-heading">Saiful Islam</div>
                                                    <div class="notification-timestamp">08 Hours ago</div>
                                                    <div class="notification-text">Hi Teddy, Just wanted to let you ...</div>
                                                </div>
                                            </a>
                                        </li>
                                        <li class="notification-unread">
                                            <a href="javascript:void()">
                                                <img class="float-left mr-3 avatar-img" src="${aprilContext}/views/images/avatar/2.jpg" alt="">
                                                <div class="notification-content">
                                                    <div class="notification-heading">Adam Smith</div>
                                                    <div class="notification-timestamp">08 Hours ago</div>
                                                    <div class="notification-text">Can you do me a favour?</div>
                                                </div>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="javascript:void()">
                                                <img class="float-left mr-3 avatar-img" src="${aprilContext}/views/images/avatar/3.jpg" alt="">
                                                <div class="notification-content">
                                                    <div class="notification-heading">Barak Obama</div>
                                                    <div class="notification-timestamp">08 Hours ago</div>
                                                    <div class="notification-text">Hi Teddy, Just wanted to let you ...</div>
                                                </div>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="javascript:void()">
                                                <img class="float-left mr-3 avatar-img" src="${aprilContext}/views/images/avatar/4.jpg" alt="">
                                                <div class="notification-content">
                                                    <div class="notification-heading">Hilari Clinton</div>
                                                    <div class="notification-timestamp">08 Hours ago</div>
                                                    <div class="notification-text">Hello</div>
                                                </div>
                                            </a>
                                        </li>
                                    </ul>
                                    
                                </div>
                            </div>
                        </li>
                        <li class="icons dropdown"><a href="javascript:void(0)" data-toggle="dropdown">
                                <i class="mdi mdi-bell-outline"></i>
                                <span class="badge badge-pill gradient-2 badge-primary">3</span>
                            </a>
                            <div class="drop-down animated fadeIn dropdown-menu dropdown-notfication">
                                <div class="dropdown-content-heading d-flex justify-content-between">
                                    <span class="">2 New Notifications</span>  
                                    
                                </div>
                                <div class="dropdown-content-body">
                                    <ul>
                                        <li>
                                            <a href="javascript:void()">
                                                <span class="mr-3 avatar-icon bg-success-lighten-2"><i class="icon-present"></i></span>
                                                <div class="notification-content">
                                                    <h6 class="notification-heading">Events near you</h6>
                                                    <span class="notification-text">Within next 5 days</span> 
                                                </div>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="javascript:void()">
                                                <span class="mr-3 avatar-icon bg-danger-lighten-2"><i class="icon-present"></i></span>
                                                <div class="notification-content">
                                                    <h6 class="notification-heading">Event Started</h6>
                                                    <span class="notification-text">One hour ago</span> 
                                                </div>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="javascript:void()">
                                                <span class="mr-3 avatar-icon bg-success-lighten-2"><i class="icon-present"></i></span>
                                                <div class="notification-content">
                                                    <h6 class="notification-heading">Event Ended Successfully</h6>
                                                    <span class="notification-text">One hour ago</span>
                                                </div>
                                            </a>
                                        </li>
                                        <li>
                                            <a href="javascript:void()">
                                                <span class="mr-3 avatar-icon bg-danger-lighten-2"><i class="icon-present"></i></span>
                                                <div class="notification-content">
                                                    <h6 class="notification-heading">Events to Join</h6>
                                                    <span class="notification-text">After two days</span> 
                                                </div>
                                            </a>
                                        </li>
                                    </ul>
                                    
                                </div>
                            </div>
                        </li>
                        <li class="icons dropdown d-none d-md-flex">
                            <a href="javascript:void(0)" class="log-user"  data-toggle="dropdown">
                                <span>English</span>  <i class="fa fa-angle-down f-s-14" aria-hidden="true"></i>
                            </a>
                            <div class="drop-down dropdown-language animated fadeIn  dropdown-menu">
                                <div class="dropdown-content-body">
                                    <ul>
                                        <li><a href="javascript:void()">English</a></li>
                                        <li><a href="javascript:void()">Dutch</a></li>
                                    </ul>
                                </div>
                            </div>
                        </li>
                        <li class="icons dropdown">
                            <div class="user-img c-pointer position-relative"   data-toggle="dropdown">
                                <span class="activity active"></span>
                                <img src="${aprilContext}/views/images/user/1.png" height="40" width="40" alt="">
                            </div>
                            <div class="drop-down dropdown-profile dropdown-menu">
                                <div class="dropdown-content-body">
                                    <ul>
                                        <li>
                                            <a href="app-profile.html"><i class="icon-user"></i> <span>Profile</span></a>
                                        </li>
                                        <li>
                                            <a href="email-inbox.html"><i class="icon-envelope-open"></i> <span>Inbox</span> <div class="badge gradient-3 badge-pill badge-primary">3</div></a>
                                        </li>
                                        
                                        <hr class="my-2">
                                        <li>
                                            <a href="page-lock.html"><i class="icon-lock"></i> <span>Lock Screen</span></a>
                                        </li>
                                        <li><a href="page-login.html"><i class="icon-key"></i> <span>Logout</span></a></li>
                                    </ul>
                                </div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <!--**********************************
            Header end ti-comment-alt
        ***********************************-->

        <!--**********************************
            Sidebar start
        ***********************************-->
        <div class="nk-sidebar">           
            <div class="nk-nav-scroll">
                <ul class="metismenu" id="menu">
                    <li class="nav-label">Dashboard</li>
                    <li>
                        <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                            <i class="icon-speedometer menu-icon"></i><span class="nav-text">Dashboard</span>
                        </a>
                        <ul aria-expanded="false">
                            <li><a href="${aprilContext}/views/index.html">Home 1</a></li>
                            <!-- <li><a href="./index-2.html">Home 2</a></li> -->
                        </ul>
                    </li>
                    <li class="mega-menu mega-menu-sm">
                        <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                            <i class="icon-globe-alt menu-icon"></i><span class="nav-text">Layouts</span>
                        </a>
                        <ul aria-expanded="false">
                            <li><a href="./layout-blank.html">Blank</a></li>
                            <li><a href="./layout-one-column.html">One Column</a></li>
                            <li><a href="./layout-two-column.html">Two column</a></li>
                            <li><a href="./layout-compact-nav.html">Compact Nav</a></li>
                            <li><a href="./layout-vertical.html">Vertical</a></li>
                            <li><a href="./layout-horizontal.html">Horizontal</a></li>
                            <li><a href="./layout-boxed.html">Boxed</a></li>
                            <li><a href="./layout-wide.html">Wide</a></li>
                            
                            
                            <li><a href="./layout-fixed-header.html">Fixed Header</a></li>
                            <li><a href="layout-fixed-sidebar.html">Fixed Sidebar</a></li>
                        </ul>
                    </li>
                    <li class="nav-label">Apps</li>
                    <li>
                        <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                            <i class="icon-envelope menu-icon"></i> <span class="nav-text">Email</span>
                        </a>
                        <ul aria-expanded="false">
                            <li><a href="./email-inbox.html">Inbox</a></li>
                            <li><a href="./email-read.html">Read</a></li>
                            <li><a href="./email-compose.html">Compose</a></li>
                        </ul>
                    </li>
                    <li>
                        <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                            <i class="icon-screen-tablet menu-icon"></i><span class="nav-text">Apps</span>
                        </a>
                        <ul aria-expanded="false">
                            <li><a href="./app-profile.html">Profile</a></li>
                            <li><a href="./app-calender.html">Calender</a></li>
                        </ul>
                    </li>
                    <li>
                        <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                            <i class="icon-graph menu-icon"></i> <span class="nav-text">Charts</span>
                        </a>
                        <ul aria-expanded="false">
                            <li><a href="./chart-flot.html">Flot</a></li>
                            <li><a href="./chart-morris.html">Morris</a></li>
                            <li><a href="./chart-chartjs.html">Chartjs</a></li>
                            <li><a href="./chart-chartist.html">Chartist</a></li>
                            <li><a href="./chart-sparkline.html">Sparkline</a></li>
                            <li><a href="./chart-peity.html">Peity</a></li>
                        </ul>
                    </li>
                    <li class="nav-label">UI Components</li>
                    <li>
                        <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                            <i class="icon-grid menu-icon"></i><span class="nav-text">UI Components</span>
                        </a>
                        <ul aria-expanded="false">
                            <li><a href="./ui-accordion.html">Accordion</a></li>
                            <li><a href="./ui-alert.html">Alert</a></li>
                            <li><a href="./ui-badge.html">Badge</a></li>
                            <li><a href="./ui-button.html">Button</a></li>
                            <li><a href="./ui-button-group.html">Button Group</a></li>
                            <li><a href="./ui-cards.html">Cards</a></li>
                            <li><a href="./ui-carousel.html">Carousel</a></li>
                            <li><a href="./ui-dropdown.html">Dropdown</a></li>
                            <li><a href="./ui-list-group.html">List Group</a></li>
                            <li><a href="./ui-media-object.html">Media Object</a></li>
                            <li><a href="./ui-modal.html">Modal</a></li>
                            <li><a href="./ui-pagination.html">Pagination</a></li>
                            <li><a href="./ui-popover.html">Popover</a></li>
                            <li><a href="./ui-progressbar.html">Progressbar</a></li>
                            <li><a href="./ui-tab.html">Tab</a></li>
                            <li><a href="./ui-typography.html">Typography</a></li>
                        <!-- </ul>
                    </li>
                    <li>
                        <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                            <i class="icon-layers menu-icon"></i><span class="nav-text">Components</span>
                        </a>
                        <ul aria-expanded="false"> -->
                            <li><a href="./uc-nestedable.html">Nestedable</a></li>
                            <li><a href="./uc-noui-slider.html">Noui Slider</a></li>
                            <li><a href="./uc-sweetalert.html">Sweet Alert</a></li>
                            <li><a href="./uc-toastr.html">Toastr</a></li>
                        </ul>
                    </li>
                    <li>
                        <a href="widgets.html" aria-expanded="false">
                            <i class="icon-badge menu-icon"></i><span class="nav-text">Widget</span>
                        </a>
                    </li>
                    <li class="nav-label">Forms</li>
                    <li>
                        <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                            <i class="icon-note menu-icon"></i><span class="nav-text">Forms</span>
                        </a>
                        <ul aria-expanded="false">
                            <li><a href="./form-basic.html">Basic Form</a></li>
                            <li><a href="./form-validation.html">Form Validation</a></li>
                            <li><a href="./form-step.html">Step Form</a></li>
                            <li><a href="./form-editor.html">Editor</a></li>
                            <li><a href="./form-picker.html">Picker</a></li>
                        </ul>
                    </li>
                    <li class="nav-label">Table</li>
                    <li>
                        <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                            <i class="icon-menu menu-icon"></i><span class="nav-text">Table</span>
                        </a>
                        <ul aria-expanded="false">
                            <li><a href="./table-basic.html" aria-expanded="false">Basic Table</a></li>
                            <li><a href="./table-datatable.html" aria-expanded="false">Data Table</a></li>
                        </ul>
                    </li>
                    <li class="nav-label">Pages</li>
                    <li>
                        <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                            <i class="icon-notebook menu-icon"></i><span class="nav-text">Pages</span>
                        </a>
                        <ul aria-expanded="false">
                            <li><a href="./page-login.html">Login</a></li>
                            <li><a href="./page-register.html">Register</a></li>
                            <li><a href="./page-lock.html">Lock Screen</a></li>
                            <li><a class="has-arrow" href="javascript:void()" aria-expanded="false">Error</a>
                                <ul aria-expanded="false">
                                    <li><a href="./page-error-404.html">Error 404</a></li>
                                    <li><a href="./page-error-403.html">Error 403</a></li>
                                    <li><a href="./page-error-400.html">Error 400</a></li>
                                    <li><a href="./page-error-500.html">Error 500</a></li>
                                    <li><a href="./page-error-503.html">Error 503</a></li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
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
                                    <h4>근태 관리</h4>
                                </div>
                                <div class="row">
                                    <div class="text-center col-lg-3 mt-1">
                                    
                                    	<!-- 시계 -->
                                    	<table class="table table-bordered verticle-middle">
                                    	<!-- <div class="col-lg-2"> -->
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
                                    	
                                        <!-- <a href="#" data-toggle="modal" data-target="#add-category" class="btn btn-primary btn-block"><i class="ti-plus f-s-12 m-r-5"></i> Create New</a> -->
                                    	<button type="button" name="attenance_btn" id="attenance_btn" class="btn mb-1 btn-outline-primary">출근</button><br/>
                                    	<button type="button" name="leave_work_btn" id="leave_work_btn" class="btn mb-1 btn-outline-primary">퇴근</button><br/>
                                    	<button type="button" name="early_leave_btn" id="early_leave_btn" class="btn mb-1 btn-outline-primary">조퇴</button><br/>
                                    	
                                    	<form action="${aprilContext}/attend/do_insert.do" name="attend_form" method="post">
                                    		<input type="hidden" name="id" id="id" value="kimjh1">
                                    		<input type="hidden" name="attendTime" id="attendTime" value="">
                                    		<input type="hidden" name="attendYN" id="attendYN" value="1">
                                    		<input type="hidden" name="leaveYN" id="leaveYN" value="0">
                                    		<input type="hidden" name="state" id="state" value="0">
                                    		<input type="hidden" name="regId" id="regId" value="kimjh1">
                                    		<input type="hidden" name="modId" id="modId" value="kimjh1">
                                    	</form>
                                        <!-- <div id="external-events" class="m-t-20">
                                            <p>Drag and drop your event or click in the calendar</p>
                                            <div class="external-event bg-primary text-white" data-class="bg-primary"><i class="fa fa-move"></i>New Theme Release</div>
                                            <div class="external-event bg-success text-white" data-class="bg-success"><i class="fa fa-move"></i>My Event</div>
                                            <div class="external-event bg-warning text-white" data-class="bg-warning"><i class="fa fa-move"></i>Meet manager</div>
                                            <div class="external-event bg-dark text-white" data-class="bg-dark"><i class="fa fa-move"></i>Create New theme</div>
                                        </div>
                                        checkbox
                                        <div class="checkbox m-t-40">
                                            <input id="drop-remove" type="checkbox">
                                            <label for="drop-remove">Remove after drop</label>
                                        </div> -->
                                    </div>
                                    
                                    <!-- 캘린더 -->
                                    <!-- <div class="col-md-8">
                                        <div class="card-box m-b-50">
                                            <div id="calendar"></div>
                                        </div>
                                    </div> -->
                                    <!-- //캘린더 -->
                                    <!-- end col -->
                                    <!-- TODO -->
                                    <div class="col-md-7">
                                    <table class="table table-bordered table-striped verticle-middle">
						    		    <!-- hidden-sm hidden-xs 숨기기 -->
						    			<thead>
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
						    							<td class="text-center">데이터가 없습니다</td>
						    						</tr>
						    					</c:otherwise>
						    				</c:choose>
						    				<%-- <tr>
						    					<td class="text-center hidden-sm hidden-xs">1</td>
						    					<td class="text-left">제목입니다. 비둘기 아닙니다.</td>
						    					<td class="text-center">이상무</td>
						    					<td class="text-center hidden-sm hidden-xs">2020/03/10</td>
						    					<td class="text-right hidden-sm hidden-xs">88</td>
						    					<td style="display:none;">88</td>
						    				</tr> --%>
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
            <div class="copyright">
                <p>Copyright &copy; Designed & Developed by <a href="https://themeforest.net/user/quixlab">Quixlab</a> 2018</p>
            </div>
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
		//TODO : id 변수 = 로그인 세션
		function goAttend() {
	    	location.href="${aprilContext}/attend/do_select_one.do?id=kimjh1";
	    }
	
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
		            //TODO 마지막 seq를 받아서 처리
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
		            //TODO 마지막 seq를 받아서 처리
	            	"seq" : "7",
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
		$("#attenance_btn").on("click", function(){
			console.log("#attenance_btn");

			var date = new Date();
			var attendTime = date.getHours();
			
			//ajax
			$.ajax({
				type:"POST",
				url:"${aprilContext}/attend/do_insert.do",
				dataType:"html",
	            data:{
		            //TODO seq query(next.val)
	            	"seq" : "7",
                    "id" : $("#id").val(),
					"attendTime" : attendTime,
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
						doRetrieve();
					//실패
					} else {
						alert(parseData.msgMsg);
					}
				},
				error:function(xhr, status, error) {
					console.log("error:"+error);
					alert("이미 출근이 완료되었습니다.");
				},
				complete:function(data) {
					
				}
			}); //--ajax
		});
		
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