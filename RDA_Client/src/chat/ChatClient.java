/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chat;

/**
 *
 * @author neeraj
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.swing.JOptionPane;


  public class ChatClient
   {
	  
	  String ip;
	  int port;
            int flag = 1;
	  
     public ChatClient(String ip,int port)
     {
    	 
    		this.ip=ip;
    		this.port=port;
    	 
       try
       {
        
           BufferedReader stdin = new BufferedReader(
             new InputStreamReader(System.in));

            if(flag==1)
            {
	               Socket s = new Socket(ip,port);
	               System.out.println("Connected to : "+s.getInetAddress());
	               MyFrame f = new MyFrame(s);
	               f.setTitle("Client Side");
	               f.setBounds(400,50,300,200);
	               f.setVisible(true);
            }        
        
        }
        catch(Exception ex)
        {
          System.out.println("Error: "+ex);
        }

     }                           // end of main()
   }                             // end of class



  // MyFrame class : Provides GUI

  class MyFrame extends Frame implements ActionListener
  {
     Socket s; BufferedReader in; PrintWriter out;
     TextField t1;  TextArea t2;

     /*
     protected void processWindowEvent(WindowEvent e)
	 {
		 super.processWindowEvent(e);
		 if(e.getID()==WindowEvent.WINDOW_CLOSING)
		 {
			 System.exit(1);
		 }
	 }
     */
     
     MyFrame(Socket s)
     {
       this.s = s;
       setFont(new Font("SansSerif",Font.BOLD,14));

       t1 = new TextField();
       t2 = new TextArea();

       add(t1,BorderLayout.SOUTH);
       add(t2,BorderLayout.CENTER);

       t1.addActionListener(this);
       
       
       this.addWindowListener(new WindowAdapter() {
    	   
    	   public void windowClosing(WindowEvent e)
    	   {
    		   System.exit(0);
    	   }
	});
       try
       {
         // Get the Streams from the Socket connection

         in = new BufferedReader(new InputStreamReader
         (s.getInputStream()));
         
         out = new PrintWriter(s.getOutputStream());

          // Send the input stream to the Thread
          // i.e. send the in to the ReadData
            ReadData r = new ReadData(this,in);
            r.start();      // start the Thread

       }
       catch(Exception ex)
       {
         System.out.println("Error: "+ex);
       }
     }                  // end of MyFrame()

     public void actionPerformed(ActionEvent e)
     {
        if(e.getSource() == t1)
        {                              
          sendAcceptedData();
        }
     }                     // end of actionPerformed()


     void sendAcceptedData()
     {
        // Send the Accepted data to the connected system

         try
         {
           String str = t1.getText();

           t2.append("\r\nclient: "+str);
           t1.setText("");           // Remove data from t1

           out.write(str+"\r\n");   // Send to NW
           out.flush();

           t1.requestFocus();
         }
         catch(Exception ex)
         {
           System.out.println("Error: "+ex);
         }
      }                      // end of sendAcceptedData()
  }                          // end of class MyFrame



  
















