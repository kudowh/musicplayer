package org.great.implrunnable;

public class RunnableDemo implements Runnable {

	int count = 100;
	@Override
	public void run() {
		
		for(int i = 0; i<count;i++){
			System.out.println( Thread.currentThread().getName() +"i:" + i);
		}
	}

}
