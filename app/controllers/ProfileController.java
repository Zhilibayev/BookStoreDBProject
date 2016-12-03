package controllers;

import play.mvc.Before;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dao.impl.CustomerDaoJDBC;
import dao.impl.CustomerDaoJDBC;
import models.Customer;
import play.mvc.Before;
import play.mvc.Controller;
import java.util.List;

public class ProfileController extends Controller{
	public static CustomerDaoJDBC customerDao = new CustomerDaoJDBC(); 
	public static Customer customer;
//	private String username;
//	private String address;
//	private String email;
//	private String phone;
//	private String password;
	
	@Before
	public static void sequrity(){
		if (session.isEmpty() == true){
			Application.loginPage();
		}
	}
	
	public static void profile() {
		System.out.println("CURRENT PAGE IS PROFILE");
		customer = customerDao.getCustomerById(Integer.parseInt(session.get("id")));
		JsonObject information = customer.convertToJson();
    	render(information);	
    }
	
	public static boolean changeUsername(String username){
		return customerDao.updateCustomerName(Integer.parseInt(session.get("id")), username);
	}
	
	public static JsonObject getCustomerInf(String username){
		customer = customerDao.getCustomerById(Integer.parseInt(session.get("id")));
		JsonObject information = customer.convertToJson();
		return information;
	}
	
	public static boolean changeAddress(String address){
		return customerDao.updateCustomerAddress(Integer.parseInt(session.get("id")), address);
	}
	public static boolean changeEmail(String email){
		return customerDao.updateCustomerEmail(Integer.parseInt(session.get("id")), email);
	}
	public static boolean changePhone(String phone){
		return customerDao.updateCustomerPhone(Integer.parseInt(session.get("id")), phone);
	}
	
	public static boolean checkPassword(String oldPassword, String newPassword) {
		Customer cust = customerDao.getCustomerById(Integer.parseInt(session.get("id")));
		
		
		if (oldPassword.equals(cust.getPassword())) {
			System.out.println(cust.getPassword() + " HELLO");
			int cid = cust.getId();
			if(customerDao.updateCustomerPassword(cid, newPassword)) {
				return true;
			}	
		}
		
		System.out.println("Old password does not match, please try again.");

		return false;
	}
	
	
}
