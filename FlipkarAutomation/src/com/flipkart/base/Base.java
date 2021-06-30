package com.flipkart.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base  {
	public WebDriver driver;
	public WebDriver baseMethod() throws Exception {


		System.setProperty("webdriver.chrome.driver","C:\\Chrome_Driver\\chromedriver.exe");			
		driver = new ChromeDriver();

		driver.get("http://www.flipkart.com");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		return driver;
	}
}

