package com.trucktracker.www;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Gui {
    
    private JFrame f = new JFrame("Truck Tracker");
    JLabel luser = new JLabel("Username: ");
    JLabel lpass = new JLabel("Password: ");
    JTextField tuser = new JTextField(10);
    JPasswordField tpass = new JPasswordField(10);
    JButton b = new JButton("Submit");
    JLabel lmsg = new JLabel();
    JPanel p = new JPanel();
	public JLabel lAddTruckBrand = new JLabel("Brand: ");
	public JLabel lAddTruckModel = new JLabel("Model: ");
	public JLabel lAddTruckColor = new JLabel("Color: ");
	public JLabel lAddTruckCC = new JLabel("CC: ");
	public JLabel lAddTruckYear = new JLabel("Year: ");	
	public JTextField tAddTruckBrand = new JTextField();	
	public JTextField tAddTruckModel = new JTextField();	
	public JTextField tAddTruckColor = new JTextField();	
	public JTextField tAddTruckCC = new JTextField();	
	public JTextField tAddTruckYear = new JTextField();
	public JButton bAddToDBTruck = new JButton("Add to database");
	public JLabel lErrorMsg = new JLabel("");
	public JButton refreshButton = new JButton("Refresh");
	public JLabel lAddTruckerFirstName = new JLabel("First Name: ");
	public JLabel lAddTruckerLastName = new JLabel("Last Name: ");
	public JLabel lAddTruckerEmail = new JLabel("Email: ");
	public JTextField tAddTruckerFirstName = new JTextField();	
	public JTextField tAddTruckerLastName = new JTextField();	
	public JTextField tAddTruckerEmail = new JTextField();	
	public JButton bAddToDBTrucker = new JButton("Add to database");
	
	
	public void loginFrame() {
		
		f.setResizable(false);
    	f.setSize(230,250);
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	f.setLocationRelativeTo(null);
    	f.setVisible(true);
    	
    	p.setLayout(null);
    	luser.setFont(new Font("Tahoma", Font.BOLD, 13));
    	luser.setBounds(10, 41, 73, 14);
    	p.add(luser);
    	tuser.setBounds(93, 39, 121, 20);
    	p.add(tuser);
    	lpass.setFont(new Font("Tahoma", Font.BOLD, 13));
    	lpass.setBounds(10, 72, 73, 14);

    	p.add(lpass);
    	tpass.setBounds(93, 70, 121, 20);
    	p.add(tpass);
    	b.setBounds(10, 101, 204, 34);
    	p.add(b);
    	lmsg.setBounds(10, 145, 204, 50);
    	p.add(lmsg);
    	
    	f.getContentPane().add(p);
		
	}

	
	
	public Gui(){
		
	}



	public JFrame getF() {
		return f;
	}



	public void setF(JFrame f) {
		this.f = f;
	}
}
