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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ include file="/common/common.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>April Groupware</title>
<!-- Favicon icon -->
<link rel="icon" type="image/png" sizes="16x16"
	href="images/favicon.png">
<!-- Custom Stylesheet -->
<link href="${hContext}/views/plugins/tables/css/datatable/dataTables.bootstrap4.min.css" rel="stylesheet">
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
`
		<!--**********************************
            Content body start
        ***********************************-->
		<div class="content-body">
			<div class="row page-titles mx-0">
				<div class="col p-md-0">
					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="javascript:void(0)">관리자 페이지</a></li>
						<li class="breadcrumb-item active"><a href="javascript:void(0)">조직 데이터 등록</a></li>
					</ol>
				</div>
			</div>
			<!-- row -->

			<div class="container-fluid">


				<!-- 조직데이터 등록 수정 삭제 -->
				<div class="row justify-content-center">

					<div class="col-lg-12">

						<div class="card">

							<div class="card-body">
								<h4 class="card-title">조직 데이터 등록</h4>
								<div class="form-validation">
									<%-- <form class="form-horizontal"action="${hContext}/admin/do_insert.do" name="mngFrm"
										id="mngFrm" method="post"> --%>
										<div class="form-group row">
											<label class="col-lg-4 col-form-label">아이디 <span
												class="text-danger">*</span>
											</label>
											<div class="col-lg-6">
												<input type="text" class="form-control" id="id" name="id" placeholder="아이디 입력하세요">
											</div>
										</div>

										<div class="form-group row">
											<label class="col-lg-4 col-form-label">패스워드 <span class="text-danger">*</span>
											</label>
											<div class="col-lg-6">
												<input type="password" class="form-control" id="password" name="password" placeholder="패스워드 입력하세요">
											</div>
										</div>
										<div class="form-group row">
											<label class="col-lg-4 col-form-label">패스워드 확인 <span class="text-danger">*</span>
											</label>
											<div class="col-lg-6">
												<input type="password" class="form-control" id="password_check" name="password_check" placeholder="패스워드 확인하세요">
											</div>
										</div>
											
										<div class="form-group row">
											<label class="col-lg-4 col-form-label">이름 <span
												class="text-danger">*</span>
											</label>
											<div class="col-lg-6">
												<input type="text" class="form-control" id="name" name="name" placeholder="이름을 입력하세요">
											</div>
										</div>	
											
										<div class="form-group row">
											<label class="col-lg-4 col-form-label">부서명 <span
												class="text-danger">*</span>
											</label>
											<div class="col-lg-6">
												<select class="form-control" id="dept_nm" name="dept_nm">
													<option value="">부서 선택</option>
													<option value="인사">인사</option>
													<option value="영업">영업</option>
													<option value="개발">개발</option>
													<option value="운영">운영</option>
												</select>
											</div>
										</div>

										<div class="form-group row">
											<label class="col-lg-4 col-form-label">권한 <span
												class="text-danger">*</span>
											</label>
											<div class="col-lg-6">
												<select class="form-control" id="auth" name="auth">
													<option value="">권한 선택</option>
													<option value="1">사용자</option>
													<option value="9">결재자</option>
												</select>
											</div>
										</div>


										<div class="form-group row">
											<label class="col-lg-4 col-form-label">직급 <span
												class="text-danger">*</span>
											</label>
											<div class="col-lg-6">
												<select class="form-control" id="position" name="position">
													<option value="">직급선택</option>
													<option value="사원">사원</option>
													<option value="과장">과장</option>
													<option value="차장">차장</option>
													<option value="부장">부장</option>
													<option value="이사">이사</option>
													<option value="대표이사">대표이사</option>
												</select>
											</div>
										</div>


										<div class="form-group row">
											<label class="col-lg-4 col-form-label" for="val-currency">입사일<span
												class="text-danger">*</span>
											</label>
											<div class="col-lg-6">
												<input type="text" class="form-control" id="hire_date"
													name="hire_date" placeholder="ex) 20200508">
											</div>
										</div>

										<div class="form-group row">
											<div class="col-lg-8 ml-auto">
												<input type="button" class="btn btn-primary" value="등록" id="insert_btn" />
												<input type="button"class="btn btn-danger" onclick="goRetrieve();" value="목록" id="list_btn" /> 
											</div>
										</div>
								<!-- </form> -->
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- #/ container -->


		<!-- 쓰기폼 -->

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

	<script src="${hContext}/views/plugins/tables/js/jquery.dataTables.min.js"></script>
	<script
		src="${hContext}/views/plugins/tables/js/datatable/dataTables.bootstrap4.min.js"></script>
	<script src="${hContext}/views/plugins/tables/js/datatable-init/datatable-basic.min.js"></script>



	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->
	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다) -->

	<script type="text/javascript">
		function goRetrieve() {
			location.href = "${hContext}/admin/do_retrieve.do?pageNum=1&pageSize=10&searchDiv=&searchWord=";
		}

		 $("#insert_btn").on("click",function(){

				var id = $("#id").val().trim();
	            if(null == id || id.length<=1){
	            	$("#id").focus();
	                alert("아이디를 입력하세요.");
	                return;
	            }

	         	var password = $("#password").val().trim();
	            if(null == password || password.length<=1){
	                $("#password").focus();
	                alert("패스워드를 입력하세요.");
	                return;
	            }

	           	var passwordCheck = $("#password_check").val().trim();
	            if(passwordCheck != password){
	                $("#passwordCheck").focus();
	                alert("패스워드가 다릅니다.");
	                return;
	            }

	        	var name = $("#name").val().trim();
	            if(null == name || name.length<=1){
	            	$("#name").focus();
	                alert("이름을 입력하세요.");
	                return;
	            }
	            

	            var deptNm = $("#dept_nm option:selected").val().trim();
	            if(null == deptNm || deptNm.length<=1){
	                $("#dept_nm").focus();
	                alert("부서명을 입력하세요.");
	                return;
	            }        	
	            
	        	var auth =  $("#auth option:selected").val().trim();
	            if(null == auth || auth.length <0){
	                $("#auth").focus();
	                alert("권한을 입력하세요.");
	                return;
	            }         
	            
	        	var position =  $("#position option:selected").val().trim();;
	        	
	            if(null == position || position.length < 0){
	                $("#position").focus();
	                alert("직급을 입력하세요.");
	                return;
	            }
	            
	            var hiredate = $("#hire_date").val().trim();
	            if(null == hiredate || hiredate.length<=1){
	                $("#hire_date").focus();
	                alert("입사일을 입력하세요.");
	                return;
	            }
	            
         if(false==confirm("등록 하시겠습니까?"))return;

         $.ajax({
                    type:"POST",
                    url:"${hContext}/admin/do_insert.do",
                    dataType:"html", 
                    data:{
                             "id":id,
                             "password":password,
                             "name": name,
                             "deptNm":deptNm,
                             "auth":auth,
                             "position":position,
                             "hiredate":hiredate
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
                    alert(id+"는 이미 사용중입니다.");
                },
                complete:function(data){
                
                }   
                
        });//--ajax

     });

 </script>   

</body>

</html>