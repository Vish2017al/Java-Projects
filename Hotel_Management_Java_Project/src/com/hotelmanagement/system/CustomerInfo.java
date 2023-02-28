package com.hotelmanagement.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

public class CustomerInfo  extends JFrame implements ActionListener  {

	  JTable table;
	  JButton back;
	
	public CustomerInfo () {
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		
		JLabel lbldocument =new JLabel("Document");
		lbldocument .setBounds(10,10,100,20);
		lbldocument .setFont(new Font("Tahoma",Font.BOLD,14));
		add(lbldocument );
     	
		JLabel lblphone =new JLabel("Phone no");
		lblphone.setBounds(135,10,100,20);
		lblphone.setFont(new Font("Tahoma",Font.BOLD,14));
		add(lblphone);
		
		  
	    JLabel lblname =new JLabel("Name");
		lblname.setBounds(260,10,100,20);
		lblname.setFont(new Font("Tahoma",Font.BOLD,14));
		add(lblname);
	
		
		JLabel lblgender =new JLabel("Gender");
		lblgender.setBounds(380,10,100,20);
		lblgender.setFont(new Font("Tahoma",Font.BOLD,14));
		add(lblgender);

		JLabel lblcountry =new JLabel("Country");
		lblcountry.setBounds(510,10,100,20);
		lblcountry.setFont(new Font("Tahoma",Font.BOLD,14));
		add(lblcountry);
      

		JLabel lblroomno =new JLabel("Room no");
		lblroomno.setBounds(630,10,100,20);
		lblroomno.setFont(new Font("Tahoma",Font.BOLD,14));
		add( lblroomno);

      

		JLabel lblcheckinTime =new JLabel("Checkin Time");
		lblcheckinTime.setBounds(760,10,100,20);
		lblcheckinTime.setFont(new Font("Tahoma",Font.BOLD,14));
		add(lblcheckinTime);
      

		JLabel lbldeposite =new JLabel("Deposite");
		lbldeposite.setBounds(880,10,100,20);
		lbldeposite.setFont(new Font("Tahoma",Font.BOLD,14));
		add(lbldeposite);
      
       table = new JTable();
		table.setBounds(0, 40, 1000, 400);
		add(table);
		
		try{
          Conn c = new Conn();
          ResultSet rs = c.s.executeQuery("select * from customer");
          table.setModel(DbUtils.resultSetToTableModel(rs));
          }
       catch(Exception e){
             e.printStackTrace();
            }
					
		back = new JButton("Back");
		back.setBounds(420,500,120,30);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);
		
		
		setBounds(300,200,1000,600);
		setVisible(true);
				
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		setVisible(false);
		new Reception();
	}

	public static void main(String[] args) {
		new CustomerInfo ();

	}

}



