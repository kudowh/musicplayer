package org.great.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

import javax.media.Time;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.great.view.MostlyDownPanel;
import org.great.view.MostlyPanel;
import org.great.daofactory.DaoFactory;
import org.great.jbasedao.JBaseDao;
import org.great.jbaseimpl.TbMusicImpl;
import org.great.jbean.TbMusic;
import org.great.model.PlayMusic;
import org.great.util.IconImage;
import org.great.view.LocalRightPanel;
import org.great.view.MostlyCenterPanel;
import org.great.view.MostlyUpPanel;
import org.great.view.Test;

public class MostlyListener implements ActionListener,AncestorListener,MouseListener{
	public static int music=0;//��ǰ���ŵ������ǵڼ���
	private boolean play=false;//�ж��Ƿ񲥷�����
	private boolean like=false;//�ж��Ƿ��ղ�
	private boolean mute=false;//�ж��Ƿ���
	public static int type=1;//�жϲ���ģʽ��1-3��
	private Object obj;
	private int addmusic;
	private int erro;
	public static boolean alter=false;//�Ƿ��϶�����
	public MostlyListener() {//ȱʡ�Ĺ��캯��
	}
	public MostlyListener(Object obj) {//����һ������
		this.obj=obj;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==MostlyUpPanel.gb){
			int dialog = JOptionPane.showConfirmDialog(null, "ȷ��Ҫ�ر���");
			if(dialog==JOptionPane.YES_OPTION){
				System.exit(0);
			}

		}
		if(e.getSource()==MostlyUpPanel.zxh){
			Test.MostlyFrame.setExtendedState(JFrame.ICONIFIED);
		}
		if(e.getSource()==MostlyDownPanel.ks){
			play=!play;//����Ƿ񲥷�����
			if(play==true){
				if(null==PlayMusic.player){
					String music_name = LocalRightPanel.list.get(MostlyListener.music).getMusic_name();//��ǰ���Ÿ����� ������
					MostlyDownPanel.sname.setText(music_name);//���õ�ǰ��ʾ������
					String music_time = LocalRightPanel.list.get(MostlyListener.music).getMusic_time();//��ǰ���Ÿ����� ʱ��
					MostlyDownPanel.alltime.setText("/"+music_time);//���õ�ǰ��ʾ����ʱ��
					String music_path = LocalRightPanel.list.get(MostlyListener.music).getMusic_path();//��ǰ���Ÿ����� ·��
					String path=music_path;//��ȡ��ǰ������·��
					
					PlayMusic.theMusic(path);//����·��
					PlayMusic.playMusic();//��ʼ����
				}else{
					PlayMusic.playMusic();
				}
				MostlyDownPanel.ks.setIcon(IconImage.zt);//ͼ������Ϊ��ͣ
			}else{
				PlayMusic.stopMusic();
				MostlyDownPanel.ks.setIcon(IconImage.ks);//ͼ������Ϊ����
				
				
			}
		}
		if(e.getSource()==MostlyDownPanel.syq){//�����һ����ť
			if(null==PlayMusic.player){//�ӵ�һ�׿�ʼ��
				String music_name = LocalRightPanel.list.get(MostlyListener.music).getMusic_name();//��ǰ���Ÿ����� ������
				MostlyDownPanel.sname.setText(music_name);//���õ�ǰ��ʾ������
				String music_time = LocalRightPanel.list.get(MostlyListener.music).getMusic_time();//��ǰ���Ÿ����� ʱ��
				MostlyDownPanel.alltime.setText("/"+music_time);//���õ�ǰ��ʾ����ʱ��
				String music_path = LocalRightPanel.list.get(MostlyListener.music).getMusic_path();//��ǰ���Ÿ����� ·��
				String path=music_path;//��ȡ��ǰ������·��
				
				PlayMusic.theMusic(path);//����·��
				PlayMusic.playMusic();//��ʼ����
				play=true;
				MostlyDownPanel.ks.setIcon(IconImage.zt);//ͼ������Ϊ��ͣ
			}else{
				PlayMusic.closeMusic();//�ȹر����ڲ��ŵĸ���
				
				if(MostlyListener.music==0){
					MostlyListener.music=LocalRightPanel.list.size()-1;
				}else{
					MostlyListener.music-=1;
				}
				String music_name = LocalRightPanel.list.get(MostlyListener.music).getMusic_name();//��ǰ���Ÿ����� ������
				MostlyDownPanel.sname.setText(music_name);//���õ�ǰ��ʾ������
				String music_time = LocalRightPanel.list.get(MostlyListener.music).getMusic_time();//��ǰ���Ÿ����� ʱ��
				MostlyDownPanel.alltime.setText("/"+music_time);//���õ�ǰ��ʾ����ʱ��
				String music_path = LocalRightPanel.list.get(MostlyListener.music).getMusic_path();//��ǰ���Ÿ����� ·��
				String path=music_path;//��ȡ��ǰ������·��
				
				PlayMusic.theMusic(path);//����·��
				PlayMusic.playMusic();//��ʼ����
				play=true;
				MostlyDownPanel.ks.setIcon(IconImage.zt);//ͼ������Ϊ��ͣ
			}
		}
		if(e.getSource()==MostlyDownPanel.xyq){//�����һ����ť
			if(null==PlayMusic.player){//�ӵ�һ�׿�ʼ��
				String music_name = LocalRightPanel.list.get(MostlyListener.music).getMusic_name();//��ǰ���Ÿ����� ������
				MostlyDownPanel.sname.setText(music_name);//���õ�ǰ��ʾ������
				String music_time = LocalRightPanel.list.get(MostlyListener.music).getMusic_time();//��ǰ���Ÿ����� ʱ��
				MostlyDownPanel.alltime.setText("/"+music_time);//���õ�ǰ��ʾ����ʱ��
				String music_path = LocalRightPanel.list.get(MostlyListener.music).getMusic_path();//��ǰ���Ÿ����� ·��
				String path=music_path;//��ȡ��ǰ������·��
				
				PlayMusic.theMusic(path);//����·��
				PlayMusic.playMusic();//��ʼ����
				play=true;
				MostlyDownPanel.ks.setIcon(IconImage.zt);//ͼ������Ϊ��ͣ
			}else{
				PlayMusic.closeMusic();//�ȹر����ڲ��ŵĸ���
				
				MusicListener.type(type);
				
				play=true;
				MostlyDownPanel.ks.setIcon(IconImage.zt);//ͼ������Ϊ��ͣ
			}
		}
		if(e.getSource()==MostlyDownPanel.likes){
			like=!like;
			if(like){//�ж�Ϊϲ��
				MostlyDownPanel.likes.setIcon(IconImage.islike);//ϲ����ͼ��
			}else{
				MostlyDownPanel.likes.setIcon(IconImage.like);//ȡ��ϲ����ͼ��
			}
		}
		//		ImageIcon mutess=new ImageIcon("img/lower/mute.png");//����ͼ��
		//		ImageIcon nomute=new ImageIcon("img/lower/nomute.png");//����ͼ��
		if(e.getSource()==MostlyDownPanel.mutes){//�ж��Ƿ���
			mute=!mute;
			if(mute){//�ж�Ϊ����
				MostlyDownPanel.mutes.setIcon(IconImage.mute);
			}else{
				MostlyDownPanel.mutes.setIcon(IconImage.nomute);
			}
		}
		//		ImageIcon type1=new ImageIcon("img/lower/type1.png");//ѭ������
		//		ImageIcon type2=new ImageIcon("img/lower/type2.png");//����ѭ��
		//		ImageIcon type3=new ImageIcon("img/lower/type3.png");//�������
		if(e.getSource()==MostlyDownPanel.types){//�жϵ�ǰ��������
			type++;//���һ�±�һ��ֵ
			if(type>3){
				type=1;
			}
			if(type==1){
				MostlyDownPanel.types.setIcon(IconImage.type1);//ͼ���Ϊѭ������
			}
			else if(type==2){
				MostlyDownPanel.types.setIcon(IconImage.type2);//ͼ���Ϊ����ѭ��
			}
			else if(type==3){
				MostlyDownPanel.types.setIcon(IconImage.type3);//ͼ���Ϊ�������
			}
		}
		if(e.getSource()==MostlyUpPanel.mymusic){//����������ְ�ť
			System.out.println("�������� ======");
			MostlyCenterPanel.cardLayout.first(MostlyPanel.centerPanel);
		}
		if(e.getSource()==MostlyUpPanel.yd){//����ƶ����ְ�ť
			System.out.println("�ƶ����� ======");
			MostlyCenterPanel.cardLayout.last(MostlyPanel.centerPanel);
		}
		if(e.getSource()==LocalRightPanel.add_local){//����������ְ�ť
			System.out.println("��������");
			JFileChooser jfc=new JFileChooser();
			jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);//�ļ����ļ��ж�����ѡ��
			jfc.setMultiSelectionEnabled(true);//���ÿ���ѡ�����ļ�
			jfc.showOpenDialog(null);//���ļ�ѡ���
			jfc.setVisible(true);//���ô��ڿɼ���
			//jfc.setFileFilter(new FileNameExtensionFilter("wav file", "wav"));//���õ�ǰ�ļ�������

			File[] file=jfc.getSelectedFiles();//����Ϊ�ɶ�ѡ�ļ�ʱ�򷵻�ѡ���ļ����б�
			addmusic = 0;//����ɹ�����������
			erro = 0;//�ļ���ʽ���������
			if(null!=file){
				System.out.println("ѡ����ļ���Ϊ��");
				core(file);
			}
			JOptionPane.showMessageDialog(Test.MostlyFrame, "��ӳɹ�"+addmusic+"������"+",����"+erro+"���ļ�����ʧ�ܣ�ʧ��ԭ���ļ�����wav��ʽ");
			LocalRightPanel.flash(LocalRightPanel.list=(List<TbMusic>) DaoFactory.DaoFactory("org.great.jbaseimpl.TbMusicImpl").selectAll());
		}
	}
	@Override
	public void ancestorAdded(AncestorEvent event) {//����������
		// TODO Auto-generated method stub

	}
	@Override
	public void ancestorRemoved(AncestorEvent event) {//����������
		// TODO Auto-generated method stub

	}
	@Override
	public void ancestorMoved(AncestorEvent event) {//����������
		// TODO Auto-generated method stub

	}

	public void core(File[] file){
		System.out.println("���뷽��");
		for(File files:file){
			System.out.println("�����ļ�");
			if(files.isDirectory()){//������ļ��о���������
				this.core(files.listFiles());
			}else{
				//�ļ����Ƿ�����wav��β����������ִ�в�  ������wav��β+1
				String filename=files.getName();//�Ѿ����˹���wav��ʽ����ȡ·�����ļ�����ʱ��
				if(filename.endsWith("wav")||filename.endsWith("WAV")){
					String path = files.getAbsolutePath();//�õ��ļ��ľ���·��
					String name=path.substring(path.lastIndexOf("\\")+1,path.lastIndexOf("."));//�õ�������
					int size=0;
					BufferedInputStream bis=null;
					try {
						bis=new BufferedInputStream(new FileInputStream(files));
						byte[] byt=new byte[1024];
						int len=-1;
						while(-1!=(len=bis.read(byt))){
							size++;//��󲻵�1K��1k��
						}
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally{
						if(null!=bis){
							try {
								bis.close();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
					}
					String	songSize=String.valueOf((float)(size/1024))+"M";
					System.out.println("�ļ���С��"+songSize);
					//���ļ��Ļ� ���ж��Ƿ�������ݿ⣬���ڵĲ��������������ڵĽ��м������ݿ����
					System.out.println("path:"+path+"name:"+name);
					//�õõ���·����ȥ���ݿ����
					JBaseDao factory = DaoFactory.DaoFactory("org.great.jbaseimpl.TbMusicImpl");
					TbMusicImpl t=(TbMusicImpl) factory;
					boolean song = t.selectSong(name);

					System.out.println("�����Ƿ���ڣ�"+song);
					//�����ڵ�����£��ٻ�ȡʱ�����������ݿ�
					if(song==false){
						//�������ֲ�����ķ������õ����ļ�����ʱ��
						int time = PlayMusic.allTime(files);
						int fen=time/60;
						int miao=time%60;
						String f=null;
						String m=null;
						if(fen<10){
							f="0"+fen;
						}else{
							f=String.valueOf(fen);
						}
						if(miao<10){
							m="0"+miao;
						}else{
							m=String.valueOf(miao);
						}
						String allTime= f+":"+m;//�õ�����ʱ��
						System.out.println("����ʱ����"+allTime);
						boolean insertBean = DaoFactory.DaoFactory("org.great.jbaseimpl.TbMusicImpl").insertBean(new TbMusic(0, name,songSize, allTime, path));
						if(insertBean){
							//�ɹ�����+1������������н�
							addmusic++;
						}
					}

				}else{
					erro++;
				}
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		//��갴���¼�
		if(e.getSource()==MostlyDownPanel.loading){
			alter=true;//׼���϶������ֻ���
		}
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {//����ɿ�
		if(e.getSource()==MostlyDownPanel.loading){
			double value=MostlyDownPanel.loading.getValue();
			if(PlayMusic.player!=null&&PlayMusic.player.getState()==PlayMusic.player.Started){//player��Ϊ�� �� ״̬�ڲ���״̬ʱ
				PlayMusic.player.setMediaTime(new Time(value));
			}
			alter=false;//�϶����
		}
		if(e.getSource()==MostlyDownPanel.volume){
			System.out.println("��ǰ����������ֵ��"+MostlyDownPanel.volume.getValue());
			float values=(float)MostlyDownPanel.volume.getValue()/10;//������float���͵ģ����һ��0.5  ���԰ѻ�����ǿת��float
			if(PlayMusic.player!=null&&PlayMusic.player.getState()==PlayMusic.player.Started){//player��Ϊ�� �� ״̬�ڲ���״̬ʱ
				PlayMusic.player.getGainControl().setLevel(values);//����
			}
		}
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



}
