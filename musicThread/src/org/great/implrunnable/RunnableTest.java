package org.great.implrunnable;

public class RunnableTest {

	public static void main(String[] args) {
		RunnableDemo run = new RunnableDemo();
		Thread thread = new Thread(run);
		Thread thread2 = new Thread(run);
		thread.setPriority(1);
		thread2.setPriority(10);//���ȼ��ߣ�ֻ�ǻ�ȡCPUִ��Ȩ�ĸ��ʴ�һ��
		thread.start();
		//thread.start();���ܵ�������
		thread2.start();
	}
}
