  package com.icloud.louiscaubet.raspflow;

import java.io.IOException;
import java.util.Random;

import com.dexterind.gopigo.Gopigo;
import com.icloud.louiscaubet.raspflow.api.Camera;
import com.icloud.louiscaubet.raspflow.api.Motion;

public class RaspFlow {
	
	private static RaspFlow instance;
	
	private Gopigo gopigo;
	private Camera camera;
	
	private ObjectDetector objectDetector;
	
	private boolean gopigoRndmove;
	
	public RaspFlow(){
		
		onEnable();
		
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			
			@Override
			public void run() {
				instance.onDisable();
				
			}
		}));
		
	}
	
	public void onEnable(){
		
		gopigo = Gopigo.getInstance();
		camera = new Camera();
		
		gopigoRndmove = true;
		
		objectDetector = new ObjectDetector();
		
		while (true) {
			
			try {
				
				int distancetoObstacle = gopigo.ultraSonicSensor.getDistance();
				while(distancetoObstacle < 30){
					Motion.right();
					try {
						Thread.sleep(100);
					}
					catch(InterruptedException e){}
				}
				
				if(gopigoRndmove){
					int direction = new Random().nextInt(5);
					
					//Turn right
					if(direction == 0){
						Motion.rightRotate();
					}
					//Turn left
					else if (direction == 1){
						Motion.leftRotate();
					}
					//Go straight forward
					else {
						Motion.forward();
					}
				}
				
				
			} 
			catch (IOException e) {}
			
			if(!ObjectDetector.pause){
				objectDetector.run();
			}
			
			try {
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			
		}
		
	}
	
	public void onDisable(){
		System.out.println("Caught Ctrl + C signal. Shutting down ...");
	}
	
	public static RaspFlow getInstance(){
		return instance;
	}
	
	public Gopigo getGoPiGo(){
		return this.gopigo;
	}
	
	public void setGoPiGoClassicMove(boolean arg){
		gopigoRndmove = arg;
	}
	
	public Camera getCamera(){
		return this.camera;
	}
	
	public void startObjectDetector(){
		ObjectDetector.pause = false;
	}
	
	public void stopObjectDetector(){
		ObjectDetector.pause = true;
	}
	
	
	public static void main(String[] args){
		instance = new RaspFlow();
	}

}
