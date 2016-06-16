package com.icloud.louiscaubet.raspflow.tensorflow;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TensorFlowExecutor {
	
	private File image;
	
	private ArrayList<String> output;
	private ArrayList<String> errorLog;
	
	public TensorFlowExecutor(File image){
		
		this.image = image;
		output = new ArrayList<String>();
		errorLog = new ArrayList<String>();
		
		//Execute Inception v3 Python Code and get return
		try {
			
			String classify_image_path = "/home/pi/tensorflow/tensorflow/tensorflow/models/image/imagenet/classify_image.py";
			
			//Create ProcessBuilder for classify_image
			ProcessBuilder builder = new ProcessBuilder("python", classify_image_path, "--image_file=" + image.getAbsolutePath());
			//Redirect the Error Stream
			builder.redirectErrorStream(true);
			//Start the process
			final Process classify_image = builder.start();
			
			//While InputStream sends something, add it to output List.
			try {
				
				BufferedReader reader = new BufferedReader(new InputStreamReader(classify_image.getInputStream()));
				String line = "";
				
				try {
					
					//This will run until classify_image exits.
					while((line = reader.readLine()) != null){
						//A message thrown by classify_image, we don't want to add it to the output
						if(!line.contains("Op is deprecated")){
							if(!line.contains("Downloading")){ //Same for when Inception is being downloaded
								output.add(line);
							}
							//Print the stream of classify_image
							System.out.println("[DEBUG] [ClassifyImageOutput] " + line);
						}
					}
					
				}
				finally {
					reader.close();
				}
					
				
				
			}
			catch(IOException e){
				System.out.println("[ERROR] Something went wrong while classifying image " + image.getAbsolutePath());
				e.printStackTrace();
				System.exit(1);
			}
			
		
			
			classify_image.waitFor();
			
		}
		catch (Exception e){
			System.out.println("[ERROR] Something went wrong while classifying image " + image.getAbsolutePath());
			e.printStackTrace();
			System.exit(1);
		}
		
		System.out.println("[INFO] Image " + image.getAbsolutePath() + " successfully classified.");
		
	}
	
	public List<String> getOutput(){
		return output;
	}
	 
	public List<String> getErrorLog(){
		return errorLog;
	}
	
	public File getImage(){
		return image;
	}

}
