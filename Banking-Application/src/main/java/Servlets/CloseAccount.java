package Servlets;

import java.io.IOException;

import DAO.UserDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/CloseAccount")
public class CloseAccount extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String accountNo = req.getParameter("accountNo");
		String userName= req.getParameter("userName");
		String password = req.getParameter("password");
		if (UserDao.closeAccount(accountNo, userName, password)) {
			req.setAttribute("msg", "Success");
			req.setAttribute("cls", "success");
			req.getRequestDispatcher("CloseAccount.jsp").forward(req, resp);
		} else {
			req.setAttribute("msg", "UnSuccess");
			req.setAttribute("cls", "error");			
			req.getRequestDispatcher("CloseAccount.jsp").forward(req, resp);
		}
	}
}
