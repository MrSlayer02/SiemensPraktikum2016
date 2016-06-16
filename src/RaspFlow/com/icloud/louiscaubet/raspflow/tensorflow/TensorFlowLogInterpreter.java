package com.icloud.louiscaubet.raspflow.tensorflow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TensorFlowLogInterpreter {
	
	//The most probable objects recognized by Inception
	private List<String> possibleObjects;
	
	/**
	 * Creates a list of possible objects
	 * @param log The classify_image.py output
	 */
	public TensorFlowLogInterpreter(List<String> log) {
		
		try {
			String line1 = log.get(0);
			//Remove score and split by , to get a list of possible objects.
			possibleObjects = new ArrayList<>(Arrays.asList(line1.split("\\(")[0].split(",")));
		}
		catch(IndexOutOfBoundsException e){
			//If there is no line in log.
			possibleObjects = new ArrayList<String>();
		}
		
		if(possibleObjects.size() <=1 ){
			try {
				String line2 = log.get(1);
				//Same as before
				possibleObjects.addAll(Arrays.asList(line2.split("\\(")[0].split(",")));
			}
			catch(IndexOutOfBoundsException e){
				//If there is no second line in code
			}
		}

	}
	
	public List<String> getPossibleObjects(){
		return possibleObjects;
	}

}
