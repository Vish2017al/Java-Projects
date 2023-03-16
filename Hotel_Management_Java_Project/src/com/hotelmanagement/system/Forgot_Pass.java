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

public class Forgot_Pass extends JFrame implements ActionListener {
	 JTextField tfusername, tfname, tfmail, tfnumber;
		JPasswordField tfpassword ,cpassword;
		JButton submit,cancel;
	Forgot_Pass(){
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel text = new JLabel("Enter Details");
		text.setBounds(150,20,300,30);
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
		
		JLabel lblmail =new JLabel("Email ID");
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
		
		JLabel lblnumber = new JLabel("Mob_No");
		lblnumber.setBounds(40,180,100,25);
	//  lblnumber.setForeground(Color.WHITE);
		lblnumber.setFont(new Font("Raleway",Font.PLAIN,20));
		add(lblnumber);
		
	    tfnumber =new JTextField();
	    tfnumber.setBounds(150,180,150,25);
	    add(tfnumber);

	   submit = new JButton("Submit");
	   submit.setBounds(150,220,150,30);
	   submit.setBackground(Color.BLACK);
	   submit.setForeground(Color.WHITE);
	   submit.addActionListener(this);
		add( submit);
		
		
		setBounds(500,300,600,300);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == submit ) {
			setVisible(false);
            JOptionPane.showMessageDialog(null,"Valid Details");
			new  SetPassword();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         new Forgot_Pass();
	}

}
