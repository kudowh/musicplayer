package org.great.extendsthread;

public class ThreadDemo extends Thread {

	//run()方法执行完之后线程结束
	int count = 100;
	@Override
	public void run() {
		for(int i = 0; i<count;i++){
			System.out.println(this.getName() + " i:" + i);
		}
	}
}
