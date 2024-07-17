package Servlets;

import java.io.IOException;

import DAO.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/Deposit")
public class Deposit extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String accountNo = req.getParameter("accountNo");
		float amount = Float.parseFloat(req.getParameter("amount"));
		if (UserDao.deposit(accountNo, amount)) {
			req.setAttribute("msg", "Success");
			req.setAttribute("cls", "success");
			req.getRequestDispatcher("Deposit.jsp").forward(req, resp);
		} else {
			req.setAttribute("msg", "UnSuccess");
			req.setAttribute("cls", "error");
			req.getRequestDispatcher("Deposit.jsp").forward(req, resp);
		}
	}
}
