package org.great.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
 * 服务端：
 * 	数据源：
 * 		1.读取客户端发来的数据--》Socket流中读取--》getInputStream() --> BufferedReader/DataInputStream
 * 		2.打印
 * 		3.将收到的消息发送给客户端
 * 	目的地：//发送给客户端
 * 		将收到的数据写入Socket流中--》Socket对象的getOutputStream()-->DataOutputStream/BufferedWriter/PrintWriter/PrintStream
 */
public class Serverice {

	public static void main(String[] args) throws IOException {
		//1
		ServerSocket serverSocket = new ServerSocket(12306);
		//2
		Socket socket = serverSocket.accept();//阻塞等待客户端请求链接
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
