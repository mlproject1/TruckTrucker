package com.trucktracker.admin;

import javax.swing.*;

import com.trucktracker.www.Gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Menus extends Gui {
	
	JPanel pMenu = new JPanel();
	JFrame fTrucks = new JFrame("Trucks");
	JFrame fTruckers = new JFrame("Truckers");
	JFrame fStatus = new JFrame("Available Trucks");
	JButton bTruck = new JButton("Trucks");
	JButton bTrucker = new JButton("Truckers");
	JButton bStatus = new JButton("Truck Status");
	JButton bLoad = new JButton("Add Package");
	JButton bStats = new JButton("Stats");

	public JPanel adminMenu() {
    	
		pMenu.setLayout(null);
		bTruck.setFont(new Font("Tahoma", Font.BOLD, 13));
		bTruck.setBounds(10, 10, 200, 50);
		
    	bTruck.addActionListener(new ActionListener() {
    		
    		public void actionPerformed(ActionEvent e) {
    			
    			Trucks trucks = new Trucks();
    			JPanel mainpanel = trucks.setTrucks();
    			mainpanel.setBounds(240, 0, 500, 600);
    			fTrucks.setResizable(true);
    			fTrucks.setSize(800,600);
    			fTrucks.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    			fTrucks.setLocation(245,5);
    			fTrucks.add(mainpanel);
    			fTrucks.setVisible(true);

    		}
    		
    	});
    	
		pMenu.add(bTruck);
		bTrucker.setFont(new Font("Tahoma", Font.BOLD, 13));
		bTrucker.setBounds(10, 70, 200, 50);
		
    	bTrucker.addActionListener(new ActionListener() {
    		
    		public void actionPerformed(ActionEvent e) {
    			
    			Truckers truckers = new Truckers();
    			JPanel mainpanel = truckers.setTruckers();
    			mainpanel.setBounds(240, 0, 500, 600);
    			fTruckers.setResizable(true);
    			fTruckers.setSize(800,600);
    			fTruckers.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    			fTruckers.setLocation(245,5);
    			fTruckers.add(mainpanel);
    			fTruckers.setVisible(true);

    		}
    		
    	});
		
    	pMenu.add(bTrucker);
    	bStatus.setFont(new Font("Tahoma", Font.BOLD, 13));
    	bStatus.setBounds(10, 130, 200, 50);
    	
    	bStatus.addActionListener(new ActionListener() {
    		
    		public void actionPerformed(ActionEvent e) {
    			
    			Trucks trucks = new Trucks();
    			JScrollPane mainpanel = trucks.truckStatus();
    			mainpanel.setBounds(240, 0, 500, 600);
    			fStatus.setResizable(true);
    			fStatus.setSize(800,600);
    			fStatus.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    			fStatus.setLocation(245,5);
    			fStatus.add(mainpanel);
    			fStatus.setVisible(true);

    		}
    		
    	});
    	
    	pMenu.add(bStatus);
    	bLoad.setFont(new Font("Tahoma", Font.BOLD, 13));
    	bLoad.setBounds(10, 190, 200, 50);
    	pMenu.add(bLoad);
    	bStats.setFont(new Font("Tahoma", Font.BOLD, 13));
    	bStats.setBounds(10, 250, 200, 50);
    	pMenu.add(bStats);
    	
    	return pMenu;
    	
	}
	
	public JPanel modMenu() {
		
		pMenu.setLayout(null);
		bTruck.setFont(new Font("Tahoma", Font.BOLD, 13));
		bTruck.setBounds(10, 10, 200, 50);
		
    	bTruck.addActionListener(new ActionListener() {
    		
    		public void actionPerformed(ActionEvent e) {
    			
    			Trucks trucks = new Trucks();
    			JPanel mainpanel = trucks.setTrucks();
    			mainpanel.setBounds(240, 0, 500, 600);
    			fTrucks.setResizable(true);
    			fTrucks.setSize(800,600);
    			fTrucks.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    			fTrucks.setLocation(245,5);
    			fTrucks.add(mainpanel);
    			fTrucks.setVisible(true);

    		}
    		
    	});
    	
		pMenu.add(bTruck);
		bTrucker.setFont(new Font("Tahoma", Font.BOLD, 13));
		bTrucker.setBounds(10, 70, 200, 50);
		
    	bTrucker.addActionListener(new ActionListener() {
    		
    		public void actionPerformed(ActionEvent e) {
    			
    			Truckers truckers = new Truckers();
    			JPanel mainpanel = truckers.setTruckers();
    			mainpanel.setBounds(240, 0, 500, 600);
    			fTruckers.setResizable(true);
    			fTruckers.setSize(800,600);
    			fTruckers.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    			fTruckers.setLocation(245,5);
    			fTruckers.add(mainpanel);
    			fTruckers.setVisible(true);

    		}
    		
    	});
		
    	pMenu.add(bTrucker);
    	bStatus.setFont(new Font("Tahoma", Font.BOLD, 13));
    	bStatus.setBounds(10, 130, 200, 50);
    	
    	bStatus.addActionListener(new ActionListener() {
    		
    		public void actionPerformed(ActionEvent e) {
    			
    			Trucks trucks = new Trucks();
    			JScrollPane mainpanel = trucks.truckStatus();
    			mainpanel.setBounds(240, 0, 500, 600);
    			fStatus.setResizable(true);
    			fStatus.setSize(800,600);
    			fStatus.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    			fStatus.setLocation(245,5);
    			fStatus.add(mainpanel);
    			fStatus.setVisible(true);

    		}
    		
    	});
    	
    	bStats.setFont(new Font("Tahoma", Font.BOLD, 13));
    	bStats.setBounds(10, 250, 200, 50);
    	pMenu.add(bStats);
    	
    	return pMenu;
		
	}
	
	public JPanel staffMenu() {
		    	
		pMenu.setLayout(null);
		bTruck.setFont(new Font("Tahoma", Font.BOLD, 13));
		bTruck.setBounds(10, 10, 200, 50);
		
    	bTruck.addActionListener(new ActionListener() {
    		
    		public void actionPerformed(ActionEvent e) {
    			
    			Trucks trucks = new Trucks();
    			JPanel mainpanel = trucks.setTrucks();
    			mainpanel.setBounds(240, 0, 500, 600);
    			fTrucks.setResizable(true);
    			fTrucks.setSize(800,600);
    			fTrucks.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    			fTrucks.setLocation(245,5);
    			fTrucks.add(mainpanel);
    			fTrucks.setVisible(true);

    		}
    		
    	});
    	
		pMenu.add(bTruck);
		bTrucker.setFont(new Font("Tahoma", Font.BOLD, 13));
		bTrucker.setBounds(10, 70, 200, 50);
		
    	bTrucker.addActionListener(new ActionListener() {
    		
    		public void actionPerformed(ActionEvent e) {
    			
    			Truckers truckers = new Truckers();
    			JPanel mainpanel = truckers.setTruckers();
    			mainpanel.setBounds(240, 0, 500, 600);
    			fTruckers.setResizable(true);
    			fTruckers.setSize(800,600);
    			fTruckers.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    			fTruckers.setLocation(245,5);
    			fTruckers.add(mainpanel);
    			fTruckers.setVisible(true);

    		}
    		
    	});
		
    	pMenu.add(bTrucker);
    	bStatus.setFont(new Font("Tahoma", Font.BOLD, 13));
    	bStatus.setBounds(10, 130, 200, 50);
    	
    	bStatus.addActionListener(new ActionListener() {
    		
    		public void actionPerformed(ActionEvent e) {
    			
    			Trucks trucks = new Trucks();
    			JScrollPane mainpanel = trucks.truckStatus();
    			mainpanel.setBounds(240, 0, 500, 600);
    			fStatus.setResizable(true);
    			fStatus.setSize(800,600);
    			fStatus.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    			fStatus.setLocation(245,5);
    			fStatus.add(mainpanel);
    			fStatus.setVisible(true);

    		}
    		
    	});
    	
    	pMenu.add(bStatus);
    	bLoad.setFont(new Font("Tahoma", Font.BOLD, 13));
    	bLoad.setBounds(10, 190, 200, 50);
    	pMenu.add(bLoad);

    	return pMenu;
    	
	}
	
	public JPanel truckerMenu() {
		
		pMenu.setLayout(null);
		bTruck.setFont(new Font("Tahoma", Font.BOLD, 13));
		bTruck.setBounds(10, 11, 200, 50);
		pMenu.add(bTruck);
		bTrucker.setFont(new Font("Tahoma", Font.BOLD, 13));
		bTrucker.setBounds(10, 72, 200, 50);
    	pMenu.add(bTrucker);
    	bStatus.setFont(new Font("Tahoma", Font.BOLD, 13));
    	bStatus.setBounds(10, 133, 200, 50);
    	pMenu.add(bStatus);
    	bLoad.setFont(new Font("Tahoma", Font.BOLD, 13));
    	bLoad.setBounds(10, 194, 200, 50);
    	pMenu.add(bLoad);
    	
    	return pMenu;
		
	}


}
