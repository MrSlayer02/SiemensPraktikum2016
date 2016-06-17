package com.icloud.louiscaubet.raspflow.tensorflow;

import com.icloud.louiscaubet.raspflow.objecttasks.CoffeeCupTask;
import com.icloud.louiscaubet.raspflow.objecttasks.IPhoneTask;
import com.icloud.louiscaubet.raspflow.objecttasks.KeyboardTask;
import com.icloud.louiscaubet.raspflow.objecttasks.WaterJugTask;

public enum DetectableObject {
	
	IPHONE("iphone", new IPhoneTask(), "cellular telephone", "cellular phone", "cellphone", "mobile phone", "iPod"),
	WATERJUG("water jug", new WaterJugTask(), "teapot", "water jug", "teapot "), 
	KEYBOARD("keyboard", new KeyboardTask(), "computer keyboard", "keypad"),
	COFFEE_CUP("Coffee Cup", new CoffeeCupTask(), "cup", "coffee mug", "coffee mug ", "cup ");
	
	private String[] tensorflownames;
	private String name;
	private Runnable associatedTask;
	
	private DetectableObject(String name, Runnable associatedTask, String... tensorflownames){
		this.tensorflownames = tensorflownames;
		this.name = name;
		this.associatedTask = associatedTask;
	}
	
	public String[] getTensorFlowNames(){
		return this.tensorflownames;
	}
	
	public String getName(){
		return this.name;
	}
	
	public Runnable getAssociatedTask(){
		return this.associatedTask;
	}
	
	public static DetectableObject getByTensorFlowName(String name){
		
		for(DetectableObject object : DetectableObject.values()){
			
			for(String s : object.getTensorFlowNames()){
				if(s.contains(name)){
					return object;
				}
			}
			
		}
		
		return null;
		
	}

}
