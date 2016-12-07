/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlclient;

/**
 *
 * @author neeraj
 */
import java.io.*;
import java.net.*;
public class ControlClient
{
	
	   String ip;
	   int port;
	
       Socket s;
       BufferedReader br1;
       
public ControlClient(int port)
	{
	
	this.port=port;
	
	try
		{
			br1 = new BufferedReader(new FileReader("/home/neeraj/IPaddress.txt"));
			String add=br1.readLine();

			s = new Socket(add,port);
			BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
			PrintWriter out=new PrintWriter(s.getOutputStream(),true);

			System.out.println("Client : i am ready");
			String s=br.readLine();
			Runtime.getRuntime().exec(s);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}