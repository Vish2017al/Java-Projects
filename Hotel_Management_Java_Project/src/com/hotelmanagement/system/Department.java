package com.hotelmanagement.system;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

import net.proteanit.sql.DbUtils;



public class Department extends JFrame implements ActionListener  {

	  JTable table;
	  JButton back;
	
	public Department() {
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
        
        JLabel lbldepartment =new JLabel("Department");
		lbldepartment.setBounds(150,10,100,20);
		
		add(lbldepartment);
		

		JLabel lblbudget =new JLabel("Budget");
		lblbudget.setBounds(450,10,100,20);
		add(lblbudget);
		
        
         table = new JTable();
		table.setBounds(0, 50, 700, 350);
		add(table);
		
		try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            }
         catch(Exception e){
               e.printStackTrace();
              }
					
		back = new JButton("Back");
		back.setBounds(280,400,120,30);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);
		
		
		setBounds(400,200,700,480);
		setVisible(true);
				
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		setVisible(false);
		new Reception();
	}

	public static void main(String[] args) {
		new Department();

	}

}
