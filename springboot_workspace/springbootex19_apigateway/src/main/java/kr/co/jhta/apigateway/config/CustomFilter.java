package kr.co.jhta.apigateway.config;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class CustomFilter extends AbstractGatewayFilterFactory<CustomFilter.Config> {
	
	// 설정 정보를 제공하는 클래스 (inner class )
	public static class Config {
		
	}
	public CustomFilter() {
		super(Config.class);
	}
	// 필터의 동작을 저의한 메서드
	@Override
	public GatewayFilter apply(Config config) {
//		GatewayFilter gf = new GatewayFilter() {
//			@Override
//			public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//				ServerHttpRequest request = exchange.getRequest();
//				ServerHttpResponse response = exchange.getResponse();
//				
//				log.info("Customer pre Filter : request id = {} ", request.getId());
//				Mono<Void> m = chain.filter(exchange).then(Mono.fromRunnable(() -> {
//					log.info("Custom Post filter : response code = {} ", response.getStatusCode());
//				}));
//				return m;
//			}
//		};
//		return gf;
		// 아래 코드와 같은 결과
		return (exchange, chain) -> {
			ServerHttpRequest request = exchange.getRequest();
			ServerHttpResponse response = exchange.getResponse();
			log.info("Customer pre Filter : request id = {} ", request.getId());
			return chain.filter(exchange).then(Mono.fromRunnable(() -> {
				log.info("Custom Post filter : response code = {} ", response.getStatusCode());
			}));
		};
	}
}
