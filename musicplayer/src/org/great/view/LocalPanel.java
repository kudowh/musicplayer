package org.great.view;

import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;
//包括左右两个panel：LocalLeftPanel、MostlyCenterPanel
public class LocalPanel extends JPanel {
	private LocalLeftPanel leftPanel;//客户端显示，左边panel
	private LocalRightPanel rightPanel;//客户端显示，右边panel

	public LocalPanel() {
		setLayout(null);
		
		leftPanel = new LocalLeftPanel();//本地列表的    左边的JTree分类列表   
		leftPanel.setBounds(0, 0, 200, 530);

		rightPanel = new LocalRightPanel();//右边的歌曲列表
		rightPanel.setBounds(200, 0, 800, 530);
		
		
		add(leftPanel);//左边的JTree分类列表   
		add(rightPanel);//右边的歌曲列表
	}
}
