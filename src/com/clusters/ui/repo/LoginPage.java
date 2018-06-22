package com.clusters.ui.repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage 
{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	public WebElement getUsernameTextbox()
	{
		WebElement element = driver.findElement(By.name("username"));
		return element;
	}
	public WebElement getPasswordTextbox()
	{
		return driver.findElement(By.name("pwd"));
	}
	public WebElement getLoginButton()
	{
		return driver.findElement(By.xpath("//input[@type='submit']"));
	}
	public WebElement getErrorMsgText()
	{
		return driver.findElement(By.
				xpath("//span[text()='Username or Password is invalid. Please try again.']"));
	}
	public void waitForLoginPageToLoad()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.
			visibilityOfElementLocated(By.name("LoginForm")));
	}
}
