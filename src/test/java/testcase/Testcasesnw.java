package testcase;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadXLdata;

public class Testcasesnw extends  BaseTest{
	@Test (dataProviderClass = ReadXLdata.class,dataProvider = "sdata")
	public static  void LoginTest(String username,String Password) throws InterruptedException {

		driver.findElement(By.linkText(loc.getProperty("Sign_in"))).click();
		Thread.sleep(5000);
		driver.findElement(By.id(loc.getProperty("email"))).sendKeys(username);
		driver.findElement(By.id(loc.getProperty("nxt_button"))).click();
	Thread.sleep(3000);
		driver.findElement(By.xpath(loc.getProperty("Password"))).sendKeys(Password);
		driver.findElement(By.xpath(loc.getProperty("LoginButton"))).click();
		Thread.sleep(5000);

}
	/*
	@DataProvider(name="testdata")
	public Object[][] tData(){
		return new Object[][] {
			{"dhakane.shm23@gmail.com","@Szz0823"},
			{"dhakane.shubh23@gmail.com","@Shubhzz0823"},
			{"dhakanem23@gmail.com","@Shuz0823"},
			{"dhakane.shubham23@gmail.com","@Shubhzz0823"}
		};*/
	
}