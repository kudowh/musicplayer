package org.great.yield;

public class ThreadYield2 extends Thread {

	@Override
	public void run() {
		for(int i = 0; i < 200;i++){
			System.out.println(this.getName() + "i: " + i);
		}
	}
}
