/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package showdesktop;

/**
 *
 * @author neeraj
 */

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This is the entry class of the server
 */
public class ServerInitiator {   
	
	int port;
    //Main server frame
    private JFrame frame = new JFrame();
    //JDesktopPane represents the main container that will contain all
    //connected clients' screens
    private JDesktopPane desktop = new JDesktopPane();

   public ServerInitiator(int port)
   {
       // String port = JOptionPane.showInputDialog("Please enter listening port");
	   
	   this.port=port;
	   
        this.initialize(port);
   }

    public void initialize(int port){

        try {
            ServerSocket sc = new ServerSocket(port);
            //Show Server GUI
            drawGUI();
            //Listen to server port and accept clients connections
            while(true){
                Socket client = sc.accept();
                System.out.println("New client Connected to the server");
                //Per each client create a ClientHandler
                new ClientHandler(client,desktop);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /*
     * Draws the main server GUI
     */
    public void drawGUI(){
            frame.add(desktop,BorderLayout.CENTER);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            //Show the frame in a maximized state
            frame.setExtendedState(frame.getExtendedState()|JFrame.MAXIMIZED_BOTH);
            frame.setVisible(true);
    }
}
