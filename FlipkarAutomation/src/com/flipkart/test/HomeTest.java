package com.flipkart.test;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;


import org.testng.annotations.*;


import com.flipkart.base.Base;
import com.flipkart.page.*;

public class HomeTest {
	WebDriver driver;
	Base bas;
	HomePage home;
	@BeforeClass
	public void beforeClass() throws Exception {

		bas=new Base();
		driver=bas.baseMethod();
		home=new HomePage(driver);
	}

	@Test(priority=1)
	public void verifyElements() throws Exception{
		home.title();
		home.clickClose();
	}
	@Test(priority=2)
	public void searchPhone()throws Exception
	{
		home.verifyHomeElements();
		home.enterSearch();
		home.clickSearchBtn();
		Thread.sleep(5000);
		home.verifyDetails();
		Thread.sleep(5000);
	}


	@AfterClass
	public void afterClass() throws InterruptedException {

		driver.close();

	}
}
