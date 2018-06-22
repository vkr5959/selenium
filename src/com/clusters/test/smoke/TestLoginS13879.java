package com.clusters.test.smoke;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.clusters.generic.utils.CreateDriver;
import com.clusters.test.config.TestConfiguration;
import com.clusters.ui.repo.LoginPage;

public class TestLoginS13879 extends TestConfiguration
{
	WebDriver driver;
	LoginPage login;
	
	@BeforeMethod
	public void preCOndition()
	{
		driver = CreateDriver.getDriverInstance();
		login = new LoginPage(driver);
	}
	@Test
	public void testLoginInvalidTC18965()
	{
//		Wait for login page
		login.waitForLoginPageToLoad();
		String actual_title = driver.getTitle();
		String expected_title = "actiTIME - Login";
//		Get title and verify it
		Assert.assertEquals(actual_title, expected_title);
//		Enter Invalid Username
		login.getUsernameTextbox().sendKeys("admin123");
//		Enter Invalid password
		login.getPasswordTextbox().sendKeys("invailed");
//		Click on Login button
		login.getLoginButton().click();
//		Get error msg and verify
		String actual_error_msg = login.getErrorMsgText().getText();
		String expected_erro_msg = "Username or Password is invalid. Please try again.";
		Assert.assertEquals(actual_error_msg, expected_erro_msg);
	}
	@AfterMethod
	public void postCondition()
	{
		driver.close();
	}
}
