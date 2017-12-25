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
	public PlayMusic() {//�յĹ��캯��
	}
	
	public static void theMusic(String file){//���ݸ����ļ���������
		URL url = null;
		try {
			url = new URL("file:///"+file);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			player=Manager.createPlayer(url);
			
			player.realize();//ʶ������
			int allTime = (int) player.getDuration().getSeconds();//��ȡ��ʱ�����룩
			MostlyDownPanel.loading.setMaximum(allTime);//���û���������ֵ
			new MusicSync(player,allTime).start();//�������ڹ��������߳�
			
		} catch (NoPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(null!=player){
			//������������״̬
			player.addControllerListener(new MusicListener(player));
		}
	}
	public static void playMusic(){//���ֿ�ʼ�����
		player.start();
	}
	public static void stopMusic(){//������ͣ
		player.stop();
	}
	public static void closeMusic(){//��������
		player.close();
	}

	public static int allTime(File file){//��ȡ�ļ�����ʱ��,���ڵ����ļ�ʱ��ȡ����ʱ�䳤��
		URL url = null;
		try {
			url=file.toURI().toURL();//�õ��ļ���//����Դ
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//ͨ��Manager�����createRealizedPlayer(java.net.URL sourceURL) ����ȡPlayer����
		Player player=null;
		int timer = 0;//��ȡ��ʱ�����룩
		try {//��ȡPlayer����
			player = Manager.createRealizedPlayer(url);//����Ҫ׼���������Ҫ��ȡ������ʱ�����Ż�׼ȷ
			timer = (int) player.getDuration().getSeconds();//��ȡ��ʱ�����룩
			
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
		while(true){				//��ȡ����״̬==��ʼ���Ÿ���			���û���϶�����
			if(player!=null&&player.getState()==player.Started&&MostlyListener.alter==false){
				//��ǰʱ��
				int curSec=(int) player.getMediaTime().getSeconds();//��ȡ��ǰʱ��
				MostlyDownPanel.loading.setValue(curSec);//���ù������ĵ�ǰʱ���λ��
				newTime(curSec);
				
				float level = player.getGainControl().getLevel();//���ص�ǰ������
//				player.getGainControl().setLevel((float)0.2);
				System.out.println("��ǰ������"+level);
				if(curSec>0&&curSec==allTime){
					break;
				}
			}
			try {
				Thread.sleep(1000);//1����ˢ��һ�¹�����
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	private void newTime(int curSec) {//���¸�����ʾ��ʱ��
		int min=curSec/60;//����
		int sec=curSec%60;//����
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


