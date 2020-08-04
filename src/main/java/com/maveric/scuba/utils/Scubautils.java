package com.maveric.scuba.utils;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.maveric.core.config.ConfigProperties;
import com.maveric.core.driver.Driver;
import com.maveric.core.testng.BaseTest;
import com.maveric.core.utils.web.WebActions;
import com.maveric.scuba.pageobjects.demoqa.pageobjects;

public class Scubautils extends WebActions{
	
	public  WebElement loc;
	public  WebElement ele;
	WebDriverWait wait;
	public  XSSFWorkbook workbook;
	public  String ExcelPath = ".\\TestData\\parabank.xlsx";
	public  String SheetName = "TestData";
	public  Sheet sheet;

	public void driverinitialize()
	{
		driver = Driver.getWebDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	public void urllaunch(String url)
	{
		driver.navigate().to(url);
		logScreenshot("UrlLaunch");
	}

	public  void driverquit()
	{
		driver.close();
		driver.quit();
	}
	
	
	public  void send(By loc, String value )
	{
		try
		{
//			wait.until(ExpectedConditions.visibilityOf((WebElement) loc ));
			WebElement ele = driver.findElement(loc);
			ele.clear();
			ele.sendKeys(value);
		}
		catch (Exception e) {
	// TODO: handle exception
			String exception = e.getMessage();
			System.out.println(exception);
		}
//		logScreenshot("Value " + value + "is set in " + loc );
	}

	public void Btnclick(By loc)
	{
		try
		{
			Thread.sleep(5000);
//			wait.until(ExpectedConditions.visibilityOfElementLocated(loc));
			WebElement ele = driver.findElement(loc);
			ele.click();
		}
		catch (Exception e) {
	// TODO: handle exception
//			JavascriptExecutor js = (JavascriptExecutor)driver;
//            js.executeScript("arguments[0].click();",ele );
			String exception = e.getMessage();
			e.printStackTrace();
			System.out.println("exception" + exception);
			WebElement element = driver.findElement(loc);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().perform();
		}
	}
	
	public void DblClick(By loc)
	{
		WebElement element = driver.findElement(loc);
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}
	
	public void RightClick(By loc)
	{
		WebElement element = driver.findElement(loc);
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}
	
	public  void linkclick(By loc)
	{
		try
		{
//			wait.until(ExpectedConditions.elementToBeSelected(loc));
			WebElement ele = driver.findElement(loc);
			if (!ele.isSelected()) {
				ele.click();
			}
		}
		catch (Exception e) {
	// TODO: handle exception
			String exception = e.getMessage();
			System.out.println(exception);
		}
	}
	
	public  void dropdownselectval(By loc, String value)
	{
		try
		{
			Select dropdown = new Select(driver.findElement(loc));
			dropdown.selectByValue(value);
			}
		catch (Exception e) {
	// TODO: handle exception
			String exception = e.getMessage();
			System.out.println(exception);
		}
	}
	
	public  void dropdownselectind(By loc, int index)
	{
		try
		{
			Select dropdown = new Select(driver.findElement(loc));
			dropdown.selectByIndex(index);
			}
		catch (Exception e) {
	// TODO: handle exception
			String exception = e.getMessage();
			System.out.println(exception);
		}
	}
	
	public  void dropdownselecttxt(By loc, String value)
	{
		try
		{
			Select dropdown = new Select(driver.findElement(loc));
			dropdown.selectByVisibleText(value);
			}
		catch (Exception e) {
	// TODO: handle exception
			String exception = e.getMessage();
			System.out.println(exception);
		}
	}
	
	public  void datePicker(By objlocator, int Index, By Date, String Year )
	{
		driver.findElement(objlocator).click();
		Select Month_dropdown = new Select(driver.findElement(pageobjects.Month));
		Month_dropdown.selectByIndex(Index);
		Select Year_dropdown = new Select(driver.findElement(pageobjects.Year));
		Year_dropdown.selectByValue(Year);
		driver.findElement(Date).click();
	}
	
	public  void sendDate(By loc, String message)
	{
		Actions action = new Actions(driver);
		WebElement textbox = driver.findElement(loc);
		textbox.clear();
		action.moveToElement(textbox).click(textbox).sendKeys(message).build().perform();		
	}
	
	public  void autofill(By loc, String text)
	{
		WebElement autoOptions= driver.findElement(loc);
	    autoOptions.sendKeys("En");

	    List<WebElement> optionsToSelect = driver.findElements(By.tagName("li"));

	    for(WebElement option : optionsToSelect){
	        System.out.println(option);
	        if(option.getText().equals(text)) {
	            System.out.println("Trying to select: "+text);
	            option.click();
	            break;
	        }
	}
}
	
	public  void UploadFile(By loc)
	{
		
		String path = System.getProperty("user.dir");
        System.out.println(path);
		driver.findElement(loc).sendKeys(path+"\\UploadaFile\\Thamarai.png");
		// click the "UploadFile" button
		//driver.findElement(By.name("send")).click();
	}
	
	public  void pgdwn()
	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		
	}
	
	public  void tabkey()
	{
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).perform();
	}
	
	public  void alertok()
	{
		driver.switchTo().alert().accept();
	}
	
	public void newtab()
	{
		 ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(tabs.get(1));
		 driver.close();
		 driver.switchTo().window(tabs.get(0));
	}
	
	public Integer randomNumber(int maxRange) 
	{	
		Random r = new Random();
		return r.nextInt(maxRange);	
	}
	
	public boolean waitVisible(By by) {
		try {
			WebDriver driver = Driver.getWebDriver();
			WebDriverWait wait = new WebDriverWait(driver,16);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
//			scrollIntoView(by);
			return true;
		}catch(Exception e) {
//			Repot
			e.printStackTrace();
			return false;
		}		
	}
	
	public String getText(By loc) 
	{
		WebDriver driver = Driver.getWebDriver();
		WebElement elem = driver.findElement(loc);
		return elem.getText();	
	}
	
	public List<WebElement> findElements(By by) {
		try {
			waitVisible(by);
			WebDriver driver = Driver.getWebDriver();
			return driver.findElements(by);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public Integer randomNumberinRange(int minRange, int maxRange) {
		
		Random r = new Random();
		return r.nextInt(maxRange - minRange) + minRange ;
		
	}

	public String randomText(int maxRange) {
		
		return RandomStringUtils.randomAlphabetic(1).toUpperCase()+RandomStringUtils.randomAlphanumeric(maxRange-1);
		
	}
//	public  String ReadExcel(int row,int col) throws IOException
//	{
////		String Excel = ".\\TestData\\parabank.xlsx";
//		File file = new File(ExcelPath);
//		FileInputStream inputstream = new FileInputStream(file);
//		workbook = new XSSFWorkbook(inputstream);
//		sheet = workbook.getSheet("SheetName");
//		Row rownum = sheet.getRow(row);
//		String Value = rownum.getCell(col).toString().toLowerCase();
//		System.out.println(Value);
//		return Value;
//	}	
	
	
	public void profileformfilling() throws InterruptedException
	{
		logScreenshot("Practice Form is Launched");
		send(pageobjects.FirstName, "Thamarai Selvan");
		send(pageobjects.LastName, "Kandasamy");
		send(pageobjects.UserEmail, "ktselvan4029@gmail.com");
		Btnclick(pageobjects.Male_Gender);
		send(pageobjects.UserNumber, "9962412123");
		datePicker(pageobjects.DOB, 2, pageobjects.Date, "1990");
		send(pageobjects.Subject_Search,"English");
		tabkey();
		Btnclick(pageobjects.Music_Hobby);
		Btnclick(pageobjects.Reading_Hobby);
		Btnclick(pageobjects.Sports_Hobby);
		UploadFile(pageobjects.ChooseFile);
		send(pageobjects.TextBox_CurrentAddress, "ABC");
		send(pageobjects.Select_State,"NCR");
		tabkey();
		send(pageobjects.Select_City,"Delhi");
		tabkey();
		pgdwn();
		Thread.sleep(5000);
		logScreenshot("All the values are Set");
		Btnclick(pageobjects.ProfileForm_Submit);
		Thread.sleep(5000);
		logScreenshot("Form is Created Successfully");
		Btnclick(pageobjects.ProfileForm_Close);
	}
	
	public void BookStoreApp() throws InterruptedException
	{
		logScreenshot("DemoQA Login Page is launched");
		send(pageobjects.UserName, "ThamaraiSelvan");
		send(pageobjects.Password, "Maveric@123");
		Btnclick(pageobjects.Login_Submit);
		Thread.sleep(5000);
		Btnclick(pageobjects.Goto_BookStore);
		logScreenshot("BookStore is Launched");
		Btnclick(pageobjects.BookName);
		Btnclick(pageobjects.AddCollection);
		Thread.sleep(5000);
		alertok();
		logScreenshot("Book is Added to the Collection");
		Btnclick(pageobjects.Login_Form);
		Btnclick(pageobjects.Profile);
		Btnclick(pageobjects.Delete_Allbooks);
		Btnclick(pageobjects.Delete_Confirm);
		Thread.sleep(2000);
		alertok();
		logScreenshot("All Books are deleted");
		Btnclick(pageobjects.Logout);		
	}
	
////////////////////////////Element Level Functions///////////////////////	
	public void textbox()
	{
		driver.navigate().to("https://demoqa.com/text-box");
		send(pageobjects.TextBox_Fullname, "Thamarai Selvan");
		send(pageobjects.UserEmail, "ktselvan4029@gmail.com");
		send(pageobjects.TextBox_CurrentAddress, "ABC");
		send(pageobjects.TextBox_PermanentAddress, "ABC");
		Btnclick(pageobjects.ProfileForm_Submit);
		logScreenshot("TextBox Element is Completed");
	}
	
	public void checkbox() 
	{
		driver.navigate().to("https://demoqa.com/checkbox");
		Btnclick(pageobjects.CheckBox_Home);
		Btnclick(pageobjects.CheckBox_Expand);
		logScreenshot("CheckBox Element is Completed");
	}
	
	public void radiobutton()
	{
		driver.navigate().to("https://demoqa.com/radio-button");
		Btnclick(pageobjects.RadioButton_YesOption);
		Btnclick(pageobjects.RadioButton_ImpressOption);
		logScreenshot("Radio Button Element is Completed");
	}
	
	public void buttons()
	{
		driver.navigate().to("https://demoqa.com/buttons");
		DblClick(pageobjects.Button_DoubleClick);
		RightClick(pageobjects.Button_RightClick);
		Btnclick(pageobjects.clickMe);
		logScreenshot("Buttons Element is Completed");
	}
	
	public void windows()
	{
		driver.navigate().to("https://demoqa.com/browser-windows");
		Btnclick(pageobjects.Browser_Windows);
		newtab();
		logScreenshot("Windows Element is Completed");
	}
	
	public void alerts()
	{
		driver.navigate().to("https://demoqa.com/alerts");
		Btnclick(pageobjects.AlertButton);
		alertok();	
		logScreenshot("Alert Element is Completed");
	}
	
	public void modal()
	{
		driver.navigate().to("https://demoqa.com/modal-dialogs");
		Btnclick(pageobjects.SmallModal_Button);
		Btnclick(pageobjects.close_small_modal);
		logScreenshot("Modal Element is Completed");
	}
}
