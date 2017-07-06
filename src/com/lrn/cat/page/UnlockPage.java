package com.lrn.cat.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class UnlockPage extends CATAppCommon {

	static public void unlockPage(String lesson, String topic, String page) throws Exception
	{
		try
		{
			Log.startTestCase("starting unlock page test case");  
			
			//WebElement productLink = driver.findElement(By.xpath(".//*[@id='j1_7_anchor']"));
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			  
			WebElement productLink = driver.findElement(By.xpath(".//*[@id='courseTree']/ul/li/ul/li[" + lesson + "]/ul/li[" + topic + "]/ul/li[" + page + "]"));

			Actions action1= new Actions(driver);
			action1.contextClick(productLink).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
			clickIdentifierXpath("html/body/ul/li[1]/a");
			Log.pass("clicked on UnLock");
			
		}
		
		   catch(Exception e){  
               Log.fail("Failed to lock page");
               e.printStackTrace();
               throw e;                                        
        } catch(AssertionError e)
        {
               Log.fail("Failed to lock page");
               e.printStackTrace();
               throw e;

        }
	}
}
