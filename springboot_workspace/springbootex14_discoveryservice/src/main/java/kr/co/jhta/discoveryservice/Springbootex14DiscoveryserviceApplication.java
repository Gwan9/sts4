package kr.co.jhta.discoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // eureak 서버 활성화
public class Springbootex14DiscoveryserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springbootex14DiscoveryserviceApplication.class, args);
	}

}
