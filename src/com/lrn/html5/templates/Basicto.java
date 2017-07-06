package com.lrn.html5.templates;

import org.testng.SkipException;
import org.testng.annotations.Test;
import com.lrn.html5.common.GenericTemplateMethods;

public class Basicto extends GenericTemplateMethods {

	@Test(testName="FLDXTWO-4708", priority=0)
	public void NEXTDisable() throws Exception {
		checkNEXTDisable();
		logPASS("NEXT is Disable");
	}

	@Test(testName="FLDXTWO-4709", priority=1)
	public void LessonTitle() throws Exception {
		verifyElementTextPresent("DesktopLessonTitle");
		logPASS("LessonTitle is Present");
	}	

	@Test(groups = { "Regression" }, testName="FLDXTWO-4710", priority=2)
	public void TopicTitle() throws Exception {
		if (!verifyElementPresent("TopicTitle2")) {
			logSKIP("Skipping test because TopicTitle was not available");
			throw new SkipException("Skipping test because TopicTitle was not available.");
		}
		verifyElementTextPresent("TopicTitle2");
		logPASS("TopicTitle is Present");
	}

	@Test(groups = { "Regression", "ContentQA" }, testName="FLDXTWO-4700", priority=3)
	public void MainContent() throws Exception {
		verifyElementTextPresent("MainContent1");
		logPASS("MainContent is Present");
		TakeScreenshot("Pass");
	}

	@Test(groups = { "Regression", "Audio" }, testName="FLDXTWO-4712", priority=4)
	public void Audio() throws Exception {
		if (!verifyElementPresent("DesktopAudio")) {
			logSKIP("Skipping test because Audio button was not available");
			throw new SkipException("Skipping test because DesktopAudio was not available.");
		}	
		checkPageAudio();
		logPASS("Clicked on Audio and checked the audio is Present");
	}

	@Test(groups = { "Regression", "Sanity", "ContentQA", "NextOnly" }, testName="FLDXTWO-4715", priority=5)
	public void Bulletin() throws Exception {
		if (!verifyElementPresent("Bulletin")) {
			logSKIP("Skipping test because Bulletin was not available");
			throw new SkipException("Skipping test because Bulletin was not available.");
		}
		checkBulletin();
		logPASS("Clicked on Bulletin icon and closed the popup box");
	}

	@Test(groups = { "Regression", "Help" }, testName="FLDXTWO-4716", priority=6)
	public void Help() throws Exception {
		if (!verifyElementPresent("DesktopHelp")) {
			logSKIP("Skipping test because Help button was not available");
			throw new SkipException("Skipping test because DesktopHelp was not available.");
		}	
		checkHelp();
		logPASS("Clicked on Help and closed the popup box");
	}

	@Test(testName="FLDXTWO-4717", priority=7)
	public void PageNumberIndicator() throws Exception {
		if (!verifyElementPresent("PageNumberIndicator")) {
			logSKIP("Skipping test because PageNumberIndicator was not available");
			throw new SkipException("Skipping test because PageNumberIndicator was not available.");
		}
		verifyElementTextPresent("PageNumberIndicator");
		logPASS("PageNumberIndicator is Present");
	}

	@Test(testName="FLDXTWO-4706", priority=8)
	public void ProgressIndicator() throws Exception {
		if (!verifyElementPresent("ProgressIndicator")) {
			logSKIP("Skipping test because ProgressIndicator was not available");
			throw new SkipException("Skipping test because ProgressIndicator was not available.");
		}
		checkElementPresent("ProgressIndicator");
		logPASS("ProgressIndicator is Present");
	}

	@Test(groups = { "Regression", "Sanity", "ContentQA", "NextOnly" }, testName="FLDXTWO-4705", priority=9)
	public void NEXT() throws Exception {
		clickNEXTTimer();
		logPASS("Clicked on Next");
	}



	/*@Test
	public void testBasicto() throws Exception {
		TakeScreenshot("Pass");
		checkNEXTDisable();
		checkTextPresent("DesktopLessonTitle");
		checkTextPresent("TopicTitle2");
		checkTextPresent("MainContent1");
		checkPageAudio();
		checkBulletin();
		checkHelp();
		checkTextPresent("PageNumberIndicator");
		checkElementPresent("ProgressIndicator");
		clickNEXTwithTimer();
	}*/
}
