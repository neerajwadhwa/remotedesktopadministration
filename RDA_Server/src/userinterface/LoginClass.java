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

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginClass {
	
	JFrame jframe;
	JPanel jpanel;
	JLabel username,password,login;
	JTextField user;
	JPasswordField UserPassword;
	JButton loginuser,signup;
	
	
	
	
	public LoginClass()
	{
		
		
		jframe =new JFrame();
		jpanel = new JPanel();
		jpanel.setLayout(null);
		
		login= new JLabel("LOGIN PAGE");
		login.setBounds(900, 10, 200, 60);
		jpanel.add(login);
		
		
		username=new JLabel("USER NAME :- ");
		username.setBounds(800, 100, 150, 20);
		jpanel.add(username);
		
		
		user=new JTextField();
		user.setBounds(900, 100, 150, 25);
		jpanel.add(user);
		
		password=new JLabel("PASSWORD:- ");
		password.setBounds(800, 200, 150, 20);
		jpanel.add(password);
		
		UserPassword=new JPasswordField();
		UserPassword.setBounds(900, 200, 150, 25);
		jpanel.add(UserPassword);
		
		loginuser=new JButton("LOGIN");
		loginuser.setBounds(900,300, 100, 20);
		loginuser.addActionListener(new loginbutton());
		jpanel.add(loginuser);
		
		signup=new JButton("SIGN UP");
		signup.setBounds(900, 350, 100, 20);
		signup.addActionListener(new signupbutton());
		jpanel.add(signup);
		
		jframe.add(jpanel);
		jframe.setVisible(true);
		jframe.setSize(jframe.getToolkit().getScreenSize());
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	
	
	class loginbutton implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			
			String us=user.getText();
			System.out.println(us);
			
			String pw=UserPassword.getText();
			System.out.println(pw);
			
			if(us.equals("") || pw.equals(""))
			{
				
				JOptionPane.showMessageDialog(null, "Please enter user name or password");
			}
			
			else
			{
				//Connection conn= DataBaseConnection.javaConnection();
				{
					try {
						//Statement st=conn.createStatement();
						//String ss="select* from login where username='"+us+"' and password='"+pw+"'";
						//ResultSet res=st.executeQuery(ss);
						
						//if(res.next())
						if(true)
						{
							
							jframe.dispose();
							int port = Integer.parseInt(JOptionPane.showInputDialog("Please enter listening port"));
							new Modules(port);
						}
						/*
						else
						{
							
							JOptionPane.showMessageDialog(null, "incorrect user name or password");
							jframe.dispose();
							new LoginClass();
						}
						*/
					} catch (Exception e2) {
						// TODO: handle exception
					}
					
						}
				
			}
			
		}
		
	}
	
	class signupbutton implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			jframe.dispose();
			new SignUp();
			
		}
}
}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		
		


