package egen.model;

import java.sql.Date;

public class Reservation {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private double phoneNumber;
	private int Total;
	private Date date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(double phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getTotal() {
		return Total;
	}
	public void setTotal(int total) {
		Total = total;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date2) {
		this.date = date2;
	}
	
	
	

}
