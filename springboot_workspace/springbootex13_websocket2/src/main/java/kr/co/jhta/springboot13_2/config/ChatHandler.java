package kr.co.jhta.springboot13_2.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ChatHandler extends TextWebSocketHandler {
	List<WebSocketSession> list = new ArrayList<>();
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		// TODO Auto-generated method stub
		String payload = message.getPayload();
		
		log.info("payrload : " + payload );
		
		for(WebSocketSession webSocketSession : list) {
			webSocketSession.sendMessage(message);
			log.info("message {} 전송됨 " , message );
			
		}
	}
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		
		list.add(session);
		
		log.info("클라이언트 {} 접속함 " , session );
		
		
	}
	
	
	@Override
		public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
			list.remove(session);
			
			log.info("클라이언트 {} 접속해제함 " , session );
		}

}
