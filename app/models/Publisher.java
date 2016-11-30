package models;

public class Publisher {


	private int pid;
	private String name;
	private String address; 
	private String phone;
	private String url;




	public Publisher (String name, String address, String phone, String url) {
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.url = url;

	}

	public Publisher() {

	}

	public Publisher (Publisher publish) {
		this.pid = publish.getPid();
		this.name = publish.getName();
		this.address = publish.getAddress();
		this.phone = publish.getPhone();
		this.url = publish.getUrl();

	}


	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public String toString(){
		return "The publisher information: " + pid + " | "+ name + " | "+ address +" | "+ phone +" | "+ url +" "; 
	}

}