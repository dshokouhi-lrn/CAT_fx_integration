package com.lrn.cat.page;

import java.util.Set;
import java.util.Iterator;

import org.openqa.selenium.JavascriptExecutor;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.html5.common.GenericTemplateMethods;
import com.lrn.pp.utility.Log;

public class PreviewCourse extends CATAppCommon{
	
	static public void previewCourse() throws Exception
	{
		try
		{
			Log.startTestCase("start previewing course");
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			
			clickIdentifierByID("coursePreviewButton");
			
			Set<String> courseWindow = driver.getWindowHandles();
			System.out.println("count of window open "  +courseWindow.size());
			System.out.println(courseWindow);
			Thread.sleep(2000);
			Iterator<String> ite1=courseWindow.iterator();
			//System.out.println("Title-------"+driver.switchTo().window(ite.next()));
			Thread.sleep(2000);
			String Mainwindow = ite1.next(); // window id of main CAT window
			String courseWindow1 = ite1.next();
			Thread.sleep(30000);
	        
			driver.switchTo().window(courseWindow1); //Switch to course window
			Log.info("switched to course window");
			Thread.sleep(5000);
			
			//String url = driver.getCurrentUrl();
			
			//Log.info(url);
			
			GenericTemplateMethods.initialiseTemplatesAndrunCourse();
			
			//driver.close();
			
			//Log.info("closed course window");
			driver.switchTo().window(Mainwindow);
			Log.info("switched back to CAT");
			

		}
		
		catch(Exception e){  
            Log.fail("Failed to preview course");
            e.printStackTrace();
            throw e;                                        
     } catch(AssertionError e)
     {
            Log.fail("Failed to preview course");
            e.printStackTrace();
            throw e;

     }
	}

}
