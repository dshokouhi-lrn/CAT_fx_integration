package com.lrn.cat.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class DeletePage extends CATAppCommon {

	/**
	 * Must be called while user is on create your course tab after course has at least 1 page
	 * @param lesson lesson position of the page we are deleting, increase by 1 if landing page is present
	 * @param topic topic position of the page we are deleting
	 * @param page page position of the page we are deleting
	 */
	static public void deletePage(String lesson, String topic, String page) throws Exception
	{
		try
		{
			Log.startTestCase("starting delete page test case");  
			
			Thread.sleep(3000);
			
			//WebElement productLink = driver.findElement(By.xpath(".//*[@id='j1_7_anchor']"));
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			  
			WebElement productLink = driver.findElement(By.xpath(".//*[@id='courseTree']/ul/li/ul/li[" + lesson + "]/ul/li[" + topic + "]/ul/li[" + page + "]"));

			 // WebElement productLink11 = driver.findElement(By.xpath(".//*[@id='j1_7_anchor']"));
			   Actions action= new Actions(driver);
				  action.contextClick(productLink).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
				  Thread.sleep(2000);
				  clickIdentifierXpath("html/body/ul/li[4]/a");
				  Log.info("clicked on Delete");
				  
				  Thread.sleep(1000);
				  
				  //clickIdentifierXpath("//div[@class='ui-dialog-buttonset']/button[1]");
				  
				  clickIdentifierXpath("//div[@aria-describedby='dialogArea']/div[3]/div/button[1]");
				  
				  Log.info("clicked on yes on Delete popup");
			
		}
		
		   catch(Exception e){  
               Log.fail("Failed to delete page");
               e.printStackTrace();
               throw e;                                        
        } catch(AssertionError e)
        {
               Log.fail("Failed to delete page");
               e.printStackTrace();
               throw e;

        }
	}
}
