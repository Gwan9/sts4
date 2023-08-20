package kr.co.jhta.zuulservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class Springbootex18ZuulserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springbootex18ZuulserviceApplication.class, args);
	}

}
