package kr.co.jhta.springbootex20_configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@EnableConfigServer
@SpringBootApplication
public class Springbootex20ConfigserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springbootex20ConfigserverApplication.class, args);
	}

}
