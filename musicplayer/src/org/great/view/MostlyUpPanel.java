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
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");//������Ŀ����UI
        } catch (Throwable e) {
            e.printStackTrace();
        }
//		ImageIcon logo=new ImageIcon("img/top/dialog_logo.png");//logoͼ��
		lg = new MyButton(IconImage.dialog_logo);
		lg.addActionListener(new MostlyListener());
		lg.setBounds(0, 0, IconImage.dialog_logo.getIconWidth(), IconImage.dialog_logo.getIconHeight());
		add(lg);
		
//		ImageIcon user=new ImageIcon("img/top/user_name.png");//�û���¼ͼ��
		buser = new MyButton(IconImage.user_name);
		buser.addActionListener(new MostlyListener());
		buser.setBounds(20, 20,IconImage.user_name.getIconWidth() , IconImage.user_name.getIconHeight());
		add(buser);
		
//		ImageIcon czt=new ImageIcon("img/top/cz.png");//������������ͼ��
		cz = new MyButton(IconImage.cz);
		cz.setOpaque(false);
		cz.setBounds(164, 34, 150, 20);
		cz.addActionListener(new MostlyListener());//Ϊ�ı�����Ӽ���
		add(cz);
		
		JTextField ss = new JTextField();//������
		ss.setOpaque(false);
		ss.setBounds(100, 30, 150, 25);
		ss.addActionListener(new MostlyListener());//Ϊ�ı�����Ӽ���
		add(ss);
		
//		ImageIcon imu=new ImageIcon("img/top/bd.png");//�ҵ�����ͼ��
		mymusic = new MyButton(IconImage.bd);
		mymusic.addActionListener(new MostlyListener());//��ӱ�������ͼ��
		mymusic.setBounds(400,5,IconImage.bd.getIconWidth(),IconImage.bd.getIconHeight());
		add(mymusic);
		
//		ImageIcon ydt=new ImageIcon("img/top/yd.png");//�ƶ�����ͼ��
		yd = new MyButton(IconImage.yd);
		yd.addActionListener(new MostlyListener());
		yd.setBounds(500,5,IconImage.yd.getIconWidth(),IconImage.yd.getIconHeight());
		add(yd);
		
//		ImageIcon szic=new ImageIcon("img/top/sz.png");//����ͼ��
		sz = new MyButton(IconImage.sz);
		sz.addActionListener(new MostlyListener());//Ϊ��ť��Ӽ���
		sz.setBounds(933,2,20, 20);//���ð�ť�Ĵ�С
		add(sz);//�Ѱ�ť��ӵ���ǰ���
		
//		ImageIcon zxhic=new ImageIcon("img/top/zxh.png");//��С��ͼ��
		zxh = new MyButton(IconImage.zxh);
		zxh.addActionListener(new MostlyListener());//Ϊ��ť��Ӽ���
		zxh.setBounds(956,2,20, 20);//���ð�ť�Ĵ�С
		add(zxh);//�Ѱ�ť��ӵ���ǰ���
		
//		ImageIcon icon=new ImageIcon("img/top/x.png");//Xͼ��
		gb = new MyButton(IconImage.x);//�ڰ�ť����ӹرմ���ͼ��
		gb.addActionListener(new MostlyListener());//Ϊ��ť��Ӽ���
		gb.setBounds(977,3,20, 20);//���ð�ť�Ĵ�С
		add(gb);//�Ѱ�ť��ӵ���ǰ���
//		setVisible(true);
		
	}
}