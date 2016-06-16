package com.icloud.louiscaubet.raspflow.api;

import java.io.IOException;

public class Motion {
	
	private static final String DIRECTORY = "/home/pi/Desktop/GoPiGo/Software/Java/RaspFlow/";
	
	public static void forward() throws IOException {
		new ProcessBuilder("python", DIRECTORY + "forward.py").start();
	}
	
	public static void backward() throws IOException {
		new ProcessBuilder("python", DIRECTORY + "backward.py").start();
	}
	
	public static void left() throws IOException {
		new ProcessBuilder("python", DIRECTORY + "left.py").start();
	}
	
	public static void right() throws IOException {
		new ProcessBuilder("python", DIRECTORY + "right.py").start();
	}
	
	public static void leftRotate() throws IOException {
		new ProcessBuilder("python", DIRECTORY + "left_rotation.py").start();
	}
	
	public static void rightRotate() throws IOException {
		new ProcessBuilder("python", DIRECTORY + "right_rotation.py").start();
	}
	
	public static void decreaseSpeed() throws IOException {
		new ProcessBuilder("python", DIRECTORY + "decrease_speed.py").start();
	}
	
	public static void increaseSpeed() throws IOException {
		new ProcessBuilder("python", DIRECTORY + "increase_speed.py").start();
	}
	
	public static void setLeftSpeed(int speed) throws IOException {
		new ProcessBuilder("python", DIRECTORY + "set_left_speed.py", "" + speed).start();
	}
	
	public static void setRightSpeed(int speed) throws IOException {
		new ProcessBuilder("python", DIRECTORY + "set_right_speed.py", "" + speed).start(); 
	}
	
	public static void setSpeed(int speed) throws IOException {
		new ProcessBuilder("python", DIRECTORY + "set_speed.py", "" + speed).start();
	}
	
	public static void stop() throws IOException {
		new ProcessBuilder("python", DIRECTORY + "stop.py").start();
	}

}
