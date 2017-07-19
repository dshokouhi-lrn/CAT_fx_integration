package com.lrn.cat.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class RevertCourse extends CATAppCommon{
	
	/**
	 * Must be called after changes have been made and course is being edited otherwise it will fail, course needs to be checked out as well
	 */
	static public void revertCourse() throws Exception
	{
		try
		{
			Log.startTestCase("start reverting course");
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			
			clickIdentifierByID("courseRevertButton");
			
			Thread.sleep(2000);
			
			clickIdentifierXpath("//*[@class='ui-dialog ui-widget ui-widget-content ui-corner-all ui-front ui-dialog-buttons']/div[3]/div/button[1]");
			
			Thread.sleep(10000);
			
			boolean revertDisabled = driver.findElement(By.id("courseRevertButton")).isEnabled();
			
			if (!revertDisabled)
				Log.pass("revert successful");
			else
				Log.fail("revert failed");
			
					
			/*String checkedIn = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			if (checkedIn.contains("Course Revert Successful"))
			{
				Log.pass("course successfully reverted");
			}
			
			else
				Log.fail("course did not revert for reason: " + checkedIn);*/
		}
		
		catch(Exception e){  
		       Log.fail("Failed to revert course");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to revert course");
		       e.printStackTrace();
		       throw e;

		}
	}

}
