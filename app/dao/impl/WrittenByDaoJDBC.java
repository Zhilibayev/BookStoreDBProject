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
import models.Publisher;

public class WrittenByDaoJDBC {
	private static final String USER = "root";
	private static final String PASSWORD = "Eeijoqu4x";
	private static final String PORT = "3306";
	private static final String SERVER = "localhost";
	private static final String DATABASE = "dzhstore";
	private static final String DBMS = "mysql";

	Connection conn = null;

	public WrittenByDaoJDBC() {
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
	
	public boolean saveWrittenBy(String isbn, int aid) throws Exception {

		
		try {
			Statement stmt = conn.createStatement();
			//insert into written_by values ('987654', '1Hskdj2');
			stmt.executeUpdate("Insert into written_by (book_isbn, author_aid) values ( '"+isbn+ "' ," +aid+ ");");
			
			stmt.close();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "SQLException when saving an author ");
			return false;
		}
	} 
	
	public boolean saveWrittenByByQuery(String query) throws Exception {

		if (query == null) {
			return false;
		}
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(query);
			stmt.close();
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "SQLException when saving an author " + query);
			return false;
		}
	} 
	public void getRelations() {


		
		// probably case when title is null is needed.

		try {

			Statement stmt = conn.createStatement(); 

			ResultSet rs = stmt.executeQuery("select * from written_by;");

			System.out.println(rs.toString());
			while (rs.next()){
				System.out.println("Authors id " +rs.getInt("author_aid") + " ------ Books Id " + rs.getString("book_isbn"));
			}

			stmt.close();
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

	}
	
	
}
