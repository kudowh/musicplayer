package org.great.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * 利用Socket编程实现多次客户端发送消息，服务端可以多次读取消息并打印在控制台上，
 * 并且服务端还会将收到的消息直接发送返回给客户端控制台上（一对一单聊，客户端跟服务器聊）
 * 
 * 分析：
 * 	客户端发送消息，服务端接收消息，并且将消息打印后，把接收到的消息发送给客户端
 * 客户端：
 * 	数据源：
 * 		消息--》键盘输入--》Scanner/BufferedReader
 * 	目的地：
 * 		将消息写入socket流中--》Socket对象的getOutputStream()-->DataOutputStream/BufferedWriter/PrintWriter/PrintStream
 * 	
 * 	读取服务端发送回来消息
 * 		读取客户端发来的数据--》Socket流中读取--》getInputStream() --> BufferedReader/DataInputStream
 * 
 * 服务端：
 * 	数据源：
 * 		1.读取客户端发来的数据--》Socket流中读取--》getInputStream() --> BufferedReader/DataInputStream
 * 		2.打印
 * 		3.将收到的消息发送给客户端
 * 	目的地：//发送给客户端
 * 		将收到的数据写入Socket流中--》Socket对象的getOutputStream()-->DataOutputStream/BufferedWriter/PrintWriter/PrintStream
 */
public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException {
		//键盘输入
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//读取键盘输入的数据
		//Socket对象
		Socket socket = new Socket("localhost", 12306);
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		BufferedReader read = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		while(true){
			bw.write(br.readLine());//阻塞,读到换行符才算一行结束
			bw.newLine();//换行符
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
