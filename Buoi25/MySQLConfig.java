package crm06.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConfig {

	public static Connection getConnection() {
		// Khai báo driver sử dụng cho jdbc
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/crmapp", "root", "admin");
		} catch (Exception e) {
			System.out.println("Không thể kết nối tới csdl " + e.getMessage());
		}
		return connection;
	}

}
