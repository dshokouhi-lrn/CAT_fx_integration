package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.ManageCourse;
import com.lrn.cat.page.CreateCourse;

public class CloneCourseTC extends ManageCourse{
	
	@Test
	void CatCloneCourse() throws Exception
	{
		searchManageCourse("DAN799", "");
		
		Thread.sleep(5000);
		
		cloneCourse("1");
		
		CreateCourse.createCourse("cloned", "test", "test", "DAN799", "Custom", "Refresher", "", "", "qacustomize07", "qacustomize07", "English", "YES", "NO", "YES", "5");

	}

}
