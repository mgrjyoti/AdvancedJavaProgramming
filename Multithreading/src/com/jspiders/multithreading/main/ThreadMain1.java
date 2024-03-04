package com.jspiders.multithreading.main;

import com.jspiders.multithreading.thread.Thread1;

public class ThreadMain1 {

	public static void main(String[] args) {
		Thread1 thread1=new Thread1();
		thread1.start();
	}
}
