package com.hotelmanagement.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.sql.SQLSyntaxErrorException;
import javax.swing.*;




public class UpdateRoom extends JFrame implements ActionListener   {
	 Choice ccustomer;
	   JTextField tfroom,tfavailable,tfstatus,tfamount,tfpending;
	   JButton back,check, update;

	
	public UpdateRoom() {
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lbltext =new JLabel("Update Room Status");
		lbltext.setBounds(30,20,250,30);
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
		lblroomno.setBounds(30,130,100,20);
		//lblroomno.setFont(new Font("Tahoma",Font.BOLD,14));
		add(lblroomno);
		
		 tfroom =new JTextField();
			tfroom.setBounds(200,130,150,25);
			add(tfroom);
		

			JLabel lblavailable =new JLabel("Availability");
			lblavailable.setBounds(30,180,100,20);
		//	lblname.setFont(new Font("Tahoma",Font.PLAIN,17));
			add(lblavailable);
			
			tfavailable =new JTextField();
			tfavailable.setBounds(200,180,150,25);
			add(tfavailable);
			
			JLabel lblstatus =new JLabel("Cleaning Status");
			lblstatus.setBounds(30,230,100,20);
			//lblname.setFont(new Font("Tahoma",Font.PLAIN,17));
			add(lblstatus);
			
			tfstatus =new JTextField();
			tfstatus.setBounds(200,230,150,25);
			add(tfstatus);
			
			
			check = new JButton("check");
			check.setBounds(30,300,100,30);
			check.setBackground(Color.BLACK);
			check.setForeground(Color.WHITE);
			check.addActionListener(this);
			add(check);
			
			update = new JButton("update");
			update.setBounds(150,300,100,30);
			update.setBackground(Color.BLACK);
			update.setForeground(Color.WHITE);
			update.addActionListener(this);
			add(update);
			
			back = new JButton("Back");
			back.setBounds(270,300,100,30);
			back.setBackground(Color.BLACK);
			back.setForeground(Color.WHITE);
			back.addActionListener(this);
			add(back);
			
			 ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
             Image i2 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
             ImageIcon i3 = new ImageIcon(i2);
             JLabel image = new JLabel(i3);
            image.setBounds(400,50,530,300);
             add(image);
			
			
			
		
		setBounds(300,200,980,450);
		setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent ae) throws NumberFormatException  {
		
		if(ae.getSource()== check) {
			String id = ccustomer.getSelectedItem();
			String query ="select * from customer where number = '"+id+ "'" ;
			try {
				Conn c = new Conn();
				ResultSet rs =c.s.executeQuery(query);
				while (rs.next()) {
					tfroom.setText(rs.getString("room"));   
          
                    
				}
		     
                     ResultSet rs2 = c.s.executeQuery("select * from room where roomnumber = "+tfroom.getText());
                     while(rs2.next()){
                    	 tfavailable.setText(rs2.getString("availability")); 
                    	 tfstatus.setText(rs2.getString("cleaning_status"));
                     }
                
			}
			catch (Exception e) {
				e.printStackTrace();
			}

			
		}else if (ae.getSource()== update){
			
		    String  number= ccustomer.getSelectedItem();
		    String room = tfroom.getText(); //room_number;        
		    String available= tfavailable.getText(); //availability 
		    String status =tfstatus.getText(); //status;
		    
		    try{
                Conn c = new Conn();
                c.s.executeUpdate("update room set availability ='"+available+"',cleaning_status='"+status+"' where roomnumber='"+room+"'" );
                
                JOptionPane.showMessageDialog(null, "Data Updated Successfully");
                setVisible(false);
                new Reception();
                
		    }catch(Exception e){
             e.printStackTrace();
            }	
						
		}else {
			setVisible(false);
            new Reception();
            
		}
		
	}
	

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       new UpdateRoom();
	}

}
