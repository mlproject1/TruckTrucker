package com.trucktracker.junit;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.trucktracker.admin.Truckers;
import com.trucktracker.www.Gui;
import com.trucktracker.www.Login;

public class TruckersTest extends Gui {

	@BeforeClass
	public static void testSetup(){
		System.out.println("Testing Truckers Starting...");
	}
	
	@AfterClass
	public static void testCleanup(){
		System.out.println("Testing Truckers Done!");
	}

	@Test
	public void testAddTruckersPushed() {
		Truckers toTest = new Truckers();
		tAddTruckerFirstName.setText("Giorgos");
		tAddTruckerLastName.setText("Papandreou");
		tAddTruckerEmail.setText("gio@gmail.com");
		assertEquals("These credetials are valid!", true, toTest.addTruckerPushed(false));
		assertEquals("These credetials are invalid!", false, toTest.addTruckerPushed(true));
	}

}
