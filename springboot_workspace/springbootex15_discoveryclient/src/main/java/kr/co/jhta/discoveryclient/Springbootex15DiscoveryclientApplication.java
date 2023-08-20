package kr.co.jhta.discoveryclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //eureka Client 활성화
public class Springbootex15DiscoveryclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springbootex15DiscoveryclientApplication.class, args);
	}

}
