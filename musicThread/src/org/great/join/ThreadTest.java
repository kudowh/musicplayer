package org.great.join;

public class ThreadTest {

	public static void main(String[] args) {
		ThreadJoinDemo demo = new ThreadJoinDemo();
		Thread thread = new Thread(demo);
		//thread.setName("Thread1");
		Thread thread2 = new Thread(demo);
		Thread thread3 = new Thread(demo);
		thread.start();
		//thread.join();//�����߳���ֹ�� 
		//thread.join(1);//�����̶߳�����֮��Ȼ�Ͳ��ȴ�
//		try {
//			thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			//				e.printStackTrace();
//			System.out.println("interupt");
//		}
		try {
			Thread.sleep(1000);
			thread.interrupt();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("jkhk");
		thread2.start();
		thread3.start();
	}
}
