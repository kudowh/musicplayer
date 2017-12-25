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

	private static List<TbMusic> list;//��ǰ�������ֵļ���

	public MusicListener(Player player) {
		this.player=player;
	}

	@Override
	public void endOfMedia(EndOfMediaEvent e) {//����������ɻ�����������
		System.out.println("���ֲ�����");
		PlayMusic.closeMusic();//�ر���һ������

		type(MostlyListener.type);//���뵱ǰ�Ĳ���ģʽ
	}

	public static void type(int model) {//����ģʽ
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
	private static void shunxu() {//˳��ѭ������ģʽ
		if(MostlyListener.music<list.size()-1){
			MostlyListener.music+=1;
		}else{
			MostlyListener.music=0;
		}
		dataList();
	}
	private static void danqu() {//����ѭ��
		dataList();
	}
	private static void shuiji() {//�������
		Random rd=new Random();
		int i = rd.nextInt(list.size());
		MostlyListener.music=i;

		dataList();
	}

	private static void dataList() {
		String music_name = list.get(MostlyListener.music).getMusic_name();//��ǰ���Ÿ����� ������
		MostlyDownPanel.sname.setText(music_name);//���õ�ǰ��ʾ������
		String music_time = list.get(MostlyListener.music).getMusic_time();//��ǰ���Ÿ����� ʱ��
		MostlyDownPanel.alltime.setText("/"+music_time);//���õ�ǰ��ʾ����ʱ��
		String music_path = list.get(MostlyListener.music).getMusic_path();//��ǰ���Ÿ����� ·��
		String path=music_path;//��ȡ��ǰ������·��

		PlayMusic.theMusic(path);//����·��
		PlayMusic.playMusic();//��ʼ����
	}

	@Override
	public void realizeComplete(RealizeCompleteEvent e) {//ʶ����ɻ�����������
		// TODO Auto-generated method stub
		super.realizeComplete(e);
		player.prefetch();//����ʶ����ɣ����û���
	}
	@Override
	public void prefetchComplete(PrefetchCompleteEvent e) {//������ɻ�����������
		// TODO Auto-generated method stub
		super.prefetchComplete(e);
		
		//����֮ǰ���������֮�󣬻�ȡ����ʱ��
		int sec=(int) player.getDuration().getSeconds();
		MostlyDownPanel.loading.setMaximum(sec);//���û���������ֵ
	}
	
}
