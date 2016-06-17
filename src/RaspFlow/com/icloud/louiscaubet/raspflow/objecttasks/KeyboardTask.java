package com.icloud.louiscaubet.raspflow.objecttasks;

import java.io.IOException;

import com.icloud.louiscaubet.raspflow.api.Motion;

public class KeyboardTask implements Runnable {

	@Override
	public void run() {
		
		try {
			Motion.setSpeed(255);
			Motion.left();
			Thread.sleep(10000);
			Motion.stop();
		} 
		catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
