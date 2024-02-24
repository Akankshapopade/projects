package com.jspiders.multithreading.thread;

import com.jspiders.multithreading.resource.MyResource;

public class MyThread7 extends Thread {
 private MyResource myResource;

public MyThread7(MyResource myResource) {
	this.myResource = myResource;
	
}
@Override
	public void run() {
	synchronized (myResource.resource2) {
		System.out.println("lock is applied on resource2 by thread7");
		synchronized (myResource.resource1) {
		  System.out.println("lock is applied on resource1 by thread7");
		}
	}
	}
 
}
