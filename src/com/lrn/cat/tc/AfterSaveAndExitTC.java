package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.lcec.pages.ModuleManager;

public class AfterSaveAndExitTC extends ModuleManager{
	
	@Test
	public void aferSaveAndExit() throws Exception
	{
		//String SearchModule = "ADP028";
		getWaitForElementPresent("//*[@id='" + configProperties.getProperty("searchModule") + "']/div[2]/div/div", 100);
		clickIdentifierXpath("//*[@id='" + configProperties.getProperty("searchModule") + "']/div[2]/div/div");
		publishCourse(configProperties.getProperty("searchModule"));
	}
}
