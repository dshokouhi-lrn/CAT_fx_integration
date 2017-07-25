package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.SelectableHotspot;



public class SelectableHotspotTC extends SelectableHotspot{
	
	
	@Test
	void SelectableHotspotPageTC() throws Exception{
		
		
		/* Layout: dir-ltr Image right,dir-rtl image left,dir-btt Imagetop,dir-ttb Imagebottom,dir-fsg fullimage
		Selection order: Random & Sequential
		imagePlacement:DesktopSamrtphones,Place*/
		SelectableHotspot obj=new SelectableHotspot();
		
		obj.selectableHotspotTemplate("dir-btt","selectable title","yes","content","Sequential","Fixed Location","DesktopSamrtphones",10,20,"HS ImageTitle","HS ImageText","yes","yes","yes","test","test","yammer","Bulletin Tilte","Content for bulletin");
		
	}

}
