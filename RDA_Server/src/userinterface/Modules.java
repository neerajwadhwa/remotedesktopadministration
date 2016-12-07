/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface;

/**
 *
 * @author neeraj
 */

import pendrive.*;
import chat.*;
import filetransfer.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import control.Server.Server;
import control.Server.UserInterface;

import properties.srvr.DateClient;

import showdesktop.ServerInitiator;

public class Modules  {
	
	public static int port;
    public static JFrame jframe;
	JPanel jpanel;
	JLabel rda;
	JButton chat,fileTransfer,systemProperities,showDesktop,pendriveDetection,remoteControl;
	 
	 
	 public Modules(int port)
	 {
		 this.port=port;
		 
		 jframe=new JFrame();
		 jpanel=new JPanel();
		 jpanel.setLayout(null);
		 
		 
		 rda=new JLabel("REMOTE        DESKTOP      ADMINISTRATOR");
		 rda.setBounds(800, 70, 400, 100);
		 jpanel.add(rda);
		 
		 chat=new JButton("CHAT");
		 chat.setBounds(850, 200, 140, 50);
		 jpanel.add(chat);
		 chat.addActionListener(new ChatButton());
		 
		 
		 systemProperities=new JButton("SYSTEM PROPERITIES");
		 systemProperities.setBounds(850, 300, 140, 50);
		 jpanel.add(systemProperities);
		 systemProperities.addActionListener(new SystemProperties());
		 
		 fileTransfer=new JButton("FILE TRANSFER");
		 fileTransfer.setBounds(850, 400, 140, 50);
		 jpanel.add(fileTransfer);
		 fileTransfer.addActionListener(new FileTransfer());
		 
		 
		 showDesktop=new JButton("REMOTE DESKTOP");
		showDesktop.setBounds(850, 500, 140, 50);
		 jpanel.add(showDesktop);
		 showDesktop.addActionListener(new ShowDesktop());
		 
		 pendriveDetection=new JButton("PEN DRIVE DETECTION");
		 pendriveDetection.setBounds(850, 600, 140, 50);
		 jpanel.add(pendriveDetection);
		 pendriveDetection.addActionListener(new PenDriveDetection());
		 
		 
		 remoteControl=new JButton("REMOTE CONTROL");
		 remoteControl.setBounds(850, 650, 140, 50);
		 jpanel.add(remoteControl);
		 remoteControl.addActionListener(new RemoteControl());
			
			jframe.add(jpanel);
			jframe.setVisible(true);
			jframe.setSize(jframe.getToolkit().getScreenSize());
			jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
	 }

}

class ChatButton implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		new ChatServer(Modules.port);
	}
	
}



class ShowDesktop implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		Modules.jframe.dispose();
		new ServerInitiator(Modules.port);
	}
	
}


class FileTransfer implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		String fileName=JOptionPane.showInputDialog("enter the file path");		
		try {
			
			new FileServer(Modules.port, fileName);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}



class PenDriveDetection implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		try {
			
			new PServer(Modules.port);    //this class extends thread class so we need to surround try catch
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}


class SystemProperties implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		new DateClient(Modules.port);
	}
	
}


class RemoteControl implements ActionListener
{
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	try {
		
		Modules.jframe.dispose();
		Server s=new Server(Modules.port);
		UserInterface u=new UserInterface();
		//u.setVisible(true);
		//u.setSize(500,200);
		//u.setResizable(false);
		//Server s=new Server(u,Modules.port);
		//s.connect();
		
		
		   /*
		    UserInterface u=new UserInterface();
		    Server s=new Server(u,Modules.port);
		    s.connect();
		*/
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
	
}
























