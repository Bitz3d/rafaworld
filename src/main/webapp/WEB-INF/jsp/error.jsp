<%--
  Created by IntelliJ IDEA.
  User: rafau
  Date: 17.11.18
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s"  uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<%@include file="/WEB-INF/incl/menu.app"%>

<img src="/resources/errorpage.jpg">
<h2>
    <s:message code="error.defaultErrorMessage"/>

</h2>

</body>
</html>
