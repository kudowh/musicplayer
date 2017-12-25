package org.great.yield;

public class ThreadYield1 extends Thread {

	@Override
	public void run() {
		for(int i = 0; i < 100;i++){
			if(i ==2){
				this.yield();
			}
			System.out.println(this.getName() + "i: " + i);
		}
	}
}
