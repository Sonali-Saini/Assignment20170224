package Assignment0303;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import junit.framework.Assert;

public class Assignment03 
{
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
			   WindowPopupModal();
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
		 		public static void WindowPopupModal() throws AWTException
		 		{      Robot robot = new Robot();
				       robot.keyPress(KeyEvent.VK_PAGE_DOWN);
				       robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
				       try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		 			   WebElement WindowPopupModal = driver.findElement(By.xpath("//div[@class='tab-content']//a[contains(text(),'Window Popup Modal')]"));
		 			   boolean assertWindowPopupModal= WindowPopupModal.isDisplayed();
		 			   Assert.assertTrue(assertWindowPopupModal);
		 			   System.out.println("Window Pop up Modal is Present = "+assertWindowPopupModal);
		 			   WindowPopupModal.click();
		 			   String winHandleBefore = driver.getWindowHandle();
		 			   WebElement FollowonTwitter = driver.findElement(By.xpath("//a[contains(text(),'Follow On Twitter')]"));
		 			   Assert.assertTrue(FollowonTwitter.isDisplayed());
		 			   FollowonTwitter.click();
		 			   Set<String> window = driver.getWindowHandles();
		 			   System.out.println(window.size());
		 			   for(String s:window)
		 			   {driver.switchTo().window(s);
		 			    if(driver.getCurrentUrl().equalsIgnoreCase("https://twitter.com/intent/follow?screen_name=seleniumeasy"))
		 			    	driver.close();
		 			    }
		 			    
		 			   System.out.println("Current window closed");
		 			   driver.switchTo().window(winHandleBefore);
		 			   
		 			   WebElement LikeusonFacebook = driver.findElement(By.xpath("//a[contains(text(),'Like us On Facebook ')]"));
		 			   Assert.assertTrue(LikeusonFacebook.isDisplayed());
		 			   LikeusonFacebook.click();
		 			  Set<String> window2 = driver.getWindowHandles();
		 			   System.out.println(window2.size());
		 			   for(String s:window2)
		 			   {driver.switchTo().window(s);
		 			    if(driver.getCurrentUrl().equalsIgnoreCase("https://www.facebook.com/seleniumeasy"))
		 			    	driver.close();
		 			    }
		 			   System.out.println("Current window closed");
		 			   driver.switchTo().window(winHandleBefore);
	
				       robot.keyPress(KeyEvent.VK_PAGE_DOWN);
				       robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
				       try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				       WebElement Follow_TwitterFacebook = driver.findElement(By.xpath("//a[contains(text(),'Follow Twitter & Facebook')]"));
		 			   boolean assertFollow_TwitterFacebook = Follow_TwitterFacebook.isDisplayed();
		 			   Assert.assertTrue(assertFollow_TwitterFacebook);
		 			   System.out.println("Follow Twitter Facebook is Present = "+assertFollow_TwitterFacebook);
		 			   Follow_TwitterFacebook.click();
		 			  Set<String> window3 = driver.getWindowHandles();
		 			   System.out.println(window3.size());
		 			   for(String s:window3)
		 			   {
		 				   driver.switchTo().window(s);
		 			    if(driver.getCurrentUrl().equalsIgnoreCase("https://www.facebook.com/seleniumeasy"))
		 			    	driver.close();
		 			    else if(driver.getCurrentUrl().equalsIgnoreCase("https://twitter.com/intent/follow?screen_name=seleniumeasy"))
		 			         driver.close();
		 			   }
		 			   System.out.println("All Current windows get closed");
		 			   driver.switchTo().window(winHandleBefore);
		 			   
		 			  WebElement Followall = driver.findElement(By.xpath("//a[contains(text(),'Follow Twitter & Facebook')]"));
		 			   boolean assertFollowall = Followall.isDisplayed();
		 			   Assert.assertTrue(assertFollowall);
		 			   System.out.println("Follow all button element is Present = "+assertFollowall);
		 			   Followall.click();
		 			   
		 			  Set<String> window4 = driver.getWindowHandles();
		 			   System.out.println(window4.size());
		 			   for(String s1:window4)
		 			   {
		 				 
		 				driver.switchTo().window(s1);
		 			    /*System.out.println("Open URL is = "+s);*/
		 			    if(driver.getCurrentUrl().equalsIgnoreCase("https://twitter.com/intent/follow?screen_name=seleniumeasy"))
		 			    	driver.close();
		 			    else if(driver.getCurrentUrl().equalsIgnoreCase("https://plus.google.com/+Seleniumeasy"))
		 			         driver.close();
		 			    else if(driver.getCurrentUrl().equalsIgnoreCase("https://www.facebook.com/seleniumeasy"))
		 			          driver.close();
		 			   }
		 			         System.out.println("All three Current windows get closed");
				 			   driver.switchTo().window(winHandleBefore);
		 			        	  
		 			   
		 }
		 	
}
