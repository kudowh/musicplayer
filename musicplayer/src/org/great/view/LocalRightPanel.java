package org.great.view;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.great.daofactory.DaoFactory;
import org.great.jbean.TbMusic;
import org.great.listener.MostlyListener;
import org.great.util.IconImage;

import com.ibm.media.bean.multiplayer.MediaArrayEditor;

public class LocalRightPanel extends JPanel{//本地音乐列表
	public static MyButton add_local;
	public static List<TbMusic> list;//当前选择的所有音乐--列表--所有地方获取或改变都调用这里的公共引用
	private static DefaultTableModel model;
	public LocalRightPanel() {
		setLayout(null);
		JPanel top=new JPanel();//上部分区域的panel
		top.setBounds(0, 0, 800, 30);
		top.setLayout(null);
		add_local = new MyButton(IconImage.add_local);
		add_local.setBounds(700, 2, IconImage.add_local.getIconWidth(), IconImage.add_local.getIconHeight());
		add_local.addActionListener(new MostlyListener());//给导入歌曲按钮添加监听
		top.add(add_local);
		add(top);

		JScrollPane sp=new JScrollPane();
		sp.setBounds(-2, 30, 805, 470);
		String[] name={"歌曲ID","歌曲名称","歌曲时长","歌曲大小","歌曲路径"};//标题栏
		model=new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row, int column) {//设置表格数据不可编辑
				return false;
			}
		};
		model.setColumnCount(5);//设置表格的列数
		model.setColumnIdentifiers(name);//设置表格的列名

		JTable table = new JTable(model);//把内容加到表格中
		
		list = (List<TbMusic>) DaoFactory.DaoFactory("org.great.jbaseimpl.TbMusicImpl").selectAll();//显示所有数据
		
		flash(list);//添加数据到表格
		table.setRowHeight(40);//设置每行高度
		table.setShowVerticalLines(false) ;//设置表是否绘制单元格之间的垂直线。
		sp.setViewportView(table);//把表格添加到ScrollPanel里面
		this.add(sp);



		JPanel down=new JPanel();//下部分区域的panel
		down.setBounds(0, 500, 800, 28);
		MyButton num = new MyButton("1");
		down.add(num);
		MyButton num2 = new MyButton("2");
		down.add(num2);
		MyButton num3 = new MyButton("3");
		down.add(num3);
		MyButton num4 = new MyButton("4");
		down.add(num4);
		MyButton num5 = new MyButton("上一页");
		down.add(num5);
		MyButton num6 = new MyButton("下一页");
		down.add(num6);
		add(down);


		//		zhong.setPreferredSize(new Dimension(800,table.getRowCount()*table.getRowHeight()));
		//		zhong.add(table);
		////		zhong.setBounds(0, 100, 800, 900);
		//		getViewport().add(zhong);
		//		add(table);//不能用add
		//setViewportView(table);
		//		JPanel top=new JPanel();//上面区域的panel
		//		top.setSize(800,100);
		//		top.setPreferredSize(new Dimension(800,900));//设置实际大小
		//		top.add(new JButton("顶部按钮"));
		//		setViewportView(top);

		//		setViewportView(table);
		//		zhong.add(table);
		//		setViewportView(top);
		//		zhong.setPreferredSize(new Dimension(800,table.getRowCount()*table.getRowHeight()));
		//		zhong.setBounds(0, top.getHeight(), 800, table.getRowCount()*table.getRowHeight());
		//		table.setBounds(0, 0, 800, table.getRowCount()*table.getRowHeight());
		//		add(zhong);
		//		setWheelScrollingEnabled(true);//启动滚轮响应


		//		setWheelScrollingEnabled(true);
		//		JPanel top=new JPanel();
		//		top.setBounds(0, 0, 800, 100);
		//		add(top);
		//		
		//		JPanel t=new JPanel();
		//		String[] name={"歌名","路径","歌大小","歌市时长"};
		//		DefaultTableModel model = new DefaultTableModel();//建一个表格模型用于添加数据
		//		model.setColumnCount(4);//设置表格的行数
		//		model.setColumnIdentifiers(name);
		//		model.setRowCount(100) ;//设置表格的列数
		//		
		//		JTable table = new JTable(model);
		//		table.setBounds(0,0,800, table.getRowHeight()*table.getRowCount());
		//		t.setBounds(0, 100,800, table.getRowHeight()*table.getRowCount());//高为表格行高*行数
		//		t.add(table);
		//		add(t);
		////		JScrollPane scrollPane = new JScrollPane(table);
		////		 scrollPane.setAutoscrolls(true);
		////		scrollPane.setBounds(0, 0, 800, 630);
		////		add(scrollPane);
		//		
		////		JButton jb=new JButton("本地音乐列表");
		////		jb.setBounds(50, 50, 200, 50);
		////		add(jb);
		//		setBounds(0, 0, 800, top.getHeight()+t.getHeight());
		//		setAutoscrolls(true);
	}
	public static void flash(List<TbMusic> list){//刷新
//		model.getRowCount();//返回总行数
//		model.removeRow(1);//移除模型中 row 位置的行。
        if(model.getRowCount()>0){
        	int all=model.getRowCount();
        	for(int a=0;a<all;a++){
        		model.removeRow(0);
        	}
        }
		
		if(null!=list){
			for(int a=0;a<list.size();a++){
			TbMusic music=list.get(a);
			String[] data={a+1+"",music.getMusic_name(),music.getMusic_time(),music.getMusic_size(),music.getMusic_path()};
			model.insertRow(a, data);//添加行数据
			}
		}
	}
	
}
