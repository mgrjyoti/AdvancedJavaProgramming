package com.jspiders.desigenpattens.creational;

public class ContactBuilder {

	private String firstName;
	private String lastName;
	private String middelName;
	private String email;
	private String address;
	private String gender;
	private String dob;
	private String work;
	private String villege;
	private long contact;
	private long landline;
	
	
	public ContactBuilder firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}
	public ContactBuilder lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	
	public ContactBuilder middelName(String middelName) {
		this.middelName = middelName;
		return this;
	}
	
	public ContactBuilder email(String email) {
		this.email = email;
		return this;
	}
	public String getAddress() {
		return address;
	}
	public ContactBuilder address(String address) {
		this.address = address;
		return this;
	}
	public ContactBuilder gender(String gender) {
		this.gender = gender;
		return this;
	}
	public ContactBuilder dob(String dob) {
		this.dob = dob;
		return this;
	}

	public ContactBuilder work(String work) {
		this.work = work;
		return this;
	}
	public String getVillege() {
		return villege;
	}
	public ContactBuilder villege(String villege) {
		this.villege = villege;
		return this;
	}

	public ContactBuilder contact(long contact) {
		this.contact = contact;
		return this;
	}
	
	public ContactBuilder landline(long landline) {
		this.landline = landline;
		return this;
	}
	
	public Contact getContact() {
		return new Contact(firstName, lastName, middelName, email, address, gender, dob, work, villege, contact, landline);				
	}
	
}
