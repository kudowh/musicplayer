package org.great.extendsthread;


public class ThreadTest {

	public static void main(String[] args) {
		ThreadDemo thread = new ThreadDemo();
		thread.start();//执行完start()，线程是进入就绪状态，真正执行是获取CPU时间片的时候才会执行
		ThreadDemo thread2 = new ThreadDemo();
		thread2.start();//执行完start()，线程是进入就绪状态，真正执行是获取CPU时间片的时候才会执行
	}
}
