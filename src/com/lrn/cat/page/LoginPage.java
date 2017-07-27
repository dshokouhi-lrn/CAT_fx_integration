package com.lrn.cat.page;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class LoginPage extends CATAppCommon{
	
	/**
	 * must be called first, be sure to update the function based on the environment the test will run in
	 * @param userName supply the user name
	 * @param passWord supply the password
	 */
	
	static public void login(String userName,String passWord) throws Exception
    {
           try
           {
                  Log.startTestCase("Verify CAT Login ");
                  typeTextByName("userName", userName);
                  typeTextByName("passWord", passWord);
                  clickIdentifierXpath("//div[@class='loginBtnWrapper']/input");
                  softAssertEquals("//div[@class='iconsTopContainer']/a[1]/p/span", "Create a Course");
                  softA.assertAll();
                  Thread.sleep(3000);
                  //     Assert.assertTrue(waitForElementPresentByLinkText("log out"));
                  Log.pass("Logged-in to " + configProperties.getProperty("env") + " Successfully!!");

           }
           catch(Exception e){  
                  Log.fail("Failed to login into Application");
                  e.printStackTrace();
                  throw e;                                        
           } catch(AssertionError e){
                  Log.fail("Failed to login into Application");
                  e.printStackTrace();
                  throw e;

           }
    }


}
