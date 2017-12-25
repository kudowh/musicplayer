package org.great.view;

import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MyButton extends JButton{
	public MyButton(ImageIcon icon) {
		setSize(icon.getImage().getWidth(null), icon.getImage().getHeight(null));
		setIcon(icon);
		setMargin(new Insets(0, 0, 0, 0));//���߿�����������ҿռ�����Ϊ0 
		setOpaque(true);
		setBorderPainted(false);//����ʾ�߿�
		setFocusPainted(false);//��ȥͼƬ���
		setIconTextGap(0);//����ǩ����ʾ���ı���ͼ��֮��ļ��������Ϊ0 
		setContentAreaFilled(false);//ȥ��Ĭ�ϵı������
	}
	public MyButton(String name) {//�ı���ť
		setText(name);
		setMargin(new Insets(0, 0, 0, 0));//���߿�����������ҿռ�����Ϊ0 
		setOpaque(true);
		setBorderPainted(false);//����ʾ�߿�
//		setFocusPainted(false);//��ȥͼƬ���
		setIconTextGap(0);//����ǩ����ʾ���ı���ͼ��֮��ļ��������Ϊ0 
		setContentAreaFilled(false);//ȥ��Ĭ�ϵı������
	}
	
}
