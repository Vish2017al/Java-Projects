package com.hotelmanagement.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;

import javax.swing.*;

public class AddDriver extends JFrame implements ActionListener {
	JButton add,back,cancel;
	JTextField tfname,tfage,tfcompany,tfmodel,tflocation;
	JComboBox availablecombo,gendercombo;
	public AddDriver() {
		
			 getContentPane().setBackground(Color.WHITE);
			 setLayout(null);
			 

				JLabel heading =new JLabel("Add Drivers");
				heading.setBounds(150,10,200,20);
				heading.setFont(new Font("Tahoma",Font.BOLD,18));
				add(heading);
			 
				JLabel lblname =new JLabel("Driver Name");
				lblname.setBounds(60,70,120,30);
				lblname.setFont(new Font("Tahoma",Font.PLAIN,16));
				add(lblname);
				
			    tfname =new JTextField();
				tfname.setBounds(200,70,150,30);
				add(tfname);
				

				JLabel lblage =new JLabel("Driver Age");
				lblage.setBounds(60,110,120,30);
				lblage.setFont(new Font("Tahoma",Font.PLAIN,16));
				add(lblage);

			    tfage =new JTextField();
				tfage.setBounds(200,110,150,30);
				add(tfage);


				JLabel lblgender =new JLabel("Gender");
				lblgender.setBounds(60,150,120,30);
				lblgender.setFont(new Font("Tahoma",Font.PLAIN,16));
				add(lblgender);
				
				String genderOptions[] = {" ","Male","female"};
				gendercombo =new JComboBox(genderOptions);
				gendercombo.setBounds(200,150,150,30);
				gendercombo.setBackground(Color.WHITE);
				add(gendercombo);

				JLabel lblcompany =new JLabel("Car Company");
				lblcompany.setBounds(60,190,120,30);
				lblcompany.setFont(new Font("Tahoma",Font.PLAIN,16));
				add(lblcompany);
				
				tfcompany =new JTextField();
				tfcompany.setBounds(200,190,150,30);
				add(tfcompany);
				

				JLabel lblmodel =new JLabel("Car Model");
				lblmodel.setBounds(60,230,120,30);
				lblmodel.setFont(new Font("Tahoma",Font.PLAIN,16));
				add(lblmodel);
				
				tfmodel =new JTextField();
				tfmodel.setBounds(200,230,150,30);
				add(tfmodel);
			

				JLabel lblavailable =new JLabel("Driver Available");
				lblavailable.setBounds(60,270,120,30);
				lblavailable.setFont(new Font("Tahoma",Font.PLAIN,16));
				add(lblavailable);
				
				String availableOptions[] = {" ","Available","Busy"};
				availablecombo =new JComboBox(availableOptions);
				availablecombo.setBounds(200,270,150,30);
				availablecombo.setBackground(Color.WHITE);
				add(availablecombo);

				JLabel lbllocation =new JLabel("Location");
				lbllocation .setBounds(60,310,120,30);
				lbllocation .setFont(new Font("Tahoma",Font.PLAIN,16));
				add(lbllocation );
				
				tflocation =new JTextField();
				tflocation.setBounds(200,310,150,30);
				add(tflocation);

				
				add = new JButton("Add ");
				add.addActionListener(this);
				add.setBounds(50, 370, 100, 30);
			    add.setBackground(Color.BLACK);
			    add.setForeground(Color.WHITE);
				add(add);
				

				back = new JButton("Back");
				back.setBounds(165,370,100,30);
				back.setBackground(Color.BLACK);
				back.setForeground(Color.WHITE);
				back.addActionListener(this);
				add(back);
				
				cancel = new JButton("Cancel");
				cancel.addActionListener(this);
				cancel.setBounds(280, 370, 100, 30);
			    cancel.setBackground(Color.BLACK);
			    cancel.setForeground(Color.WHITE);
				add(cancel);
			
				 ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
	             Image i2 =i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
	             ImageIcon i3 = new ImageIcon(i2);
	             JLabel image =new JLabel(i3);
	             
	             image.setBounds(400,30,510,380);
	             add(image);
				
			 setBounds(300,200,980,470);
			 setVisible(true);
			
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		if(ae.getSource()==add) {
			
            String name = tfname.getText();
            String age =tfage.getText();
            String gender = (String)gendercombo.getSelectedItem();
            String company  = tfcompany.getText();
            String brand_model = tfmodel.getText();
            String availability = (String)availablecombo.getSelectedItem();
            String location = tflocation.getText();
           
           
            try{
                Conn c = new Conn();
                
            String str = "INSERT INTO driver values( '"+name+"','"+age+"','"+gender+"','"+company+"','"+brand_model+"', '"+availability+"', '"+location+"')";
          
            
	c.s.executeUpdate(str);
	JOptionPane.showMessageDialog(null, "New Driver Added Successfully");
            this.setVisible(false);
           
            }catch(Exception e){
            	 e.printStackTrace();
            }
        }
		
	else if (ae.getSource()== back){
		setVisible(false);
		new Dashboard();
	}
	else if (ae.getSource()== cancel){
		setVisible(false);
	}
}
	



	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new AddDriver();
	}

}
