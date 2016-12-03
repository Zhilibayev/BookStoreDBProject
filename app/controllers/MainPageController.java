package controllers;

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
import java.util.List;

public class MainPageController extends Controller {
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
		System.out.println(session.all());
	}
	
	public static void mainPage() {
		System.out.println("CURRENT PAGE IS MAINPAGE " + AGR);
		customer = customerDao.getCustomerById(Integer.parseInt(session.get("id")));
		JsonObject information = customer.convertToJson();
    	render(information);	
    }
	
	public static String getAllBooks(){
		System.out.println("Hello");
		List<Book> books = 	bookDao.getAllBooks();	
		String json = new Gson().toJson(books);
		System.out.println(json);
		return json;
	}
	
	public static String getBooksByTitle(String title){
		System.out.println(title);
		List<Book> books = 	bookDao.getBookByTitle(title);	
		String json = new Gson().toJson(books);
		System.out.println(json);
		return json;
	}
	
	public static String getBooksByAuthor(String author){
		System.out.println(author);
		List<Book> books = 	bookDao.getBookByAuthorName(author);	
		String json = new Gson().toJson(books);
		System.out.println(json);
		return json;
	}
	
	public static String getBooksByISBN(String isbn){
		System.out.println(isbn);
		List<Book> books = bookDao.getBookByIsbnSBS(isbn);	
		String json = new Gson().toJson(books);
		System.out.println(json);
		return json;
	}
	
	public static String getBooksByPublisher(String publisher){
		System.out.println(publisher);
		List<Book> books = 	bookDao.getBookByPublisher(publisher);	
		String json = new Gson().toJson(books);
		System.out.println(json);
		return json;	
	}
	public static String getBooksByCustomerId(int customer){
		System.out.println(customer);
		List<Book> books = 	cartDao.getBooksByCustomerId(customer);	
		String json = new Gson().toJson(books);
		System.out.println(json);
		return json;	
	}
	public static boolean addToCard(String isbn){
		Cart c = new Cart(isbn, Integer.parseInt(session.get("id")));
		boolean f = cartDao.saveCart(c);
		System.out.println(f);
		return f;
	} 
	
	
	
	
	
}
