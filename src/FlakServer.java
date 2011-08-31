

import java.net.*;
import java.io.*;



/* Flak Server Prototype
 * 
 * Every Character has a unique GUID
 * Under the GUID they have X, Y , Size and RGB colors 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 *
*/


public class FlakServer {

	public static int connectionCount = 0;
	public static PrintWriter out = null;
	public static BufferedReader in = null;
	public static String inputLine, outputLine;
	
	public static ServerSocket serverSocket = null;
	public static Socket clientSocket = null;
	
	
	
	public static void main(String[] args){
		

		try{
			
			serverSocket = new ServerSocket(8888);
			System.out.println("Attempting to listen on port 8888");
			
		} catch(IOException e){
			
			e.printStackTrace();
			System.err.println("Could not listen on port 8888");
			System.exit(-1);
			
			
		}
	
		System.out.println("Listening on port 8888");
		
		
		try{
			
		System.out.println("Waiting for client to connect...");
		clientSocket = serverSocket.accept();

		
		} catch (IOException e){
			
			e.printStackTrace();
			System.err.println("Failed to connect to client...");
			System.exit(-1);
			
			
		}
		
		try{
			

		out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		System.out.println("NEW LINE to open communication with client...");
	

		


		} catch (IOException e){
			
			e.printStackTrace();
			System.err.println("Connection terminated...");
			System.exit(-1);
			
		}
		
		out.println("Hello world...");
		
		System.out.println("Connection Succesfull...");

		
		System.out.println("Begin Open Communication...");
		/*
		try {
			while ((inputLine = in.readLine()) != null){
				
				System.out.println(inputLine);
				
				
			}
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		*/
		
		try{
			out.close();
			in.close();
			clientSocket.close();
			serverSocket.close();
		} catch (IOException e){
			
			e.printStackTrace();
			System.exit(-1);
			
		}
		
			

		
	}//end main
	
}//end class
		
	

























		
	
	
