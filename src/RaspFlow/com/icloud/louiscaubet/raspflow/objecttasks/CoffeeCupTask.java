package com.icloud.louiscaubet.raspflow.objecttasks;

//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//import java.util.Scanner;
//
//import com.icloud.louiscaubet.raspflow.ObjectDetector;
//import com.icloud.louiscaubet.raspflow.RaspFlow;
import com.icloud.louiscaubet.raspflow.api.Motion;
//import com.icloud.louiscaubet.raspflow.tensorflow.DetectableObject;
//import com.icloud.louiscaubet.raspflow.tensorflow.TensorFlowExecutor;
//import com.icloud.louiscaubet.raspflow.tensorflow.TensorFlowLogInterpreter;

public class CoffeeCupTask implements Runnable {
	
//	private static RaspFlow raspflow = RaspFlow.getInstance();
	
//	private boolean followCup = true;

	@Override
	public void run() {
		
		try {
			
			Motion.setSpeed(255);
			Motion.rightRotate();
			Thread.sleep(50000);
			Motion.stop();
			
		}
		catch (Exception e){
			
		}
		
		/*
		raspflow.setGoPiGoClassicMove(false);
		ObjectDetector.pause = true;
		
		System.out.println("Coffee Cup detected. Following cup. To stop, type \"stop\".");
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				Scanner scan = new Scanner(System.in);
				
				while (true) {
					
					if(scan.next() != null){
						if(scan.next().equals("stop")){
							followCup = false;
							break;
						}
					}
					
				}
				
				scan.close();
				
			}
		}).start();
		
		while (followCup) {
			
			boolean foundCup = false;
			
			raspflow.getCamera().takePicture("/home/pi/Desktop/Software/Java/RaspFlow/tmp/searchcup.jpg");
			
			File picture = new File("/home/pi/Desktop/Software/Java/RaspFlow/tmp/searchcup.jpg");
			
			List<String> log = new TensorFlowExecutor(picture).getOutput();
			
			picture.delete();
			
			
			for(String s : new TensorFlowLogInterpreter(log).getPossibleObjects()){
				if(DetectableObject.getByTensorFlowName(s) == DetectableObject.COFFEE_CUP){
					foundCup = true;
				}
			}
			
			if(foundCup){
				
				try {
					Motion.forward();
					
					Thread.sleep(500);
					
					Motion.stop();
				} 
				catch (IOException | InterruptedException e) {
					onExceptionCaught();
				}
				
			}
			else {
				
				try {
				
					int timePassed = 0;
					
					while(timePassed < 10000 && !foundCup){
						
						Motion.left();
						
						Thread.sleep(500);
						timePassed = timePassed + 500;
						
						Motion.stop();
						
						raspflow.getCamera().takePicture("/home/pi/Desktop/Software/Java/RaspFlow/tmp/searchcup.jpg");
						
						picture = new File("/home/pi/Desktop/Software/Java/RaspFlow/tmp/searchcup.jpg");
						
						log = new TensorFlowExecutor(picture).getOutput();
						
						picture.delete();
						
						for(String s : new TensorFlowLogInterpreter(log).getPossibleObjects()){
							if(DetectableObject.getByTensorFlowName(s) == DetectableObject.COFFEE_CUP){
								foundCup = true;
							}
						}
						
					}
					
					if(!foundCup){
						System.out.println("Coffee cup not found. Stopping search. ");
						followCup = false;
					}
					
				}
				catch(Exception e){
					onExceptionCaught();
				}
				
				
			}
			
			
		}
		
		stopFollowCup();
		*/

	}
	
	/*
	private void stopFollowCup(){
		raspflow.setGoPiGoClassicMove(true);
		ObjectDetector.pause = false;
	}
	
	private void onExceptionCaught(){
		System.out.println("Exception caught while following cup. Stopping Cup Follow");
		followCup = false;
	}*/

}
