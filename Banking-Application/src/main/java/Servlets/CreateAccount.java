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
@WebServlet("/CreateAccount")
public class CreateAccount extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		String num = req.getParameter("amount");
		float amount=Float.parseFloat(num);
		String address = req.getParameter("address");
		String phone = req.getParameter("phone");
		
		UserBean userBean = new UserBean(userName, password, amount, address, phone);
		if(UserDao.createAccount(userBean)) {
			req.setAttribute("msg", "Success");
			req.setAttribute("cls", "success");
			req.setAttribute("userBean", userBean);
			req.getRequestDispatcher("Account.jsp").forward(req, resp);
		}
		else {
			req.setAttribute("msg", "UnSuccess");
			req.setAttribute("cls", "error");
			req.getRequestDispatcher("NewAccount.jsp").forward(req, resp);
		}

	}
}
