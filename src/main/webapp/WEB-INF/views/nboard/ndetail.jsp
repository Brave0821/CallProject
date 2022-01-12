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

<title>${vo.ntitle }</title>
</head>
<body>
<div class="container-fluid" id="yk1" style="height: 150%;">
	<h2 style="margin: 0px;">
			<div class="container-fluid">
	
	<h3>글 보기</h3>
	</h2>
	<h4></h4>
	
	<!--  선  -->
	<hr class="my-15">
	<div>

		<p>글 번호 : ${vo.bno }</p>
	</div>

	<div>

		<p>
			제목 : <input type="text" value="${vo.ntitle }"  readonly="readonly">
		</p>

	</div>

	<div>
		<p>작성자 : ${vo.nuserid }</p>
		<fmt:formatDate value="${vo.ncdate }" pattern="yyyy-MM-dd HH:mm:ss"
			var="ncdate" />
		<p>작성일 : ${ncdate }</p>
	</div>


	<div>
		<textarea rows="20" cols="120" readonly="readonly">${vo.ncontent }</textarea>
	</div>



	<div>
		<a href="nlist?page=${page }"><input type="button" class="btn btn-secondary" value="글 목록"></a> 
			
			<c:if test="${sessionScope.userid == 'Manager123' || sessionScope.userid == 'TEST' }">
			<a href="nupdate?bno=${vo.bno }&page=${page}"> <input type="button" class="btn btn-secondary" value="글 수정"></a>  
			<a href="ndelete?bno=${vo.bno }"><input type="button" class="btn btn-secondary" value="글 삭제" onclick="alert('삭제되었습니다.')"></a>
			</c:if>
	</div>
</div>
</body>
</html>