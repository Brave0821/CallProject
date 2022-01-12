<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">

</head>
<body>
	<div class="container-fluid" id="yk1" style="height: 150%;">
		<h2 style="margin: 0px;">
			<div class="container-fluid">
				<h2>자유게시판 작성 페이지</h2>
		</h2>
		<h4>
			<!-- 색분활 -->
		</h4>
		<hr class="my-10">

		<form action="fregister" method="post">
			<div>
				<p>
					제목 : <input type="text" name="ftitle"  style="width: 600px" class="form-control" placeholder="제목 입력 " required>
			</div>

			
			<div>
				<p>
					작성자 : <input type="text" name="fuserid" style="width: 150px" class="form-control"
						value="${sessionScope.userid }" placeholder="작성자 입력" required>
			</div>
		


			<div>
				<textarea rows="20" cols="120" name="fcontent" class="form-control"  style="width: 800px" placeholder="내용입력"
					required></textarea>
			</div>


			<div>
				<input type="submit" class="btn btn-secondary" value="등록">
			
			<!-- 뒤로가기 버튼 밑  -->
		<input type="button" value="뒤로가기" onclick="history.back(-1)"
			class="btn btn-secondary"><a
			href="javascript:history.back(-1)"></a>
			
			
			</div>

		</form>
	</div>
</body>
</html>