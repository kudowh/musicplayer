package org.great.join;

public class ThreadJoinDemo implements Runnable {

	int count = 100;
	@Override
	public void run() {
		//Thread.currentThread().interrupt();
		try {
			Thread.currentThread().sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("interrupt");
		}
		for(int i = 0; i < count; i++){
			System.out.println(Thread.currentThread().getName() + " i: " + i);
		}
	}

}
