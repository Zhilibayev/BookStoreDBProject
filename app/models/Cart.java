package models;

import dao.impl.BookDaoJDBC;
import dao.impl.CustomerDaoJDBC;

public class Cart { 


		private Book book; 
		private Customer customer; 


		public Cart (String book, int customer) { 
			this.book = new BookDaoJDBC().getBookByIsbn(book); 
			this.customer = new CustomerDaoJDBC().getCustomerById(customer); 
		} 

		public Cart() { 

		} 

		public Cart (Cart cart) { 
			this.book = cart.getBook(); 
			this.customer = cart.getCustomer(); 
		} 


		public Book getBook() { 
			return book; 
		} 
		
		public void setBook(Book book) { 
			this.book = book; 
		}
		
		public Customer getCustomer() { 
			return customer; 
		}
		
		public void setCustomer(Customer customer) { 
			this.customer = customer; 
		} 

		public String toString(){ 
			return "The cart information: " + book + " | "+ customer; 
		} 

}

