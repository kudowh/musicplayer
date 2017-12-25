package org.great.demo;

public class Demo {

	
	public static void main(String[] args) {
		String str = "aaa";
		System.out.println(str);
		
		Deemo d = new Deemo();
		d.show();
		d.method();
	}
}

class Deemo{
	int a = 10;
	public void show(){
		System.out.println("Hello");
	}
	public void method(){
		System.out.println("method");
	}
}
