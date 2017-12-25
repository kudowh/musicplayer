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
	public static MyButton ks;//开始按钮
	public static MyButton syq;//上一曲按钮
	public static MyButton xyq;//下一曲按钮
	public static JSlider loading;//音乐播放进度条-滑动块
	public static JLabel sname;//歌曲名Label
	public static JLabel nowtime;//当前歌曲总时长JLable
	public static JLabel alltime;//当前播放的时间位置JLable
	public static MyButton likes;//喜欢、收藏
	public static MyButton loads;//下载本歌曲，后面再加一个图标，若为下载好的显示打钩
	public static MyButton mutes;//是否静音
	public static MyButton delete;//删除歌曲
	public static MyButton types;//歌曲播放模式
	public static int model=1;//传入音乐播放类型
	public static  JSlider volume;//音量进度条-滑动块
	public MostlyDownPanel() {
		this.setLayout(null);
		
//		ImageIcon icon=new ImageIcon("img/lower/ks.png");//开始播放图标
		ks = new MyButton(IconImage.ks);//在按钮中添加关闭窗口图标
		ks.addActionListener(new MostlyListener());//为按钮添加监听
		ks.setBounds(73, 10, IconImage.ks.getIconWidth(), IconImage.ks.getIconHeight());//设置按钮的位置和大小
		add(ks);//把按钮添加到当前组件
		
//		ImageIcon qh1=new ImageIcon("img/lower/syq.png");//上一曲图标
		syq = new MyButton(IconImage.syq);
		syq.addActionListener(new MostlyListener());//为按钮添加监听
		syq.setBounds(30, 15, IconImage.syq.getIconWidth(), IconImage.syq.getIconHeight());//设置按钮的位置和大小
		add(syq);//把按钮添加到当前组件
		
//		ImageIcon qh2=new ImageIcon("img/lower/xyq.png");//下一曲图标
		xyq = new MyButton(IconImage.xyq);
		xyq.addActionListener(new MostlyListener());//为按钮添加监听
		xyq.setBounds(130, 15, IconImage.xyq.getIconWidth(), IconImage.xyq.getIconHeight());//设置按钮的位置和大小
		add(xyq);//把按钮添加到当前组件
		
		loading = new JSlider();//播放音乐进度条
		loading.setPreferredSize(new Dimension(500,5)); //设置进度条首选大小  
		loading.setValue(0);
		loading.setBounds(220, 40, 450, 5);
		loading.addMouseListener(new MostlyListener());
		loading.addAncestorListener(new MostlyListener());//为进度条添加监听
		add(loading);//把进度条添加到当前组件
		
		volume = new JSlider();//调节音量进度条
		volume.setBounds(835, 30,70, 5);
		volume.setMaximum(5);//最大值设为5、0-5
		volume.addMouseListener(new MostlyListener());//为进度条添加监听
		volume.addAncestorListener(new MostlyListener());//为  音量  的进度条添加监听
		add(volume);//把进度条添加到当前组件
		
		sname = new JLabel();//歌曲名显示
		sname.setFont(new Font("宋体", Font.PLAIN, 15));
		sname.setBounds(230, 15, 200, 20);
		sname.addAncestorListener(new MostlyListener());//添加监听
//		sname.setText("薛之谦-绅士");
		add(sname);
		
		nowtime = new JLabel();
		nowtime.setFont(new Font("宋体", Font.PLAIN, 10));
		nowtime.setBounds(605, 20, 30, 20);
		nowtime.setText("00:00");
		add(nowtime);
		
		alltime = new JLabel();
		alltime.setFont(new Font("宋体", Font.PLAIN, 10));
		alltime.setBounds(630, 20, 40, 20);
		alltime.setText("/00:00");
		add(alltime);
		
//		ImageIcon type=new ImageIcon("img/lower/type1.png");//播放模式图标
		types = new MyButton(IconImage.type1);
		types.setBounds(690, 23, IconImage.type1.getIconWidth(),IconImage.type1.getIconHeight());
		types.addActionListener(new MostlyListener());
		add(types);
		
//		ImageIcon like=new ImageIcon("img/lower/like.png");//我喜欢-图标
		likes = new MyButton(IconImage.like);//我喜欢-按钮
		likes.setBounds(720, 23, IconImage.like.getIconWidth(),IconImage.like.getIconHeight());
		likes.addActionListener(new MostlyListener());
		add(likes);
		
//		ImageIcon load=new ImageIcon("img/lower/load.png");//下载图标
		loads = new MyButton(IconImage.load);
		loads.setBounds(750, 23, IconImage.load.getIconWidth(),IconImage.load.getIconHeight());
		loads.addActionListener(new MostlyListener());
		add(loads);
		
//		ImageIcon lyric=new ImageIcon("img/lower/lyric.png");//歌词图标
		MyButton lyrics = new MyButton(IconImage.lyric);
		lyrics.setBounds(780, 23, IconImage.lyric.getIconWidth(),IconImage.lyric.getIconHeight());
		lyrics.addActionListener(new MostlyListener());
		add(lyrics);
		
//		ImageIcon mute=new ImageIcon("img/lower/nomute.png");//静音图标
		mutes = new MyButton(IconImage.nomute);
		mutes.setBounds(810, 23, IconImage.nomute.getIconWidth(),IconImage.nomute.getIconHeight());
		mutes.addActionListener(new MostlyListener());
		add(mutes);
		
		
		
//		ImageIcon dd=new ImageIcon("img/lower/delete.png");//删除歌曲图标
		delete = new MyButton(IconImage.delete);
		delete.setBounds(920, 23, IconImage.delete.getIconWidth(),IconImage.delete.getIconHeight());
		delete.addActionListener(new MostlyListener());
		add(delete);
	}
}