package com.lrn.cat.page;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.lcec.pages.ModuleManager;
import com.lrn.pp.utility.Log;

public class CustomizerRole extends CATAppCommon{
	

	/**
	 * Get Started tab edits for customizer role, at the end will navigate user to create your course tab, leave the descriptions blank as customizer cannot edit them
	 * @param getStartedText leave blank for now
	 * @param Description leave blank for now
	 * @param longDesc leave blank for now
	 * @param hasAudio YES/NO
	 * @param courseDuration numeric only
	 * @param courseObjective leave blank for now
	 */
	static public void customizerGetStarted(String getStartedText, String Description, String longDesc, String hasAudio, String courseDuration, String courseObjective) throws Exception
	{
		try
		{
			Date d = new Date();
			
			Log.startTestCase("start editing get started tab as customizer");
			
			if (driver.findElement(By.id("ckeditorContentDescription")).isDisplayed())
			{
				if (Description != "")
					typeTextById("ckeditorContentDescription", Description + " "  + d.toString());
			}
			
			if (driver.findElement(By.id("ckeditorContentCourseObjective")).isDisplayed())
			{
				if (courseObjective != "")
					typeTextById("ckeditorContentCourseObjective", courseObjective + " "  + d.toString());
			}
			
			if (driver.findElement(By.id("ckeditorContentLong")).isDisplayed())
			{
				if (longDesc != "")
					typeTextById("ckeditorContentLong", longDesc + " "  + d.toString());
			}
			
			if (driver.findElement(By.id("ckeditorContentShort")).isDisplayed())
			{
				if (getStartedText != "")
					typeTextById("ckeditorContentShort", getStartedText + " "  + d.toString());
			}
			
			if (hasAudio != "")
				selectDropdownValueVisibleText("hasAudio", hasAudio.toUpperCase());
			
			if (courseDuration != "")
				typeTextById("courseDuration", courseDuration);
			
			Log.info("customized get started tab");
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			
			clickIdentifierXpath("//*[@id='editedCourse']/div[1]/button");
			
			//Thread.sleep(5000);
		
			String courseSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
		
			String passed = "Course saved";
		
			if (courseSaved.contains(passed))
			{
				Log.pass("get started tab edited successfully");
			}
			
			else {
				Log.fail("could not edit course due to following error: " + courseSaved);
			}
			
			clickIdentifierXpath(".//div[@id='menuTabs']/ul/li[2]"); 
			Thread.sleep(1000);
			clickIdentifierXpath(".//div[@id='menuTabs']/ul/li[2]/p"); 
			Log.info("Navigate to Create course tab");
			
			Thread.sleep(3000);
		}
		
		catch(Exception e){  
		       Log.fail("Failed to edit get started tab");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to edit get started tab");
		       e.printStackTrace();
		       throw e;

		}
	}
	
	/**
	 * custom add page method for customizer role as they can only add 3 templates
	 * @param template must be either "text", "sidebar" or "video"
	 */
	static public void customizerAddPage(String template) throws Exception
	{
		try
		{
			Log.startTestCase("adding a " + template + " page");
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			
			String template1 = "";
			
			if (template == "text")
				template1 = "0-0";
			
			if (template == "sidebar")
				template1 = "0-1";
			
			if (template == "video")
				template1 = "0-2";
			
			Thread.sleep(1000);
			
			clickIdentifierXpath("//*[@id='courseTreeOperationIcons']/li[3]");
			
			Thread.sleep(300);
			
			clickIdentifierXpath("//*[@id='template-row-column-image-" + template1 + "']/img");
			
			Log.info("selected the " + template + " template");
			
			//clickIdentifierXpath(".//div[@class='ui-dialog-buttonpane ui-widget-content ui-helper-clearfix']/div/button[1]");
			
			clickIdentifierXpath(".//div[@aria-describedby='dialogArea']/div[3]/div/button[1]");
			
			Log.pass(template + " page added");
			
			Thread.sleep(10000);
		}
		
		catch(Exception e){  
		       Log.fail("Failed to add page");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to add page");
		       e.printStackTrace();
		       throw e;

		}
	}
	
	/**
	 * Called at the end of the customizer role test
	 */
	static public void saveAndExit() throws Exception
	{
		try
		{
			Log.startTestCase("start save and exit course");
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			   
			Thread.sleep(1000);
			
			clickIdentifierByID("coursePublishButton");
			
			Log.info("clicked on Save and Exit button");
			
			Thread.sleep(1000);
			
			clickIdentifierXpath(".//div[@aria-describedby='dialogArea']/div[3]/div/button[1]");

			Thread.sleep(20000);
			
			driver.switchTo().window(ModuleManager.window);
			
			Log.pass("switched back to LCEC");
		}
		
		catch(Exception e){  
		       Log.fail("Failed to save and exit");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to save and exit");
		       e.printStackTrace();
		       throw e;

		}
	}

}
