<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="style.css" />
<title>Insert title here</title>
</head>
<body>
	<div class="header shadow">
		<div class="header2 ">
			<h3 style="float: left"><a href="#" style="color: white">Simple board</a></h3>
			<button style="float: right" type="button" class="btn btn-outline-light">로그인</button>
		</div>
		
	</div>
	
	<div class="container">
		<div class="content2">
		
			<div class="contentL shadow-sm">
				<div>
					<form method="post" action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data">
						<div class="write">
							<h3>글쓰기</h3><br>
							<input type="text" class="form-control" placeholder="제목" name="title" ><br>
							<input class="form-control" type="file" id="formFile" name="uploadFile"><br>
							<textarea class="form-control" placeholder="파일 설명  (1000자 이내)" name="content"></textarea>
							<div class="btn1 mt-5">
								<button type="submit" class="btn btn-outline-secondary" >작성하기</button>	
								<button type="button" class="btn btn-outline-secondary" onclick="location.href='${pageContext.request.contextPath}/list'" >취소</button>	
							</div>
						</div>
					</form>
				</div>
					  
					
			</div>
				
			
		
			<div class="profile shadow-sm">
				 <div class="d-grid gap-2 profile-top">
				   <button class="btn btn-info" type="button">로그인</button>
				   <button class="btn btn-info" type="button">회원가입</button>
				 </div>
				 <div class="profile-mid">
				 	<h6 class="ul-title">홈</h6>
				 	<h5>전체</h5>
				 </div>
				 <div class="profile-mid">
				 	<h6 class="ul-title">정보</h6>
				 	<h5>공지사항</h5>
				 	<h5>긴급 뉴스</h5>
				 </div>
				 <div class="profile-bottom">
				 	<h6 class="ul-title">커뮤니티</h6>
				 	<h5>자유</h5>
				 	<h5>유머</h5>
				 	<h5>팬아트</h5>
				 </div>
			</div>
			
		</div>
		
		<footer class="mt-3 mb-5">
			<br>Copyright &copy; 2021 김태민 All Rights Reserved.<br>
			이 사이트는 그 어떠한 상업적 목적도 없습니다.
		</footer>
	</div>
	
	
</body>
</html>