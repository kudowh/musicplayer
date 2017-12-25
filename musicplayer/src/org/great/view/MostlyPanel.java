package org.great.view;


import java.awt.BorderLayout;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.great.listener.MostlyListener;
import org.great.util.IconImage;

public class MostlyPanel extends JPanel{
	public static MyButton gb;
	private MostlyUpPanel upPanel;
	private MostlyDownPanel downPanel;
	private LocalLeftPanel leftPanel;
	public static MostlyCenterPanel rightPanel;
	public static MostlyCenterPanel centerPanel;
	public MostlyPanel() {
		this.setLayout(null);
		
		upPanel = new MostlyUpPanel();
		upPanel.setBounds(0, 0, 1000, 60);
		upPanel.setOpaque(false);
		add(upPanel);//����
		
		downPanel = new MostlyDownPanel();
		downPanel.setBounds(0, 590, 1000, 60);
		downPanel.setOpaque(false);
		add(downPanel);//����
		
		centerPanel = new MostlyCenterPanel();//��������˺Ϳͻ��˵Ľ�������б���ʾ
		centerPanel.setBounds(0, 60, 1000, 530);
		add(centerPanel);//����
		
//		leftPanel = new LocalLeftPanel();
//		leftPanel.setBounds(0, 60, 200, 530);
//		add(leftPanel);//����
//		
//		rightPanel = new MostlyCenterPanel();
//		rightPanel.setBounds(200, 60, 800, 530);
//		add(rightPanel);//����
//		rightPanel.setVisible(false);
		
	}
	@Override
	protected void paintComponent(Graphics g) {
//		ImageIcon icon=new ImageIcon("img/123.png");
		g.drawImage(IconImage.back.getImage(), 0, 0, this.getWidth(), this.getHeight(), this);
	}
}