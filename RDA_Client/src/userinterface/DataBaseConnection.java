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

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection{
	
		final static private String url = "jdbc:mysql://localhost:3308/";
		final static private String driver = "com.mysql.jdbc.Driver";
		final static private String db = "rda"; //Schema Name
		final static private String pass = "root";//DB Pasword
		final static private String user = "root";//DB UserName
		
		public static Connection javaConnection()
		{
			Connection conne=null;
			try {
				Class.forName(driver).newInstance();
				conne = (Connection) DriverManager.getConnection(url + db,user, pass);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return conne;
			
		}
		
	 
}
