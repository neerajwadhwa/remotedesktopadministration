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

import java.io.*;
import java.net.*;
import java.util.*;
public class MultiThreaded extends Thread
{
	
	ServerSocket server;
	Socket soc;
	int i=0;
	UserInterface in;
	HashMap v;
	public MultiThreaded(ServerSocket server,UserInterface in,HashMap v)
	{
			this.in=in;
			this.server=server;
			this.v=v;
			//start();
	}
	
	public void run()
	{
		
		//in.call(v);
		
	}	
}


