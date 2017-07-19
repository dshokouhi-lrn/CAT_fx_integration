package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.SearchCourse;

public class SearchCourseTC extends SearchCourse{
	
	@Test
	void CatLogicTC() throws Exception
	{

		searchcourse("DAN736-a80en", "", "");

	}
}
