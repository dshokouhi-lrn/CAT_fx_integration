package com.lrn.lcec.pages;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;
import com.relevantcodes.extentreports.LogStatus;

public class LCECLogin extends  CATAppCommon{
	private String userIDlocater="User";
    //user password locater 
    private String passwordLocater="Password";
    //user login button  locater
    private String loginLocater="//input[@name='SignOn']";
    //user after log in locater for validation 
  //  private String verifyLocater="//a[contains(text(),'Logout')]";
    String dueDate_xpath="//a[text()='Due:']";
    
    /**
     * Logs into LCEC
     * @param username the user name to log in
     * @param password the password to log in
     */
    public  void getLoginLCEC(String username,String password) throws Exception
    {
    	Log.startTestCase("start logging into LCEC");
    	
    	openURL(configProperties.getProperty("pptUrl"));

           typeTextById(userIDlocater,username);
           Log.info( "send user name in to user name text box");
           //LogerData.info("user name is :"+username);
           typeTextById(passwordLocater,password);
           //logger.log(LogStatus.INFO, "send password to password text box");
           //LogerData.info("password name is :"+password);
           clickIdentifierXpath(loginLocater);
           //logger.log(LogStatus.INFO, "log in browser successfully");
           logger1.log(LogStatus.PASS, "Locater user name is displaying");
    }


}