<%--
  /**
  * Class Name : 
  * Description : 
  * Modification Information
  *  수정일                   수정자                      수정내용
  *  -------    --------    ---------------------------
  * 2020. 4. 24.            최초 생성
  * author 실행환경 개발팀
  * since 2009.01.06
  *
  * Copyright (C) 2009 by KandJang  All right reserved.
  */
  * dash/do_selectone.do
--%>
<%@page import="com.april.groupware.dash.service.DashDeptVO"%>
<%@page import="com.april.groupware.dash.service.DashTodoVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
    <link rel="icon" type="${hContext}/views/image/png" sizes="16x16" href="${hContext}/views/images/favicon.png">
    <!-- Pignose Calender -->
    <link href="${hContext}/views/plugins/pg-calendar/css/pignose.calendar.min.css" rel="stylesheet">
    <!-- Chartist -->
    <link rel="stylesheet" href="${hContext}/views/plugins/chartist/css/chartist.min.css">
    <link rel="stylesheet" href="${hContext}/views/plugins/chartist-plugin-tooltips/css/chartist-plugin-tooltip.css">
    <!-- Custom Stylesheet -->
    <link href="${hContext}/views/css/style.css" rel="stylesheet">
    <link href="${hContext}/views/css/morris.min.js" rel="stylesheet">
    <script src="${hContext}/views/js/jquery-migrate-1.4.1.js"></script>
	<script src="http://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
	<script src="http://code.jquery.com/jquery-1.8.2.min.js"></script>
  	<!-- <script src="http://cdn.oesmith.co.uk/morris-0.4.1.min.js"></script> -->

	<!--A:인디고, B주황, C핑크,D블루 -->
    <script>
        jQuery(document).ready(function($) {

    		/* 인사부서 */
        	var hr01 = $("#hr01").val();
        	var hr02 = $("#hr02").val();
        	var hr03 = $("#hr03").val();
        	var hr04 = $("#hr04").val();
        	var hr05 = $("#hr05").val();
        	
        	/* 영업 부서 */
        	var salse01 = $("#salse01").val();
        	var salse02 = $("#salse02").val();
        	var salse03 = $("#salse03").val();
        	var salse04 = $("#salse04").val();
        	var salse05 = $("#salse05").val();
        	
        	/* 운영 부서 */
        	var oper01 = $("#oper01").val();
        	var oper02 = $("#oper02").val();
        	var oper03 = $("#oper03").val();
        	var oper04 = $("#oper04").val();
        	var oper05 = $("#oper05").val();

        	/* 개발 부서 */
        	var dev01 = $("#dev01").val();
        	var dev02 = $("#dev02").val();
        	var dev03 = $("#dev03").val();
        	var dev04 = $("#dev04").val();
        	var dev05 = $("#dev05").val();
            
            Morris.Area({
                element: 'area-chart',
                data: [
                    { y: '2020-01', 인사: hr01,  영업: salse01 ,개발: oper01 ,운영: dev01},
                    { y: '2020-02', 인사: hr02,  영업: salse02 ,개발: oper02 ,운영: dev02},
                    { y: '2020-03', 인사: hr03,  영업: salse03 ,개발: oper03 ,운영: dev03},
                    { y: '2020-04', 인사: hr04,  영업: salse04 ,개발: oper04 ,운영: dev04},
                    { y: '2020-05', 인사: hr05,  영업: salse05 ,개발: oper05 ,운영: dev05}
                ],
                xkey: 'y',
                ykeys:  ['인사', '영업', '개발', '운영'],
                labels: ['인사팀', '영업팀','개발팀','운영팀'],
          /*   fillOpacity: 0.9, */
            resize: true,
            parseTime: true,
            grid: false,
            smooth: true,
            behaveLikeLine:true,
            lineColors: ['#7b73fb', '#ffa463','#fb7a93','#396bfe']
            });
        });
    </script>
    
    
    
       <!--  font style -->
    <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@500&display=swap" rel="stylesheet">
	<style type="text/css">
	h4 {
		font-family: 'Noto Sans KR', sans-serif;
	}
	
	a {
		font-family: 'Noto Sans KR', sans-serif;
	}
	

	</style>
    


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

            <div class="container-fluid mt-3">
                <div class="row">
                    <div class="col-lg-3 col-sm-6">
                        <div class="card gradient-1">
                            <div class="card-body">
                                <h3 class="card-title text-white">인사팀</h3>
                                <div class="d-inline-block">
                                    <h2 class="text-white">${hrVO.customer }</h2>
                                    <p class="text-white mb-0">${hrVO.taskContents }</p>
                                </div>
                                <span class="float-right display-5 opacity-5"><i class="fa fa-shopping-cart"></i></span>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="card gradient-2">
                            <div class="card-body">
                                <h3 class="card-title text-white">영업팀</h3>
                                <div class="d-inline-block">
                                    <h2 class="text-white">${salseVO.customer }</h2>
                                    <p class="text-white mb-0">${salseVO.taskContents }</p>
                                </div>
                                <span class="float-right display-5 opacity-5"><i class="fa fa-money"></i></span>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="card gradient-3">
                            <div class="card-body">
                                <h3 class="card-title text-white">운영팀</h3>
                                <div class="d-inline-block">
                                    <h2 class="text-white">${operVO.customer }</h2>
                                    <p class="text-white mb-0">${operVO.taskContents }</p>
                                </div>
                                <span class="float-right display-5 opacity-5"><i class="fa fa-users"></i></span>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="card gradient-4">
                            <div class="card-body">
                                <h3 class="card-title text-white">개발팀</h3>
                                <div class="d-inline-block">
                                    <h2 class="text-white">${devVO.customer }</h2>
                                    <p class="text-white mb-0">${devVO.taskContents }</p>
                                </div>
                                <span class="float-right display-5 opacity-5"><i class="fa fa-heart"></i></span>
                            </div>
                        </div>
                    </div>
                </div>
					
				<!-- 인사부서 -->	
				<input type="hidden" name="hr01" id="hr01" value="${dhrVO.jan}" />
				<input type="hidden" name="hr02" id="hr02" value="${dhrVO.feb}" />
				<input type="hidden" name="hr03" id="hr03" value="${dhrVO.mar}" />
				<input type="hidden" name="hr04" id="hr04" value="${dhrVO.apr}" />
				<input type="hidden" name="hr05" id="hr05" value="${dhrVO.may}" />
				
				<!-- 영업부서 -->	
				<input type="hidden" name="salse01" id="salse01" value="${dsalseVO.jan}" />
				<input type="hidden" name="salse02" id="salse02" value="${dsalseVO.feb}" />
				<input type="hidden" name="salse03" id="salse03" value="${dsalseVO.mar}" />
				<input type="hidden" name="salse04" id="salse04" value="${dsalseVO.apr}" />
				<input type="hidden" name="salse05" id="salse05" value="${dsalseVO.may}" />
				
				
				<!-- 운영 부서 -->	
				<input type="hidden" name="oper01" id="oper01" value="${doperVO.jan}" />
				<input type="hidden" name="oper02" id="oper02" value="${doperVO.feb}" />
				<input type="hidden" name="oper03" id="oper03" value="${doperVO.mar}" />
				<input type="hidden" name="oper04" id="oper04" value="${doperVO.apr}" />
				<input type="hidden" name="oper05" id="oper05" value="${doperVO.may}" />
				
				
				<!-- 개발부서 -->	
				<input type="hidden" name="dev01" id="dev01"  value="${ddevVO.jan}" />
				<input type="hidden" name="dev02" id="dev02"  value="${ddevVO.feb}" />
				<input type="hidden" name="dev03" id="dev03" value="${ddevVO.mar}" />
				<input type="hidden" name="dev04" id="dev04" value="${ddevVO.apr}" />
				<input type="hidden" name="dev05" id="dev05" value="${ddevVO.may}" />
				


				<div class="row">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-body">
								<h4 class="card-title" align="center">부서 별 업무 지원 현황</h4>

								<!-- 그래프 데이터 세팅 -->
								<div id="area-chart"></div>
							

							</div>
							
						</div>
					</div>
				</div>
				

                <div class="row">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="active-member">
                                    <div class="table-responsive">
                                        <table class="table table-xs mb-0">
                                            <thead class="bg-primary" style="text-align: center; color:white;">
                                            
                                            <h4 class="card-title" align="center">전사 게시판</h4>
                                                <tr style="text-align: center">
                                                    <th>글번호</th>
                                                    <th>분류</th>
                                                    <th>제목</th>
                                                    <th>등록자</th>
                                                    <th>등록일</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:choose>
												    <c:when test="${dashNbList.size()>0 }">
												        <c:forEach var="vo" items="${dashNbList }">
												            <tr>
												                <td class="text-center hidden-sm hidden-xs"> <c:out value="${vo.nbNo }" /></td>
												                <td class="text-center"><c:out value="${vo.nbCategory }" /></td>
												                <td class="text-left"><c:out value="${vo.nbTitle }" /></td>
												                <td class="text-center"><c:out value="${vo.regId }" /></td>
												                <td class="text-center hidden-sm hidden-xs  "><c:out value="${vo.regDate }" /></td>
												            </tr>
												        </c:forEach>
												    </c:when>
												    <c:otherwise>
												        <tr>
												            <td class="text-center">No data found.</td>
												        </tr>
												    </c:otherwise>
												</c:choose>
                                           
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>                        
                    </div>
                </div>

                <div class="row">
                    <div class="col-xl-3 col-lg-6 col-sm-6 col-xxl-6">

                        
                    </div>
                    <div class="col-xl-3 col-lg-6 col-sm-6 col-xxl-6">
                        <div class="card">
                       
                        </div>
                    </div>
                    <div class="col-xl-6 col-lg-12 col-sm-12 col-xxl-12">
                        <div class="card">
                          
                        </div>
                    </div>
                </div>

                

                <div class="row">
                        <div class="col-lg-3 col-sm-6">
                            <div class="card">
                                <div class="social-graph-wrapper widget-facebook">
                                    <a class="s-icon" style="font-size: 20px">인사팀 출근현황</a>
                                </div>
                                <div class="row">
                                    <div class="col-6 border-right">
                                        <div class="pt-3 pb-3 pl-0 pr-0 text-center">
                                            <h4 class="m-1">근무 인원</h4>
                                            <p class="m-0"> 5 명</p>
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="pt-3 pb-3 pl-0 pr-0 text-center">
                                            <h4 class="m-1">총 인원</h4>
                                            <p class="m-0">5 명</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-sm-6">
                            <div class="card">
                                <div class="social-graph-wrapper widget-linkedin">
                                      <a class="s-icon" style="font-size: 20px">영업팀 출근현황</a>
                                </div>
                                <div class="row">
                                    <div class="col-6 border-right">
                                        <div class="pt-3 pb-3 pl-0 pr-0 text-center">
                                            <h4 class="m-1">근무 인원</h4>
                                            <p class="m-0"> 4 명</p>
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="pt-3 pb-3 pl-0 pr-0 text-center">
                                            <h4 class="m-1">총 인원</h4>
                                            <p class="m-0">5 명</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-sm-6">
                            <div class="card">
                                <div class="social-graph-wrapper widget-googleplus">
                                      <a class="s-icon" style="font-size: 20px">운영팀 출근현황</a>
                                </div>
                                <div class="row">
                                    <div class="col-6 border-right">
                                        <div class="pt-3 pb-3 pl-0 pr-0 text-center">
                                            <h4 class="m-1">근무 인원</h4>
                                            <p class="m-0"> 3 명</p>
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="pt-3 pb-3 pl-0 pr-0 text-center">
                                            <h4 class="m-1">총 인원</h4>
                                            <p class="m-0">5 명</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-sm-6">
                            <div class="card">
                                <div class="social-graph-wrapper widget-twitter">
                                       <a class="s-icon" style="font-size: 20px">개발팀 출근현황</a>
                                </div>
                                <div class="row">
                                    <div class="col-6 border-right">
                                        <div class="pt-3 pb-3 pl-0 pr-0 text-center">
                                            <h4 class="m-1">근무 인원</h4>
                                            <p class="m-0"> 5 명</p>
                                        </div>
                                    </div>
                                    <div class="col-6">
                                        <div class="pt-3 pb-3 pl-0 pr-0 text-center">
                                            <h4 class="m-1">총 인원</h4>
                                            <p class="m-0">5 명</p>
                                        </div>
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

    <!-- Chartjs -->
    <script src="${hContext}/views/plugins/chart.js/Chart.bundle.min.js"></script>
    <!-- Circle progress -->
    <script src="${hContext}/views/plugins/circle-progress/circle-progress.min.js"></script>
    <!-- Datamap -->
    <script src="${hContext}/views/plugins/d3v3/index.js"></script>
    <script src="${hContext}/views/plugins/topojson/topojson.min.js"></script>
    <script src="${hContext}/views/plugins/datamaps/datamaps.world.min.js"></script>
    <!-- Morrisjs -->
    <script src="${hContext}/views/plugins/raphael/raphael.min.js"></script>
    <script src="${hContext}/views/plugins/morris/morris.min.js"></script>
    <script src="${hContext}/views/js/plugins-init/morris-init.js"></script>
    <!-- Pignose Calender -->
    <script src="${hContext}/views/plugins/moment/moment.min.js"></script>
    <script src="${hContext}/views/plugins/pg-calendar/js/pignose.calendar.min.js"></script>
    <!-- ChartistJS -->
    <script src="${hContext}/views/plugins/chartist/js/chartist.min.js"></script>
    <script src="${hContext}/views/plugins/chartist-plugin-tooltips/js/chartist-plugin-tooltip.min.js"></script>



    <script src="${hContext}/views/js/dashboard/dashboard-1.js"></script>

</body>

</html>