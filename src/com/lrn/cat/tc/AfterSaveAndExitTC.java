package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.lcec.pages.ModuleManager;

public class AfterSaveAndExitTC extends ModuleManager{
	
	@Test
	public void aferSaveAndExit() throws Exception
	{
		//String SearchModule = "ADP028";
		if (configProperties.getProperty("env").contains("qa7") || configProperties.getProperty("env").contains("prod"))
		{
			getWaitForElementPresent("//*[@id='" + configProperties.getProperty("searchModule") + "']/div[2]/div/div", 100);
			clickIdentifierXpath("//*[@id='" + configProperties.getProperty("searchModule") + "']/div[2]/div/div");
			
			Thread.sleep(5000);
			
			publishCourse(configProperties.getProperty("searchModule"));
		}
		
		else if (configProperties.getProperty("env").contains("qa4"))
		{
			getWaitForElementPresent("//*[@id='" + configProperties.getProperty("qa4Module") + "']/div[2]/div/div", 100);
			clickIdentifierXpath("//*[@id='" + configProperties.getProperty("qa4Module") + "']/div[2]/div/div");
			
			Thread.sleep(5000);
			
			publishCourse(configProperties.getProperty("qa4Module"));
		}
	}
}
