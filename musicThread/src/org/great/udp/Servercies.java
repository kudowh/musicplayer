package org.great.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Servercies {

	public static void main(String[] args) throws IOException {
		//1.����DatagramSocket
		DatagramSocket datagramSocket = new DatagramSocket(10086);
		
		//2.��ȡ���ݱ�
		byte[] buf = new byte[1024];
		DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
		datagramSocket.receive(datagramPacket);
		
		//3��������
		byte[] msg = datagramPacket.getData();
		System.out.println(new String(msg,0,msg.length));
		
		//4
		datagramSocket.close();
		
	}
}
