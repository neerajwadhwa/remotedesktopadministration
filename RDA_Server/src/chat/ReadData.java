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
import java.io.BufferedReader;

//ReadData class monitors the network input
class ReadData extends Thread
{
  MyFrame f;  BufferedReader in;

 ReadData(MyFrame f, BufferedReader in)
 {
    this.f = f;
    this.in = in;

 }                     // end of constructor

  @Override
  public void run()    // Overridden
  {
   while(true)
   {
     try
     {
       // Read Data from the NW
          String str = in.readLine();

          if(str == null)
          {
            break;
          }


        // Place data into the Frame's TextArea
           f.t2.append("\r\nsrvr: "+str);

       }
       catch(Exception ex)
       {
         System.out.println("Error: "+ex);
         break;
       }
     }                       // end of while()

  // close the Socket
    try
    {
      f.s.close();
    }
    catch(Exception ex)
    {
      System.out.println("Error: "+ex);
    }

  }                    // end of run()
}                      // end of class ReadData