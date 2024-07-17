package bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserBean implements Serializable{
	private String accountNo;
	private String userName;
	private String password;
	private float amount;
	private String address;
	private String phone;
	
	public UserBean() {
		super();
	}

	public UserBean(String userName, String password, float amount, String address, String phone) {
		super();
		this.userName = userName;
		this.password = password;
		this.amount = amount;
		this.address = address;
		this.phone = phone;
	}
	
	
	
	public UserBean(String accountNo, String userName, String password, float amount, String address, String phone) {
		super();
		this.accountNo = accountNo;
		this.userName = userName;
		this.password = password;
		this.amount = amount;
		this.address = address;
		this.phone = phone;
	}
	

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "UserBean [userName=" + userName + ", password=" + password + ", amount=" + amount + ", address="
				+ address + ", phone=" + phone + "]";
	}
	
	
	
}
