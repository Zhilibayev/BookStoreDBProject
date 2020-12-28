package dao.interfaces;

import java.util.List;
import models.Customer;


public interface CustomerDao {
	
	public boolean saveCustomer(Customer customer) throws Exception;
	
	public Customer getCustomerById(int id);
	
	public Customer getCustomerByEmail(String email);

	public List<Customer> getAllCustomers();	
}
