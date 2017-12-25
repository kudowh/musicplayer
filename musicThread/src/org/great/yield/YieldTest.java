package org.great.yield;

public class YieldTest {

	public static void main(String[] args) {
		ThreadYield1 t = new ThreadYield1();
		ThreadYield2 t2 = new ThreadYield2();
		ThreadYield3 t3 = new ThreadYield3();
		
//		t.setPriority(1);
		t2.setPriority(10);
		t3.setPriority(1);
		t.start();
		t2.start();
		t3.start();
		
	}
}
