package com.jspiders.desigenpattens.creational;

public class Contact {

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
	
	public Contact(String firstName, String lastName, String middelName, String email, String address, String gender,
			String dob, String work, String villege, long contact, long landline) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.middelName = middelName;
		this.email = email;
		this.address = address;
		this.gender = gender;
		this.dob = dob;
		this.work = work;
		this.villege = villege;
		this.contact = contact;
		this.landline = landline;
	}

	@Override
	public String toString() {
		return "Contact [firstName=" + firstName + ", lastName=" + lastName + ", middelName=" + middelName + ", email="
				+ email + ", address=" + address + ", gender=" + gender + ", dob=" + dob + ", work=" + work
				+ ", villege=" + villege + ", contact=" + contact + ", landline=" + landline + "]";
	}
	
}
