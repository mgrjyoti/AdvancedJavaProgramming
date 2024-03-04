package com.jspirders.desigenpattern.main;

import com.jspiders.desigenpattens.creational.Contact;
import com.jspiders.desigenpattens.creational.ContactBuilder;

public class ContactMain {

	public static void main(String[] args) {
		Contact contact=new ContactBuilder().firstName("Jyoti").lastName("Magar").email("magarjyotis1304@gmail.com").contact(8805489109l).getContact();
		System.out.println(contact);
	}
}
