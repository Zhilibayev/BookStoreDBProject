package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import dao.impl.CustomerDaoJDBC;

import java.*;
import java.lang.reflect.Type;
import models.*;


public class Application extends Controller {
	public static final String ACY = "\u001B[36m";
	public static CustomerDaoJDBC customerDao = new CustomerDaoJDBC(); 
	
//	@Before
//	public static void sequrity(){
//		if (session.isEmpty() == false){
//			Customer c = customerDao.getCustomerById(Integer.parseInt(session.get("id")));
//			MainPageController.mainPage();
//		}
//	}
	
    public static void loginPage() {
    	System.out.println("CURRENT PAGE IS LOGIN PAGE " + ACY);
    	String error = flash.get("error");
    	render(error);
    }
    
    public static void registrationPage() {
    	String error = flash.get("error");
    	render(error);
    }
    
    public static void logout(){
    	System.out.println("Applicatoin Class");
    	session.clear();
    	loginPage();
    }
    
    
    public static void login(int tid){
    	session.put("id", tid);
    }
    
    public static boolean requestHandle(String tid){
    	HashMap<String, String> son = new Gson().fromJson(tid, new TypeToken<HashMap<String, String>>(){}.getType());	
    	return checkLogin(son.get("u"), son.get("p"));
    }
    
    public static boolean checkLogin(String email, String password){
    	Customer c = customerDao.getCustomerByEmail(email);
    	System.out.println(c);
    	if (c == null || !c.getPassword().equals(password)){
    		return false;
    	}
    	login(c.getId());
    	return true;
    }
    
    public static boolean registrationHandle(String data){
    	HashMap<String, String> son = new Gson().fromJson(data, new TypeToken<HashMap<String, String>>(){}.getType());	
    	Customer c = new Customer(son.get("u"), son.get("a") ,son.get("e"), son.get("ph"), son.get("p")); 
    	System.out.println(c);
    	boolean k = checkNewRegistration(c);
    	return k;
    }
    
    public static boolean checkNewRegistration(Customer c){
    	Customer check = customerDao.getCustomerByEmail(c.getEmail());	
    	if (check == null){
    		try {
    			System.out.println("What is wrong?");
				customerDao.saveCustomer(c);
				return true;
    		} catch (Exception e) {
				e.printStackTrace();
			}
    	}	
    	return false;
    }
    
    
   
}











