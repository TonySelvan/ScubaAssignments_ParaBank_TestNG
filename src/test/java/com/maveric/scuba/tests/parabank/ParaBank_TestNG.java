package com.maveric.scuba.tests.parabank;

import org.testng.annotations.Test;

import com.maveric.core.testng.BaseTest;
import com.maveric.scuba.utils.Scubautils;

public class ParaBank_TestNG extends BaseTest{
	
	Scubautils Utils = new Scubautils();
	ParaBank Para = new ParaBank();
	
	@Test
	public void Register_User()
	{
		Para.launch();
		Para.User_Registration();
	}
}
