package crm06.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm06.config.MySQLConfig;

@WebServlet(name = "AddRoleController", urlPatterns = { "/role-add" })
public class AddRoleController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("role-add.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			String roleName = req.getParameter("role_name");
			String description = req.getParameter("description");

			String query = "INSERT INTO roles (name, description) VALUES (?, ?)";
			connection = MySQLConfig.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, roleName);
			preparedStatement.setString(2, description);
			int rowsAffected = preparedStatement.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Thêm dữ liệu thành công.");
			} else {
				System.out.println("Không thể thêm dữ liệu.");
			}

			connection.close();

		} catch (Exception e) {
			System.out.println("Không thể kết nối tới csdl " + e.getMessage());
		}
	}
}
