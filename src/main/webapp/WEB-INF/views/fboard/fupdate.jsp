<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${vo.ftitle }</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">
</head>
<body>
	<div class="container-fluid" id="yk1" style="height: 150%;">
		<h2 style="margin: 0px;">
			<div class="container-fluid">
				<h2>글 수정 :D</h2>
		</h2>
		<h4></h4>

		<form action="fupdate" method="POST">

			<input type="hidden" name="page" value="${page }">
			<!-- 수정부분이니까 hidden -->
			<div>
				<p>글 번호 : ${vo.bno }</p>
				<input type="hidden" name="bno" value="${vo.bno }">
			</div>
			<!--hidden 제목 숨기기.  -->


			<div>
				<p>
					제목 <input type="text" name="ftitle" value="${vo.ftitle }">
			</div>

			<div>
				<p>작성자 : ${vo.fuserid }</p>
				<p>작성일 : ${vo.fcdate }</p>
			</div>

			<div>
				<textarea rows="20" cols="120" name="fcontent">${vo.fcontent }</textarea>
			</div>


			<div>
				<input type="submit" class="btn btn-secondary"  value="제출">

				<!-- 뒤로가기 버튼 밑  -->
				<input type="button" value="뒤로가기" onclick="history.back(-1)"
					class="btn btn-secondary"> <a
					href="javascript:history.back(-1)"></a>

			</div>
		</form>
	</div>


</body>
</html>