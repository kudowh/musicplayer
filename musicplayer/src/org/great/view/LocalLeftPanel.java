package org.great.view;


import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import org.great.listener.MostlyListener;

public class LocalLeftPanel extends JScrollPane{
	public LocalLeftPanel() {
		init();
	}
	private void init() {
		this.setWheelScrollingEnabled(true);
		//不显示水平滚动条
		this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );

		this.setBounds(0, this.getHeight(),this.getWidth(),(this.getHeight()-this.getHeight()-10));
		JButton jb = new JButton("hah");
		this.add(jb);
		//jTreeDemo();
		jtree();
	}
	private void jtree() {
		//root节点
		IconTreeNode root = new IconTreeNode(null,null,-1);
		//1.获取歌曲列表的所有数据
		//2.创建所有列表节点
		IconTreeNode tybNode1 = new IconTreeNode(null, "我的音乐", 1);
		root.add(tybNode1);
		IconTreeNode tybNode2 = new IconTreeNode(null, "云歌单", 2);
		root.add(tybNode2);
		IconTreeNode tybNode3 = new IconTreeNode(null, "本地歌曲", 3);
		root.add(tybNode3);
		//3.添加子节点获取这个列表下所有的歌曲
		IconTreeNode node = new IconTreeNode(null, "本地音乐", 1);
		tybNode1.add(node);
		IconTreeNode node2 = new IconTreeNode(null, "歌曲下载", 2);
		tybNode1.add(node2);
		IconTreeNode node3 = new IconTreeNode(null, "我收藏的单曲", 1);
		tybNode2.add(node3);
		IconTreeNode node4 = new IconTreeNode(null, "我的歌单", 2);
		tybNode2.add(node4);
		IconTreeNode node5 = new IconTreeNode(null, "流行歌曲", 1);
		tybNode3.add(node5);
		IconTreeNode node6 = new IconTreeNode(null, "DJ舞曲", 2);
		tybNode3.add(node6);
		
		
		
		
		
		JTree jtree = new JTree(root);
		//隐藏根节点
		jtree.setRootVisible(false);
		//隐藏连接线
		jtree.putClientProperty("JTree.lineStyle", "None");
		//设置根节点是否打开或关,默认fasle
		jtree.setShowsRootHandles(true);
		//设置是否看拖动、编辑,默认为false
		jtree.setEditable(false);
		//设置单击几次展开数节点
		jtree.setToggleClickCount(1);
		jtree.setShowsRootHandles(false);//隐藏左侧小图标

		//自定义
		//jtree.setCellRenderer(new ImageCellRender());
		jtree.setCellRenderer(new IconNodeRenderer());
		
		this.setViewportView(jtree);
	}
	
}




//自定义DefaultMutableTreeNode
class IconTreeNode extends DefaultMutableTreeNode{
	private static final long serialVersionUID = 1L;
	protected Icon icon; 
	protected String txt; 
	protected int e_no;

	//只包含文本的节点构造
	public IconTreeNode(String txt){
		super();
		this.txt=txt;
	} 

	//包含文本和图片的节点构造
	public IconTreeNode(Icon icon,String txt,int e_no){
		super();
		this.icon = icon; 
		this.txt = txt;
		this.e_no = e_no;
	}
	public void setIcon(Icon icon){ 
		this.icon = icon; 
	} 

	public Icon getIcon() { 
		return icon; 
	} 

	public void setText(String txt){
		this.txt=txt;
	}

	public String getText()	{
		return txt;
	}

	public int getE_no() {
		return e_no;
	}

	public void setE_no(int e_no) {
		this.e_no = e_no;
	} 


}

//自定义DefaultTreeCellRenderer
class IconNodeRenderer extends DefaultTreeCellRenderer{//继承该类 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int e_no;

	//重写该方法
	public Component getTreeCellRendererComponent(JTree tree, Object value,boolean sel, 
			boolean expanded, boolean leaf, int row,boolean hasFocus)
	{ 
		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf,row, hasFocus); //调用父类的该方法 
		Icon icon = ((IconTreeNode) value).getIcon();//从节点读取图片
		String txt=((IconTreeNode) value).getText(); //从节点读取文本
		this.setIcon(icon);//设置歌曲图标
		this.setText(txt);//设置歌曲名称
		this.setE_no(row);//插入歌曲号
		this.setFont(new Font("宋体", Font.PLAIN, 15));
//		System.out.println("row: " + row);
		return this; 
	}

	public int getE_no() {
		return e_no;
	}

	public void setE_no(int e_no) {
		this.e_no = e_no;
	}

}