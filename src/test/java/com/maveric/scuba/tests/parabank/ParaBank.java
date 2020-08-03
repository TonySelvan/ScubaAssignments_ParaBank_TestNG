package com.maveric.scuba.tests.parabank;

import org.openqa.selenium.WebDriver;

import com.maveric.core.driver.Driver;
import com.maveric.core.utils.web.WebActions;
import com.maveric.scuba.utils.Scubautils;

import io.cucumber.java.en.Given;

public class ParaBank{
	
	Scubautils Utils = new Scubautils();
	WebActions Act = new WebActions();
	
	@Given("^User Launch the Parabank Application$")
	public void launch()
	{
		Utils.driverinitialize();
		Act.logScreenshot("Browser Launch");
	}
	
	@Given("^Launch the URL$")
	public void lunch_url()
	{
		Utils.urllaunch("https://parabank.parasoft.com/parabank/register.htm");
		Act.logScreenshot("Url Launch");
	}
}