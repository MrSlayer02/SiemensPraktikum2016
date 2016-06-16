package com.icloud.louiscaubet.raspflow.tensorflow;

import com.icloud.louiscaubet.raspflow.objecttasks.CoffeeCupTask;
import com.icloud.louiscaubet.raspflow.objecttasks.ComputerTask;

public enum DetectableObject {
	
	COFFEE_CUP("coffee_cup", new CoffeeCupTask(), " cup "),
	COMPUTER("computer", new ComputerTask(), "computer");
	
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
