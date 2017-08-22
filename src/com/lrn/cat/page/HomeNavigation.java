package com.lrn.cat.page;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.lrn.cat.common.CATAppCommon;

import com.lrn.pp.utility.Log;

public class HomeNavigation extends CATAppCommon {
	public static String window = null;
	
	/**
	 * Must be called after createCourse or editGetStarted
	 * AboutCAT and UserGuide Test cases
	 */

	static public void aboutCAT() throws Exception
	{
		try{
			
			Log.startTestCase("Started Test case for UserGuide");
			
			/*JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");*/
			clickIdentifierXpath("//ul[@class='nav navbar-nav nav-pills pull-right']/li[2]/a");
			 clickIdentifierXpath("//a[@id='about']/span");
			 
			 Set<String> windows = driver.getWindowHandles();
			 System.out.println("count of windows open is "  +windows.size());
			 Iterator<String> itr = windows.iterator();
			
			 //patName will provide you parent window
			 String patName = itr.next();

			 //chldName will provide you child window
			 String chldName = itr.next();

			 //Switch to child window
			 int windowCount = windows.size();
			 System.out.println("count of windows open is "  +windowCount);
			 Thread.sleep(2000);
			 if (windowCount == 2)
				{
				 
				 driver.switchTo().window(chldName);
				 Thread.sleep(3000);
				 
					String Childwindow= driver.findElement(By.xpath("//div[2][@id='aboutContent']/h3")).getText();
					 Thread.sleep(3000);
					 System.out.println("Content for child windowis : "+ Childwindow);
					 
					 if(Childwindow.contains("Version: 1.0")){
						 
						driver.close();
						driver.switchTo().window(patName); 
						String getURL = driver.getCurrentUrl();
						 System.out.println("URL for main window is : "+ getURL);
						 
					 Log.pass("verified content on child window");
					 }else
					 {
						 
						 //To come back to parent window
						 driver.switchTo().window(patName);
						 String getURL1 = driver.getCurrentUrl();
						 System.out.println("URL for main window is : "+ getURL1);
						 Log.fail("Failed to verified  content on child  window ");
					 }

			 
				}
			 	else{
					driver.switchTo().window(patName); //Switch to main window
				
				Log.info("switched to main window");
				Thread.sleep(5000);
				
			 	}
				Log.pass("clicked on about Successfully");
				
						}
			 
		catch(Exception e){  
		       Log.fail("Failed to click on about ");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to click on about ");
		       e.printStackTrace();
		       throw e;

		}
	}
	static public void UserGuide() throws Exception
	{
		try{
			
			
			Log.startTestCase("Started Test case for AdminGuide");
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			 clickIdentifierXpath("//ul[@class='nav navbar-nav nav-pills pull-right']/li[2]/a");
			 clickIdentifierXpath("//a[@id='userguide']/span");
			 
			 Set<String> window = driver.getWindowHandles();
			 System.out.println("count of windows open is "  +window.size());
			 Iterator<String> itr = window.iterator();
			
			 //patName will provide you parent window
			 String parentName = itr.next();

			 //chldName will provide you child window
			 String childName = itr.next();
			 int windowCount = window.size();
			 System.out.println("count of windows open is "  +windowCount);
			 Thread.sleep(2000);
			 if (windowCount == 2)
			 {
				 
				 driver.switchTo().window(childName);
				 Thread.sleep(10000);
				 String getURL = driver.getCurrentUrl();
				
				 System.out.println("URL for userguide is : "+ getURL);
				 Thread.sleep(5000);
					if(getURL.contains("HTML5CATGuide.pdf"))
						 driver.close();
						 driver.switchTo().window(parentName);
						 String getURL1 = driver.getCurrentUrl();
						 System.out.println("URL for main window is : "+ getURL1);
						 clickIdentifierXpath("//ul[@class='nav navbar-nav nav-pills pull-right']/li[2]/a");
					//driver.switchTo().defaultContent();
					
						 Log.pass("verified URL on child window and UserGuide Loaded Successfully");
								 }
			 else{
				   Thread.sleep(3000);
                
					driver.switchTo().window(parentName); //Switch to main window
					String getURL2 = driver.getCurrentUrl();
					 System.out.println("URL for main window is : "+ getURL2);
				Log.info("switched to main window");
				Log.fail("Failed to load user guide and switched back to CAT Main Window");
				Thread.sleep(5000);
				
			 	}
															
			  Log.pass("Clicked on UserGuide Successfully");
			 
			}
		
		catch(Exception e){  
		       Log.fail("Failed to click on UserGuide ");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to click on UserGuide ");
		       e.printStackTrace();
		       throw e;

		}
	}
	
}