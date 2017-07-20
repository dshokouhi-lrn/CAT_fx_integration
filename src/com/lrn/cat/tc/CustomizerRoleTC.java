package com.lrn.cat.tc;

import org.testng.annotations.Test;

import com.lrn.cat.page.AddLesson;
import com.lrn.cat.page.CustomizerRole;
import com.lrn.cat.page.EditTextTemplate;
import com.lrn.cat.page.ExportToWord;
import com.lrn.cat.page.PreviewCourse;

public class CustomizerRoleTC extends CustomizerRole{
	
	@Test
	void CatCustomizerRole() throws Exception
	{
		customizerGetStarted("", "", "", "YES", "6", "");
		AddLesson.addLesson("customizer lesson");
		customizerAddPage("text");
		EditTextTemplate.editTextTemplate("dir-ltr", "customizer test", "yes", "customizer content", "yes", "yes", "yes", "customizer test", "customizer test");
		//PreviewCourse.previewCourse();
		//ExportToWord.exportToWordCourse(configProperties.getProperty("searchModule"), "no", "no", "yes", "yes", "no", "yes", "no");
		saveAndExit();
	}

}
