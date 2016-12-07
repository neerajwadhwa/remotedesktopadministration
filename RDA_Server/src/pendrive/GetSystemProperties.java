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


import java.util.*;

class  GetSystemProperties{
  public static void main(String[] args) {
  Properties prop = System.getProperties();
    Enumeration keys = prop.keys();
    while (keys.hasMoreElements()) {
    String key = (String)keys.nextElement();
    String value = (String)prop.get(key);
    //System.out.println(key + ": " + value);
   }
  }
} 
