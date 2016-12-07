/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendrive;

/**
 *
 * @author neeraj
 */

import java.io.*;
import java.net.Socket;


public class FindDrive
{

public static String msg(Socket client)
   {
   String[] letters = new String[]{ "A", "B", "C", "D", "E", "F", "G", "H", "I"};
   File[] drives = new File[letters.length];
   boolean[] isDrive = new boolean[letters.length];

   for ( int i = 0; i < letters.length; ++i )
       {
       drives[i] = new File(letters[i]+":/");

       isDrive[i] = drives[i].canRead();
       }

    System.out.println("FindDrive: waiting for devices...");

   
    while(true)
       {
     
       for ( int i = 0; i < letters.length; ++i )
           {
           boolean pluggedIn = drives[i].canRead();

          
           if ( pluggedIn != isDrive[i] )
             {
               if ( pluggedIn )
                  return ("PenDrive "+letters[i]+" has been plugged in\t"+client.getInetAddress());
               if(!pluggedIn)
                   return ("PenDrive "+letters[i]+" has been unplugged from\t"+client.getInetAddress());

              // isDrive[i] = pluggedIn;
             }
        }

    
       try { Thread.sleep(100); }
       catch (InterruptedException e) {  }

       }
   }
}