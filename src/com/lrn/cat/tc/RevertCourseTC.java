package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.RevertCourse;

public class RevertCourseTC extends RevertCourse{
	
	@Test
	void CatRevertCourse() throws Exception
	{
		revertCourse();
	}

}
