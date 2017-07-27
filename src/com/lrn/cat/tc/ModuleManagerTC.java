package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.lcec.pages.ModuleManager;

public class ModuleManagerTC extends ModuleManager
{
	@Test
	public void searchModule() throws Exception
	{
		//String course = "ADP028";
		getModuleManager();
		
		if (configProperties.getProperty("env").contains("qa7") || configProperties.getProperty("env").contains("prod"))
		{
			getSearchModule(configProperties.getProperty("searchModule"));
			copyToEditLibrary(configProperties.getProperty("searchModule"));
			editFluidxCourse(configProperties.getProperty("searchModule"));
		}
		
		else if (configProperties.getProperty("env").contains("qa4"))
		{
			getSearchModule(configProperties.getProperty("qa4Module"));
			copyToEditLibrary(configProperties.getProperty("qa4Module"));
			editFluidxCourse(configProperties.getProperty("qa4Module"));
		}
	}
	
	
}