<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:message code="menu.users"></s:message></title>
<script type="text/javascript">
function changeTrBg(row){
	row.style.backgroundColor = "lightgray"
	
}
function defaultTrBg(row){
	row.style.backgroundColor = "white"
	
}
function searchPerson(){
    var searchWord = document.getElementById('searchPerson').value;

    if(searchWord < 3){ 
        document.getElementById('errorSearch').innerHTML = "<s:message code="error.searchString.toShort" />";
        return false;
    }else{
        document.getElementById('errorSearch').innerHTML ="";
        var searLink = '${pageContext.request.contextPath}/admin/users/search/' + searchWord;
        window.location.href=searLink;
    }  
}
</script>
</head>
<body>
	<%@include file="/WEB-INF/incl/menu.app"%>
	<h1>
		<s:message code="menu.users"></s:message>
	</h1>
	<c:set var="count" value="${recordStartCounter }"/>
	<div align="right" style="width: 1000px; padding: 2px;">
		<input type="text" id="searchPerson"/>&nbsp;&nbsp;<input type="button" value="<s:message code="button.search" />"
				onclick="searchPerson();"/>
		<span id="errorSearch" style="color: red"></span>
	</div>
	<table width="1000" border="0" cellpadding="6" cellspacing="0">
		<tr>
		    <td width="40" align="center"><s:message code="admin.numer"></s:message></td>
			<td width="40" align="center"><s:message code="admin.user.id"></s:message></td>
			<td width="200" align="center"><s:message code="register.name"></s:message></td>
			<td width="200" align="center"><s:message
					code="register.lastName"></s:message></td>
			<td width="220" align="center"><s:message code="register.email"></s:message></td>
			<td width="200" align="center"><s:message code="profil.isActive"></s:message></td>
			<td width="90" align="center"><s:message code="profil.rola"></s:message></td>
		</tr>
		<c:forEach var="u" items="${userList}">
			<c:set var="count" value="${count + 1 }"/>
			<tr onmouseover="changeTrBg(this)" onmouseout="defaultTrBg(this)">
				<td align="center"><c:out value="${count}"></c:out></td>
				<td align="center"><a href="../edit/${u.id }"><c:out value="${u.id}"/></a></td>
				<td align="center"><a href="../edit/${u.id }"><c:out value="${u.name}"/></a></td>
				<td align="center"><a href="../edit/${u.id }"><c:out value="${u.lastName}"/></a></td>
				<td align="center"><a href="../edit/${u.id }"><c:out value="${u.email}"/></a></td>
				<td align="center"><c:choose>
						<c:when test="${u.active == 1 }">
							<font color="green"><s:message code="word.tak"></s:message></font>
						</c:when>
						<c:otherwise>
							<font color="red"><s:message code="word.nie"></s:message></font>
						</c:otherwise>
					</c:choose></td>
				<td align="center"><c:choose>
						<c:when test="${u.nrRoli == 1 }">
							<font color="green"><s:message code="word.admin" /></font>
						</c:when>
						<c:otherwise>
							<s:message code="word.user" />
						</c:otherwise>
					</c:choose></td>
			</tr>

		</c:forEach>
	</table>
	<table width="1000" border="0" cellpadding="6" cellspacing="0">
		<tr>
			<td width="300" align="left"><s:message code="info.page" />
				${currentPage} <s:message code="info.from" /> ${numberOfPages}</td>
			<td align="right"><c:if test="${currentPage > 1 }">
					<input type="button"
						onclick="window.location.href='${pageContext.request.contextPath}/admin/users/${currentPage - 1 }'"
						value='<s:message code="link.poprzedni"/>' />&nbsp;&nbsp;
				</c:if> <c:if test="${currentPage < numberOfPages }">
					<input type="button"
						onclick="window.location.href='${pageContext.request.contextPath}/admin/users/${currentPage + 1 }'"
						value='<s:message code="link.nastepny"/>' />&nbsp;&nbsp; 
				</c:if></td>
		</tr>
	</table>

</body>
</html>