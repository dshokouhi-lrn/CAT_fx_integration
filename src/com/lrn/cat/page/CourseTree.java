package com.lrn.cat.page;

import org.openqa.selenium.JavascriptExecutor;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class CourseTree extends CATAppCommon{

	static public void selectPage(String lesson, String topic, String page) throws Exception
	{
		try
		{
			Log.startTestCase("start selecting page");
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			
			if(lesson != "" && topic != "" && page != "")
				clickIdentifierXpath("//*[@id='courseTree']/ul/li/ul/li["+ lesson + "]/ul/li[" + topic + "]/ul/li[" + page + "]/a");
			
			if(lesson != "" && topic == "" && page != "")
				clickIdentifierXpath("//*[@id='courseTree']/ul/li/ul/li["+ lesson + "]/ul/li[" + page + "]/a");
			
			Log.pass("selected page");
			
			Thread.sleep(10000);
			
		}
		
		catch(Exception e){  
		       Log.fail("Failed to select page");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to select page");
		       e.printStackTrace();
		       throw e;

		}
	}
}
