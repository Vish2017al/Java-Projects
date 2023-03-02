package com.hotelmanagement.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;


import javax.swing.*;



import net.proteanit.sql.DbUtils;

public class Pickup extends JFrame implements ActionListener {
        Choice model;
	  JTable table;
	  JButton back, submit;
	  JCheckBox available;
	JComboBox badtype;
	
	public Pickup () {
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lbltext =new JLabel("Pickup Service");
		lbltext.setBounds(400,30,200,30);
		lbltext.setFont(new Font("Tahoma",Font.BOLD,14));
		add(lbltext);
		

		JLabel lblmodel =new JLabel("Model Of Car ");
		lblmodel.setBounds(50,100,100,20);
		lblmodel.setFont(new Font("Tahoma",Font.BOLD,14));
		add(lblmodel);
		
		
		model =new Choice();
		model.setBounds(150,100,200,25);
		add(model);
		  try{
              Conn c = new Conn();
              ResultSet rs = c.s.executeQuery("select * from driver");
              while(rs.next()){
                  model.add(rs.getString("company"));    
              }
		  }catch (Exception e) {
  				e.printStackTrace();
  			}
		

       
        JLabel lblname =new JLabel("Name");
        lblname.setBounds(50,160,100,20);
        lblname.setFont(new Font("Tahoma",Font.BOLD,14));
		add(lblname);
		

		JLabel lblage =new JLabel("Age");
		lblage.setBounds(200,160,100,20);
		lblage.setFont(new Font("Tahoma",Font.BOLD,14));
		add(lblage);

		JLabel lblgender =new JLabel("gender");
		lblgender.setBounds(330,160,100,20);
		lblgender.setFont(new Font("Tahoma",Font.BOLD,14));
		add(lblgender);
		
		JLabel lblcompany =new JLabel("Company");
		lblcompany.setBounds(450,160,100,20);
		lblcompany.setFont(new Font("Tahoma",Font.BOLD,14));
		add(lblcompany);
		

		JLabel lblbrand=new JLabel("Brand");
		lblbrand.setBounds(600,160,100,20);
		lblbrand.setFont(new Font("Tahoma",Font.BOLD,14));
		add(lblbrand);

		JLabel lblavailable =new JLabel("Availability");
		lblavailable .setBounds(740,160,100,20);
		lblavailable .setFont(new Font("Tahoma",Font.BOLD,14));
		add(lblavailable );
		

		JLabel lbllocation =new JLabel("Location");
		lbllocation.setBounds(890,160,100,20);
		lbllocation.setFont(new Font("Tahoma",Font.BOLD,14));
		add(lbllocation);
		
         table = new JTable();
		table.setBounds(0,200, 1000, 300);
		add(table);
		
		try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
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
	            String query="select * from driver where company='"+model.getSelectedItem()+"'";
	            
	            
	           ResultSet rs;
	            	rs= c.s.executeQuery(query);
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
      new Pickup ();
	}

}
