+<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title>Home</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<!-- 인터넷 강의 참고   아이콘 활용가능 이제.-->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/main.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">

<!-- 부트 스트랩은 추가적인 사용법 숙지  -->

</head>
<body>
	<div class="container-fluid" id="yk1" style= "height:150%;"> <!-- 전체 초록색-->
		<!-- <div class="container" style="background : LightSteelBlue;">
			<h2 style="margin : 0px;">
				<span class="material-icons"
					style="color: black; font-size: 30px;"> phone </span> <label
					for="email" class="form-label mt-4"> Call 저장소 환영합니다.</label>
			</h2>
		</div> -->

		<!--  -->


		<!-- 버튼 뒷 배경 -->

		<!--  <nav class="navbar navbar-expand-lg navbar-dark bg-dark"> -->
		<!-- <div class="container-fluid"> -->
		<!--    <nav class="navbar navbar-expand-lg navbar-light bg-light"> -->

		<!--     <div class="container"> -->
		
		<div class="container" style= "background : White; padding: 0px; height:100%; ">  <!-- 가운데 -->
			<h5 style="margin : 0px;">
				<span class="material-icons"
					style="color: black; font-size: 30px;"> phone </span> <label  
					for="email" class="form-label mt-4"> 스팸번호 저장소</label> <!-- 이모티콘 색깔  -->
			</h5>
			<h6>
			
			</h6>
			<div class="wd-100" style="padding: 0px 10px;">
			<label for="email" class="form-label mt-4">메뉴</label><br>
			<!-- <label></label>  -->
			<div3>
			
			<a href="nboard/nlist"><button type="button"
					class="btn btn-secondary" >공지사항</button></a> <a href="fboard/flist"><button
					type="button" class="btn btn-secondary">자유게시판</button></a> <a
				href="cboard/clist"><button type="button"
					class="btn btn-secondary">스팸번호게시판</button></a>
			</div3>
			<hr class="my-10"> <!--  선  -->
			<!-- 줄 그어줌  -->
			<!-- 부트스트랩 사용   -->

			<h1 class="display-10"></h1>
			<!-- 줄 그어줌  -->


			<!--      <legend>메뉴</legend> -->

			<!--  <div class="container"> -->

			<!-- 출처: https://minaminaworld.tistory.com/137 [미나미 블로그] -->

			<!--  <a href="nboard/nlist"><input type="button" value="공지사항"></a> -->
			<!--<a href="fboard/flist"><input type="button" value="자유게시판"></a> -->
			<!-- <a href="cboard/clist"><input type="button" value="스팸번호게시판"></a> -->

			<!-- class="btn btn-secondary">Secondary
 -->

			<!-- 중간 띄움  -->
			<!--  <fieldset>
 <legend></legend> -->
			<jsp:include page="/WEB-INF/views/member/login.jsp" />
			<!-- </fieldset> -->
			<br> <br>
			<!-- 게시판 인클루드 미 사용  -->
			<fieldset>
				<%-- <jsp:include page="/WEB-INF/views/nboard/nlist.jsp"/> --%>
				<!--인클루드를 사용하여 한페이지에 여러 모듈을 더할 수 있다.! 매우좋음 12-01  -->
				<!-- https://enzycut.tistory.com/entry/jsp-include-%EC%82%AC%EC%9A%A9%EB%B0%A9%EB%B2%95 include 사용법 -->
			</fieldset>
<!-- 
			예제1  목록양식
			<ul class="nav nav-pills" role="tablist">
				<li role="presentation" class="active"><a href="#">Home</a></li>
				<li role="presentation"><a href="#">Profile</a></li>
				<li role="presentation"><a href="#">Messages</a></li>
			</ul>

			<br>
			예제2 게시판양식 
			<div class="col-md-6">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>#</th>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Username</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1</td>
							<td>Mark</td>
							<td>Otto</td>
							<td>@mdo</td>
						</tr>
						<tr>
							<td>2</td>
							<td>Jacob</td>
							<td>Thornton</td>
							<td>@fat</td>
						</tr>
						<tr>
							<td>3</td>
							<td>Larry</td>
							<td>the Bird</td>
							<td>@twitter</td>
						</tr>
					</tbody>
				</table>
			</div> -->
			</div>
		</div>
	</div>
	
	
	
	
	
	<!-- <head>
	<title>드롭다운 테스트</title>
	</head>
	<body>
	
<div id="container">
<ul>
	<li>메뉴1</li>
	<li>메뉴2</li>
	<li>메뉴3</li>
	<li>메뉴4</li>
	<li>메뉴5</li>
	<li>메뉴6</li>



</ul> -->

</div>
	
	
</body>
</html>
