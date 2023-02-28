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

public class ManagerInfo  extends JFrame implements ActionListener  {
	
	  JTable table;
	  JButton back;
	
	public ManagerInfo () {
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		
        
        JLabel lblname =new JLabel("Name");
		lblname.setBounds(30,10,100,20);
		lblname.setFont(new Font("Tahoma",Font.BOLD,14));
		add(lblname);
		

		JLabel lblage =new JLabel("Age");
		lblage.setBounds(150,10,100,20);
		lblage.setFont(new Font("Tahoma",Font.BOLD,14));
		add(lblage);

		JLabel lblgender =new JLabel("Gender");
		lblgender.setBounds(260,10,100,20);
		lblgender.setFont(new Font("Tahoma",Font.BOLD,14));
		add(lblgender);
		
		JLabel lbljob =new JLabel("Job");
		lbljob.setBounds(390,10,100,20);
		lbljob.setFont(new Font("Tahoma",Font.BOLD,14));
		add(lbljob);
		

		JLabel lblsalary =new JLabel("Salary");
		lblsalary.setBounds(510,10,100,20);
		lblsalary.setFont(new Font("Tahoma",Font.BOLD,14));
		add(lblsalary);
        

		JLabel lblphone =new JLabel("Phone no");
		lblphone.setBounds(630,10,100,20);
		lblphone.setFont(new Font("Tahoma",Font.BOLD,14));
		add(lblphone);
        

		JLabel lblemail =new JLabel("Email");
		lblemail.setBounds(770,10,100,20);
		lblemail.setFont(new Font("Tahoma",Font.BOLD,14));
		add(lblemail);
        

		JLabel lblaadhar =new JLabel("Addhar");
		lblaadhar.setBounds(900,10,100,20);
		lblaadhar.setFont(new Font("Tahoma",Font.BOLD,14));
		add(lblaadhar);
        
         table = new JTable();
		table.setBounds(0, 40, 1000, 400);
		add(table);
		
		try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from employee where job ='manager'");
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
		// TODO Auto-generated method stub

	}

}
