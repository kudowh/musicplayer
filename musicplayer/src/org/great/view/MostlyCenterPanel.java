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
		
		localPanel = new LocalPanel();//本地音乐列表
		
		yunPanel = new YunPanel();//云端音乐列表
//		cardLayout.addLayoutComponent(localPanel, "localmusic");// 将指定的组件添加到此卡片布局的内部名称表。
//		cardLayout.addLayoutComponent(yunPanel, "yunmusic"); // 将指定的组件添加到此卡片布局的内部名称表。
		add(localPanel);
		add(yunPanel);
	}
}