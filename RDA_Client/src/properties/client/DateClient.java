/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package properties.client;

/**
 *
 * @author neeraj
 */

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.Properties.*;


import javax.swing.JOptionPane;

public class DateClient {
	
	String ip;
	int port;
	
  public DateClient(String ip,int port)
  {
	  
	  this.ip=ip;
	  this.port=port;
	  
      ObjectOutputStream oos = null;
      ObjectInputStream ois = null;
      Socket socket = null;
      String date = "";
      try {
        // open a socket connection
          socket = new Socket(ip, port);
        // open I/O streams for objects
        oos = new ObjectOutputStream(socket.getOutputStream());
        ois = new ObjectInputStream(socket.getInputStream());
        // read an object from the server
        System.out.println("wait????????????");
        int i;
        i=0;
        //get prop
        while(i<30)
        {
        date = (String) ois.readObject();
       
        System.out.println(date);
        i++;
        }
        System.out.println("end of client");
        
        /*Properties prop = System.getProperties();
	    Enumeration keys = prop.keys();
	    while (keys.hasMoreElements())
	    {
	    String key = (String)keys.nextElement();
	    String value = (String)prop.get(key);
	    //System.out.println(key + ": " + value);
	    }*/
        
        
       // System.out.print("The date is: " + date);
        oos.close();
        ois.close();
      } catch(Exception e) {
        System.out.println(e.getMessage());
      }
   }
}
