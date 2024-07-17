package Servlets;

import java.io.IOException;

import DAO.UserDao;
import bean.UserBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/Withdraw")
public class Withdraw extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String accountNo = req.getParameter("accountNo");
		String userName= req.getParameter("userName");
		String password = req.getParameter("password");
		float amount = Float.parseFloat(req.getParameter("amount"));
		UserBean ub = UserDao.balance(userName, password);
		if(amount>ub.getAmount()) {
			req.setAttribute("msg", "Insuficiente Balance");
			req.setAttribute("cls", "error");
			req.getRequestDispatcher("Withdraw.jsp").forward(req, resp);
		}
		else if (UserDao.withdraw(accountNo, userName, password, amount)) {
			req.setAttribute("msg", "Success");			
			req.setAttribute("cls", "success");
			req.getRequestDispatcher("Withdraw.jsp").forward(req, resp);
		} else {
			req.setAttribute("msg", "UnSuccess");
			req.setAttribute("cls", "error");
			req.getRequestDispatcher("Withdraw.jsp").forward(req, resp);
		}
	}
}
