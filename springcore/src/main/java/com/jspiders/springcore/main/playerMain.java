package com.jspiders.springcore.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcore.Beans.Player;

public class playerMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext= new ClassPathXmlApplicationContext("PlayerConfig.xml");
		
		Player player1=(Player) applicationContext.getBean("player1");
		System.out.println(player1);
		
		Player player2=(Player) applicationContext.getBean("player2");
		System.out.println(player2);
		
		((ClassPathXmlApplicationContext)applicationContext).close();
	}
}