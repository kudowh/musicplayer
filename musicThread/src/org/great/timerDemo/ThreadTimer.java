package org.great.timerDemo;

import java.util.Date;
import java.util.Timer;

public class ThreadTimer {

	public static void main(String[] args) {
		Timer timer = new Timer();
		MyTimerTask mt = new MyTimerTask();
		System.out.println("main: " + new Date());
		timer.schedule(mt, 1000,2000);
	}
}
