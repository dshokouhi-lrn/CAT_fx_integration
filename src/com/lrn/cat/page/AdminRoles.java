package com.lrn.cat.page;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class AdminRoles extends CATAppCommon {
	
	/**
	 * Must be called after createCourse or editGetStarted
	 * @param Searchuser searching the user to assign the roles
	 * Assign roles, Manage attribute & Manage media Test cases 
	 */

	static public void Assignrole(String Searchuser) throws Exception
	{
		try{
			
			

			/************************** Assign Roles*********************/
			 
			Log.startTestCase("Started Test case for AssignRoles");
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			
			
			 //clickIdentifierXpath("//*[@id='mainSection']/div[2]/a[1]/span");
			 clickIdentifierXpath("//ul[@class='nav navbar-nav nav-pills pull-right']/li[2]/a");
			clickIdentifierXpath("//*[@id='assignRoles']/a/span");
			 typeTextByXpath("//*[@id='user_table_filter']/label/input",Searchuser);
			 	
			clickIdentifierXpath("//*[@id='user_table']/tbody/tr/td[7]/button");
				 				 
			String checkadminrole = driver.findElement(By.name("chk_Admin")).getAttribute("checked");
			System.out.println("User searched for adminrole :"+ checkadminrole);
			
			if(checkadminrole == null){
				clickIdentifierXpath("//ul[2][@class='userRoleInnerContent']/li[1]/input");
				 clickIdentifierXpath("//div[@class='userRoleContent']/input");
				Log.pass("admin roles assigned");
				}
				 else{
					 clickIdentifierXpath("//ul[2][@class='userRoleInnerContent']/li[1]/input");
					 clickIdentifierXpath("//div[@class='userRoleContent']/input");
					 Log.pass("admin roles unassigned");
				 }
			clickIdentifierXpath("//*[@id='user_table']/tbody/tr/td[7]/button");
			String checkCreatorrole = driver.findElement(By.name("chk_Creator")).getAttribute("checked");
			System.out.println("User searched for Creatorrole:"+ checkCreatorrole);
			
			if(checkCreatorrole == null){
				clickIdentifierXpath("//ul[3][@class='userRoleInnerContent']/li[1]/input");
				 clickIdentifierXpath("//div[@class='userRoleContent']/input");
				Log.pass("creator roles assigned");
				}
				 else{
					 clickIdentifierXpath("//ul[3][@class='userRoleInnerContent']/li[1]/input");
					 clickIdentifierXpath("//div[@class='userRoleContent']/input");
					 Log.pass("creator roles unassigned");
					 
				 }
			
			clickIdentifierXpath("//*[@id='user_table']/tbody/tr/td[7]/button");
			String checkCustomizerrole = driver.findElement(By.name("chk_Customizer")).getAttribute("checked");
			System.out.println("User searched for Customizerrole:"+ checkCustomizerrole);
			if(checkCustomizerrole == null){
				clickIdentifierXpath("//ul[4][@class='userRoleInnerContent']/li[1]/input");
				 clickIdentifierXpath("//div[@class='userRoleContent']/input");
				Log.pass("customizer roles assigned");
				}
				 else{
					 clickIdentifierXpath("//ul[4][@class='userRoleInnerContent']/li[1]/input");
					 clickIdentifierXpath("//div[@class='userRoleContent']/input");
					 Log.pass("Customizer roles unassigned");
				 }
			clickIdentifierXpath("//*[@id='user_table']/tbody/tr/td[7]/button");
			String checkReviewerrole = driver.findElement(By.name("chk_Reviewer")).getAttribute("checked");
			System.out.println("User searched for Reviewerrole:"+ checkReviewerrole);
			if(checkReviewerrole == null){
				clickIdentifierXpath("//ul[5][@class='userRoleInnerContent']/li[1]/input");
				 clickIdentifierXpath("//div[@class='userRoleContent']/input");
				Log.pass("Reviewer roles assigned");
				}
				 else{
					 clickIdentifierXpath("//ul[5][@class='userRoleInnerContent']/li[1]/input");
					 clickIdentifierXpath("//div[@class='userRoleContent']/input");
					 Log.pass("Reviewer roles unassigned"); 
				 }
			
			
					
						}
		
		
			 
		catch(Exception e){  
		       Log.fail("Failed to click on assign roles");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to  click on assign roles");
		       e.printStackTrace();
		       throw e;

		}
	}
	
	
	
	/************************** Manage Attributes*********************/
	
	static public void ManageAttributes() throws Exception
	{
		try{
			
			
			Log.startTestCase("Started Test case for ManageAttributes");
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			 clickIdentifierXpath("//ul[@class='nav navbar-nav nav-pills pull-right']/li[2]/a");
			 clickIdentifierXpath("//li[7][@id='manageAttributes']/a/span");
			 
			 Log.pass("Clicked on ManageAttributes");
			 //Log.info("Clicked on course languauges");
			 String lang = driver.findElement(By.xpath("//*[@id='attributesTableContainer']/div/table/tbody/tr[5]/td[1]")).getText();
			 				 System.out.println("attribute fro lang :"+ lang);
			 				
			 		if (lang.contains("arSA")){
			 					 		 					 
			 						Log.pass("Clicked on courselanguages successfully");
			 					}
			 					else
			 					{
			 						Log.fail("failed to find Course Languages");
			 					}

			 				 			
					
			Thread.sleep(3000);
			
			selectDropdownValueByIndex("attributeGroupDropDown",1);
			
			 String CourseTopic = driver.findElement(By.xpath("//*[@id='attributesTableContainer']/div/table/tbody/tr[5]/td[2]")).getText();
				 System.out.println("attribute for topic :"+ CourseTopic);
				 Thread.sleep(3000);	
				 //Log.info("Clicked on course topic");
		if (CourseTopic.contains("Conflicts Of Interest")){
					 		 					 
						Log.pass("clicked on Course topic  successfully");
					}
					else
					{
						Log.fail("failed to click course topic");
					}
		
		Thread.sleep(3000);
			selectDropdownValueByIndex("attributeGroupDropDown",2);
			
			 String coursetype = driver.findElement(By.xpath("//*[@id='attributesTableContainer']/div/table/tbody/tr[1]/td[2]")).getText();
				 System.out.println("attribute for coursetype :"+ coursetype);
				 Thread.sleep(3000);	 
				 //Log.info("Clicked on course type");	
		if (coursetype.contains("Custom")){
					 		 					 
						Log.pass("clicked on Course types  successfully");
					}
					else
					{
						Log.fail("failed to click Course types " );
					}
		Thread.sleep(3000);
			selectDropdownValueByIndex("attributeGroupDropDown",3);
			 String courseformat = driver.findElement(By.xpath("//*[@id='attributesTableContainer']/div/table/tbody/tr[3]/td[2]")).getText();
				
			 Thread.sleep(5000);
			 System.out.println("attribute for courseformat "+ courseformat);
			// Log.info("Clicked on course format");	 
				 
				
		if (courseformat.contains("Foundational")){
					 		 					 
						Log.pass("Clicked on course format successfully");
					}
					else
					{
						Log.fail("failed to click Course formats");
					}

		
			}
		
		catch(Exception e){  
		       Log.fail("Failed to click on Manage Attributes");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to click on Manage Attributes");
		       e.printStackTrace();
		       throw e;

		}
	}
	
	
	/**************************Manage MediaFolders********************/
	
	static public void ManageMediaFolders () throws Exception
	{
		try{
			
			
			Log.startTestCase("Started Test case for ManageMediaFolders");
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			 /*clickIdentifierXpath("//ul[@class='nav navbar-nav nav-pills pull-right']/li[2]/a");
			 clickIdentifierXpath("//*[@id='homeDropDown']/a");*/
			 clickIdentifierXpath("//ul[@class='nav navbar-nav nav-pills pull-right']/li[2]/a");
			 clickIdentifierXpath("//li[6][@id='manageAttributes']/a/span");
			 Log.pass("Clicked on ManageMedia successfully");
			 //clickIdentifierXpath("//*[@id='mediaTypeSelect']");
			 Log.info("Shared media test case started");
			 selectDropdownValueByIndex("mediaTypeSelect",1);
			 clickIdentifierXpath("//div[@aria-describedby='sharedMediaUploadDialog']/div[3]/div/button");
			 clickIdentifierXpath("//*[@id='toggleLeft']");
			 Thread.sleep(3000);
			 /*clickIdentifierXpath("//*[@id='addAFolder']/label");
			 //*[@id='note_pag']/ul/li/input
			//div[@aria-describedby='folderCreateDialogArea']/div[2]/div
			 typeTextByXpath("//div[@aria-describedby='folderCreateDialogArea']/div[2]/div/ul/li/input","People");
			 clickIdentifierXpath("//div[@aria-describedby='folderCreateDialogArea']/div[3]/div/button[1]/span");*/
			// typeTextById("note_pag","Automationimgs");
			
			
			 String Sharedimage = driver.findElement(By.xpath("//div[@class='imagelibrary-container clearfix']/div[1]/div/div/ul/li/a")).getText();
			 Thread.sleep(3000);
			 System.out.println("Media library Folder : "+ Sharedimage);
				 	 
			 if(Sharedimage.contains("Shared Images")){
				 
			 clickIdentifierXpath("//div[@class='imagelibrary-container clearfix']/div[1]/div/div/ul/li/i");
			 clickIdentifierXpath("//div[@aria-describedby='dialogArea']/div[3]/div/button");
			 Log.pass("Shared image folder is found");
			 }else
			 {
				 clickIdentifierXpath("//div[@aria-describedby='dialogArea']/div[3]/div/button");
				 Log.fail("Shared image folder is not found");
			 }
			 Log.pass("Shared Image test case successfully");
			 
			Log.info("Shared video test case started");
			 clickIdentifierXpath("//ul[@class='nav navbar-nav nav-pills pull-right']/li[2]/a");
			 clickIdentifierXpath("//li[6][@id='manageAttributes']/a/span");
			 selectDropdownValueByIndex("mediaTypeSelect",2);
			 clickIdentifierXpath("//div[@aria-describedby='sharedMediaUploadDialog']/div[3]/div/button");
			 clickIdentifierXpath("//*[@id='toggleLeft']");
			 Thread.sleep(3000);
			 /*clickIdentifierXpath("//*[@id='addAFolder']/label");
			 //*[@id='note_pag']/ul/li/input
			//div[@aria-describedby='folderCreateDialogArea']/div[2]/div
			 typeTextByXpath("//div[@aria-describedby='folderCreateDialogArea']/div[2]/div/ul/li/input","People");
			 clickIdentifierXpath("//div[@aria-describedby='folderCreateDialogArea']/div[3]/div/button[1]/span");*/
			// typeTextById("note_pag","Automationimgs");
			
			 
			 String SharedVideo= driver.findElement(By.xpath("//div[@class='imagelibrary-container clearfix']/div/div/div/ul/li/a")).getText();
			 Thread.sleep(3000);
			 System.out.println("Video library Folder : "+ SharedVideo);
			 
			 if(SharedVideo.contains("Shared Videos")){
				 
			 clickIdentifierXpath("//div[@class='imagelibrary-container clearfix']/div/div/div/ul/li/i");
			 
			 clickIdentifierXpath("//div[@aria-describedby='dialogArea']/div[3]/div/button");
			 Log.pass("Shared Video folder is found");
			 }else
			 {
				 clickIdentifierXpath("//div[@aria-describedby='dialogArea']/div[3]/div/button");
				 Log.fail("Shared Video folder is not found");
			 }
			 Log.pass("Shared video test case successfully");
			 
				
			
			Thread.sleep(3000);
			
					}
		
		catch(Exception e){  
		       Log.fail("Failed to Click on ManageMediaFolders");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to Click on ManageMediaFolders");
		       e.printStackTrace();
		       throw e;

		}
	}
	
	/*static public void 	Importcustomizerversion(String lessonName) throws Exception
	{
		try{
		
		Log.startTestCase("Started Test case for Admin Roles");
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			
			 String Adminvalue = getValueByXpath("html/body/div[3]/a[3]/p");
			 System.out.println("Message value of course:"+ Adminvalue);
			 
			 Thread.sleep(3000);
			 if (Adminvalue.contains("Admin Tools")){
				 clickIdentifierXpath("html/body/div[3]/a[3]");
				 
					Log.pass("Clicked on Admin roles");
				}
				else
				{
					Log.fail("failed to click on Admin roles: " + Adminvalue);
				}
			
			
			Log.startTestCase("Started Test case for Importcustomizerversion");
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			 clickIdentifierXpath("//ul[@class='nav navbar-nav nav-pills pull-right']/li[2]/a");
			 clickIdentifierXpath("//*[@id='homeDropDown']/a");
					
				 String Adminvalue = getValueByXpath("html/body/div[3]/a[3]/p");
				 System.out.println("Message value of course:"+ Adminvalue);
				 
				 Thread.sleep(3000);
				 if (Adminvalue.contains("Admin Tools")){
					 clickIdentifierXpath("html/body/div[3]/a[3]");
					 
						Log.pass("Clicked on Admin roles");
					}
					else
					{
						Log.fail("failed to click on Admin roles: " + Adminvalue);
					}

			 
			 clickIdentifierXpath("//*[@id='mainSection']/div[2]/a[4]/span");
				 	
				Log.info("Clicked on Importcustomizerversion");
			
			
			
			Log.pass("lesson created");
		}
		
		catch(Exception e){  
		       Log.fail("Failed to add lesson");
		       e.printStackTrace();
		       throw e;                                        
		} catch(AssertionError e)
		{
		       Log.fail("Failed to add lesson");
		       e.printStackTrace();
		       throw e;

		}
	}*/

}
