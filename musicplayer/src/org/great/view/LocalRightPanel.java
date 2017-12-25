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

public class LocalRightPanel extends JPanel{//���������б�
	public static MyButton add_local;
	public static List<TbMusic> list;//��ǰѡ�����������--�б�--���еط���ȡ��ı䶼��������Ĺ�������
	private static DefaultTableModel model;
	public LocalRightPanel() {
		setLayout(null);
		JPanel top=new JPanel();//�ϲ��������panel
		top.setBounds(0, 0, 800, 30);
		top.setLayout(null);
		add_local = new MyButton(IconImage.add_local);
		add_local.setBounds(700, 2, IconImage.add_local.getIconWidth(), IconImage.add_local.getIconHeight());
		add_local.addActionListener(new MostlyListener());//�����������ť��Ӽ���
		top.add(add_local);
		add(top);

		JScrollPane sp=new JScrollPane();
		sp.setBounds(-2, 30, 805, 470);
		String[] name={"����ID","��������","����ʱ��","������С","����·��"};//������
		model=new DefaultTableModel(){
			@Override
			public boolean isCellEditable(int row, int column) {//���ñ�����ݲ��ɱ༭
				return false;
			}
		};
		model.setColumnCount(5);//���ñ�������
		model.setColumnIdentifiers(name);//���ñ�������

		JTable table = new JTable(model);//�����ݼӵ������
		
		list = (List<TbMusic>) DaoFactory.DaoFactory("org.great.jbaseimpl.TbMusicImpl").selectAll();//��ʾ��������
		
		flash(list);//������ݵ����
		table.setRowHeight(40);//����ÿ�и߶�
		table.setShowVerticalLines(false) ;//���ñ��Ƿ���Ƶ�Ԫ��֮��Ĵ�ֱ�ߡ�
		sp.setViewportView(table);//�ѱ����ӵ�ScrollPanel����
		this.add(sp);



		JPanel down=new JPanel();//�²��������panel
		down.setBounds(0, 500, 800, 28);
		MyButton num = new MyButton("1");
		down.add(num);
		MyButton num2 = new MyButton("2");
		down.add(num2);
		MyButton num3 = new MyButton("3");
		down.add(num3);
		MyButton num4 = new MyButton("4");
		down.add(num4);
		MyButton num5 = new MyButton("��һҳ");
		down.add(num5);
		MyButton num6 = new MyButton("��һҳ");
		down.add(num6);
		add(down);


		//		zhong.setPreferredSize(new Dimension(800,table.getRowCount()*table.getRowHeight()));
		//		zhong.add(table);
		////		zhong.setBounds(0, 100, 800, 900);
		//		getViewport().add(zhong);
		//		add(table);//������add
		//setViewportView(table);
		//		JPanel top=new JPanel();//���������panel
		//		top.setSize(800,100);
		//		top.setPreferredSize(new Dimension(800,900));//����ʵ�ʴ�С
		//		top.add(new JButton("������ť"));
		//		setViewportView(top);

		//		setViewportView(table);
		//		zhong.add(table);
		//		setViewportView(top);
		//		zhong.setPreferredSize(new Dimension(800,table.getRowCount()*table.getRowHeight()));
		//		zhong.setBounds(0, top.getHeight(), 800, table.getRowCount()*table.getRowHeight());
		//		table.setBounds(0, 0, 800, table.getRowCount()*table.getRowHeight());
		//		add(zhong);
		//		setWheelScrollingEnabled(true);//����������Ӧ


		//		setWheelScrollingEnabled(true);
		//		JPanel top=new JPanel();
		//		top.setBounds(0, 0, 800, 100);
		//		add(top);
		//		
		//		JPanel t=new JPanel();
		//		String[] name={"����","·��","���С","����ʱ��"};
		//		DefaultTableModel model = new DefaultTableModel();//��һ�����ģ�������������
		//		model.setColumnCount(4);//���ñ�������
		//		model.setColumnIdentifiers(name);
		//		model.setRowCount(100) ;//���ñ�������
		//		
		//		JTable table = new JTable(model);
		//		table.setBounds(0,0,800, table.getRowHeight()*table.getRowCount());
		//		t.setBounds(0, 100,800, table.getRowHeight()*table.getRowCount());//��Ϊ����и�*����
		//		t.add(table);
		//		add(t);
		////		JScrollPane scrollPane = new JScrollPane(table);
		////		 scrollPane.setAutoscrolls(true);
		////		scrollPane.setBounds(0, 0, 800, 630);
		////		add(scrollPane);
		//		
		////		JButton jb=new JButton("���������б�");
		////		jb.setBounds(50, 50, 200, 50);
		////		add(jb);
		//		setBounds(0, 0, 800, top.getHeight()+t.getHeight());
		//		setAutoscrolls(true);
	}
	public static void flash(List<TbMusic> list){//ˢ��
//		model.getRowCount();//����������
//		model.removeRow(1);//�Ƴ�ģ���� row λ�õ��С�
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
			model.insertRow(a, data);//���������
			}
		}
	}
	
}
