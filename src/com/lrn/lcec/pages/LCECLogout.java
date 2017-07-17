package com.lrn.lcec.pages;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class LCECLogout extends CATAppCommon{
	
	public void getLogOutLCEC() throws Exception
	{	
		Log.startTestCase("start logging out of LCEC");
		String logoutLocater="//a[contains(text(),'Logout')]";
		clickIdentifierXpath(logoutLocater);
		Log.info("logout button clicked");
		driver.quit();
		Log.pass("logged out and closed window");
	}
}
