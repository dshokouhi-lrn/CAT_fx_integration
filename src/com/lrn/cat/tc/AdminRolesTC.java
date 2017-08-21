package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.AdminRoles;


public class AdminRolesTC extends AdminRoles {

	@Test
	
	void adminrole() throws Exception
	{
		//Admin,creator,customizer,reviewer values :true/null
				
		Assignrole(configProperties.getProperty("Searchuser"));
		ManageAttributes();
		ManageMediaFolders();
		/*Importcustomizerversion("");*/
		
	}
}
	
