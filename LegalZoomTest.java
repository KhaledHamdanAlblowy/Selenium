package Exam;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LegalZoomTest {
	
	public WebDriver driver;
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/chromedriver");
		driver =new ChromeDriver();
		driver.navigate().to("https://www.legalzoom.com/personal/estate-planning/living-trust-pricing.html"); 
		driver.manage().window().maximize(); 
	}
	
	//Start of test,
	@Test (priority=1)		
	public void personalA() {
		// choosing a package = Basic Living Trust
		driver.findElement(By.cssSelector("div[id='collapse1623156477351-1'] a[class='btn btn-action w-100 w-md-auto w-lg-100 ']")).
		click();
		//What to expect in this questionnaire.
		driver.findElement(By.id("ctl00_cphMainContent_btnContinue2")).click();
		
		//Who is making this trust?
		driver.findElement(By.xpath("//input[@id='chkctlgrantor_selfonly_CB']")).click();
		driver.findElement(By.id("ctl00_cphMainContent_btnContinue2")).click();
		
		//Tell us about yourself.
		driver.findElement(By.name("grantor_first|290240")).sendKeys("");
		driver.findElement(By.id("grantor_middle")).sendKeys("");
		driver.findElement(By.id("grantor_last")).sendKeys("");
		WebElement marriedDropDown = driver.findElement(By.cssSelector("#grantor_married_MC"));
		WebElement childrenDrop = driver.findElement(By.cssSelector("#grantor_children_MC"));
		Select selectMarried = new Select(marriedDropDown);
		selectMarried.selectByIndex(2);
		Select selectChildren = new Select(childrenDrop);
		selectChildren.selectByIndex(2);
		driver.findElement(By.id("ctl00_cphMainContent_btnContinue2")).click();
		
		//Where do you live?
		driver.findElement(By.xpath("//input[@id='grantor_address']")).sendKeys("scott road");
		driver.findElement(By.xpath("//input[@id='grantor_city']")).sendKeys("City");
		driver.findElement(By.xpath("//input[@id='grantor_county']")).sendKeys("America");
		Select stateSelect = new Select(driver.findElement(By.xpath("//select[@id='grantor_state']")));
		stateSelect.selectByVisibleText("Alaska");
		driver.findElement(By.xpath("//input[@id='grantor_zip']")).sendKeys("4000");
		driver.findElement(By.id("ctl00_cphMainContent_btnContinue2")).click();
	}
	
	//Start page is : Overview of how property is placed in a trust.
	@Test (priority=2)		
	public void propertyB() {
		driver.findElement(By.id("ctl00_cphMainContent_btnContinue2")).click();
		driver.findElement(By.xpath("//input[@id='chkctlproperty_personal_CB']")).click();
		driver.findElement(By.id("ctl00_cphMainContent_btnContinue2")).click();
		Select allIntrustDropDown = new Select(driver.findElement(By.xpath("//select[@id='property_personal_MC']")));
		allIntrustDropDown.selectByIndex(2);
		driver.findElement(By.id("ctl00_cphMainContent_btnContinue2")).click();
	}
	
	//Start page is : Overview of how gifts are handled in a trust.
	@Test (priority=3)		
	public void giftsC() {
		driver.findElement(By.id("ctl00_cphMainContent_btnContinue2")).click();
		driver.findElement(By.cssSelector("#grantor_heir_info_percent_1")).sendKeys("50");
		driver.findElement(By.cssSelector("#grantor_heir_info_name_1")).sendKeys("");
		driver.findElement(By.cssSelector("#grantor_heir_info_alt_1")).sendKeys("");
		driver.switchTo().activeElement().sendKeys(Keys.TAB);
		driver.switchTo().activeElement().sendKeys(Keys.ENTER);
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='grantor_heir_info_percent_2']"))).sendKeys("50");
		driver.findElement(By.cssSelector("#grantor_heir_info_name_2")).sendKeys("");
		driver.findElement(By.cssSelector("#grantor_heir_info_alt_2")).sendKeys("");
		driver.findElement(By.id("ctl00_cphMainContent_btnContinue2")).click();
	
		//Do you want to give any specific and charitable gifts?
		driver.findElement(By.id("ctl00_cphMainContent_btnContinue2")).click();
		//Do you want any gifts held in a subtrust?
		driver.findElement(By.id("ctl00_cphMainContent_btnContinue2")).click();
		//Do you want a pour-over will?
		Select pour_overSelect = new Select(driver.findElement(By.xpath("//select[@id='pow_MC']")));
		pour_overSelect.selectByIndex(1);
		driver.findElement(By.id("ctl00_cphMainContent_btnContinue2")).click();
	}
	
	@Test (priority=4)		
	public void representativesD() {
		//Overview of representatives named in trust documents.
		driver.findElement(By.id("ctl00_cphMainContent_btnContinue2")).click();
		//Do you want to appoint a co-trustee?
		driver.findElement(By.id("ctl00_cphMainContent_btnContinue2")).click();
		//Who are the successor trustees?
		driver.findElement(By.cssSelector("#first_successor_trustee")).sendKeys(" ");
		driver.findElement(By.cssSelector("#second_successor_trustee")).sendKeys(" ");
		driver.findElement(By.id("ctl00_cphMainContent_btnContinue2")).click();
		//Do you want to include additional instructions for trustees?
		driver.findElement(By.id("ctl00_cphMainContent_btnContinue2")).click();
	}
	
	@Test (priority=5)		
	public void additionaloptionsE() {
		//Would you like to name the trust?
		driver.findElement(By.id("ctl00_cphMainContent_btnContinue2")).click();
		//Other estate planning options.
		driver.findElement(By.id("ctl00_cphMainContent_btnContinue2")).click();
		//Congratulations - you've taken the next steps. We have everything we need to get started.
		driver.findElement(By.id("ibTestContinueBottom")).click();
		//Choose your package
		driver.findElement(By.cssSelector("input[value='6695']")).click();
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgButton_Continue")).click();
	}
	
	@Test (priority=6)		
	public void checkoutF() throws InterruptedException {
		//Professional Printing
		driver.findElement(By.cssSelector("img[alt='Next Button']")).click();
		//fill info
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ctl00_cphMainContent_txt_ContactInfo_FName"))).sendKeys("kha");
		driver.findElement(By.cssSelector("#ctl00_cphMainContent_txt_ContactInfo_LName")).sendKeys("hhh");
		WebElement phonenumberElement = driver.findElement(By.cssSelector("#ctl00_cphMainContent_txt_ContactInfo_PhoneNumber"));
		phonenumberElement.click();
		phonenumberElement.sendKeys("(011)111-1111");
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("#ctl00_cphMainContent_txt_ContactInfo_EmailAddress")).sendKeys("khad_00@hotmail.com");
		driver.findElement(By.cssSelector("#ctl00_cphMainContent_txt_ContactInfo_Street1")).sendKeys("95 Scott Road");
		driver.findElement(By.cssSelector("#ctl00_cphMainContent_txt_ContactInfo_ZipCode")).sendKeys("12111");
		driver.findElement(By.cssSelector("#ctl00_cphMainContent_txt_ContactInfo_City")).sendKeys("newyork");
		Select stateSelect = new Select(driver.findElement(By.id("ctl00_cphMainContent_ddl_ContactInfo_State")));
		stateSelect.selectByVisibleText("AL");
	
		//payment info
		driver.findElement(By.cssSelector("#ctl00_cphMainContent_txt_PaymentInfo_FName")).sendKeys("khal");
		driver.findElement(By.cssSelector("#ctl00_cphMainContent_txt_PaymentInfo_LName")).sendKeys("khal");
		driver.findElement(By.cssSelector("#ctl00_cphMainContent_txt_CC_Number")).sendKeys("5555555555");
		Select monthSelect = new Select(driver.findElement(By.cssSelector("#ctl00_cphMainContent_ddl_CC_ExpirationMonth")));
		monthSelect.selectByVisibleText("April");
		Select yearSelect = new Select(driver.findElement(By.cssSelector("#ctl00_cphMainContent_ddl_CC_ExpirationYear")));
		yearSelect.selectByVisibleText("2023");
		driver.findElement(By.cssSelector("#ctl00_cphMainContent_txt_CC_ZipCode")).sendKeys("12222");
		driver.findElement(By.cssSelector("#ctl00_cphMainContent_txt_CC_SecurityCode")).sendKeys("444");
		driver.findElement(By.xpath("//*[@id=\"ctl00_cphMainContent_imgbtn_CheckOut\"]/span[2]")).click();
	}
	
	@Test (priority=7)		
	public void errorcreditcardG() {
		String expectedString = "Invalid Credit Card Number";
		String actualString = driver.findElement(By.id("ctl00_cphMainContent_cv_txt_CC_Number")).getText();
		assertEquals(actualString, expectedString);	
		System.out.println(actualString);
	}
	
	@BeforeMethod
	public void waitForAbit() throws InterruptedException {
		Thread.sleep(3000);
	}
	
	@AfterTest 
	public void closeWindow() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
	}
}
