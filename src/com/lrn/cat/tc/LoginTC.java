package com.lrn.cat.tc;

import org.testng.annotations.Test;


import com.lrn.cat.page.LoginPage;


public class LoginTC extends LoginPage{

	@Test
	void CatLogicTC() throws Exception
	{
		//For QA
		login(configProperties.getProperty("catQA"), configProperties.getProperty("catQA"));
		
		//For Production
		//login(configProperties.getProperty("username"), configProperties.getProperty("prodPassword"));
	}	
}