package com.trucktracker.junit;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.trucktracker.www.Login;

public class LoginTest {

	@BeforeClass
	public static void testSetup(){
		System.out.println("Testing Login Starting...");
	}
	
	@AfterClass
	public static void testCleanup(){
		System.out.println("Testing Login Done!");
	}

	@Test
	public void testCheckLogin() {
		Login toTest = new Login();
		assertEquals("These user and pass are valid!", true, toTest.checkLogin("ecs", "ecs123"));
		assertEquals("These user and pass are invalid!", false, toTest.checkLogin("sad", "sad"));
	}
	
	@Test
	public void testSetMenuByLevel() {
		Login toTest = new Login();
		assertEquals("These user and pass are valid!", "Admin", toTest.setMenuByLevel(5));
		assertEquals("These user and pass are valid!", "Mod", toTest.setMenuByLevel(4));
		assertEquals("These user and pass are valid!", "Staff", toTest.setMenuByLevel(2));
		assertEquals("These user and pass are valid!", "Trucker", toTest.setMenuByLevel(1));
	}
	


}
