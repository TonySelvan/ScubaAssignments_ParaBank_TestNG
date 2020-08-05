package com.maveric.scuba.tests.parabank;

import org.testng.annotations.Test;

import com.maveric.core.testng.BaseTest;
import com.maveric.scuba.utils.Scubautils;

public class ParaBank_TestNG extends BaseTest{
	
	Scubautils Utils = new Scubautils();
	ParaBank Para = new ParaBank();
	
	@Test(priority =1)
	public void Register_User()
	{
		Para.launch();
		Para.User_Registration();
	}
	
	@Test(priority =2)
	public void Paralogin()
	{
		Para.launch();
		Para.login();
	}
	
	@Test(priority =3)
	public void AccountCreation() throws Throwable
	{
		Para.launch();
		Para.login();
		Para.createAccount();
		Para.transferFunds();
		Para.viewAccount();
	}
}
