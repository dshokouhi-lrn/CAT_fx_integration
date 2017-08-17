package com.lrn.cat.page;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class EditConsult extends CATAppCommon{
	
	
	/**
	 * to be called after addPage or selectPage
	 * @param showTitle show title yes/no
	 * @param pageTitle supply page content
	 * @param layoutConsult Left to Right or Right to Left
	 * @param consultContent content for the page
	 * @param consultClickText first consult image click text
	 * @param consultClickTitle first consult image click title
	 * @param consultImage first consult image yes or blank for no
	 * @param consultImageDesc first consult image description
	 * @param consultAltText first consult alt text
	 * @param consultQuestion consult question text
	 * @param consultQuestionAudio consult question audio yes or blank for no
	 * @param consultQuestionType consult question type either: "Two or More Correct Answers" or "One Correct Answer"
	 * @param consultAnswerCorrect is the first answer correct yes/no
	 * @param consultAnswer first answer text
	 * @param consultAnswerImage first answer image yes/no
	 * @param consultAnswerDesktopImage first answer desktop image yes or blank for no
	 * @param consultAnswerImageDesc first answer image description
	 * @param consultAnswerAltText first answer alt text
	 * @param consultRetryNumber number of retry attempts, leave blank to configure
	 * @param consultRetryTitle title for retry prompt, leave blank to configure
	 * @param consultRetryMessage message for retry prompt, leave blank to configure
	 * @param consultRetryButton button text for retry prompt, leave blank to configure
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
	static public void editConsult(String showTitle, String pageTitle, String layoutConsult, String consultContent, String consultClickText, String consultClickTitle, String consultImage, String consultImageDesc, String consultAltText, String consultQuestion, String consultQuestionAudio, String consultQuestionType, String consultAnswerCorrect, String consultAnswer, String consultAnswerImage, String consultAnswerDesktopImage, String consultAnswerImageDesc, String consultAnswerAltText, String consultRetryNumber, String consultRetryTitle, String consultRetryMessage, String consultRetryButton, String feedbackOption, String singleFeedback, String singleImage, String singleImageDesc, String singleAltText, String correctTitle, String correctContent, String correctImage, String correctImageDesc, String correctAltText, String incorrectTitle, String incorrectContent, String incorrectImage, String incorrectImageDesc, String incorrectAltText, String pageAudio, String backgroundImage) throws Exception
	{
		try
		{
			Date d = new Date();
			
			Log.startTestCase("start editing consult");
			
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
			
			if (layoutConsult == "Left To Right" || layoutConsult == "Right To Left")
				selectDropdownValueXpathVisibleText(".//*[@id='consultLayout']/div[1]/div/select", layoutConsult);
			
			if (consultContent != "")
				typeTextById("ckeditorContentconsultContent", consultContent + " " + d.toString());
			
			if (consultClickText != "")
				typeTextById("ckeditorconsultClickReveal", consultClickText + " " + d.toString());
			
			if (consultClickTitle != "")
				typeTextById("desc_richTextconsultClickReveal", consultClickTitle + " " + d.toString());
			
			if (consultImage != "")
			{
				String image = getRandomImage();
				clickIdentifierXpath(".//*[@id='consultClickReveal']/ul/li/div/div[4]/div[2]/div/div/img");
				WebElement file = driver.findElement(By.xpath(".//*[@id='consultClickReveal']/ul/li/div/div[4]/div[2]/div/div/input[2]"));
				file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
				Thread.sleep(15000);
				Log.info("uploaded consult image");
			}
			
			if (consultImageDesc != "")
				typeTextByXpath(".//*[@id='consultClickReveal']/ul/li/div/div[4]/div[3]/div/input", consultImageDesc + " " + d.toString());
			
			if (consultAltText != "")
				typeTextByXpath(".//*[@id='consultClickReveal']/ul/li/div/div[4]/div[4]/div/input", consultAltText + " " + d.toString());
			
			if (consultQuestion != "")
				typeTextById("ckeditorContentconsultQuestion", consultQuestion + " " + d.toString());
			
			if (consultQuestionAudio != "")
			{
				/*String audio = getRandomAudio();
				clickIdentifierByID("sltAudio");
				uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\audio\\" + audio + ".mp3");
				Thread.sleep(3000);*/
				Log.info("uploaded audio");
			}
			
			if (consultQuestionType == "One Correct Answer" || consultQuestionType == "Two or More Correct Answers")
				selectDropdownValueXpathVisibleText(".//*[@id='consultQuestionType']/div[1]/div/select", consultQuestionType);
			
			if (consultAnswerCorrect.toLowerCase() == "no")
			{
				uncheckCheckBox(".//*[@id='consultAnswer']/ul/li[1]/div/div/label[2]/input");
				Log.info("unchecked correct answer");
			}
			
			if (consultAnswerCorrect.toLowerCase() == "yes")
			{
				checkCheckBox(".//*[@id='consultAnswer']/ul/li[1]/div/div/label[2]/input");
				Log.info("checked correct answer");
			}
			
			if (consultAnswer != "")
				typeTextById("ckeditorconsultAnswer", consultAnswer + " " + d.toString());
			
			if (consultAnswerImage.toLowerCase() == "yes")
			{
				checkCheckBox(".//*[@id='consultAnswer']/ul/li[1]/div/div[4]/div[1]/label/input");
				Log.info("checked answer image");
			}
			
			if (consultAnswerDesktopImage != "")
			{
				String image = getRandomImage();
				clickIdentifierXpath(".//*[@id='consultAnswer']/ul/li[1]/div/div[4]/div[2]/div/div[1]/img");
				WebElement file = driver.findElement(By.xpath(".//*[@id='consultAnswer']/ul/li[1]/div/div[4]/div[2]/div/div[1]/input[2]"));
				file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
				Thread.sleep(15000);
				Log.info("uploaded consult image");
			}
			
			if (consultAnswerImageDesc != "")
				typeTextByXpath(".//*[@id='consultAnswer']/ul/li[1]/div/div[4]/div[3]/div/input", consultAnswerImageDesc + " " + d.toString());
			
			if (consultAnswerAltText != "")
				typeTextByXpath(".//*[@id='consultAnswer']/ul/li[1]/div/div[4]/div[4]/div/input", consultAnswerAltText + " " + d.toString());
			
			if (consultRetryNumber != "")
				typeTextById("titleTextconsultRetryAttempt", consultRetryNumber);
			
			if (consultRetryTitle != "")
				typeTextById("titleTextconsultRetryAlertTitle", consultRetryTitle + " " + d.toString());
			
			if (consultRetryMessage != "")
				typeTextById("ckeditorContentconsultRetryAlertText", consultRetryMessage + " " + d.toString());
			
			if (consultRetryButton != "")
				typeTextById("titleTextconsultRetryAlertButtonTitle", consultRetryButton + " " + d.toString());
			
			if (feedbackOption.toLowerCase() == "single")
			{
				clickIdentifierXpath(".//*[@id='consultFeedback']/div/div/input[1]");
				
				if (singleFeedback != "")
					typeTextByXpath(".//*[@id='consultFeedback']/div[1]/div[2]/div[2]/div", singleFeedback + " " + d.toString());
				
				if (singleImage != "")
				{
					String image = getRandomImage();
					clickIdentifierXpath(".//*[@id='consultFeedback']/div[1]/div[2]/div[3]/div/div[2]/img");
					WebElement file = driver.findElement(By.xpath(".//*[@id='consultFeedback']/div[1]/div[2]/div[3]/div/div[2]/input[2]"));
					file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
					//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
					Thread.sleep(60000);
					Log.info("uploaded feedback image");
				}
				
				if (singleImageDesc != "")
					typeTextByXpath(".//*[@id='consultFeedback']/div[1]/div[2]/div[3]/div[2]/input", singleImageDesc + " " + d.toString());
				
				if (singleAltText != "")
					typeTextByXpath(".//*[@id='consultFeedback']/div[1]/div[2]/div[3]/div[3]/input", singleAltText + " " + d.toString());
			}
			
			if (feedbackOption.toLowerCase() == "multiple")
			{
				clickIdentifierXpath(".//*[@id='consultFeedback']/div/div/input[2]");
				
				if (correctTitle != "")
					typeTextByXpath(".//*[@id='consultFeedback']/div[1]/div[3]/div[1]/input", correctTitle + " " + d.toString());
				
				if (incorrectTitle != "")
					typeTextByXpath(".//*[@id='consultFeedback']/div[1]/div[3]/div[2]/input", incorrectTitle + " " + d.toString());
				
				if (correctContent != "")
					typeTextById("ckeditorContentCorrectconsultFeedback1", correctContent + " " + d.toString());
				
				if (incorrectContent != "")
					typeTextById("ckeditorContentIncorrectconsultFeedback1", incorrectContent + " " + d.toString());
				
				if (correctImage != "")
				{
					String image = getRandomImage();
					clickIdentifierXpath(".//*[@id='consultFeedback']/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/img");
					uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
					Thread.sleep(15000);
					Log.info("uploaded correct feedback image");
				}
				
				if (incorrectImage != "")
				{
					String image = getRandomImage();
					clickIdentifierXpath(".//*[@id='consultFeedback']/div[1]/div[3]/div[2]/div[3]/div[1]/div[2]/img");
					uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
					Thread.sleep(15000);
					Log.info("uploaded incorrect feedback image");
				}
				
				if (correctImageDesc != "")
					typeTextByXpath(".//*[@id='consultFeedback']/div/div[3]/div[1]/div[2]/div[2]/input", correctImageDesc + " " + d.toString());
				
				if (correctAltText != "")
					typeTextByXpath(".//*[@id='consultFeedback']/div/div[3]/div[1]/div[2]/div[3]/input", correctAltText + " " + d.toString());
				
				if (incorrectImageDesc != "")
					typeTextByXpath(".//*[@id='consultFeedback']/div/div[3]/div[2]/div[3]/div[2]/input", incorrectImageDesc + " " + d.toString());
				
				if (incorrectAltText != "")
					typeTextByXpath(".//*[@id='consultFeedback']/div/div[3]/div[2]/div[3]/div[3]/input", incorrectAltText + " " + d.toString());
				
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
			
			clickIdentifierByID("ok-button");
			
			String pageSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			Thread.sleep(3000);
			
			if (pageSaved.contains("Page saved"))
				Log.pass("page saved");
			else
				Log.fail("page failed to save for reason: " + pageSaved);
		}
		
		catch(Exception e){  
		       Log.fail("Failed to edit consult page");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to edit consult page");
		       e.printStackTrace();
		       throw e;

		}
	}
	
	/**
	 * to be called after editConsult or selectPage
	 * @param consultPosition the position of the consult image
	 * @param consultClickText consult image text
	 * @param consultClickTitle consult image title
	 * @param consultImage consult image yes or blank for no
	 * @param consultImageDesc consult image description
	 * @param consultAltText consult alt text
	 */
	static public void addConsult(int consultPosition, String consultClickText, String consultClickTitle, String consultImage, String consultImageDesc, String consultAltText) throws Exception
	{
		try
		{
			
			Date d = new Date();
			
			Log.info("start adding additional consult section");
			
			int consultCount = consultPosition + 1;
			
			clickIdentifierByID("multiGraphicContentContainer_addconsultClickReveal");
			
			if (consultClickText != "")
				typeTextById("ckeditorconsultClickReveal" + consultPosition, consultClickText + " " + d.toString());
			
			if (consultClickTitle != "")
				typeTextById("desc_richTextconsultClickReveal" + consultPosition, consultClickTitle + " " + d.toString());
			
			if (consultImage != "")
			{
				String image = getRandomImage();
				clickIdentifierXpath(".//*[@id='consultClickReveal']/ul/li[" + consultCount + "]/div/div[5]/div[2]/div/div/img");
				WebElement file = driver.findElement(By.xpath(".//*[@id='consultClickReveal']/ul/li[" + consultCount + "]/div/div[5]/div[2]/div/div/input[2]"));
				file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
				Thread.sleep(60000);
				Log.info("uploaded consult image");
			}
			
			if (consultImageDesc != "")
				typeTextByXpath(".//*[@id='consultClickReveal']/ul/li[" + consultCount + "]/div/div[5]/div[3]/div/input", consultImageDesc + " " + d.toString());
			
			if (consultAltText != "")
				typeTextByXpath(".//*[@id='consultClickReveal']/ul/li[" + consultCount + "]/div/div[5]/div[4]/div/input", consultAltText + " " + d.toString());
			
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
		       Log.fail("Failed to add consult section");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to add consult section");
		       e.printStackTrace();
		       throw e;

		}
	}
	
	/**
	 * to be called after selectPage or editConsult
	 * @param answerPosition the answer position for the added answer
	 * @param consultAnswerCorrect is the answer correct yes/no
	 * @param consultAnswer answer text
	 * @param consultAnswerImage answer image yes or blank for no
	 * @param consultAnswerDesktopImage answer desktop image yes or blank for no
	 * @param consultAnswerImageDesc answer image description
	 * @param consultAnswerAltText answer alt text
	 */
	static public void addAnswerOption(String answerPosition, String consultAnswerCorrect, String consultAnswer, String consultAnswerImage, String consultAnswerDesktopImage, String consultAnswerImageDesc, String consultAnswerAltText) throws Exception
	{
		try
		{
			Date d = new Date();
			
			Log.info("start adding additional consult answer option");
			
			clickIdentifierByID("multiGraphicContentContainer_addconsultAnswer");
			
			if (consultAnswerCorrect.toLowerCase() == "no")
			{
				uncheckCheckBox(".//*[@id='consultAnswer']/ul/li[" + answerPosition + "]/div/div[2]/label[2]/input");
				Log.info("unchecked correct answer");
			}
			
			if (consultAnswerCorrect.toLowerCase() == "yes")
			{
				checkCheckBox(".//*[@id='consultAnswer']/ul/li[" + answerPosition + "]/div/div[2]/label[2]/input");
				Log.info("checked correct answer");
			}
			
			if (consultAnswer != "")
				typeTextByXpath(".//*[@id='consultAnswer']/ul/li[" + answerPosition + "]/div/div[2]/div/div", consultAnswer + " " + d.toString());
			
			if (consultAnswerImage.toLowerCase() == "yes")
			{
				checkCheckBox(".//*[@id='consultAnswer']/ul/li[" + answerPosition + "]/div/div[5]/div[1]/label/input");
				Log.info("checked answer image");
			}
			
			if (consultAnswerDesktopImage != "")
			{
				String image = getRandomImage();
				clickIdentifierXpath(".//*[@id='consultAnswer']/ul/li[" + answerPosition + "]/div/div[5]/div[2]/div/div[1]/img");
				WebElement file = driver.findElement(By.xpath(".//*[@id='consultAnswer']/ul/li[" + answerPosition + "]/div/div[5]/div[2]/div/div[1]/input[2]"));
				file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
				Thread.sleep(60000);
				Log.info("uploaded consult image");
			}
			
			if (consultAnswerImageDesc != "")
				typeTextByXpath(".//*[@id='consultAnswer']/ul/li[" + answerPosition + "]/div/div[5]/div[3]/div/input", consultAnswerImageDesc + " " + d.toString());
			
			if (consultAnswerAltText != "")
				typeTextByXpath(".//*[@id='consultAnswer']/ul/li[" + answerPosition + "]/div/div[5]/div[4]/div/input", consultAnswerAltText + " " + d.toString());
			
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
		       Log.fail("Failed to add answer option");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to add answer option");
		       e.printStackTrace();
		       throw e;

		}
	}

}
