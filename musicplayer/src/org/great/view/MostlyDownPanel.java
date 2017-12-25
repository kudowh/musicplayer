package org.great.view;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;

import org.great.listener.MostlyListener;
import org.great.util.IconImage;

public class MostlyDownPanel extends JPanel{
	public static MyButton ks;//��ʼ��ť
	public static MyButton syq;//��һ����ť
	public static MyButton xyq;//��һ����ť
	public static JSlider loading;//���ֲ��Ž�����-������
	public static JLabel sname;//������Label
	public static JLabel nowtime;//��ǰ������ʱ��JLable
	public static JLabel alltime;//��ǰ���ŵ�ʱ��λ��JLable
	public static MyButton likes;//ϲ�����ղ�
	public static MyButton loads;//���ر������������ټ�һ��ͼ�꣬��Ϊ���غõ���ʾ��
	public static MyButton mutes;//�Ƿ���
	public static MyButton delete;//ɾ������
	public static MyButton types;//��������ģʽ
	public static int model=1;//�������ֲ�������
	public static  JSlider volume;//����������-������
	public MostlyDownPanel() {
		this.setLayout(null);
		
//		ImageIcon icon=new ImageIcon("img/lower/ks.png");//��ʼ����ͼ��
		ks = new MyButton(IconImage.ks);//�ڰ�ť����ӹرմ���ͼ��
		ks.addActionListener(new MostlyListener());//Ϊ��ť��Ӽ���
		ks.setBounds(73, 10, IconImage.ks.getIconWidth(), IconImage.ks.getIconHeight());//���ð�ť��λ�úʹ�С
		add(ks);//�Ѱ�ť��ӵ���ǰ���
		
//		ImageIcon qh1=new ImageIcon("img/lower/syq.png");//��һ��ͼ��
		syq = new MyButton(IconImage.syq);
		syq.addActionListener(new MostlyListener());//Ϊ��ť��Ӽ���
		syq.setBounds(30, 15, IconImage.syq.getIconWidth(), IconImage.syq.getIconHeight());//���ð�ť��λ�úʹ�С
		add(syq);//�Ѱ�ť��ӵ���ǰ���
		
//		ImageIcon qh2=new ImageIcon("img/lower/xyq.png");//��һ��ͼ��
		xyq = new MyButton(IconImage.xyq);
		xyq.addActionListener(new MostlyListener());//Ϊ��ť��Ӽ���
		xyq.setBounds(130, 15, IconImage.xyq.getIconWidth(), IconImage.xyq.getIconHeight());//���ð�ť��λ�úʹ�С
		add(xyq);//�Ѱ�ť��ӵ���ǰ���
		
		loading = new JSlider();//�������ֽ�����
		loading.setPreferredSize(new Dimension(500,5)); //���ý�������ѡ��С  
		loading.setValue(0);
		loading.setBounds(220, 40, 450, 5);
		loading.addMouseListener(new MostlyListener());
		loading.addAncestorListener(new MostlyListener());//Ϊ��������Ӽ���
		add(loading);//�ѽ�������ӵ���ǰ���
		
		volume = new JSlider();//��������������
		volume.setBounds(835, 30,70, 5);
		volume.setMaximum(5);//���ֵ��Ϊ5��0-5
		volume.addMouseListener(new MostlyListener());//Ϊ��������Ӽ���
		volume.addAncestorListener(new MostlyListener());//Ϊ  ����  �Ľ�������Ӽ���
		add(volume);//�ѽ�������ӵ���ǰ���
		
		sname = new JLabel();//��������ʾ
		sname.setFont(new Font("����", Font.PLAIN, 15));
		sname.setBounds(230, 15, 200, 20);
		sname.addAncestorListener(new MostlyListener());//��Ӽ���
//		sname.setText("Ѧ֮ǫ-��ʿ");
		add(sname);
		
		nowtime = new JLabel();
		nowtime.setFont(new Font("����", Font.PLAIN, 10));
		nowtime.setBounds(605, 20, 30, 20);
		nowtime.setText("00:00");
		add(nowtime);
		
		alltime = new JLabel();
		alltime.setFont(new Font("����", Font.PLAIN, 10));
		alltime.setBounds(630, 20, 40, 20);
		alltime.setText("/00:00");
		add(alltime);
		
//		ImageIcon type=new ImageIcon("img/lower/type1.png");//����ģʽͼ��
		types = new MyButton(IconImage.type1);
		types.setBounds(690, 23, IconImage.type1.getIconWidth(),IconImage.type1.getIconHeight());
		types.addActionListener(new MostlyListener());
		add(types);
		
//		ImageIcon like=new ImageIcon("img/lower/like.png");//��ϲ��-ͼ��
		likes = new MyButton(IconImage.like);//��ϲ��-��ť
		likes.setBounds(720, 23, IconImage.like.getIconWidth(),IconImage.like.getIconHeight());
		likes.addActionListener(new MostlyListener());
		add(likes);
		
//		ImageIcon load=new ImageIcon("img/lower/load.png");//����ͼ��
		loads = new MyButton(IconImage.load);
		loads.setBounds(750, 23, IconImage.load.getIconWidth(),IconImage.load.getIconHeight());
		loads.addActionListener(new MostlyListener());
		add(loads);
		
//		ImageIcon lyric=new ImageIcon("img/lower/lyric.png");//���ͼ��
		MyButton lyrics = new MyButton(IconImage.lyric);
		lyrics.setBounds(780, 23, IconImage.lyric.getIconWidth(),IconImage.lyric.getIconHeight());
		lyrics.addActionListener(new MostlyListener());
		add(lyrics);
		
//		ImageIcon mute=new ImageIcon("img/lower/nomute.png");//����ͼ��
		mutes = new MyButton(IconImage.nomute);
		mutes.setBounds(810, 23, IconImage.nomute.getIconWidth(),IconImage.nomute.getIconHeight());
		mutes.addActionListener(new MostlyListener());
		add(mutes);
		
		
		
//		ImageIcon dd=new ImageIcon("img/lower/delete.png");//ɾ������ͼ��
		delete = new MyButton(IconImage.delete);
		delete.setBounds(920, 23, IconImage.delete.getIconWidth(),IconImage.delete.getIconHeight());
		delete.addActionListener(new MostlyListener());
		add(delete);
	}
}