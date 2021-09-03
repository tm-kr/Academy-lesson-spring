<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
<h2>회원 정보 입력</h2>
<form:form action="step3" commandName="formData">
	<p>
		이메일:<form:input path="email"/>
	</p>
	<p>
		이름:<form:input path="name"/>
	</p>
	<p>
		비밀번호:<form:password path="password"/>
	</p>
	<p>
		비밀번호 확인:<form:password path="confirmPassword"/>
	</p>
	<p><input type="submit" value="가입완료"></p>
</form:form>
</body>
</html>