<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><s:message code="profil.userDane"/> </title>
</head>
<body>
<%@include file="/WEB-INF/incl/menu.app"%>
<div align="center">
    <h2><s:message code="profil.userDane"/> </h2>
</div>

<table width="500" border="0" cellpadding="4" cellspacing="1" align="center">

    <tr>
        <td width="130" align="right" >
            <s:message code="register.email"/>
        </td>
        <td width="270" align="left">
            <c:out value="${user.email}"/>
        </td>
    </tr>
    <tr>
        <td width="130" align="right" >
            <s:message code="register.name"/>
        </td>
        <td width="270" align="left">
            <c:out value="${user.name}"/>
        </td>
    </tr>
    <tr>
        <td width="130" align="right" >
            <s:message code="register.lastName"/>
        </td>
        <td width="270" align="left">
            <c:out value="${user.lastName}"/>
        </td>
    </tr>
    <tr>
        <td width="130" align="right" >
            <s:message code="profil.isActive"/>
        </td>
        <td width="270" align="left">
            <c:choose>
                <c:when test="${user.active == 1}">
                    <s:message code="word.tak"/>
                </c:when>
                <c:otherwise>
                    <s:message code="word.nie"/>
                </c:otherwise>
            </c:choose>
        </td>
    </tr>
    <tr>
        <td width="130" align="right" >
            <s:message code="profil.isActive"/>
        </td>
        <td width="270" align="left">
            <c:choose>
                <c:when test="${user.nrRoli == 1}">
                    <s:message code="word.admin"/>
                </c:when>
                <c:otherwise>
                    <s:message code="word.user"/>
                </c:otherwise>
            </c:choose>
        </td>
    </tr>
		<table width="500" border="0" cellpadding="4" cellspacing="1"
			align="center">
			<td align="center"><input type="button"
				value="<s:message code="button.edycjaProfilu"/>"
				onclick="window.location.href='${pageContext.request.contextPath}/editprofile'"/>
			</td>
			<td colspan="2" align="center" bgcolor="#fff"><input
				type="button" value="<s:message code="button.zmianaHasla"/>"
				onclick="javascript:window.location.href='${pageContext.request.contextPath}/editPassword'" />
			</td>
		</table>


	</table>


</body>
</html>
