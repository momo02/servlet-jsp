문제.1
index.jsp 문서를 보면 완벽하지 않은 소스입니다.
코드를 수정하여 post 방식으로 전달하시고 action을 LoginController로 설정하세요.


문제.2
LoginController, MessageController는 아직 서블릿 객체가 아닙니다.
서블릿을 상속하고 DD파일에 등록하여 서블릿을 만드세요.
Servlet 이름을 각각 loginServlet, messageServlet 으로
url Mapping을 각각 loginServlet.do, messageServlet.do로 작성하세요.


문제.3
loginServlet에 init-param 속성으로 name - value 를 
각각  id - victory , pass - victory123 으로 등록하세요
등록한 id, pass는 로그인시 비교 대상이 됩니다.


문제.4
MyListener를 완성하세요.


문제.5
Listener에서 filePath를 참조합니다.
filePath를 context-param 속성을 이용해 등록하세요
value 는 "WEB-INF/member.txt"입니다.


문제.6
LoginController에서
init()에 servletContext 와 fullPath를 초기화하세요.


문제.7
LoginController에서
doPost()를 구현하세요.
이메서드는 index.jsp 에서 구해온 id와 pass를
LoginServlet의 init-param 속성에 id, pass 값과 비교합니다.


문제.8
Log 클레스에 writeLog 메서드는 message를 txt 파일에 기록하는 역할을 합니다.
로그인 처리를 로그로 남기세요.


아이디가 틀렸을 시 - "chunkind 로그인 실패(아이디)"
비밀번호가 틀렸을 시 - "chunkind 로그인 실패(비밀번호)"
로그인 성공시 - "chunkind 로그인 성공"



문제.9
servletContext에 

아이디가 틀렸을 시 - "chunkind 로그인 실패(아이디)"
비밀번호가 틀렸을 시 - "chunkind 로그인 실패(비밀번호)"
로그인 성공시 - "chunkind 로그인 성공"

값을 저장하고 messageServlet에서 context에 저장한 message가 보일 수 있게 로직을 작성하세요.


문제.10
로그가 기록된 membet.txt를 찾고
해당 내용을 아래에 작성하고 readme.txt 파일을 제출하여 주세요.
예)
-------------------------------------------------------------
[2017-04-04 17:30:46초]톰켓 시작
[2017-04-04 17:30:55초]victory로그인 성공!
[2017-04-04 17:30:58초]톰켓 종료
-------------------------------------------------------------



아래 작성)
-------------------------------------------------------------


-------------------------------------------------------------