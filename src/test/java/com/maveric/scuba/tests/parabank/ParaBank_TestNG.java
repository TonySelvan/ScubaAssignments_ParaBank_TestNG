package com.maveric.scuba.tests.parabank;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.maveric.core.testng.BaseTest;
import com.maveric.scuba.utils.Scubautils;

public class ParaBank_TestNG extends BaseTest{
	
	Scubautils Utils = new Scubautils();
	ParaBank Para = new ParaBank();
	Logger logger = LogManager.getLogger();
	
	@Test(priority =1)
	public void Register_User()
	{
		logger.info("Starting the Test : Register_User" );
		Para.launch();
		Para.User_Registration();
		logger.info("Completing the Test : Register_User" );
	}
	
	@Test(priority =2)
	public void Paralogin()
	{
		logger.info("Starting the Test : Paralogin" );
		Para.launch();
		Para.login();
		logger.info("Completing the Test : Paralogin" );
	}
	
	@Test(priority =3)
	public void AccountCreation() throws Throwable
	{
		logger.info("Starting the Test : AccountCreation" );
		Para.launch();
		Para.login();
		Para.createAccount();
		Para.transferFunds();
		Para.viewAccount();
		logger.info("Completing the Test : AccountCreation" );
	}
}
