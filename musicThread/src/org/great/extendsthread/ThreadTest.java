package org.great.extendsthread;


public class ThreadTest {

	public static void main(String[] args) {
		ThreadDemo thread = new ThreadDemo();
		thread.start();//ִ����start()���߳��ǽ������״̬������ִ���ǻ�ȡCPUʱ��Ƭ��ʱ��Ż�ִ��
		ThreadDemo thread2 = new ThreadDemo();
		thread2.start();//ִ����start()���߳��ǽ������״̬������ִ���ǻ�ȡCPUʱ��Ƭ��ʱ��Ż�ִ��
	}
}
