package com.lrn.cat.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class ReorderNodes extends CATAppCommon{
	
	/**
	 * Must be called after editGetStarted or while script is on create your course tab
	 */
	static public void collapseLessons() throws Exception
	{
		try
		{
			Log.info("starting collapse lessons test case");  
			
			//WebElement productLink = driver.findElement(By.xpath(".//*[@id='j1_7_anchor']"));
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			
			clickIdentifierXpath("//*[@id='courseTree']/ul/li/a");
			
			Thread.sleep(3000);
			
			WebElement productLink = driver.findElement(By.xpath("//*[@id='courseTree']/ul/li/a"));
			  
			Log.info("found the page"); 
			  
			Actions action= new Actions(driver);
			action.contextClick(productLink).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.RETURN).build().perform();
			
			Log.info("right clicked on the page");
			Thread.sleep(10000);
			
			clickIdentifierXpath("html/body/ul/li[1]/a");
			Log.pass("clicked on collapse lessons");
			Thread.sleep(20000);
			
			clickIdentifierXpath("//*[@id='courseTree']/ul/li/i");
		}
		
		catch(Exception e){  
            Log.fail("Failed to collapse lessons");
            e.printStackTrace();
            throw e;                                        
     } catch(AssertionError e)
     {
            Log.fail("Failed to collapse lessons");
            e.printStackTrace();
            throw e;

     }
	}
	
	/**
	 * Must be called after collapseLesson
	 * @param fromLesson provide the location of the lesson we are dragging (note: if landing page is present increase number by 1)
	 * @param toLesson provide the location where the fromLesson will be dropped to (note: if landing page is present increase number by 1)
	 */
	
	static public void dragAndDropLesson(String fromLesson, String toLesson) throws Exception
	{
		try
		{
			
			Log.info("start drag and drop lesson test case");
			
			Actions builder = new Actions(driver);
			
			Action dragAndDrop = builder.clickAndHold(driver.findElement(By.xpath("//*[@id='courseTree']/ul/li/ul/li[" + fromLesson + "]/div"))) //some element will be the location(xpath) from where you will drag
					   .moveToElement(driver.findElement(By.xpath("//*[@id='courseTree']/ul/li/ul/li[" + toLesson + "]/div"))) //other element will be the xpath where you gona drop.
					   .release(driver.findElement(By.xpath("//*[@id='courseTree']/ul/li/ul/li[" + toLesson + "]/div")))
					   .build();
					dragAndDrop.perform();

					String publish = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
					
					if (publish.contains("Successfully reordered course."))
					{
						Log.pass("lesson " + fromLesson + " dropped to lesson " + toLesson);
					}
					
					else
						Log.fail("Unable to reorder course for reason: " + publish);
		}
		
		catch(Exception e){  
            Log.fail("Failed to drag and drop lessons");
            e.printStackTrace();
            throw e;                                        
     } catch(AssertionError e)
     {
            Log.fail("Failed to drag and drop lessons");
            e.printStackTrace();
            throw e;

     }
	}
	
	/**
	 * Must be called while user is on create your course tab or after editGetStarted
	 * @param fromTopic the position of the topic we are grabbing
	 * @param toTopic the position of the topic we are dropping fromTopic to
	 * @param fromLesson the lesson position for fromTopic (note: if landing page is present increase number by 1)
	 * @param toLesson the lesson position for toTopic (note: if landing page is present increase number by 1)
	 * @throws Exception
	 */
	
	static public void dragAndDropTopic(String fromTopic, String toTopic, String fromLesson, String toLesson) throws Exception
	{
		try
		{
			
			Log.info("start drag and drop topics");
			
			Actions builder = new Actions(driver);
			
			Action dragAndDrop = builder.clickAndHold(driver.findElement(By.xpath("//*[@id='courseTree']/ul/li/ul/li[" + fromLesson + "]/ul/li[" + fromTopic + "]/div"))) //some element will be the location(xpath) from where you will drag
					   .moveToElement(driver.findElement(By.xpath("//*[@id='courseTree']/ul/li/ul/li[" + toLesson + "]/ul/li[" + toTopic + "]/div"))) //other element will be the xpath where you gona drop.
					   .release(driver.findElement(By.xpath("//*[@id='courseTree']/ul/li/ul/li[" + toLesson + "]/ul/li[" + toTopic + "]/div")))
					   .build();
					dragAndDrop.perform();

					String publish = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
					
					if (publish.contains("Successfully reordered course."))
					{
						Log.pass("dragged topic " + fromTopic + " from lesson " + fromLesson + " to topic " + toTopic + " at lesson " + toLesson);
					}
					
					else
						Log.fail("Unable to reorder course for reason: " + publish);
		}
		
		catch(Exception e){  
            Log.fail("Failed to drag and drop topic");
            e.printStackTrace();
            throw e;                                        
     } catch(AssertionError e)
     {
            Log.fail("Failed to drag and drop topic");
            e.printStackTrace();
            throw e;

     }
	}
	
	/**
	 * Must be called after editGetStarted or while user is on create your course tab
	 * @param fromTopic position of topic we are moving
	 * @param toTopic position of topic we are dropping fromTopic to
	 * @param fromLesson position of lesson for fromTopic (note: if landing page is present increase number by 1)
	 * @param toLesson position of lesson for toTopic (note: if landing page is present increase number by 1)
	 */
	
	static public void dragTopicToDropLesson(String fromTopic, String toTopic, String fromLesson, String toLesson) throws Exception
	{
		try
		{
			Log.info("start drag topic to lesson");
			
			Actions builder = new Actions(driver);
			
			Action dragAndDrop = builder.clickAndHold(driver.findElement(By.xpath("//*[@id='courseTree']/ul/li/ul/li[" + fromLesson + "]/ul/li[" + fromTopic + "]/div"))) //some element will be the location(xpath) from where you will drag
					   .moveToElement(driver.findElement(By.xpath("//*[@id='courseTree']/ul/li/ul/li[" + toLesson + "]/div"))) //other element will be the xpath where you gona drop.
					   .release(driver.findElement(By.xpath("//*[@id='courseTree']/ul/li/ul/li[" + toLesson + "]/div")))
					   .build();
					dragAndDrop.perform();

					String publish = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
					
					if (publish.contains("Successfully reordered course."))
					{
						Log.pass("moved topic " + fromTopic + " to lesson " + toLesson);
					}
					
					else
						Log.fail("Unable to reorder course for reason: " + publish);
		}
		
		catch(Exception e){  
            Log.fail("Failed to drag and drop topic");
            e.printStackTrace();
            throw e;                                        
     } catch(AssertionError e)
     {
            Log.fail("Failed to drag and drop topic");
            e.printStackTrace();
            throw e;

     }
	}
	
	/**
	 * Must be called after editGetStarted or while user is on create your course tab
	 * @param fromTopic position of topic where we are grabbing the fromPage from
	 * @param toTopic position of topic where we are dropping the fromPage to
	 * @param fromLesson position of lesson where we are grabbing fromPage (note: if landing page is present increase number by 1)
	 * @param toLesson position of lesson where we are dropping fromPage to (note: if landing page is present increase number by 1)
	 * @param fromPage position of the page are moving
	 * @param toPage position of the page we are dropping fromPage to
	 */
	
	static public void dragPageToDropTopic(String fromTopic, String toTopic, String fromLesson, String toLesson, String fromPage, String toPage) throws Exception
	{
		try
		{
			Log.info("start dragging page to topic");
			
			Actions builder = new Actions(driver);
			
			Action dragAndDrop = builder.clickAndHold(driver.findElement(By.xpath("//*[@id='courseTree']/ul/li/ul/li[" + fromLesson + "]/ul/li[" + fromTopic + "]/ul/li[" + fromPage + "]/div"))) //some element will be the location(xpath) from where you will drag
					   .moveToElement(driver.findElement(By.xpath("//*[@id='courseTree']/ul/li/ul/li[" + toLesson + "]/ul/li[" + toTopic + "]/div"))) //other element will be the xpath where you gona drop.
					   .release(driver.findElement(By.xpath("//*[@id='courseTree']/ul/li/ul/li[" + toLesson + "]/ul/li[" + toTopic + "]/div")))
					   .build();
					dragAndDrop.perform();

					String publish = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
					
					if (publish.contains("Successfully reordered course."))
					{
						Log.pass("moved page " + fromPage + " from lesson " + fromLesson + " to topic " + toTopic + " at lesson " + toLesson);
					}
					
					else
						Log.fail("Unable to reorder course for reason: " + publish);
		}
		
		catch(Exception e){  
            Log.fail("Failed to drag and drop page");
            e.printStackTrace();
            throw e;                                        
     } catch(AssertionError e)
     {
            Log.fail("Failed to drag and drop page");
            e.printStackTrace();
            throw e;

     }
	}
	
	/**
	 * Must be called after editGetStarted or while user is on create your course tab
	 * @param fromTopic position of topic where we are grabbing the fromPage from
	 * @param toTopic position of topic where we are dropping the fromPage to
	 * @param fromLesson position of lesson where we are grabbing fromPage (note: if landing page is present increase number by 1)
	 * @param toLesson position of lesson where we are dropping fromPage to (note: if landing page is present increase number by 1)
	 * @param fromPage position of the page are moving
	 * @param toPage position of the page we are dropping fromPage to
	 */
	
	static public void dragPageToDropLesson(String fromTopic, String toTopic, String fromLesson, String toLesson, String fromPage, String toPage) throws Exception
	{
		try
		{
			Log.startTestCase("start dragging page to lesson");
			
			Actions builder = new Actions(driver);
			
			Action dragAndDrop = builder.clickAndHold(driver.findElement(By.xpath("//*[@id='courseTree']/ul/li/ul/li[" + fromLesson + "]/ul/li[" + fromTopic + "]/ul/li[" + fromPage + "]/div"))) //some element will be the location(xpath) from where you will drag
					   .moveToElement(driver.findElement(By.xpath("//*[@id='courseTree']/ul/li/ul/li[" + toLesson + "]/div"))) //other element will be the xpath where you gona drop.
					   .release(driver.findElement(By.xpath("//*[@id='courseTree']/ul/li/ul/li[" + toLesson + "]/div")))
					   .build();
					dragAndDrop.perform();

					String publish = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
					
					if (publish.contains("Successfully reordered course."))
					{
						Log.pass("moved page " + fromPage + " from lesson " + fromLesson + " to lesson " + toLesson);
					}
					
					else
						Log.fail("Unable to reorder course for reason: " + publish);
		}
		
		catch(Exception e){  
            Log.fail("Failed to drag and drop page");
            e.printStackTrace();
            throw e;                                        
     } catch(AssertionError e)
     {
            Log.fail("Failed to drag and drop page");
            e.printStackTrace();
            throw e;

     }
	}

}
