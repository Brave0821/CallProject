<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<!-- main에서 css가져오기. -->

<title>${vo.ctitle }</title>
</head>
<body>
	<div class="container-fluid" id="yk1" style="height: 150%;">
		<h2 style="margin: 0px;">
			<div class="container-fluid">


				<h2>글 보기</h2>
		</h2>
		<h4></h4>

		<!--  선  -->
		<hr class="my-15">
		<div>
			<p>글 번호 : ${vo.bno }</p>
		</div>
		<div>


			<p>
				제목 : <input type="text" value="${vo.ctitle }"  readonly="readonly">
			</p>
		</div>


		<div>
			<p>작성자 : ${vo.cuserid }</p>
			<fmt:formatDate value="${vo.ccdate }" pattern="yyyy-MM-dd" />
			<p>작성일 : ${ccdate }</p>
		</div>


		<div>
			<textarea rows="20" cols="120" readonly="readonly">${vo.ccontent }</textarea>
		</div>


		<div>
			<a href="clist?page=${page }"><input type="button" class="btn btn-secondary"  value="글 목록"></a>
			<a href="cupdate?bno=${vo.bno }&page=${page }"><input
				type="button" class="btn btn-secondary" value="글 수정" ></a> <a href="cdelete?bno=${vo.bno }"><input
				type="button" class="btn btn-secondary" value="글 삭제" onclick="alert( '삭제되었습니다.')"></a>
		</div>
		</div>
</body>
</html>