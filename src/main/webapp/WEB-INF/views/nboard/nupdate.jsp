<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${vo.ntitle }</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">

</head>
<body>
	<div class="container-fluid" id="yk1" style="height: 150%;">
		<h2 style="margin: 0px;">
			<div class="container-fluid">
				<h2>글 수정하기 :D</h2>
		</h2>
		<h4></h4>
		<form action="nupdate" method="POST">
			<!--  <input type="hidden" name="_method" value="PUT"> -->
			<input type="hidden" name="page" value="${page }">

			<div>
				<p>글 번호 : ${vo.bno }</p>
				<input type="hidden" name="bno" value="${vo.bno }">
				<!-- hidden 제목 숨기기 -->
			</div>

			<div>
				<p>
					제목 <input type="text" name="ntitle" value="${vo.ntitle  }">
			</div>

			<div>
				<p>작성자 : ${vo.nuserid }</p>
				<%-- <fmt:formatDate value="${vo.cdate }" pattern="yyyy-MM-dd HH:mm:ss" var="cdate"/> --%>
				<p>작성일 : ${vo.ncdate }</p>
			</div>

			<div>
				<textarea rows="20" cols="120" name="ncontent">${vo.ncontent }</textarea>
			</div>

			<!-- 작성자는 기록 그대로 남아있음. -->

			<div>
				<input type="submit" class="btn btn-secondary" value="제출">

				<!-- 뒤로가기 버튼 밑  -->
				<input type="button" value="뒤로가기" onclick="history.back(-1)"
					class="btn btn-secondary"> <a
					href="javascript:history.back(-1)"></a>
			</div>



		</form>
	</div>

	</div>
</body>
</html>