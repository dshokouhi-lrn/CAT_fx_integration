package com.lrn.cat.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class CopyNode extends CATAppCommon {

	static public void copyNode(String lesson, String topic, String page) throws Exception
	{
		try
		{
			Log.startTestCase("starting copy node test case");  
			
			//WebElement productLink = driver.findElement(By.xpath(".//*[@id='j1_7_anchor']"));
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			
			WebElement productLink = null;
			
			if (lesson != "" && topic != "" && page != "")
				productLink = driver.findElement(By.xpath(".//*[@id='courseTree']/ul/li/ul/li[" + lesson + "]/ul/li[" + topic + "]/ul/li[" + page + "]"));
			else if (lesson != "" && topic != "" && page == "")
				productLink = driver.findElement(By.xpath(".//*[@id='courseTree']/ul/li/ul/li[" + lesson + "]/ul/li[" + topic + "]/a"));
			else if (lesson != "" && topic == "" && page == "")
				productLink = driver.findElement(By.xpath(".//*[@id='courseTree']/ul/li/ul/li[" + lesson + "]/a"));

			  
			Log.info("found the page"); 
			  
			Actions action= new Actions(driver);
			action.contextClick(productLink).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
			
			Log.info("right clicked on the page");
			Thread.sleep(10000);
			clickIdentifierXpath("html/body/ul/li[1]/a");
			Log.pass("clicked on copy");
			
			String publish = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			if (publish.contains("Node copy successfull"))
			{
				Log.pass("node successfully copied");
			}
			
			else
				Log.fail("node did not copy for reason: " + publish);
			
			Thread.sleep(20000);
			
		}
		
		   catch(Exception e){  
               Log.fail("Failed to copy node");
               e.printStackTrace();
               throw e;                                        
        } catch(AssertionError e)
        {
               Log.fail("Failed to copy node");
               e.printStackTrace();
               throw e;

        }
	}
}
