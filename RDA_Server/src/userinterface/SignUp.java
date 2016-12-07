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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SignUp {
	
	JFrame frame;
	JPanel panel;
	JLabel registrationForm;
	JLabel name;
	JTextField nme;JLabel password;
	JPasswordField pasWrd;
	JLabel dateofBirth;
	JComboBox date,month,year;
	JLabel gender;
	JRadioButton male,female;
	ButtonGroup bg;
	JButton sbmit,bck,rest;
	
	
	public SignUp()
	{
		
		
		frame=new JFrame();
		panel=new JPanel();
panel.setLayout(null);

		registrationForm=new JLabel("REGISTRATION FORM");
		registrationForm.setBounds(800, 5, 900, 100);
		panel.add(registrationForm);
		
		name=new JLabel("NAME   :-");
	name.setBounds(600, 110,60, 60);
	panel.add(name);
	
	nme=new JTextField();
	nme.setBounds(800, 120, 170, 30);
	panel.add(nme);
	
	password=new JLabel("PASSWORD");
	password.setBounds(600, 190,120, 60);
	panel.add(password);
	
	pasWrd=new JPasswordField();
	pasWrd.setBounds(800, 190, 170, 30);
	panel.add(pasWrd);

gender=new JLabel("GENDER   :-");
gender.setBounds(600, 260, 150, 50);
panel.add(gender);
male=new JRadioButton("Male");
male.setBounds(800, 260,80,40);


female=new JRadioButton("Female");
female.setBounds(880, 260,80,40);


bg=new ButtonGroup();
bg.add(male);
bg.add(female);
panel.add(male);
panel.add(female);

dateofBirth=new JLabel("date of birth   :-");
dateofBirth.setBounds(600,330, 150, 50);
panel.add(dateofBirth);

date=new JComboBox();
date.setBounds(800,340, 50,30 );

for(int i=1;i<=31;i++)
{
	   date.addItem(i);
}
panel.add(date);


month=new JComboBox();
month.setBounds(870, 340, 50, 30);
   for(int i=1;i<=12;i++)
   {
 	  month.addItem(i);
   }
   panel.add(month);
   
  
   year=new JComboBox();
   year.setBounds(940, 340, 80, 30);
   for(int i=1970;i<=2016;i++)
   {
 	  year.addItem(i);
   }	      
   panel.add(year);

 

	sbmit=new JButton("SUBMIT");
	sbmit.setBounds(700, 550, 80, 50);
    sbmit.addActionListener(new submit());
	panel.add(sbmit);
	
	
	rest=new JButton("RESET");
	rest.setBounds(825, 550, 80, 50);
	rest.addActionListener(new reset());
    panel.add(rest);
	
	bck=new JButton("BACK");
	bck.setBounds(950, 550, 80, 50);
	bck.addActionListener(new back());
    panel.add(bck);
    


		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(frame.getToolkit().getScreenSize());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
class submit implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		String name=nme.getText();
		System.out.println("name "  +name);
		
		String ps=pasWrd.getText();
		System.out.println(" " +ps);


  
		String gender="";
      
		if(male.isSelected())
		{
			gender="Male";
		}
		else if(female.isSelected())
		{
			gender="Female";
		}
		System.out.println(gender);

		

		int date1=(int) date.getSelectedItem();
		int month1=(int) month.getSelectedItem();
		int year1=(int) year.getSelectedItem();
		String dmy=date1+"-" +month1 +"-" +year1;
       System.out.println(dmy);

 if(name.equals("") || ps.equals("") )
 {
	 JOptionPane.showMessageDialog(null, "plz fill username and password");
	 
 }
 
 else if(ps.length() > 10 ||ps.length() < 3)	  
 {
	 JOptionPane.showMessageDialog(null, "password field contain 6 to 10 character");
	 
	 pasWrd.setText("");
 }
 else if( gender.isEmpty())
 {
	 JOptionPane.showMessageDialog(null, "plz select a gender");
 }
 
 else
 {
	 
	 Connection conn= DataBaseConnection.javaConnection();
	 {
		 try {
			 Statement st=conn.createStatement();
			 String ss="select * from login where username='"+name+"' and password='"+ps+"'";
			 ResultSet dd=st.executeQuery(ss);
			 if(dd.next())
			 {
				 JOptionPane.showMessageDialog(null, "Duplicate entries");
			 }
			 
			 else
			 {
				 
				 String ff="insert into registration(username,password,gender,dob) values('"+name+"','"+ps+"','"+gender+"','"+dmy+"')";
                 String gg="insert into login(username,password) values('"+name+"','"+ps+"')";
                 int i =st.executeUpdate(ff);
                 int j=st.executeUpdate(gg);
                 if(i==1 || j==1)
                 {
                	 JOptionPane.showMessageDialog(null, "insert successfully");
                	 
                 }
                 
                 
                 nme.setText("");
         		pasWrd.setText("");
         		date.setSelectedIndex(0);
         		month.setSelectedIndex(0);
         		year.setSelectedIndex(0);
         		bg.clearSelection();
			 
			 }
			
		} catch (Exception e2) {
			// TODO: handle exception
		}
	 }
	 
 }

		
	};
}


class back implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		frame.dispose();
		new LoginClass();
	}
	
}


class reset implements ActionListener
{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		frame.dispose();
		new SignUp();
		
	}
	
}

}
