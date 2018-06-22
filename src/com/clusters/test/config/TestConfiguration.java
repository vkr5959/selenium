package com.clusters.test.config;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class TestConfiguration 
{
	@BeforeSuite
	public void beforeSuite()
	{
Reporter.log("------------Started Suite execution-----------", true);
	}
	@AfterSuite
	public void afterSuite()
	{
Reporter.log("------------Ended Suite execution-------------", true);
	}
	@BeforeClass
	public void beforeClass()
	{
Reporter.log("---------- Started Execution of USer story--------", true);
	}
	@AfterClass
	public void afterClass()
	{
Reporter.log("---------- Ended Execution of USer story--------", true);
	}
}
