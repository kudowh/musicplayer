package org.great.view;


import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MostlyFrame extends JFrame {
	//表示点击的时候坐标的位置，把每次点击时候的位置先存为成员变量
	Point point=new Point();//表示 (x,y) 坐标空间中的位置的点，以整数精度指定。   
	public MostlyFrame() {
		setName("音乐播放器");
//		setLayout(null);
		setSize(1000, 650);
		setLocationRelativeTo(null);
		MostlyPanel panel = new MostlyPanel();
		add(panel,BorderLayout.CENTER);
		setUndecorated(true);//隐藏边框
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		this.addMouseListener(new MouseAdapter() {//鼠标点击监听
			@Override					//按下（mousePressed 不是点击，而是鼠标被按下没有抬起）
			public void mousePressed(MouseEvent e) {//表示鼠标按下去的位置
				point.x=e.getX();//获取鼠标点击的位置
				point.y=e.getY();
				System.out.println("获取鼠标点击的位置"+"X:"+point.x+" Y:"+point.y);
			}
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {
			@Override// 拖动（mouseDragged 指的不是鼠标在窗口中移动，而是用鼠标拖动）
			public void mouseDragged(MouseEvent e) {
				Point p=Test.MostlyFrame.getLocation();//获取当前窗口的位置
				
				//设置窗口的位置为：窗口当前的位置+（鼠标移动的位置-鼠标点击时的位置）
				Test.MostlyFrame.setLocation((int)(p.getX()+e.getX()-point.x),(int)(p.getY()+e.getY()-point.y));
			}
		});//鼠标移动监听
		
	}
}
