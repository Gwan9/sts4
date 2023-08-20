package kr.co.jhta.springboot12.service;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import kr.co.jhta.springboot12.dto.MemberDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
//  기본 open인가사용자서비스를 상속받아서 커스텀한 사용자서비스 객체를 구현
public class CustomerOAuth2UseretailService extends DefaultOAuth2UserService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	// 유저로딩 메서드 재정의
	@Autowired
	MemberService service;
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		
		log.info(">>>>>>>>>>>>>>>>>>>>>>> userRequest : " + userRequest);
		// 등록 클라이언트 이름 가져오기
		String clientName = userRequest.getClientRegistration().getClientName();
		
		// 유저요청정보로 인증사용자 객체 얻어오기
		OAuth2User oAuth2User = super.loadUser(userRequest);
		
		Map<String, Object> map = oAuth2User.getAttributes();
		Set<String> s = map.keySet();
		Iterator<String> it = s.iterator();
		
		while(it.hasNext()) {
			String name= it.next();
			log.info(name + " : " + map.get(name));
			
		}
		
		String email = "";
		String name = "";
		// 구글 로그인 인지 확인 후
		if(clientName.equals("Google"))  {
			email = oAuth2User.getAttribute("email");
			name = oAuth2User.getAttribute("name");
		
		}else if (clientName.equals("Naver")) {
			Map<String, Object> map2 = oAuth2User.getAttributes();
			Map<String, Object> map3 = (Map<String,Object>)map2.get("response");
			email = (String)map3.get("email");
			name = (String)map3.get("name");
			log.info("네이버 이메일 : " + email);
			log.info("네이버 등록이름 : " + name);
		}else if (clientName.equals("Kakao")) {
			
			Map<String, Object> map2 = oAuth2User.getAttributes();
			
			Map<String, Object> map3 = (Map<String,Object>)map2.get("properties");	
			name = (String)map3.get("nickname");
			
			Map<String, Object> map4 = (Map<String,Object>)map2.get("kakao_account");	
			email = (String) map4.get("email");
			log.info("이메일 : {}, 이름 : {} ", email, name);
		}
		saveMember(email, name);
		
		
		
		return super.loadUser(userRequest);
		
	}

	private void saveMember(String email, String name) {
		// 기존에 등록되어있는 회원인지 확인 후
		
		MemberDTO dto = service.getMemberByEmail(email);
		log.info("멤버 : " + dto) ;
		
		
		
		// 등록되어 있지 않으면 db에 추가
		
		if(dto == null) {
			dto=
					MemberDTO.builder()
							.id(email)
							.pw(passwordEncoder.encode("1111"))
							.email(email)
							.name(name)
							.build();
			service.addUser(dto); // member 테이블에만 저장
			// member_role 에는 존재하지않음
			service.addRole(email);
		}
	}
}
