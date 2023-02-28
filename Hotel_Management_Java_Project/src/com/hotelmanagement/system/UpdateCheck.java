package com.hotelmanagement.system;


import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class UpdateCheck extends JFrame implements ActionListener  {
   Choice ccustomer;
   JTextField tfroom,tfname,tfcheckin,tfamount,tfpending,tfgender;
   JButton back,check, update;
   JComboBox gendercombo;

	public UpdateCheck(){
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lbltext =new JLabel("Update Status");
		lbltext.setBounds(90,20,200,30);
		lbltext.setFont(new Font("Tahoma",Font.BOLD,20));
		lbltext.setForeground(Color.BLUE);
		add(lbltext);
		
		JLabel lblid =new JLabel("Customer Id");
		lblid.setBounds(30,80,100,20);
		//lblid.setFont(new Font("Tahoma",Font.BOLD,14));
		//lblid.setForeground(Color.BLUE);
		add(lblid);
		
		ccustomer = new Choice();
		ccustomer.setBounds(200,80,150,25);
		add(ccustomer);

		try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
            	ccustomer.add(rs.getString("number"));
            }
           // table.setModel(DbUtils.resultSetToTableModel(rs));
            }
         catch(Exception e){
               e.printStackTrace();
              }

		JLabel lblroomno =new JLabel("Room No");
		lblroomno.setBounds(30,120,100,20);
		//lblroomno.setFont(new Font("Tahoma",Font.BOLD,14));
		add(lblroomno);
		
		 tfroom =new JTextField();
			tfroom.setBounds(200,120,150,25);
			add(tfroom);
		

			JLabel lblname =new JLabel("Name");
			lblname.setBounds(30,160,100,20);
		//	lblname.setFont(new Font("Tahoma",Font.PLAIN,17));
			add(lblname);
			
			tfname =new JTextField();
			tfname.setBounds(200,160,150,25);
			add(tfname);
			
			JLabel lblcheckin =new JLabel("Checkin Time");
			lblcheckin.setBounds(30,200,100,20);
			//lblname.setFont(new Font("Tahoma",Font.PLAIN,17));
			add(lblcheckin);
			
			tfcheckin =new JTextField();
			tfcheckin.setBounds(200,200,150,25);
			add(tfcheckin);
			
			JLabel lblamount =new JLabel("Amount paid");
			lblamount.setBounds(30,240,100,20);
			//lblamount.setFont(new Font("Tahoma",Font.PLAIN,17));
			add(lblamount);
			
			tfamount =new JTextField();
			tfamount.setBounds(200,240,150,25);
			add(tfamount);
			
			JLabel lblpendingAmount =new JLabel("Pending Amount");
			lblpendingAmount.setBounds(30,280,100,20);
			//lblpendingAmount.setFont(new Font("Tahoma",Font.PLAIN,17));
			add(lblpendingAmount);
		
			
			tfpending =new JTextField();
			tfpending.setBounds(200,280,150,25);
			add(tfpending);

			JLabel lblgender =new JLabel("Gender");
			lblgender.setBounds(30,320,100,20);
			//lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
			add(lblgender);

			tfgender =new JTextField();
			tfgender.setBounds(200,320,150,25);
			add(tfgender);
			
			
			
			check = new JButton("check");
			check.setBounds(30,360,100,30);
			check.setBackground(Color.BLACK);
			check.setForeground(Color.WHITE);
			check.addActionListener(this);
			add(check);
			
			update = new JButton("update");
			update.setBounds(150,360,100,30);
			update.setBackground(Color.BLACK);
			update.setForeground(Color.WHITE);
			update.addActionListener(this);
			add(update);
			
			back = new JButton("Back");
			back.setBounds(270,360,100,30);
			back.setBackground(Color.BLACK);
			back.setForeground(Color.WHITE);
			back.addActionListener(this);
			add(back);
			
			 ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
		       
	         JLabel image = new JLabel(i1);
	         image.setBounds(400,50,500,300);
	         add(image);
			
			
			
		
		setBounds(300,200,980,500);
		setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		if(ae.getSource()== check) {
			String id = ccustomer.getSelectedItem();
			String query ="select * from customer where number = '"+id+ "'" ;
			try {
				Conn c = new Conn();
				ResultSet rs =c.s.executeQuery(query);
				while (rs.next()) {
					tfroom.setText(rs.getString("room"));   
                    tfname.setText(rs.getString("name"));    
                    tfcheckin.setText(rs.getString("checkin_time"));    
                    tfamount.setText(rs.getString("deposite"));  
                    tfgender.setText(rs.getString("gender"));
				}
				
				ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = "+tfroom.getText());
                while(rs2.next()){
                	String price = rs2.getString("price");
                    int pending = Integer.parseInt(price)- Integer.parseInt(tfamount.getText());
                    tfpending.setText(""+pending);
                   
                }
			}catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if (ae.getSource()== update){
			
		    String  number= ccustomer.getSelectedItem();
		    String room = tfroom.getText(); //room_number;    
		    String name = tfname.getText(); //name    
		    String checkin_time = tfcheckin.getText(); //status;    
		    String deposite = tfamount.getText(); //deposit  
		    String gender = tfgender.getText();
		    
		    try{
                Conn c = new Conn();
                c.s.executeUpdate("update customer set room ='"+room+"',name='"+name+"',gender='"+gender+"',checkin_time ='"+checkin_time+"',deposite='"+deposite+"'");
                
                JOptionPane.showMessageDialog(null, "Data Update Successfully");
                setVisible(false);
                new Reception();
                
		    }catch(Exception ee){
             ee.printStackTrace();
            }	
						
		}else {
			setVisible(false);
            new Reception();
            
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
             new UpdateCheck();
	}

}
