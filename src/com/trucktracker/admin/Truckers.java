package com.trucktracker.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.sql.DataSource;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.trucktracker.jdbc.datasource.DataSourceTruckTracker;
import com.trucktracker.www.Gui;

public class Truckers extends Gui {

	 Connection con = null;
	 Statement st = null;
	 ResultSet rs = null;
	    
	 DataSource ds = DataSourceTruckTracker.getMySQLDataSource();
	 
	 Vector<Object> columnNames = new Vector<Object>();
	 Vector<Object> data = new Vector<Object>();
	 int columns = 0;
	 
	public JPanel setTruckers() {		
	    	
	    try {
	    		
	        String sql = "SELECT fname,lname,email,"
	        		+" (SELECT COUNT(id) FROM truckers WHERE status=1) as totaltruckers"
	    			+" FROM truckers WHERE status=1";    		
	    	
	        con = ds.getConnection();
	        st = con.createStatement();
	        rs = st.executeQuery(sql);
	        ResultSetMetaData rsmd = rs.getMetaData();
	        columns = rsmd.getColumnCount()-1;
	        
            for (int i = 1; i <= columns; i++) {
            	
                columnNames.addElement(rsmd.getColumnName(i));
                
            }
		        
	        while (rs.next()) {
	        	
                Vector<Object> row = new Vector<Object>(columns);

                for (int i = 1; i <= columns; i++) {
                	
                    row.addElement(rs.getObject(i));
                    
                }

                data.addElement(row);
	        
	        }
		        
    	} catch (SQLException e) {
    		
    		System.out.println(e);
    		
    	} finally {
	    	
	        try {
	        	
	            if(rs != null) rs.close();
	            if(st != null) st.close();
	            if(con != null) con.close();
	            
	        } catch (SQLException e) {
	        	
	        	System.out.println(e);
	            
	        }
	        
	    }
    	
        final DefaultTableModel model = new DefaultTableModel(data, columnNames) {
        	@Override
            public Class getColumnClass(int column) {
        		
                for (int row = 0; row < getRowCount(); row++) {
                	
                	Object o = getValueAt(row, column);

                    if (o != null) {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };
        
        refreshButton.addActionListener(new ActionListener()
        {   
            public void actionPerformed(ActionEvent e)
            {                  
                if (model != null)
                {
                	model.fireTableDataChanged();
                }              
            }              
        });
        
        
        JPanel results = new JPanel();
        results.add(refreshButton);
		JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        results.add(scrollPane);
        
        JButton bAddTrucker = new JButton("Add");
        bAddTrucker.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	addTrucker();
            	
            }
        });
        
        results.add(bAddTrucker);
        JButton bEditTrucker = new JButton("Update");
        bEditTrucker.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
            }
        });
        
        results.add(bEditTrucker);
    	
    	return results;
    	
	}

	public JFrame addTrucker(){
		
		JFrame fAddTrucker = new JFrame("Add Trucker");
		fAddTrucker.setSize(600,400);
		fAddTrucker.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fAddTrucker.setLocationRelativeTo(null);
		fAddTrucker.getContentPane().setLayout(null);

		lAddTruckerFirstName.setBounds(10, 10, 80, 25);
		lAddTruckerLastName.setBounds(10, 40, 80, 25);
		lAddTruckerEmail.setBounds(10, 70, 80, 25);
		tAddTruckerFirstName.setBounds(85, 10, 260, 25);
		tAddTruckerFirstName.setColumns(10);
		tAddTruckerLastName.setBounds(85, 40, 260, 25);
		tAddTruckerLastName.setColumns(10);
		tAddTruckerEmail.setBounds(85, 70, 260, 25);
		tAddTruckerEmail.setColumns(10);
		bAddToDBTrucker.setBounds(140, 110, 130, 60);
		lErrorMsg.setBounds(10, 190, 260, 60);
		bAddToDBTrucker.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	boolean bAddState = (tAddTruckerFirstName.getText().trim().equals("")||tAddTruckerLastName.getText().trim().equals("")||tAddTruckerEmail.getText().trim().equals(""));
            	addTruckerPushed(bAddState);
            	
            }
        });
		
		fAddTrucker.getContentPane().add(lAddTruckerFirstName);
		fAddTrucker.getContentPane().add(lAddTruckerLastName);
		fAddTrucker.getContentPane().add(lAddTruckerEmail);
		fAddTrucker.getContentPane().add(tAddTruckerFirstName);
		fAddTrucker.getContentPane().add(tAddTruckerLastName);
		fAddTrucker.getContentPane().add(tAddTruckerEmail);
		fAddTrucker.getContentPane().add(bAddToDBTrucker);
		fAddTrucker.getContentPane().add(lErrorMsg);
		
		fAddTrucker.setVisible(true);
		
		return fAddTrucker;
	}
	
	public boolean addTruckerPushed(boolean bAddState) {
		
    	if (!(bAddState)) {
    		
        	String fName = tAddTruckerFirstName.getText();
        	String lName = tAddTruckerLastName.getText();
        	String email = tAddTruckerEmail.getText();
        	
	        try {
	        	
				String sql = "INSERT INTO truckers (`fname`,`lname`,`email`) VALUES ('"+fName+"','"+lName+"','"+email+"')";
	        	
				con = ds.getConnection();
				st = con.createStatement();
				st.executeUpdate(sql);
				ResultSet rs = null;
				
	        	String lastRow = "SELECT fname,lname,email"
	    				+" FROM truckers WHERE status=1 ORDER BY id DESC LIMIT 1";
	        	
	        	rs = st.executeQuery(lastRow);
	        	
	        	if(rs.next()){
	                Vector<Object> newRow = new Vector<Object>(columns);

	                for (int i = 1; i <= columns; i++) {
	                	
	                    newRow.addElement(rs.getObject(i));
	                    
	                }
		        	
	                data.addElement(newRow);
	                lErrorMsg.setText("<html><font color=#47A447>Trucker added to database successfully!</font><br>"+
	                		"Please push the refresh button to see the new trucker.</html>");
	                
	        	}
	        	return true;
			} catch (SQLException ex) {
				ex.printStackTrace();
				return false;
			} finally {
		    	
		        try {
		        	
		            if(rs != null) rs.close();
		            if(st != null) st.close();
		            if(con != null) con.close();
		            
		        } catch (SQLException ex) {
		        	
		        	System.out.println(ex);
		            
		        }
		    }
	        
    	} else {
    		
    		lErrorMsg.setText("All the fields are required!");
    		return false;
    	}
		
	}
	
	 
	 public Truckers() {
			
	 }
	 
}


