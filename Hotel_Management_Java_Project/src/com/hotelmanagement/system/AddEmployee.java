
package com.hotelmanagement.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class AddEmployee extends JFrame implements ActionListener {

	JTextField tfname,tfgender,tfemail,tfaadhar,tfphone,tfage,tfsalary;
    JComboBox c1;
    JButton submit,back,cancel;
    JRadioButton rbmale,rbfemale,rbother;

	 AddEmployee(){
		 setLayout(null);
		 
			
			JLabel lblname =new JLabel("NAME");
			lblname.setBounds(60,30,120,30);
			lblname.setFont(new Font("Tahoma",Font.PLAIN,17));
			add(lblname);
			
			 tfname =new JTextField();
			tfname.setBounds(200,30,150,30);
			add(tfname);
			
			JLabel lblage =new JLabel("AGE");
			lblage.setBounds(60,80,120,30);
			lblage.setFont(new Font("Tahoma",Font.PLAIN,17));
			add(lblage);
			
			tfage =new JTextField();
			tfage.setBounds(200,80,150,30);
			add(tfage);
			
			JLabel lblgender =new JLabel("GENDER");
			lblgender.setBounds(60,130,120,30);
			lblgender.setFont(new Font("Tahoma",Font.PLAIN,17));
			add(lblgender);
			
			 rbmale = new JRadioButton("Male");
			rbmale.setBackground(Color.WHITE);
			rbmale.setBounds(200,130,70,30);
			rbmale.setFont(new Font("Tahoma",Font.PLAIN,17));
	        add(rbmale);
	        
	         rbfemale = new JRadioButton("Female");
			rbfemale.setBackground(Color.WHITE);
			rbfemale.setBounds(280,130,70,30);
			rbfemale.setFont(new Font("Tahoma",Font.PLAIN,14));
	        add(rbfemale);
	        ButtonGroup bg =new ButtonGroup();
	        bg.add(rbfemale);
	        bg.add(rbmale);
	        bg.add(rbother);
	        
	        rbother = new JRadioButton("Other");
			rbother.setBackground(Color.WHITE);
			rbother.setBounds(360,130,70,30);
			rbother.setFont(new Font("Tahoma",Font.PLAIN,17));
	        add(rbother);

	        JLabel lbljob =new JLabel("JOB");
			lbljob.setBounds(60,180,120,30);
			lbljob.setFont(new Font("Tahoma",Font.PLAIN,17));
			add(lbljob);
			
			 String str[] = {" ","Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
			  c1  = new JComboBox(str);
		        c1.setBackground(Color.WHITE);
		        c1.setBounds(200,180,150,30);
		        add(c1);
		        
		        JLabel lblsalary = new JLabel("SALARY");
		        lblsalary.setFont(new Font("Tahoma", Font.PLAIN, 17));
		        lblsalary.setBounds(60, 230, 120, 30);
		        add(lblsalary);
				
		        tfsalary = new JTextField();
		        tfsalary.setBounds(200, 230, 120, 30);
		        add(tfsalary);
		        
		        JLabel lblphone = new JLabel("PHONE");
		        lblphone.setFont(new Font("Tahoma", Font.PLAIN, 17));
		        lblphone.setBounds(60, 280, 120, 30);
		        add(lblphone);

		        tfphone = new JTextField();
		        tfphone.setBounds(200, 280, 120, 30);
		        add(tfphone);
		        
		        
		        JLabel lblemail = new JLabel("EMAIL");
		        lblemail.setFont(new Font("Tahoma", Font.PLAIN, 17));
		        lblemail.setBounds(60, 380, 120, 30);
		        add(lblemail);
				
		        tfemail = new JTextField();
		        tfemail.setBounds(200, 380, 120, 30);
		        add(tfemail);
        
		        JLabel lblaadhar = new JLabel("AADHAR");
		        lblaadhar.setFont(new Font("Tahoma", Font.PLAIN, 17));
		        lblaadhar.setBounds(60, 330, 120,30);
		        add(lblaadhar);
				
		        tfaadhar = new JTextField();
		        tfaadhar.setBounds(200, 330, 120, 30);
		        add(tfaadhar);
		        
		        submit =new JButton("SUBMIT");
		        submit.setBounds(10,450,150,30);
		        submit.setBackground(Color.BLACK);
		        submit.setForeground(Color.WHITE);
		        submit.addActionListener(this);
				add(submit);


				back = new JButton("Back");
				back.setBounds(200,450,150,30);
				back.setBackground(Color.BLACK);
				back.setForeground(Color.WHITE);
				back.addActionListener(this);
				add(back);
				
				cancel = new JButton("Cancel");
				cancel.addActionListener(this);
				cancel.setBounds(400, 450, 150, 30);
			    cancel.setBackground(Color.BLACK);
			    cancel.setForeground(Color.WHITE);
				add(cancel);
				
				 ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
			        Image i2 = i1.getImage().getScaledInstance(450, 450,Image.SCALE_DEFAULT);
			        ImageIcon i3 = new ImageIcon(i2);
			        JLabel image = new JLabel(i3);
			        image.setBounds(380,120,450,380);
			        add(image);


			
		
		 getContentPane().setBackground(Color.WHITE);
		 setBounds(350,200,850,540);
		 setVisible(true);
		
		 
	 }
	 
	 
	@Override
	public void actionPerformed(ActionEvent ae) {
		  String name   = tfname.getText();
          String age    = tfage.getText();
          String salary = tfsalary.getText();
          String phone  = tfphone.getText();
          String aadhar = tfaadhar.getText();
          String email  = tfemail.getText();
         
          String gender = null;
          if(ae.getSource()==submit) {
  			
          
          if(name.equals("")) {
        	  JOptionPane.showMessageDialog(null, "name should not be empty");
        	  return;
          }
          
          if(aadhar.equals("")) {
        	  JOptionPane.showMessageDialog(null, "aadhar should not be empty");
        	  return;
          }
          
          if(email.equals("")) {
        	  JOptionPane.showMessageDialog(null, "email should not be empty");
        	  return;
          }
          
          if(phone.equals("")) {
        	  JOptionPane.showMessageDialog(null, "phone should not be empty");
        	  return;
          }
        
          if(rbmale.isSelected()){
              gender = "male";
          
          }else if(rbfemale.isSelected()){
              gender = "female";
          }else if (rbother.isSelected()) {
        	  gender = "other";
          }
    		
         
          String job = (String)c1.getSelectedItem();
          
          try {
              Conn c = new Conn();
              String query = "INSERT INTO employee values( '"+name+"', '"+age+"', '"+gender+"','"+job+"', '"+salary+"', '"+phone+"','"+email+"', '"+aadhar+"')";
              
              c.s.executeUpdate(query);
              JOptionPane.showMessageDialog(null,"Employee Added Successfully");
              setVisible(false);
          
          } catch (Exception e) {
              e.printStackTrace();
          }
          }
          else if (ae.getSource()== back)  {
      		setVisible(false);
    		new Dashboard();
          }
          else if (ae.getSource() == cancel){
        	  setVisible(false);
          }
	}
          

	public static void main(String[] args) {
		new  AddEmployee ();

	}

}
