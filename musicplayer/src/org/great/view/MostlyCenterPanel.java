package org.great.view;


import java.awt.CardLayout;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import org.great.listener.MostlyListener;

public class MostlyCenterPanel extends JPanel{
	public static CardLayout cardLayout;
	public static  YunPanel yunPanel;
	public static  LocalPanel localPanel;
	public MostlyCenterPanel() {
		cardLayout = new CardLayout();
		setLayout(cardLayout);
		
		localPanel = new LocalPanel();//���������б�
		
		yunPanel = new YunPanel();//�ƶ������б�
//		cardLayout.addLayoutComponent(localPanel, "localmusic");// ��ָ���������ӵ��˿�Ƭ���ֵ��ڲ����Ʊ�
//		cardLayout.addLayoutComponent(yunPanel, "yunmusic"); // ��ָ���������ӵ��˿�Ƭ���ֵ��ڲ����Ʊ�
		add(localPanel);
		add(yunPanel);
	}
}