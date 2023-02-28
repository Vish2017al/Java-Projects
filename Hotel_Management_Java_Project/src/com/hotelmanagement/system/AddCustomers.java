package com.hotelmanagement.system;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import javax.swing.*;

public class AddCustomers extends JFrame implements ActionListener {
	JComboBox comboid;
	JTextField tfnumber, tfname,tfcountry,tfdeposit ;
	 JRadioButton rbmale,rbfemale,rbother;
	 Choice croom;
	 JLabel checkintime;
	 JButton add,back;
	public AddCustomers() {
		setLayout(null);
		

		JLabel text = new JLabel("NEW CUSTOMER FROM");
		text.setBounds(100,20,300,30);
		text.setForeground(Color.BLACK);
		text.setFont(new Font("Raleway",Font.PLAIN,20));
		add(text); 
		
		
		JLabel lblname =new JLabel("Name");
		lblname.setBounds(35,80,100,20);
		lblname.setFont(new Font("Raleway",Font.PLAIN,20));
		add(lblname);
		
	    tfname =new JTextField();
		tfname.setBounds(200,80,150,25);
		add(tfname); 
	
		
		JLabel lblnumber = new JLabel("Number");
		lblnumber.setBounds(35,120,100,20);
	//  lblnumber.setForeground(Color.WHITE);
		lblnumber.setFont(new Font("Raleway",Font.PLAIN,20));
		add(lblnumber);
		
	    tfnumber =new JTextField();
	    tfnumber.setBounds(200,120,150,25);
	    add(tfnumber);
			
		JLabel lblid =new JLabel("ID");
	    lblid.setBounds(35,160,100,20);
		lblid.setFont(new Font("Raleway",Font.PLAIN,20));
		add(lblid);
		
		String Options[] = {" ","Aadhar card","Passport","Driving License","Voting-id Card","Ration card"};
		comboid =new JComboBox(Options);
		comboid.setBounds(200,160,150,25);
		comboid.setBackground(Color.WHITE);
		add(comboid);
		
		JLabel lblgender =new JLabel("Gender");
		lblgender.setBounds(35,200,100,20);
		lblgender.setFont(new Font("Raleway",Font.PLAIN,20));
		add(lblgender);
		
		rbmale = new JRadioButton("Male");
		rbmale.setBackground(Color.WHITE);
		rbmale.setBounds(200,200,60,30);
		rbmale.setFont(new Font("Raleway",Font.PLAIN,14));
        add(rbmale);
        
         rbfemale = new JRadioButton("Female");
		rbfemale.setBackground(Color.WHITE);
		rbfemale.setBounds(265,200,75,30);
		rbfemale.setFont(new Font("Raleway",Font.PLAIN,14));
        add(rbfemale);
        ButtonGroup bg =new ButtonGroup();
        bg.add(rbfemale);
        bg.add(rbmale);
        bg.add(rbother);
        
        rbother = new JRadioButton("Other");
		rbother.setBackground(Color.WHITE);
		rbother.setBounds(345,200,90,30);
		rbother.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(rbother);
        

		JLabel lblcountry =new JLabel("Country");
		lblcountry.setBounds(35,240,100,20);
		lblcountry.setFont(new Font("Raleway",Font.PLAIN,20));
		add(lblcountry);
		
	    tfcountry =new JTextField();
		tfcountry.setBounds(200,240,150,25);
		add(tfcountry); 
		
		JLabel lblroomno =new JLabel("Room Number");
		lblroomno.setBounds(35,280,160,20);
		lblroomno.setFont(new Font("Raleway",Font.PLAIN,20));
		add(lblroomno);
		
		croom = new Choice();
		try {
			Conn c= new Conn();
			String query ="select* from room where availability ='Available'";
			ResultSet rs =c.s.executeQuery(query);
			while (rs.next()) {
				croom.add(rs.getString("roomnumber"));
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		croom.setBounds(200,280,150,25);
		add(croom);
		
		
		JLabel lbltime =new JLabel("Checkin Time");
		lbltime.setBounds(35,320,150,20);
		lbltime.setFont(new Font("Raleway",Font.PLAIN,20));
		add(lbltime);
		
		Date date = new Date();
		
		checkintime =new JLabel("" + date);
		checkintime.setBounds(200,320,150,25);
		checkintime.setFont(new Font("Raleway",Font.PLAIN,14));
		add(checkintime);
		

		JLabel lbldeposit =new JLabel("Deposit");
		lbldeposit.setBounds(35,360,100,20);
		lbldeposit.setFont(new Font("Raleway",Font.PLAIN,20));
		add(lbldeposit);
		
	    tfdeposit =new JTextField();
		tfdeposit.setBounds(200,360,150,25);
		add(tfdeposit); 
		

		add = new JButton("Add");
		add.setBounds(50,410,120,30);
		add.setBackground(Color.BLACK);
		add.setForeground(Color.WHITE);
		add.addActionListener(this);
		add(add);
		

		back = new JButton("Back");
		back.setBounds(200,410,120,30);
		back.setBackground(Color.BLACK);
		back.setForeground(Color.WHITE);
		back.addActionListener(this);
		add(back);
		

		ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2=i1.getImage().getScaledInstance(300,400,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,50,300,400);
        add(image);
					
		setBounds(350,200,800,550);
		setVisible(true);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==add) {
			
            
            String id = (String)comboid.getSelectedItem();
            String number  = tfnumber.getText();
            String name = tfname.getText();

            String gender = null;
            
            if(rbmale.isSelected()){
                gender = "male";
            
            }else if(rbfemale.isSelected()){
                gender = "female";
            }else if (rbother.isSelected()) {
          	  gender = "other";
            }
         
            
            String country =tfcountry.getText();
            String room = croom.getSelectedItem();
            String checkin_time =checkintime.getText();
            String deposit =tfdeposit.getText();
      
            
           
            try{
               
                
            String str = "Insert into customer values( '"+id+"', '"+number+"','"+name+"','"+gender+"', '"+country+"','"+room+"','"+checkin_time+"','"+deposit+"')";
            String query = "update room set availability ='Occupied' where roomnumber ='"+room+"'";
            
            Conn c = new Conn();
            
	c.s.executeUpdate(str);
	c.s.executeUpdate(query);
	JOptionPane.showMessageDialog(null, "New Customer Added Successfully");

           setVisible(false);
        	new Reception();
        	
            }catch(Exception e){
            	 e.printStackTrace();
            }
          
      }
		
	else if (ae.getSource()== back)  {
		setVisible(false);
		new Reception();
		
	}
	
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
		new  AddCustomers();
	}

}
