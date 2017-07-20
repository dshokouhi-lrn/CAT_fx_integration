package com.lrn.cat.page;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class SearchCourse extends CATAppCommon{
	
	/**
	 * Can be called any time after logOn
	 * @param courseName provide the full catalog ID of the course you wish to interact
	 * @param courseContent must be one of the following: "Catalog ID" (can be left blank as this is default value in application), "Course Content", "Course Information", "Bulletins", "Tags" or "Videos"
	 * @param courseType must be one of the following: "All" (can be left blank as this is default value in application), "Library" or "Custom"
	 * 
	 */
	
	static public void searchcourse(String courseName, String courseContent, String courseType) throws Exception
    {
           try
           {
                  Log.startTestCase("Verify Search course ");
                  
                  navigateHome();
                  
                  typeTextById("courseName", courseName);
                  
                  if (courseContent != "")
                	  selectDropdownValueVisibleText("courseContent", courseContent);
                  
                  if (courseType != "")
                  	selectDropdownValueVisibleText("courseType", courseType);
                  
                  Thread.sleep(300);
                  clickIdentifierXpath("//form/div/div/div/input");
                 
                  Thread.sleep(300);

                  Log.pass("Searched course successfully");

           }
           catch(Exception e){  
                  Log.fail("Failed to search course");
                  e.printStackTrace();
                  throw e;                                        
           } catch(AssertionError e)
           {
                  Log.fail("Failed to search course");
                  e.printStackTrace();
                  throw e;

           }
    }
	
	/**
	 * Must be called after searchCourse with full catalog ID as it will click on the first delete icon it see's
	 * 
	 */
	
	static public void deleteCourse() throws Exception
	{
		try
		{
			Log.startTestCase("start deleting course");
			
			clickIdentifierXpath(".//*[@id='deleteACourse']/span/i");
			
			Thread.sleep(2000);
			
			clickIdentifierXpath("//*[@aria-describedby='dialogArea']/div[3]/div/button[1]");
			
			String publish = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			if (publish.contains("Delete Successfull"))
			{
				Log.pass("course deleted");
			}
			
			else
				Log.fail("Unable to delete course for reason: " + publish);
		}
		
		catch(Exception e){  
            Log.fail("Failed to delete course");
            e.printStackTrace();
            throw e;                                        
     } catch(AssertionError e)
     {
            Log.fail("Failed to delete course");
            e.printStackTrace();
            throw e;

     }
	}
}