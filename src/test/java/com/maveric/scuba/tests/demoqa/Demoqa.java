package com.maveric.scuba.tests.demoqa;
import java.io.IOException;

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
//	WebActions Act = new WebActions();
//	@BeforeTest
//	public void driverinit() 
//	{
//		System.out.println("In before Test");
//		Utils.driverinit();
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
		Utils.driverinit();
		Utils.urllaunch("https://demoqa.com/");
		Utils.Btnclick(pageobjects.form);
//		Act.logScreenshot("PofileForm");
//		Utils.Btnclick(pageobjects.Practice_Form);
//		Utils.send(pageobjects.FirstName, "Thamarai Selvan");
//		Utils.send(pageobjects.LastName, "Kandasamy");
//		Utils.send(pageobjects.UserEmail, "ktselvan4029@gmail.com");
//		Utils.Btnclick(pageobjects.Male_Gender);
//		Utils.send(pageobjects.UserNumber, "9962412123");
//		Utils.datePicker(pageobjects.DOB, 2, pageobjects.Date, "1990");
//		Utils.send(pageobjects.Subject_Search,"English");
//		Utils.tabkey();		
//		Utils.Btnclick(pageobjects.Music_Hobby);
//		Utils.Btnclick(pageobjects.Reading_Hobby);
//		Utils.Btnclick(pageobjects.Sports_Hobby);
//		Utils.UploadFile(pageobjects.ChooseFile);
//		Utils.send(pageobjects.TextBox_CurrentAddress, "ABC");
//		Utils.send(pageobjects.Select_State,"NCR");
//		Utils.tabkey();
//		Utils.send(pageobjects.Select_City,"Delhi");
//		Utils.tabkey();
//		Utils.pgdwn();
//		Thread.sleep(5000);
//		Utils.Btnclick(pageobjects.ProfileForm_Submit);
//		Thread.sleep(5000);
//		Utils.Btnclick(pageobjects.ProfileForm_Close);
	}
	
//@Test(priority = 2)
public  void BookStore() throws InterruptedException
{
		Utils.pgdwn();
		Utils.Btnclick(pageobjects.BookStoreApplications);
		Utils.Btnclick(pageobjects.Login_Form);
		Utils.Btnclick(pageobjects.Login_Button);
		Utils.send(pageobjects.UserName, "ThamaraiSelvan");
		Utils.send(pageobjects.Password, "Maveric@123");
		Utils.Btnclick(pageobjects.Login_Submit);
		Thread.sleep(5000);
		Utils.Btnclick(pageobjects.Goto_BookStore);
		Utils.Btnclick(pageobjects.BookName);
		Utils.Btnclick(pageobjects.AddCollection);
		Thread.sleep(5000);
		Utils.alertok();
		Utils.Btnclick(pageobjects.Login_Form);
		Utils.Btnclick(pageobjects.Profile);
		Utils.Btnclick(pageobjects.Delete_Allbooks);
		Utils.Btnclick(pageobjects.Delete_Confirm);
		Thread.sleep(2000);
		Utils.alertok();
		Utils.Btnclick(pageobjects.Logout);
}


//@Test
//public void exceldata() throws IOException
//{
//	Utils.ReadExcel(1, 1);
//	Utils.ReadExcel(1, 2);
//	Utils.ReadExcel(1, 3);
//	Utils.ReadExcel(1, 4);	
//}
}