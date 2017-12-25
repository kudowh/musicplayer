package org.great.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * ����ˣ�
 * 	����Դ��
 * 		1.��ȡ�ͻ��˷���������--��Socket���ж�ȡ--��getInputStream() --> BufferedReader/DataInputStream
 * 		2.��ӡ
 * 		3.���յ�����Ϣ���͸��ͻ���
 * 	Ŀ�ĵأ�//���͸��ͻ���
 * 		���յ�������д��Socket����--��Socket�����getOutputStream()-->DataOutputStream/BufferedWriter/PrintWriter/PrintStream
 */
public class Serverice {

	public static void main(String[] args) throws IOException {
		//1
		ServerSocket serverSocket = new ServerSocket(12306);
		//2
		Socket socket = serverSocket.accept();//�����ȴ��ͻ�����������
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintStream ps = new PrintStream(socket.getOutputStream());
		
		while(true){
			String msg = br.readLine();
			System.out.println("msg: " + msg);

			ps.println(msg);
			ps.flush();
			if(msg.equals("886")){
				break;
			}
		}
		
		ps.close();
		br.close();
		socket.close();
	}
}
