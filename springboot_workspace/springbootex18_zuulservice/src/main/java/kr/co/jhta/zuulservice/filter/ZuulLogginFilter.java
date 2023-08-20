package kr.co.jhta.zuulservice.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class ZuulLogginFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return false; // 필터 사ㅛㅇ
	}

	@Override
	public Object run() throws ZuulException {
		// 필터가 동작 된 다면 이 부분이 실행됨
		log.info(" 로그 시작 ==============>" );
		// 요청 URI 를 로그로 기록
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		String uri = request.getRequestURI();
		log.info(" 요청 URI : {}", uri);
		log.info(" 요청 URI : {}", RequestContext.getCurrentContext()
												.getRequest()
												.getRequestURI());
		log.info(" 로그 끝 ==============>");
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre"; // 진입 쪽 필터
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
