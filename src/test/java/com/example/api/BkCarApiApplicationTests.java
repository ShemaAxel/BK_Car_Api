package com.example.api;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.Assert;

import com.example.api.domain.Driver;
import com.example.api.mytests.TestData;
import com.example.api.mytests.TestDatabaseSetup;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BkCarApiApplicationTests {

	@Test
	public void testCreateDriver() {
		System.out.print("Adding new Driver");
		Driver d = new Driver(3,"Axel", "axel", "078", 0);
		String msg = Driver.createAc(d);
		Assert.assertTrue(msg.equalsIgnoreCase("Driver created"));
	}
	
	@Test(expected = RuntimeException.class)
	public void testCreateDriverNegativeUpdate() {
		System.out.println("UPDATING DRIVER");
		Driver driver = new Driver(3,"axel", "axel@gmail.com", "078298000", 1);
		String msg = Driver.updateDriver(driver);
		Assert.assertTrue(msg.equalsIgnoreCase("Driver updated"));
	}
	
	@Test
	public void testFindAllDrivers() {
		System.out.println("VIEWING ALL DRIVERS");
		List<Driver> list = Driver.findAll();
		Assert.assertEquals(list.size(), 2);
	}
	
	@Test
	public void testDeleteDriver() {
		System.out.println("Deleting Driver");
		
		Driver driver = new Driver(3,"axel", "axel@gmail.com", "0782980090", 0);
		String msg = Driver.delete(driver);
		Assert.assertTrue(msg.equalsIgnoreCase("Driver deleted"));
	}
	
	@Test
	public void testUpdateDriver() {
		System.out.println("UPDATING DRIVER");
		
		Driver driver = new Driver(3,"axel", "axel@gmail.com", "0782980090", 1);
		String msg = Driver.updateDriver(driver);
		Assert.assertTrue(msg.equalsIgnoreCase("Driver updated"));
	}

	@Before
	public void initialize() {
		System.out.println("Inserting values in DB");
		TestDatabaseSetup.execute(TestData.INSERT_DRIVER);
	}

	@After
	public void clear() {
		System.out.println("Clearing DB");
		TestDatabaseSetup.execute(TestData.DELETE_ALL);
	}

}
