package baitap01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/product")
public class Product extends HttpServlet {
	private int stt = 0;
	private List<String[]> productList = new ArrayList<>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("productList", productList);
		req.getRequestDispatcher("product.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String productName = req.getParameter("product-name");
		String quantity = req.getParameter("quantity");
		String price = req.getParameter("price");

		stt++;
		productList.add(new String[] { String.valueOf(stt), productName, quantity, price });

		resp.sendRedirect("product");
	}
}
