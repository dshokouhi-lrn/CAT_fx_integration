package com.lrn.cat.tc;

import org.testng.annotations.Test;


import com.lrn.cat.page.LoginPage;


public class LoginTC extends LoginPage{

	@Test
	void CatLogicTC() throws Exception
	{

		login(configProperties.getProperty("username"), configProperties.getProperty("password"));
	}	
}