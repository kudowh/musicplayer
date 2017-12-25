package org.great.yield;

public class ThreadYield3 extends Thread {

	@Override
	public void run() {
		for(int i = 0; i < 300;i++){
			System.out.println(this.getName() + "i: " + i);
		}
	}
}
