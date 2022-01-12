<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<!-- main에서 css가져오기. -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<!-- 부트스트랩 추가. 12-02  -->
<style type="text/css">
table, th, td {
	border-style: outset; /* board 스타일   */
	board-width: 5px; /* 너비 */
	text-align: center; /* 속성은 텍스트 정렬 방향 지금은 가운데!  */
}

ul {
	list-style-type: none;
}

li {
	display: inline-block;
	/*http://ielselog.blogspot.com/2013/10/css-color-keywords.html
  css display 색 모음.  */
}
</style>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<!-- J쿼리 사용 시 꼭 필요하다.11-22 -->

<meta charset="UTF-8">
<title>Call 스팸번호 게시판 list</title>
</head>
<body>

	<div class="container-fluid" id="yk1" style="height: 150%;">
		<h2 style="margin: 0px;">
			<div class="container-fluid">
				<h1>:D 스팸번호 게시판</h1>
		</h2>
		<h4></h4>

		<!--   <a href="cregister"><input type="button" value="글작성"></a> -->
		<!-- 글작성 button 누르면 cregister 페이지로 이동한다. 11-22 -->
		<!-- <a href="/ex08"><input type="button" value="메인화면"></a> -->
		<!-- jsp단에 들어가는 건 vo 변수명과 일치해야한다. 11-22 -->

		<!-- 11-24일  https://jg-han.tistory.com/38 참고! -->

		<div>
				<fieldset>
					<legend>메뉴</legend>
					<hr class="my-15">
					<!-- <label>검색 분류</label> -->
					<label for="csearch" class="form-label mt-4">검색 분류</label>
					<form name="clist" method="get" action="searchCList"
						class="searchForm">
						<select name="searchOption">

							<option value="all"
								<c:out value="${map.searchOption == 'all'?'selected':''}"/>>모든검색</option>
							<option value="ctitle"
								<c:out value="${map.searchOption == '${ctitle}'?'selected':''}"/>>제목</option>
							<option value="ccontent"
								<c:out value="${map.searchOption == '${ccontent}'?'selected':''}"/>>내용</option>
						</select> <input name="keyword" placeholder="검색어 입력"
							value="${map.keyword }"/ > 
							<input id="search-btn" type="submit" class="btn btn-secondary" value="검색" />

						<!-- <label>검색어</label> -->






						<a href="cregister"> <input type="button" class="btn btn-secondary" value="글작성"></a> 
						<a href="/ex08"><input type="button" class="btn btn-secondary" value="메인화면"></a>
						<!-- 뒤로가기 버튼 밑 뒤로가기 버튼임   -->
						
						<input type="button" value="뒤로가기" onclick="alert('이동합니다.')"
							class="btn btn-secondary" onclick="history.back(-1)"> <a
							href="javascript:history.back(-1)"></a>
			</form>
				</fieldset>
		</div>


		<!-- 게시판 부분. -->

		<hr>
		<table>
			<thead>
				<tr style="background: LightGrey;">
					<th style="width: 60px">번호</th>
					<th style="width: 700px">제목</th>
					<th style="width: 80px">작성자</th>
					<th style="width: 130px">작성일</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="vo" items="${clist }">

					<tr>
						<td>${vo.bno }</td>
						<td><a
							href="cdetail?bno=${vo.bno }&page=${pageMaker.criteria.page }">${vo.ctitle }</a></td>
						<td>${vo.cuserid }</td>
						<fmt:formatDate value="${vo.ccdate }"
							pattern="yyyy-MM-dd HH:mm:ss" var="ccdate" />
						<td>${ccdate }</td>
					</tr>

				</c:forEach>
			</tbody>
		</table>

		<hr>
		<ul>
			<c:if test="${pageMaker.hasPrev }">
				<li><a href="clist?page=${pageMaker.startPageNo -1 }">이전</a>
				<li>
					<!-- 11-22 페이지 번호가 늘어나면, var=num 설정으로 자동으로 번호가 늘어남. -->
			</c:if>


			<c:forEach begin="${pageMaker.startPageNo }"
				end="${pageMaker.endPageNo }" var="num">
				<!-- begin : 시작  end : 끝 -->
				<li><a href="clist?page=${num }">${num }</a></li>
				<!--  페이지 번호가 늘어나면, var=num 설정으로 자동으로 번호가 늘어난다.! -->
			</c:forEach>


			<c:if test="${pageMaker.hasNext }">
				<li><a href="clist?page=${pageMaker.endPageNo + 1}">다음</a></li>
				<!-- endpage 1,2,3 < 일 경우 다음을 누를 시, 4부터 구현되게 -->
			</c:if>
			<!-- 페이지 버튼은 구현! 게시글이 부족하면 구현되지 않는 기능. -->
			<!-- 날짜검색, 페이지 게시글 숫자 늘리기. -->
		</ul>
	</div>

	<!-- CBoardController - > registerPOST()에서 보낸 데이터 저장. 11-22 -->

	<input type="hidden" id="insertAlert" value="${insert_result }">


	<script type="text/javascript">
		$(document).ready(function() {
			confirmInsertResult(); // 함수 호출!
			function confirmInsertResult() {

				var result = $('#insertAlert').val();
				if (result == 'success') {
					alert('새 글 작성 성공!')
				}

			}

		});
	</script>
</body>
</html>