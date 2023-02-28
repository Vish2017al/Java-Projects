package com.hotelmanagement.system;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import net.proteanit.sql.DbUtils;



public class Room extends JFrame implements ActionListener  {

	  JTable table;
	  JButton back;
	
	public Room() {
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		
		ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2=i1.getImage().getScaledInstance(600,600,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500,0,600,600);
        add(image);
        
        JLabel lblroomno =new JLabel("Room No");
		lblroomno.setBounds(5,10,100,20);
		lblroomno.setFont(new Font("Tahoma",Font.BOLD,14));
		add(lblroomno);
		

		JLabel lblavailable =new JLabel("Availibility");
		lblavailable.setBounds(102,10,100,20);
		lblavailable.setFont(new Font("Tahoma",Font.BOLD,14));
		add(lblavailable);

		JLabel lblclean =new JLabel("Status");
		lblclean.setBounds(202,10,100,20);
		lblclean.setFont(new Font("Tahoma",Font.BOLD,14));
		add(lblclean);
		

		JLabel lbltype =new JLabel("Bed Type");
		lbltype.setBounds(402,10,100,20);
		lbltype.setFont(new Font("Tahoma",Font.BOLD,14));
		add(lbltype);
        
         table = new JTable();
		table.setBounds(0, 40, 500, 400);
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
		back.setBounds(200,500,120,30);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);
		
		
		setBounds(300,200,1050,600);
		setVisible(true);
				
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		setVisible(false);
		new Reception();
	}

	public static void main(String[] args) {
		new Room();

	}

}
