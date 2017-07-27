package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.lcec.pages.LCECLogin;

public class LCECLoginTC extends LCECLogin {
	
	@Test
	public void login() throws Exception{

		getLoginLCEC(configProperties.getProperty("username"), configProperties.getProperty("password"));
	}
}