package com.jspiders.multithreading.thread;

public class MyThread10 extends Thread {
@SuppressWarnings("deprecation")
@Override
public void run() {
	for (int i = 0; i < 5; i++) {
		System.out.println("hello from myThread10");
		if (i==3) {
			stop();
		}
	}
}
}
