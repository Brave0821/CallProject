<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<!-- 인터넷 강의 참고   아이콘 활용가능 이제.-->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/login.css">
<script>
	/*   로그인 -> 로그인ok(로그인이 성공했는지 확인 page) -> 성공시 main
	 중간에 jsp 페이지를 하나 더 거처야한다. 그러나 ajax로 구현하면 동적으로 할 수있다.

	 그리고 페이지또한
	 로그인->성공시 main 실패시 그냥 alert 창 하나만 띄워주면 됐다. 아주 간편해짐
	 https://unordinarydays.tistory.com/98
	 */

	function enterkey() {
		if (window.event.keyCode == 13) { //로그인 버튼 말고 엔터키로 로그인 하는 경우
			document.getElementById("loginbtn").click();
		}
	}
	$(document).ready(
			function() { // 댓글 ajax부분 참고! 11-30 ~ 12-02
				$('#loginbtn').click(
						function() {
							$.ajax({
								type : 'post',
								url : '/ex08/member/login',
								data : "userid=" + $("#userid").val()
										+ "&password=" + $("#password").val(),

								success : function(result) {
									if (result == "1") {
										alert("로그인 성공");
										location.reload();
									} else {
										alert("아이디 또는 비밀번호가 다릅니다.");
									}
								}
							});
						});
			});

	function add() {
		location.href = "/ex08/member/register"; // 회원가입하기!!!!
	}

	function logout() {
		alert("로그아웃 되었습니다.");
		location.href = "/ex08/member/logout"; /// 로그아웃!
	}
</script>
</head>
<body>

	<!-- https://web-obj.tistory.com/77 
EL은 Expression language 

EL에서  eq, ne, lt, gt, le, ge 정리   
== 또는 eq, != 또는 ne, < 또는 lt
> 또는 gt, <= 또는 le , >= 또는 ge
-->

	<!-- <div class="container row" style="float: none; margin: 100 auto;">  중앙으로 이동 -->
	<!-- <div class="col-md-3" style="float: none; margin: 0 auto;"> -->
	<!--  </div> -->
	<!--   </div> -->

	
	<div class="page-header"> 	
	<!-- <span class="material-icons" >login </span> -->
	<h1>Login</h1> 
		<hr class="my-10">

		<!--  선  -->
	</div>

<!-- 	<span class="material-icons"> login </span> -->
	
	<span class="border"> <c:if
			test="${sessionScope.userid eq NULL}">
			<div style="margin: 10px;">

				<!-- 중앙으로 이동하기.12-02  -->
				<div class="container" margin: 100 auto;">
					<div class="col-md-3" style="float: none; margin: 0 auto;">

						<!-- 출처: https://cokes.tistory.com/49 [Cokes Blog] -->
						<!-- <p>아이디 :</p> -->
						<label for="email" class="form-label mt-4">아이디 :</label> <input
							type="text" style="width: 150px;" class="form-control"
							id="userid"> <br>
						<!-- <p>비밀번호 :</p> -->
						<label for="email" class="form-label mt-4">비밀번호 :</label> <input
							type="password" onkeyup="enterkey()" class="form-control"
							style="width: 150px;" id="password">
						<!-- </div> -->
						<br> <br>
						<!--  class="form-label mt-4" 글자 변경
      class="form-control" 검색창 변경  -->

						<!-- <button type="button" class="btn btn-sm btn-primary">공지사항</button> -->
						<button style="margin: 10px;" id="loginbtn"
							class="btn btn-secondary">로그인</button>
						<p style="margin: 10px;">
							<a href="#" onclick="add()" class="btn btn-secondary">회원가입</a>
						</p>

					</div>
				</div>
			</div>

<br>
<br>
<br>
			<section class="about" font-size= "70px"; >
				<p class="title">
				
					<u>게시판 이용사항</u>
				</p>
				<p>공지사항은 등록된 관리자들만 글 작성이 가능합니다.</p>
				<p>자유게시판은 로그인 후 글 작성이 가능합니다.</p>

			</section>
		</c:if>
	</span>

	<br>

	<c:if test="${sessionScope.userid ne NULL}">
		<label for="email" class="form-label mt-4">${sessionScope.userid}
			님 환영합니다.</label>

		<button style="margin: 20px;" class="btn btn-secondary"
			onclick="logout()">로그아웃</button>
	</c:if>

</body>
</html>