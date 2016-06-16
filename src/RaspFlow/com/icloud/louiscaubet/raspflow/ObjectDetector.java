package com.icloud.louiscaubet.raspflow;

import java.io.File;
import java.util.List;

import com.icloud.louiscaubet.raspflow.api.Camera;
import com.icloud.louiscaubet.raspflow.tensorflow.DetectableObject;
import com.icloud.louiscaubet.raspflow.tensorflow.TensorFlowExecutor;
import com.icloud.louiscaubet.raspflow.tensorflow.TensorFlowLogInterpreter;

public class ObjectDetector implements Runnable {
	
	public static boolean pause;

	@Override
	public void run() {

		String path = "/home/pi/Desktop/GoPiGo/Software/Java/RaspFlow/tmp/image.jpg";
		File file = new File(path);
		
		if(file.exists()){
		//	file.delete();
		}
		
		file.getParentFile().mkdirs();
		
		new Camera().takePicture(path);
		List<String> log = new TensorFlowExecutor(new File(path)).getOutput();
		
		List<String> imageRepresents = new TensorFlowLogInterpreter(log).getPossibleObjects();
		DetectableObject object = null;
		for(String s : imageRepresents){
			System.out.println("[DEBUG] Image could represent : " + s);
			if(DetectableObject.getByTensorFlowName(s) != null){
				object = DetectableObject.getByTensorFlowName(s);
				break;
			}
		}
			
		if(object != null){
			System.out.println("[INFO] Detected " + object.getName() + " !" + "Executing associated task.");
			object.getAssociatedTask().run();
		}
		else {
			System.out.println("[INFO] No associated task for this object .");
		}
		
	}

}
