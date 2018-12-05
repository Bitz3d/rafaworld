 <%@page import="com.fasterxml.jackson.annotation.JsonInclude.Include"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><s:message code="menu.admin" /></title>
</head>
<body>
<%@include file="/WEB-INF/incl/menu.app" %>
<h1><s:message code="menu.adminPage"/></h1>
<%@include file="/WEB-INF/incl/adminmenu.app" %>
</body>
</html>