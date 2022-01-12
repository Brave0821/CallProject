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
<!-- <script>
	var $js = jQuery.noConflice();
</script> uncaught typeerror is not a function 에러 직후 검색 후 적용해봄 11-22 실패.
 -->

<title>${vo.ftitle }</title>
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
				제목 <input type="text" value="${vo.ftitle }" readonly="readonly">
			</p>
		</div>


		<div>
			<p>작성자 : ${vo.fuserid }</p>
			<fmt:formatDate value="${vo.fcdate}" pattern="yyyy-MM-dd HH:mm:ss"
				var="fcdate" />
			<p>작성일 : ${fcdate }</p>
		</div>


		<!-- 위에  taglib 추가 안해주면 노란줄 나온다. 아래 나오는 이유!  
      JSTL(JSP Standard Tag Library)는 
      JSP 페이지 작성시에 사용 가능한 여러 유용한 커스텀 태그나 함수가 포함 되어 있다.
      c태그도 JSTL에 포함되어 있으며 사용하려면 라이브러리로써 추가하거나 또는
      위의 taglib 디렉티브를 꼭 추가해주어야 한다!  https://chemeez.tistory.com/12
      -->

		<div>
			<textarea rows="20" cols="120" readonly="readonly">${vo.fcontent }</textarea>
		</div>



		<div>
			<a href="flist?page=${page }"><input type="button"
				class="btn btn-secondary" value="글 목록"></a> <a
				href="fupdate?bno=${vo.bno }&page=${page}"><input type="button"
				class="btn btn-secondary" value="글 수정"></a> <a
				href="fdelete?bno=${vo.bno }"><input type="button"
				class="btn btn-secondary" onclick="alert( '삭제되었습니다.')" value="글 삭제"></a>
		</div>



		<!-- 자유게시판 댓글.  -->


		<div style="text-align: center">
			<!-- center -->
			<div>
				<input type="hidden" id="freplybno" value=${vo.bno }>
				<!--  value="2";>  -->

				<%--  ${vo.freplybno } --%>

				<!--  $('input[freplybno=t_freplybno]').val(); 실험1 -->

				<!--  $('#freplybno').val(); -->

				<!--
        hidden value
        hidden 입력 필드의 value 속성값 설정/반환. 
        https://devjhs.tistory.com/560 -->

				<input type="text" value="${sessionScope.userid }" id="freplyid">
				<input type="text" id="freplycontent" placeholder="내용입력">

				<button type="button" class="btn btn-secondary" id="btn_add">작성</button>
			</div>
		</div>
	</div>
	<!--     jsp에서 $사용하면 뭔가를 불러온다는 의미. 
    즉 밑에 '#freplybno'는 위에 id  설정한 값을 불러온다는 것.
     -->

	<hr>
	<div style="text-align: left;">
		<!-- center -->
		<div id="freplies"></div>
		<!-- ID로 가져와서 ajax로  -->
	</div>


	<script type="text/javascript">
		$(document)
				.ready(
						function() {
							var freplybno = $('#freplybno').val(); // 게시판 번호 값
							getAllReplies();

							$('#btn_add').click(function() {

								var freplycontent = $('#freplycontent').val(); // 댓글 내용
								var freplyid = $('#freplyid').val(); // 댓글 작성자 아이디 

								var obj = { // 데이터 보냄 

									'freplybno' : freplybno,
									'freplycontent' : freplycontent,
									'freplyid' : freplyid

								}; //''부분 간격 주의하기. 11-17

								// 11-17 보낼 때 받을 때 둘다 json - obj를 json으로 변환하려면 뭘 써야할까?    
								// JavaScript Object Notation - > JSON은 속성-값 or 키-값 쌍으로 이루어진.
								// 데이터 오브젝트를 전달하기 위해 인간이 읽을 수 있는 텍스트를 사용하는 개방형 표준 포맷이다. 

								var JSONObj = JSON.stringify(obj); // 이렇게 입력하면 JSON으로 변환된다. 11-17

								// $불러온다.
								// $.ajax로 송수신

								$.ajax({
									type : 'post',
									url : '	/ex08/freplies/freplies', // FReplyRESTController에 replyAdd?(애는 없었는데?)
									// 로 이동 url적기 

									// 11-17 보내니까 json 잘 받아.
									headers : {
										'Content-Type' : 'application/json',
										'X-HTTP-Method-Override' : 'POST'
									}, // OCR 광학문자인식

									data : JSONObj, // 이거 제이슨으로 보내줄게~~ JSON타입은 기본적으로 문자열이기에.
									//{OBJ : JSON.stringify(obj)}, 제이슨으로 바꾸는거 안씀.
									success : function(result, status) {
										console.log(result);
										console.log(status);
										// status로 주면은 ok! 유지보수 측면에서 바로바로 알 수 있다.

										if (result == 1) {
											alert('댓글 입력 성공 :D');
											getAllReplies(); // 새로고침 후 데이터를 다시 한번 가져온다. 
											//11.19 getAllReplies(); 위에 추가하고 F11하면 댓글 추가하고 자동으로 나온다. 
										}
									}
								}); // end ajax()
							}); // end btn_add click

							// 11-17 <div style="text-align : center;"> 이거!
							// 위 만들고 
							// 게시판의 댓글 전체 가져오기. 밑
							function getAllReplies() {
								var url = '/ex08/freplies/all/' + freplybno; // 현재 게시판. //url에 이름이 들어가는건 좋은 상황은 아니다.    

								$
										.getJSON(
												// end getJSON() 파싱을 알아서 해주기에 JSON이면.
												url,
												function(jsonData) {
													// jsonData : 서버에서 온 list 데이터가 저장되어 있다.

													console.log(jsonData); // 가져왔다.

													var replyWriter = $('')
															.val(); // 로그인 사용자 아이디.
													var list = "";
													console.log(list);
													// $(컬렉션).each() : 컬렉션 데이터를 반복문으로 꺼내는 함수 
													// for each는 하나 씩 꺼내주기에.

													$(jsonData)
															.each(
																	function() {
																		console
																				.log(this);
																		//typeof 확인하는 방법 (typeof(this));
																		var freplydate = new Date(
																				this.freplydate); // - > *
																		// 데이트 타입으로 변환해주기!.
																		var disabled = ''; // disabled 버튼이 망가지는 것.
																		var readonly = ''; // readonly 아이디를 가려준다. 읽기만 가능하게.

																		/* if(replyWriter == this.replyId) { // 로그인한 사람과 작성자가 일치할 때 ㅇㅇ 
																		        disabled = '';
																		        readonly = ''; */

																		list += '<div class="reply_item">' // 임의 변수 지정해주는건가? 11-17
																				+ '<pre>'
																				+ '<input type="hidden" id="freplyno" value="' + this.freplyno + '" />'
																				+ '<input type="hidden" id="freplyid" value="' + this.freplyid + '" />'
																				+ this.freplyid
																				+ '&nbsp;&nbsp;' //공백
																				+ '<input type= "text" id="freplycontent" value="' + this.freplycontent + '"' + readonly + '/>'
																				+ '&nbsp;&nbsp;' //공백 '+ readonly +' 위 추가하기. 아이디를 가려줌 읽기만 가능하게. - > 추가함 확인 11.24
																				+ freplydate
																				+ '&nbsp;&nbsp;' //공백

																				// 여기 if문. 
																				//var disabled = 'disabled'; 코드가 망가지고 로그인한 사람과 작성자가 일치할 때만 고장이 풀리면 된다. 

																				+ '<button class="btn_update"   type="button"' + disabled +'>수정</button>'
																				+ '<button class="btn_delete" type="button"' + disabled +'>삭제</button>'
																				+ '</pre>' // 밑 업데이트와 삭제에 네임 맞추기.
																				+ '</div>';
																		// http dom 참고 사이트 윗 개념을 이해하기 쉬워짐.
																		//https://developer.mozilla.org/ko/docs/Web/API/Document_Object_Model/Introduction

																		// <div id= "freplies"></div> 아이디로 가져와서 에이작스로 위에 저기로 보여줌.
																	}); // end each() 댓글에 아이디와 시간 나오게 하는 것. (jsonData) 하나 씩 꺼내기   
													$('#freplies').html(list);

												}); // end getJSON()
							} // end getAllReplies()

							// 수정버튼을 클릭하면 선택된 댓글 수정.

							$('#freplies')
									.on(
											'click',
											'.reply_item .btn_update',
											function() {
												console.log(this);

												var freplyno = $(this).prevAll(
														'#freplyno').val(); //11-22 여기가 이상하다. 개발자 도구 상.
												//11-22 preAll 오류 prevAll ㅇㅇ 이런; 개발자 도구 적극사용ㅇㅇ 
												var freplycontent = $(this)
														.prevAll(
																'#freplycontent')
														.val();

												// 이전 
												console.log("선택된 댓글 번호 : "
														+ freplyno
														+ ", 댓글 내용 :"
														+ freplycontent);

												// ajax 요청. 11-17 $는 무언가를 불러온다는 의미
												
														$.ajax({ // 원래 get 안 사용한다.
															type : 'put',
															url : '/ex08/freplies/'
																	+ freplyno, // update?replyno = 지움
															data : JSON
																	.stringify({

																		// delelte는 url : '/ex08/freplies/' + freplyno,

																		'freplybno' : freplybno,
																		'freplycontent' : freplycontent

																	}), // json 형태로 

															headers : {
																'Content-Type' : 'application/json',
																'X-HTTP-Method-Override' : 'PUT'
															}, // OCR

															success : function(
																	result) {
																if (result == 'success') {
																	alert('댓글 수정 성공:D');
																	getAllReplies();
																}
															} // success     
														}); // end ajax
											}); // replies.on()

							/////////////////////////////////////////////// 

							$('#freplies')
									.on(
											'click',
											'.reply_item .btn_delete', //  여기 버튼을 btn_update로 바꾸니 수정버튼을 누르니 지워짐.

											function() {
												console.log(this);

												var freplyno = $(this).prevAll(
														'#freplyno').val();
												console.log("선택된 댓글 번호 :"
														+ freplyno);

												// ajax 요청.
												
														$.ajax({ // 원래는 GET 안 사용 
															type : 'delete', // 11-18 수정 
															url : '/ex08/freplies/'
																	+ freplyno,

															data : JSON
																	.stringify({
																		'freplybno' : freplybno
																	}),

															headers : {
																'Content-Type' : 'application/json',
																'X-HTTP-Method-Override' : 'DELETE'
															}, // OCR

															success : function(
																	result) {
																if (result == 'success') {
																	alert('댓글 삭제 성공 :D')
																	getAllReplies()
																}
															}// end success        
														}); // end ajax
											}); // replies.on()  
						}); // end document

		//JQuery에 ON기능 이벤트를 여러 개 처리하는게 ON
		// freplies 중에서 클릭한 것에 freplies-item 밑에 클래스 이름을 찾고 
		// 그 안에서 수정 버튼을 찾는다.      
		// 이렇게 구현을 하면 가져오는 객체의 정보가 console.log(this); 입력
	</script>

</body>
</html>