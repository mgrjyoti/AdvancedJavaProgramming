package com.jspiders.structral.main;

import com.jspiders.structeral.StudentBuilder;
import com.jspiders.structeral.TeacherBuilder;

public class BuilderMain {

	public static void main(String[] args) {
		StudentBuilder sb=new StudentBuilder();
		TeacherBuilder tb= new TeacherBuilder();
		sb.football();
		sb.hockey();
		tb.football();
		
	}
}
