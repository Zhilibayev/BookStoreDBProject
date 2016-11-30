package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import dao.interfaces.CustomerDao;
import models.Cart;
import models.Customer;
import play.Logger;

public class CustomerDaoJDBC {
	
	private static final String USER = "root";
	private static final String PASSWORD = "Eeijoqu4x";
	private static final String PORT = "3306";
	private static final String SERVER = "localhost";
	private static final String DATABASE = "dzhstore";
	private static final String DBMS = "mysql";
	
	Connection conn = null;
	
	public CustomerDaoJDBC() {
		try {
			conn = getConnection();
		} catch (SQLException e) {
			Logger.info("SQLException during database connection");
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
	
	
	
	
	public boolean saveCustomer(Customer customer) throws Exception {
		// TODO Auto-generated method stub
		if (customer == null) {
			return false;
		}
    	try {
			Statement stmt = conn.createStatement();
			
			stmt.executeUpdate("Insert into customer(username, address, email, phone, password) values ( '" 
								+ customer.getUsername() 	+ "', '" 
								+ customer.getAddress()		+ "', '"  
								+ customer.getEmail() 		+ "', '"  
								+ customer.getPhone() 		+ "', '"
								+ customer.getPassword()	+ "');");
			System.out.println("OK It was saved");
			stmt.close();
			return true;
    	} catch (SQLException e) {
			Logger.info(e.getMessage() + "SQLException when saving a cat " + customer.toString());
			return false;
		}
	}	
	
	
	public Customer getCustomerById(int id) {
		List<Customer> customers = new ArrayList<Customer>();
		if (id == 0) { // should correct this place
			return null;
		}
		try {
			//Customer customer = new Customer();
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery(
	        		"select * from customer where cid = '" + id + "';");
			transferData(rs, customers);
			stmt.close();
			return customers.get(0);
    	} catch (SQLException e) {
			Logger.info(e.getMessage());
			return null;
		}
		
	}

	
	public Customer getCustomerByEmail(String email) {
		
		List<Customer> customers = new ArrayList<Customer>();
		if (email == null) { // should correct this place
			return null;
		}
		try {
			
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery("select * from customer where email = '" + email + "';");
			Customer customer = transferData(rs, customers);
			stmt.close();
			
			return customer;
    	} catch (SQLException e) {
			Logger.info(e.getMessage());
			return null;
    	}
	
	}

	
	public List<Customer> getAllCustomers() {
		List<Customer> customers = new ArrayList<Customer>();
		try {
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery("select * from customer;");
			transferData(rs, customers);
			stmt.close();
			return customers;
    	} catch (SQLException e) {
			Logger.info(e.getMessage());
			return null;
    	}
	}
	
	public boolean updateCustomerName(int cid, String name) { 
		
		if (cid == 0) { 
			return false; 
		}
		try {
			Statement stmt = conn.createStatement(); 
			stmt.executeUpdate("Update customer set username = '"+name+"' where cid = '"+cid+"'"); 
			stmt.close(); 
			return true; 
		} catch (SQLException e) { 
			System.out.println(e.getMessage() + "SQLException when updating the name for customer cid = '"+cid+"'"); 
			return false; 
		} 
	 } 
	
	public boolean updateCustomerAddress(int cid, String address) { 
		
		if (cid == 0) { 
			return false; 
		}
		try {
			Statement stmt = conn.createStatement(); 
			stmt.executeUpdate("Update customer set address = '"+address+"' where cid = '"+cid+"'"); 
			stmt.close(); 
			return true; 
		} catch (SQLException e) { 
			System.out.println(e.getMessage() + "SQLException when updating the address for customer cid = '"+cid+"'"); 
			return false; 
		} 
	 } 
	
	public boolean updateCustomerEmail(int cid, String email) { 
		
		if (cid == 0) { 
			return false; 
		}
		try {
			Statement stmt = conn.createStatement(); 
			stmt.executeUpdate("Update customer set email = '"+email+"' where cid = '"+cid+"'"); 
			stmt.close(); 
			return true; 
		} catch (SQLException e) { 
			System.out.println(e.getMessage() + "SQLException when updating the email for customer cid = '"+cid+"'"); 
			return false; 
		} 
	 } 
	
	public boolean updateCustomerPhone(int cid, String phone) { 
		
		if (cid == 0) { 
			return false; 
		}
		try {
			Statement stmt = conn.createStatement(); 
			stmt.executeUpdate("Update customer set phone = '"+phone+"' where cid = '"+cid+"'"); 
			stmt.close(); 
			return true; 
		} catch (SQLException e) { 
			System.out.println(e.getMessage() + "SQLException when updating the phone for customer cid = '"+cid+"'"); 
			return false; 
		} 
	 } 
	
	public boolean updateCustomerPassword(int cid, String password) { 
		
		if (cid == 0) { 
			return false; 
		}
		try {
			Statement stmt = conn.createStatement(); 
			stmt.executeUpdate("Update customer set password = '"+password+"' where cid = '"+cid+"'"); 
			stmt.close(); 
			return true; 
		} catch (SQLException e) { 
			System.out.println(e.getMessage() + "SQLException when updating the password for customer cid = '"+cid+"'"); 
			return false; 
		} 
	 } 
	
	
	
	
	public Customer transferData(ResultSet rs, List<Customer> customers) throws SQLException{
		Customer cc = null;
        while (rs.next()) {
        	Customer c = new Customer();
        	c.setId(rs.getInt("cid"));
            c.setAddress(rs.getString("address"));
            c.setPhone(rs.getString("phone"));
            c.setUsername(rs.getString("username"));
        	c.setEmail(rs.getString("email"));
            c.setPassword(rs.getString("password"));
            customers.add(c);
            cc = c;
            System.out.println(customers.size());
        }
        return cc;
	}
	
	
	
	
	
	
}
