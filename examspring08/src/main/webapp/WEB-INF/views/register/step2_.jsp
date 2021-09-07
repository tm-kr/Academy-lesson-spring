<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
</head>
<body>
<h2>회원 정보 입력</h2>
<form action="step3" method="post">
	<p>이메일:<input type="text" name="email" value="${formData.email}"></p>
	<p>이름:<input type="text" name="name" value="${formData.name}"></p>
	<p>비밀번호:<input type="password" name="password"></p>
	<p>비밀번호 확인:<input type="password" name="confirmPassword"></p>
	<p><input type="submit" value="가입완료"></p>
</form>
</body>
</html>