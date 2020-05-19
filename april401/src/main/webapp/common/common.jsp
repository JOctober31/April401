<%--
  /**
  * Class Name : common.jsp
  * Description : 뷰에 공통 변수,cache control
  * Modification Information
  *
  *   수정일                   수정자                      수정내용
  *  -------    --------    ---------------------------
  *  2020. 5. 12.            최초 생성
  *
  * author 실행환경 개발팀
  * since 2009.01.06
  *
  * Copyright (C) 2009 by KandJang  All right reserved.
  */
--%>
<%@page import="org.slf4j.LoggerFactory"%>
<%@page import="org.slf4j.Logger"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:set  var="hContext" value="${pageContext.request.contextPath }"></c:set>    
<%
    final String H_PATH = request.getContextPath();
    Logger  LOG = LoggerFactory.getLogger(this.getClass());
	//HTTP1.1에서 지원하는 헤더로 : 웹브라우저가 응답결과를 캐시하지 않음
	response.setHeader("Cashe-Control", "no-cache");
	
	//웹브라우저가 응답결과를 캐시하지 않음(앞/뒤로가기 캐시하지 않음)
	response.addHeader("Cashe-Control","no-store");
	
	//HTTP1.0에서 지원하는 헤더로 : 웹브라우저가 응답결과를 캐시하지 않음
	response.setHeader("Pragma", "No-cache");
	
	//HTTP1.0에서 응답결과 만료일: 현재시간 이전으로 설정 캐지하지 않음( 기준시간 1970.1.1,)
	response.setDateHeader("Expires", 1L);
%>    