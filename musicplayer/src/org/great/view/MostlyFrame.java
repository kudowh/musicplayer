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
	//��ʾ�����ʱ�������λ�ã���ÿ�ε��ʱ���λ���ȴ�Ϊ��Ա����
	Point point=new Point();//��ʾ (x,y) ����ռ��е�λ�õĵ㣬����������ָ����   
	public MostlyFrame() {
		setName("���ֲ�����");
//		setLayout(null);
		setSize(1000, 650);
		setLocationRelativeTo(null);
		MostlyPanel panel = new MostlyPanel();
		add(panel,BorderLayout.CENTER);
		setUndecorated(true);//���ر߿�
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		this.addMouseListener(new MouseAdapter() {//���������
			@Override					//���£�mousePressed ���ǵ����������걻����û��̧��
			public void mousePressed(MouseEvent e) {//��ʾ��갴��ȥ��λ��
				point.x=e.getX();//��ȡ�������λ��
				point.y=e.getY();
				System.out.println("��ȡ�������λ��"+"X:"+point.x+" Y:"+point.y);
			}
		});
		this.addMouseMotionListener(new MouseMotionAdapter() {
			@Override// �϶���mouseDragged ָ�Ĳ�������ڴ������ƶ�������������϶���
			public void mouseDragged(MouseEvent e) {
				Point p=Test.MostlyFrame.getLocation();//��ȡ��ǰ���ڵ�λ��
				
				//���ô��ڵ�λ��Ϊ�����ڵ�ǰ��λ��+������ƶ���λ��-�����ʱ��λ�ã�
				Test.MostlyFrame.setLocation((int)(p.getX()+e.getX()-point.x),(int)(p.getY()+e.getY()-point.y));
			}
		});//����ƶ�����
		
	}
}
