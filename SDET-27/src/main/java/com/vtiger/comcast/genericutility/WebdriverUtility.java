package com.vtiger.comcast.genericutility;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * consists webdriver specific actions
 * @author Priya
 *
 */
public class WebdriverUtility {

	/**
	 * wait for the page to load until the specified element is located until the time lapse
	 * @param driver
	 */
	
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	/**
	 * wait for the page to load until the JS element is located until the time lapse
	 * @param driver
	 */
	
	public void waitForThePageToLoadForJSElement(WebDriver driver) {
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
	}
	
	/**
	 * wait for the page to load until the element is click able until the time lapse
	 * @param driver
	 * @param element
	 */
	
	public void waitForTheElementToBeClickable(WebDriver driver, WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.elementToBeClickable(element));		
	}
	
	public void waitForTheElementToBeVisible(WebDriver driver, WebElement element) {
		WebDriverWait wait= new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.visibilityOf(element));		
	}
	
	/**
	 * used to wait until the element is clickable using in GUI , & check for specific element for every 500 milli seconds
	 * @param driver
	 * @param element
	 * @param pollingTime
	 * @throws InterruptedException
	 */
	
	public void waitForElementWithCustomWait(WebDriver driver, WebElement element, int pollingTime) throws InterruptedException {
		FluentWait wait=new FluentWait(driver);
		wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
		wait.wait(20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * used to Switch to Any Window based on Window Title
	 * @param driver
	 * @param partialwindowtitle
	 */
	
	public void switchToWindow(WebDriver driver, String partialwindowtitle) {
		Set<String> allwh = driver.getWindowHandles();
		Iterator<String> itr = allwh.iterator();
		
		while(itr.hasNext()) {
			String WID = itr.next();
			String currentWindowTitle = driver.switchTo().window(WID).getTitle();
					if(currentWindowTitle.contains(partialwindowtitle)){
						break;
					}
		}
		
	}
	
	/**
	 * used to Switch to Alert Window & click on OK button
	 * @param driver
	 */
	
	public void SwitchToAlertWindowAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	/**
	 * used to Switch to Alert Window & click on Cancel button
	 * @param driver
	 */
	public void SwitchToAlertWindowAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * used to Switch to Frame Window based on index
	 * @param driver
	 * @param index
	 */
	
	public void SwitchToFrame(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}
	
	/**
	 *  used to Switch to Frame Window based on id_name_attribute
	 * @param driver
	 * @param id_name_attribute
	 */
	
	public void SwitchToFrame(WebDriver driver,String id_name_attribute) {
		driver.switchTo().frame(id_name_attribute);
	}
	
	/**
	 * used to select the value from the dropDwon  based on value / option avlaible in GUI
	 * @param element
	 * @param index
	 */
	
	public void SelectByIndex(WebElement element,int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	/**
	 * used to select the value from the dropDwon  based on value / option avlaible in GUI
	 * @param element
	 * @param option
	 */
	
	public void selectByText(WebElement element, String option) {
		Select s=new Select(element);
		s.selectByVisibleText(option);
	}
	
	/**
	 * used to place mouse cursor on specified element
	 * @param driver
	 * @param element
	 */
	
	public void mouseOverOnElement(WebDriver driver, WebElement element) {
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	
	/**
	 * used to right click on specified element
	 * @param driver
	 * @param element
	 */
	
	public void rightClickOnElement(WebDriver driver, WebElement element) {
		Actions a=new Actions(driver);
		a.contextClick(element);
	}
	
	/**
	 * used to execute the scroll actions by passing javascript
	 * @param driver
	 * @param javascript
	 */
	
	public void executeJavaScript(WebDriver driver, String javascript ) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeAsyncScript(javascript, null);
	}
	
	
	/**
	 * used to wait until the time lapse and perform the action
	 * @param element
	 * @throws InterruptedException
	 */
	   public void waitAndClick(WebElement element) throws InterruptedException
	   {
		   int count = 0;
	       while(count<20) {
		    	   try {
		    	       element.click();
		    	       break;
		    	   }catch(Throwable e){
		    		   Thread.sleep(3000);
		    		   count++;
		    	   }
	       }
	   }
	   
	   /**
	    * Takes screen shot
	    * @param driver
	    * @param screenshotName
	    * @throws Throwable
	    */
	   
	   public void takeScreenshot(WebDriver driver, String screenshotName) throws Throwable {
	    	TakesScreenshot ts=(TakesScreenshot)driver;
	    	File src=ts.getScreenshotAs(OutputType.FILE);
	    	File dest=new File("./screenshot/"+screenshotName+".PNG");
	    	Files.copy(src, dest);
	    }
	    
	    /**
	     * pass enter Key appertain in to Browser
	     * @param driver
	     */
	   public void passEnterKey(WebDriver driver) {
		   Actions act = new Actions(driver);
		   act.sendKeys(Keys.ENTER).perform();
	   } 
	
}
