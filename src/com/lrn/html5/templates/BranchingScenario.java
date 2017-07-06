package com.lrn.html5.templates;

import org.testng.annotations.Test;
import com.lrn.html5.common.GenericTemplateMethods;

public class BranchingScenario extends GenericTemplateMethods {
	
	@Test
	public void testBranchingScenario() throws Exception {
		//checkNEXTDisable();
		//checkTextPresent("DesktopLessonTitle");
		//checkTextPresent("TopicTitle1");
		//runBranchingScenario();
		checkBulletin();
		//checkHelp();
		//checkTextPresent("PageNumberIndicator");
		//checkElementPresent("ProgressIndicator");
		//clickNEXTwithTimer();
	}
}
