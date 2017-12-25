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
		//����ʾˮƽ������
		this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );

		this.setBounds(0, this.getHeight(),this.getWidth(),(this.getHeight()-this.getHeight()-10));
		JButton jb = new JButton("hah");
		this.add(jb);
		//jTreeDemo();
		jtree();
	}
	private void jtree() {
		//root�ڵ�
		IconTreeNode root = new IconTreeNode(null,null,-1);
		//1.��ȡ�����б����������
		//2.���������б�ڵ�
		IconTreeNode tybNode1 = new IconTreeNode(null, "�ҵ�����", 1);
		root.add(tybNode1);
		IconTreeNode tybNode2 = new IconTreeNode(null, "�Ƹ赥", 2);
		root.add(tybNode2);
		IconTreeNode tybNode3 = new IconTreeNode(null, "���ظ���", 3);
		root.add(tybNode3);
		//3.����ӽڵ��ȡ����б������еĸ���
		IconTreeNode node = new IconTreeNode(null, "��������", 1);
		tybNode1.add(node);
		IconTreeNode node2 = new IconTreeNode(null, "��������", 2);
		tybNode1.add(node2);
		IconTreeNode node3 = new IconTreeNode(null, "���ղصĵ���", 1);
		tybNode2.add(node3);
		IconTreeNode node4 = new IconTreeNode(null, "�ҵĸ赥", 2);
		tybNode2.add(node4);
		IconTreeNode node5 = new IconTreeNode(null, "���и���", 1);
		tybNode3.add(node5);
		IconTreeNode node6 = new IconTreeNode(null, "DJ����", 2);
		tybNode3.add(node6);
		
		
		
		
		
		JTree jtree = new JTree(root);
		//���ظ��ڵ�
		jtree.setRootVisible(false);
		//����������
		jtree.putClientProperty("JTree.lineStyle", "None");
		//���ø��ڵ��Ƿ�򿪻��,Ĭ��fasle
		jtree.setShowsRootHandles(true);
		//�����Ƿ��϶����༭,Ĭ��Ϊfalse
		jtree.setEditable(false);
		//���õ�������չ�����ڵ�
		jtree.setToggleClickCount(1);
		jtree.setShowsRootHandles(false);//�������Сͼ��

		//�Զ���
		//jtree.setCellRenderer(new ImageCellRender());
		jtree.setCellRenderer(new IconNodeRenderer());
		
		this.setViewportView(jtree);
	}
	
}




//�Զ���DefaultMutableTreeNode
class IconTreeNode extends DefaultMutableTreeNode{
	private static final long serialVersionUID = 1L;
	protected Icon icon; 
	protected String txt; 
	protected int e_no;

	//ֻ�����ı��Ľڵ㹹��
	public IconTreeNode(String txt){
		super();
		this.txt=txt;
	} 

	//�����ı���ͼƬ�Ľڵ㹹��
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

//�Զ���DefaultTreeCellRenderer
class IconNodeRenderer extends DefaultTreeCellRenderer{//�̳и��� 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int e_no;

	//��д�÷���
	public Component getTreeCellRendererComponent(JTree tree, Object value,boolean sel, 
			boolean expanded, boolean leaf, int row,boolean hasFocus)
	{ 
		super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf,row, hasFocus); //���ø���ĸ÷��� 
		Icon icon = ((IconTreeNode) value).getIcon();//�ӽڵ��ȡͼƬ
		String txt=((IconTreeNode) value).getText(); //�ӽڵ��ȡ�ı�
		this.setIcon(icon);//���ø���ͼ��
		this.setText(txt);//���ø�������
		this.setE_no(row);//���������
		this.setFont(new Font("����", Font.PLAIN, 15));
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