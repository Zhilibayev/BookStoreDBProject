import dao.impl.AuthorDaoJDBC;
import dao.impl.CartDaoJDBC;
import dao.impl.CustomerDaoJDBC;
import models.Cart;
import models.Customer;

public class tester {

	public static void main(String[] args) throws Exception {
		//AuthorDaoJDBC au = new AuthorDaoJDBC();
		//CustomerDaoJDBC co = new CustomerDaoJDBC();
		//Cart c = new Cart();
		CartDaoJDBC c = new CartDaoJDBC();
		//co.saveCustomer(new Customer("12", "12", "12", "12","12"));
		c.saveCart(new Cart("abc1113",2));
		System.out.println(c.getBooksByCustomerId(2).size());

	}

}
