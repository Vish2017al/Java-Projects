package com.hotelmanagement.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SetPassword extends JFrame implements ActionListener {
	JTextField tfname;
	JButton submit,cancel;
	JPasswordField tfpassword ,cpassword;
	
	 SetPassword(){
	getContentPane().setBackground(Color.WHITE);
	setLayout(null);
		
	JLabel text = new JLabel("Set New Password");
	text.setBounds(200,20,300,30);
	text.setForeground(Color.BLACK);
	text.setBackground(Color.BLUE);
	text.setFont(new Font("Raleway",Font.PLAIN,20));
	add(text); 
	

	JLabel lblname =new JLabel("Name");
	lblname.setBounds(40,80,150,25);
	lblname.setFont(new Font("Raleway",Font.PLAIN,20));
	add(lblname);
	
    tfname =new JTextField();
	tfname.setBounds(200,80,150,25);
	add(tfname); 
	
	JLabel pass =new JLabel("Enter Password");
	pass.setBounds(40,130,150,25);
	pass.setFont(new Font("Raleway",Font.PLAIN,18));
	add(pass);
	
    tfpassword  =new JPasswordField();
	tfpassword.setBounds(200,130,150,25);
	add(tfpassword);

	JLabel lblpasswords =new JLabel("Confirm Password");
	lblpasswords.setBounds(40,180,150,25);
	lblpasswords.setFont(new Font("Raleway",Font.PLAIN,18));
	add(lblpasswords);
	
    cpassword  =new JPasswordField();
	cpassword.setBounds(200,180,150,25);
	add(cpassword);
	
	 submit = new JButton("Submit");
	   submit.setBounds(30,250,150,30);
	   submit.setBackground(Color.BLACK);
	   submit.setForeground(Color.WHITE);
	   submit.addActionListener(this);
		add( submit);
		
		cancel =new JButton("cancel");
		cancel.setBounds(220,250,150,30);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		add(cancel);
	
	setBounds(500,250,550,350);
	setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
	
		 if(ae.getSource()== submit) {
			 String password=tfpassword.getText();
				String repassword= cpassword.getText();
				String name=tfname.getText();
	
				
				 try{
		                Conn c = new Conn();
		                c.s.executeUpdate("update signup set Password ='"+password+"',repassword='"+repassword+"' where name='"+name+"'" );
		                
		                setVisible(false);
			            JOptionPane.showMessageDialog(null,"Password Set Successfully");
						new  Login();
		                
				    }catch(Exception e){
		             e.printStackTrace();
		            }	
		 }else if (ae.getSource()== cancel) {
				setVisible(false);
				new Login();
			}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
   new SetPassword();
	}

}
