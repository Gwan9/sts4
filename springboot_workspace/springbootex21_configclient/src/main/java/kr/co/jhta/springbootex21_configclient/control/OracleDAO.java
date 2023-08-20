package kr.co.jhta.springbootex21_configclient.control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

@Repository
public class OracleDAO {
	Connection conn = null;
	public void setConnection(String driver, String url, String username, String password) {
		System.out.println(driver + " : " + url + " : " + username + " : " + password);
			
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("conn : " + conn);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
