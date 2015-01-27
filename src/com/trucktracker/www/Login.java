package com.trucktracker.www;

import javax.swing.*;

import java.awt.event.*;

import javax.sql.DataSource;

import com.trucktracker.admin.Menus;
import com.trucktracker.admin.Truckers;
import com.trucktracker.admin.Trucks;
import com.trucktracker.jdbc.datasource.DataSourceTruckTracker;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login extends Gui{
    
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    
    public String username;
    String fname, lname, email, phone;
	int level,id,status;

    public void loginSetup() {
    	loginFrame();
    	b.addActionListener(new ActionListener() {
    		
    		public void actionPerformed(ActionEvent e) {
    			
    			String user = tuser.getText().trim();
    			String pass = new String(tpass.getPassword());
    			
    			checkLogin(user,pass);
    			
    		}

    	});

    }
    
    public boolean checkLogin(String user, String pass) {
    	
		DataSource ds = null;
		ds = DataSourceTruckTracker.getMySQLDataSource();    	
		
    	try {
    		
        	String sql = "SELECT * FROM users"
    				+" WHERE username='"+user+"' AND password='"+pass+"' AND status=1";    		
    		
	        con = ds.getConnection();
	        st = con.createStatement();
	        rs = st.executeQuery(sql);
	        
	        int cusers = 0;
	        
	        while (rs.next()) {
	        	
	        	cusers++;
	        	fname = rs.getString("fname");
	    		lname = rs.getString("lname");
	    		phone = rs.getString("phone");
	    		email = rs.getString("email");
	    		username = rs.getString("username");
	    		id = rs.getInt("id");
	    		level = rs.getInt("level");
	    		status = rs.getInt("status");
	        	
	        }
	        
	        if (cusers == 0) {
	        	
	        	 lmsg.setText("<html>Wrong Username/Password!<br>Please try again...</html>");
	        	 return false;
	        	 
	        } else if (cusers == 1) {
	        	
	        	lmsg.setText("<html>Login Success!<br>Please wait while redirecting you...</html>");
	        	
	        	setMenuByLevel(level);
	        	return true;
	        	
	        } else if(cusers >= 2) {
	        	
	        	lmsg.setText("<html>Duplicate User!<br>Please contact the administaror...</html>");
	        	return false;
	        } else {
	        	
	        	lmsg.setText("<html>Error!<br>Please contact the administaror...</html>");
	        	return false;
	        } 
    		
    	} catch (SQLException e) {
    		
    		e.printStackTrace();
    		return false;
    		
    	} finally {
	    	
	        try {
	        	
	            if(rs != null) rs.close();
	            if(st != null) st.close();
	            if(con != null) con.close();
	            
	        } catch (SQLException e) {
	        	
	            e.printStackTrace();
	            return false;
	        }
	        
	    }
    	   	
    }
    
    public String setMenuByLevel(int level) {
    	
    	Menus menu = new Menus();
    	
    	String wLevel = null;
    	
    	switch (level) {
    	
			case 5:
				
				getF().setState(JFrame.ICONIFIED);
				getF().getContentPane().remove(p);
				getF().setResizable(false);
				getF().setSize(230,550);
				getF().setLocation(5,5);
				getF().setTitle( "Welcome "+username+"!" );
				getF().setState(JFrame.NORMAL);
				JPanel menuPanel = menu.adminMenu();
				menuPanel.setBounds(0, 0, 220, 310);
				getF().getContentPane().add(menuPanel);
				wLevel = "Admin";
				
			break;
			
			case 4:
				
				getF().setState(JFrame.ICONIFIED);
				getF().getContentPane().remove(p);
				getF().setResizable(false);
				getF().setSize(230,550);
				getF().setLocation(5,5);
				getF().setTitle( "Welcome "+username+"!" );
				getF().setState(JFrame.NORMAL);
				JPanel modMenuPanel = menu.modMenu();
				modMenuPanel.setBounds(0, 0, 220, 310);
				getF().getContentPane().add(modMenuPanel);
				wLevel = "Mod";
				
			break;
			
			case 2:
				
				getF().setState(JFrame.ICONIFIED);
				getF().getContentPane().remove(p);
				getF().setResizable(false);
				getF().setSize(230,550);
				getF().setLocation(5,5);
				getF().setTitle( "Welcome "+username+"!" );
				getF().setState(JFrame.NORMAL);
				JPanel staffMenuPanel = menu.staffMenu();
				staffMenuPanel.setBounds(0, 0, 220, 310);
				getF().getContentPane().add(staffMenuPanel);
				wLevel = "Staff";

			break;
			
			case 1:
				menu.truckerMenu();
				wLevel = "Trucker";
			break;
			
    	}
    	
    	return wLevel;
    	
    }
    
    public Login() {
    	
    	loginSetup();
    	
    }
    
}
