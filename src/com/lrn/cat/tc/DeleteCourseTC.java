package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.SearchCourse;

public class DeleteCourseTC extends SearchCourse{
	
	@Test
	void CatDeleteCourse() throws Exception
	{
		searchcourse(configProperties.getProperty("cloneDeleteCat"), "", "");
		
		Thread.sleep(5000);
		
		deleteCourse();
	}

}
