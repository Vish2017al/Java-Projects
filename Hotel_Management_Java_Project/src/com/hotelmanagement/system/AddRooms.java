package com.hotelmanagement.system;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;



public class AddRooms extends JFrame implements ActionListener{

	JButton add,back,cancel;
	JTextField tfroom,tfprice;
	JComboBox bedcombo,availablecombo,cleancombo;
	
	 AddRooms()
	 {
		 getContentPane().setBackground(Color.WHITE);
		 setLayout(null);
		 

			JLabel heading =new JLabel("Add Rooms");
			heading.setBounds(150,20,200,20);
			heading.setFont(new Font("Tahoma",Font.BOLD,18));
			add(heading);
		 
			JLabel lblroomno =new JLabel("Add Room No");
			lblroomno.setBounds(60,80,120,30);
			lblroomno.setFont(new Font("Tahoma",Font.PLAIN,16));
			add(lblroomno);
			
		    tfroom =new JTextField();
			tfroom.setBounds(200,80,150,30);
			add(tfroom);
			

			JLabel lblavailable =new JLabel("Room Status");
			lblavailable.setBounds(60,130,120,30);
			lblavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
			add(lblavailable);
			
			String availableOptions[] = {" ","Available","Occupied"};
			availablecombo =new JComboBox(availableOptions);
			availablecombo.setBounds(200,130,150,30);
			availablecombo.setBackground(Color.WHITE);
			add(availablecombo);


			JLabel lblclean =new JLabel("Cleaning Status");
			lblclean.setBounds(60,180,120,30);
			lblclean.setFont(new Font("Tahoma",Font.PLAIN,16));
			add(lblclean);
			
			String cleanOptions[] = {" ","Cleaned","Dirty"};
			cleancombo =new JComboBox(cleanOptions);
			cleancombo.setBounds(200,180,150,30);
			cleancombo.setBackground(Color.WHITE);
			add(cleancombo);

			JLabel lblprice =new JLabel("Room Price");
			lblprice.setBounds(60,230,120,30);
			lblprice.setFont(new Font("Tahoma",Font.PLAIN,16));
			add(lblprice);
			
			tfprice =new JTextField();
			tfprice.setBounds(200,230,150,30);
			add(tfprice);
			

			JLabel lbltype =new JLabel("Bed Type");
			lbltype.setBounds(60,280,120,30);
			lbltype.setFont(new Font("Tahoma",Font.PLAIN,16));
			add(lbltype);
			
			String bedOptions[] = {" ","Single Bed","Double Bed"};
			bedcombo =new JComboBox(bedOptions);
			bedcombo.setBounds(200,280,150,30);
			bedcombo.setBackground(Color.WHITE);
			add(bedcombo);
			
			add = new JButton("Add ");
			add.addActionListener(this);
			add.setBounds(10, 350, 100, 30);
		    add.setBackground(Color.BLACK);
		    add.setForeground(Color.WHITE);
			add(add);

			back = new JButton("Back");
			back.setBounds(130,350,100,30);
			back.setBackground(Color.BLACK);
			back.setForeground(Color.WHITE);
			back.addActionListener(this);
			add(back);
			
			cancel = new JButton("Cancel");
			cancel.addActionListener(this);
			cancel.setBounds(250, 350, 100, 30);
		    cancel.setBackground(Color.BLACK);
		    cancel.setForeground(Color.WHITE);
			add(cancel);
		
			 ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
			 JLabel image =new JLabel(i1);
             //Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
             //ImageIcon i2 = new ImageIcon(i3);
             //JLabel l15 = new JLabel(i2);
             image.setBounds(400,30,510,380);
             add(image);
			
		 setBounds(330,200,940,470);
		 setVisible(true);
		
	 }
	 
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==add) {
			
                String roomnumber = tfroom.getText();
                String availability = (String)availablecombo.getSelectedItem();
                String cleaning_status = (String)cleancombo.getSelectedItem();
                String price  = tfprice.getText();
                String bed_type = (String)bedcombo.getSelectedItem();
               
                try{
                    Conn c = new Conn();
                    
                String str = "INSERT INTO room values( '"+roomnumber+"', '"+availability+"', '"+cleaning_status+"','"+price+"', '"+bed_type+"')";
              
                
		c.s.executeUpdate(str);
		JOptionPane.showMessageDialog(null, "Room Added Successfully");
                this.setVisible(false);
               
                }catch(Exception e){
                	 e.printStackTrace();
                }
            }
		else if (ae.getSource()== back){
			setVisible(false);
			new Dashboard();
		}	
		else if (ae.getSource()== cancel) {
			setVisible(false);
		}
		
	}
		
	

	public static void main(String[] args) {
		
		new  AddRooms();
		
			}

}
