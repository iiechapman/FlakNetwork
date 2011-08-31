package com.vindince.flak;

import org.lwjgl.input.Keyboard;

public class GameInput {
	
	public static boolean W,A,S,D;
	public static boolean UP,DOWN,LEFT,RIGHT;
	public static boolean ENTER;
	
	
	public static void poll(){
		
		while (Keyboard.next()){

				switch (Keyboard.getEventKey()){
				
				
				case Keyboard.KEY_W:
					W = Keyboard.getEventKeyState();
					break;
					
				case Keyboard.KEY_A:
					A = Keyboard.getEventKeyState();
					break;
					
				case Keyboard.KEY_S:
					S = Keyboard.getEventKeyState();
					break;
					
				case Keyboard.KEY_D:
					D = Keyboard.getEventKeyState();
					break;
					
				
				case Keyboard.KEY_UP:
					UP = Keyboard.getEventKeyState();
					break;
					
				case Keyboard.KEY_DOWN:
					DOWN = Keyboard.getEventKeyState();
					break;
						
					
				case Keyboard.KEY_LEFT:
					LEFT = Keyboard.getEventKeyState();
					break;
						
					
				case Keyboard.KEY_RIGHT:
					RIGHT = Keyboard.getEventKeyState();
					break;
					
				case Keyboard.KEY_RETURN:
					ENTER = Keyboard.getEventKeyState();
					break;
						
						
					
					
					
					
					
				default:
					break;
				
				
				
				}
	
				
				
				
				
				
				
			}
			
			
		}
		
	}
	
	

