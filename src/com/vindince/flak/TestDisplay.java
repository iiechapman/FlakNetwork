package com.vindince.flak;


import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.*;


public class TestDisplay {
	
	public void start(){
		
		try{
			Display.setDisplayMode(new DisplayMode(800,600));
			Display.create();
			Display.setTitle("Flak Network Demo");
	
			
		}
		catch (LWJGLException e){
			
			e.printStackTrace();
			System.exit(0);
			
		}//end  create display
	
		//Setup OpenGL
		initOpenGL();
		
		
		while (!Display.isCloseRequested()){
		
	
			clearGL();
			drawQuad();
			
			Display.update();
		
		}//end loop
		
		
		Display.destroy();
		
		
	}//end start
	
	
	
	public static void main (String[] argv){
		
		TestDisplay newDisplay = new TestDisplay();
		
		newDisplay.start();
		
		
	}
	
	
	
	public void drawQuad(){
		
		//set color of quad
		glColor3f(0.5f,0.5f,0.5f);
		
		//start draw
		glBegin(GL11.GL_QUADS);
			glVertex2f(100,100);
			glVertex2f(100+200,100);
			glVertex2f(100+200,100+200);
			glVertex2f(100,100+200);
		glEnd();
	
	}//end draw quad
	
	
	public void initOpenGL(){
		
		glMatrixMode(GL11.GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0,800,600,0,1,-1);
		glMatrixMode(GL11.GL_MODELVIEW);
	
	}//end init GL
	
	
	
	public void clearGL(){
		
		glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		
	}//end clear gl
	
	
	
	
	

}//end class
