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
@WebServlet("/Transfer")
public class Transfer extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String accountNo = req.getParameter("accountNo");
		String userName= req.getParameter("userName");
		String password = req.getParameter("password");
		float amount = Float.parseFloat(req.getParameter("amount"));
		
		String accountNo2 = req.getParameter("accountNo2");
		String userName2= req.getParameter("userName2");
		UserBean ub = UserDao.balance(userName, password);
		if(amount>ub.getAmount()) {
			req.setAttribute("msg", "Insuficiente Balance");
			req.setAttribute("cls", "error");
			req.getRequestDispatcher("Withdraw.jsp").forward(req, resp);
		}
		else if (UserDao.transfer(accountNo, userName, password, amount,accountNo2, userName2)) {
			req.setAttribute("msg", "Success");
			req.setAttribute("cls", "success");
			req.getRequestDispatcher("Transfer.jsp").forward(req, resp);
		} else {
			req.setAttribute("msg", "UnSuccess");
			req.setAttribute("cls", "error");
			req.getRequestDispatcher("Transfer.jsp").forward(req, resp);
		}
	}
}
