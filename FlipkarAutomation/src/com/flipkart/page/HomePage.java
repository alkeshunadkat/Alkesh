package com.flipkart.page;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;
import org.testng.Assert;

import com.flipkart.common.ResuableFunctions;

import au.com.bytecode.opencsv.CSVWriter;

public class HomePage {
	//locators
	WebDriver driver;

	ResuableFunctions rf=new ResuableFunctions();
	By closeBtn = By.xpath("/html/body/div[2]/div/div/button");
	By searchBox = By.name("q");
	By searchBtn=By.xpath("//*[@id='container']/div/div[1]/div[1]/div[2]/div[2]/form/div/button");
	By modelName = By.xpath("//*[@class='_4rR01T']");
	By price = By.xpath("//div[@class='_25b18c']");
	By ratings = By.xpath("//*[@class='_2_R_DZ']");
	By sort = By.xpath("/html/body/div[1]/div/div[3]/div[1]/div[2]/div[1]/div/div/div[2]/div[3]");
	String csv = "C:\\Users\\aunadkat\\eclipse-workspace\\FlipkartAutomation\\FlipkarAutomation\\src\\com\\flipkart\\page\\data.csv";

	//Constructor
	public HomePage(WebDriver driver) {

		this.driver=driver;
	}

	//verifying methods
	public void title()
	{
		String title=driver.getTitle();
		System.out.println(title);
		boolean result=rf.StringStartsWith(title,"Online");
		System.out.print(result);
	}

	public void verifyHomeElements()
	{

		boolean slide=driver.findElement(searchBox).isDisplayed();
		Assert.assertEquals(true, slide, "SearchBox not found");

		boolean input=driver.findElement(searchBox).isEnabled();
		Assert.assertEquals(true, input, "Search Button not found");


	}
	public void clickClose()
	{
		driver.findElement(closeBtn).click();
	}


	public void enterSearch()
	{
		driver.findElement(searchBox).sendKeys("iphones");
	}
	public void clickSearchBtn()
	{
		driver.findElement(searchBtn).click();

	}
	public void verifyDetails() throws InterruptedException, IOException
	{
		driver.findElement(sort).click();
		Thread.sleep(5000);
		List<WebElement> modList = driver.findElements(modelName);
		List<WebElement> lis = driver.findElements(price);
		List<WebElement> ratList = driver.findElements(ratings);
		CSVWriter writer = new CSVWriter(new FileWriter(csv));

		List<String[]> data = new ArrayList<String[]>();

		for (int i=0; i<5;i++){
			System.out.println("ModelName :" + modList.get(i).getText());
			System.out.println("Price :" + lis.get(i).getText());

			data.add(new String[] {modList.get(i).getText(), lis.get(i).getText(), ratList.get(i).getText() });
		}
		writer.writeAll(data);

		writer.close();
	}

}



