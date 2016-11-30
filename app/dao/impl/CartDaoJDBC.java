package dao.impl;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 
import java.util.ArrayList; 
import java.util.List; 
import java.util.Properties;

import models.Author;
import models.Book;
import models.Cart;
import models.Customer;
import models.Publisher; 

public class CartDaoJDBC { 

	private static final String USER = "root"; 
	private static final String PASSWORD = "Eeijoqu4x"; 
	private static final String PORT = "3306"; 
	private static final String SERVER = "localhost"; 
	private static final String DATABASE = "dzhstore"; 
	private static final String DBMS = "mysql"; 

	Connection conn = null; 

	public CartDaoJDBC() { 
		try { 
			conn = getConnection(); 
		} catch (SQLException e) { 
			System.out.println("SQLException during database connection"); 
		} 
	} 

	private Connection getConnection() throws SQLException { 
		Connection conn = null; 
		Properties connectionProps = new Properties(); 
		connectionProps.put("user", USER); 
		connectionProps.put("password", PASSWORD); 
		conn = DriverManager.getConnection("jdbc:" + DBMS + "://" + SERVER + ":" + PORT + "/" + DATABASE, connectionProps); 
		return conn; 
	} 

	public boolean saveCart(Cart cart){ 
		if (cart == null) { 
			return false; 
		}
		try {
			Statement stmt = conn.createStatement(); 
			stmt.executeUpdate("Insert into cart(book_isbn, customer_cid) values ( '" 
					+ cart.getBook().getIsbn() + "', " 
					+ cart.getCustomer().getId() + ");"); 
			stmt.close(); 
			return true; 
		} catch (SQLException e) { 
			System.out.println(e.getMessage() + "SQLException when saving a book " + cart.toString()); 
			return false; 
		} 
	} 


	public List<Book> getBooksByCustomerId(int cid) { 
		List<Book> books = new ArrayList<Book>(); 
		if (cid == 0) { // should correct this place 
			return null; 
		} 
		try { 
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery( 
					"select * from book b join cart c on b.isbn = c.book_isbn where customer_cid = '" + cid + "';"); 
			transferData(rs, books); 
			stmt.close(); 
			return books; 
		} catch (SQLException e) { 
			System.out.println(e.getMessage()); 
			return null; 
		} 

	} 
	
	public boolean removeFromCart(Cart cart) { 
		
			if (cart == null) { 
				return false; 
			}
			try {
				Statement stmt = conn.createStatement(); 
				stmt.executeUpdate("Delete from cart where book_isbn = '"+cart.getBook().getIsbn()+"' and customer_cid ='"+cart.getCustomer().getId()+"';"); 
				stmt.close(); 
				return true; 
			} catch (SQLException e) { 
				System.out.println(e.getMessage() + "SQLException when removing a book " + cart.toString()); 
				return false; 
			} 
	} 
	
	public void transferData(ResultSet rs, List<Book> books) throws SQLException{ 
		PublisherDaoJDBC pub = new PublisherDaoJDBC();
		AuthorDaoJDBC aut = new AuthorDaoJDBC();
		while (rs.next()) {
			Book b = new Book();
			b.setIsbn(rs.getString("isbn"));
			b.setTitle(rs.getString("title"));
			b.setPrice(rs.getInt("price"));
			b.setYear(rs.getString("year"));
			b.setQuantity(rs.getInt("quantity"));
			b.setDescription(rs.getString("description"));
			b.setPid(rs.getInt("publisher_pid"));
			b.setAid(rs.getInt("author_aid"));
			Author a = aut.getAuthorByAid(b.getAid());
			Publisher p = pub.getPublisherByPid(b.getPid());
			b.setAname(a.getFname() + " " + a.getLname());
			b.setPname(p.getName());
			books.add(b);
		} 

	} 



}
