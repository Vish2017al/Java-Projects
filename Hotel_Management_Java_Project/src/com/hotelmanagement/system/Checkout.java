package com.hotelmanagement.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;
public class Checkout extends JFrame   implements ActionListener   {

	Choice ccustomer;
	JLabel lblroomnumber,lblcheckin,lblcheckout;
	JButton checkout,back;
	public Checkout () {
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		JLabel lbltext =new JLabel("Checkout");
		lbltext.setBounds(100,20,100,30);
		lbltext.setForeground(Color.BLUE);
		lbltext.setFont(new Font("Tahoma",Font.BOLD,14));
		add(lbltext);
		
		JLabel lblaid =new JLabel("Customer Id");
		lblaid.setBounds(30,80,100,30);
	//	lblaid.setFont(new Font("Tahoma",Font.BOLD,14));
		add(lblaid);
		
		ccustomer = new Choice();
		ccustomer.setBounds(150,80,120,25);
		add(ccustomer);

		

		 ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
		Image i2 =i1.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel tick =new JLabel(i3); 
        tick.setBounds(310,80,20,20);
        add(tick);
        

		JLabel lblroom =new JLabel("Room Number");
		lblroom.setBounds(30,130,100,30);
		add(lblroom);
		

		lblroomnumber =new JLabel();
		lblroomnumber.setBounds(150,130,100,30);
		add(lblroomnumber); 
		
		JLabel lblcheckintime =new JLabel("Checkin Time");
		lblcheckintime.setBounds(30,180,100,30);
		add(lblcheckintime);
		
		
	    lblcheckintime =new JLabel();
		lblcheckintime.setBounds(150,180,100,30);
		add(lblcheckintime);

		JLabel lblcheckouttime =new JLabel("Checkout Time");
		lblcheckouttime.setBounds(30,230,100,30);
		add(lblcheckouttime);
		
		Date date = new Date();
		
	    lblcheckouttime =new JLabel(""+date);
		lblcheckouttime.setBounds(150,230,150,30);
		add(lblcheckouttime);
		
		 
		checkout = new JButton("checkout");
		checkout.setBackground(Color.BLACK);
		checkout.setForeground(Color.WHITE);
		checkout.setBounds(30,280,120,30);
		checkout.addActionListener(this);
		add(checkout);
		
		 
		back= new JButton("Back");
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.setBounds(170,280,120,30);
		back.addActionListener(this);
		add(back);
		
		try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
            	ccustomer.add(rs.getString("number"));
            	lblroomnumber.setText(rs.getString("room"));
            	lblcheckintime.setText(rs.getString("checkin_time"));
            }
           // table.setModel(DbUtils.resultSetToTableModel(rs));
            }
         catch(Exception e){
               e.printStackTrace();
              }

		
		 ImageIcon i4  = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
	     Image i5 =i4.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
	     ImageIcon i6 = new ImageIcon(i5); 
         JLabel image =new JLabel(i6); 
	     image.setBounds(350,50,400,250);
	     add(image);
		
		setBounds(300,200,800,400);
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if (ae.getSource()== checkout) {
			String query1="delete from customer where number = '"+ccustomer.getSelectedItem()+ "'" ;
			String query2="update room set availability ='Available' where roomnumber ='"+lblroomnumber.getText()+"'";
			
			try {
				Conn c =new Conn();
				c.s.executeUpdate(query1);
				c.s.executeUpdate(query2);
				JOptionPane.showMessageDialog(null, "Checkout Done");
				setVisible(false);
				new Reception();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}else {
			setVisible(false);
			new Reception();
		}
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Checkout ();
	}

}
