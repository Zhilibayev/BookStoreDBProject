package models;

import com.google.gson.JsonObject;

public class Customer {
	
	private int id; 
	private String username;
	private String address;
	private String email;
	private String phone;
	private String password;
	
	
	
	public Customer(String username, String address, String email, String phone, String password) {
		this.username = username;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.address = address;	
	}
	
	public Customer(){
	
	}
	
	public Customer(Customer cEnt) {
		this.id = cEnt.getId();
		this.username = cEnt.getUsername();
		this.email = cEnt.getEmail();
		this.password = cEnt.getPassword();
		this.address = cEnt.getAddress();
		this.phone = cEnt.getPhone();
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String toString(){
		return "The UserInformation: " + username  + " | " + id + " | " + address + " | <" + email + "> | " + phone + " | " + password;	
	}
	public JsonObject convertToJson(){
		JsonObject json = new JsonObject();
		json.addProperty("id", id);
		json.addProperty("username", username);
		json.addProperty("address", address);
		json.addProperty("email", email);
		json.addProperty("phone", phone);
		json.addProperty("password", password);
		return json;
	}

}
