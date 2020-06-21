<%--
  /**
  * Class Name : 
  * Description : 
  * Modification Information
  *
  *   수정일                   수정자                      수정내용
  *  -------    --------    ---------------------------
  *  2020. 3. 18.            최초 생성
  *
  * author 실행환경 개발팀
  * since 2009.01.06
  *
  * Copyright (C) 2020 by SOMAC  All right reserved.
  */
--%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


	<!-- sidebar start  -->
	<div class="nk-nav-scroll">
		<ul class="metismenu" id="menu">
			<li class="nav-label">${user.name}님 환영합니다</li>
			
			<!-- 관리자페이지 네비게이션 시작 -->
			<li>
			    <a class="has-arrow" href="javascript:void()" aria-expanded="false">
			        <i class="icon-speedometer menu-icon"></i><span class="nav-text">관리자페이지</span>
			    </a>
			    <ul aria-expanded="false">
				    <c:set var="orgId" value="${user.id}" />
		               <c:choose>
		                  <c:when test="${orgId eq 'admin'}">
		                     <li><a href="${hContext}/dash/do_selectone.do">대시보드</a></li>
		                     <li><a href="${hContext}/admin/do_retrieve.do?pageNum=1&pageSize=10&searchDiv=&searchWord=">조직데이터</a></li>
		                  </c:when>
		               </c:choose>
			        <%-- <li><a href="${hContext}/dash/do_selectone.do">대시보드</a></li>
			        <li><a href="${hContext}/admin/do_retrieve.do?pageNum=1&pageSize=10&searchDiv=&searchWord=">조직데이터</a></li> --%>
			    </ul>
			</li>
			<!-- 관리자페이지 네비게이션 끝 -->
			  
			<!-- 전사게시판 네비게이션 시작 --> 
            <li class="mega-menu mega-menu-sm">
                <a class="has-arrow" href="javascript:void()" aria-expanded="false">
                    <i class="icon-screen-tablet menu-icon"></i><span class="nav-text">게시판</span>
                </a>
                <ul aria-expanded="false">
                     <li><a href="${hContext}/nboard/do_retrieve.do?pageNum=1&pageSize=10&searchDiv=&searchWord=">전사게시판</a></li>
                </ul>
            </li>
            <!-- 전사게시판 네비게이션 끝 --> 
			
			<!-- 이메일페이지 네비게이션 시작 -->
			<li class="mega-menu mega-menu-sm">
			    <a class="has-arrow" href="javascript:void()" aria-expanded="false">
			        <i class="icon-envelope menu-icon"></i><span class="nav-text">메일</span>
			    </a>
			    <ul aria-expanded="false">
			        <li><a href="${hContext}/mail/do_retrieve.do?pageNum=1&pageSize=10&searchDiv=&searchWord=${user.id}">받은 메일함</a></li>
			        <li><a href="${hContext}/mail/do_retrieveSent.do?pageNum=1&pageSize=10&searchDiv=&searchWord=${user.id}">보낸 메일함</a></li>
			        <li><a href="${hContext}/mail/do_retrieveTrash.do?pageNum=1&pageSize=10&searchDiv=&searchWord=${user.id}">휴지통 </a></li>
			    </ul>
			</li>
			<!-- 이메일페이지 네비게이션 끝 -->
			
			<!-- Todo페이지 네비게이션 시작 -->
			<li class="mega-menu mega-menu-sm">
			    <a class="has-arrow" href="javascript:void()" aria-expanded="false">
			        <i class="icon-globe-alt menu-icon"></i><span class="nav-text">업무등록</span>
			    </a>
			    <ul aria-expanded="false">
			          <li><a href="${hContext}/todo/do_retrieve.do?pageNum=1&pageSize=10&searchDiv=&searchWord=">Todo</a></li>
			    </ul>
			</li>
			<!-- Todo페이지 네비게이션 끝 -->
           
			<!-- 마이페이지 네비게이션 시작 -->
			<li class="mega-menu mega-menu-sm">
			    <a class="has-arrow" href="javascript:void()" aria-expanded="false">
			        <i class="icon-notebook menu-icon"></i><span class="nav-text">마이페이지</span>
			    </a>
			    <ul aria-expanded="false">
			        <li><a href="${hContext}/org/do_select_one.do">개인 정보 수정</a></li>
			        <li><a href="${hContext}/attend/do_select_one.do">근태 관리</a></li>
			    </ul>
			</li>
			<!-- 마이페이지 네비게이션 끝 -->
           
			<!-- 채팅페이지 네비게이션 시작 -->
			<li class="mega-menu mega-menu-sm">
			    <a class="has-arrow" href="javascript:void()" aria-expanded="false">
			        <i class="icon-globe-alt menu-icon"></i><span class="nav-text">커뮤니티</span>
			    </a>
			    <ul aria-expanded="false">
			        <li><a href="${hContext}/chat/do_retrieve.do?pageNum=1&pageSize=10&searchDiv=&searchWord=${user.id}">채팅</a></li>
			    </ul>
			</li>
			<!-- 채팅페이지 네비게이션 끝 -->
			
       </ul>
   </div>
	<!--/ sidebar end  -->