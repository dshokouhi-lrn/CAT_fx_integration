package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.KCConifg;


public class KCConfigTC extends KCConifg {
	
    
	@Test
	void CATKCConifgTC () throws Exception
	{
		KCConfiguration("1", "", "Failed rety Attempts");
		
		knowledgecheckTab("yes","img desc","alt Text","Success Message","Failure Message","Cert Message","Question Tag", "page Comments");
		
		
	}
	
	
}
