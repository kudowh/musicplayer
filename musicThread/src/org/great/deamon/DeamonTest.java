package org.great.deamon;

public class DeamonTest {

	public static void main(String[] args) {
		DeamonThread d = new DeamonThread();
		Thread th1 = new Thread(d);
//		Thread th2 = new Thread(d);
		th1.setDaemon(true);//要求必须在start()方法之前调用
		th1.start();
//		th2.start();
		for(int i = 0; i < 2;i++){
			System.out.println(Thread.currentThread().getName() + " i: " + i);
		}
	}
}
