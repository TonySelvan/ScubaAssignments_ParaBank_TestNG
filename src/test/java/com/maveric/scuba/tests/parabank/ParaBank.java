package com.maveric.scuba.tests.parabank;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.maveric.core.driver.Driver;
import com.maveric.core.utils.web.WebActions;
import com.maveric.core.utils.web.WebActions;
import com.maveric.scuba.utils.Scubautils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ParaBank{
	
	Scubautils Utils = new Scubautils();
	WebActions Act = new WebActions();
	propertyFileMethods Prop = new propertyFileMethods();
	ParabankPage page = new ParabankPage();
	Logger logger = LogManager.getLogger();
	
	String newAccountNumber = "";
	String firstAccount = "";
	String UserName = "";
	
	@Given("^User Launch the Parabank Application$")
	public void launch()
	{
		WebDriver driver = Driver.getWebDriver();
		Utils.driverinitialize();
		Utils.urllaunch(Prop.readProp("url"));
	}
	
	@Given("^Register The User$")
	public void User_Registration()
	{
		WebDriver driver = Driver.getWebDriver();
		UserName = Prop.readProp("userName") + Utils.randomNumber(1200);
		Utils.Btnclick(page.RegisterLink);
		Utils.logScreenshot("Parabank Site loaded : Login screen");
		Utils.send(page.FirstName, Prop.readProp("FirstName"));
		Utils.send(page.LastName, Prop.readProp("LastName"));
		Utils.send(page.Address, Prop.readProp("Address"));
		Utils.send(page.City, Prop.readProp("City"));
		Utils.send(page.State, Prop.readProp("State"));
		Utils.send(page.Zip, Prop.readProp("Zip"));
		Utils.send(page.Phone, Prop.readProp("Phone"));
		Utils.send(page.SSN, Prop.readProp("SSN"));
		Utils.send(page.UserName, UserName);
		Utils.send(page.Password, Prop.readProp("password"));
		Utils.send(page.ConfirmPassword, Prop.readProp("password"));
		Utils.logScreenshot("Parabank Site : New User Registration Values are Entered");
		Utils.Btnclick(page.RegisterButton);
		Utils.waitVisible(page.CreationSuccess);
		Utils.logScreenshot(String.format("Parabank Site logged in : New user registered with ID %s; Password: %s", UserName, Prop.readProp("password")));
		Utils.Btnclick(page.LogoutLink);
		Utils.waitVisible(page.UserNameTextBox);
		Utils.logScreenshot("Parabank Site logged out after creating registering a new user");
	}
	
	//Login
		@When("^The user should be able to login into Parabank$")
		public void login(){
			
			Utils.send(page.UserNameTextBox, UserName);
			Utils.send(page.PasswordTextBox, Prop.readProp("password"));	
//			screenshot
			Utils.logScreenshot("Credentials entered");		
			Utils.Btnclick(page.LogInButton);
			Utils.waitVisible(page.LogoutLink);			
//			screenshot
			Utils.logScreenshot("Parabank Site logged in successfully");		
			Utils.Btnclick(page.AccountsOverviewLink);
			Utils.waitVisible(page.AccountTableRows);
			Utils.waitVisible(page.getAccNumber(2));
			String firstAccount = Utils.getText(page.getAccNumber(1));
			System.out.println("firstAccount1 - " + firstAccount);	
//			screenshot
			Utils.logScreenshot("Default account : " + firstAccount);		
		}
		
		//Account creation
		@Then("^The user should be able to Create a new Account$")
		public void createAccount(){
			Utils.Btnclick(page.OpenAccountLink);
			Utils.waitVisible(page.AccountTypeDropDown);
			Utils.dropdownselecttxt(page.AccountTypeDropDown, Prop.readProp("accType"));
			Utils.dropdownselecttxt(page.FromAccountDropDown, firstAccount);	
//			screenshot
			Utils.logScreenshot("date entred for create account");
			Utils.Btnclick(page.OpenNewAccountButton);
			Utils.waitVisible(page.AccountNumberLabel);
			Assert.assertTrue(Utils.waitVisible(page.AccountCreationSuccess));
			newAccountNumber = Utils.getText(page.AccountNumberLabel);	
//			screenshot
			Utils.logScreenshot("Account created - '" + newAccountNumber + "'");	
			Utils.Btnclick(page.AccountsOverviewLink);
			Utils.waitVisible(page.AccountTableRows);
//			screenshot
			Utils.logScreenshot("Utilsive accounts");		
		}
		
		//Transfer
		@And("^The user should be able to transferFunds from one accont to another$")
		public void transferFunds() throws Throwable{
			Utils.Btnclick(page.TransferFundsLink);
			Utils.waitVisible(page.ToAccountDropDown);
			Thread.sleep(3000);
			Utils.send(page.AmountTextBox, "100");
			Utils.dropdownselecttxt(page.ToAccountDropDown, firstAccount);
			Utils.dropdownselecttxt(page.FromAccountDropDown, newAccountNumber);	
//			screenshot
			Utils.logScreenshot("selected transUtilsion accounts");		
			Utils.Btnclick(page.TransferButton);
			Utils.waitVisible(page.TransferCompleteLabel);	
//			screenshot
			Utils.logScreenshot("TransUtilsion completed successfully");	
		}
		
		//view txn
		@And("^The user should be able to view the list of accounts$")
		public void viewAccount() {
			Utils.Btnclick(page.AccountsOverviewLink);
			Utils.waitVisible(page.AccountTableRows);
			List<WebElement> eles = Utils.findElements(page.AccountTableRows);
			for (int i = 1; i<=eles.size(); i++) {
				if (Utils.getText(page.getAccNumber(i)).contentEquals(newAccountNumber)){
					String accBal = Utils.getText(page.getAccBalance(i));
					System.out.println(accBal);			
//					screenshots
					Utils.logScreenshot("View Accounts");
				}
			}
		
				//logout
				Utils.Btnclick(page.LogoutLink);
				Utils.waitVisible(page.LogInButton);
						
		//				screenshot
				Utils.logScreenshot("Parabank Site logged out");
			}
}