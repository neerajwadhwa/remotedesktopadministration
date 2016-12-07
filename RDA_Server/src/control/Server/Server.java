/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control.Server;

/**
 *
 * @author neeraj
 */

import java.net.*;
import java.util.*;
public class Server
{
	int port;
	ServerSocket server;
	UserInterface in;
	HashMap v=new HashMap();
	Socket s;
//public Server(UserInterface in,int port)
public Server(int port)
	{
		//this.in=in;
		this.port=port;
		
	try{
			v.clear();
			server = new ServerSocket(port);
	   }
	catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void connect()throws Exception
	{
	while(true)
		{
			s=server.accept();
			v.put(s.getInetAddress(),s);
			//MultiThreaded m=new MultiThreaded(server,in,v);
		}	
	}
}
