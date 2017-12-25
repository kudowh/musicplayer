package org.great.timerDemo;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.Timer;

public class TimerSwing extends JFrame{

	
	public TimerSwing() throws HeadlessException {
		this.setSize(200, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new TimerSwing();
		System.out.println("Timerǰ: " + new Date());
		Timer t = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(new Date());
				System.out.println("jkljl");
			}
		});
		t.start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
