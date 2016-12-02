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

public class AuthorDaoJDBC{

	private static final String USER 		= 	"bfdeaf34174e28"		;
	private static final String PASSWORD 	= 	"ce5f54a0"	;
	private static final String PORT 		= 	"3306"		;
	private static final String SERVER 		= 	"us-cdbr-iron-east-04.cleardb.net"	;
	private static final String DATABASE 	= 	"heroku_0d7134efafff084";
	private static final String DBMS 		= 	"mysql"		;

	Connection conn = null;

	public AuthorDaoJDBC() {
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




	public boolean saveAuthor(Author author) throws Exception {

		if (author == null) {
			return false;
		}
		try {
			Statement stmt = conn.createStatement();

			stmt.executeUpdate("Insert into author(aid, fname, lname, url) values ( '" 
					+ author.getAid() + "', '" 
					+ author.getFname() + "', '" 
					+ author.getLname() + "', '" 
					+ author.getUrl() + "');");

			
			return true;

		} catch (SQLException e) {
			System.out.println(e.getMessage() + "SQLException when saving an author " + author.toString());
			return false;
		}
	} 
	public boolean saveAuthorByQuery(String query) throws Exception {

		if (query == null) {
			return false;
		}
		try {
			Statement stmt = conn.createStatement();

			stmt.executeUpdate(query);

			
			return true;

		} catch (SQLException e) {
			System.out.println(e.getMessage() + "SQLException when saving an author " + query);
			return false;
		}
	} 


	public Author getAuthorByAid(int aid) {
		List<Author> authors = new ArrayList<Author>();

		if (aid == 0) { // should correct this place
			return null;
		}

		try {
			

			Statement stmt = conn.createStatement(); 

			ResultSet rs = stmt.executeQuery(
					"select * from author where aid = '"+aid+"';");

			transferData(rs, authors);

			

			return authors.get(0);

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	public List<Author> getAuthorByFname(String fname) {


		List<Author> authors = new ArrayList<Author>();

		// probably case when title is null is needed.

		try {
			

			Statement stmt = conn.createStatement(); 

			ResultSet rs = stmt.executeQuery(
					"select * from author where fname like '%"+fname+"%';");

			transferData(rs, authors);

			

			return authors;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

	public List<Author> getAuthorByLname(String lname) {


		List<Author> authors = new ArrayList<Author>();

		// probably case when title is null is needed.

		try {
			Statement stmt = conn.createStatement(); 

			ResultSet rs = stmt.executeQuery(
					"select * from author where lname like '%"+lname+"%';");

			transferData(rs, authors);
			
			return authors;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}

	}




	public List<Author> getAllAuthors() {


		List<Author> authors = new ArrayList<Author>();

		// probably case when title is null is needed.

		try {
			

			Statement stmt = conn.createStatement(); 

			ResultSet rs = stmt.executeQuery("select * from author;");
			
			transferData(rs, authors);

			
			for (int i = 0; i < authors.size(); i++){
				System.out.println(authors.get(i));
			}
			return authors;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}

	}
	

	public void transferData(ResultSet rs, List<Author> authors) throws SQLException{

		while (rs.next()) {
			Author a = new Author();
			a.setAid(rs.getInt("aid"));
			a.setFname(rs.getString("fname"));
			a.setLname(rs.getString("lname"));
			a.setUrl(rs.getString("url"));
			authors.add(a);
		}

	}


}