package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.AdvancedTab;

public class AdvancedTabTC extends AdvancedTab{
	
	@Test
	void CatAdvancedTab() throws Exception
	{
		setupAdvancedFeatures("yes", "no", "no", "yes", "no", "no", "yes","3");
		endOfCourseConfiguration("yes", "custom print label");
		courseWindowSize("yes", "custom", "1050", "980");
	}

}
