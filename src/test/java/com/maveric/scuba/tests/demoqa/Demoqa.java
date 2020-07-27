package com.maveric.scuba.tests.demoqa;
import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.maveric.scuba.pageobjects.demoqa.pageobjects;
import com.maveric.scuba.utils.*;

public class Demoqa {
	
	@BeforeMethod
	public static void driverinit() 
	{
		Scubautils.driverinit("chrome");
		Scubautils.urllaunch("https://demoqa.com/");
	}
	
	@AfterMethod
	public static void driverclose() 
	{
		Scubautils.driverquit();
	}
	
	@Test(priority = 1)
	public static void ProfileForm() throws InterruptedException {
		Scubautils.Btnclick(pageobjects.form);
		Scubautils.Btnclick(pageobjects.Practice_Form);
		Scubautils.send(pageobjects.FirstName, "Thamarai Selvan");
		Scubautils.send(pageobjects.LastName, "Kandasamy");
		Scubautils.send(pageobjects.UserEmail, "ktselvan4029@gmail.com");
		Scubautils.Btnclick(pageobjects.Male_Gender);
		Scubautils.send(pageobjects.UserNumber, "9962412123");
		Scubautils.datePicker(pageobjects.DOB, 2, pageobjects.Date, "1990");
		Scubautils.send(pageobjects.Subject_Search,"English");
		Scubautils.tabkey();		
		Scubautils.Btnclick(pageobjects.Music_Hobby);
		Scubautils.Btnclick(pageobjects.Reading_Hobby);
		Scubautils.Btnclick(pageobjects.Sports_Hobby);
		Scubautils.UploadFile(pageobjects.ChooseFile);
		Scubautils.send(pageobjects.TextBox_CurrentAddress, "ABC");
		Scubautils.send(pageobjects.Select_State,"NCR");
		Scubautils.tabkey();
		Scubautils.send(pageobjects.Select_City,"Delhi");
		Scubautils.tabkey();
		Scubautils.pgdwn();
		Thread.sleep(5000);
		Scubautils.Btnclick(pageobjects.ProfileForm_Submit);
		Thread.sleep(5000);
		Scubautils.Btnclick(pageobjects.ProfileForm_Close);
	}
	
@Test(priority = 2)
public static void BookStore() throws InterruptedException
{
		Scubautils.pgdwn();
		Scubautils.Btnclick(pageobjects.BookStoreApplications);
		Scubautils.Btnclick(pageobjects.Login_Form);
		Scubautils.Btnclick(pageobjects.Login_Button);
		Scubautils.send(pageobjects.UserName, "ThamaraiSelvan");
		Scubautils.send(pageobjects.Password, "Maveric@123");
		Scubautils.Btnclick(pageobjects.Login_Submit);
		Thread.sleep(5000);
		Scubautils.Btnclick(pageobjects.Goto_BookStore);
		Scubautils.Btnclick(pageobjects.BookName);
		Scubautils.Btnclick(pageobjects.AddCollection);
		Thread.sleep(5000);
		Scubautils.alertok();
		Scubautils.Btnclick(pageobjects.Login_Form);
		Scubautils.Btnclick(pageobjects.Profile);
		Scubautils.Btnclick(pageobjects.Delete_Allbooks);
		Scubautils.Btnclick(pageobjects.Delete_Confirm);
		Thread.sleep(2000);
		Scubautils.alertok();
		Scubautils.Btnclick(pageobjects.Logout);
}


//@Test
//public void exceldata() throws IOException
//{
//	Scubautils.ReadExcel(1, 1);
//	Scubautils.ReadExcel(1, 2);
//	Scubautils.ReadExcel(1, 3);
//	Scubautils.ReadExcel(1, 4);	
//}
}