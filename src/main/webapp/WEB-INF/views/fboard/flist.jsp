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
<!-- 11.15  -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
  <!--부트스트랩 추가 12-02  -->
  
<style type="text/css">
table, th, td {
  border-style: outset; /* 보드스타일 */
  board-width: 5px; /* 너비  */
  text-align: center; /* 속성은 텍스트의 정렬 방향을 의미. */
}

ul {
  list-style-type: none;
}

li {
  display: inline-block;
}
</style>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<!-- J쿼리 사용 시 꼭 필요함.11.15 -->


<link rel="stylesheet"
  href="${pageContext.request.contextPath}/resources/css/main.css">


<meta charset="UTF-8">
<title>Call 게시판 자유게시판 list</title>
</head>
<body>
<div class="container-fluid" id="yk1" style="height: 150%;">
  <h2 style="margin: 0px;">
			<div class="container-fluid">
  
  <h1>D: 자유게시판</h1>
</h2>
		<h4>
		
		</h4>
  <!-- jsp 생성 후 컨트롤러 fregister   -->
  <!-- flist는 게시판 메인 글 호출 GET 방식.
  
    form에서 method를 따로 지정하지 않으면 GET방식으로 디폴드 - 11.15
    -->

  <!--**
    11.15 주의 공지사항에서도 문제가 일어났지만.
    JSP단에 들어가는건 VO 변수명과 일치해야 연결된다.
    -->


  <!-- 11-24일 추가.! https://jg-han.tistory.com/38 참고! -->
 <div>
    <form>
      <fieldset>
        <legend>메뉴!</legend>
        <!-- <label>검색 분류</label>  -->
        <label for="test" class="form-label mt-4">검색분류</label>
        <select name="f">
          <option value="title">제목</option>
          <option value="writerId">작성자</option>
        </select> 
       <!--  <label>검색어</label>  -->
        <label for="text" class="form-label mt-4" >검색어</label>
        <input type="text" name="q"  placeholder="검색어 입력" value="" /> 
        <input type="submit"   class="btn btn-secondary" value="검색" > 
        <a href="fregister">
        
        
        <c:if test="${not empty sessionScope.userid}"> <!-- 로그인을해야 글작성이 가능하다.! 12월 4일.  -->
    		<input type="button"  class="btn btn-secondary" value="글작성"></c:if></a>
    		 
       	<a href="/ex08"> <input type="button"class="btn btn-secondary"  value="메인화면">
        </a>
       	<!-- 뒤로가기 버튼 밑  -->
        <input type="button" value="뒤로가기" class="btn btn-secondary"  onclick="history.back(-1)">
        <a href="javascript:history.back(-1)"></a>
      </fieldset>
    </form>
  </div>

  <!--   <input class = 'keyword' type = 'text' name = 'search' maxlength = 355 value = "" 
  autocomplete = "off"> 검색바 구현. -->

  <!-- 게시판 부분 -->

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
      <c:forEach var="vo" items="${flist }">

        <tr>
          <td>${vo.bno }</td>
          <td><a
            href="fdetail?bno=${vo.bno }&page=${pageMaker.criteria.page}">${vo.ftitle }</a></td>
          <td>${vo.fuserid }</td>
          <fmt:formatDate value="${vo.fcdate }"
            pattern="yyyy-MM-dd HH:mm:ss" var="fcdate" />
          <td>${fcdate }</td>


        </tr>
      </c:forEach>
    </tbody>
  </table>

  <hr>
  <ul>

    <c:if test="${pageMaker.hasPrev }">
      <li><a href="flist?page=${pageMaker.startPageNo -1 }">이전</a></li>
      <!-- startPageNo 4 5 6일 경우 이전을 누르면  startPage 4번 -1  -->
    </c:if>


    <c:forEach begin="${pageMaker.startPageNo }"
      end="${pageMaker.endPageNo }" var="num">
      <!-- begin : 시작  end : 끝 -->
      <li><a href="flist?page=${num }">${num }</a></li>
    </c:forEach>
    <!-- 페이지 번호가 늘어나면 var = num 설정으로 자동으로 번호 늘어남 11.15  -->

    <c:if test="${pageMaker.hasNext }">
      <li><a href="nlist?page=${pageMaker.endPageNo + 1 }">다음</a></li>
      <!-- endPage 1 2 3 < 일 경우 다음을 누를 시, 4부터 구현되게. 11-15 -->
    </c:if>
    <!-- 페이지 버튼은 구현되었지만 게시글이 부족하면 구현되지 않는 기능.  -->
    <!-- 날짜검색, 페이지 게시글 숫자 늘리기 (버튼으로)ㅇㅇ -->
  </ul>
</div>

  <!-- FBoardController -> registerPOST()에서 보낸 데이터 저장.11-15 J쿼리 부분! 위에 추가.  -->

  <input type="hidden" id="insertAlert" value="${insert_result }">

  <script type="text/javascript">
            $(document).ready(function() {
                confirmInsertResult(); // 함수 호출
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
