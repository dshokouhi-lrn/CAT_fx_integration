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
		getSearchModule(configProperties.getProperty("searchModule"));
		copyToEditLibrary(configProperties.getProperty("searchModule"));
		editFluidxCourse(configProperties.getProperty("searchModule"));
	}
	
	
}