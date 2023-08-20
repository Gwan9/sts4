<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
</head>
<script type="text/javascript">
	$(document).ready(function(){
		
		const username = "${user}"
		
		/* $("#button-send").on("click", function(e){
			
		}) */
		
		$("#button-send").on("click", (e) => {
			send();
		});
		const websocket = new WebSocket ("ws://http://192.168.0.27/:8082/ws/chat");
		
		websocket.onmessage = onMessage;
		websocket.onopen = onOpen;
		websocket.onclose = onClose;
		
		function send(){
			// id가 msg엘리먼트 가져오기
			let msg = document.getElementById("msg");
			// 콘솔에 어떤값이 들어있는지 한번 출력해보기
			console.log(username + " : " + msg.value);
			// 서버로 메세지 전송
			websocket.send(username + " : " + msg.value);
			// 다 보냈으면 input:text 내용 지우기
			msg.value='';
			
		}
		// 채팅창 나갔을 때
		function onClose(e){
			let str = username + "님이 방을 나가셨습니다";
			websocket.send(str);
		}
		function onOpen(e){
			let str = username + ": 님이 입장하셨습니다";
			websocket.send(str);
		}
		function onMessage (msg){
			console.log("msg: " + msg);
			let data = msg.data;
			let message = null;
			let arr = data.split(":");
			for( let i=0; i<arr.length; i++){
				console.log('arr['+ i +'] :' + arr[i]);
			}
			
			//내가 보낸 글과 남이 보낸 글 분리
			
			let cur_session = username;
			
			// 받은 메세지 작성자
			messageSender = arr[0].trim();
			let rmessage = arr[1];
			
			// 내가 보낸 메세지라면
			if(messageSender == cur_session){
				
			
			// 받은 메세지를 html 형식으로 작성
				let tag = "<div class='col-6'>";
				tag += "<div class='p-3 text-primary-emphasis bg-primary-subtle border border-primary-subtle rounded-3'>";
				tag += "<b>" + messageSender + " : " + rmessage + "</b>";
				tag += "</div></div>";	
			
				$("#msgArea").append(tag);
			}else{
				//다른 사람이 보낸 메세지 라면
				let tag = "<div class='col-6'>";
				tag += "<div class='p-3 text-primary-emphasis bg-success-subtle border border-primary-subtle rounded-3'>";
				tag += "<b>" + messageSender + " : " + rmessage + "</b>";
				tag += "</div></div>";	
			
				$("#msgArea").append(tag);
				
			}
		}
	})
</script>
<body>
	<div class="container">
		<div class="col-6">채팅방</div>
		
		<div>
			<div id="msgArea">
				<div class="col-6">
					<div class="input-group mb-3">
						  <input type="text" id="msg" class="form-control"
						   placeholder="전달 할 메세지" 
						   aria-label="전달 할 메세지" 
						   aria-describedby="button-addon2">
						  <button class="btn btn-outline-secondary" 
						  type="button" 
						  id="button-send">전송
						  </button>
						</div>
				</div>
				
			</div>
			
			<!-- 채팅 출력되는 부분 -->
		</div>
		
	
	</div>

</body>
</html>