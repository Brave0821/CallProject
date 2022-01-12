<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">

<!-- 부트스트랩 추가. 12-02  -->
<script>
	function add() {
		var form = $("#form");
		form.submit();
	}
</script>
</head>



<body>
<div class="container-fluid" id="yk1" style= "height:150%;"> <!-- 전체 초록색-->
<div class="container" style= "background : White; padding: 0px; height:100%; ">  <!-- 가운데 -->
			<h2 style="margin : 0px;">

	<fieldset>
		<!-- <legend>
			<label for="email" class="form-label mt-4">회원가입 등록페이지</label> 
		</legend> -->
		<h1>회원가입 등록페이지</h1>
		</h2>
		<h4></h4>
			<hr class="my-10">
	<!--  선  -->

		<!-- 부트스트랩 예제1. 12-02 
<input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email"> -->


		<!-- 출처: https://minaminaworld.tistory.com/140 [미나미 블로그] 왼쪽 정렬 -->

		<!--  <p>아이디 :</p> -->
		<!-- "container", "col-lg-4" id, pw는 나눠서 적용  -->
		<!-- 이상하네. row, left 둘 다 정렬 안된다.  -->


		<form action="register" method="post" id="form">

			<div class="container">
				<div class=" col-lg-4">
					<label for="userid" class="form-label mt-4">아이디 :</label>
					<!--  글자 반영  -->
					<input type="text" style="width: 150px" class="form-control"
						name="userid" placeholder="아이디 입력">
					<!-- 검색바 반영  -->
				</div>
			</div>
			
			<!-- <p>비밀번호 :</p> -->
			<div class="container">
				<div class=" col-lg-4">
					<label for="password" class="form-label mt-4">비밀번호 :</label> <input
						type="password" style="width: 150px;" class="form-control"
						class=" col-lg-4" name="password" placeholder="비밀번호 입력">
				</div>
			</div>

			<!--<p>이메일 :</p> -->
			<!-- 한번에 묶어서 적용. -->
			<div class="container">
				<div class=" col-lg-4">

					<label for="email" class="form-label mt-4">이메일 :</label> <input
						type="email" class="form-control" style="width: 200px;"
						name="email" placeholder="이메일 입력">

					<!--  <p>핸드폰 번호 :</p> -->
					<label for="phone" class="form-label mt-4">핸드폰 번호 :</label> <input
						type="text" class="form-control" style="width: 150px;"
						name="phone" placeholder="핸드폰번호 입력"> <br>
				</div>
			</div>
	<hr class="my-10">
	<!--  선  -->


			<!-- 버튼  -->
			<a href="/ex08"><input type="button" value="메인화면"
				class="btn btn-secondary" onclick="alert('메인으로 이동합니다.')"></a>
			<button onclick="add()" onclick="alert('등록 되었습니다.')" class="btn btn-secondary">등록</button>
			<br>

		</form>
	</fieldset>
			</div>
			</div>
</body>
</html>