package org.great.extendsthread;

public class ThreadDemo extends Thread {

	//run()����ִ����֮���߳̽���
	int count = 100;
	@Override
	public void run() {
		for(int i = 0; i<count;i++){
			System.out.println(this.getName() + " i:" + i);
		}
	}
}
