<%--
 /**
  * Class Name : mypage_org.jsp
  * Description : 회원 정보 수정
  * http://localhost:8080/groupware/org/do_select_one.do?id=kimjh1
  * Modification Information
  *
  * 수정일			수정자		수정내용
  * ------------    --------    ---------------------------
  * 2020. 4. 27.	이지은		최초 생성
  *
  * author 실행환경 개발팀
  * since 2009.01.06
  *
  * Copyright (C) 2009 by KandJang  All right reserved.
  */
--%>
<%@page import="com.april.groupware.attendance.service.OrgUpdateVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <link rel="icon" type="image/png" sizes="16x16" href="${aprilContext}/views/images/favicon.png">
    
    <!-- Custom Stylesheet -->
    <link href="${aprilContext}/views/css/style.css" rel="stylesheet">
	
	<!-- <script src="//code.jquery.com/jquery-3.3.1.min.js"></script> -->
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
				<a> <b class="logo-abbr"><img
						src="${hContext}/views/images/logo.png" alt=""> </b> <span
					class="logo-compact"><img
						src="${hContext}/views/images/logo-compact.png" alt=""></span> <span
					class="brand-title"> <img
						src="${hContext}/views/images/april_logo.png" alt="">
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
                        <li class="breadcrumb-item active"><a href="javascript:void(0)">개인 정보 수정</a></li>
                    </ol>
                </div>
            </div>
            <!-- row -->

            <div class="container-fluid">
                <div class="row justify-content-center">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-body">
                            	<div class="card-title">
                                    <h4>개인 정보 수정</h4>
                                </div>
                                <div class="form-validation">
                                    <form action="${aprilContext}/org/do_update.do" name="org_form" id="org_form" method="post" enctype="multipart/form-data">
                                    	<div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="profile">사진 <span class="text-danger"></span>
                                            </label>
                                            <div class="col-lg-3">
                                            	<!-- 사진 미리보기 https://codepen.io/buppagi/pen/wKwPBP -->
                                            	<table>
                                            		<tr>
                                            			<td style="width:150px;">
                                            				<!-- style="width: 150px; height: 180px; color: grey; border: 1px solid grey; dispaly: inline;" -->
                                            				<!-- URL : /groupware/resources/file_upload_img/2020/05/20200521223603e14a31e15955478eab54f34c7a9cd2cd.gif -->
                                            				<!-- URL 못 불러오면 [Window]-[Preferences]-[Workspace]-"Refresh using native hooks or polling" 체크 -->
                                            				<%-- <c:choose>
																<c:when test="${vo.imgFile==null || vo.imgFile.length()==0}">
																    <img class="card-img rounded-0" style="width:300px; height:300px" src="/Deep/DEEP_View/img/no_image.gif" alt="">
																</c:when>
																<c:otherwise>
																    <img class="card-img rounded-0" style="width:300px; height:300px" src="<c:out value="${vo.imgFile}"></c:out>" alt="">
															    </c:otherwise>
															</c:choose> --%>
															<!-- 이미지가 없을 경우 no_image -->
															<c:choose>
																<c:when test="${orgUpdateVO.saveFileName==null || orgUpdateVO.saveFileName.length()==0}">
																    <img alt="profile" src="${aprilContext}/img_cmn/no_image.gif" width="150px" height="180px"/>
																</c:when>
																<c:otherwise>
		                                                			<img alt="profile" src="${aprilContext}/${orgUpdateVO.saveFileName}" width="150px" height="180px"/>
															    </c:otherwise>
															</c:choose>
                                                		</td>
                                                		<td style="width:50px;"></td>
                                                		<td style="width:150px;">
															<div id='View_area' style='position:relative; width: 150px; height: 180px; display: inline;'></div>
                                                		</td>
                                                	</tr>
                                                	<tr>
                                                		<td colspan="3">
                                                			<input type="file" name="profile_after" id="profile_after" onchange="previewImage(this,'View_area')">
                                                			<input type="hidden" name="id" id="id" value="${user.id}" />
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
                                            <label class="col-lg-4 col-form-label" for="confirm_password">패스워드  확인 <span class="text-danger">*</span>
                                            </label>
                                            <div class="col-lg-6">
                                                <input type="password" class="form-control" id="confirm_password" name="confirm_password" placeholder="">
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
                                                <%-- <select class="form-control" id="grade" name="grade">
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
                                                </select> --%>
                                                <select class="form-control" id="grade" name="grade">
                                                    <option value="고졸" <c:if test="${orgUpdateVO.grade.split(',')[0] == '고졸'}"> selected="selected"</c:if>>
                                                    	고졸
                                                    </option>
                                                    <option value="전문학사" <c:if test="${orgUpdateVO.grade.split(',')[0] == '전문학사'}"> selected="selected"</c:if>>
                                                    	전문학사
                                                    </option>
                                                    <option value="학사" <c:if test="${orgUpdateVO.grade.split(',')[0] == '학사'}"> selected="selected"</c:if>>
                                                    	학사
                                                    </option>
                                                    <option value="석사" <c:if test="${orgUpdateVO.grade.split(',')[0] == '석사'}"> selected="selected"</c:if>>
                                                    	석사
                                                    </option>
                                                    <option value="박사" <c:if test="${orgUpdateVO.grade.split(',')[0] == '박사'}"> selected="selected"</c:if>>
                                                    	박사
                                                    </option>
                                                </select>
                                                <!-- TODO : ,로 split -->
                                                <input type="text" class="form-control" id="grade_sc_name" name="grade_sc_name" placeholder="학교명" value="${orgUpdateVO.grade.split(',')[1]}">
                                                <input type="text" class="form-control" id="grade_dp_name" name="grade_dp_name" placeholder="계열 및 전공학과명" value="${orgUpdateVO.grade.split(',')[2]}">
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="militaryYN">병역 사항 <span class=""></span>
                                            </label>
                                            <div class="col-lg-6">
                                            	<%-- <input type="text" id="military" name="military"/>
	                                            <select class="form-control" id="military" name="military">
	                                            	<option value="해당" <c:if test="${orgUpdateVO.militaryYN == '0'}"> selected="selected"</c:if>>
	                                                    	해당 없음
	                                                </option>
	                                            	<option value="군필" <c:if test="${orgUpdateVO.militaryYN == '1'}"> selected="selected"</c:if>>
	                                                    	군필
	                                                </option>
	                                                <option value="미필" <c:if test="${orgUpdateVO.militaryYN == '2'}"> selected="selected"</c:if>>
	                                                    	미필
	                                                </option>
	                                                <option value="군면" <c:if test="${orgUpdateVO.militaryYN == '3'}"> selected="selected"</c:if>>
	                                                    	군면제
	                                                </option>
	                                            </select> --%>
                                            	<label>
                                            		<input type="radio" name="militaryYN" value="0" <c:if test="${orgUpdateVO.militaryYN == '0'}"> checked="checked"</c:if>>
                                            		해당 없음
                                            	</label>
                                            	<label>
                                            		<input type="radio" name="militaryYN" value="1" <c:if test="${orgUpdateVO.militaryYN == '1'}"> checked="checked"</c:if>>
                                            		군필
                                            	</label>
                                            	<label>
                                            		<input type="radio" name="militaryYN" value="2" <c:if test="${orgUpdateVO.militaryYN == '2'}"> checked="checked"</c:if>>
                                            		미필
                                            	</label>
                                            	<label>
                                            		<input type="radio" name="militaryYN" value="3" <c:if test="${orgUpdateVO.militaryYN == '3'}"> checked="checked"</c:if>>
                                            		군면제
                                            	</label>
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label class="col-lg-4 col-form-label" for="dspsnYN">장애 여부<span class=""></span>
                                            </label>
                                            <div class="col-lg-6">
                                            	<%--<input type="text" id="disabled" name="disabled"/>
                                            	<select class="form-control" id="disabled" name="disabled">
	                                            	<option value="비대상" <c:if test="${orgUpdateVO.dspsnYN == '0'}"> selected="selected"</c:if>>
	                                                    	비대상
	                                                </option>
	                                            	<option value="대상" <c:if test="${orgUpdateVO.dspsnYN == '1'}"> selected="selected"</c:if>>
	                                                    	대상
	                                                </option>
	                                            </select> --%>
                                            	<label>
                                            		<input type="radio" name="dspsnYN" value="0" <c:if test="${orgUpdateVO.dspsnYN == '0'}"> checked="checked"</c:if>>
                                            		비대상
                                            	</label>
                                            	<label>
                                            		<input type="radio" name="dspsnYN" value="1" <c:if test="${orgUpdateVO.dspsnYN == '1'}"> checked="checked"</c:if>>
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

	<script src="${aprilContext}/views/js/jquery-migrate-1.4.1.js"></script>
	<script src="${aprilContext}/views/js/jquery.validate.js"></script>
    <%-- <script src="${aprilContext}/views/plugins/validation/jquery.validate.min.js"></script>
    <script src="${aprilContext}/views/plugins/validation/jquery.validate-init.js"></script> --%>
	
	<script type="text/javascript">

		//input 태그 유효성 검사
		function bindEventHandler() {
			$("#org_form").validate({
				//서버 전송 여부 : true-유효성 검사만 함, false-DB로 넘김 
				onfocus : false,
				debug : true,
				rules : {
					//name 속성 값 (name=password)
					password : {
						//필수값
						//required : true,
						//최소 길이
						//minlength : 4,
						//최대 길이
						//maxlength : 20,
						//범위
						rangelength : [4, 20]
					}, confirm_password : {
						//필수값
						required : true,
						//범위
						rangelength : [4, 20],
						//password == password
						equalTo: "#password"
					}, email : {
						//이메일 형식
						email: true
					}, mobile : {
						//범위
						range: [12, 13]
					}
				},
				//message
				messages : {
					//name, pass : id 속성으로
					password : {
						//최소길이
						//minlength : $.validator.format('비밀번호는 최소{0}자 ~ 최대{1}자로 입력하세요.')
						rangelength : $.validator.format('패스워드는 최소 {0}자 ~ 최대 {1}자로 입력하세요.')
					}, confirm_password : {
						//필수값 
						required : "패스워드 확인을 반드시 입력해주세요.",
						//최소길이
						rangelength : $.validator.format('패스워드는 최소 {0}자 ~ 최대 {1}자로 입력하세요.'),
						//pass == comfirm_pass
						equalTo: "패스워드와 패스워드 확인이 일치하지 않습니다."
					}, email : {
						//이메일 형식
						email: "올바른 이메일 형식이 아닙니다. ex)abc@email.com"
					}, mobile : {
						//범위
						range: $.validator.format('휴대폰 번호는 {0}~{1}자로 입력하세요. ex)010-000-0000')
					}
				}, errorElement: "em", errorPlacement: function ( error, element ) {
					// Add the `help-block` class to the error element
					error.addClass( "help-block" );
					
					if ( element.prop( "type" ) === "checkbox" ) {
					    error.insertAfter( element.parent( "label" ) );
					} else {
					    error.insertAfter( element );
					}
				}, highlight: function ( element, errorClass, validClass ) {
				    $( element ).parents( ".col-lg-5" ).addClass( "has-error" ).removeClass( "has-success" );
				}, unhighlight: function (element, errorClass, validClass) {
				    $( element ).parents( ".col-lg-5" ).addClass( "has-success" ).removeClass( "has-error" );
				}
	    	});
		}

		$(document).ready(function() {
			bindEventHandler();
		});
		//--input 태그 유효성 검사

		//전화번호 자동 하이픈
		var autoHypenPhone = function(str){
			str = str.replace(/[^0-9]/g, '');
			var tmp = '';
			if( str.length < 4){
			    return str;
			} else if(str.length < 7){
			    tmp += str.substr(0, 3);
			    tmp += '-';
			    tmp += str.substr(3);
			    return tmp;
			} else if(str.length < 11){
			    tmp += str.substr(0, 3);
			    tmp += '-';
			    tmp += str.substr(3, 3);
			    tmp += '-';
			    tmp += str.substr(6);
			    return tmp;
			} else {              
			    tmp += str.substr(0, 3);
			    tmp += '-';
			    tmp += str.substr(3, 4);
			    tmp += '-';
			    tmp += str.substr(7);
			    return tmp;
			}
			return str;
		}

		var mobile = document.getElementById('mobile');

		mobile.onkeyup = function(){
			console.log(this.value);
			this.value = autoHypenPhone(this.value) ;  
		}
		//--전화번호 자동 하이픈
		
		//취소-초기화
		$("#cancel_btn").on("click", function(){
			console.log("#cancel_btn");
	
			//입력 초기화
			$("#profile_after").val("");
			$("#password").val("");
			$("#confirm_password").val("");
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
 
		//정보 수정 버튼
		$("#update_btn").on("click", function(){
			console.log("#update_btn");
			//org_form
			//var form = $('form')[0]; //Form data read, 폼 태그 중에 1번째 폼을 불러옴
	        //var formData = new FormData(form);

			if(confirm("수정하시겠습니까?") == true) {

			var form = document.org_form;
	        form.submit();
                
            //버튼으로 submit할 경우 form과 ajax가 두 번 동작해서 form으로만 돌리고 controller에서 리디렉션함
	            //$.ajax({
	            //	async: false,
	            //    cache: false,
				//	processData: false,
				//	contentType: false,
				//	enctype: "multipart/form-data",
			    //    type:"POST",
			    //    url:"${aprilContext}/org/do_update.do",
			    //    //dataType:"html", 
			    //    data: formData,
			    //    //data:{
				//	//    "id": id,
				//	//    "password": password,
				//	//    "email": email,
				//	//    "mobile": mobile,
				//	//    "address": address,
				//	//    "grade": grade,
				//	//    "militaryYN": militaryYN,
				//	//    "dspsnYN": dspsnYN
			    //    //},
				//	//성공
			    //    success:function(data){
                //        //alert(data);
                //        window.location.href="http://localhost:8080/groupware/org/do_select_one.do?id=kimjh1";
                //        location.href="http://localhost:8080/groupware/org/do_select_one.do?id=kimjh1";
				//        goAttend();
                //        alert("성공");
                //
				//        var jData = JSON.parse(data);
                //        if(null != jData && jData.msgId == "1"){
                //            alert(jData.msgMsg);
                //        } else {
                //            alert(jData.msgMsg);
                //        }
				//	},
				//	//에러
		        //    error:function(xhr,status,error){
		        //    	alert("error:"+error);
		        //    },
		        //    complete:function(data){
		        //    }   
				//}); //--ajax
			}
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
						if (!document.getElementById("sfr_preview_error_" + View_area)) {
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