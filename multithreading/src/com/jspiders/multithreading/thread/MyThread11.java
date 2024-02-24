package com.jspiders.multithreading.thread;

public class MyThread11 extends Thread{
@Override
public void run() {
	String message="java is a programming language ";
	char[] array=message.toCharArray();
	for (int i = 0; i < array.length; i++) {
		System.out.print(array[i]);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
}
