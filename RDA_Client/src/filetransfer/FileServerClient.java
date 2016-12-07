/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filetransfer;

/**
 *
 * @author neeraj
 */
import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.*;
   import java.io.*;
   import java.net.*;
import javax.swing.*;

public class FileServerClient {

	
	String ip;
	int port;
	  
	File myfile;
	Frame myFrame = new Frame();

	
	public FileServerClient(String ip,int port)
	{
		
		this.ip=ip;
		this.port=port;
		
		try {
			
			this.receiveFileFromServer(ip,port);

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	public void receiveFileFromServer(String ip,int port) throws ClassNotFoundException, IOException{

		Socket sock = null;	
		       
		try {
			
			   sock = new Socket(ip, port);
			   
		    } catch (IOException e1) {
		    	
			e1.printStackTrace();
			
		       }

		System.out.println("Connection made (clientSide)");
		//recieve the file

		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(sock.getInputStream());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		/*file from server is deserialized*/
		myfile=(File)ois.readObject();

		/*deserialized file properties*/
		System.out.println("AbsolutePath: " + myfile.getAbsolutePath()); 
		System.out.println("FileName:" + myfile.getName() );
		System.out.println("lenght"  + myfile.length()); 


		FileDialog choo = new FileDialog(myFrame,"Choose File Destination",FileDialog.SAVE);
		choo.setDirectory(null);
		choo.setFile("enter file name here");
		choo.setVisible(true);


		String targetFileName = choo.getDirectory()+choo.getFile( )+".jpg" ;

		System.out.println("File will be saved to: " + targetFileName); 

		copyBytes(myfile, targetFileName);


	}//

	private void copyBytes(File originalFile, String targetFileName) throws IOException {

		FileInputStream in = null;
		FileOutputStream out = null;


		in = new FileInputStream(originalFile);
		out = new FileOutputStream(targetFileName);
		int c;

		while ((c = in.read()) != -1) {
			out.write(c);
		}

		out.close();
		in.close();

	}	
}
