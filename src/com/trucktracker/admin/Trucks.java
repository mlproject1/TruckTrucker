package com.trucktracker.admin;

import javax.sql.DataSource;
import javax.swing.*;

import com.mysql.jdbc.PreparedStatement;
import com.trucktracker.jdbc.datasource.DataSourceTruckTracker;
import com.trucktracker.www.Gui;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

public class Trucks extends Gui{
	
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;

	DataSource ds = DataSourceTruckTracker.getMySQLDataSource();

    Vector<Object> columnNames = new Vector<Object>();
    Vector<Object> data = new Vector<Object>();
    int columns = 0;

	public JPanel setTrucks() {
		
    	try {
    		
        	String sql = "SELECT brand as Brand,model,year,color,cc,gps,"
        			+" (SELECT COUNT(id) FROM trucks WHERE status=1) as totaltrucks"
    				+" FROM trucks WHERE status=1";
    		
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
        
        JButton bAddTruck = new JButton("Add");
        bAddTruck.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	addTruck();
            	
            }
        });
        
        results.add(bAddTruck);
        JButton bEditTruck = new JButton("Update");
        bEditTruck.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
            }
        });
        
        results.add(bEditTruck);
    	
    	return results;
    	
	}

	public JFrame addTruck(){
		
		JFrame fAddTruck = new JFrame("Add Truck");
		fAddTruck.setSize(600,400);
		fAddTruck.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		fAddTruck.setLocationRelativeTo(null);
		fAddTruck.getContentPane().setLayout(null);

		lAddTruckBrand.setBounds(10, 10, 60, 25);
		lAddTruckModel.setBounds(10, 40, 60, 25);
		lAddTruckColor.setBounds(10, 70, 60, 25);
		lAddTruckCC.setBounds(10, 100, 60, 25);
		lAddTruckYear.setBounds(10, 130, 60, 25);
		tAddTruckBrand.setBounds(65, 10, 260, 25);
		tAddTruckBrand.setColumns(10);
		tAddTruckModel.setBounds(65, 40, 260, 25);
		tAddTruckModel.setColumns(10);
		tAddTruckColor.setBounds(65, 70, 260, 25);
		tAddTruckColor.setColumns(10);
		tAddTruckCC.setBounds(65, 100, 260, 25);
		tAddTruckCC.setColumns(10);
		tAddTruckYear.setBounds(65, 130, 260, 25);
		tAddTruckYear.setColumns(10);
		bAddToDBTruck.setBounds(120, 170, 130, 60);
		lErrorMsg.setBounds(10, 250, 260, 60);
		bAddToDBTruck.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	boolean bAddState = (tAddTruckBrand.getText().trim().equals("")||tAddTruckModel.getText().trim().equals("")||tAddTruckColor.getText().trim().equals("")||tAddTruckCC.getText().trim().equals("")||tAddTruckYear.getText().trim().equals(""));
            	addTruckPushed(bAddState);
            }
        });
		
		fAddTruck.getContentPane().add(lAddTruckBrand);
		fAddTruck.getContentPane().add(lAddTruckModel);
		fAddTruck.getContentPane().add(lAddTruckColor);
		fAddTruck.getContentPane().add(lAddTruckCC);
		fAddTruck.getContentPane().add(lAddTruckYear);
		fAddTruck.getContentPane().add(tAddTruckBrand);
		fAddTruck.getContentPane().add(tAddTruckModel);
		fAddTruck.getContentPane().add(tAddTruckColor);
		fAddTruck.getContentPane().add(tAddTruckCC);
		fAddTruck.getContentPane().add(tAddTruckYear);
		fAddTruck.getContentPane().add(bAddToDBTruck);
		fAddTruck.getContentPane().add(lErrorMsg);
		
		fAddTruck.setVisible(true);
		
		return fAddTruck;
	}
	
	public boolean addTruckPushed(boolean bAddState) {
		
    	if (!(bAddState)) {
    		
        	String brand = tAddTruckBrand.getText();
        	String model = tAddTruckModel.getText();
        	String year = tAddTruckYear.getText();
        	String color = tAddTruckColor.getText();
        	String cc = tAddTruckCC.getText();

        	
	        try {
	        	
				String sql = "INSERT INTO trucks (`brand`,`model`,`year`,`color`,`cc`) VALUES ('"+brand+"','"+model+"','"+year+"','"+color+"','"+cc+"')";
	        	
				con = ds.getConnection();
				st = con.createStatement();
				st.executeUpdate(sql);
				ResultSet rs = null;
				
	        	String lastRow = "SELECT brand,model,year,color,cc,gps"
	    				+" FROM trucks WHERE status=1 ORDER BY id DESC LIMIT 1";
	        	
	        	rs = st.executeQuery(lastRow);
	        	
	        	if(rs.next()){
	                Vector<Object> newRow = new Vector<Object>(columns);

	                for (int i = 1; i <= columns; i++) {
	                	
	                    newRow.addElement(rs.getObject(i));
	                    
	                }
		        	
	                data.addElement(newRow);
	                lErrorMsg.setText("<html><font color=#47A447>Truck added to database successfully!</font><br>"+
	                		"Please push the refresh button to see the new truck.</html>");

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
	
	
	
	public JScrollPane truckStatus() {
    	
		DataSource ds = null;
		ds = DataSourceTruckTracker.getMySQLDataSource();
    	try {
    		
        	String sql = "SELECT brand,model,year,color,cc,gps"
        			+" FROM trucks"
    				+" WHERE status!=9";    		
    		
	        con = ds.getConnection();
	        st = con.createStatement();
	        rs = st.executeQuery(sql);
	        ResultSetMetaData rsmd = rs.getMetaData();
	        int columns = rsmd.getColumnCount()-1;
	        
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
    	
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
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
        
        JPanel results = new JPanel();
		JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        results.add(scrollPane);
    	
    	return scrollPane;
    	
	}
	
	
	public void getTrucks(){
		

    	
	}
	
	public Trucks() {
		
		
	}
}
