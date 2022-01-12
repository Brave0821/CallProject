<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!-- JSTL 라이브러리 호출 
현재 화면에서는 c:forEach 와 fmt:formatDate를 사용중-->
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<!-- main에서 css가져오기. -->

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

<style type="text/css">
table, th, td {
	border-style: outset; /* solid; 보드 스타일 */
	border-width: 5px; /* 너비  */
	text-align: center; /* 속성은 텍스트의 정렬 방향을 의미합니다. */
}

ul {
	list-style-type: none;
}

li {
	display: inline-block; /* Moccasin; */ /* inline-block; */
}

.searchForm a button {
	color: black !important;
}
/* http://ielselog.blogspot.com/2013/10/css-color-keywords.html
css display 색 모음.
 */
</style>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<!-- J쿼리 사용 시 꼭 필요하다. 11-12  -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>


<meta charset="UTF-8">

<title>Call 게시판 공지사항 list</title>
</head>
<body>
<body>
	<div class="container-fluid" id="yk1" style="height: 150%;">
		<!-- 전체 초록색-->

		<!-- <div class="container" style= "background : White; padding: 0px; height:100%; "> -->
		<!-- 가운데 -->
		<h2 style="margin: 0px;">
			<div class="container-fluid">
				<h1>:D 공지사항</h1>
		</h2>
		<h4></h4>
		<!-- 글작성 버튼을 누르면 nregister 페이지로 이동 -->

		<!--  noticelist는 게시판 메인 글 호출, GET 방식이다.
   form에서 method를 따로 지정하지 않으면, GET방식으로 디폴트.
   -->
		<!-- 
   **
   JSP단에 들어가는 건 vo변수명과 일치해야 연결된다.  -->

		<!-- 11-24일 추가.  https://jg-han.tistory.com/38 참고 -->
		<div>
			<br>
			<fieldset>
				<legend>관리자만 글작성이 가능합니다.</legend>
				<hr class="my-15">
				<label for="search" class="form-label mt-4">검색 분류</label>
				<form name="nlist" method="get" action="searchNList"
					class="searchForm">
					<select name="searchOption">



						<option value="all"
							<c:out value="${map.searchOption == 'all'?'selected':''}"/>>모든검색</option>
						<option value="ntitle"
							<c:out value="${map.searchOption == '${ntitle}'?'selected':''}"/>>제목</option>
						<option value="ncontent"
							<c:out value="${map.searchOption == '${ncontent}'?'selected':''}"/>>내용</option>
					</select> <input name="keyword"  placeholder="검색어 입력" value="${map.keyword }"/ >
					<input id="search-btn" type="submit"  class="btn btn-secondary"
						value="검색" />



					<!--  <option value = "ntitle">제목</option>
              <option value = "ncontent">내용</option> -->
					<!-- <option value = "nwriter">작성자</option> -->
					<!-- <label>검색어</label>
              <input type = "text" name = "keyword" value = ""/>
              버튼을 누르면 getsearchlist 함수 실행! 
              <input type = "button" onclick="getSeartList()" class="btn-outline-primary mr-2" value = "검색"> -->

					<!-- <c:if test="${not empty sessionScope.userId}"></c:if> 로그인하면 글작성가능. 일반 회원들은 로그인 후 자유게시판 사용가능. 
					https://jjinbbangworld.tistory.com/4
					 -->



					<c:if
						test="${sessionScope.userid == 'Manager123' || sessionScope.userid == 'TEST' }">
						<!-- 관리자 지정 아이디 공지사항이기에 아이디를 지정해서 일반회원은 공지사항 글 작성 못 한다. -->
						<!--https://kmhan.tistory.com/m/390 위에 지정한 아이디 복수로 보이게. 관리자 지정 2명  Manager123 or TEST
						즉 2명은 공지사항에 글을 쓸 수 있다.
						 -->

						<!-- 로그인시 글작성 버튼 보이게 구현 11-29 -->
						<a href="nregister"> <input type="button"
							class="btn btn-secondary" value="글작성"> <!-- 글작성</button> -->
						</a>
					</c:if>



					<!-- 실험  style="background-color:lavender;" 부트스트랩 적용해봄.11-26 -->

					<a href="/ex08"><input type="button" onclick="alert('이동합니다.')"
						class="btn btn-secondary" value="메인화면"></input></a>

					<!-- <a href="/ex08/nboard/nlist"><button type="button">돌아가기</button></a> -->

					<!-- 뒤로가기 버튼 밑  -->
					<input type="button" value="뒤로가기" onclick="history.back(-1)"
						class="btn btn-secondary"> <a
						href="javascript:history.back(-1)"></a>

					<!-- <a href="/ex08/nboard/login"><button type="button">로그인</button> -->

					<!-- <button type="button" class="btn btn-primary"
						onclick="location.href='/ex08/member/login'">로그인</button> -->
				</form>

				<!--  style="background-color:lavender;" -->
			</fieldset>
		</div>

		<!-- 게시판 부분  -->
		<hr>
		<table class="table table-hover">
			<thead>
				<tr style="background: LightGrey;">
					<!-- 게시판 머리 색   -->
					<th style="width: 60px">번호</th>
					<th style="width: 700px">제목</th>
					<th style="width: 80px">작성자</th>
					<th style="width: 130px">작성일</th>
				</tr>
			</thead>

			<tbody id="noticeList">
				<c:forEach var="vo" items="${nlist}">
					<tr>
						<td>${vo.bno }</td>
						<td><a
							href="ndetail?bno=${vo.bno }&page=${pageMaker.criteria.page}">${vo.ntitle }</a></td>
						<!--  <a href="detail.do">로 제목 클릭시 넘어가기. -->
						<td>${vo.nuserid }</td>
						<fmt:formatDate value="${vo.ncdate }"
							pattern="yyyy-MM-dd HH:mm:ss" var="ncdate" />
						<td>${ncdate }</td>

					</tr>
				</c:forEach>
			</tbody>
		</table>

		<hr>

		<!-- 페이지네이션 -->
		<ul>
			<c:if test="${pageMaker.hasPrev }">
				<li><a href="nlist?page=${pageMaker.startPageNo -1 }">이전</a></li>
				<!-- startPageNo 4,5,6일 경우 이전을 누를시 , startpage 4번 -1 -> 3번으로 넘어감!(1,2,3) -->
			</c:if>
			<c:forEach begin="${pageMaker.startPageNo }"
				end="${pageMaker.endPageNo }" var="num">
				<!-- begin : 시작  end : 끝 -->
				<li><a href="nlist?page=${num }">${num }</a></li>
				<!--  페이지 번호가 늘어나면, var=num 설정으로 자동으로 번호가 늘어난다. -->
			</c:forEach>
			<c:if test="${pageMaker.hasNext }">
				<li><a href="nlist?page=${pageMaker.endPageNo + 1 }">다음</a></li>
				<!-- endpage 1,2,3 < 일 경우 다음을 누를 시, 4부터 구현되게 -->
			</c:if>
			<!-- 페이지 버튼은 구현이 되었지만, 게시글이 부족하면 구현되지 않는 기능..  -->
			<!--  날짜검색, 페이지 게시글 숫자 늘리기 (버튼으로) -->

		</ul>

	</div>
	<%--  <h1>게시판 메인</h1>
    <c:if test="${empty userid }">
      <button type="button" id="btn_login">로그인</button>
    </c:if>
    <c:if test="${not empty userid }">
      <button type="button" id="btn_logout">로그아웃</button>
    </c:if>


 --%>


	<!-- NBoardController - > registerPOST()에서 보낸 데이터 저장.11-12 J쿼리부분! 위에 추가하기.
  
   -->

	<input type="hidden" id="insertAlert" value="${insert_result }">
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			/* 리스트 조회 성공시 메시지 호출 */
			confirmInsertResult();// 함수호출
			/* search-btn 클릭 시에, 함수 호출 */
			/* $('#search-btn').click(function(){
				setSearchList();
			}); */
		});

		function confirmInsertResult() {
			var result = $('#insertAlert').val();
			if (result == 'success') {
				alert('새 글 작성 성공!')
			}
		}
	</script>

</body>
</html>