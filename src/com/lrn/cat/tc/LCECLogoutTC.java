package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.lcec.pages.LCECLogout;

public class LCECLogoutTC extends LCECLogout{
	
	@Test
	void CatLCECLogout() throws Exception
	{
		getLogOutLCEC();
	}

}
