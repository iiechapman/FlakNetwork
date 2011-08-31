package com.vindince.flak;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

import static org.lwjgl.opengl.GL11.*;






public class TestDisplay {
	
	float x 	= 100;
	float y 	= 100;
	float size 	= 100;
	float speed = 0.25f;
	float delta = 0;
	float red,green,blue;
	
	
   public  static Socket flakSocket = null;
   public  static PrintWriter    out = null;
   public  static BufferedReader in = null;
   public  static BufferedReader textIn = null;
   public  static String ipAddress = "192.168.1.11";

    
    
  
	
	public static int GUID = 0000;
	
	
	GameInput Input = new GameInput();
	GameTimer Timer = new GameTimer();
	
	
	public static void main (String[] argv){
		

        textIn = new BufferedReader(new InputStreamReader(System.in));
        
		
		TestDisplay newDisplay = new TestDisplay();
	
		newDisplay.start();
		
		
	}
	
	
	
	
	public void start(){
		
		
		
		
		red=green=blue = .5f;
		
		
		//create window
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
		
		connectToServer();
		
		
		
		
		//Main Loop
		while (!Display.isCloseRequested()){
		
	
			Timer.start();
			
			GameInput.poll();
			
			if (GameInput.W){y -= speed * delta ;}
			if (GameInput.A){x -= speed	* delta	;}
			if (GameInput.S){y += speed * delta ;}
			if (GameInput.D){x += speed * delta	;}
			
			
			if(GameInput.UP)	{size += speed * delta; green += .001f * delta; }
			if(GameInput.DOWN)	{size -= speed * delta; green -= .001f * delta; }
			
			
			
			if (GameInput.RIGHT) {red += .001f * delta; blue -= .001f * delta;}
			if (GameInput.LEFT)  {red -= .001f * delta; blue += .001f * delta;}
			

			try {
			if (in.readLine() !=null){
				
				System.out.println(in.readLine());
				
			}
			
			} catch (IOException e){
				
				e.printStackTrace();
				
			}
			
			
			
			clearGL();

			
			drawPlayerQuad();

			out.println(x + "," + y);
			
			Display.update();
			delta = Timer.deltaTime();
		
		}//end loop
		
		
		Display.destroy();
		
		
	}//end start
	
	
	
	
	
	

	public void connectToServer(){
		
		System.out.println("Connecting to server...");
		
        try {
            flakSocket = new Socket(ipAddress, 8888);
            out = new PrintWriter(flakSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(flakSocket.getInputStream()));
            
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host:" + ipAddress);
            System.exit(1);
            
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: IP.");
            System.exit(1);
        }
		
        System.out.println("Connection successful..");
	

        try{
        System.out.println(in.readLine());
        } catch (IOException e){
        	
        	System.err.println("Failed to communicate...");
        	
        }
	}

	
	
	
	public void drawPlayerQuad(){
		
		//set color of quad
		glColor3f(red,green,blue);
		
		//start draw
		glBegin(GL11.GL_QUADS);
			glVertex2f(x,y);
			glVertex2f(x+size,y);
			glVertex2f(x+size,y+size);
			glVertex2f(x,y+size);
		glEnd();
	
	}//end draw quad
	
	
	
	
	public void drawNPCQuad(float x, float y,float size,float red, float green, float blue){
		
		//set color of quad
		glColor3f(red,green,blue);
		
		//start draw
		glBegin(GL11.GL_QUADS);
			glVertex2f(x,y);
			glVertex2f(x+size,y);
			glVertex2f(x+size,y+size);
			glVertex2f(x,y+size);
		glEnd();
		
	}//end draw NPC quad
	
	
	
	
	
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
