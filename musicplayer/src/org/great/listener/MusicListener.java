package org.great.listener;

import java.util.List;
import java.util.Random;

import javax.media.ControllerAdapter;
import javax.media.EndOfMediaEvent;
import javax.media.Player;
import javax.media.PrefetchCompleteEvent;
import javax.media.RealizeCompleteEvent;

import org.great.jbean.TbMusic;
import org.great.model.PlayMusic;
import org.great.view.LocalRightPanel;
import org.great.view.MostlyDownPanel;

public class MusicListener extends ControllerAdapter{
	private Player player;

	private static List<TbMusic> list;//当前所有音乐的集合

	public MusicListener(Player player) {
		this.player=player;
	}

	@Override
	public void endOfMedia(EndOfMediaEvent e) {//歌曲播放完成会调用这个方法
		System.out.println("音乐播放完");
		PlayMusic.closeMusic();//关闭上一首音乐

		type(MostlyListener.type);//传入当前的播放模式
	}

	public static void type(int model) {//播放模式
		list= LocalRightPanel.list;
		switch(model){
		case 1:
			shunxu();
			break;
		case 2:
			danqu();
			break;
		case 3:
			shuiji();
			break;
		}
	}
	private static void shunxu() {//顺序循环播放模式
		if(MostlyListener.music<list.size()-1){
			MostlyListener.music+=1;
		}else{
			MostlyListener.music=0;
		}
		dataList();
	}
	private static void danqu() {//单曲循环
		dataList();
	}
	private static void shuiji() {//随机播放
		Random rd=new Random();
		int i = rd.nextInt(list.size());
		MostlyListener.music=i;

		dataList();
	}

	private static void dataList() {
		String music_name = list.get(MostlyListener.music).getMusic_name();//当前播放歌曲的 歌曲名
		MostlyDownPanel.sname.setText(music_name);//设置当前显示歌曲名
		String music_time = list.get(MostlyListener.music).getMusic_time();//当前播放歌曲的 时长
		MostlyDownPanel.alltime.setText("/"+music_time);//设置当前显示的总时长
		String music_path = list.get(MostlyListener.music).getMusic_path();//当前播放歌曲的 路径
		String path=music_path;//获取当前歌曲的路径

		PlayMusic.theMusic(path);//传入路径
		PlayMusic.playMusic();//开始播放
	}

	@Override
	public void realizeComplete(RealizeCompleteEvent e) {//识别完成会调用这个方法
		// TODO Auto-generated method stub
		super.realizeComplete(e);
		player.prefetch();//音乐识别完成，调用缓冲
	}
	@Override
	public void prefetchComplete(PrefetchCompleteEvent e) {//缓冲完成会调用这个方法
		// TODO Auto-generated method stub
		super.prefetchComplete(e);
		
		//播放之前，缓冲完成之后，获取音乐时长
		int sec=(int) player.getDuration().getSeconds();
		MostlyDownPanel.loading.setMaximum(sec);//设置滑动块的最大值
	}
	
}
