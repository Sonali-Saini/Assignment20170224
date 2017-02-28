/*==============================================================================================================================
 File Name    : Assignment0224.java
 ClassName    : Assignment0224
 Summary      : Contains demo test to login.
 ===============================================================================================================================
 History      :   Company            Created By     
                  360logica			 Sonali Saini                         

 ===============================================================================================================================
 Remarks      :   Tests - 
 ===============================================================================================================================*/
package Assignment2;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class Assignment0224 {
	/**
	 * 
	 * @author 360logica
	 * @version 1.0 <br>
	 *          Date Created: 24/02/2017 <br>
	 *          Test Case: Assignment20170224 <br>
	 *          Priority: P1 <br>
	 *          Status: Active <br>
	 *          Automated: Yes <br>
	 *          Execution Time: 1 minutes. <br>
	 *          <b>Steps:</b> Step 1: Launch web browser (Chrome).
	 *          Step 2: Click on Start Practising button Step 3: Click on simpleformdemo
	 *          Step 4: Click on Start Practising button 5: checkboxdemo and perform check 
	 *          box functionality Step 6:Click on Start Practising button Step 7: Click on Radiobuttonsdemo
	 *          and perform radio button functionality Step 8: Click on Start Practising button Step9: Click on
	 *          SelectDropdownList and perform select functionality
	 * @param none
	 * @return None.
	 * @throws Exception
	 * @exception None.
	 */
	 public static WebDriver driver; 
	public static void main(String[] args) throws AWTException, InterruptedException {
	   String baseurl = "http://www.seleniumeasy.com/test/"; 
       System.setProperty("webdriver.chrome.driver", "D:\\Java\\chromedriver.exe");
	   driver = new ChromeDriver(); 
	   driver.manage().window().maximize();
	   System.out.println("Maximize Window");
	   driver.get(baseurl);
	   
		//Delete cookies
		driver.manage().deleteAllCookies();
		
	   System.out.println("Open http://www.seleniumeasy.com/");
	   String currenturl = driver.getCurrentUrl();
	   System.out.println("Current open URL is = "+currenturl);
	    Assert.assertEquals(baseurl, currenturl);
	   System.out.println("URL matching");
	   
	   Robot robot = new Robot();
	   robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	   robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	   Thread.sleep(2000);
	   startpractising();
	   Thread.sleep(2000);
	   simpleformdemo();
	   driver.navigate().back();
	   startpractising();
	   checkboxdemo();
	   driver.navigate().back();
	   startpractising();
	   Radiobuttonsdemo();
	   driver.navigate().back();
	   startpractising();
	   SelectDropdownList();
	   //Close window
		driver.quit();
	}

	public static WebDriver getWebDriver(){
		return driver;
	}
	public static void startpractising()
	   {
		//Verify element present
		   boolean present;
		   try {
		      driver.findElement(By.id("btn_basic_example"));
		      present = true;
		   } catch (NoSuchElementException e) {
		      present = false;
		   } 
		   System.out.println("Verify startpractising Element Prresent = "+present);
	    WebElement start_practising = getWebDriver().findElement(By.id("btn_basic_example"));
	    Actions actions = new Actions(getWebDriver());
	    actions.moveToElement(start_practising);
	    actions.click();
	    actions.perform();
	  
	   }
	public static void simpleformdemo()
	{
		   WebElement simple_form_demo = driver.findElement(By.xpath("//div[@class='tab-content']//a[contains(text(),'Simple Form Demo')]"));
		   boolean assertsimple_form_demo = simple_form_demo.isDisplayed();
		   Assert.assertTrue(assertsimple_form_demo);
		   System.out.println("Simple Form Demo is Present = "+assertsimple_form_demo);
		   simple_form_demo.click();
		   
		   WebElement enter_message = driver.findElement(By.xpath("//input[@class='form-control']"));
		   enter_message.sendKeys("Enter Message");
		   WebElement show_message = driver.findElement(By.xpath("//button[text() = 'Show Message']"));
		   show_message.click();
		   WebElement your_message = driver.findElement(By.xpath("//div[@id='user-message']//span[@id='display']"));
		   String message = your_message.getText();
		   System.out.println("Message is = "+message);
		   Assert.assertEquals("Enter Message", message);
		   System.out.println("Actual message is equal to Expected message");
		   
		   WebElement enter_a = driver.findElement(By.xpath("//input[@id='sum1']"));
		   enter_a.sendKeys("20");
		   WebElement enter_b = driver.findElement(By.xpath("//input[@id='sum2']"));
		   enter_b.sendKeys("20");
		   WebElement Get_total = driver.findElement(By.xpath("//button[text() = 'Get Total']"));
		   Get_total.click();
		   WebElement display_value = driver.findElement(By.xpath("//div[@class ='panel-body']//span[@id='displayvalue']"));
		   String value = display_value.getText();
		   Assert.assertEquals("40", value);
	}
	public static void checkboxdemo()
	{
		   WebElement checkbox_demo = driver.findElement(By.xpath("//div[@class='tab-content']//a[contains(text(),'Check Box Demo')]"));
		   try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		   boolean assertcheckbox_demo = checkbox_demo.isDisplayed();
		   Assert.assertTrue(assertcheckbox_demo);
		   System.out.println("Checkbox Demo is Present = "+assertcheckbox_demo);
		   checkbox_demo.click();
		   //Verify element present
		   boolean present;
		   try {
		      driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
		      present = true;
		   } catch (NoSuchElementException e) {
		      present = false;
		   }
		   System.out.println("Verify checkbox Element Prresent = "+present);
		   WebElement isageselected = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
		   //isageselected.clear();
		   isageselected.click();
		   WebElement display_success_message = getWebDriver().findElement(By.xpath("//div[@id='txtAge']"));
		   String success_value = display_success_message.getText();
		   System.out.println("Dispaly success message is = "+success_value);
		   Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_PAGE_DOWN);
			   robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
			   try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				   
		 //Verify element present
		   /*try {
			      driver.findElement(By.xpath("//div[@class='panel-body']//input[starts-with(text(),'Option 1')]"));
			      present = true;
			   } catch (NoSuchElementException e) {
			      present = false;
			   }
		   System.out.println("Option 1 element is present = "+present);
		   
		   WebElement Option1 = getWebDriver().findElement(By.xpath("//div[@class='panel-body']//input[starts-with(text(),'Option 1')]"));
		   Option1.click();*/
		 //Verify Check all button is present
		   try {
			      driver.findElement(By.xpath("//input[@value='Check All']"));
			      present = true;
			   } catch (NoSuchElementException e) {
			      present = false;
			   }
		   System.out.println("Check All button is present = "+present);
		   getWebDriver().findElement(By.xpath("//input[@value='Check All']")).click();
		   WebElement verifycheckall = getWebDriver().findElement(By.xpath("//input[@value='Uncheck All']"));
		  String verifyCheckAll = verifycheckall.getAttribute("value");
		  System.out.println("verify Check all button name after click on is "+verifyCheckAll);
		   Assert.assertEquals("Uncheck All", verifyCheckAll);
	}
	public static void Radiobuttonsdemo()
	{
		 WebElement radiobutton_demo = driver.findElement(By.xpath("//div[@class='tab-content']//a[contains(text(),'Radio Buttons Demo')]"));
		   try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		   boolean assertradiobutton_demo = radiobutton_demo.isDisplayed();
		   Assert.assertTrue(assertradiobutton_demo);
		   System.out.println("Radion Button Demo is Present = "+assertradiobutton_demo);
		   radiobutton_demo.click();
		   WebElement female = getWebDriver().findElement(By.xpath("//input[@value='Female']"));
		   boolean assertFemale = female.isEnabled();
		   Assert.assertTrue(assertFemale);
		   System.out.println("Female radio button is enabled =  "+assertFemale);
		   female.click();
		   WebElement GetCheckedValue = getWebDriver().findElement(By.xpath("//button[contains(text(),'Get Checked value')]"));
		   boolean assertGetchecked = GetCheckedValue.isDisplayed();
		   Assert.assertTrue(assertGetchecked);
		   System.out.println("Get Checked Value button is displayed = "+assertGetchecked);
		   GetCheckedValue.click();
		   WebElement radiobutton_value = getWebDriver().findElement(By.xpath("//p[@class='radiobutton']"));
		   String getradiobutton_value = radiobutton_value.getText();
		   System.out.println("Selected Radio button value is = "+getradiobutton_value);
           Assert.assertEquals("Radio button 'Female' is checked", getradiobutton_value);
		   System.out.println("Actual value is equal to Expected value");
	}
	public static void SelectDropdownList()
	{
		WebElement SelectDropdownList = driver.findElement(By.xpath("//div[@class='tab-content']//a[contains(text(),'Select Dropdown List')]"));
		   try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		   boolean assertSelectDropdownList = SelectDropdownList.isDisplayed();
		   Assert.assertTrue(assertSelectDropdownList);
		   System.out.println("Select Dropdown List is Present = "+assertSelectDropdownList);
		   SelectDropdownList.click();
		   Select selectvalue = new Select(getWebDriver().findElement(By.xpath("//select[@id='select-demo']")));
		   selectvalue.selectByValue("Sunday");
		   WebElement selectedoption = selectvalue.getFirstSelectedOption();
		   String SelectedOption = selectedoption.getText();
		   System.out.println("Selected option is ="+SelectedOption);
		   Assert.assertEquals("Sunday", SelectedOption);
		   WebElement dayselected = getWebDriver().findElement(By.xpath("//p[@class='selected-value']"));
		   String dayselectedvalue = dayselected.getText();
		   System.out.println("Day selected value is = "+dayselectedvalue);
		   
		   Select selectcityvalue = new Select(getWebDriver().findElement(By.xpath("//select[@id='multi-select']")));
		   selectcityvalue.selectByValue("Florida");
		   WebElement selectedcityoption = selectcityvalue.getFirstSelectedOption();
		   String SelectedCityOption = selectedcityoption.getText();
		   System.out.println("Selected option is ="+SelectedCityOption);
		   Assert.assertEquals("Florida", SelectedCityOption);
		   WebElement firstselected = getWebDriver().findElement(By.xpath("//button[contains(text(),'First Selected')]"));
		   boolean assertfirstSelected = firstselected.isDisplayed();
		   Assert.assertTrue(assertfirstSelected);
		   System.out.println("Selected button = "+assertfirstSelected);
		   firstselected.click();
		   WebElement firstselectedoption = getWebDriver().findElement(By.xpath("//p[@class='getall-selected']"));
		   String FirstSelectedOption = firstselectedoption.getText();
		   System.out.println("Selected otion = "+FirstSelectedOption);
		   
	}

	private static void foreach(Object selectoption) {
		// TODO Auto-generated method stub
		
	}
	
}
