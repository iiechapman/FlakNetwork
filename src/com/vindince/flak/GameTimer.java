package com.vindince.flak;

import org.lwjgl.Sys;
import org.lwjgl.LWJGLException;






public class GameTimer {
	
	private static long startTime;
	private static long time;
	private static long prevTime;
	private static long deltaTime;
	private static int FPS;
	private static long lastFrameCheck;
	private static int currentFrames;
	
	public GameTimer(){
		
		startTime = getTime();
		
	}//end constructor





public long getTime(){ 
	time = (Sys.getTime() * 1000 / Sys.getTimerResolution()) - startTime;
	return time;}

public int getFPS(){
	
	if (getTime() - lastFrameCheck > 1000){
		FPS = currentFrames;
		currentFrames=0;	
		lastFrameCheck+=1000;
	}
	
	
	currentFrames++;
	return FPS;
}

public void start(){lastFrameCheck=getTime();}//Start FPS counter
public float deltaTime(){
	
	deltaTime = getTime() - prevTime;
	prevTime = getTime();
	return deltaTime;
}



}//end gametimer class