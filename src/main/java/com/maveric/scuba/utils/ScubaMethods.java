package com.maveric.scuba.utils;

import org.openqa.selenium.WebDriver;

import com.maveric.core.driver.Driver;
import com.maveric.core.utils.web.WebActions;

public class ScubaMethods{

	Scubautils Util = new Scubautils();
	WebActions Act = new WebActions();
	
	public void login()
	{	
		Util.driverinitialize();
		Util.urllaunch("https://parabank.parasoft.com/parabank/register.htm");
		Act.logScreenshot("Sheet");
	}
}
