package controllers;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dao.impl.BookDaoJDBC;
import dao.impl.CartDaoJDBC;
import dao.impl.CustomerDaoJDBC;
import models.Book;
import models.Cart;
import models.Customer;
import play.mvc.Before;
import play.mvc.Controller;

public class CartPageController extends Controller{
	public static CustomerDaoJDBC customerDao = new CustomerDaoJDBC(); 
	public static Customer customer;
	public static final String AGR = "\u001B[32m";
	public static BookDaoJDBC bookDao = new BookDaoJDBC();
	public static CartDaoJDBC cartDao = new CartDaoJDBC();
	
	@Before
	public static void sequrity(){
		if (session.isEmpty() == true){
			Application.loginPage();
		}
	}
	
	public static void cartPage() {
		System.out.println("CURRENT PAGE IS PROFILE");
		customer = customerDao.getCustomerById(Integer.parseInt(session.get("id")));
		JsonObject information = customer.convertToJson();
    	render(information);	
    }
	
	public static String getAllBooks(){
		System.out.println("Hello");
		List<Book> books = 	cartDao.getBooksByCustomerId(Integer.parseInt(session.get("id")));	
		String json = new Gson().toJson(books);
		System.out.println(json);
		return json;
	}
	public static boolean removeFromCart(String isbn){
		System.out.println("Hello");
		Cart c = new Cart(isbn, Integer.parseInt(session.get("id")));
		return cartDao.removeFromCart(c);
	}
	
}












