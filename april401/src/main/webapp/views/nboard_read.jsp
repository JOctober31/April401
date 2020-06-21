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

<%@page import="com.april.groupware.nboard.service.NBAnswerVO"%>
<%@page import="com.april.groupware.cmn.StringUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.april.groupware.code.service.CodeVO"%>
<%@page import="com.april.groupware.cmn.SearchVO"%>
<%@page import="com.april.groupware.member.service.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib  prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib  prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="/common/common.jsp"%>
<%
     //session
    UserVO userInfo = (UserVO) session.getAttribute("user");

    //List<NBAnswerVO> list = (List<NBAnswerVO>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>전사게시판_상세페이지</title>
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="${hContext}/views/images/favicon.png">
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
                        <li class="breadcrumb-item active"><a href="javascript:void(0)">Home</a></li>
                    </ol>
                </div>
            </div>
            <!-- row -->

            <div class="container-fluid">
            <div class="bootstrap-label">
            <div class="toolbar" role="toolbar">
              <span style="font-size:1.7em; text-align:center; line-height:30px; height: 40px; width: 150px;" class="label label-info" >전사게시판</span>
            </div>
                <div class="row">
                    <div class="col-lg-12">
                    <form name="searchFrm" id="searchFrm" method="get">
                        <div class="card">
                            <div class="card-body">
                                <div class="email-box">
                                    <div class="toolbar" role="toolbar">
                                        <div class="btn-group" style="float:right;">
                                         <!-- 마지막에 풀기 -->
                                         <c:choose>
                                            <c:when test="${9 eq user.auth}">
                                              <input type="button" style="margin:0.2em; height: 30px; width: 100px; text-align:center;" 
                                                     class="label label-pill label-danger"
                                                     value="삭제" id="delete_btn" name="delete_btn" />
                                              <input type="button" style="margin:0.2em; height: 30px; width: 100px; text-align:center;" 
                                                     class="label label-pill label-danger" value="수정"
                                                     id="update_btn" name="update_btn" />
                                           </c:when>
                                         </c:choose>
                                              <input type="text" style="margin:0.2em; height: 30px; width: 100px; text-align:center;" class="label label-pill label-success" 
                                                     id="nbNo" name="nbNo" value="글번호  ${vo.nbNo }"  readonly="readonly"/>
                                              <label style="margin:0.2em; height: 30px; width: 100px; text-align:center;" class="label label-pill label-success"
                                                     >조회수 ${vo.readCnt }</label>
                                              <span style="margin:0.2em; height: 30px; width: 100px; text-align:center;" class="label label-pill label-success">댓글  ${list.size()}</span>
                                              <input type="button" style="margin:0.2em; height: 30px; width: 100px; text-align:center;" class="label label-pill label-success"
                                                     value="글 목록" id="list_btn" onclick="goRetrieve();" />
                                        </div>
                                    </div>
                                    
                                    <!-- 게시글 내용 영역 -->
                                    <div class="read-content">
                                    <div class="media mb-4 mt-1">
                                            <div class="media" style="display: flex; padding-right: 1em;">
                                                ${vo.nbCategory }
                                            </div>
                                                <div class="media-body" style="margin: 0; padding: 0;">
                                                 <%-- <input type="hidden" id="nbTitle" value="${vo.nbTitle }"/> --%>
                                                    <h4 class="m-0 text-primary" style="font-weight: bolder;">${vo.nbTitle }</h4>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="media pt-3">
                                            <img class="mr-3 rounded-circle" src="${hContext}/views/images/avatar/1.jpg">
                                            <div class="media-body">
                                                <%-- <input type="hidden" id="regId" value="${vo.regId }"/>
                                                <input type="hidden" id="regDate" value="${vo.regDate }"/> --%>
                                                <h5 class="m-b-3">등록자 ${vo.regId }</h5>
                                                <p class="m-b-2">등록일 ${vo.regDate }</p>
                                            </div>
                                            <!-- 수정시 수정자 아이디/수정일 -->
                                        </div>
                                            <c:choose>
                                                <c:when test="${vo.modId != null}">     
                                                    <p class="m-b-2" > 수정자 ${vo.modId} 수정일 ${vo.modDate }</p>
                                                </c:when>
                                             </c:choose>
                                        <hr>
                                         <pre><c:out value="${vo.nbContents}" /></pre>
                                         <%-- <input type="hidden" id="nbContents" value="${vo.nbContents }"/>
                                       <h5 class="m-b-15">${vo.nbContents }</h5> --%>
                                        <hr>
                                      <!-- // 게시글 내용 영역 -->
                                    </div>
                                </div>
                            </div>
                                      </form>
                        </div>
                        
                        
                        <!--div 댓글 작성 -->
                        <div class="col-lg-12">
                        <div class="card">
                            <div class="card-body" style="padding-bottom: 1em;">
                                <span style="margin-bottom:1em; height: 30px; width: 100px; text-align:center;" class="label label-pill label-danger">댓글 작성</span>
                                <div class="basic-form">
                                    <form id="answerFrm" name="answerFrm">
                                        <div class="form-group">
                                            <table>
                                                <tr>
                                                    <td>
                                                    <img class="mr-3 circle-rounded" src="${hContext}/views/images/avatar/2.jpg" width="50" height="50" alt="Generic placeholder image">
                                                    </td>
                                                    <td width="1500px">
                                                   <textarea class="form-control h-150px" rows="2" id="aw_contents" placeholder="댓글 내용을 입력하세요."></textarea>
                                                   <input type="hidden" id="awRegId" name="awRegId" value=" ${user.id }">
                                                   </td>
                                                </tr>
                                                <tr>
                                                   <td colspan = "2" align="right" style="padding-top: 1em;">
                                                       <button type="button" class="btn mb-1 btn-outline-info" id="aw_insert_btn">댓글 등록</button>
                                                   </td>
                                                </tr>
                                            </table>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        
                        
                        
                        
                       <!--div 댓글 읽기 -->
                        <div class="card">
                            <div class="card-body">
                             <span style="margin-bottom:1em; height: 30px; width: 100px; text-align:center;" class="label label-pill label-success">댓글</span>
                                <c:choose>
			                        <c:when test="${list.size()>0 }">
			                            <c:forEach var="vo" items="${list }">
                                <div class="media media-reply">
                                    <div class="media-body">
                                        <div class="d-sm-flex justify-content-between mb-2">
                                            <h6 class="mb-sm-0"><c:out value="${vo.deptNm } ${vo.position } ${vo.name }" /></h6>
                                             <small class="text-muted ml-3"><c:out value="${vo.regDate }" /></small>
                                        </div>
                                        <p><c:out value="${vo.awContents }" /></p>
                                </div>
                            </div>
                            </c:forEach>
                            </c:when>
                            <c:otherwise>
                            <div class="media media-reply">
                                    <div class="media-body">
                                        <div class="d-sm-flex justify-content-between mb-2">
                                            <h5 class="mb-sm-0"><small class="text-muted ml-3"></small></h5>
                                        </div>
                                        <p> 등록된 댓글이 없습니다.</p>
                                </div>
                            </div>
                            </c:otherwise>
                            </c:choose>
                        
                            
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
    <script type="text/javascript">
    //목록 화면으로 이동
    function goRetrieve(){
        location.href="${hContext}/nboard/do_retrieve.do?pageNum=1&nbNo=&pageSize=10&searchDiv=&searchWord=";
        //location.href="${hContext}/nboard/nboard_list.jsp";
    }

  //수정 화면으로 이동
    $("#update_btn").on("click",function(){
            var nbNo = ${vo.nbNo };
            var readCnt = ${vo.readCnt };
            console.log("nbNo:"+nbNo);
            console.log("readCnt:"+readCnt);
             var frm = document.searchFrm;
             frm.nbNo.value = nbNo;
             frm.action = "${hContext}/nboard/do_selectone_update.do";
             frm.submit();
             
             
         });
    

    // 삭제하기 - 관리자만 보여짐
    $("#delete_btn").on("click",function(){
        console.log("delete_btn");
        var nbNo = ${vo.nbNo };
        //var nbNo = $("#nbNo").val();
        console.log("nbNo : "+nbNo);

        if(false==confirm("삭제 하시겠습니까?"))return;

        $.ajax({
                   type:"POST",
                   url:"${hContext}/nboard/do_delete.do",
                   dataType:"html", 
                   data:{"nbNo":nbNo  },
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
                   alert("error:"+error);
               },
               complete:function(data){
               
               }   
               
       });//--ajax
    });

    //댓글 입력
    $("#aw_insert_btn").on("click",function(){

                
        //nbContents 내용 미입력시 
        var awContents = $("#aw_contents").val().trim();
        if(null==awContents || awContents.length<=1){
           $("#aw_contents").focus();
           alert("댓글 내용을 입력하세요.");
           return;
        }

        //게시글번호
        var nbNo = ${vo.nbNo };
        console.log("nbNo : "+nbNo);

        //var regId = regId;
        var awRegId = $("#awRegId").val().trim();
        console.log("awRegId : "+awRegId);

        /* var awRegId = $("#awRegId").val().trim();
        if(null==awRegId || awRegId.length<=1){
           $("#regId").focus();
           alert("아이디를 입력하세요.");
           return;
        } */

        if(false==confirm("등록하시겠습니까?")) return;
        
      //ajax
        $.ajax({
           type:"POST",
           url:"${hContext }/nbAnswer/do_insert.do",
           dataType:"html", 
           data:{"nbNo":nbNo,
                 "awContents":awContents,
                 "regId":awRegId
           },
           success:function(data){ //성공
              //{"msgId":"1","msgMsg":"삭제 되었습니다.","num":0,"totalCnt":0}
              //alert(data);

              var jData = JSON.parse(data);
              if(null != jData && jData.msgId=="1"){
                 alert(jData.msgMsg);
                 //등록 성공시 페이지 새로고침
                 location.reload();
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
     }); //--insert_btn

    </script>
</body>

</html>