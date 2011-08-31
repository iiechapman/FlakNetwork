

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
	
	
	
	public static void main(String[] args){
		
		PrintWriter out = null;
		BufferedReader in = null;
		String inputLine, outputLine;
		
		ServerSocket serverSocket = null;
		Socket clientSocket = null;
		
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
		

		
			

		
	}//end main
	
}//end class
		
	
		
	
	
