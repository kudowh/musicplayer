package org.great.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * ����Socket���ʵ�ֶ�οͻ��˷�����Ϣ������˿��Զ�ζ�ȡ��Ϣ����ӡ�ڿ���̨�ϣ�
 * ���ҷ���˻��Ὣ�յ�����Ϣֱ�ӷ��ͷ��ظ��ͻ��˿���̨�ϣ�һ��һ���ģ��ͻ��˸��������ģ�
 * 
 * ������
 * 	�ͻ��˷�����Ϣ������˽�����Ϣ�����ҽ���Ϣ��ӡ�󣬰ѽ��յ�����Ϣ���͸��ͻ���
 * �ͻ��ˣ�
 * 	����Դ��
 * 		��Ϣ--����������--��Scanner/BufferedReader
 * 	Ŀ�ĵأ�
 * 		����Ϣд��socket����--��Socket�����getOutputStream()-->DataOutputStream/BufferedWriter/PrintWriter/PrintStream
 * 	
 * 	��ȡ����˷��ͻ�����Ϣ
 * 		��ȡ�ͻ��˷���������--��Socket���ж�ȡ--��getInputStream() --> BufferedReader/DataInputStream
 * 
 * ����ˣ�
 * 	����Դ��
 * 		1.��ȡ�ͻ��˷���������--��Socket���ж�ȡ--��getInputStream() --> BufferedReader/DataInputStream
 * 		2.��ӡ
 * 		3.���յ�����Ϣ���͸��ͻ���
 * 	Ŀ�ĵأ�//���͸��ͻ���
 * 		���յ�������д��Socket����--��Socket�����getOutputStream()-->DataOutputStream/BufferedWriter/PrintWriter/PrintStream
 */
public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//��������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//��ȡ�������������
		//Socket����
		Socket socket = new Socket("localhost", 12306);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		BufferedReader read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		while(true){
			bw.write(br.readLine());//����,�������з�����һ�н���
			bw.newLine();//���з�
			bw.flush();

			String msg = read.readLine();
			System.out.println("client->msg: " + msg);
			if(msg.equals("886")){
				break;
			}
		}
		
		bw.close();
		br.close();
		read.close();
		socket.close();
	}
}
