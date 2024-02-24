package com.jspiders.multithreading.thread;

import com.jspiders.multithreading.resource.MyResource;

public class MyThread6 extends Thread {
private MyResource myResource;	
public MyThread6(MyResource resource) {
		this.myResource = resource;
	}
@Override
	public void run() {
	synchronized (myResource.resource1) {
		System.out.println("lock is applied on resource1 by thread6");
		synchronized (myResource.resource2) {
			System.out.println("lock is applied on resource2 by thread6");
			
		}
	}
	}


}
