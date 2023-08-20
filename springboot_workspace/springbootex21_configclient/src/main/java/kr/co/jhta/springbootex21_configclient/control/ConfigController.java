package kr.co.jhta.springbootex21_configclient.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {
	@Autowired
	OracleDAO dao;
	
	@Value("${spring.datasource.driverClassName}")
	private String driver;
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;
	
	@GetMapping("/config")
	public String get() {
		dao.setConnection(driver, url, username, password);
		return "url : " + url; 
	}
}
