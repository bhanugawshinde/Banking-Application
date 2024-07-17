package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

import bean.UserBean;

public class UserDao {
	static Connection con = DBConnection.getConnection();

	public static boolean createAccount(UserBean userBean) {
		try {
			PreparedStatement pstmt = con.prepareStatement("insert into bank values(?,?,?,?,?,?)");
			String str = userBean.getPhone();
			StringBuilder acc = new StringBuilder("Bank");
			for (int i = 0; i < str.length(); i++) {
				if (i < 4)
					acc.append((char) (str.charAt(i) - '0' + 'Q'));
				else
					acc.append(str.charAt(i));
			}
			userBean.setAccountNo(acc.toString());
			pstmt.setString(1, acc.toString());
			pstmt.setString(2, userBean.getUserName());
			pstmt.setString(3, userBean.getPassword());
			pstmt.setFloat(4, userBean.getAmount());
			pstmt.setString(5, userBean.getAddress());
			pstmt.setString(6, userBean.getPhone());
			int k = pstmt.executeUpdate();
			if (k > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static UserBean balance(String userName, String password) {
		UserBean userBean = null;
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from bank where username =? and password=?");
			pstmt.setString(1, userName);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				userBean = new UserBean();
				userBean.setAccountNo(rs.getString(1));
				userBean.setUserName(userName);
				userBean.setPassword(password);
				userBean.setAmount(rs.getFloat(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userBean;
	}
	public static boolean deposit(String accountNo, float amount) {
		try {
			PreparedStatement pstmt = con.prepareStatement("update bank set amount=amount+? where ACCOUNTNO=?");
			pstmt.setFloat(1, amount);
			pstmt.setString(2, accountNo);
			int k = pstmt.executeUpdate();
			if (k > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static boolean withdraw(String accountNo,String userName, String password, float amount) {
		try {
			PreparedStatement pstmt = con.prepareStatement("update bank set amount=amount-? where ACCOUNTNO=? and username=? and password=?");
			pstmt.setFloat(1, amount);
			pstmt.setString(2, accountNo);
			pstmt.setString(3, userName);
			pstmt.setString(4, password);
			int k = pstmt.executeUpdate();
			if (k > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static boolean transfer(String accountNo, String userName, String password, float amount, String accountNo2,
			String userName2) {
		try {
			con.setAutoCommit(false);
			Savepoint setSavepoint = con.setSavepoint();
			PreparedStatement pstmt = con.prepareStatement("update bank set amount=amount-? where ACCOUNTNO=? and username=? and password=?");
			pstmt.setFloat(1, amount);
			pstmt.setString(2, accountNo);
			pstmt.setString(3, userName);
			pstmt.setString(4, password);
			int k = pstmt.executeUpdate();
			if (k > 0) {
				PreparedStatement pstmt2 = con.prepareStatement("update bank set amount=amount+? where ACCOUNTNO=? and username=?");
				pstmt2.setFloat(1, amount);
				pstmt2.setString(2, accountNo2);
				pstmt2.setString(3, userName2);
				int k2 = pstmt2.executeUpdate();
				if (k2 > 0) {
					con.commit();
					return true;
				}
				else {
					con.rollback(setSavepoint);
				}
			}else {
				con.rollback(setSavepoint);
				
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	public static boolean closeAccount(String accountNo, String userName, String password) {
		try {
			PreparedStatement pstmt = con.prepareStatement("delete from bank where accountno=? and username =? and password=? ");
			pstmt.setString(1, accountNo);
			pstmt.setString(2, userName);
			pstmt.setString(3, password);
			int k = pstmt.executeUpdate();
			if (k > 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
