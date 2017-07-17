package com.lrn.cat.page;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class CreateCourse extends CATAppCommon {
	
	/**
	 * Must be called after logOn or cloneCourse
	 * @param clonedCourse leave blank if you did not call cloneCourse
	 * @param CourseTitle provide the course title here
	 * @param Description provide course description
	 * @param BaseCat provide the base catalog id here
	 * @param CourseType must be one of the following: "Custom" or "Library"
	 * @param CourseFormat must be one of the following: "Awareness Vignette", "Experiential Learning", "Foundational", "Refresher", "Standalone Certification"
	 * @param CourseProgression  must be any letter of US alphabet capitalized (ex: "A" or "B")
	 * @param CourseTopic must be one of the course topics in list, must be provided if CourseType is Library (ex: "HOW" or "Fraud")
	 * @param Site must be one of the partners name in the list, must be provided if CourseType is custom
	 * @param Partner must be one of the partners name in the list, must be provided if CourseType is custom
	 * @param Language must be any language
	 * @param Mobile must be yes/no
	 * @param Video must be yes/no
	 * @param Audio must be yes/no
	 * @param CourseDuration must be a number, does not need to be provided
	 */
	static public void createCourse(String clonedCourse, String CourseTitle, String Description, String BaseCat, String CourseType, String CourseFormat, String CourseProgression, String CourseTopic, String Site, String Partner, String Language, String Mobile, String Video, String Audio, String CourseDuration) throws Exception {
		
		try{
			
			Date d = new Date();
			
			Log.startTestCase("Start create a course");
			
			Thread.sleep(2000);
			
			if (clonedCourse == "")
			{
				clickIdentifierXpath("//div[3]//a[1]");
				Log.info("clicked on create your course button");
			}
			
			typeTextById("title", "Course title " + d.toString());
			Log.info("entered course title");
			
			selectDropdownValueVisibleText("courseTypeDropDown", CourseType);
			
			Thread.sleep(5000);
			
			if (CourseType == "Custom")
			{
				typeTextById("partnerName", Partner);
				selectDropdownValueVisibleText("siteId", Site);
				typeTextById("ckeditorContentDescription", Description + " "  + d.toString());
				typeTextById("ckeditorContentCourseObjective", Description + " "  + d.toString());
				
				Log.pass("course type custom selected and necessary details filled in");
			}
			
			if (CourseType == "Library")
			{
				selectDropdownValueVisibleText("topicArea", CourseTopic);
				typeTextById("ckeditorContentShort", Description + " "  + d.toString());
				typeTextById("ckeditorContentLong", Description + " "  + d.toString());
				typeTextById("ckeditorContentCourseObjective", Description + " "  + d.toString());
				
				Log.pass("course type library used and necesary details filled in");
			}
			
			selectDropdownValueVisibleText("courseFormatDropDown", CourseFormat);
			
			if (CourseProgression != "")
			{
				selectDropdownValueVisibleText("courseProgression", CourseProgression);
			}
			
			selectDropdownValueVisibleText("lang", Language);
			
			typeTextById("baseCatalogId", BaseCat);
			
			Log.info("base catalog id and course format selected");
			
			selectDropdownValueVisibleText("hasMobileReady", Mobile);
			
			selectDropdownValueVisibleText("hasVideo", Video);
			
			selectDropdownValueVisibleText("hasAudio", Audio);
			
			typeTextById("courseDuration", CourseDuration);
			
			Log.info("mobile, video, audio and duration configured");
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			
			clickIdentifierXpath("//*[@id='editedCourse']/div[1]/button");
			
			//Thread.sleep(5000);
			
			String courseSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			String passed = "Course saved";
			
			if (courseSaved.contains(passed))
			{
				String sysID = driver.findElement(By.xpath(".//*[@id='systemId']")).getAttribute("value");
				String catID = driver.findElement(By.xpath(".//*[@id='catalogId']")).getAttribute("value");

				//String systemID = getValueByXpath(".//*[@id='systemId']");
				//String catalogID = getValueByXpath(".//*[@id='catalogId']");
				
				Log.pass("course created successfully with system ID " + sysID + " and catalog ID " + catID);
				
				clickIdentifierXpath(".//div[@id='menuTabs']/ul/li[2]"); 
				Log.info("Navigate to Create course tab");
			}
			
			else {
				Log.fail("could not create course due to following error: " + courseSaved);
			}
		}
		
		catch(Exception e){  
		       Log.fail("Failed to Create course");
		       e.printStackTrace();
		       throw e;                                        
		} 
		
		catch(AssertionError e)
		{
		       Log.fail("Failed to Create course");
		       e.printStackTrace();
		       throw e;
		}
	}
		
}
