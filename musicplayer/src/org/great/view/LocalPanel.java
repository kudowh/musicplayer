package org.great.view;

import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JPanel;
//������������panel��LocalLeftPanel��MostlyCenterPanel
public class LocalPanel extends JPanel {
	private LocalLeftPanel leftPanel;//�ͻ�����ʾ�����panel
	private LocalRightPanel rightPanel;//�ͻ�����ʾ���ұ�panel

	public LocalPanel() {
		setLayout(null);
		
		leftPanel = new LocalLeftPanel();//�����б��    ��ߵ�JTree�����б�   
		leftPanel.setBounds(0, 0, 200, 530);

		rightPanel = new LocalRightPanel();//�ұߵĸ����б�
		rightPanel.setBounds(200, 0, 800, 530);
		
		
		add(leftPanel);//��ߵ�JTree�����б�   
		add(rightPanel);//�ұߵĸ����б�
	}
}
