package com.lrn.cat.page;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class EditMultipleScenarioTemplate extends CATAppCommon{
	
	/**
	 * to be called after addPage or selectPage
	 * @param pageTitle page title
	 * @param showTitle show title yes/no
	 * @param layoutMultiple must be one of the following: "Left To Right", "Right To Left", "Bottom To Top", "Top To Bottom" or "Full Screen Graphic"
	 * @param multipleContent content for the page
	 * @param multipleDesktop desktop yes or blank for no
	 * @param multipleMobile mobile yes or blank for no
	 * @param multipleImageDesc image description
	 * @param multipleAltTags image alt text
	 * @param multipleOrder Random or Sequential
	 * @param multipleDesktopX must be 1-100
	 * @param multipleDesktopY must be 1-100
	 * @param multipleMobileX must be 1-100
	 * @param multipleMobileY must be 1-100
	 * @param multipleNormal supply custom normal hotspot image yes or blank for no
	 * @param multipleHover supply custom hover hotspot image yes or blank for no
	 * @param multipleClick supply custom click hotspot image yes or blank for no
	 * @param scenarioTemplate "Text and Graphic" or "Saq"
	 * @param scenarioShowTitle show scenario title yes/no
	 * @param scenarioPageTitle page title for scenario
	 * @param scenarioTextContent text for Text and Graphic scenario
	 * @param scenarioImageDesktop scenario desktop yes or blank for no
	 * @param scenarioImageMobile scenario mobile yes or blank for no
	 * @param scenarioImageDesc image description for scenario
	 * @param scenarioAltText alt text for scenario
	 * @param scenarioAudio add audio to scenario yes or blank for no
	 * @param scenarioQuestionType must be either: "Multiple Choice", "Check All"
	 * @param scenarioQuestionText question text for scenario
	 * @param scenarioAnswerCorrect is the answer correct yes or blank for no
	 * @param scenarioAnswerText answer text
	 * @param scenarioRetryTitle retry title, leave blank if not configured
	 * @param scenarioRetryText retry message, leave blank if not configured
	 * @param scenarioRetryButton retry button text, leave blank if not configured
	 * @param feedbackOption "single" or "multiple"
	 * @param singleFeedback feedback text for single feedback
	 * @param singleImage single feedback image yes or blank for no
	 * @param singleImageDesc single feedback image description
	 * @param singleAltText single feedback alt text
	 * @param correctTitle multiple feedback correct tile
	 * @param correctContent multiple feedback correct text
	 * @param correctImage multiple feedback image yes or blank for no
	 * @param correctImageDesc multiple feedback image description
	 * @param correctAltText  multiple feedback alt text
	 * @param incorrectTitle multiple feedback  incorrect title
	 * @param incorrectContent multiple feedback incorrect text
	 * @param incorrectImage multiple feedback incorrect image yes or blank for no
	 * @param incorrectImageDesc multiple feedback image description
	 * @param incorrectAltText multiple feedback alt text
	 * @param multipleRetryAttempts number of retry attempts, leave blank if not configured
	 * @param pageAudio add page audio yes or blank for no
	 * @param backgroundImage add background image yes or blank for no
	 */
	static public void editMultipleScenarioTemplate(String pageTitle, String showTitle, String layoutMultiple, String multipleContent, String multipleDesktop, String multipleMobile, String multipleImageDesc, String multipleAltTags, String multipleOrder, String multipleDesktopX, String multipleDesktopY, String multipleMobileX, String multipleMobileY, String multipleNormal, String multipleHover, String multipleClick, String scenarioTemplate, String scenarioShowTitle, String scenarioPageTitle, String scenarioTextContent, String scenarioImageDesktop, String scenarioImageMobile, String scenarioImageDesc, String scenarioAltText, String scenarioAudio, String scenarioQuestionType, String scenarioQuestionText, String scenarioAnswerCorrect, String scenarioAnswerText, String scenarioRetryTitle, String scenarioRetryText, String scenarioRetryButton, String feedbackOption, String singleFeedback, String singleImage, String singleImageDesc, String singleAltText, String correctTitle, String correctContent, String correctImage, String correctImageDesc, String correctAltText, String incorrectTitle, String incorrectContent, String incorrectImage, String incorrectImageDesc, String incorrectAltText, String multipleRetryAttempts, String pageAudio, String backgroundImage) throws Exception
	{
		try
		{
			Date d = new Date();
			
			Log.startTestCase("start editing multiple scenario");
			
			if (pageTitle != "")
				typeTextById("pageTitle", pageTitle + " " + d.toString());
			
			if (showTitle.toLowerCase() == "no")
			{
				uncheckCheckBox(".//input[@name='titleVisible']");
				Log.info("unchecked show title");
			}
			
			if (showTitle.toLowerCase() == "yes")
			{
				checkCheckBox(".//input[@name='titleVisible']");
				Log.info("checked show title");
			}
			
			if (layoutMultiple == "Left To Right" || layoutMultiple == "Right To Left" || layoutMultiple == "Bottom To Top" || layoutMultiple == "Top To Bottom" || layoutMultiple == "Full Screen Graphic")
				selectDropdownValueXpathVisibleText(".//*[@id='scenario_layout']/div[1]/div/select", layoutMultiple);
			
			if (multipleContent != "")
				typeTextById("ckeditorContentscenario_content", multipleContent + " " + d.toString());
			
			if (multipleDesktop != "" || multipleMobile != "" || multipleImageDesc != "" || multipleAltTags != "")
			{
				clickIdentifierXpath(".//*[@id='multipleScenarioSectionContainerscenario_scenes']/h5[1]");
				
				Thread.sleep(2000);
				
				if (multipleDesktop != "")
				{
					String image = getRandomImage();
					clickIdentifierXpath(".//*[@id='desktopImageContainer']/div/div[2]/img");
					uploadFile("C:\\github\\CAT_automation\\resource\\images\\" + image + ".jpg");
					Thread.sleep(5000);
					Log.info("uploaded multiple scenario desktop image");
				}
				
				if (multipleMobile != "")
				{
					String image = getRandomImage();
					clickIdentifierXpath(".//*[@id='smartPhoneImageContainer']/div/div[2]/img");
					uploadFile("C:\\github\\CAT_automation\\resource\\images\\" + image + ".jpg");
					Thread.sleep(5000);
					Log.info("uploaded multiple scenario mobile image");
				}
				
				if (multipleImageDesc != "")
					typeTextById("hotspotgraphicDescription", multipleImageDesc + " " + d.toString());
				
				if (multipleAltTags != "")
					typeTextById("hotspotaltText", multipleAltTags);
			}
			
			clickIdentifierXpath(".//*[@id='multipleScenarioSectionContainerscenario_scenes']/h5[2]");
			
			Thread.sleep(2000);
			
			if (multipleOrder == "Random" || multipleOrder == "Sequential")
			{
				if (multipleOrder == "Random")
					clickIdentifierXpath(".//*[@id='scenarioSectionContainerscenario_scenes']/div[1]/div[1]/label[2]/input");
				
				if (multipleOrder == "Sequential")
					clickIdentifierXpath(".//*[@id='scenarioSectionContainerscenario_scenes']/div[1]/div[1]/label[3]/input");
				
				Log.info("set order to " + multipleOrder);
			}
			
			if (multipleDesktopX != "")
				typeTextByXpath(".//*[@id='desktopHotSpotContentField']/div[1]/div[1]/input", multipleDesktopX);
			
			if (multipleDesktopY != "")
				typeTextByXpath(".//*[@id='desktopHotSpotContentField']/div[1]/div[2]/input", multipleDesktopY);
			
			if (multipleMobileX != "")
				typeTextByXpath(".//*[@id='smartPhoneHotSpotContentField']/div[1]/div[1]/input", multipleMobileX);
			
			if (multipleMobileY != "")
				typeTextByXpath(".//*[@id='smartPhoneHotSpotContentField']/div[1]/div[2]/input", multipleMobileY);
			
			if (multipleNormal != "" || multipleHover != "" || multipleClick != "")
			{
				clickIdentifierByID("chooseHotspotImage");
				
				Thread.sleep(2000);
				
				if (multipleNormal != "")
				{
					String image = getRandomHotSpotImage();
					clickIdentifierXpath(".//*[@id='hotSpotImageDiv']/div/div[2]/img");
					uploadFile("C:\\github\\CAT_automation\\resource\\images\\" + image + ".jpg");
					Thread.sleep(6000);
					Log.info("uploaded multiple scenario normal hot spot image");
				}
				
				if (multipleHover != "")
				{
					String image = getRandomHotSpotImage();
					clickIdentifierXpath(".//*[@id='hoverhotSpotImageDiv']/div/div[2]/img");
					uploadFile("C:\\github\\CAT_automation\\resource\\images\\" + image + ".jpg");
					Thread.sleep(6000);
					Log.info("uploaded multiple scenario hover hot spot image");
				}
				
				if (multipleClick != "")
				{
					String image = getRandomHotSpotImage();
					clickIdentifierXpath(".//*[@id='clickhotSpotImageDiv']/div/div[2]/img");
					uploadFile("C:\\github\\CAT_automation\\resource\\images\\" + image + ".jpg");
					Thread.sleep(6000);
					Log.info("uploaded multiple scenario click hot spot image");
				}
				
				clickIdentifierXpath(".//div[@aria-describedby='hotspotImageSelectionArea']/div[3]/div[1]/button[1]");
			
				Thread.sleep(5000);
			}

			clickIdentifierByID("multiplePage_add");

			if (scenarioTemplate == "Text and Graphic" || scenarioTemplate == "Saq")	
			{
				selectDropdownValueXpathVisibleText(".//*[@id='templateChoiceLayout']", scenarioTemplate);
				
				if (scenarioShowTitle.toLowerCase() == "no")
				{
					uncheckCheckBox(".//input[@id='titleVisiblePage']");
					Log.info("unchecked scenario show title");
				}
				
				if (scenarioShowTitle.toLowerCase() == "yes")
				{
					checkCheckBox(".//input[@id='titleVisiblePage']");
					Log.info("checked scenario show title");
				}
				
				if (scenarioPageTitle != "")
					typeTextByXpath(".//*[@id='scenarioPageContainerscenario_scenes']/div[2]/div[1]/input[2]", scenarioPageTitle + " " + d.toString());
				
				if (scenarioImageDesktop != "" || scenarioImageMobile != "" || scenarioImageDesc != "" || scenarioAltText != "")
				{
					clickIdentifierXpath(".//*[@id='templateTnGImageAccordian']/h5");
					
					if (scenarioImageDesktop != "")
					{
						String image = getRandomImage();
						clickIdentifierXpath(".//*[@id='tngDesktopImageContainer']/div/img");
						uploadFile("C:\\github\\CAT_automation\\resource\\images\\" + image + ".jpg");
						Thread.sleep(5000);
						Log.info("uploaded scenario 1 desktop image");
					}
					
					if (scenarioImageMobile != "")
					{
						String image = getRandomImage();
						clickIdentifierXpath(".//*[@id='tngSmartPhoneImageContainer']/div/img");
						uploadFile("C:\\github\\CAT_automation\\resource\\images\\" + image + ".jpg");
						Thread.sleep(5000);
						Log.info("uploaded 1 scenario mobile image");
					}
					
					if (scenarioImageDesc != "")
						typeTextById("tngGraphicDescription", scenarioImageDesc + " " + d.toString());
					
					if (scenarioAltText != "")
						typeTextById("tngAltText", scenarioAltText + " " + d.toString());
				}
				
				/*if (scenarioAudio != "")
				{
					String audio = getRandomAudio();
					clickIdentifierXpath(".//*[@id='sltAudio']");
					uploadFile("C:\\github\\CAT_automation\\resource\\audio\\" + audio + ".mp3");
					Thread.sleep(3000);
					Log.info("uploaded scenario audio");
				}*/
			
				if (scenarioTemplate == "Text and Graphic")
				{
					if (scenarioTextContent != "")
						typeTextByiframe("Rich Text Editor, textGraphicCkEditor", scenarioTextContent + " " + d.toString());
						//typeTextById("cke_textGraphicCkEditor", scenarioTextContent + " " + d.toString());
					
					clickIdentifierXpath("//div[@aria-describedby='pageDialogArea']/div[3]/div/button");
					
					Thread.sleep(5000);
					
					boolean scenarioSaved = isElementPresent(By.xpath(".//*[@id='page_1']/div/img[1]"));
					
					if (scenarioSaved)
						Log.pass("scenario 1 created");
					else
						Log.fail("scenario 1 did not save properly");
				}
				
				if (scenarioTemplate == "Saq")
				{
					if (scenarioQuestionText != "" || scenarioQuestionType != "")
					{
						clickIdentifierXpath(".//*[@aria-controls='templateSaqQuestionSection']");
						
						if (scenarioQuestionType == "Multiple Choice" || scenarioQuestionType == "Check All")
							selectDropdownValueXpathVisibleText(".//*[@id='questionType']", scenarioQuestionType);
						
						if (scenarioQuestionText != "")
							typeTextByiframe("Rich Text Editor, saqQuestionCkEditor", scenarioQuestionText + " " + d.toString());
					}
					
					if (scenarioAnswerCorrect != "" || scenarioAnswerText != "")
					{
						clickIdentifierXpath(".//*[@aria-controls='templateSaqAnswerSection']");
						
						if (scenarioAnswerCorrect.toLowerCase() == "no")
						{
							uncheckCheckBox(".//*[@id='templateSaqAnswerSection']/ul/ul/li/div/div/input");
							Log.info("unchecked correct scenario answer");
						}
						
						if (scenarioAnswerCorrect.toLowerCase() == "yes")
						{
							checkCheckBox(".//*[@id='templateSaqAnswerSection']/ul/ul/li/div/div/input");
							Log.info("checked correct scenario answer");
						}
						
						if (scenarioAnswerText != "")
							typeTextByiframe("Rich Text Editor, saqAnswerCkEditor", scenarioAnswerText + " " + d.toString());
					
						addAnswerOption(2, "yes", "test");
					}
					
					if (scenarioRetryButton != "" || scenarioRetryText != "" || scenarioRetryTitle != "")
					{
						clickIdentifierXpath(".//*[@aria-controls='templateSaqRetakeAttemptSection']");
						
						if (scenarioRetryTitle != "")
							typeTextById("saqRetakeAttemptAlertTitle", scenarioRetryTitle + " " + d.toString());
						
						if (scenarioRetryText != "")
							typeTextByiframe("Rich Text Editor, ckeditorSaqRetakeAttempAlertText",  scenarioRetryText + " " + d.toString());
						
						if (scenarioRetryButton != "")
							typeTextById("saqRetakeAttemptAlertButtonText", scenarioRetryButton + " " + d.toString());
					}
					
					if (feedbackOption != "")
					{
						clickIdentifierXpath(".//*[@aria-controls='templateSaqFeedbackSection']");
						
						
						//TODO change xpaths
						if (feedbackOption.toLowerCase() == "single")
						{
							clickIdentifierXpath(".//*[@id='templateSaqFeedbackSection']/div/label[2]/input");
							
							Thread.sleep(2000);
							
							if (singleFeedback != "")
								typeTextByiframe("Rich Text Editor, saqFeedbackCkEditor", singleFeedback + " " + d.toString());
								//typeTextByXpath(".//*[@id='concernMeterFeedback']/div[1]/div[2]/div[2]/div", singleFeedback + " " + d.toString());
							
							if (singleImage != "")
							{
								String image = getRandomImage();
								clickIdentifierXpath(".//*[@id='feedbackSingleImage']/div[1]/div[1]/img");
								uploadFile("C:\\github\\CAT_automation\\resource\\images\\" + image + ".jpg");
								Thread.sleep(5000);
								Log.info("uploaded feedback image");
							}
							
							if (singleImageDesc != "")
								typeTextByXpath(".//*[@id='singleFeedbackContent']/div[3]/div[2]/input", singleImageDesc + " " + d.toString());
							
							if (singleAltText != "")
								typeTextByXpath(".//*[@id='singleFeedbackContent']/div[3]/div[3]/input", singleAltText + " " + d.toString());
						}
						
						if (feedbackOption.toLowerCase() == "multiple")
						{
							clickIdentifierXpath(".//*[@id='templateSaqFeedbackSection']/div/label[3]/input");
							
							if (correctTitle != "")
								typeTextByXpath(".//*[@id='templateSaqFeedbackSection']/div[1]/div[2]/div[1]/input[1]", correctTitle + " " + d.toString());
								//typeTextById("correctTitle", correctTitle + " " + d.toString());
							
							if (incorrectTitle != "")
								typeTextByXpath(".//*[@id='templateSaqFeedbackSection']/div[1]/div[2]/div[2]/input[1]", incorrectTitle + " " + d.toString());
								//typeTextById("incorrectTitle", incorrectTitle + " " + d.toString());
							
							if (correctContent != "")
								typeTextByiframe("Rich Text Editor, saqFeedbackCorrectCkEditor", correctContent + " " + d.toString());
								//typeTextById("ckeditorContentCorrectconcernFeedback1", correctContent + " " + d.toString());
							
							if (incorrectContent != "")
								typeTextByiframe("Rich Text Editor, saqFeedbackIncorrectCkEditor", incorrectContent + " " + d.toString());
								//typeTextById("ckeditorContentIncorrectconcernFeedback1", incorrectContent + " " + d.toString());
							
							if (correctImage != "")
							{
								String image = getRandomImage();
								clickIdentifierXpath(".//*[@id='templateSaqFeedbackSection']/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/img");
								uploadFile("C:\\github\\CAT_automation\\resource\\images\\" + image + ".jpg");
								Thread.sleep(5000);
								Log.info("uploaded correct feedback image");
							}
							
							if (incorrectImage != "")
							{
								String image = getRandomImage();
								clickIdentifierXpath(".//*[@id='templateSaqFeedbackSection']/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/img");
								uploadFile("C:\\github\\CAT_automation\\resource\\images\\" + image + ".jpg");
								Thread.sleep(5000);
								Log.info("uploaded incorrect feedback image");
							}
							
							if (correctImageDesc != "")
								typeTextByXpath(".//*[@id='templateSaqFeedbackSection']/div[1]/div[2]/div[1]/div[2]/div[2]/input", correctImageDesc + " " + d.toString());
							
							if (correctAltText != "")
								typeTextByXpath(".//*[@id='templateSaqFeedbackSection']/div[1]/div[2]/div[1]/div[2]/div[3]/input", correctAltText + " " + d.toString());
							
							if (incorrectImageDesc != "")
								typeTextByXpath(".//*[@id='templateSaqFeedbackSection']/div[1]/div[2]/div[2]/div[3]/div[2]/input", incorrectImageDesc + " " + d.toString());
							
							if (incorrectAltText != "")
								typeTextByXpath(".//*[@id='templateSaqFeedbackSection']/div[1]/div[2]/div[2]/div[3]/div[3]/input", incorrectAltText + " " + d.toString());
						
						}
					}
					
					clickIdentifierXpath("//div[@aria-describedby='pageDialogArea']/div[3]/div/button");
					
					Thread.sleep(5000);
					
					boolean scenarioSaved = isElementPresent(By.xpath(".//*[@id='page_1']/div/img[1]"));
					
					if (scenarioSaved)
						Log.pass("scenario 1 created");
					else
						Log.fail("scenario 1 did not save properly");
				}
				
				if (multipleRetryAttempts != "")
					typeTextById("titleTextscenario_retakeAttempt", multipleRetryAttempts);
				
				if (pageAudio.toLowerCase() == "yes")
				{
					uploadPageAudio();			
				}
				
				if (backgroundImage.toLowerCase() == "yes")
				{
					uploadBackgroundImage();
				}
				
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollTo(0,0)", "");
				
				Thread.sleep(1000);
				
				clickIdentifierByID("ok-button");
				
				String pageSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
				
				Thread.sleep(3000);
				
				if (pageSaved.contains("Page saved"))
					Log.pass("page saved");
				else
					Log.fail("page failed to save for reason: " + pageSaved);
				
			}
				
		}
		
		catch(Exception e){  
		       Log.fail("Failed to edit multiple scenario template");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to edit multiple scenario template");
		       e.printStackTrace();
		       throw e;

		}
	}
	
	/**
	 * to be called after selectPage or editMultiple
	 * @param scenarioPosition the position of the scenario where we are adding a page
	 * @param scenarioTemplate "Text and Graphic" or "Saq"
	 * @param scenarioShowTitle show scenario title yes/no
	 * @param scenarioPageTitle page title for scenario
	 * @param scenarioTextContent text for Text and Graphic scenario
	 * @param scenarioImageDesktop scenario desktop yes or blank for no
	 * @param scenarioImageMobile scenario mobile yes or blank for no
	 * @param scenarioImageDesc image description for scenario
	 * @param scenarioAltText alt text for scenario
	 * @param scenarioAudio add audio to scenario yes or blank for no
	 * @param scenarioQuestionType must be either: "Multiple Choice", "Check All"
	 * @param scenarioQuestionText question text for scenario
	 * @param scenarioAnswerCorrect is the answer correct yes or blank for no
	 * @param scenarioAnswerText answer text
	 * @param scenarioRetryTitle retry title, leave blank if not configured
	 * @param scenarioRetryText retry message, leave blank if not configured
	 * @param scenarioRetryButton retry button text, leave blank if not configured
	 * @param feedbackOption "single" or "multiple"
	 * @param singleFeedback feedback text for single feedback
	 * @param singleImage single feedback image yes or blank for no
	 * @param singleImageDesc single feedback image description
	 * @param singleAltText single feedback alt text
	 * @param correctTitle multiple feedback correct tile
	 * @param correctContent multiple feedback correct text
	 * @param correctImage multiple feedback image yes or blank for no
	 * @param correctImageDesc multiple feedback image description
	 * @param correctAltText  multiple feedback alt text
	 * @param incorrectTitle multiple feedback  incorrect title
	 * @param incorrectContent multiple feedback incorrect text
	 * @param incorrectImage multiple feedback incorrect image yes or blank for no
	 * @param incorrectImageDesc multiple feedback image description
	 * @param incorrectAltText multiple feedback alt text
	 * @param multipleRetryAttempts number of retry attempts, leave blank if not configured
	 */
	static public void addPageToScenario(String scenarioPosition, String scenarioTemplate, String scenarioShowTitle, String scenarioPageTitle, String scenarioTextContent, String scenarioImageDesktop, String scenarioImageMobile, String scenarioImageDesc, String scenarioAltText, String scenarioAudio, String scenarioQuestionType, String scenarioQuestionText, String scenarioAnswerCorrect, String scenarioAnswerText, String scenarioRetryTitle, String scenarioRetryText, String scenarioRetryButton, String feedbackOption, String singleFeedback, String singleImage, String singleImageDesc, String singleAltText, String correctTitle, String correctContent, String correctImage, String correctImageDesc, String correctAltText, String incorrectTitle, String incorrectContent, String incorrectImage, String incorrectImageDesc, String incorrectAltText, String multipleRetryAttempts) throws Exception
	{
		try
		{
	
			Date d = new Date();
			
			Log.info("start adding new page to scenario");
			
			clickIdentifierByID("multiplePage_add");
	
			if (scenarioTemplate == "Text and Graphic" || scenarioTemplate == "Saq")	
			{
				selectDropdownValueXpathVisibleText(".//*[@id='templateChoiceLayout']", scenarioTemplate);
				
				if (scenarioShowTitle.toLowerCase() == "no")
				{
					uncheckCheckBox(".//input[@id='titleVisiblePage']");
					Log.info("unchecked scenario show title");
				}
				
				if (scenarioShowTitle.toLowerCase() == "yes")
				{
					checkCheckBox(".//input[@id='titleVisiblePage']");
					Log.info("checked scenario show title");
				}
				
				if (scenarioPageTitle != "")
					typeTextByXpath(".//*[@id='scenarioPageContainerscenario_scenes']/div[2]/div[1]/input[2]", scenarioPageTitle + " " + d.toString());
				
				if (scenarioImageDesktop != "" || scenarioImageMobile != "" || scenarioImageDesc != "" || scenarioAltText != "")
				{
					clickIdentifierXpath(".//*[@id='templateTnGImageAccordian']/h5");
					
					if (scenarioImageDesktop != "")
					{
						String image = getRandomImage();
						clickIdentifierXpath(".//*[@id='tngDesktopImageContainer']/div/img");
						uploadFile("C:\\github\\CAT_automation\\resource\\images\\" + image + ".jpg");
						Thread.sleep(5000);
						Log.info("uploaded scenario 1 desktop image");
					}
					
					if (scenarioImageMobile != "")
					{
						String image = getRandomImage();
						clickIdentifierXpath(".//*[@id='tngSmartPhoneImageContainer']/div/img");
						uploadFile("C:\\github\\CAT_automation\\resource\\images\\" + image + ".jpg");
						Thread.sleep(5000);
						Log.info("uploaded 1 scenario mobile image");
					}
					
					if (scenarioImageDesc != "")
						typeTextById("tngGraphicDescription", scenarioImageDesc + " " + d.toString());
					
					if (scenarioAltText != "")
						typeTextById("tngAltText", scenarioAltText + " " + d.toString());
				}
				
				if (scenarioAudio != "")
				{
					String audio = getRandomAudio();
					clickIdentifierXpath(".//*[@id='sltAudio']");
					Thread.sleep(1000);
					clickIdentifierXpath(".//*[@id='audBtn_1']");
					Thread.sleep(1000);
					uploadFile("C:\\github\\CAT_automation\\resource\\audio\\" + audio + ".mp3");
					Thread.sleep(3000);
					clickIdentifierXpath("//*[@aria-describedby='selectDialog']/div[3]/div[1]/button");
					Thread.sleep(2000);
					Log.info("uploaded scenario audio");
				}
			
				if (scenarioTemplate == "Text and Graphic")
				{
					if (scenarioTextContent != "")
						typeTextByiframe("Rich Text Editor, textGraphicCkEditor", scenarioTextContent + " " + d.toString());
						//typeTextById("cke_textGraphicCkEditor", scenarioTextContent + " " + d.toString());
					
					clickIdentifierXpath("//div[@aria-describedby='pageDialogArea']/div[3]/div/button");
					
					Thread.sleep(5000);
					
					boolean scenarioSaved = isElementPresent(By.xpath(".//*[@id='page_1']/div/img[1]"));
					
					if (scenarioSaved)
						Log.pass("scenario " + scenarioPosition + " created");
					else
						Log.fail("scenario " + scenarioPosition + " did not save properly");
				}
				
				if (scenarioTemplate == "Saq")
				{
					if (scenarioQuestionText != "" || scenarioQuestionType != "")
					{
						clickIdentifierXpath(".//*[@id='templateSaqAccordian']/h5[1]");
						
						if (scenarioQuestionType == "Multiple Choice" || scenarioQuestionType == "Check All")
							selectDropdownValueXpathVisibleText(".//*[@id='questionType']", scenarioQuestionType);
						
						if (scenarioQuestionText != "")
							typeTextByiframe("Rich Text Editor, saqQuestionCkEditor", scenarioQuestionText + " " + d.toString());
					}
					
					if (scenarioAnswerCorrect != "" || scenarioAnswerText != "")
					{
						clickIdentifierXpath(".//*[@aria-controls='templateSaqAnswerSection']");
						
						if (scenarioAnswerCorrect.toLowerCase() == "no")
						{
							uncheckCheckBox(".//*[@id='templateSaqAnswerSection']/ul/ul/li/div/div/input");
							Log.info("unchecked correct scenario answer");
						}
						
						if (scenarioAnswerCorrect.toLowerCase() == "yes")
						{
							checkCheckBox(".//*[@id='templateSaqAnswerSection']/ul/ul/li/div/div/input");
							Log.info("checked correct scenario answer");
						}
						
						if (scenarioAnswerText != "")
							typeTextByiframe("Rich Text Editor, saqAnswerCkEditor", scenarioAnswerText + " " + d.toString());
					
						addAnswerOption(2, "yes", "test");
					}
					
					if (scenarioRetryButton != "" || scenarioRetryText != "" || scenarioRetryTitle != "")
					{
						clickIdentifierXpath(".//*[@aria-controls='templateSaqRetakeAttemptSection']");
						
						if (scenarioRetryTitle != "")
							typeTextById("saqRetakeAttemptAlertTitle", scenarioRetryTitle + " " + d.toString());
						
						if (scenarioRetryText != "")
							typeTextByiframe("Rich Text Editor, ckeditorSaqRetakeAttempAlertText",  scenarioRetryText + " " + d.toString());
						
						if (scenarioRetryButton != "")
							typeTextById("saqRetakeAttemptAlertButtonText", scenarioRetryButton + " " + d.toString());
					}
					
					if (feedbackOption != "")
					{
						clickIdentifierXpath(".//*[@aria-controls='templateSaqFeedbackSection']");
						
						
						//TODO change xpaths
						if (feedbackOption.toLowerCase() == "single")
						{
							clickIdentifierXpath(".//*[@id='templateSaqFeedbackSection']/div/label[2]/input");
							
							Thread.sleep(2000);
							
							if (singleFeedback != "")
								typeTextByiframe("Rich Text Editor, saqFeedbackCkEditor", singleFeedback + " " + d.toString());
								//typeTextByXpath(".//*[@id='concernMeterFeedback']/div[1]/div[2]/div[2]/div", singleFeedback + " " + d.toString());
							
							if (singleImage != "")
							{
								String image = getRandomImage();
								clickIdentifierXpath(".//*[@id='feedbackSingleImage']/div[1]/div[1]/img");
								uploadFile("C:\\github\\CAT_automation\\resource\\images\\" + image + ".jpg");
								Thread.sleep(5000);
								Log.info("uploaded feedback image");
							}
							
							if (singleImageDesc != "")
								typeTextByXpath(".//*[@id='singleFeedbackContent']/div[3]/div[2]/input", singleImageDesc + " " + d.toString());
							
							if (singleAltText != "")
								typeTextByXpath(".//*[@id='singleFeedbackContent']/div[3]/div[3]/input", singleAltText + " " + d.toString());
						}
						
						if (feedbackOption.toLowerCase() == "multiple")
						{
							clickIdentifierXpath(".//*[@id='templateSaqFeedbackSection']/div/label[3]/input");
							
							if (correctTitle != "")
								typeTextByXpath(".//*[@id='templateSaqFeedbackSection']/div[1]/div[2]/div[1]/input[1]", correctTitle + " " + d.toString());
								//typeTextById("correctTitle", correctTitle + " " + d.toString());
							
							if (incorrectTitle != "")
								typeTextByXpath(".//*[@id='templateSaqFeedbackSection']/div[1]/div[2]/div[2]/input[1]", incorrectTitle + " " + d.toString());
								//typeTextById("incorrectTitle", incorrectTitle + " " + d.toString());
							
							if (correctContent != "")
								typeTextByiframe("Rich Text Editor, saqFeedbackCorrectCkEditor", correctContent + " " + d.toString());
								//typeTextById("ckeditorContentCorrectconcernFeedback1", correctContent + " " + d.toString());
							
							if (incorrectContent != "")
								typeTextByiframe("Rich Text Editor, saqFeedbackIncorrectCkEditor", incorrectContent + " " + d.toString());
								//typeTextById("ckeditorContentIncorrectconcernFeedback1", incorrectContent + " " + d.toString());
							
							if (correctImage != "")
							{
								String image = getRandomImage();
								clickIdentifierXpath(".//*[@id='templateSaqFeedbackSection']/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/img");
								uploadFile("C:\\github\\CAT_automation\\resource\\images\\" + image + ".jpg");
								Thread.sleep(5000);
								Log.info("uploaded correct feedback image");
							}
							
							if (incorrectImage != "")
							{
								String image = getRandomImage();
								clickIdentifierXpath(".//*[@id='templateSaqFeedbackSection']/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/img");
								uploadFile("C:\\github\\CAT_automation\\resource\\images\\" + image + ".jpg");
								Thread.sleep(5000);
								Log.info("uploaded incorrect feedback image");
							}
							
							if (correctImageDesc != "")
								typeTextByXpath(".//*[@id='templateSaqFeedbackSection']/div[1]/div[2]/div[1]/div[2]/div[2]/input", correctImageDesc + " " + d.toString());
							
							if (correctAltText != "")
								typeTextByXpath(".//*[@id='templateSaqFeedbackSection']/div[1]/div[2]/div[1]/div[2]/div[3]/input", correctAltText + " " + d.toString());
							
							if (incorrectImageDesc != "")
								typeTextByXpath(".//*[@id='templateSaqFeedbackSection']/div[1]/div[2]/div[2]/div[3]/div[2]/input", incorrectImageDesc + " " + d.toString());
							
							if (incorrectAltText != "")
								typeTextByXpath(".//*[@id='templateSaqFeedbackSection']/div[1]/div[2]/div[2]/div[3]/div[3]/input", incorrectAltText + " " + d.toString());
						
						}
					}
					
					clickIdentifierXpath("//div[@aria-describedby='pageDialogArea']/div[3]/div/button");
					
					Thread.sleep(5000);
					
					boolean scenarioSaved = isElementPresent(By.xpath(".//*[@id='page_" + scenarioPosition + "']/div/img[1]"));
					
					if (scenarioSaved)
						Log.pass("page " + scenarioPosition + " created");
					else
						Log.fail("page " + scenarioPosition + " did not save properly");
				}
				
				if (multipleRetryAttempts != "")
					typeTextById("titleTextscenario_retakeAttempt", multipleRetryAttempts);
				
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollTo(0,0)", "");
				
				Thread.sleep(1000);
				
				clickIdentifierByID("ok-button");
				
				String pageSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
				
				Thread.sleep(3000);
				
				if (pageSaved.contains("Page saved"))
					Log.pass("page saved");
				else
					Log.fail("page failed to save for reason: " + pageSaved);
			}
		}
		
		catch(Exception e){  
		       Log.fail("Failed to add page to scenario");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to add page to scenario");
		       e.printStackTrace();
		       throw e;
		}
	}
	
	/**
	 * to be called after selectPage or editMultiple
	 * @param scenarioNumber1 the position of the scenario to be added
	 * @param multipleDesktopX must be 1-100
	 * @param multipleDesktopY must be 1-100
	 * @param multipleMobileX must be 1-100
	 * @param multipleMobileY must be 1-100
	 * @param multipleNormal supply custom normal hotspot image yes or blank for no
	 * @param multipleHover supply custom hover hotspot image yes or blank for no
	 * @param multipleClick supply custom click hotspot image yes or blank for no
	 * @param scenarioTemplate "Text and Graphic" or "Saq"
	 * @param scenarioShowTitle show scenario title yes/no
	 * @param scenarioPageTitle page title for scenario
	 * @param scenarioTextContent text for Text and Graphic scenario
	 * @param scenarioImageDesktop scenario desktop yes or blank for no
	 * @param scenarioImageMobile scenario mobile yes or blank for no
	 * @param scenarioImageDesc image description for scenario
	 * @param scenarioAltText alt text for scenario
	 * @param scenarioAudio add audio to scenario yes or blank for no
	 * @param scenarioQuestionType must be either: "Multiple Choice", "Check All"
	 * @param scenarioQuestionText question text for scenario
	 * @param scenarioAnswerCorrect is the answer correct yes/no
	 * @param scenarioAnswerText answer text
	 * @param scenarioRetryTitle retry title, leave blank if not configured
	 * @param scenarioRetryText retry message, leave blank if not configured
	 * @param scenarioRetryButton retry button text, leave blank if not configured
	 * @param feedbackOption "single" or "multiple"
	 * @param singleFeedback feedback text for single feedback
	 * @param singleImage single feedback image yes or blank for no
	 * @param singleImageDesc single feedback image description
	 * @param singleAltText single feedback alt text
	 * @param correctTitle multiple feedback correct tile
	 * @param correctContent multiple feedback correct text
	 * @param correctImage multiple feedback image yes or blank for no
	 * @param correctImageDesc multiple feedback image description
	 * @param correctAltText  multiple feedback alt text
	 * @param incorrectTitle multiple feedback  incorrect title
	 * @param incorrectContent multiple feedback incorrect text
	 * @param incorrectImage multiple feedback incorrect image yes or blank for no
	 * @param incorrectImageDesc multiple feedback image description
	 * @param incorrectAltText multiple feedback alt text
	 * @param multipleRetryAttempts number of retry attempts, leave blank if not configured
	 */
	static public void addScenario(int scenarioNumber1, String multipleDesktopX, String multipleDesktopY, String multipleMobileX, String multipleMobileY, String multipleNormal, String multipleHover, String multipleClick, String scenarioTemplate, String scenarioShowTitle, String scenarioPageTitle, String scenarioTextContent, String scenarioImageDesktop, String scenarioImageMobile, String scenarioImageDesc, String scenarioAltText, String scenarioAudio, String scenarioQuestionType, String scenarioQuestionText, String scenarioAnswerCorrect, String scenarioAnswerText, String scenarioRetryTitle, String scenarioRetryText, String scenarioRetryButton, String feedbackOption, String singleFeedback, String singleImage, String singleImageDesc, String singleAltText, String correctTitle, String correctContent, String correctImage, String correctImageDesc, String correctAltText, String incorrectTitle, String incorrectContent, String incorrectImage, String incorrectImageDesc, String incorrectAltText) throws Exception
	{
		try
		{
			Date d = new Date();
			
			String scenarioNumber = Integer.toString(scenarioNumber1);
			
			int scenarioNumber3 = scenarioNumber1 - 1;
			
			String scenarioNumber2 = Integer.toString(scenarioNumber3);
			
			Log.info("start adding scenario " + scenarioNumber);
			
			clickIdentifierXpath(".//*[@id='scenarioList']/li[" + scenarioNumber + "]/input");
			
			if (multipleDesktopX != "")
				typeTextByXpath(".//*[@id='scrn_tab_" + scenarioNumber2 + "']/div[1]/div[2]/div[1]/div[1]/input", multipleDesktopX);
			
			if (multipleDesktopY != "")
				typeTextByXpath(".//*[@id='scrn_tab_" + scenarioNumber2 + "']/div[1]/div[2]/div[1]/div[2]/input", multipleDesktopY);
			
			if (multipleMobileX != "")
				typeTextByXpath(".//*[@id='scrn_tab_" + scenarioNumber2 + "']/div[1]/div[3]/div[1]/div[1]/input", multipleMobileX);
			
			if (multipleMobileY != "")
				typeTextByXpath(".//*[@id='scrn_tab_" + scenarioNumber2 + "']/div[1]/div[3]/div[1]/div[2]/input", multipleMobileY);
			
			Thread.sleep(1000);
			
			if (multipleNormal != "" || multipleHover != "" || multipleClick != "")
			{
				clickIdentifierXpath(".//*[@id='scrn_tab_" + scenarioNumber2 + "']/div[1]/div[4]/input[1]");
				
				Thread.sleep(2000);
				
				if (multipleNormal != "")
				{
					String image = getRandomHotSpotImage();
					clickIdentifierXpath(".//*[@id='hotSpotImageDiv']/div/div[2]/img");
					uploadFile("C:\\github\\CAT_automation\\resource\\images\\" + image + ".jpg");
					Thread.sleep(6000);
					Log.info("uploaded multiple scenario normal hot spot image");
				}
				
				if (multipleHover != "")
				{
					String image = getRandomHotSpotImage();
					clickIdentifierXpath(".//*[@id='hoverhotSpotImageDiv']/div/div[2]/img");
					uploadFile("C:\\github\\CAT_automation\\resource\\images\\" + image + ".jpg");
					Thread.sleep(6000);
					Log.info("uploaded multiple scenario hover hot spot image");
				}
				
				if (multipleClick != "")
				{
					String image = getRandomHotSpotImage();
					clickIdentifierXpath(".//*[@id='clickhotSpotImageDiv']/div/div[2]/img");
					uploadFile("C:\\github\\CAT_automation\\resource\\images\\" + image + ".jpg");
					Thread.sleep(6000);
					Log.info("uploaded multiple scenario click hot spot image");
				}
				
				clickIdentifierXpath(".//div[@aria-describedby='hotspotImageSelectionArea']/div[3]/div[1]/button[1]");
			
				Thread.sleep(5000);
			}
			
			Thread.sleep(3000);

			clickIdentifierXpath(".//*[@id='scrn_tab_" + scenarioNumber2 + "']/div[2]/div[1]/input");

			Thread.sleep(3000);
			if (scenarioTemplate == "Text and Graphic" || scenarioTemplate == "Saq")	
			{
				selectDropdownValueXpathVisibleText(".//*[@id='templateChoiceLayout']", scenarioTemplate);
				
				if (scenarioShowTitle.toLowerCase() == "no")
				{
					uncheckCheckBox(".//input[@id='titleVisiblePage']");
					Log.info("unchecked scenario show title");
				}
				
				if (scenarioShowTitle.toLowerCase() == "yes")
				{
					checkCheckBox(".//input[@id='titleVisiblePage']");
					Log.info("checked scenario show title");
				}
				
				if (scenarioPageTitle != "")
					typeTextByXpath(".//*[@id='scenarioPageContainerscenario_scenes']/div[2]/div[1]/input[2]", scenarioPageTitle + " " + d.toString());
				
				if (scenarioImageDesktop != "" || scenarioImageMobile != "" || scenarioImageDesc != "" || scenarioAltText != "")
				{
					clickIdentifierXpath(".//*[@id='templateTnGImageAccordian']/h5");
					
					if (scenarioImageDesktop != "")
					{
						String image = getRandomImage();
						clickIdentifierXpath(".//*[@id='tngDesktopImageContainer']/div/img");
						uploadFile("C:\\github\\CAT_automation\\resource\\images\\" + image + ".jpg");
						Thread.sleep(5000);
						Log.info("uploaded scenario 1 desktop image");
					}
					
					if (scenarioImageMobile != "")
					{
						String image = getRandomImage();
						clickIdentifierXpath(".//*[@id='tngSmartPhoneImageContainer']/div/img");
						uploadFile("C:\\github\\CAT_automation\\resource\\images\\" + image + ".jpg");
						Thread.sleep(5000);
						Log.info("uploaded 1 scenario mobile image");
					}
					
					if (scenarioImageDesc != "")
						typeTextById("tngGraphicDescription", scenarioImageDesc + " " + d.toString());
					
					if (scenarioAltText != "")
						typeTextById("tngAltText", scenarioAltText + " " + d.toString());
				}
				
				if (scenarioAudio != "")
				{
					String audio = getRandomAudio();
					clickIdentifierXpath(".//*[@id='sltAudio']");
					Thread.sleep(1000);
					clickIdentifierXpath(".//*[@id='audBtn_1']");
					Thread.sleep(1000);
					uploadFile("C:\\github\\CAT_automation\\resource\\audio\\" + audio + ".mp3");
					Thread.sleep(3000);
					clickIdentifierXpath("//*[@aria-describedby='selectDialog']/div[3]/div[1]/button");
					Thread.sleep(2000);
					Log.info("uploaded scenario audio");
				}
			
				if (scenarioTemplate == "Text and Graphic")
				{
					if (scenarioTextContent != "")
						typeTextByiframe("Rich Text Editor, textGraphicCkEditor", scenarioTextContent + " " + d.toString());
						//typeTextById("cke_textGraphicCkEditor", scenarioTextContent + " " + d.toString());
					
					clickIdentifierXpath("//div[@aria-describedby='pageDialogArea']/div[3]/div/button");
					
					Thread.sleep(5000);
					
					boolean scenarioSaved = isElementPresent(By.xpath(".//*[@id='scrn_tab_" + scenarioNumber2 + "']/div[2]/ul/li/div/img[1]"));
					
					if (scenarioSaved)
						Log.pass("scenario " + scenarioNumber + " created");
					else
						Log.fail("scenario " + scenarioNumber + " did not save properly");
				}
				
				if (scenarioTemplate == "Saq")
				{
					if (scenarioQuestionText != "" || scenarioQuestionType != "")
					{
						clickIdentifierXpath(".//*[@aria-controls='templateSaqQuestionSection']");
						
						if (scenarioQuestionType == "Multiple Choice" || scenarioQuestionType == "Check All")
							selectDropdownValueXpathVisibleText(".//*[@id='questionType']", scenarioQuestionType);
						
						if (scenarioQuestionText != "")
							typeTextByiframe("Rich Text Editor, saqQuestionCkEditor", scenarioQuestionText + " " + d.toString());
					}
					
					if (scenarioAnswerCorrect != "" || scenarioAnswerText != "")
					{
						clickIdentifierXpath(".//*[@aria-controls='templateSaqAnswerSection']");
						
						if (scenarioAnswerCorrect.toLowerCase() == "no")
						{
							uncheckCheckBox(".//*[@id='templateSaqAnswerSection']/ul/ul/li/div/div/input");
							Log.info("unchecked correct scenario answer");
						}
						
						if (scenarioAnswerCorrect.toLowerCase() == "yes")
						{
							checkCheckBox(".//*[@id='templateSaqAnswerSection']/ul/ul/li/div/div/input");
							Log.info("checked correct scenario answer");
						}
						
						if (scenarioAnswerText != "")
							typeTextByiframe("Rich Text Editor, saqAnswerCkEditor", scenarioAnswerText + " " + d.toString());
						
						addAnswerOption(2, "yes", "test");
					}
					
					if (scenarioRetryButton != "" || scenarioRetryText != "" || scenarioRetryTitle != "")
					{
						clickIdentifierXpath(".//*[@aria-controls='templateSaqRetakeAttemptSection']");
						
						if (scenarioRetryTitle != "")
							typeTextById("saqRetakeAttemptAlertTitle", scenarioRetryTitle + " " + d.toString());
						
						if (scenarioRetryText != "")
							typeTextByiframe("Rich Text Editor, ckeditorSaqRetakeAttempAlertText",  scenarioRetryText + " " + d.toString());
						
						if (scenarioRetryButton != "")
							typeTextById("saqRetakeAttemptAlertButtonText", scenarioRetryButton + " " + d.toString());
					}
					
					if (feedbackOption != "")
					{
						clickIdentifierXpath(".//*[@aria-controls='templateSaqFeedbackSection']");
						
						
						//TODO change xpaths
						if (feedbackOption.toLowerCase() == "single")
						{
							clickIdentifierXpath(".//*[@id='templateSaqFeedbackSection']/div/label[2]/input");
							
							Thread.sleep(2000);
							
							if (singleFeedback != "")
								typeTextByiframe("Rich Text Editor, saqFeedbackCkEditor", singleFeedback + " " + d.toString());
								//typeTextByXpath(".//*[@id='concernMeterFeedback']/div[1]/div[2]/div[2]/div", singleFeedback + " " + d.toString());
							
							if (singleImage != "")
							{
								String image = getRandomImage();
								clickIdentifierXpath(".//*[@id='feedbackSingleImage']/div[1]/div[1]/img");
								uploadFile("C:\\github\\CAT_automation\\resource\\images\\" + image + ".jpg");
								Thread.sleep(5000);
								Log.info("uploaded feedback image");
							}
							
							if (singleImageDesc != "")
								typeTextByXpath(".//*[@id='singleFeedbackContent']/div[3]/div[2]/input", singleImageDesc + " " + d.toString());
							
							if (singleAltText != "")
								typeTextByXpath(".//*[@id='singleFeedbackContent']/div[3]/div[3]/input", singleAltText + " " + d.toString());
						}
						
						if (feedbackOption.toLowerCase() == "multiple")
						{
							clickIdentifierXpath(".//*[@id='templateSaqFeedbackSection']/div/label[3]/input");
							
							if (correctTitle != "")
								typeTextByXpath(".//*[@id='templateSaqFeedbackSection']/div[1]/div[2]/div[1]/input[1]", correctTitle + " " + d.toString());
								//typeTextById("correctTitle", correctTitle + " " + d.toString());
							
							if (incorrectTitle != "")
								typeTextByXpath(".//*[@id='templateSaqFeedbackSection']/div[1]/div[2]/div[2]/input[1]", incorrectTitle + " " + d.toString());
								//typeTextById("incorrectTitle", incorrectTitle + " " + d.toString());
							
							if (correctContent != "")
								typeTextByiframe("Rich Text Editor, saqFeedbackCorrectCkEditor", correctContent + " " + d.toString());
								//typeTextById("ckeditorContentCorrectconcernFeedback1", correctContent + " " + d.toString());
							
							if (incorrectContent != "")
								typeTextByiframe("Rich Text Editor, saqFeedbackIncorrectCkEditor", incorrectContent + " " + d.toString());
								//typeTextById("ckeditorContentIncorrectconcernFeedback1", incorrectContent + " " + d.toString());
							
							if (correctImage != "")
							{
								String image = getRandomImage();
								clickIdentifierXpath(".//*[@id='templateSaqFeedbackSection']/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/img");
								uploadFile("C:\\github\\CAT_automation\\resource\\images\\" + image + ".jpg");
								Thread.sleep(5000);
								Log.info("uploaded correct feedback image");
							}
							
							if (incorrectImage != "")
							{
								String image = getRandomImage();
								clickIdentifierXpath(".//*[@id='templateSaqFeedbackSection']/div[1]/div[2]/div[2]/div[3]/div[1]/div[1]/img");
								uploadFile("C:\\github\\CAT_automation\\resource\\images\\" + image + ".jpg");
								Thread.sleep(5000);
								Log.info("uploaded incorrect feedback image");
							}
							
							if (correctImageDesc != "")
								typeTextByXpath(".//*[@id='templateSaqFeedbackSection']/div[1]/div[2]/div[1]/div[2]/div[2]/input", correctImageDesc + " " + d.toString());
							
							if (correctAltText != "")
								typeTextByXpath(".//*[@id='templateSaqFeedbackSection']/div[1]/div[2]/div[1]/div[2]/div[3]/input", correctAltText + " " + d.toString());
							
							if (incorrectImageDesc != "")
								typeTextByXpath(".//*[@id='templateSaqFeedbackSection']/div[1]/div[2]/div[2]/div[3]/div[2]/input", incorrectImageDesc + " " + d.toString());
							
							if (incorrectAltText != "")
								typeTextByXpath(".//*[@id='templateSaqFeedbackSection']/div[1]/div[2]/div[2]/div[3]/div[3]/input", incorrectAltText + " " + d.toString());
						
						}
					}
					
					clickIdentifierXpath("//div[@aria-describedby='pageDialogArea']/div[3]/div/button");
					
					Thread.sleep(5000);
					
					boolean scenarioSaved = isElementPresent(By.xpath(".//*[@id='scrn_tab_" + scenarioNumber2 + "']/div[2]/ul/li/div/img[1]"));
					
					if (scenarioSaved)
						Log.pass("scenario " + scenarioNumber + " created");
					else
						Log.fail("scenario " + scenarioNumber + " did not save properly");
				}
			}
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			
			Thread.sleep(1000);
			
			clickIdentifierByID("ok-button");
			
			String pageSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			Thread.sleep(3000);
			
			if (pageSaved.contains("Page saved"))
				Log.pass("page saved");
			else
				Log.fail("page failed to save for reason: " + pageSaved);
		}
		
		catch(Exception e){  
		       Log.fail("Failed to add page");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to add page");
		       e.printStackTrace();
		       throw e;
		}
	}
	
	static public void addAnswerOption(int answerPosition1, String answerCorrect, String answerText) throws Exception
	{
		try
		{
			Date d = new Date();
			
			String answerPosition = Integer.toString(answerPosition1);
			
			int answerPosition2 = answerPosition1 - 2;
			
			clickIdentifierByID("multiGraphicContentContainer_add");
			
			if (answerCorrect.toLowerCase() == "no")
			{
				uncheckCheckBox(".//*[@id='templateSaqAnswerSection']/ul/ul/li[" + answerPosition + "]/div/div/input");
				Log.info("unchecked correct scenario answer");
			}
			
			if (answerCorrect.toLowerCase() == "yes")
			{
				checkCheckBox(".//*[@id='templateSaqAnswerSection']/ul/ul/li[" + answerPosition + "]/div/div/input");
				Log.info("checked correct scenario answer");
			}
			
			if (answerText != "")
				typeTextByiframe("Rich Text Editor, saqAnswerCkEditor" + answerPosition2, answerText + " " + d.toString());
		
			Log.info("added answer option " + answerPosition);
		}
		
		catch(Exception e){  
		       Log.fail("Failed to add additional answer option");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to add additional answer option");
		       e.printStackTrace();
		       throw e;
		}
		
	}
	
}
	
	
