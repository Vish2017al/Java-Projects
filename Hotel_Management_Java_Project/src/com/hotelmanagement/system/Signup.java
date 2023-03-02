package com.hotelmanagement.system;

import java.awt.*;

import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;


public class Signup extends JFrame implements ActionListener{
	
	 JTextField tfusername, tfname, tfmail, tfnumber;
		JPasswordField tfpassword ,cpassword;
		JButton submit,cancel;
	public Signup() {
		
			
			getContentPane().setBackground(Color.WHITE);
			setLayout(null);
			
			JLabel text = new JLabel("Signup");
			text.setBounds(320,20,300,30);
			text.setForeground(Color.BLACK);
			text.setBackground(Color.BLUE);
			text.setFont(new Font("Raleway",Font.PLAIN,20));
			add(text); 
			
		
			JLabel lblname =new JLabel("Name");
			lblname.setBounds(40,60,150,25);
			lblname.setFont(new Font("Raleway",Font.PLAIN,20));
			add(lblname);
			
		    tfname =new JTextField();
			tfname.setBounds(150,60,150,25);
			add(tfname); 
			
			JLabel lblmail =new JLabel("Mail");
			lblmail .setBounds(40,100,150,25);
			lblmail .setFont(new Font("Raleway",Font.PLAIN,20));
			add(lblmail );
			
		    tfmail =new JTextField();
		    tfmail.setBounds(150,100,150,25);
			add(tfmail); 
			
			JLabel user =new JLabel("Username");
			user.setBounds(40,140,100,25);
			user.setFont(new Font("Raleway",Font.PLAIN,20));
			add(user);
			
			 tfusername =new JTextField();
			tfusername.setBounds(150,140,150,25);
			add(tfusername);
			
			JLabel pass =new JLabel("Password");
			pass.setBounds(40,180,150,25);
			pass.setFont(new Font("Raleway",Font.PLAIN,20));
			add(pass);
			
		    tfpassword  =new JPasswordField();
			tfpassword.setBounds(150,180,150,25);
			add(tfpassword);

			JLabel lblpasswords =new JLabel("RePassword");
			lblpasswords.setBounds(40,220,150,25);
			lblpasswords.setFont(new Font("Raleway",Font.PLAIN,17));
			add(lblpasswords);
			
		    cpassword  =new JPasswordField();
			cpassword.setBounds(150,220,150,25);
			add(cpassword);
			

			JLabel lblnumber = new JLabel("Mob_No");
			lblnumber.setBounds(40,260,150,25);
		//  lblnumber.setForeground(Color.WHITE);
			lblnumber.setFont(new Font("Raleway",Font.PLAIN,20));
			add(lblnumber);
			
		    tfnumber =new JTextField();
		    tfnumber.setBounds(150,260,150,25);
		    add(tfnumber);

		   submit = new JButton("Submit");
		   submit.setBounds(30,310,150,30);
		   submit.setBackground(Color.BLACK);
		   submit.setForeground(Color.WHITE);
		   submit.addActionListener(this);
			add( submit);
			
			cancel =new JButton("cancel");
			cancel.setBounds(200,310,150,30);
			cancel.setBackground(Color.BLACK);
			cancel.setForeground(Color.WHITE);
			cancel.addActionListener(this);
			add(cancel);
			
			setBounds(350,200,700,400);
			setVisible(true);
			
			ImageIcon i8  = new ImageIcon(ClassLoader.getSystemResource("icons/R.png"));
			 Image i7=i8.getImage().getScaledInstance(200,150,Image.SCALE_DEFAULT);
		     ImageIcon i9= new ImageIcon(i7);
	         JLabel images = new JLabel(i9);
	         images.setBounds(400,50,210,150);
	        
	         add(images);

			
			ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/s1.png"));
	        Image i2=i1.getImage().getScaledInstance(150,100,Image.SCALE_DEFAULT);
	        ImageIcon i3= new ImageIcon(i2);
	        JLabel image = new JLabel(i3);
	        image.setBounds(410,50,205,440);
	        add(image);
	        

						
	 }
	 

	@Override
	public void actionPerformed(ActionEvent ae) {
//		// TODO Auto-generated method stub
//		 if (ae.getSource() == submit ) {
//				setVisible(false);
//				new  Login();
//			}
//			if(ae.getSource()== submit) {
//				String name=tfname.getText();
//				String mail=tfmail.getText();
//			    String username=tfusername.getText();
//				String password=tfpassword.getText();
//				String repassword= cpassword.getText();
//				String Mob_No=tfnumber.getText();
//				new Login();
//			
//				
//				try {
//					Conn c= new Conn();
//					String query = "INSERT INTO signup values ('"+ name+"','"+mail+"', '"+ username+"','"+ password+"','"+repassword+"','"+Mob_No+"')";
//					
//					ResultSet rs= c.s.executeQuery(query);
//					
//					if(rs.next()) {
//						setVisible(false);
//						new Login();
//					}else {
//						JOptionPane.showMessageDialog(null,"Signup Successfully");
//						setVisible(false);
//					}
//					
//				}catch (Exception e) {
//					e.printStackTrace();
//					
//				}
//			}else if (ae.getSource()== cancel) {
//				setVisible(false);
//			}
//					
//		
		String name=tfname.getText();
		String mail=tfmail.getText();
	    String Username=tfusername.getText();
		String password=tfpassword.getText();
		String repassword= cpassword.getText();
		String Mob_No=tfnumber.getText();
		new Login();
	
        
          if(ae.getSource()==submit) {
  			
          
          if(name.equals("")) {
        	  JOptionPane.showMessageDialog(null, "name should not be empty");
        	  return;
          }
          
          if(Username.equals("")) {
        	  JOptionPane.showMessageDialog(null, "aadhar should not be empty");
        	  return;
          }
          
          if(mail.equals("")) {
        	  JOptionPane.showMessageDialog(null, "email should not be empty");
        	  return;
          }
          
          if(Mob_No.equals("")) {
        	  JOptionPane.showMessageDialog(null, "phone should not be empty");
        	  return;
          }
        
       
    		
         

          
          try {
              Conn c = new Conn();
              String query = "INSERT INTO signup values( '"+name+"','"+mail+"', '"+Username+"', '"+password+"','"+repassword+"', '"+Mob_No+"')";
              
              c.s.executeUpdate(query);
              setVisible(false);
              JOptionPane.showMessageDialog(null,"Signup Successfully");
              setVisible(false);
          
          } catch (Exception e) {
              e.printStackTrace();
          }
          }
       
          else if (ae.getSource() == cancel){
        	  setVisible(false);
          }
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
              new Signup();
	}

}
