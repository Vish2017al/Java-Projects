package com.hotelmanagement.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;
public class Login extends JFrame implements ActionListener {

	JTextField username;
	JPasswordField password;
	JButton login, cancel,Signup;
	
	Login(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
	
		
		JLabel user =new JLabel("Username");
		user.setBounds(40,50,150,30);
		add(user);
		
		 username =new JTextField();
		username.setBounds(150,50,150,30);
		add(username);
		
		JLabel pass =new JLabel("Password");
		pass.setBounds(40,110,150,30);
		add(pass);
		
	 password  =new JPasswordField();
		password.setBounds(150,110,150,30);
		add(password);
		
		 login =new JButton("Login");
		login.setBounds(40,200,120,30);
		login.setBackground(Color.BLACK);
		login.setForeground(Color.WHITE);
		login.addActionListener(this);
		add(login);
		
		Signup =new JButton("Signup");
		Signup.setBounds(180,200,120,30);
		Signup.setBackground(Color.BLACK);
		Signup.setForeground(Color.WHITE);
		Signup.addActionListener(this);
		add(Signup);
		
		 cancel =new JButton("Cancel");
		cancel.setBounds(320,200,150,30);
		cancel.setBackground(Color.BLACK);
		cancel.setForeground(Color.WHITE);
		cancel.addActionListener(this);
		add(cancel);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
		Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(400,5,150,200);
		add(image);
		
		
		setBounds(500,200,600,300);
		setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		 if (ae.getSource() == Signup  ) {
				setVisible(false);
				new  Signup();
		 }
				
		 if(ae.getSource()== login) {
		    String user=username.getText();
			String pass=password.getText();
			new Dashboard();
			try {
				Conn c= new Conn();
				String query = "select * from login where username='"+ user+"' and passward ='"+ pass+"'";
				
				ResultSet rs= c.s.executeQuery(query);
				
				if(rs.next()) {
					setVisible(false);
					new Dashboard();
				}else {
					JOptionPane.showMessageDialog(null,"valid username or password");
					setVisible(false);
				}
				
			}catch (Exception e) {
				e.printStackTrace();
				
			}
		}else if (ae.getSource()== cancel) {
			setVisible(false);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Login();
	}

}
