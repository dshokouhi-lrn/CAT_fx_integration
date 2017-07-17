package com.lrn.cat.page;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class LogoutPage extends CATAppCommon{
	
	/**
	 * can be called at any time after logOn, course window is closed as well
	 */
	
	static public void logout() throws Exception
    {
           try
           {
                  Log.startTestCase("Verify CAT Logout ");
                  clickIdentifierXpath("//ul[@class='nav navbar-nav nav-pills pull-right']/li[2]/a");
                  clickIdentifierXpath(".//*[@id='logout']/span");
                 
                  Thread.sleep(300);
                  //     Assert.assertTrue(waitForElementPresentByLinkText("log out"));
                  Log.pass("Logged-out Successfully!!");
                  
                  //driver.close();
                  
                  //Log.info("closed browser window");
                  
                  //driver.quit();
                  
                  Log.pass("quit the driver");

           }
           catch(Exception e){  
                  Log.fail("Failed to logout of Application");
                  e.printStackTrace();
                  throw e;                                        
           } catch(AssertionError e)
           {
                  Log.fail("Failed to logout of Application");
                  e.printStackTrace();
                  throw e;

           }
    }
}

	
	


