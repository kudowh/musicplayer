package org.great.view;


import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.great.listener.MostlyListener;
import org.great.util.IconImage;

public class MostlyUpPanel extends JPanel{
	public static MyButton gb;
	private MyButton buser;
	private MyButton lg;
	private MyButton sz;
	public static MyButton zxh;
	public static MyButton yd;
	public static MyButton mymusic;
	private MyButton cz;
	public MostlyUpPanel() {
		this.setLayout(null);
		
		try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");//设置项目整体UI
        } catch (Throwable e) {
            e.printStackTrace();
        }
//		ImageIcon logo=new ImageIcon("img/top/dialog_logo.png");//logo图标
		lg = new MyButton(IconImage.dialog_logo);
		lg.addActionListener(new MostlyListener());
		lg.setBounds(0, 0, IconImage.dialog_logo.getIconWidth(), IconImage.dialog_logo.getIconHeight());
		add(lg);
		
//		ImageIcon user=new ImageIcon("img/top/user_name.png");//用户登录图标
		buser = new MyButton(IconImage.user_name);
		buser.addActionListener(new MostlyListener());
		buser.setBounds(20, 20,IconImage.user_name.getIconWidth() , IconImage.user_name.getIconHeight());
		add(buser);
		
//		ImageIcon czt=new ImageIcon("img/top/cz.png");//搜索查找音乐图标
		cz = new MyButton(IconImage.cz);
		cz.setOpaque(false);
		cz.setBounds(164, 34, 150, 20);
		cz.addActionListener(new MostlyListener());//为文本框添加监听
		add(cz);
		
		JTextField ss = new JTextField();//搜索框
		ss.setOpaque(false);
		ss.setBounds(100, 30, 150, 25);
		ss.addActionListener(new MostlyListener());//为文本框添加监听
		add(ss);
		
//		ImageIcon imu=new ImageIcon("img/top/bd.png");//我的音乐图标
		mymusic = new MyButton(IconImage.bd);
		mymusic.addActionListener(new MostlyListener());//添加本地音乐图标
		mymusic.setBounds(400,5,IconImage.bd.getIconWidth(),IconImage.bd.getIconHeight());
		add(mymusic);
		
//		ImageIcon ydt=new ImageIcon("img/top/yd.png");//云端音乐图标
		yd = new MyButton(IconImage.yd);
		yd.addActionListener(new MostlyListener());
		yd.setBounds(500,5,IconImage.yd.getIconWidth(),IconImage.yd.getIconHeight());
		add(yd);
		
//		ImageIcon szic=new ImageIcon("img/top/sz.png");//设置图标
		sz = new MyButton(IconImage.sz);
		sz.addActionListener(new MostlyListener());//为按钮添加监听
		sz.setBounds(933,2,20, 20);//设置按钮的大小
		add(sz);//把按钮添加到当前组件
		
//		ImageIcon zxhic=new ImageIcon("img/top/zxh.png");//最小化图标
		zxh = new MyButton(IconImage.zxh);
		zxh.addActionListener(new MostlyListener());//为按钮添加监听
		zxh.setBounds(956,2,20, 20);//设置按钮的大小
		add(zxh);//把按钮添加到当前组件
		
//		ImageIcon icon=new ImageIcon("img/top/x.png");//X图标
		gb = new MyButton(IconImage.x);//在按钮中添加关闭窗口图标
		gb.addActionListener(new MostlyListener());//为按钮添加监听
		gb.setBounds(977,3,20, 20);//设置按钮的大小
		add(gb);//把按钮添加到当前组件
//		setVisible(true);
		
	}
}