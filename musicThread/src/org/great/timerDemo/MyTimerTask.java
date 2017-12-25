package org.great.timerDemo;

import java.util.Date;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {

	@Override
	public void run() {
		System.out.println(new Date());
	}

}
