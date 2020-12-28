package models;

public class Author {
	private int aid;
	private String fname;
	private String lname; 
	private String url;




	public Author (String fname, String lname, String url) {
		this.fname = fname;
		this.lname = lname;
		this.url = url;

	}

	public Author() {

	}

	public Author (Author auth) {
		this.aid = auth.getAid();
		this.fname = auth.getFname();
		this.lname = auth.getLname();
		this.url = auth.getUrl();
	}


	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public String toString(){
		return "The author information: " + aid + " | "+ fname + " | "+ lname +" | "+ url ; 
	}
}
