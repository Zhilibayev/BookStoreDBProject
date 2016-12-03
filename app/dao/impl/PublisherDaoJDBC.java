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

public class PublisherDaoJDBC{

//	private static final String USER = "root";
//	private static final String PASSWORD = "Eeijoqu4x";
//	private static final String PORT = "3306";
//	private static final String SERVER = "localhost";
//	private static final String DATABASE = "dzhstore";
//	private static final String DBMS = "mysql";
	
//	private static final String USER 		= 	"bfdeaf34174e28"		;
//	private static final String PASSWORD 	= 	"ce5f54a0"	;
//	private static final String PORT 		= 	"3306"		;
//	private static final String SERVER 		= 	"us-cdbr-iron-east-04.cleardb.net"	;
//	private static final String DATABASE 	= 	"heroku_0d7134efafff084";
//	private static final String DBMS 		= 	"mysql"		;
	private static final String USER 		= 	"s.zhilibayev"		;
	private static final String PASSWORD 	= 	"L4ZJZQQ"	;
	private static final String PORT 		= 	"80"		;
	private static final String SERVER 		= 	"46.101.171.158"	;
	private static final String DATABASE 	= 	"serik_zhilibayev_employee";
	private static final String DBMS 		= 	"mysql"		;

	Connection conn = null;

	public PublisherDaoJDBC() {
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

	public boolean savePublisher(Publisher publisher) throws Exception {

		if (publisher == null) {
			return false;
		}
		try {
			Statement stmt = conn.createStatement();

			stmt.executeUpdate("Insert into publisher(pid, name, address, phone, url) values ( '" 
					+ publisher.getPid() + "', '" 
					+ publisher.getName() + "', '" 
					+ publisher.getAddress() + "', '" 
					+ publisher.getPhone() + "', '"
					+ publisher.getUrl() + "');");

			
			return true;

		} catch (SQLException e) {
			System.out.println(e.getMessage() + "SQLException when saving a publisher " + publisher.toString());
			return false;
		}
	} 
	
	public boolean savePublisherByQuery(String query) throws Exception {

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

	public Publisher getPublisherByPid(int pid) {
		List<Publisher> publishers = new ArrayList<Publisher>();
		if (pid == 0) { 
			return null;
		}
		try {
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery("select * from publisher where pid = '"+pid+"';");
			transferData(rs, publishers);
			
			return publishers.get(0);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public List<Publisher> getPublisherByName(String name) {
		List<Publisher> publishers = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery(
					"select * from publisher where name like '%"+name+"%';");
			transferData(rs, publishers);
			
			return publishers;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public List<Publisher> getAllPublishers() {
		List<Publisher> publishers = new ArrayList<Publisher>();
		try {
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery("select * from publisher;");
			transferData(rs, publishers);
			
			for (int i = 0; i < publishers.size(); i++){
				System.out.println(publishers.get(i));
			}
			return publishers;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public void transferData(ResultSet rs, List<Publisher> publishers) throws SQLException{
		while (rs.next()) {
			Publisher p = new Publisher();
			p.setPid(rs.getInt("pid"));
			p.setName(rs.getString("name"));
			p.setAddress(rs.getString("address"));
			p.setPhone(rs.getString("phone"));
			p.setUrl(rs.getString("url"));
			publishers.add(p);
		}
	}

}