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
	public static int music=0;//当前播放的音乐是第几首
	private boolean play=false;//判断是否播放音乐
	private boolean like=false;//判断是否收藏
	private boolean mute=false;//判断是否静音
	public static int type=1;//判断播放模式（1-3）
	private Object obj;
	private int addmusic;
	private int erro;
	public static boolean alter=false;//是否拖动滑块
	public MostlyListener() {//缺省的构造函数
	}
	public MostlyListener(Object obj) {//传入一个对象
		this.obj=obj;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==MostlyUpPanel.gb){
			int dialog = JOptionPane.showConfirmDialog(null, "确定要关闭吗？");
			if(dialog==JOptionPane.YES_OPTION){
				System.exit(0);
			}

		}
		if(e.getSource()==MostlyUpPanel.zxh){
			Test.MostlyFrame.setExtendedState(JFrame.ICONIFIED);
		}
		if(e.getSource()==MostlyDownPanel.ks){
			play=!play;//标记是否播放音乐
			if(play==true){
				if(null==PlayMusic.player){
					String music_name = LocalRightPanel.list.get(MostlyListener.music).getMusic_name();//当前播放歌曲的 歌曲名
					MostlyDownPanel.sname.setText(music_name);//设置当前显示歌曲名
					String music_time = LocalRightPanel.list.get(MostlyListener.music).getMusic_time();//当前播放歌曲的 时长
					MostlyDownPanel.alltime.setText("/"+music_time);//设置当前显示的总时长
					String music_path = LocalRightPanel.list.get(MostlyListener.music).getMusic_path();//当前播放歌曲的 路径
					String path=music_path;//获取当前歌曲的路径
					
					PlayMusic.theMusic(path);//传入路径
					PlayMusic.playMusic();//开始播放
				}else{
					PlayMusic.playMusic();
				}
				MostlyDownPanel.ks.setIcon(IconImage.zt);//图标设置为暂停
			}else{
				PlayMusic.stopMusic();
				MostlyDownPanel.ks.setIcon(IconImage.ks);//图标设置为播放
				
				
			}
		}
		if(e.getSource()==MostlyDownPanel.syq){//点击上一曲按钮
			if(null==PlayMusic.player){//从第一首开始放
				String music_name = LocalRightPanel.list.get(MostlyListener.music).getMusic_name();//当前播放歌曲的 歌曲名
				MostlyDownPanel.sname.setText(music_name);//设置当前显示歌曲名
				String music_time = LocalRightPanel.list.get(MostlyListener.music).getMusic_time();//当前播放歌曲的 时长
				MostlyDownPanel.alltime.setText("/"+music_time);//设置当前显示的总时长
				String music_path = LocalRightPanel.list.get(MostlyListener.music).getMusic_path();//当前播放歌曲的 路径
				String path=music_path;//获取当前歌曲的路径
				
				PlayMusic.theMusic(path);//传入路径
				PlayMusic.playMusic();//开始播放
				play=true;
				MostlyDownPanel.ks.setIcon(IconImage.zt);//图标设置为暂停
			}else{
				PlayMusic.closeMusic();//先关闭正在播放的歌曲
				
				if(MostlyListener.music==0){
					MostlyListener.music=LocalRightPanel.list.size()-1;
				}else{
					MostlyListener.music-=1;
				}
				String music_name = LocalRightPanel.list.get(MostlyListener.music).getMusic_name();//当前播放歌曲的 歌曲名
				MostlyDownPanel.sname.setText(music_name);//设置当前显示歌曲名
				String music_time = LocalRightPanel.list.get(MostlyListener.music).getMusic_time();//当前播放歌曲的 时长
				MostlyDownPanel.alltime.setText("/"+music_time);//设置当前显示的总时长
				String music_path = LocalRightPanel.list.get(MostlyListener.music).getMusic_path();//当前播放歌曲的 路径
				String path=music_path;//获取当前歌曲的路径
				
				PlayMusic.theMusic(path);//传入路径
				PlayMusic.playMusic();//开始播放
				play=true;
				MostlyDownPanel.ks.setIcon(IconImage.zt);//图标设置为暂停
			}
		}
		if(e.getSource()==MostlyDownPanel.xyq){//点击下一曲按钮
			if(null==PlayMusic.player){//从第一首开始放
				String music_name = LocalRightPanel.list.get(MostlyListener.music).getMusic_name();//当前播放歌曲的 歌曲名
				MostlyDownPanel.sname.setText(music_name);//设置当前显示歌曲名
				String music_time = LocalRightPanel.list.get(MostlyListener.music).getMusic_time();//当前播放歌曲的 时长
				MostlyDownPanel.alltime.setText("/"+music_time);//设置当前显示的总时长
				String music_path = LocalRightPanel.list.get(MostlyListener.music).getMusic_path();//当前播放歌曲的 路径
				String path=music_path;//获取当前歌曲的路径
				
				PlayMusic.theMusic(path);//传入路径
				PlayMusic.playMusic();//开始播放
				play=true;
				MostlyDownPanel.ks.setIcon(IconImage.zt);//图标设置为暂停
			}else{
				PlayMusic.closeMusic();//先关闭正在播放的歌曲
				
				MusicListener.type(type);
				
				play=true;
				MostlyDownPanel.ks.setIcon(IconImage.zt);//图标设置为暂停
			}
		}
		if(e.getSource()==MostlyDownPanel.likes){
			like=!like;
			if(like){//判断为喜欢
				MostlyDownPanel.likes.setIcon(IconImage.islike);//喜欢的图标
			}else{
				MostlyDownPanel.likes.setIcon(IconImage.like);//取消喜欢的图标
			}
		}
		//		ImageIcon mutess=new ImageIcon("img/lower/mute.png");//静音图标
		//		ImageIcon nomute=new ImageIcon("img/lower/nomute.png");//静音图标
		if(e.getSource()==MostlyDownPanel.mutes){//判断是否静音
			mute=!mute;
			if(mute){//判断为静音
				MostlyDownPanel.mutes.setIcon(IconImage.mute);
			}else{
				MostlyDownPanel.mutes.setIcon(IconImage.nomute);
			}
		}
		//		ImageIcon type1=new ImageIcon("img/lower/type1.png");//循环播放
		//		ImageIcon type2=new ImageIcon("img/lower/type2.png");//单曲循环
		//		ImageIcon type3=new ImageIcon("img/lower/type3.png");//随机播放
		if(e.getSource()==MostlyDownPanel.types){//判断当前播放类型
			type++;//点击一下变一个值
			if(type>3){
				type=1;
			}
			if(type==1){
				MostlyDownPanel.types.setIcon(IconImage.type1);//图标改为循环播放
			}
			else if(type==2){
				MostlyDownPanel.types.setIcon(IconImage.type2);//图标改为单曲循环
			}
			else if(type==3){
				MostlyDownPanel.types.setIcon(IconImage.type3);//图标改为随机播放
			}
		}
		if(e.getSource()==MostlyUpPanel.mymusic){//点击本地音乐按钮
			System.out.println("本地音乐 ======");
			MostlyCenterPanel.cardLayout.first(MostlyPanel.centerPanel);
		}
		if(e.getSource()==MostlyUpPanel.yd){//点击云端音乐按钮
			System.out.println("云端音乐 ======");
			MostlyCenterPanel.cardLayout.last(MostlyPanel.centerPanel);
		}
		if(e.getSource()==LocalRightPanel.add_local){//点击导入音乐按钮
			System.out.println("导入音乐");
			JFileChooser jfc=new JFileChooser();
			jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);//文件和文件夹都可以选择
			jfc.setMultiSelectionEnabled(true);//设置可以选择多个文件
			jfc.showOpenDialog(null);//打开文件选择框
			jfc.setVisible(true);//设置窗口可见性
			//jfc.setFileFilter(new FileNameExtensionFilter("wav file", "wav"));//设置当前文件过滤器

			File[] file=jfc.getSelectedFiles();//设置为可多选文件时候返回选中文件的列表
			addmusic = 0;//导入成功的音乐数量
			erro = 0;//文件格式错误的数量
			if(null!=file){
				System.out.println("选择的文件不为空");
				core(file);
			}
			JOptionPane.showMessageDialog(Test.MostlyFrame, "添加成功"+addmusic+"首音乐"+",其中"+erro+"个文件导入失败！失败原因：文件不是wav格式");
			LocalRightPanel.flash(LocalRightPanel.list=(List<TbMusic>) DaoFactory.DaoFactory("org.great.jbaseimpl.TbMusicImpl").selectAll());
		}
	}
	@Override
	public void ancestorAdded(AncestorEvent event) {//进度条监听
		// TODO Auto-generated method stub

	}
	@Override
	public void ancestorRemoved(AncestorEvent event) {//进度条监听
		// TODO Auto-generated method stub

	}
	@Override
	public void ancestorMoved(AncestorEvent event) {//进度条监听
		// TODO Auto-generated method stub

	}

	public void core(File[] file){
		System.out.println("进入方法");
		for(File files:file){
			System.out.println("遍历文件");
			if(files.isDirectory()){//如果是文件夹就往里搜索
				this.core(files.listFiles());
			}else{
				//文件名是否是以wav结尾，不包含不执行并  不是以wav结尾+1
				String filename=files.getName();//已经过滤过是wav格式、读取路径、文件名、时长
				if(filename.endsWith("wav")||filename.endsWith("WAV")){
					String path = files.getAbsolutePath();//得到文件的绝对路径
					String name=path.substring(path.lastIndexOf("\\")+1,path.lastIndexOf("."));//得到歌曲名
					int size=0;
					BufferedInputStream bis=null;
					try {
						bis=new BufferedInputStream(new FileInputStream(files));
						byte[] byt=new byte[1024];
						int len=-1;
						while(-1!=(len=bis.read(byt))){
							size++;//最后不到1K按1k算
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
					System.out.println("文件大小："+songSize);
					//是文件的话 先判断是否存在数据库，存在的不做操作，不存在的进行加入数据库操作
					System.out.println("path:"+path+"name:"+name);
					//用得到的路径名去数据库查找
					JBaseDao factory = DaoFactory.DaoFactory("org.great.jbaseimpl.TbMusicImpl");
					TbMusicImpl t=(TbMusicImpl) factory;
					boolean song = t.selectSong(name);

					System.out.println("音乐是否存在："+song);
					//不存在的情况下，再获取时长，加入数据库
					if(song==false){
						//调用音乐播放类的方法，得到该文件的总时长
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
						String allTime= f+":"+m;//得到歌曲时长
						System.out.println("音乐时长："+allTime);
						boolean insertBean = DaoFactory.DaoFactory("org.great.jbaseimpl.TbMusicImpl").insertBean(new TbMusic(0, name,songSize, allTime, path));
						if(insertBean){
							//成功条数+1，定义个变量承接
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
		//鼠标按下事件
		if(e.getSource()==MostlyDownPanel.loading){
			alter=true;//准备拖动放音乐滑块
		}
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {//鼠标松开
		if(e.getSource()==MostlyDownPanel.loading){
			double value=MostlyDownPanel.loading.getValue();
			if(PlayMusic.player!=null&&PlayMusic.player.getState()==PlayMusic.player.Started){//player不为空 且 状态在播放状态时
				PlayMusic.player.setMediaTime(new Time(value));
			}
			alter=false;//拖动完成
		}
		if(e.getSource()==MostlyDownPanel.volume){
			System.out.println("当前音量滑动块值："+MostlyDownPanel.volume.getValue());
			float values=(float)MostlyDownPanel.volume.getValue()/10;//音量是float类型的，最大一般0.5  所以把滑动块强转成float
			if(PlayMusic.player!=null&&PlayMusic.player.getState()==PlayMusic.player.Started){//player不为空 且 状态在播放状态时
				PlayMusic.player.getGainControl().setLevel(values);//设置
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
