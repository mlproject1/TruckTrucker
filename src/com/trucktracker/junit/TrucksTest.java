package com.trucktracker.junit;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.trucktracker.admin.Truckers;
import com.trucktracker.admin.Trucks;
import com.trucktracker.www.Gui;

public class TrucksTest extends Gui{
	
	@BeforeClass
	public static void testSetup(){
		System.out.println("Testing Trucks Starting...");
	}
	
	@AfterClass
	public static void testCleanup(){
		System.out.println("Testing Trucks Done!");
	}

	@Test
	public void testAddTruckPushed() {
		Trucks toTest = new Trucks();
		tAddTruckBrand.setText("some brand");
		tAddTruckModel.setText("some model");
		tAddTruckColor.setText("red");
		tAddTruckCC.setText("5000");
		tAddTruckYear.setText("2015");		
		assertEquals("These credetials are valid!", true, toTest.addTruckPushed(false));
		assertEquals("These credetials are invalid!", false, toTest.addTruckPushed(true));

	}

}
