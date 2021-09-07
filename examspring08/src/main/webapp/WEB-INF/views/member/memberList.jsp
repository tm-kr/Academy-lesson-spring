<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 조회</title>
</head>
<body>
<form:form commandName="cmd">
	<p>
		from:
			<form:input path="from"/>
			<form:errors path="from"/> ~ 
		to:
			<form:input path="to"/>
			<form:errors path="to"/>
		<input type="submit" value="조회">
	</p>
</form:form>
<hr>
<c:if test="${!empty members}">
	<table>
		<tr>
			<th>아이디</th>
			<th>이메일</th>
			<th>이름</th>
			<th>등록일</th>
		</tr>
		<c:forEach var="member" items="${members}">
			<tr>
				<td>${ member.id }</td>
				<td><a href="<c:url value="/member/detail"/>?id=${member.id}">${ member.email }</a></td>
				<td><a href="<c:url value="/member/detail/${member.id}"/>">${ member.email }</a></td>
				<td>${ member.name }</td>
				<td><fmt:formatDate value="${ member.registerDate }" pattern="yyyy-MM-dd:HH"/></td>
			</tr>
		</c:forEach>
	</table>
</c:if>
</body>
</html>

















