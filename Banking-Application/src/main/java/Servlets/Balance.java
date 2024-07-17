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
@WebServlet("/Balance")
public class Balance extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userName = req.getParameter("userName");
		String password = req.getParameter("password");
		UserBean userBean = UserDao.balance(userName, password);
		if(userBean!= null) {
			req.setAttribute("msg", "Success");
			req.setAttribute("cls", "success");
			req.setAttribute("userBean", userBean);
			req.getRequestDispatcher("Balance.jsp").forward(req, resp);
		}
		else {
			req.setAttribute("msg", "Invalid Details");
			req.setAttribute("cls", "error");

			req.getRequestDispatcher("CheckBalance.jsp").forward(req, resp);
		}

	}

}
