package org.great.join;

import java.util.Date;

public class ThreadStopDemo extends Thread{

	public void run(){
		System.out.println("Date start:" + new Date());

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("³ÌÐò is over");
		}
		System.out.println("Date end:" + new Date());
	}

	public static void main(String[] args) {
		ThreadStopDemo tsd = new ThreadStopDemo();
		tsd.start();
		try {
			Thread.sleep(2000);
			//tsd.stop();
			tsd.interrupt();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ThreadStopDemo tsd2 = new ThreadStopDemo();
		tsd2.start();
	}
}
