package com.lrn.cat.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class HidePage extends CATAppCommon {

	static public void hidePage(String lesson, String topic, String page) throws Exception
	{
		try
		{
			Log.startTestCase("starting hide page test case");  
			
			//WebElement productLink = driver.findElement(By.xpath(".//*[@id='j1_7_anchor']"));
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			  
			WebElement productLink = driver.findElement(By.xpath(".//*[@id='courseTree']/ul/li/ul/li[" + lesson + "]/ul/li[" + topic + "]/ul/li[" + page + "]"));

			 // WebElement productLink11 = driver.findElement(By.xpath(".//*[@id='j1_7_anchor']"));
			   Actions action11= new Actions(driver);
			  action11.contextClick(productLink).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
			  clickIdentifierXpath("html/body/ul/li[2]/a");
			  Log.info("clicked on Hide");
			  Thread.sleep(20000);
			
		}
		
		   catch(Exception e){  
               Log.fail("Failed to hide page");
               e.printStackTrace();
               throw e;                                        
        } catch(AssertionError e)
        {
               Log.fail("Failed to hide page");
               e.printStackTrace();
               throw e;

        }
	}
}
