package org.great.implrunnable;

public class RunnableTest {

	public static void main(String[] args) {
		RunnableDemo run = new RunnableDemo();
		Thread thread = new Thread(run);
		Thread thread2 = new Thread(run);
		thread.setPriority(1);
		thread2.setPriority(10);//优先级高，只是获取CPU执行权的概率大一点
		thread.start();
		//thread.start();不能调用两次
		thread2.start();
	}
}
