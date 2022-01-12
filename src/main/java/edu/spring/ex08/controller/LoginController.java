/*
 * package edu.spring.ex08.controller;
 * 
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpSession;
 * 
 * import org.slf4j.Logger; import org.slf4j.LoggerFactory; import
 * org.springframework.stereotype.Controller; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RequestMethod;
 * 
 * @Controller
 * 
 * @RequestMapping(value = "/nboard") // requestmapping를 통해서 view의 요청경로 설정 11-29
 * //, method = RequestMethod.POST //
 * 
 * public class LoginController { private static final Logger Logger =
 * LoggerFactory.getLogger(LoginController.class);
 * 
 * // 다시 한번 읽어보는 컨트롤러 사용법. 11-27 // 사용자가 요청을하면 @controller로 진입 // // 요청에대한 작업
 * 수행하고 view 즉 jsp로 데이터 전달. // 컨트롤러를 이용해 클래스 생성 // requestmapping를 이용해 view의 요청
 * 경로를 지정 // // 요청 처리를 위한 메소드 즉 로직을 구현 // 뷰 이름 리턴.
 * 
 * // midel 객체를 파라미터로 받는다. // // model.addattribute를 이용하여 넘길 데이터의 이름과 값 넣기. //
 * 그러면 똑똑한 스프링은 그 값을 jsp view쪽으로 넘겨준다. // // jsp에선 ${}를 이용해서 값을 가져온다.
 * 
 * // modelandview 사용 시 // modelandview 객체를 선언 및 생성. // view 이름은 setViewName 라는
 * 메소드 친구를 이용한다. // addObject 메소드 친구를 이용하여 데이터를 보낸다. // // return을 통해서 mav 객체를
 * 반환한다. // jsp도 $ 즉 모델과 같이 이용하여 값을 가져온다., // // https://hongku.tistory.com/116
 * (글 개 좋다. 기본중의 기본.)11-26 // 모델과 모델뷰에 관한 글이니 1일 1독하며 반복
 * 
 * @GetMapping("/login") // 브라우저 상 입력한 값이 그대로 노출됨. public void loginGet() {
 * Logger.info("loginGet() 호출"); }
 * 
 * controller에서 request 요청을 보낼 때 get 방식과 post 방식 get과 post 방식의 차이. post 방식을 사용하면
 * 숨겨져서 전송, 로그인 페이지 등등 보안에 좋음-> 보안을 위한 페이지에서 사용! 왜? 주소창에 id와 pw가 노출이 안된다 . get
 * 방식은 브라우저상 내가 입력한 값이 노출된다.
 * 
 * 
 * @PostMapping("/login") // 브라우저 상 입력한 값이 숨겨져서 나옴. public String
 * loginPost(String userid, String password, HttpServletRequest request) {
 * Logger.info("loginPost() 호출"); if (userid.equals("test") &&
 * password.equals("1234")) { Logger.info("로그인 성공"); //
 * https://tsop.tistory.com/15 HttpSession session = request.getSession();
 * session.setAttribute("userid", userid); // 세션 속성명이 userid인 속성에 속성값으로 value를
 * 할당한다. // 당연히 오류나지 왜냐하면 userid가 없으니까.
 * 
 * // session에서 targetURL 가져오기. String targetURL = (String)
 * session.getAttribute("targetURL"); Logger.info("목표 url! : " + targetURL);
 * 
 * if (targetURL != null) { // 세션 속성명이 targetURL인 속성을 제거한다.
 * session.removeAttribute("targetURL");
 * 
 * return "redirect:" + targetURL; // redirect : 다시 지시할게. } else { return
 * "redirect :/nboard/nlist"; // 있는경우 }
 * 
 * } else { Logger.info("로그인 실패"); return "redirect:/nboard/login"; } // equals는
 * 메소드 대상의 내용자체를 비교. } // 로그인에 성공하면 세션을 만든다. request.getsession ㅇㅇ~
 * 
 * // httpservetRequest를 사용하면 값 받는게 가능 . // ex) id,pw 등의 데이터 컨트롤러로 보냈을때 hsr 객체안에
 * 모든 데이터들이 들어가게 됨.
 * 
 * // 원하는 데이터를 이용할땐 담은거에서 꺼내면된다. // getPrameter() 메소드는 string 타입. // ex) String
 * id = httpServletRequest.getParameter("id") // -> HttpServletRequest 객체안의 id값을
 * string타입으로 가져온다.
 * 
 * @GetMapping("/logout") public String logout(HttpServletRequest request) {
 * 
 * HttpSession session = request.getSession();
 * session.removeAttribute("userid"); return "redirect:nboard/nlist"; }
 * 
 * 
 * 
 * 
 * }// end
 */