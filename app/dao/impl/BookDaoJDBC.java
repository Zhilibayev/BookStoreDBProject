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
import models.Publisher;

public class BookDaoJDBC{
//	private static final String USER 		= 	"bfdeaf34174e28"		;
//	private static final String PASSWORD 	= 	"ce5f54a0"	;
//	private static final String PORT 		= 	"3306"		;
//	private static final String SERVER 		= 	"us-cdbr-iron-east-04.cleardb.net"	;
//	private static final String DATABASE 	= 	"heroku_0d7134efafff084";
//	private static final String DBMS 		= 	"mysql"		;
	
//	private static final String USER = "root";
//	private static final String PASSWORD = "Eeijoqu4x";
//	private static final String PORT = "3306";
//	private static final String SERVER = "localhost";
//	private static final String DATABASE = "dzhstore";
//	private static final String DBMS = "mysql";

	private static final String USER 		= 	"s.zhilibayev"		;
	private static final String PASSWORD 	= 	"L4ZJZQQ"	;
	private static final String PORT 		= 	"80"		;
	private static final String SERVER 		= 	"46.101.171.158"	;
	private static final String DATABASE 	= 	"serik_zhilibayev_employee";
	private static final String DBMS 		= 	"mysql"		;
	
	Connection conn = null;

	public BookDaoJDBC() {
		try {
			conn = getConnection();
		} catch (Exception e) {
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




	public boolean saveBook(Book book) throws Exception {

		if (book == null) {
			return false;
		}
		try {
			Statement stmt = conn.createStatement();

			stmt.executeUpdate("Insert into book(isbn, title, year, quantity, price, description, publisher_pid, author_aid) values ( '" 
					+ book.getIsbn() + "', '" 
					+ book.getTitle() + "', '" 
					+ book.getYear() + "', '" 
					+ book.getQuantity() + "', '"
					+ book.getPrice() + "', '"
					+ book.getDescription() + "', '"
					+ book.getPid() + "', '"
					+ book.getAid() + "');");
			
			
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage() + "SQLException when saving a book " + book.toString());
			return false;
		}
	} 
	public boolean saveBookByQuery(String query) throws Exception {

		if (query == null) {
			return false;
		}
		try {
			
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);	
			
			return true;

		} catch (Exception e) {
			System.out.println(e.getMessage() + "SQLException when saving a book " + query);
			return false;
		}
	}


	public Book getBookByIsbn(String isbn) {
		List<Book> books = new ArrayList<Book>();

		if (isbn == null) { // should correct this place
			return null;
		}

		try {
			
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery(
					"select * from book where isbn = '"+isbn+"';");
			transferData(rs, books);
			
			return books.get(0);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}
	public List<Book> getBookByIsbnSBS(String isbn) {
		List<Book> books = new ArrayList<Book>();

		if (isbn == null) { // should correct this place
			return null;
		}

		try {
			
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery(
					"select * from book where isbn like '%"+isbn+"%';");
			transferData(rs, books);
			
			return books;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	public List<Book> getBookByTitle(String title) {
		List<Book> books = new ArrayList<Book>();
		// probably case when title is null is needed.
		try {
			
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery(
					"select * from book where title like '%"+title+"%';");
			transferData( rs, books);
			
			return books;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	public List<Book> getBookByAuthorName(String authorName) {
		List<Book> books = new ArrayList<Book>();
		// probably case when title is null is needed.
		try {	
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery(
					"select distinct * from book b join author a on a.aid = b.author_aid where "
							+ " a.fname like '%"+authorName+"%' "
							+ "or a.lname like '%"+authorName+"%' or CONCAT(a.fname, ' ', a.lname) like '%"+ authorName +"%';");
			transferData(rs, books);
			
			return books;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public List<Book> getBookByPublisher(String publisher) {
		List<Book> books = new ArrayList<Book>();
		// probably case when title is null is needed.
		try {
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery(
					"select distinct * from book b join publisher p on p.pid = b.publisher_pid where "
					+ " p.name like '%"+publisher+"%';");
			transferData(rs, books);
			
			return books;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}




	public List<Book> getAllBooks() {


		List<Book> books = new ArrayList<Book>();

		// probably case when title is null is needed.

		try {
			
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery("select * from book;");
			transferData(rs, books);
			
			
			for (int i = 0; i < books.size(); i++){
				System.out.println(books.get(i));
			}
			return books;

		} catch
		(Exception e) {
			System.out.println(e.getMessage());
			return null;
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

