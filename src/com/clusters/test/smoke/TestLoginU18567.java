package com.clusters.test.smoke;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.clusters.generic.utils.CreateDriver;
import com.clusters.test.config.TestConfiguration;
import com.clusters.ui.repo.LoginPage;

public class TestLoginU18567 extends TestConfiguration
{
	WebDriver driver;
	LoginPage login;
	
	@BeforeMethod
	public void preCondition()
	{
		driver = CreateDriver.getDriverInstance();
		login = new LoginPage(driver);
	}
	@Test
	public void testLoginInvalidTC15679()
	{
		login.waitForLoginPageToLoad();
//		Enter valid UN
		login.getUsernameTextbox().sendKeys("admin");
//		Enter invalid password
		login.getPasswordTextbox().sendKeys("Invalid");
//		Click on Login button
		login.getLoginButton().click();
//		Get error mgs
		String actualErrorMsg = login.getErrorMsgText().getText();
		String expectedErrorMsg = "Username or Password is invalid. Please try again.";
		Assert.assertEquals(actualErrorMsg, expectedErrorMsg);
	}
	@AfterMethod
	public void postCondition()
	{
		driver.close();
	}
}
