package com.icloud.louiscaubet.raspflow.objecttasks;

import com.icloud.louiscaubet.raspflow.api.Motion;

public class WaterJugTask implements Runnable {

	@Override
	public void run() {
		
		try {
			
			Motion.setSpeed(255);
			Motion.forward();
			Thread.sleep(6000);
			Motion.stop();
			
		}
		catch (Exception e){
			
		}

	}

}
