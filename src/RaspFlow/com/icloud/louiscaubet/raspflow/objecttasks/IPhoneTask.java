package com.icloud.louiscaubet.raspflow.objecttasks;

import com.icloud.louiscaubet.raspflow.api.Motion;

public class IPhoneTask implements Runnable {

	@Override
	public void run() {
		
		try {
			Motion.setSpeed(255);
			Motion.backward();
			Thread.sleep(3000);
			Motion.stop();
		}
		catch (Exception e){
			
		}
		
	}

}
