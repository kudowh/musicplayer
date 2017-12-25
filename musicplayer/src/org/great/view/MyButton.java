package org.great.view;

import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MyButton extends JButton{
	public MyButton(ImageIcon icon) {
		setSize(icon.getImage().getWidth(null), icon.getImage().getHeight(null));
		setIcon(icon);
		setMargin(new Insets(0, 0, 0, 0));//将边框外的上下左右空间设置为0 
		setOpaque(true);
		setBorderPainted(false);//不显示边框
		setFocusPainted(false);//除去图片外框
		setIconTextGap(0);//将标签中显示的文本和图标之间的间隔量设置为0 
		setContentAreaFilled(false);//去除默认的背景填充
	}
	public MyButton(String name) {//文本按钮
		setText(name);
		setMargin(new Insets(0, 0, 0, 0));//将边框外的上下左右空间设置为0 
		setOpaque(true);
		setBorderPainted(false);//不显示边框
//		setFocusPainted(false);//除去图片外框
		setIconTextGap(0);//将标签中显示的文本和图标之间的间隔量设置为0 
		setContentAreaFilled(false);//去除默认的背景填充
	}
	
}
