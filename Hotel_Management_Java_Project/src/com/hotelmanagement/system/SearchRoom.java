package com.hotelmanagement.system;


import java.awt.*;
import java.awt.event.*;

import java.sql.*;

import javax.swing.*;


import net.proteanit.sql.DbUtils;

public class SearchRoom extends JFrame implements ActionListener  {
	  JTable table;
	  JButton back, submit;
	  JCheckBox available;
	JComboBox badtype;
	public SearchRoom() {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lbltext =new JLabel("Search For Room");
		lbltext.setBounds(400,30,200,30);
		lbltext.setFont(new Font("Tahoma",Font.BOLD,14));
		add(lbltext);
		

		JLabel lblbedtype =new JLabel("Bed Type");
		lblbedtype.setBounds(50,100,100,20);
		lblbedtype.setFont(new Font("Tahoma",Font.BOLD,14));
		add(lblbedtype);
		

		 String str[] = {" ","Single Bed","Double Bed"};
		 badtype = new JComboBox(str);
		 badtype.setBackground(Color.WHITE);
		 badtype.setBounds(150,100,150,25);
	     add(badtype);
	     
	     available = new  JCheckBox ("only Display Available");
	     available.setBounds(650,100,150,25);
	     available.setBackground(Color.WHITE);
	     add( available);
        
        JLabel lblroomno =new JLabel("Room No");
		lblroomno.setBounds(50,160,100,20);
		lblroomno.setFont(new Font("Tahoma",Font.BOLD,14));
		add(lblroomno);
		

		JLabel lblavailable =new JLabel("Availibility");
		lblavailable.setBounds(250,160,100,20);
		lblavailable.setFont(new Font("Tahoma",Font.BOLD,14));
		add(lblavailable);

		JLabel lblclean =new JLabel("Status");
		lblclean.setBounds(450,160,100,20);
		lblclean.setFont(new Font("Tahoma",Font.BOLD,14));
		add(lblclean);
		
		JLabel lblprice =new JLabel("Price");
		lblprice.setBounds(650,160,100,20);
		lblprice.setFont(new Font("Tahoma",Font.BOLD,14));
		add(lblprice);
		

		JLabel lbltype =new JLabel("Bed Type");
		lbltype.setBounds(850,160,100,20);
		lbltype.setFont(new Font("Tahoma",Font.BOLD,14));
		add(lbltype);
		
         table = new JTable();
		table.setBounds(0,200, 1000, 300);
		add(table);
		
		try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            }
         catch(Exception e){
               e.printStackTrace();
              }
					
		back = new JButton("Back");
		back.setBounds(300,500,120,30);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);
		
		 submit =new JButton("SUBMIT");
	        submit.setBounds(600,500,120,30);
	        submit.setBackground(Color.BLACK);
	        submit.setForeground(Color.WHITE);
	        submit.addActionListener(this);
			add(submit);
		
		setBounds(300,200,1000,600);
		setVisible(true);
				
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == submit) {
			try{
			 Conn c = new Conn();
	            String query1="select * from room where bed_type='"+badtype.getSelectedItem()+"'";
	            String query2="select * from room where availability='Available' AND bed_type='"+badtype.getSelectedItem()+"'";
	            
	           ResultSet rs;
	            if(available.isSelected()) {
	            	rs= c.s.executeQuery(query2);
	            }else {
	            	rs =c.s.executeQuery(query1);
	            }
	            table.setModel(DbUtils.resultSetToTableModel(rs));
	            }
		
	         catch(Exception e){
	               e.printStackTrace();
	              }
						
		}else {
			setVisible(false);
			new Reception();
		}
		

		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new SearchRoom();
	}

}
