package com.lrn.cat.page;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;


public class EditConcernTemplate extends CATAppCommon{
	
	/**
	 *  to be called after addPage or selectPage
	 * @param showTitle show page title yes or blank for no
	 * @param pageTitle supply page title
	 * @param concernLayout Left to Right or Right to Left
	 * @param concernContent content for concern meter
	 * @param meterQuestion the question for the concern meter
	 * @param meterQuestionType "Multiple Choice" or "Check All"
	 * @param meterCorrectAnswer is answer 1 correct yes or blank for no
	 * @param meterAnswer answer 1 text
	 * @param meterAnswerImage answer 1 image yes or blank for no
	 * @param meterAnswerDesktop answer 1 desktop image yes or blank for no
	 * @param meterAnswerImageDesc answer 1 image description
	 * @param meterAnswerAltText answer 1 alt text
	 * @param questionText question text after concern meter
	 * @param questionAudio add audio for the question yes or blank for no
	 * @param questionType "Multiple Choice" or "Check All"
	 * @param correctAnswer is answer 1 correct for question after meter
	 * @param answerText answer 1 text
	 * @param answerImage answer 1 image yes or blank for no
	 * @param answerDesktopImage answer 1 desktop image yes or blank for no
	 * @param answerImageDesc answer 1 image description for question after meter
	 * @param answerAltText answer 1 alt text for question for after meter
	 * @param retryNumber number of retry attempts, leave blank to not configured
	 * @param retryTitle retry title, leave blank if not configured
	 * @param retryMessage retry message text, leave blank if not configured
	 * @param retryButton retry button text, leave blank if not configured
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
	 * @param pageAudio add page audio yes or blank for no
	 * @param backgroundImage add background image yes or blank for no
	 */
	static public void editConcernTemplate(String showTitle, String pageTitle, String concernLayout, String concernContent, String meterQuestion, String meterQuestionType, String meterCorrectAnswer, String meterAnswer, String meterAnswerImage, String meterAnswerDesktop, String meterAnswerImageDesc, String meterAnswerAltText, String questionText, String questionAudio, String questionType,  String correctAnswer, String answerText, String answerImage, String answerDesktopImage, String answerImageDesc, String answerAltText, String retryNumber, String retryTitle, String retryMessage, String retryButton, String feedbackOption, String singleFeedback, String singleImage, String singleImageDesc, String singleAltText, String correctTitle, String correctContent, String correctImage, String correctImageDesc, String correctAltText, String incorrectTitle, String incorrectContent, String incorrectImage, String incorrectImageDesc, String incorrectAltText, String pageAudio, String backgroundImage) throws Exception
	{
		try
		{
			Date d = new Date();
			
			Log.startTestCase("start editing concern");
			
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
			
			if (concernLayout == "Left To Right" || concernLayout == "Right To Left")
				selectDropdownValueXpathVisibleText(".//*[@id='concernLayout']/div[1]/div/select", concernLayout);
			
			//enter meter stuff
			
			if (concernContent != "")
				typeTextById("ckeditorContentconcernText", concernContent + " " + d.toString());
			
			if (meterQuestion != "")
				typeTextById("ckeditorContentconcernQuestion", meterQuestion + " " + d.toString());
			
			if (meterQuestionType == "Multiple Choice" || questionType == "Check All")
				selectDropdownValueXpathVisibleText(".//*[@id='concernQuestionType']/div[1]/div/select", meterQuestionType);
			
			if (meterCorrectAnswer.toLowerCase() == "no")
			{
				uncheckCheckBox(".//*[@id='multiGraphicContentContainerconcernAnswer']/div/div/label/input");
				Log.info("unchecked correct meter answer");
			}
			
			if (meterCorrectAnswer.toLowerCase() == "yes")
			{
				checkCheckBox(".//*[@id='multiGraphicContentContainerconcernAnswer']/div/div/label/input");
				Log.info("checked correct meter answer");
			}
			
			if (meterAnswer != "")
				typeTextByXpath(".//*[@id='multiGraphicContent_add']/li[1]/div[1]/div[1]/div[1]/div", meterAnswer + " " + d.toString());
			
			if (meterAnswerImage.toLowerCase() == "yes")
			{
				checkCheckBox(".//*[@id='multiGraphicContent_add']/li[1]/div[1]/div[4]/div[1]/label/input");
				Log.info("checked meter answer image");
			}
			
			if (meterAnswerDesktop != "")
			{
				String image = getRandomImage();
			
				//WebElement file = driver.findElement(By.xpath(".//*[@id='concernAnswer']/ul/li[1]/div[1]/div[4]/div[2]/div/div[1]/input[2]"));
				//file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
				clickIdentifierXpath(".//*[@id='multiGraphicContent_add']/li[1]/div[1]/div[4]/div[2]/div/div[1]/img");
				//driver.switchTo().activeElement().sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jp");
				WebElement file = driver.findElement(By.xpath(".//*[@id='concernAnswer']/ul/li[1]/div[1]/div[4]/div[2]/div/div[1]/input[2]"));
				file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
				
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
				Thread.sleep(60000);
				Log.info("uploaded meter answer image");
				if(driver.getPageSource().contains(image))
					Log.pass("successfully uploaded meter answer image");
			}
			
			if (meterAnswerImageDesc != "")
				typeTextByXpath(".//*[@id='multiGraphicContent_add']/li[1]/div[1]/div[4]/div[3]/div/input", meterAnswerImageDesc + " " + d.toString());
			
			if (meterAnswerAltText != "")
				typeTextByXpath(".//*[@id='multiGraphicContent_add']/li[1]/div[1]/div[4]/div[4]/div/input", meterAnswerAltText + " " + d.toString());
			
			if (questionText != "")
				typeTextById("ckeditorContentconcernMeterQuestion", questionText + " " + d.toString());
			
			Thread.sleep(2000);
			
/*			if (questionAudio != "")
			{
			String audio = getRandomAudio();
				clickIdentifierXpath(".//*[@id='sltAudio']");
				uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\audio\\" + audio + ".mp3");
				Thread.sleep(3000);
				Log.info("uploaded question audio");
			}*/
			
			if (questionType == "Multiple Choice" || questionType == "Check All")
				selectDropdownValueXpathVisibleText(".//*[@id='concernMeterQuestionType']/div[1]/div/select", questionType);
			
			if (correctAnswer.toLowerCase() == "no")
			{
				uncheckCheckBox(".//*[@id='multiGraphicContentContainerconcernChoice']/div/div/label/input");
				Log.info("unchecked correct answer");
			}
			
			if (correctAnswer.toLowerCase() == "yes")
			{
				checkCheckBox(".//*[@id='multiGraphicContentContainerconcernChoice']/div/div/label/input");
				Log.info("checked correct answer");
			}
			
			if (answerText != "")
				typeTextById("ckeditorconcernChoice", answerText + " " + d.toString());
			
			if (answerImage.toLowerCase() == "yes")
			{
				checkCheckBox(".//*[@id='multiGraphicContentContainerconcernChoice']/div/div[4]/div[1]/label/input");
				Log.info("checked answer image");
			}
			
			if (answerDesktopImage != "")
			{
				String image1 = getRandomImage();
				clickIdentifierXpath(".//*[@id='multiGraphicContentContainerconcernChoice']/div/div[4]/div[2]/div/div[1]/img");
				WebElement file = driver.findElement(By.xpath(".//*[@id='multiGraphicContentContainerconcernChoice']/div/div[4]/div[2]/div/div[1]/input[2]"));
				file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image1 + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image1 + ".jpg");
				Thread.sleep(60000);
				Log.info("uploaded answer image");
			}
			
			if (answerImageDesc != "")
				typeTextByXpath(".//*[@id='multiGraphicContentContainerconcernChoice']/div/div[4]/div[3]/div/input", answerImageDesc + " " + d.toString());
			
			if (answerAltText != "")
				typeTextByXpath(".//*[@id='multiGraphicContentContainerconcernChoice']/div/div[4]/div[4]/div/input", answerAltText + " " + d.toString());
			
			if (retryNumber != "")
				typeTextById("titleTextconcernRetryAttempt", retryNumber);
			
			if (retryTitle != "")
				typeTextById("titleTextconcernRetryAlertTitle", retryTitle + " " + d.toString());
			
			if (retryMessage != "")
				typeTextById("ckeditorContentconcernRetryAlertText", retryMessage + " " + d.toString());
			
			if (retryButton != "")
				typeTextById("titleTextconcernRetryAlertButtonTitle", retryButton + " " + d.toString());
			
			if (feedbackOption.toLowerCase() == "single")
			{
				clickIdentifierXpath(".//*[@id='concernMeterFeedback']/div/div/input[1]");
				
				Thread.sleep(2000);
				
				if (singleFeedback != "")
					typeTextByXpath(".//*[@id='concernMeterFeedback']/div[1]/div[2]/div[2]/div", singleFeedback + " " + d.toString());
				
				if (singleImage != "")
				{
					String image2 = getRandomImage();
					clickIdentifierXpath(".//*[@id='concernMeterFeedback']/div[1]/div[2]/div[3]/div/div[2]/img");
					WebElement file = driver.findElement(By.xpath(".//*[@id='concernMeterFeedback']/div[1]/div[2]/div[3]/div/div[2]/input[2]"));
					file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image2 + ".jpg");
					//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image2 + ".jpg");
					Thread.sleep(60000);
					Log.info("uploaded feedback image");
				}
				
				if (singleImageDesc != "")
					typeTextByXpath(".//*[@id='concernMeterFeedback']/div[1]/div[2]/div[3]/div[2]/input", singleImageDesc + " " + d.toString());
				
				if (singleAltText != "")
					typeTextByXpath(".//*[@id='concernMeterFeedback']/div[1]/div[2]/div[3]/div[3]/input", singleAltText + " " + d.toString());
			}
			
			if (feedbackOption.toLowerCase() == "multiple")
			{
				clickIdentifierXpath(".//*[@id='concernMeterFeedback']/div/div/input[2]");
				
				if (correctTitle != "")
					typeTextById("correctTitle", correctTitle + " " + d.toString());
				
				if (incorrectTitle != "")
					typeTextById("incorrectTitle", incorrectTitle + " " + d.toString());
				
				if (correctContent != "")
					typeTextById("ckeditorContentCorrectconcernFeedback1", correctContent + " " + d.toString());
				
				if (incorrectContent != "")
					typeTextById("ckeditorContentIncorrectconcernFeedback1", incorrectContent + " " + d.toString());
				
				if (correctImage != "")
				{
					String image = getRandomImage();
					clickIdentifierXpath(".//*[@id='feedbackCorrectImage']/div[1]/div[2]/img");
					uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
					Thread.sleep(5000);
					Log.info("uploaded correct feedback image");
				}
				
				if (incorrectImage != "")
				{
					String image = getRandomImage();
					clickIdentifierXpath(".//*[@id='feedbackIncorrectImage']/div[1]/div[2]/img");
					uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
					Thread.sleep(5000);
					Log.info("uploaded incorrect feedback image");
				}
				
				if (correctImageDesc != "")
					typeTextByXpath(".//*[@id='concernMeterFeedback']/div/div[3]/div[1]/div[2]/div[2]/input", correctImageDesc + " " + d.toString());
				
				if (correctAltText != "")
					typeTextByXpath(".//*[@id='concernMeterFeedback']/div/div[3]/div[1]/div[2]/div[3]/input", correctAltText + " " + d.toString());
				
				if (incorrectImageDesc != "")
					typeTextByXpath(".//*[@id='concernMeterFeedback']/div/div[3]/div[2]/div[3]/div[2]/input", incorrectImageDesc + " " + d.toString());
				
				if (incorrectAltText != "")
					typeTextByXpath(".//*[@id='concernMeterFeedback']/div/div[3]/div[2]/div[3]/div[3]/input", incorrectAltText + " " + d.toString());
			
			}
			
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
		catch(Exception e){  
		       Log.fail("Failed to edit concern template");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to edit concern template");
		       e.printStackTrace();
		       throw e;

		}
	}
	
	/**
	 * to be called after editConcernTemplate or selectPage
	 * @param answerPosition the position of the answer option for the meter
	 * @param meterCorrectAnswer is this answer option correct yes or blank for no
	 * @param meterAnswer answer option text
	 * @param meterAnswerImage answer option image yes or blank for no
	 * @param meterAnswerDesktop answer option desktop image yes or blank for no
	 * @param meterAnswerImageDesc answer option image description
	 * @param meterAnswerAltText answer option alt text
	 */
	static public void addMeterAnswer(String answerPosition, String meterCorrectAnswer, String meterAnswer, String meterAnswerImage, String meterAnswerDesktop, String meterAnswerImageDesc, String meterAnswerAltText) throws Exception
	{
		try
		{
			Date d = new Date();
			
			Log.info("start adding additional concern meter answer");
			
			clickIdentifierByID("multiGraphicContentContainer_addconcernAnswer");
			
			if (meterCorrectAnswer.toLowerCase() == "no")
			{
				uncheckCheckBox(".//*[@id='concernAnswer']/ul/li[" + answerPosition + "]/div/div[2]/label[2]/input");
				Log.info("unchecked correct meter answer");
			}
			
			if (meterCorrectAnswer.toLowerCase() == "yes")
			{
				checkCheckBox(".//*[@id='concernAnswer']/ul/li[" + answerPosition + "]/div/div[2]/label[2]/input");
				Log.info("checked correct meter answer");
			}
			
			if (meterAnswer != "")
				typeTextByXpath(".//*[@id='concernAnswer']/ul/li[" + answerPosition + "]/div/div[2]/div/div[1]", meterAnswer + " " + d.toString());
			
			if (meterAnswerImage.toLowerCase() == "yes")
			{
				checkCheckBox(".//*[@id='concernAnswer']/ul/li[" + answerPosition + "]/div/div[5]/div[1]/label/input");
				Log.info("checked meter answer image");
			}
			
			if (meterAnswerDesktop != "")
			{
				String image = getRandomImage();
				clickIdentifierXpath(".//*[@id='concernAnswer']/ul/li[" + answerPosition + "]/div/div[5]/div[2]/div[1]/div[1]/img");
				uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
				Thread.sleep(60000);
				Log.info("uploaded meter answer image");
			}
			
			if (meterAnswerImageDesc != "")
				typeTextByXpath(".//*[@id='concernAnswer']/ul/li[" + answerPosition + "]/div/div[5]/div[3]/div/input", meterAnswerImageDesc + " " + d.toString());
			
			if (meterAnswerAltText != "")
				typeTextByXpath(".//*[@id='concernAnswer']/ul/li[" + answerPosition + "]/div/div[5]/div[4]/div/input", meterAnswerAltText + " " + d.toString());
			
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			
			clickIdentifierByID("ok-button");
			
			String pageSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			Thread.sleep(3000);
			
			if (pageSaved.contains("Page saved"))
				Log.pass("page saved");
			else
				Log.fail("page failed to save for reason: " + pageSaved);
		}
		catch(Exception e){  
		       Log.fail("Failed to add additional concern meter answer");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to add additional concern meter answer");
		       e.printStackTrace();
		       throw e;

		}
	}
	
	/**
	 * to be called after editConcernTemplate or selectPage, this is for the question after the meter
	 * @param answerPosition the position of the answer option for after the meter
	 * @param meterCorrectAnswer is this answer option correct yes or blank for no
	 * @param meterAnswer answer option text
	 * @param meterAnswerImage answer option image yes or blank for no
	 * @param meterAnswerDesktop answer option desktop image yes or blank for no
	 * @param meterAnswerImageDesc answer option image description
	 * @param meterAnswerAltText answer option alt text
	 */
	static public void addAnswerOption(String answerPosition, String correctAnswer, String answerText, String answerImage, String answerDesktopImage, String answerImageDesc, String answerAltText) throws Exception
	{
		try
		{
			Date d = new Date();
			
			Log.info("start adding additional answer");
			
			clickIdentifierByID("multiGraphicContentContainer_addconcernChoice");
			
			if (correctAnswer.toLowerCase() == "no")
			{
				uncheckCheckBox(".//*[@id='concernChoice']/ul/li[" + answerPosition + "]/div/div[2]/label[2]/input");
				Log.info("unchecked correct answer");
			}
			
			if (correctAnswer.toLowerCase() == "yes")
			{
				checkCheckBox(".//*[@id='concernChoice']/ul/li[" + answerPosition + "]/div/div[2]/label[2]/input");
				Log.info("checked correct answer");
			}
			
			if (answerText != "")
				typeTextByXpath(".//*[@id='concernChoice']/ul/li[" + answerPosition + "]/div/div[2]/div/div", answerText + " " + d.toString());
			
			if (answerImage.toLowerCase() == "yes")
			{
				checkCheckBox(".//*[@id='concernChoice']/ul/li[" + answerPosition + "]/div/div[5]/div[1]/label/input");
				Log.info("checked answer image");
			}
			
			if (answerDesktopImage != "")
			{
				String image = getRandomImage();
				clickIdentifierXpath(".//*[@id='concernChoice']/ul/li[" + answerPosition + "]/div/div[5]/div[2]/div/div[1]/img");
				uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
				Thread.sleep(60000);
				Log.info("uploaded answer image");
			}
			
			if (answerImageDesc != "")
				typeTextByXpath(".//*[@id='concernChoice']/ul/li[" + answerPosition + "]/div/div[5]/div[3]/div/input", answerImageDesc + " " + d.toString());
			
			if (answerAltText != "")
				typeTextByXpath(".//*[@id='concernChoice']/ul/li[" + answerPosition + "]/div/div[5]/div[4]/div/input", answerAltText + " " + d.toString());
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			
			clickIdentifierByID("ok-button");
			
			String pageSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			Thread.sleep(3000);
			
			if (pageSaved.contains("Page saved"))
				Log.pass("page saved");
			else
				Log.fail("page failed to save for reason: " + pageSaved);
		}
		
		catch(Exception e){  
		       Log.fail("Failed to add additional answer");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to add additional answer");
		       e.printStackTrace();
		       throw e;

		}
	}

}
