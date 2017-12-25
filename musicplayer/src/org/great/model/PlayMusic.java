package org.great.model;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.media.CannotRealizeException;
import javax.media.ControllerAdapter;
import javax.media.EndOfMediaEvent;
import javax.media.Manager;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.media.Time;

import org.great.daofactory.DaoFactory;
import org.great.jbean.TbMusic;
import org.great.listener.MostlyListener;
import org.great.listener.MusicListener;
import org.great.view.MostlyDownPanel;
import org.junit.Test;


public class PlayMusic {
	public static Player player;
	public PlayMusic() {//空的构造函数
	}
	
	public static void theMusic(String file){//根据给定文件播放音乐
		URL url = null;
		try {
			url = new URL("file:///"+file);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			player=Manager.createPlayer(url);
			
			player.realize();//识别音乐
			int allTime = (int) player.getDuration().getSeconds();//获取总时长（秒）
			MostlyDownPanel.loading.setMaximum(allTime);//设置滑动块的最大值
			new MusicSync(player,allTime).start();//开启调节滚动条的线程
			
		} catch (NoPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(null!=player){
			//监听播放器的状态
			player.addControllerListener(new MusicListener(player));
		}
	}
	public static void playMusic(){//音乐开始或继续
		player.start();
	}
	public static void stopMusic(){//音乐暂停
		player.stop();
	}
	public static void closeMusic(){//结束歌曲
		player.close();
	}

	public static int allTime(File file){//获取文件的总时长,用于导入文件时获取音乐时间长度
		URL url = null;
		try {
			url=file.toURI().toURL();//得到文件的//数据源
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//通过Manager对象的createRealizedPlayer(java.net.URL sourceURL) ，获取Player对象
		Player player=null;
		int timer = 0;//获取总时长（秒）
		try {//获取Player对象
			player = Manager.createRealizedPlayer(url);//音乐要准备完成我们要获取音乐总时长，才会准确
			timer = (int) player.getDuration().getSeconds();//获取总时长（秒）
			
		} catch (NoPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CannotRealizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			player.close();
		}
		return timer;
	}
}

class MusicSync extends Thread{
	Player player;
	int allTime;
	public MusicSync(Player player, int allTime) {
		this.player=player;
		this.allTime=allTime;
	}
	@Override
	public void run() {
		while(true){				//获取它的状态==开始播放歌曲			鼠标没有拖动滑块
			if(player!=null&&player.getState()==player.Started&&MostlyListener.alter==false){
				//当前时间
				int curSec=(int) player.getMediaTime().getSeconds();//获取当前时间
				MostlyDownPanel.loading.setValue(curSec);//设置滚动条的当前时间的位置
				newTime(curSec);
				
				float level = player.getGainControl().getLevel();//返回当前的音量
//				player.getGainControl().setLevel((float)0.2);
				System.out.println("当前音量："+level);
				if(curSec>0&&curSec==allTime){
					break;
				}
			}
			try {
				Thread.sleep(1000);//1秒钟刷新一下滚动条
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private void newTime(int curSec) {//更新歌曲显示的时间
		int min=curSec/60;//分钟
		int sec=curSec%60;//秒钟
		String m=null;
		String s=null;
		if(min<10){
			m="0"+min;
		}else{
			m=String.valueOf(min);
		}
		if(sec<10){
			s="0"+sec;
		}else{
			s=String.valueOf(sec);
		}
		MostlyDownPanel.nowtime.setText(m+":"+s);
	}
	
}


