package com.maveric.scuba.pageobjects.demoqa;

import org.openqa.selenium.By;

public class pageobjects {

	//*************************************************Elements*****************************************************************
	    public static By Elements = By.xpath("//div[@class='card-body']//h5[text()='Elements']");
	    
	    //=============Text box==================
	    public static By TextBox_TextBox= By.xpath("//span[text()='Text Box']");
	    public static By TextBox_Fullname= By.id("userName");
	    public static By TextBox_EmailId = By.id("userEmail");
	    public static By TextBox_CurrentAddress = By.id("currentAddress");
	    public static By TextBox_PermanentAddress = By.id("permanentAddress");
	    public static By submit = By.xpath("//button[text()='Submit']");
	    
	    //=============Check box==================    
	    public static By CheckBox_Checkbox = By.xpath("//span[text()='Check Box']");
	    public static By CheckBox_Home = By.xpath("//span[@class='rct-checkbox'][1]");
	    public static By CheckBox_Expand = By.xpath("//div[@class='rct-options']//button[1]");
	    public static By CheckBox_Collapse = By.xpath("//div[@class='rct-options']//button[2]");
	    
	    //=============RadioButton==================
	    public static By RadioButton_RadioButton = By.xpath("//span[text()='Radio Button']");    
	    public static By RadioButton_YesOption = By.xpath("//label[@for='yesRadio']");
	    public static By RadioButton_ImpressOption = By.xpath("//label[@for='impressiveRadio']");
	    public static By RadioButton_NoOption = By.xpath("//label[@for='NoRadio']");
	            
	    //=============Buttons==================
	    public static By Button_Buttons = By.xpath("//span[text()='Buttons']");
	    public static By Button_DoubleClick = By.id("doubleClickBtn");
	    public static By Button_RightClick = By.id("rightClickBtn");
	    public static By clickMe = By.xpath("//button[text()='Click Me']");
	    
	    
	    //=============Links=================
	    public static By Link_links = By.xpath("//span[text()='Links']");
	    public static By Link_Created = By.xpath("//*[@id='created']");
	            
	            
	    //=============Upload & Download==================        
	    public static By UploadAndDownload = By.xpath("//span[text()='Upload and Download']");
	    public static By ChooseUploadFile= By.xpath("//div[@class='form-file']//input[@id='uploadFile']");
	    
	    //=============Dynamic Properties==================        
	    public static By DyanmicProperty = By.xpath("//span[text()='Dynamic Properties']");
	    public static By Enable5Secs = By.xpath("//button[@id='enableAfter']");
	    public static By Colorchange = By.xpath("//button[@id='colorChange']");
	    public static By VisibleAfter5secs = By.xpath("//button[@id='Visible After 5 Seconds']");
	    
	    
	    
	//*************************************************Alerts,Frames, Windows*****************************************************************    
	public static By Alerts_Frames_WindowsOptions = By.xpath("//div[text()='Alerts, Frame & Windows']");
	public static By Mainscreen_Alerts_Frames_WindowsOptions = By.xpath("//div[@class='card-body']//h5[text()='Alerts, Frame & Windows']");
	    //=============Alerts==================
	    public static By AlertOption = By.xpath("//span[text()='Alerts']");
	    public static By AlertButton = By.xpath("//Button[text()='Click me']");
	    public static By AlertText =By.xpath("//span[text()='Click Button to see alert ']");
	    
	    //=============Frames==================    
	    public static By FrameOption = By.xpath("//span[text()='Frames']");
	    
	    //=============Browser==================    
	    public static By BrowserOption = By.xpath("//span[text()='Browser Windows']");
	    public static By Browser_Windows =By.xpath("//Button[@id='tabButton']");
	    
	        
	    public static By Modal_DialogsOption = By.xpath("//span[text()='Modal Dialogs']");
	        public static By SmallModal_Button = By.xpath("//Button[@id='showSmallModal']");
	        public static By LargeModal_Button = By.xpath("//Button[@id='showLargeModal']");
	        public static By close_small_modal = By.id("closeSmallModal");

	 


	//*************************************************Interactions*****************************************************************
	    public static By InteractionsButton = By.xpath("//div[text()='Interactions']");
	    public static By SortableButton = By.xpath("//span[text()='Sortable']");
	    public static By SelectableButton = By.xpath("//span[text()='Selectable']");
	    
	    public static By ResizableButton = By.xpath("//span[text()='Resizable']");
	    public static By Resize = By.xpath("(//span[@class='react-resizable-handle react-resizable-handle-se'])[1]");
	    
	    public static By DroppableButton = By.xpath("//span[text()='Droppable']");
	    public static By DragabbleButton = By.xpath("//span[text()='Dragabble']");
	    public static By fromElement = By.xpath("//*[@id='draggable']");
	    public static By toElement = By.xpath("//*[@id='droppable']");
	    
	//public static By Labels(String label)
	//{
//	    String locator = "//div[text()='" + label +  "']";
//	    return (By) driver.findElement(By.xpath(locator));
	//    
	//}
	    
	//*************************************************Interactions*****************************************************************    
	    public static    By Interactions = By.xpath("//div[@class='card-body']//h5[text()='Interaction']");
	    
	//*************************************************Forms*****************************************************************
	    public static    By form = By.xpath("//div[@class='card-body']//h5[text()='Forms']");
	    
	    //=======Practice Forms======
	    public static By Practice_Form = By.xpath("//span[text()='Practice Form']");
	    public static    By FirstName= By.id("firstName");
	    public static    By LastName = By.id("lastName");
	    public static    By UserEmail = By.id("userEmail");
	    public static    By Male_Gender = By.xpath("//label[@for='gender-radio-1']");
	    public static    By Female_Gender = By.xpath("//label[@for='gender-radio-2']");
	    public static    By Other_Gender = By.xpath("//label[@for='gender-radio-3']");
	    public static By UserNumber = By.id("userNumber");
	    public static By DOB = By.id("dateOfBirthInput");
	    public static    By Calendar = By.xpath("//div[@class='react-datepicker__month-container']/child::div[1]/child::div[2]/div/select");
	    public static By Date = By.xpath("//div[text()='23']");
	    public static By Month = By.xpath("//select[@class='react-datepicker__month-select']");
	    public static By Year = By.xpath("//select[@class='react-datepicker__year-select']");
	    public static    By Subject_Search = By.id("subjectsInput");
	    public static    By Sports_Hobby = By.xpath("//label[@for='hobbies-checkbox-1']");
	    public static     By Reading_Hobby = By.xpath("//label[@for='hobbies-checkbox-2']");
	    public static    By Music_Hobby = By.xpath("//label[@for='hobbies-checkbox-3']");
	    public static    By Select_Picture = By.xpath("//label[@for='uploadPicture']");
	    public static    By ChooseFile = By.id("uploadPicture");
	    //currentaddress already declared
	    public static    By Select_State = By.id("react-select-3-input");
	    public static    By Select_City = By.id("react-select-4-input");
	    public static    By ProfileForm_Submit = By.xpath("//button[text()='Submit']");
	    public static    By ProfileForm_Close = By.xpath("//button[text()='Close']");
	        
	//*************************************************Book Store Application*****************************************************************    
	    public static By BookStoreApplications = By.xpath("//div[@class='card-body']//h5[text()='Book Store Application']");
	    
	    //=======Login======
	    public static By Login_Form = By.xpath("//span[text()='Login']");
	    public static By Login_Button = By.xpath("//button[text()='Login']");
	    public static    By UserName= By.id("userName");
	    public static    By Password = By.id("password");
	    public static    By Login_Submit = By.xpath("//button[text()='Login']");
	    public static By BookName = By.id("see-book-Git Pocket Guide");
//	    public static By fklkf = By.xpath("//button[text()='Add To Your Collection']"); 
	    public static By AddCollection = By.xpath("//button[text()='Add To Your Collection']");
	    public static     By Search_book = By.id("searchBox");
	    public static    By Goto_BookStore = By.xpath("//button[text()='Go To Book Store']");
	    public static    By Delete_Allbooks = By.xpath("//button[text()='Delete All Books']");
	    public static By Delete_Confirm = By.id("closeSmallModal-ok");
	    public static    By Delete_Account = By.xpath("//button[text()='Delete Account']");
	    public static  By Loggedin_Profile = By.xpath("//a[contains(text(),'profile')]");
	    public static     By Logout = By.id("submit");

	 

	    //=======Profile======
	    public static By Profile = By.linkText("profile");
//	    public static By Profile = By.id("item-3");
	    public static By login_link = By.xpath("//a[contains(@href, 'login')]");
	    public static By register_link = By.xpath("//a[contains(@href, 'register')]");
	    
	    //=======Book Store======
	    public static By Book_Store = By.xpath("//span[text()='Book Store']");
	    public static By Book1 = By.xpath("//a[text()='Git Pocket Guide']");
	    public static    By BacktoBookStore = By.xpath("//button[text()='Back To Book Store']");
}
