package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.SearchCourse;


public class ResetTestTC extends SearchCourse{
	
	//The purpose of this test is to delete a course before we start creating it
	
	@Test
	void CatResetTest() throws Exception
	{
		searchcourse(configProperties.getProperty("fullCat"), "", "");
		
		Thread.sleep(5000);
		
		String result = getValueByXpath(".//*[@id='courseResultsTable']/tbody[1]/tr[2]/td[2]");
		
		if (!result.contains("No Result(s) found"))
			deleteCourse();
		
		navigateHome();
	}

}
