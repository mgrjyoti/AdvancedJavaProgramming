package com.jspiders.structeral;

public class StudentBuilder implements Game {

	 Student st=new Student();
	@Override
	public void football() {
	st.setId(1);
	st.setName("Jyoti Magar");
	st.setEmail("magarjyotis1304@gmail.com");
	st.setAddress("Pune");
	System.out.println(st.getName()+ " is a caption of football team.");	
	}

	@Override
	public void hockey() {
		st.setId(2);
		st.setName("Pratiksha Magar");
		st.setEmail("magarpratikshas2209@gmail.com");
		st.setAddress("Pune");
		System.out.println(st.getName()+ " is a caption of hockey team.");	

		
	}

}
