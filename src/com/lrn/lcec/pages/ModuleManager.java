package com.lrn.lcec.pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class ModuleManager extends CATAppCommon
{
	private List<WebElement> element = null;
	String SearchBox_Xpath="//input[@id='search']";
	String SearchButton_Xpath="//button[text()='Search']";
	String FilterValue_Xpath="//select[@id='filter_options']";
	String AdminTool_Xpath="//a[text()='Admin Tools']";
	String Module_Manager_Xpath="//div[contains(text(),'Module Manager')]";
	public static String window = null;
	//this method use for search module
	
	/**
	 * Called after LCECLogin to navigate to module manager
	 */
	public void getModuleManager() throws Exception
	{
		Log.info("navigate to admin tools");
		//click admin tool link
		clickIdentifierXpath(AdminTool_Xpath);
		//LogerData.info("Click Admin tool link.");
		//getScrrolToWebElement(Module_Manager_Xpath);
		clickIdentifierXpath(Module_Manager_Xpath);
		
		Log.info("navigate to module manager");
		//LogerData.info("Click Module Manager link.");
	}
	
	/**
	 * Must be called after getModuleManager, will search for a course and select it
	 * @param SearchModule provide the base catalog ID
	 */
	public void getSearchModule(String SearchModule) throws Exception
	{
		
		Log.startTestCase("searching for course: " + SearchModule);
		Thread.sleep(5000);
		//String NextButton="//a[contains(text(),'next')]";
		String PreviesButton="//span[contains(text(),'prev')]";
		getWaitForElementPresent(PreviesButton,1000);
		
		//getWaitForElementPresent(NextButton,10000);
		typeTextByXpath(SearchBox_Xpath,SearchModule);
		//LogerData.info("Send text to  Search Box");
		WebElement filterLocater=driver.findElement(By.xpath(FilterValue_Xpath));
		getDroupDown(filterLocater,"Search the entire LRN Library");
		clickIdentifierXpath(SearchButton_Xpath);
		Log.info("Clicked on Search Button.");
		Thread.sleep(5000);
		
		getWaitForElementPresent("//div/div/div/div[@class='module_header']",600);
		element=driver.findElements(By.xpath("//div/div/div/div[@class='module_header']"));
		//Thread.sleep(2000);
		for(int k=1;k<=element.size();k++)
		{
			String exceptedResultXpath="//div["+k+"]/div/div/div[@class='module_header']";
			String exceptedSearchModule=driver.findElement(By.xpath(exceptedResultXpath)).getText();
			
			System.out.println("exceptedSearchModule: "+exceptedSearchModule);
			//String exceptedSearchModule=getTextValueByXpath(exceptedResultXpath,exceptedResultXpath);
			//System.out.println("exceptedSearchModule:"+exceptedSearchModule);
			String exceptedModuleID = exceptedSearchModule.substring(exceptedSearchModule.indexOf("(")+1,exceptedSearchModule.indexOf(")"));
			System.out.println("exceptedModuleID:"+exceptedModuleID);

			if (exceptedModuleID.equalsIgnoreCase(SearchModule)) 
			{
				try
				{
					
					Thread.sleep(5000);
					//assertEquals(SearchModule, exceptedModuleID);
					//Log.info("Searching module ::"+"excepted value "+exceptedModuleID+"and"+"  Actual value::"+SearchModule);
					clickIdentifierXpath("//*[@id='" + SearchModule + "']/div[2]/div/div");
					//LogerData.info("Select Searching Module!");
					//break;
					Thread.sleep(5000);
					Log.pass("clicked on the course");
				}catch(AssertionError  e)
				{
					//LogerData.info("Searching Module are not same");
				}
			}
			
			
		}
	}
	
	

	/******************* Edit Course*************************/
	/**
	 * To be called after getSearchModule, will add course to site and perform copy to edit if necessary before clicking on edit
	 * @param course provide the base catalog ID
	 */
	static public void editFluidxCourse(String course) throws Exception
	{
		try{
			
			//Date d = new Date();
			
			Log.startTestCase("Start edit Fluidx Course in MM");
			
			String expecetedcourse = driver.findElement(By.xpath(".//*[@id='module_" + course + "']/table[1]/tbody[2]/tr[1]/td[3]/div/div")).getAttribute("class");
			System.out.println("expecetedFluidxcourse:"+ expecetedcourse);
			
			
			if (expecetedcourse.equalsIgnoreCase("editionIcon FluidX")) 
			{
				try
				{
					//assertEquals(SearchModule, exceptedModuleID);
					//Log.info("Searching module ::"+"excepted value "+exceptedModuleID+"and"+"  Actual value::"+SearchModule);
					clickIdentifierXpath(".//*[@id='module_" + course + "']/table[1]/tbody[2]/tr[1]/td[3]/div");
					
					Thread.sleep(5000);
					
					Log.info("expanded course");
					
					String addSite = driver.findElement(By.xpath(".//*[@id='module_" + course + "']/table[1]/tbody[2]/tr[1]/td[4]/div/span/span[2]")).getText();
					System.out.println("label for add to site is: " + addSite);
					

					if (addSite.contains("Add to Our Site"))
					{
						clickIdentifierXpath(".//*[@id='module_" + course + "']/table[1]/tbody[2]/tr[1]/td[4]/div/span/span[2]/span");
						//Log.info("attempted to click on add to site button");
						System.out.println("attempted to click on add to site button");
					}
					
					Thread.sleep(5000);
					
					/*boolean copy = driver.findElement(By.xpath(".//*[@id='course_version_" + course + "']/td[1]/div[1]/div[@class='entry library selected']/div[1]/div[1]/div[2]/div[1]/span[2]/span/button")).isDisplayed();
					
					boolean copy1 = driver.findElement(By.xpath(".//*[@id='course_version_" + course + "']/td[1]/div[1]/div[@class='entry ready_to_use selected']/div[1]/div[1]/div[2]/div[1]/span[2]/span/button")).isDisplayed();
					
					if (copy)
						clickIdentifierXpath(".//*[@id='course_version_" + course + "']/td[1]/div[1]/div[@class='entry library selected']/div[1]/div[1]/div[2]/div[1]/span[2]/span/button");
					else if (copy1)
						clickIdentifierXpath(".//*[@id='course_version_" + course + "']/td[1]/div[1]/div[@class='entry ready_to_use selected']/div[1]/div[1]/div[2]/div[1]/span[2]/span/button");
					
					Thread.sleep(5000);*/
					
					clickIdentifierXpath(".//*[@id='course_version_" + course + "']/td[1]/div[1]/div[@class='entry draft selected']/div[1]/div[1]/div[2]/div[1]/span[2]/span/button");
					//LogerData.info("Select Searching Module!");
					
					Log.pass("clicked on the edit button for the course");
					
					Thread.sleep(10000);
					
					Set<String> catWindow = driver.getWindowHandles();
					System.out.println("count of windows open is "  +catWindow.size());
					System.out.println(catWindow);
					Thread.sleep(2000);
					Iterator<String> ite1=catWindow.iterator();
					//System.out.println("Title-------"+driver.switchTo().window(ite.next()));
					Thread.sleep(2000);
					String Mainwindow = ite1.next(); // window id of main CAT window
					String catWindow1 = ite1.next();
					Thread.sleep(30000);
			        window = Mainwindow;
					driver.switchTo().window(catWindow1); //Switch to course window
					Log.pass("switched to CAT window");
					Thread.sleep(5000);
					
				}catch(AssertionError  e)
				{
					//LogerData.info("Searching Module are not same");
				}
			}
		}
	
		catch(Exception e){  
	        Log.fail("Failed to edit course in MM");
	        e.printStackTrace();
	        throw e;                                        
	 } catch(AssertionError e)
	 {
	        Log.fail("Failed to edit course in MM");
	        e.printStackTrace();
	        throw e;
	
	 }
	}
	
	
	/**
	 * to be called after getSearchModule, will copy to edit the library/base version of the course
	 * @param course provide the base catalog ID
	 * @param type must be either "library" or "custom" for the course type
	 */
	static public void copyToEditLibrary(String course, String type) throws Exception
	{
		try
		{
			Log.startTestCase("refreshing library version");
			
			String expecetedcourse = driver.findElement(By.xpath(".//*[@id='module_" + course + "']/table[1]/tbody[2]/tr[1]/td[3]/div/div")).getAttribute("class");
			System.out.println("expecetedFluidxcourse:"+ expecetedcourse);
			
			clickIdentifierXpath(".//*[@id='module_" + course + "']/table[1]/tbody[2]/tr[1]/td[3]/div");
					
			Thread.sleep(5000);
					
			Log.info("expanded course");
			
			String CopyToEdit_Xpath="//div[div[div[text()='LRN Library']]]/div[2]/descendant::button[contains(text(),'Copy to Edit')]";
			String CopyToEdit_Xpath1="//div[div[div[text()='LRN QA Custom']]]/div[2]/descendant::button[contains(text(),'Copy to Edit')]";
			//String Libray_Xpath="//div[text()='LRN Library']";
			
			clickIdentifierXpath(".//*[@id='course_version_" + course + "']/td[1]/div[1]/div[1]/div[1]");
			Log.info("Click Libray link for fresh insert page.");
			
			Thread.sleep(5000);
			
			if (type.toLowerCase() == "library")
				clickIdentifierXpath(CopyToEdit_Xpath);
			else if (type == "custom")
				clickIdentifierXpath(CopyToEdit_Xpath1);
			
			Log.pass("Clicked Copy to edit");
			
			Thread.sleep(15000);
			
		}
		
		catch(Exception e){  
	        Log.fail("Failed to copy to edit library version in MM");
	        e.printStackTrace();
	        throw e;                                        
	 } catch(AssertionError e)
	 {
	        Log.fail("Failed to copy to edit library version in MM");
	        e.printStackTrace();
	        throw e;

	 }
		
	}
	
	/**
	 * To be called after saveAndExit or getSearchModule
	 * @param course the base catalog ID for the course (ex: ADP028)
	 */
	static public void publishCourse(String course) throws Exception
	{
		try
		{
			Log.startTestCase("start publishing course");
			
			String expecetedcourse = driver.findElement(By.xpath(".//*[@id='module_" + course + "']/table[1]/tbody[2]/tr[1]/td[3]/div/div")).getAttribute("class");
			System.out.println("expecetedFluidxcourse:"+ expecetedcourse);
			
			clickIdentifierXpath(".//*[@id='module_" + course + "']/table[1]/tbody[2]/tr[1]/td[3]/div");
					
			Thread.sleep(5000);
					
			Log.info("expanded course");
			
			clickIdentifierXpath(".//*[@id='course_version_" + course + "']/td[1]/div[1]/div[@class='entry draft selected']/div[1]/div[1]/div[2]/div[2]/span/span/button");
			
			Log.pass("clicked on publish course");
			
			clickIdentifierXpath("//div[@class='ft']/descendant::button[text()='Publish']");
			
			Log.pass("clicked on publish in pop-up");
			
			Thread.sleep(10000);
		}
		
		catch(Exception e){  
	        Log.fail("Failed to publish in MM");
	        e.printStackTrace();
	        throw e;                                        
	 } catch(AssertionError e)
	 {
	        Log.fail("Failed to publish in MM");
	        e.printStackTrace();
	        throw e;

	 }
	}
	
}