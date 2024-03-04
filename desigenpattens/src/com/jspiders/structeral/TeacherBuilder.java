package com.jspiders.structeral;

public class TeacherBuilder implements Game{

	Teacher  st=new Teacher();
	@Override
	public void football() {
		st.setId(1);
		st.setName("S K Jadhav");
		st.setEmail("skjadhav@gmail.com");
		st.setContact(9876543210l);
		System.out.println(st.getName() + " is a coche of foot ball team.");
		
	}

	@Override
	public void hockey() {
		st.setId(2);
		st.setName("B B Jadhav");
		st.setEmail("bbjadhav@gmail.com");
		st.setContact(9786543210l);
		System.out.println(st.getName() + " is a coche of hockey team.");
	}

}
