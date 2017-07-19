package com.lrn.cat.page;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class CourseFeatures extends CATAppCommon {
	
	/**
	 * Must be called after createCourse or editGetStarted or anything in between
	 * @param helpMenu show help menu yes/no
	 * @param eocSurvey show EOC survey yes/no
	 * @param surveyID provide survey ID if EOC survey is set to yes
	 * @param menuImage show menu image, leave blank if no
	 * @param menuImageDesc provide image description
	 * @param menuAltText provide image alt text
	 * @param hsNormal change global hotspot normal image
	 * @param hsHover change global hotspot hover image
	 * @param hsComplete change global hotspot complete image
	 */
	
	static public void setupCourseFeatures(String helpMenu, String eocSurvey, String surveyID, String menuImage, String menuImageDesc, String menuAltText, String hsNormal, String hsHover, String hsComplete) throws Exception
	{
		try
		{
			Date d = new Date();
			
			Log.startTestCase("start editing course features tab");
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			
			Thread.sleep(1000);
			
			clickIdentifierXpath(".//*[@id='menuTabs']/ul/li[5]/p");
			
			Thread.sleep(1000);
			
			clickIdentifierXpath(".//*[@id='menuTabs']/ul/li[5]/p");
			
			Thread.sleep(1000);
			
			if (helpMenu != "")
			{
				//checkCheckBox(".//*[@id='videoAutoPlay']/div[2]/div/div[2]/div/input");
				WebElement check1 = driver.findElement(By.id("hlpMun"));
				Boolean value = check1.isSelected();
				Log.info("help menu is " + value);
				
				if (value && helpMenu =="no")
				{
					clickIdentifierXpath(".//*[@id='courseFeature']/div[1]/div[2]/div/div/div[2]/div/div/label[2]");
					Log.info("turned off help menu");
				}
				
				if (!value && helpMenu =="yes")
				{
					clickIdentifierXpath(".//*[@id='courseFeature']/div[1]/div[2]/div/div/div[2]/div/div/label[2]");
					Log.info("turned on help menu");
				}
			}
			
			if (eocSurvey != "")
			{
				//checkCheckBox(".//*[@id='videoAutoPlay']/div[2]/div/div[2]/div/input");
				WebElement check1 = driver.findElement(By.id("hasEOCS"));
				Boolean value = check1.isSelected();
				Log.info("eoc survey is " + value);
				
				if (value && eocSurvey =="no")
				{
					clickIdentifierXpath(".//*[@id='courseFeature']/div[2]/div[1]/div/div[2]/div/div/label[2]");
					Log.info("turned off eoc survey");
				}
				
				if (!value && eocSurvey =="yes")
				{
					clickIdentifierXpath(".//*[@id='courseFeature']/div[2]/div[1]/div/div[2]/div/div/label[2]");
					Log.info("turned on eoc survey");
					
					if (surveyID != "")
						typeTextByXpath(".//*[@id='surveyIdDiv']/input", surveyID);
				}
			}
			
			if (menuImage != "")
			{
				String image = getRandomImage();
				clickIdentifierXpath(".//*[@id='courseFeature']/div[3]/div/div[1]/img");
				uploadFile("C:\\github\\CAT_automation\\resource\\images\\" + image + ".jpg");
				Thread.sleep(5000);
				Log.info("uploaded menu image");
			}
			
			if (menuImageDesc != "")
				typeTextByXpath(".//*[@id='courseFeature']/div[3]/div/input[2]", menuImageDesc + " " + d.toString());
			
			if (menuAltText != "")
				typeTextByXpath(".//*[@id='courseFeature']/div[3]/div/input[3]", menuAltText + " " + d.toString());
			
			if (hsNormal != "" || hsHover != "" || hsComplete != "")
			{
				clickIdentifierByID("hotspotImgPopup");
				
				Thread.sleep(2000);
				
				if (hsNormal != "")
				{
					String image = getRandomHotSpotImage();
					clickIdentifierXpath(".//*[@id='chooseHotspot']/div[1]/div[1]/div[1]/div[2]/img");
					uploadFile("C:\\github\\CAT_automation\\resource\\images\\" + image + ".jpg");
					Thread.sleep(6000);
					Log.info("uploaded normal hot spot image");
				}
				
				if (hsHover != "")
				{
					String image = getRandomHotSpotImage();
					clickIdentifierXpath(".//*[@id='chooseHotspot']/div[1]/div[2]/div[1]/div[2]/img");
					uploadFile("C:\\github\\CAT_automation\\resource\\images\\" + image + ".jpg");
					Thread.sleep(6000);
					Log.info("uploaded hover hot spot image");
				}
				
				if (hsComplete != "")
				{
					String image = getRandomHotSpotImage();
					clickIdentifierXpath(".//*[@id='chooseHotspot']/div[1]/div[3]/div[1]/div[2]/img");
					uploadFile("C:\\github\\CAT_automation\\resource\\images\\" + image + ".jpg");
					Thread.sleep(6000);
					Log.info("uploaded completed hot spot image");
				}
				
				clickIdentifierXpath(".//div[@aria-describedby='hotspotImageSelectionArea']/div[3]/div[1]/button[1]");
			
				Thread.sleep(5000);
			}
			
			JavascriptExecutor jse1 = (JavascriptExecutor)driver;
			jse1.executeScript("window.scrollTo(0,0)", "");
			
			Thread.sleep(1000);
			
			clickIdentifierByID("featureSaveButton");
			
			String pageSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			Thread.sleep(3000);
			
			if (pageSaved.contains("Course features saved"))
				Log.pass("Course features saved");
			else
				Log.fail("course features failed to save for reason: " + pageSaved);
			
		}
		
		catch(Exception e){  
		       Log.fail("Failed to edit course features");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to edit course features");
		       e.printStackTrace();
		       throw e;

		}
	}
	
	/**
	 * must be called after setupCourseFeatures
	 * @param enableTimer turn on timer yes/no
	 * @param timerType must be one of the following: "Course Level", "Page Level" or "Custom Page Level"
	 * @param page1Time if Custom Page Level provide first page time
	 * @param page2Time if Custom Page Level provide second page time
	 */
	
	static public void setupTimer(String enableTimer, String timerType, String page1Time, String page2Time) throws Exception
	{
		try
		{
			Log.info("configuring timer");
			
			if (enableTimer != "")
			{
				//checkCheckBox(".//*[@id='videoAutoPlay']/div[2]/div/div[2]/div/input");
				WebElement check1 = driver.findElement(By.id("hascourseTimer"));
				Boolean value = check1.isSelected();
				Log.info("timer is " + value);
				
				if (value && enableTimer =="no")
				{
					clickIdentifierXpath(".//*[@id='courseFeature']/div[4]/div[1]/div[2]/div[2]/div/div/label[1]");
					Log.info("turned off timer");
				}
				
				if (!value && enableTimer =="yes")
				{
					clickIdentifierXpath(".//*[@id='courseFeature']/div[4]/div[1]/div[2]/div[2]/div/div/label[2]");
					Log.info("turned on timer");
				}
			}
			
			if (timerType == "Course Level" || timerType == "Page Level" || timerType == "Custom Page Level")
				selectDropdownValueXpathVisibleText(".//*[@id='timerTypeDDbox']", timerType);
			
			if (timerType == "Custom Page Level")
			{
				typeTextByXpath(".//*[@id='customlevelpagetimer']/div[1]/div[1]/div[2]/div[1]/input", page1Time);
				typeTextByXpath(".//*[@id='customlevelpagetimer']/div[1]/div[2]/div[2]/div[1]/input", page2Time);
				
				clickIdentifierXpath("//*[@aria-describedby='customPageTimer']/div[3]/div[1]/button[1]");
				
				Log.info("configured custom page level timer");
			}
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			
			Thread.sleep(1000);
			
			clickIdentifierByID("featureSaveButton");
			
			String pageSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			Thread.sleep(3000);
			
			if (pageSaved.contains("Course features saved"))
				Log.pass("Course features saved");
			else
				Log.fail("course features failed to save for reason: " + pageSaved);
		}
		
		catch(Exception e){  
		       Log.fail("Failed to setup timer");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to setup timer");
		       e.printStackTrace();
		       throw e;

		}
		
	}
	
	/**
	 * Must be called after setupCourseFeatures
	 * @param enableFAQ turn on FAQ Yes/No
	 * @param question1Text provide question text for first FAQ
	 * @param answer1Text provide answer text for first FAQ
	 * @param question2Text provide question text for second FAQ
	 * @param answer2Text provide answer text for second FAQ
	 */
	
	static public void editFAQ(String enableFAQ, String question1Text, String answer1Text, String question2Text, String answer2Text) throws Exception
	{
		try
		{
			Date d = new Date();
			
			Log.info("configuring FAQ");
			
			if (enableFAQ == "Yes" || enableFAQ == "No")
				selectDropdownValueXpathVisibleText(".//*[@id='FaqButton']", enableFAQ);
			
			if (enableFAQ == "Yes")
			{
				clickIdentifierXpath(".//*[@id='addFaqButton']/input[1]");
				
				if (question1Text != "")
					typeTextById("questionText", question1Text + " " + d.toString());
				
				if (question2Text != "")
					typeTextById("questionText_2", question2Text + " " + d.toString());
				
				if (answer1Text != "")
					typeTextById("answer", answer1Text + " " + d.toString());
				
				if (answer2Text != "")
					typeTextById("answer_2", answer2Text + " " + d.toString());
				
				Log.info("added 2 FAQ items");
			}
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			
			Thread.sleep(1000);
			
			clickIdentifierByID("featureSaveButton");
			
			String pageSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			Thread.sleep(3000);
			
			if (pageSaved.contains("Course features saved"))
				Log.pass("Course features saved");
			else
				Log.fail("course features failed to save for reason: " + pageSaved);
		}
		
		catch(Exception e){  
		       Log.fail("Failed to setup faq");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to setup faq");
		       e.printStackTrace();
		       throw e;

		}
	}
	

	/**
	 * Must be called after setupCourseFeatures
	 * @param enableTop10 Yes/No
	 * @param summary1 summary for first top 10 item
	 * @param explain1 explanation for first top 10 item
	 * @param summary2 summary for second top 10 item
	 * @param explain2 explanation for second top 10 item
	 */
	static public void editTop10(String enableTop10, String summary1, String explain1, String summary2, String explain2) throws Exception
	{
		try
		{
			Date d = new Date();
			
			Log.info("configuring top 10");
			
			if (enableTop10 == "Yes" || enableTop10 == "No")
				selectDropdownValueXpathVisibleText(".//*[@id='topTenDD']", enableTop10);
			
			if (enableTop10 == "Yes")
			{
				clickIdentifierXpath(".//*[@id='topTenButton']/input[1]");
				
				if (summary1 != "")
					typeTextById("title", summary1 + " " + d.toString());
				
				if (summary2 != "")
					typeTextById("title_2", summary2 + " " + d.toString());
				
				if (explain1 != "")
					typeTextById("explanation", explain1 + " " + d.toString());
				
				if (explain2 != "")
					typeTextById("explanation_2", explain2 + " " + d.toString());
				
				Log.info("added 2 top 10 items");
			}
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			
			Thread.sleep(1000);
			
			clickIdentifierByID("featureSaveButton");
			
			String pageSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			Thread.sleep(3000);
			
			if (pageSaved.contains("Course features saved"))
				Log.pass("Course features saved");
			else
				Log.fail("course features failed to save for reason: " + pageSaved);
		}
		
		catch(Exception e){  
		       Log.fail("Failed to setup top 10");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to setup top 10");
		       e.printStackTrace();
		       throw e;

		}
	}
	
	/**
	 * Must be called after setupCourseFeatures
	 * @param enableResources Yes/No
	 * @param resource1Type must be "Link" or "Document"
	 * @param resource1Name name of first resource
	 * @param resource2Type must be "Link" or "Document"
	 * @param resource2Name name of second resource
	 */
	
	static public void editResources (String enableResources, String resource1Type, String resource1Name, String resource2Type, String resource2Name) throws Exception
	{
		try
		{
			Date d = new Date();
			
			Log.info("configuring resources");
			
			if (enableResources == "Yes" || enableResources == "No")
				selectDropdownValueXpathVisibleText(".//*[@id='addBtnSlct']", enableResources);
			
			if (enableResources == "Yes")
			{
				clickIdentifierXpath(".//*[@id='addBtnResource']/input[1]");
				
				if (resource1Name != "")
					typeTextById("resourceName", resource1Name + " " + d.toString());
				
				if (resource2Name != "")
					typeTextById("resourceName_2", resource2Name + " " + d.toString());
				
				if (resource1Type == "Link" || resource1Type == "Document")
					selectDropdownValueXpathVisibleText(".//*[@id='hasLinkDoc']", resource1Type);
				
				if (resource2Type == "Link" || resource2Type == "Document")
					selectDropdownValueXpathVisibleText(".//*[@id='hasLinkDoc_2']", resource2Type);
				
				if (resource1Type == "Document")
				{
					String image = getRandomImage();
					clickIdentifierXpath(".//*[@id='fileUpload']");
					uploadFile("C:\\github\\CAT_automation\\resource\\images\\" + image + ".jpg");
					Thread.sleep(5000);
					Log.info("uploaded resource 1 document");
				}
				
				if (resource2Type == "Document")
				{
					String image = getRandomHotSpotImage();
					clickIdentifierXpath(".//*[@id='fileUpload2']");
					uploadFile("C:\\github\\CAT_automation\\resource\\images\\" + image + ".jpg");
					Thread.sleep(5000);
					Log.info("uploaded resource 2 document");
				}
				
				if (resource1Type == "Link")
					typeTextById("link", "http://www.google.com");
				
				if (resource2Type == "Link")
					typeTextById("link2", "http://www.google.com");
				
				Log.info("added 2 resource items");
			}
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			
			Thread.sleep(1000);
			
			clickIdentifierByID("featureSaveButton");
			
			String pageSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			Thread.sleep(3000);
			
			if (pageSaved.contains("Course features saved"))
				Log.pass("Course features saved");
			else
				Log.fail("course features failed to save for reason: " + pageSaved);
		}
		
		catch(Exception e){  
		       Log.fail("Failed to setup top 10");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to setup top 10");
		       e.printStackTrace();
		       throw e;

		}
	}

}
