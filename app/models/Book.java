package models;

public class Book {
	
	private String isbn;
	private String year;
	private int quantity; 
	private int price;
	private int pid;
	private String title;
	private int aid;
	private String description;
	private String aname;
	private String pname;


	public Book (String ISBN, String year, int quantity, int price, String title, String version, String description, int pid, int aid, String aname, String pname) {
		this.isbn = ISBN;
		this.year = year;
		this.quantity = quantity;
		this.price = price;
		this.title = title;
		
		this.description = description;
		this.pid = pid;
		this.aid = aid;
		this.aname = aname;
		this.pname = pname;
	}

	public Book() {
		
	}

	public Book (Book book) {
		this.isbn = book.getIsbn();
		this.year = book.getYear();
		this.quantity = book.getQuantity();
		this.price = book.getPrice();
		this.title = book.getTitle();
		
		this.description = book.getDescription();
		this.pid= book.getPid();
		this.aid = book.getAid();
		this.aname = book.getAname();
		this.pname = book.getPname();
	}


	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public int getPid() {
		return pid;
	}
	
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String toString(){
		return "The book information: " + title + " | "+ isbn + " | "+ description +" | "+year+" | "+" | "+quantity+" | "+price+" | "+aid+" | "+aname+" | "+pname; 
	}
	}

