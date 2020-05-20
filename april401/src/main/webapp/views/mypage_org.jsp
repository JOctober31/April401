<%--
 /**
  * Class Name : 
  * Description : http://localhost:8080/groupware/org/do_select_one.do?id=kimjh1
  * Modification Information
  *
  * 수정일		수정자		수정내용
  * -------    --------    ---------------------------
  * 2020. 4. 27.					최초 생성
  *
  * author 실행환경 개발팀
  * since 2009.01.06
  *
  * Copyright (C) 2009 by KandJang  All right reserved.
  */
--%>
<%@page import="com.april.groupware.attendance.service.OrgUpdateVO"%>
<%@page import="java.util.List"%>
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
                        <div class="drop-down   d-md-none">
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
                            <div class="drop-down dropdown-profile   dropdown-menu">
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
                            <li><a href="./index.html">Home 1</a></li>
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
                <div class="row justify-content-center">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="form-validation">
                                
	                               	<!-- TODO -->
	                                <!-- <table border="1">
	                                	<tr>
	                                		<td rowspan="5">사진</td>
	                                		<td>이름</td>
	                                		<td colspan="3">00</td>
	                                	</tr>
	                                	<tr>
	                                		<td>생년월일</td>
	                                		<td>00</td>
	                                		<td>입사일</td>
	                                		<td>00</td>
	                                	</tr>
	                                	<tr>
	                                		<td>핸드폰</td>
	                                		<td>00</td>
	                                		<td>부서명</td>
	                                		<td>00</td>
	                                	</tr>
	                                	<tr>
	                                		<td>이메일</td>
	                                		<td>00</td>
	                                		<td>직급</td>
	                                		<td>00</td>
	                                	</tr>
	                                	<tr>
	                                		<td>주소</td>
	                                		<td colspan="3">00</td>
	                                	</tr>
	                                </table> -->
									
	                                <!-- TODO : 지우기 -->
                                	${orgUpdateVO}
                                    <form class="form-valide" action="${aprilContext}/org/do_update.do" name="org_form" method="post" enctype="multipart/form-data">
                                    	<div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="profile">사진 <span class="text-danger"></span>
                                            </label>
                                            <div class="col-lg-3">
                                            	<!-- 사진 미리보기 https://codepen.io/buppagi/pen/wKwPBP -->
                                            	<table>
                                            		<tr>
                                            			<td>
                                            				<!-- style="width: 150px; height: 180px; color: grey; border: 1px solid grey; dispaly: inline;" -->
                                            				<!-- TODO saveFileName : ./WEB-INF/file_upload_img/2020/05/20200518183556e4e57f3d2dfe4a09a6315871562752ae.gif  -->
                                                			<img alt="profile" src="./WEB-INF/file_upload_img/2020/05/20200518183556e4e57f3d2dfe4a09a6315871562752ae.gif" width="150px" height="180px"/>
                                                		</td>
                                                		<td>
															<div id='View_area' style='position:relative; width: 150px; height: 180px; display: inline;'></div>
                                                		</td>
                                                	</tr>
                                                	<tr>
                                                		<td colspan="2">
                                                			<input type="file" name="profile_after" id="profile_after" onchange="previewImage(this,'View_area')">
                                                			<!-- TODO : 지우기 -->
                                                			<input type="text" name="profile_before" id="profile_before" value="${orgUpdateVO.orgFileName}" />
                                                			<input type="text" name="id" id="id" value="${orgUpdateVO.id}" />
                                                			<!-- TODO : 지우기 -->
                                                		</td>
                                                	</tr>
                                                </table>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="name">이름 <span class="text-danger" >*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="name" name="name" placeholder="${orgUpdateVO.name}" readonly="readonly">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="password">패스워드 <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="password" class="form-control" id="password" name="password" placeholder="">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="confirm-password">패스워드  확인 <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="password" class="form-control" id="confirm-password" name="confirm-password" placeholder="">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="hiredate">입사일 <span class=""></span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="hiredate" name="hiredate" placeholder="${orgUpdateVO.hiredate}" readonly="readonly">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="deptNm">부서명 <span class=""></span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="deptNm" name="deptNm" placeholder="${orgUpdateVO.deptNm}" readonly="readonly">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="position">직급 <span class=""></span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="position" name="position" placeholder="${orgUpdateVO.position}" readonly="readonly">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="email">이메일 <span class="text-danger"></span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="email" name="email" placeholder="${orgUpdateVO.email}">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="birth">생년월일 <span class=""></span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="birth" name="birth" placeholder="${orgUpdateVO.birth}" readonly="readonly">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="mobile">휴대폰 번호 <span class="text-danger"></span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="mobile" name="mobile" placeholder="${orgUpdateVO.mobile}">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="address">주소 <span class=""></span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="address" name="address" placeholder="${orgUpdateVO.address}">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="grade">최종 학력 <span class=""></span>
                                            </label>
                                            <div class="col-lg-6">
                                                <select class="form-control" id="grade" name="grade">
                                                    <option value="고졸" <c:if test="${orgUpdateVO.grade == '고졸'}"> selected="selected"</c:if>>
                                                    	고졸
                                                    </option>
                                                    <option value="전문학사" <c:if test="${orgUpdateVO.grade == '전문학사'}"> selected="selected"</c:if>>
                                                    	전문학사
                                                    </option>
                                                    <option value="학사" <c:if test="${orgUpdateVO.grade == '학사'}"> selected="selected"</c:if>>
                                                    	학사
                                                    </option>
                                                    <option value="석사" <c:if test="${orgUpdateVO.grade == '석사'}"> selected="selected"</c:if>>
                                                    	석사
                                                    </option>
                                                    <option value="박사" <c:if test="${orgUpdateVO.grade == '박사'}"> selected="selected"</c:if>>
                                                    	박사
                                                    </option>
                                                </select>
                                                <!-- TODO : ,로 split -->
                                                <input type="text" class="form-control" id="grade_sc_name" name="grade_sc_name" placeholder="학교명">
                                                <input type="text" class="form-control" id="grade_dp_name" name="grade_dp_name" placeholder="계열 및 전공학과명">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="military">병역 사항 <span class=""></span>
                                            </label>
                                            <div class="col-lg-6">
                                            	<label>
                                            		<input type="radio" name="military" value="0" <c:if test="${orgUpdateVO.militaryYN == '0'}"> checked="checked"</c:if>>
                                            		해당 없음
                                            	</label>
                                            	<label>
                                            		<input type="radio" name="military" value="1" <c:if test="${orgUpdateVO.militaryYN == '1'}"> checked="checked"</c:if>>
                                            		군필
                                            	</label>
                                            	<label>
                                            		<input type="radio" name="military" value="1" <c:if test="${orgUpdateVO.militaryYN == '2'}"> checked="checked"</c:if>>
                                            		미필
                                            	</label>
                                            	<label>
                                            		<input type="radio" name="military" value="1" <c:if test="${orgUpdateVO.militaryYN == '3'}"> checked="checked"</c:if>>
                                            		군면제
                                            	</label>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="disabled">장애 여부<span class=""></span>
                                            </label>
                                            <div class="col-lg-6">
                                            	<label>
                                            		<input type="radio" name="disabled" value="0" <c:if test="${orgUpdateVO.dspsnYN == '0'}"> checked="checked"</c:if>>
                                            		비대상
                                            	</label>
                                            	<label>
                                            		<input type="radio" name="disabled" value="1" <c:if test="${orgUpdateVO.dspsnYN == '1'}"> checked="checked"</c:if>>
                                            		대상
                                            	</label>
                                            </div>
                                        </div>
                                        <hr/>
                                        <!-- <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="val-suggestions">Suggestions <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <textarea class="form-control" id="val-suggestions" name="val-suggestions" rows="5" placeholder="What would you like to see?"></textarea>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="val-skill">Best Skill <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <select class="form-control" id="val-skill" name="val-skill">
                                                    <option value="">Please select</option>
                                                    <option value="html">HTML</option>
                                                    <option value="css">CSS</option>
                                                    <option value="javascript">JavaScript</option>
                                                    <option value="angular">Angular</option>
                                                    <option value="angular">React</option>
                                                    <option value="vuejs">Vue.js</option>
                                                    <option value="ruby">Ruby</option>
                                                    <option value="php">PHP</option>
                                                    <option value="asp">ASP.NET</option>
                                                    <option value="python">Python</option>
                                                    <option value="mysql">MySQL</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="val-currency">Currency <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="val-currency" name="val-currency" placeholder="$21.60">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="val-website">Website <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="val-website" name="val-website" placeholder="http://example.com">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="val-phoneus">Phone (US) <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="val-phoneus" name="val-phoneus" placeholder="212-999-0000">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="val-digits">Digits <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="val-digits" name="val-digits" placeholder="5">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="val-number">Number <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="val-number" name="val-number" placeholder="5.0">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="val-range">Range [1, 5] <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="text" class="form-control" id="val-range" name="val-range" placeholder="4">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label"><a href="#">Terms &amp; Conditions</a>  <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-8">
                                                <label class="css-control css-control-primary css-checkbox" for="val-terms">
                                                    <input type="checkbox" class="css-control-input" id="val-terms" name="val-terms" value="1"> <span class="css-control-indicator"></span> I agree to the terms</label>
                                            </div>
                                        </div> -->
                                        <div class="form-group row">
                                            <div class="col-lg-8 ml-auto">
                                                <button type="submit" name="update_btn" id="update_btn" class="btn btn-primary">저장</button>
                                                <button type="button" name="cancel_btn" id="cancel_btn" class="btn btn-outline-primary">취소</button>
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

    <script src="${aprilContext}/views/plugins/validation/jquery.validate.min.js"></script>
    <script src="${aprilContext}/views/plugins/validation/jquery.validate-init.js"></script>
	
	<script type="text/javascript">

		//취소-초기화
		$("#cancel_btn").on("click", function(){
			console.log("#cancel_btn");
	
			//입력 초기화
			$("#profile_after").val("");
			$("#password").val("");
			$("#confirm-password").val("");
			$("#hiredate").val("");
			$("#deptNm").val("");
			$("#position").val("");
			$("#email").val("");
			$("#birth").val("");
			$("#mobile").val("");
			$("#address").val("");
			$("#grade").val("고졸");
			$("#grade_sc_name").val("");
			$("#grade_dp_name").val("");
			//$("#military").val(0);
			//$("#disabled").val(0);
			$('input:radio[name="military"]:input[value="0"]').attr("checked", true);
			$('input:radio[name="disabled"]:input[value="0"]').attr("checked", true);
	
			//버튼 제어
			//enable 
			//disable
			//$("#u_id").prop("disabled", false);
			//$("#doInsert").prop("disabled", false);
			//$("#doUpdate").prop("disabled", true);
			//$("#doDelete").prop("disabled", true);
		});

	//id = id;                   
	//password = password;       
	//deptNm = deptNm;           
	//deptCd = deptCd;           
	//parentDeptCd = parentDeptCd
	//auth = auth;               
	//name = name;               
	//position = position;       
	//mobile = mobile;           
	//email = email;             
	//address = address;         
	//hiredate = hiredate;       
	//birth = birth;             
	//vacationCnt = vacationCnt; 
	//militaryYN = militaryYN;   
	//dspsnYN = dspsnYN;         
	//grade = grade;             
	//orgFileName = orgFileName; 
	//modFileName = modFileName; 
	//imgPath = imgPath;         
	//ext = ext;                 
	//fileSize = fileSize;       
	//regId = regId;             
	//regDate = regDate;         
	//modId = modId;             
	//modDate = modDate;         
		//정보 수정 버튼
		$("#update_btn").on("click", function(){
        	var id = $("#id").val().trim();
            if(id == null || id.length<=1){
                console.log("아이디가 없습니다");
                return;
            }
        	
        	var modFileName = $("#profile_after").val().trim();
        	
        	var orgFileName = $("#profile_before").val().trim();

			
        	
        	
            if(false==confirm("수정하시겠습니까?")) return;

            $.ajax({
				processData: false,
				contentType: false,
		        type:"POST",
		        url:"${aprilContext}/org/do_update.do",
		        dataType:"html", 
		        data:{
				    "modFileName": modFileName,  
				    "orgFileName": orgFileName,
		        },
				//성공
		        success:function(data){ 
			        //alert(data);
			        //{"msgId":"1","msgMsg":"삭제 되었습니다.","num":0,"totalCnt":0}
			        var jData = JSON.parse(data);
			        if(jData != null && jData.msgId== "1"){
				        //alert(jData.msgMsg);
			        } else {
			            alert(jData.msgMsg);
			        }
	            },
				//에러
	            error:function(xhr,status,error){
	            	//alert("error:"+error);
	            },
	            complete:function(data){
	            }   
			}); //--ajax
        });

		function previewImage(targetObj, View_area) {
			var preview = document.getElementById(View_area); //div id
			var ua = window.navigator.userAgent;
	
			//IE일 때(IE8 이하만 작동)
			if (ua.indexOf("MSIE") > -1) {
				targetObj.select();
				try {
					var src = document.selection.createRange().text; //get file full path(IE9, IE10에서 사용 불가)
					var ie_preview_error = document.getElementById("ie_preview_error_" + View_area);

					//error가 있으면 delete
					if (ie_preview_error) {
						preview.removeChild(ie_preview_error); 
					}

					//이미지 보여줄 영역
					var img = document.getElementById(View_area); 
	
					//이미지 로딩, sizingMethod는 div에 맞춰서 사이즈를 자동 조절하는 역할
					img.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+src+"', sizingMethod='scale')";
				} catch (e) {
					if (!document.getElementById("ie_preview_error_" + View_area)) {
						var info = document.createElement("<p>");
						info.id = "ie_preview_error_" + View_area;
						info.innerHTML = e.name;
						preview.insertBefore(info, null);
					}
				}
			//IE가 아닐때(크롬, 사파리, FF 등)
			} else {
				var files = targetObj.files;
				for ( var i = 0; i < files.length; i++) {
					var file = files[i];
					
					//이미지 파일일 경우만 미리보기
					var imageType = /image.*/; 
					if (!file.type.match(imageType))
						continue;

					//이전에 미리보기가 있다면 삭제
					var prevImg = document.getElementById("prev_" + View_area); 
					if (prevImg) {
						preview.removeChild(prevImg);
					}
					var img = document.createElement("img"); 
					img.id = "prev_" + View_area;
					img.classList.add("obj");
					img.file = file;
					img.style.width = '150px'; 
					img.style.height = '180px';
					preview.appendChild(img);
					
					//FireFox, Chrome, Opera 확인
					if (window.FileReader) {
						var reader = new FileReader();
						reader.onloadend = (function(aImg) {
							return function(e) {
								aImg.src = e.target.result;
							};
						})(img);
						reader.readAsDataURL(file);
						//Safari is not supported FileReader
					} else { 
						//alert('not supported FileReader');
						if (!document.getElementById("sfr_preview_error_"
								+ View_area)) {
							var info = document.createElement("p");
							info.id = "sfr_preview_error_" + View_area;
							info.innerHTML = "not supported FileReader";
							preview.insertBefore(info, null);
						}
					}
				}
			}
		}
	</script>
</body>

</html>