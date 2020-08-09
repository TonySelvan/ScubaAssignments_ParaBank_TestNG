package com.maveric.scuba.tests.demoqa;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.maveric.core.testng.BaseTest;
import com.maveric.core.utils.web.WebActions;
import com.maveric.scuba.pageobjects.demoqa.pageobjects;
import com.maveric.scuba.utils.*;

public class Demoqa extends BaseTest{
	 
	Scubautils Utils = new Scubautils();
	ScubaMethods Method = new ScubaMethods();
//	ScubaMethods met = new ScubaMethods();
//	WebActions Act = new WebActions();
//	@BeforeTest
//	public void driverinit() 
//	{
//		Utils.urllaunch("https://demoqa.com/");
//	}
//	
//	@AfterMethod
//	public  void driverclose()
//	{
//		Utils.driverquit();
//	}
	
@Test(priority = 1)
public  void ProfileForm() throws InterruptedException {
	Utils.driverinitialize();
	Utils.urllaunch("https://demoqa.com/automation-practice-form");
	Utils.profileformfilling();
}
	
//@Test(priority = 2)
public  void BookStore() throws InterruptedException
{
	Utils.driverinitialize();
	Utils.urllaunch("https://demoqa.com/login");
	Utils.BookStoreApp();
}

@Test
public void AllElements()
{
	Method.login();
	Utils.driverinitialize();
	Utils.urllaunch("https://demoqa.com/login");
//	Utils.textbox();
	Utils.checkbox();
	Utils.radiobutton();
	Utils.buttons();
	Utils.windows();
	Utils.alerts();
	Utils.modal();
}
}