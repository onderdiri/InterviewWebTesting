package com.bilyoner.test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.Assert;

public class DirectionPage {

	final static Logger logger = Logger.getLogger(DirectionPage.class);

	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
		baseUrl = "https://www.bilyoner.com/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void loginTest() throws Exception {
		driver.get(baseUrl);
		String actualUserName = "17984199";
		String actualPassWord = "153624";
		String expectedPassword, expectedUserName;

		driver.findElement(By.id("j_username")).clear();
		driver.findElement(By.id("j_username")).sendKeys("17984199");
		// Use getAttribute("value") method for get value in Email Textbox
		expectedUserName = driver.findElement(By.id("j_username")).getAttribute("value");

		driver.findElement(By.id("j_password")).clear();
		driver.findElement(By.id("j_password")).sendKeys("153624");
		// Use getAttribute("value") method for get value in Password Textbox
		expectedPassword = driver.findElement(By.id("j_password")).getAttribute("value");

		driver.findElement(By.className("loginButton")).click();
		
		
		try {
			Assert.assertTrue(expectedUserName.equals(actualUserName) && expectedPassword.equals(actualPassWord));
			logger.info("Sisteme " + driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[1]/span[1]")).getText() + " olarak giriþ yapýldý.");
		} catch (AssertionError e) {
			logger.error(driver.findElement(By.className("login-err-text")).getText(), e);
		}
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {}
	}
}
