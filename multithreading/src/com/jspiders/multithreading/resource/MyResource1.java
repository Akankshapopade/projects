package com.jspiders.multithreading.resource;

public class MyResource1 {
public void resource() {
	System.out.println("lock is applied on resource by" +Thread.currentThread().getName());
}
}
