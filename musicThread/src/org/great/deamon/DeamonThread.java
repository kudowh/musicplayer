package org.great.deamon;

public class DeamonThread implements Runnable {

	int count = 200;
	@Override
	public void run() {
		for(int i = 0; i < count; i++){
			System.out.println(Thread.currentThread().getName() + " i: " + i);
		}
	}

}
