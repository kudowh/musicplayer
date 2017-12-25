package org.great.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {

	public static void main(String[] args) throws IOException {
		//1.创建DatagramSocket
		DatagramSocket datagramSocket = new DatagramSocket();
		
		//2.打包数据
		//2.1构造数据
		byte[] buf = "Hello".getBytes();
		InetAddress address = InetAddress.getLocalHost();
		int port = 10086;
		DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length, address, port);
		
		//3发送
		datagramSocket.send(datagramPacket);
		
		datagramSocket.close();
	}
}
