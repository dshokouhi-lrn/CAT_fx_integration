package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.lcec.pages.ModuleManager;

public class AfterSaveAndExitTC extends ModuleManager{
	
	@Test
	public void aferSaveAndExit() throws Exception
	{
		//getSearchModule("ADP028");
		String SearchModule = "ADP028";
		getWaitForElementPresent("//*[@id='" + SearchModule + "']/div[2]/div/div", 100);
		clickIdentifierXpath("//*[@id='" + SearchModule + "']/div[2]/div/div");
		publishCourse(SearchModule);
	}

}
