package application;

public class Customer extends User
{
	String contactinfo;
	String paymentinfo;
	
	Customer(String username, String password)
	{
		this.username = username;
		this.password = password;
	}
}
