package com.lrn.cat.page;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.lrn.cat.common.CATAppCommon;
import com.lrn.pp.utility.Log;

public class SelectableHotspot extends CATAppCommon {
	
		 public void selectableHotspotTemplate(String layout, String pageTitle, String showTitle, String pageContent,String selectionOrder,String RevealBox,String imagePlacement, int placementX, int placementY,String siTitle,String siText,String desktopImage, String mobileImage, String audioFile, String imageDesc, String altText,String selectbulletintype, String bulletinTitle,String bulletinText) throws Exception{
						
			 
			 String glPlacementX=String.valueOf(placementX);
			 String glPlacementY=String.valueOf(placementY);
			try
			{
				Date d = new Date();
				
				Log.startTestCase("Adding Selectable Hotspot Template");
				
				Thread.sleep(1000);
				
				
				if (layout != "")
					clickIdentifierByID("layout-" + layout + "-main");
				
				if (pageTitle != "")
					typeTextById("pageTitle", pageTitle + " " + d.toString());
				
				if (showTitle == "no")
				{
					uncheckCheckBox("//*[@id='mz-showTitle-2']");
					Log.info("unchecked show title");
				}
				
				if (showTitle == "yes")
				{
					checkCheckBox("//*[@id='mz-showTitle-2']");
					Log.info("checked show title");
				}
				
				if (pageContent != "")
					typeTextById("ckeditorContentrevealHotspot_content", pageContent + " " + d.toString());
				//*[@id='ckeditorContentrevealHotspot_content']
				
				/*if (audioFile != "")
				{
					
					clickIdentifierXpath("//*[@id='page_uploadAudio']/img");
					uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resou
					rce\\audio\\l1p01_1.mp3");
					Thread.sleep(3000);
					Log.info("uploaded audio");
				}*/
				
				if (desktopImage != "")
				{
					String image = getRandomImage();
					clickIdentifierXpath(".//div[@id='desktop-image-main-div-hotspot_pageImage']/img");
					WebElement file = driver.findElement(By.xpath(".//div[@id='desktop-image-main-div-hotspot_pageImage']/input[2]"));
					file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
					//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
					Thread.sleep(50000);
					Log.info("uploaded desktop image");
				}
				
				if (mobileImage != "")
				{
					String image = getRandomImage();
					clickIdentifierXpath(".//div[@id='mobile-image-main-div-hotspot_pageImage']/img");
					WebElement file = driver.findElement(By.xpath(".//div[@id='mobile-image-main-div-hotspot_pageImage']/input[2]"));
					file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
					//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
					Thread.sleep(50000);
					Log.info("uploaded mobile image");
				}
				
				if (imageDesc != "")
					//typeTextByXpath(".//*[@id='widgetImageDescription-sidebar_image']",imageDesc + " " + d.toString());
					typeTextById("widgetImageDescription-hotspot_pageImage", imageDesc + " " + d.toString());
				
				if (altText != "")
					
					//typeTextByXpath(".//*[@id='widgetAltTextBackgroundImage-sidebar_image']",altText + " " + d.toString());
					typeTextById("widgetAltTextBackgroundImage-hotspot_pageImage", altText + " " + d.toString());
				
		
			String CISettings =driver.findElement(By.xpath(".//div[@id='selection-order-option-div']/div/div[2]")).getText();
			System.out.println("Selection order default setting is "  + CISettings); 
			
			String RBsettings=driver.findElement(By.xpath("//div[@class='reveal-box-fixed']")).getText();
			System.out.println("Reveal Box default setting is" + RBsettings);
			
			
						
			if (selectionOrder=="Random")
			{
				Log.info("selectionOrder is selected as Random ");
				
				if (RevealBox=="Fixed Location")
				{
				
				Log.info("reveal box is selected as Fixed Location ");
				
				String normalImage = getRandomHotSpotImage();
				clickIdentifierXpath(".//*[@id='hotspot-normal-image-main-div-hotspot_image']/img");
				WebElement file = driver.findElement(By.xpath(".//*[@id='hotspot-normal-image-main-div-hotspot_image']/input[2]"));
				file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + normalImage + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + normalImage + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded normal image");
				
				String hoverImage = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-hover-image-main-div-hotspot_image']/img");
				WebElement file1 = driver.findElement(By.xpath(".//div[@id='hotspot-hover-image-main-div-hotspot_image']/input[2]"));
				file1.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + hoverImage + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + hoverImage + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded hover image");
				
				Thread.sleep(3000);
				
				String activeImage = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-active-image-main-div-hotspot_image']/img");
				WebElement file2 = driver.findElement(By.xpath(".//div[@id='hotspot-active-image-main-div-hotspot_image']/input[2]"));
				file2.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + activeImage + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + activeImage + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded close image");
				
				Thread.sleep(3000);
				
				String closeImage = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-close-image-main-div-hotspot_image']/img");
				WebElement file3 = driver.findElement(By.xpath(".//div[@id='hotspot-close-image-main-div-hotspot_image']/input[2]"));
				file3.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + closeImage + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + closeImage + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded closehover image");
				
				Thread.sleep(3000);
				
				String completeImage = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-complete-image-main-div-hotspot_image']/img");
				WebElement file4 = driver.findElement(By.xpath(".//div[@id='hotspot-complete-image-main-div-hotspot_image']/input[2]"));
				file4.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + completeImage + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + completeImage + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded complete image");
				
				
				//typeTextByXpath(".//*[@id='ckeditorContentSidebarTitle']",sbTitle + " " + d.toString());
				typeTextById("ckeditorContentHotspotTitle0", siTitle + " " + d.toString());
				//typeTextByXpath(".//*[@id='ckeditorContentSidebarText']",pageContent + " " + d.toString());
				typeTextById("ckeditorContentHotspotText0", siText + " " + d.toString());
				/*if (audioFile != "")
				{
					
					clickIdentifierXpath(".//*[@id='widget1_uploadAudio']/img");
					uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\audio\\l1p01_1.mp3");
					Thread.sleep(3000);
					Log.info("uploaded Hotspot1 audio");
				}*/
				
				
				
				if(imagePlacement =="DesktopSamrtphones")
				{	
				/*desktop or tablets*/
				
				//typeTextByXpath(".//*[@id='hotSpotDesktopPositionX0']",placementX);
					placementX=1+placementX;
					String PlacementX=String.valueOf(placementX);
					typeTextById("hotSpotDesktopPositionX0", PlacementX);
				//typeTextByXpath(".//*[@id='hotSpotDesktopPositionY0']",placementY);
					placementY=1+placementY;
					String PlacementY=String.valueOf(placementY);
					typeTextById("hotSpotDesktopPositionY0", PlacementY);
				
				/*Smart phones*/
				
				//typeTextByXpath(".//*[@id='hotSpotSmartphonePositionX0']",placementX);
				typeTextById("hotSpotSmartphonePositionX0", glPlacementX);
				//typeTextByXpath(".//*[@id='hotSpotSmartphonePositionY0']",placementY);
				typeTextById("hotSpotSmartphonePositionY0", glPlacementY);
				
				/*driver.findElement(By.xpath(".//*[@id='hotSpotDesktopPositionX0']")).clear();
				driver.findElement(By.xpath(".//*[@id='hotSpotDesktopPositionX0']")).sendKeys("12");*/
				}
				else{
				/*--POPUP desktop or tablets Placement--*/
				
				clickIdentifierXpath(".//*[@id='placeDesktopHotSpot0']");

				typeTextById("popUpX", glPlacementX);
				
				typeTextById("popUpY", glPlacementY);
				
				//clickIdentifierXpath(".//*[@id='hotSpotPoint']"); Placement in popup image
				clickIdentifierXpath(".//*[@id='hotspotPopUpApplyButton']");
				//clickIdentifierXpath(".//*[@id='hotspotPopUpResetButton']"); //reset button in popup
				clickIdentifierXpath(".//*[@id='hotspotPopUpSaveButton']");
				
				//clickIdentifierXpath(".//*[@id='hotspotPopUpCancelButton']"); //Cancel popup 
				
				/*--POPUP SmartPhone Placement--*/
				
				clickIdentifierXpath(".//*[@id='placeSmartphoneHotSpot0']");

				typeTextById("popUpX", glPlacementX);
				
				typeTextById("popUpY", glPlacementY);
				
				clickIdentifierXpath(".//*[@id='hotspotPopUpApplyButton']");
				clickIdentifierXpath(".//*[@id='hotspotPopUpSaveButton']");
				
				}
				
				//uplaod active image
				String activeImage1 = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-content-active-image-main-div-revealHotspot_hotspot0']/img");
				WebElement file5 = driver.findElement(By.xpath(".//div[@id='hotspot-content-active-image-main-div-revealHotspot_hotspot0']/input"));
				file5.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + activeImage1 + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + activeImage1 + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded Active image");
				
				String normalImage1 = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-normal-image-main-div-revealHotspot_hotspot0']/img");
				WebElement file6 = driver.findElement(By.xpath(".//div[@id='hotspot-normal-image-main-div-revealHotspot_hotspot0']/input[2]"));
				file6.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + normalImage1 + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + normalImage1 + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded normal image");
				
				String hoverImage1 = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-hover-image-main-div-revealHotspot_hotspot0']/img");
				WebElement file7 = driver.findElement(By.xpath(".//div[@id='hotspot-hover-image-main-div-revealHotspot_hotspot0']/input[2]"));
				file7.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + hoverImage1 + ".jpg");
		        //uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + hoverImage1 + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded hover image");
				
				String closeImage1 = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-active-image-main-div-revealHotspot_hotspot0']/img");
				WebElement file8 = driver.findElement(By.xpath(".//div[@id='hotspot-active-image-main-div-revealHotspot_hotspot0']/input[2]"));
				file8.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + closeImage1 + ".jpg");
		        //uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + closeImage1 + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded close image");
				
				String closeHoverImage = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-close-image-main-div-revealHotspot_hotspot0']/img");
				WebElement file9 = driver.findElement(By.xpath(".//div[@id='hotspot-close-image-main-div-revealHotspot_hotspot0']/input[2]"));
				file9.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + closeHoverImage + ".jpg");
		        //uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + closeHoverImage + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded closehover image");
				
				String completeImage1 = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-complete-image-main-div-revealHotspot_hotspot0']/img");
				WebElement file10 = driver.findElement(By.xpath(".//div[@id='hotspot-complete-image-main-div-revealHotspot_hotspot0']1/input[2]"));
				file10.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + completeImage1 + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + completeImage1 + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded complete image");
				
				/* to click on + to add New panel */
				clickIdentifierXpath(".//*[@id='revealHotspot_hotspot']/div[2]/div[1]");
				String ImagePanel =driver.findElement(By.xpath(".//*[@id='fieldset-panel0']/legend/label")).getText();
				System.out.println("ImagePanel default Name ="  + ImagePanel); 
				
				/* Image panel2*/
				
				
				typeTextById("ckeditorContentHotspotTitle1", siTitle + " " + d.toString());
				//typeTextByXpath(".//*[@id='ckeditorContentSidebarText']",pageContent + " " + d.toString());
				typeTextById("ckeditorContentHotspotText1", siText + " " + d.toString());
				/*if (audioFile != "")
				{
					
					clickIdentifierXpath(".//*[@id='widget1_uploadAudio']/img");
					uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\audio\\l1p01_1.mp3");
					Thread.sleep(3000);
					Log.info("uploaded Hotspot1 audio");
				}*/
				
				
				
				if(imagePlacement =="DesktopSamrtphones")
				{	
				/*desktop or tablets*/
				
				//typeTextByXpath(".//*[@id='hotSpotDesktopPositionX0']",placementX);
				typeTextById("hotSpotDesktopPositionX1", glPlacementX);
				//typeTextByXpath(".//*[@id='hotSpotDesktopPositionY0']",placementY);
				typeTextById("hotSpotDesktopPositionY1", glPlacementY);
				
				/*Smart phones*/
				
				//typeTextByXpath(".//*[@id='hotSpotSmartphonePositionX0']",placementX);
				typeTextById("hotSpotSmartphonePositionX1", glPlacementX);
				//typeTextByXpath(".//*[@id='hotSpotSmartphonePositionY0']",placementY);
				typeTextById("hotSpotSmartphonePositionY1", glPlacementY);
				
				/*driver.findElement(By.xpath(".//*[@id='hotSpotDesktopPositionX0']")).clear();
				driver.findElement(By.xpath(".//*[@id='hotSpotDesktopPositionX0']")).sendKeys("12");*/
				}
				else{
				/*--POPUP desktop or tablets Placement--*/
				
				clickIdentifierXpath(".//*[@id='placeDesktopHotSpot1']");

				typeTextById("popUpX", glPlacementX);
				
				typeTextById("popUpY", glPlacementY);
				
				//clickIdentifierXpath(".//*[@id='hotSpotPoint']"); Placement in popup image
				clickIdentifierXpath(".//*[@id='hotspotPopUpApplyButton']");
				//clickIdentifierXpath(".//*[@id='hotspotPopUpResetButton']"); //reset button in popup
				clickIdentifierXpath(".//*[@id='hotspotPopUpSaveButton']");
				
				//clickIdentifierXpath(".//*[@id='hotspotPopUpCancelButton']"); //Cancel popup 
				
				/*--POPUP SmartPhone Placement--*/
				
				clickIdentifierXpath(".//*[@id='placeSmartphoneHotSpot1']");

				typeTextById("popUpX", glPlacementX);
				
				typeTextById("popUpY", glPlacementY);
				
				clickIdentifierXpath(".//*[@id='hotspotPopUpApplyButton']");
				clickIdentifierXpath(".//*[@id='hotspotPopUpSaveButton']");
				
				}
				
				String activeImage2 = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-content-active-image-main-div-revealHotspot_hotspot1']/img");
				WebElement file11 = driver.findElement(By.xpath(".//div[@id='hotspot-content-active-image-main-div-revealHotspot_hotspot1']/input"));
				file11.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + activeImage2 + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + activeImage2 + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded Active image");
				
				String normalImage2 = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-normal-image-main-div-revealHotspot_hotspot1']/img");
				WebElement file12 = driver.findElement(By.xpath(".//div[@id='hotspot-normal-image-main-div-revealHotspot_hotspot1']/input[2]"));
				file12.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + normalImage2 + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + normalImage2 + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded normal image");
				
				String hoverImage2 = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-hover-image-main-div-revealHotspot_hotspot1']/img");
				WebElement file13 = driver.findElement(By.xpath(".//div[@id='hotspot-hover-image-main-div-revealHotspot_hotspot1']/input[2]"));
				file13.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + hoverImage2 + ".jpg");
		        //uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + hoverImage2 + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded hover image");
				
				String closeImage2 = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-active-image-main-div-revealHotspot_hotspot1']/img");
				WebElement file14 = driver.findElement(By.xpath(".//div[@id='hotspot-active-image-main-div-revealHotspot_hotspot1']/input[2]"));
				file14.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + closeImage2 + ".jpg");
		        //uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + closeImage2 + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded close image");
				
				String closeHoverImage1 = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-close-image-main-div-revealHotspot_hotspot1']/img");
				WebElement file15 = driver.findElement(By.xpath(".//div[@id='hotspot-close-image-main-div-revealHotspot_hotspot1']/input[2]"));
				file15.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + closeHoverImage1 + ".jpg");
		        //uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + closeHoverImage1 + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded closehover image");
				
				String completeImage2 = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-complete-image-main-div-revealHotspot_hotspot1']/img");
				WebElement file16 = driver.findElement(By.xpath(".//div[@id='hotspot-complete-image-main-div-revealHotspot_hotspot1']/input[2]"));
				file16.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + completeImage2 + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + completeImage2 + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded complete image");
				
				/* to click on + to add New panel */
				clickIdentifierXpath(".//*[@id='revealHotspot_hotspot']/div[2]/div[1]");
				String ImagePanel1 =driver.findElement(By.xpath(".//*[@id='fieldset-panel0']/legend/label")).getText();
				System.out.println("ImagePanel default Name ="  + ImagePanel1); 
				
				/* Image panel2*/
				
				
				typeTextById("ckeditorContentHotspotTitle1", siTitle + " " + d.toString());
				//typeTextByXpath(".//*[@id='ckeditorContentSidebarText']",pageContent + " " + d.toString());
				typeTextById("ckeditorContentHotspotText1", siText + " " + d.toString());
				/*if (audioFile != "")
				{
					
					clickIdentifierXpath(".//*[@id='widget1_uploadAudio']/img");
					uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\audio\\l1p01_1.mp3");
					Thread.sleep(3000);
					Log.info("uploaded Hotspot1 audio");
				}*/
				
				
				
				if(imagePlacement =="DesktopSamrtphones")
				{	
				/*desktop or tablets*/
					placementX=3+placementX;
					String PlacementX=String.valueOf(placementX);
				//typeTextByXpath(".//*[@id='hotSpotDesktopPositionX0']",placementX);
				typeTextById("hotSpotDesktopPositionX1", PlacementX);
				//typeTextByXpath(".//*[@id='hotSpotDesktopPositionY0']",placementY);
				placementX=3+placementX;
				String PlacementY=String.valueOf(placementY);
				typeTextById("hotSpotDesktopPositionY1", PlacementY);
				
				/*Smart phones*/
				
				//typeTextByXpath(".//*[@id='hotSpotSmartphonePositionX0']",placementX);
				typeTextById("hotSpotSmartphonePositionX1", PlacementX);
				//typeTextByXpath(".//*[@id='hotSpotSmartphonePositionY0']",placementY);
				typeTextById("hotSpotSmartphonePositionY1", PlacementY);
				
				/*driver.findElement(By.xpath(".//*[@id='hotSpotDesktopPositionX0']")).clear();
				driver.findElement(By.xpath(".//*[@id='hotSpotDesktopPositionX0']")).sendKeys("12");*/
				}
				else{
				/*--POPUP desktop or tablets Placement--*/
				
				clickIdentifierXpath(".//*[@id='placeDesktopHotSpot1']");

				typeTextById("popUpX", glPlacementX);
				
				typeTextById("popUpY", glPlacementY);
				
				//clickIdentifierXpath(".//*[@id='hotSpotPoint']"); Placement in popup image
				clickIdentifierXpath(".//*[@id='hotspotPopUpApplyButton']");
				//clickIdentifierXpath(".//*[@id='hotspotPopUpResetButton']"); //reset button in popup
				clickIdentifierXpath(".//*[@id='hotspotPopUpSaveButton']");
				
				//clickIdentifierXpath(".//*[@id='hotspotPopUpCancelButton']"); //Cancel popup 
				
				/*--POPUP SmartPhone Placement--*/
				
				clickIdentifierXpath(".//*[@id='placeSmartphoneHotSpot1']");

				typeTextById("popUpX", glPlacementX);
				
				typeTextById("popUpY", glPlacementY);
				
				clickIdentifierXpath(".//*[@id='hotspotPopUpApplyButton']");
				clickIdentifierXpath(".//*[@id='hotspotPopUpSaveButton']");
				
				}
				
				String activeImage3 = getRandomHotSpotImage();
				//clickIdentifierXpath(".//div[@id='hotspot-content-active-image-main-div-revealHotspot_hotspot1']/img");
				WebElement file17 = driver.findElement(By.xpath(".//div[@id='hotspot-content-active-image-main-div-revealHotspot_hotspot1']/input"));
				file17.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + activeImage3 + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + activeImage3 + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded Active image");//
				
				String normalImage3 = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-normal-image-main-div-revealHotspot_hotspot1']/img");
				WebElement file18 = driver.findElement(By.xpath(".//div[@id='hotspot-normal-image-main-div-revealHotspot_hotspot1']/input[2]"));
				file18.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + normalImage3 + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + normalImage3 + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded normal image");
				
				String hoverImage3 = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-hover-image-main-div-revealHotspot_hotspot1']/img");
				WebElement file19 = driver.findElement(By.xpath(".//div[@id='hotspot-hover-image-main-div-revealHotspot_hotspot1']/input[2]"));
				file19.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + hoverImage3 + ".jpg");
		       // uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + hoverImage3 + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded hover image");
				
				String closeImage3 = getRandomHotSpotImage();
				//clickIdentifierXpath(".//div[@id='hotspot-active-image-main-div-revealHotspot_hotspot1']/img");
				WebElement file20 = driver.findElement(By.xpath(".//div[@id='hotspot-active-image-main-div-revealHotspot_hotspot1']/input[2]"));
				file20.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + closeImage3 + ".jpg");
		        //uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + closeImage3 + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded close image");//
				
				String closeHoverImage3 = getRandomHotSpotImage();
				//clickIdentifierXpath(".//div[@id='hotspot-close-image-main-div-revealHotspot_hotspot1']/img");
				WebElement file21 = driver.findElement(By.xpath(".//div[@id='hotspot-close-image-main-div-revealHotspot_hotspot1']/input[2]"));
				file21.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + closeHoverImage3 + ".jpg");
		        //uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + closeHoverImage3 + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded closehover image");//
				
				String completeImage3 = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-complete-image-main-div-revealHotspot_hotspot1']/img");
				WebElement file22 = driver.findElement(By.xpath(".//div[@id='hotspot-complete-image-main-div-revealHotspot_hotspot1']/input[2]"));
				file22.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + completeImage3 + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + completeImage3 + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded complete image");
				
				


					
			}	
				
			
				
	
			
			else if(RevealBox=="Customizable Location")
			{
				
				
				
				clickIdentifierXpath("//input[@id='customizableLocation']");
				
				Log.info("reveal box is selected as Customizable Location ");
				
				String normalImage = getRandomHotSpotImage();
				clickIdentifierXpath(".//*[@id='hotspot-normal-image-main-div-hotspot_image']/img");
				WebElement file = driver.findElement(By.xpath(".//*[@id='hotspot-normal-image-main-div-hotspot_image']/input[2]"));
				file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + normalImage + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + normalImage + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded normal image");
				
				String hoverImage = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-hover-image-main-div-hotspot_image']/img");
				WebElement file1 = driver.findElement(By.xpath(".//div[@id='hotspot-hover-image-main-div-hotspot_image']/input[2]"));
				file1.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + hoverImage + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + hoverImage + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded hover image");
				
				String completeImage = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-complete-image-main-div-hotspot_image']/img");
				WebElement file2 = driver.findElement(By.xpath(".//div[@id='hotspot-complete-image-main-div-hotspot_image']/input[2]"));
				file2.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + completeImage + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + completeImage + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded complete image");
				
				
				
				
				//typeTextByXpath(".//*[@id='ckeditorContentSidebarTitle']",sbTitle + " " + d.toString());
				typeTextById("ckeditorContentHotspotTitle0", siTitle + " " + d.toString());
				//typeTextByXpath(".//*[@id='ckeditorContentSidebarText']",pageContent + " " + d.toString());
				typeTextById("ckeditorContentHotspotText0", siText + " " + d.toString());
				/*if (audioFile != "")
				{
					
					clickIdentifierXpath(".//*[@id='widget1_uploadAudio']/img");
					uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\audio\\l1p01_1.mp3");
					Thread.sleep(3000);
					Log.info("uploaded Hotspot1 audio");
				}*/
				
				
				
				if(imagePlacement =="DesktopSamrtphones")
				{	
				/*desktop or tablets*/
					placementX=4+placementX;
					String PlacementX=String.valueOf(placementX);
				
				//typeTextByXpath(".//*[@id='hotSpotDesktopPositionX0']",placementX);
				typeTextById("hotSpotDesktopPositionX0", PlacementX);
				//typeTextByXpath(".//*[@id='hotSpotDesktopPositionY0']",placementY);
					placementY=5+placementX;
					String PlacementY=String.valueOf(placementX);
				typeTextById("hotSpotDesktopPositionY0", PlacementY);
				
				/*Smart phones*/
				
				//typeTextByXpath(".//*[@id='hotSpotSmartphonePositionX0']",placementX);
				typeTextById("hotSpotSmartphonePositionX0", PlacementX);
				//typeTextByXpath(".//*[@id='hotSpotSmartphonePositionY0']",placementY);
				typeTextById("hotSpotSmartphonePositionY0", PlacementY);
				
				/*driver.findElement(By.xpath(".//*[@id='hotSpotDesktopPositionX0']")).clear();
				driver.findElement(By.xpath(".//*[@id='hotSpotDesktopPositionX0']")).sendKeys("12");*/
				}
				else{
				/*--POPUP desktop or tablets Placement--*/
				
				clickIdentifierXpath(".//*[@id='placeDesktopHotSpot0']");

				typeTextById("popUpX", glPlacementX);
				
				typeTextById("popUpY", glPlacementY);
				
				//clickIdentifierXpath(".//*[@id='hotSpotPoint']"); Placement in popup image
				clickIdentifierXpath(".//*[@id='hotspotPopUpApplyButton']");
				//clickIdentifierXpath(".//*[@id='hotspotPopUpResetButton']"); //reset button in popup
				clickIdentifierXpath(".//*[@id='hotspotPopUpSaveButton']");
				
				//clickIdentifierXpath(".//*[@id='hotspotPopUpCancelButton']"); //Cancel popup 
				
				/*--POPUP SmartPhone Placement--*/
				
				clickIdentifierXpath(".//*[@id='placeSmartphoneHotSpot0']");

				typeTextById("popUpX", glPlacementX);
				
				typeTextById("popUpY", glPlacementY);
				
				clickIdentifierXpath(".//*[@id='hotspotPopUpApplyButton']");
				clickIdentifierXpath(".//*[@id='hotspotPopUpSaveButton']");
				
				}
				
			
				String normalImage1 = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-normal-image-main-div-revealHotspot_hotspot0']/img");
				WebElement file3 = driver.findElement(By.xpath(".//div[@id='hotspot-normal-image-main-div-revealHotspot_hotspot0']/input[2]"));
				file3.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + normalImage1 + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + normalImage1 + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded normal image");
				
				String hoverImage1 = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-hover-image-main-div-revealHotspot_hotspot0']/img");
				WebElement file4 = driver.findElement(By.xpath(".//div[@id='hotspot-hover-image-main-div-revealHotspot_hotspot0']/input[2]"));
				file4.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + hoverImage1 + ".jpg");
		        //uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + hoverImage1 + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded hover image");
				
				String completeImage1 = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-complete-image-main-div-revealHotspot_hotspot0']/img");
				WebElement file5 = driver.findElement(By.xpath(".//div[@id='hotspot-complete-image-main-div-revealHotspot_hotspot0']/input[2]"));
				file5.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + completeImage1 + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + completeImage1 + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded complete image");
				
				/* to click on + to add New panel */
				clickIdentifierXpath(".//*[@id='revealHotspot_hotspot']/div[2]/div[1]");
				String ImagePanel =driver.findElement(By.xpath(".//*[@id='fieldset-panel0']/legend/label")).getText();
				System.out.println("ImagePanel default Name ="  + ImagePanel); 
				
				/* Image panel2*/
				
				
				typeTextById("ckeditorContentHotspotTitle1", siTitle + " " + d.toString());
				//typeTextByXpath(".//*[@id='ckeditorContentSidebarText']",pageContent + " " + d.toString());
				typeTextById("ckeditorContentHotspotText1", siText + " " + d.toString());
				/*if (audioFile != "")
				{
					
					clickIdentifierXpath(".//*[@id='widget1_uploadAudio']/img");
					uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\audio\\l1p01_1.mp3");
					Thread.sleep(3000);
					Log.info("uploaded Hotspot1 audio");
				}*/
				
				
				
				if(imagePlacement =="DesktopSamrtphones")
				{	
				/*desktop or tablets*/
					placementX=6+placementX;
					String PlacementX=String.valueOf(placementX);
				//typeTextByXpath(".//*[@id='hotSpotDesktopPositionX0']",placementX);
				typeTextById("hotSpotDesktopPositionX1", PlacementX);
				//typeTextByXpath(".//*[@id='hotSpotDesktopPositionY0']",placementY);
				
				placementY=4+placementY;
				String PlacementY=String.valueOf(placementY);
				typeTextById("hotSpotDesktopPositionY1", PlacementY);
				
				/*Smart phones*/
				
				//typeTextByXpath(".//*[@id='hotSpotSmartphonePositionX0']",placementX);
				typeTextById("hotSpotSmartphonePositionX1", PlacementX);
				//typeTextByXpath(".//*[@id='hotSpotSmartphonePositionY0']",placementY);
				typeTextById("hotSpotSmartphonePositionY1", PlacementY);
				
				/*driver.findElement(By.xpath(".//*[@id='hotSpotDesktopPositionX0']")).clear();
				driver.findElement(By.xpath(".//*[@id='hotSpotDesktopPositionX0']")).sendKeys("12");*/
				}
				else{
				/*--POPUP desktop or tablets Placement--*/
				
				clickIdentifierXpath(".//*[@id='placeDesktopHotSpot1']");

				typeTextById("popUpX", glPlacementX);
				
				typeTextById("popUpY", glPlacementY);
				
				//clickIdentifierXpath(".//*[@id='hotSpotPoint']"); Placement in popup image
				clickIdentifierXpath(".//*[@id='hotspotPopUpApplyButton']");
				//clickIdentifierXpath(".//*[@id='hotspotPopUpResetButton']"); //reset button in popup
				clickIdentifierXpath(".//*[@id='hotspotPopUpSaveButton']");
				
				//clickIdentifierXpath(".//*[@id='hotspotPopUpCancelButton']"); //Cancel popup 
				
				/*--POPUP SmartPhone Placement--*/
				
				clickIdentifierXpath(".//*[@id='placeSmartphoneHotSpot1']");

				typeTextById("popUpX", glPlacementX);
				
				typeTextById("popUpY", glPlacementY);
				
				clickIdentifierXpath(".//*[@id='hotspotPopUpApplyButton']");
				clickIdentifierXpath(".//*[@id='hotspotPopUpSaveButton']");
				
				}
				
				String activeImage2 = getRandomHotSpotImage();
				//clickIdentifierXpath(".//div[@id='hotspot-content-active-image-main-div-revealHotspot_hotspot1']/img");
				WebElement file7 = driver.findElement(By.xpath(".//div[@id='hotspot-content-active-image-main-div-revealHotspot_hotspot1']/input"));
				file7.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + activeImage2 + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + activeImage2 + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded Active image");//
				
				String normalImage2 = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-normal-image-main-div-revealHotspot_hotspot1']/img");
				WebElement file8 = driver.findElement(By.xpath(".//div[@id='hotspot-normal-image-main-div-revealHotspot_hotspot1']/input[2]"));
				file8.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + normalImage2 + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + normalImage2 + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded normal image");
				
				String hoverImage2 = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-hover-image-main-div-revealHotspot_hotspot1']/img");
				WebElement file9 = driver.findElement(By.xpath(".//div[@id='hotspot-hover-image-main-div-revealHotspot_hotspot1']/input[2]"));
				file9.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + hoverImage2 + ".jpg");
		        //uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + hoverImage2 + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded hover image");
				
				String closeImage2 = getRandomHotSpotImage();
				//clickIdentifierXpath(".//div[@id='hotspot-active-image-main-div-revealHotspot_hotspot1']/img");
				WebElement file10 = driver.findElement(By.xpath(".//div[@id='hotspot-active-image-main-div-revealHotspot_hotspot1']/input[2]"));
				file10.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + closeImage2 + ".jpg");
		        //uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + closeImage2 + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded close image");//
				
				String closeHoverImage2 = getRandomHotSpotImage();
				//clickIdentifierXpath(".//div[@id='hotspot-close-image-main-div-revealHotspot_hotspot1']/img");
				WebElement file11 = driver.findElement(By.xpath(".//div[@id='hotspot-close-image-main-div-revealHotspot_hotspot1']/input[2]"));
				file11.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + closeHoverImage2 + ".jpg");
		        //uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + closeHoverImage2 + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded closehover image");//
				
				String completeImage2 = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-complete-image-main-div-revealHotspot_hotspot1']/img");
				WebElement file12 = driver.findElement(By.xpath(".//div[@id='hotspot-complete-image-main-div-revealHotspot_hotspot1']/input[2]"));
				file12.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + completeImage2 + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + completeImage2 + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded complete image");
				
				
			}
			
			}
			else if(selectionOrder=="Sequential"){
				
				clickIdentifierXpath("//div[@id='selection-order-option-div']/div/div[3]/input");

				Log.info("selectionOrder is selected as Sequential ");
				
				if (RevealBox=="Fixed Location")
				{
				
				Log.info("reveal box is selected as Fixed Location ");
				
				String normalImage = getRandomHotSpotImage();
				clickIdentifierXpath(".//*[@id='hotspot-normal-image-main-div-hotspot_image']/img");
				WebElement file = driver.findElement(By.xpath(".//*[@id='hotspot-normal-image-main-div-hotspot_image']/input[2]"));
				file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + normalImage + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + normalImage + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded normal image");
				
				String hoverImage = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-hover-image-main-div-hotspot_image']/img");
				WebElement file1 = driver.findElement(By.xpath(".//div[@id='hotspot-hover-image-main-div-hotspot_image']/input[2]"));
				file1.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + hoverImage + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + hoverImage + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded hover image");
				
				String closeImage = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-active-image-main-div-hotspot_image']/img");
				WebElement file2 = driver.findElement(By.xpath(".//div[@id='hotspot-active-image-main-div-hotspot_image']/input[2]"));
				file2.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + closeImage + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + closeImage + ".jpg");
				Thread.sleep(8000);
				Log.info("uploaded close image");
				
				String closeHoverImage = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-close-image-main-div-hotspot_image']/img");
				WebElement file3 = driver.findElement(By.xpath(".//div[@id='hotspot-close-image-main-div-hotspot_image']/input[2]"));
				file3.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + closeHoverImage + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + closeHoverImage + ".jpg");
				Thread.sleep(15000);
				Log.info("uploaded closehover image");
				
				String completeImage = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-complete-image-main-div-hotspot_image']/img");
				WebElement file4 = driver.findElement(By.xpath(".//div[@id='hotspot-complete-image-main-div-hotspot_image']/input[2]"));
				file4.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + completeImage + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + completeImage + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded complete image");
				
				
				//typeTextByXpath(".//*[@id='ckeditorContentSidebarTitle']",sbTitle + " " + d.toString());
				typeTextById("ckeditorContentHotspotTitle0", siTitle + " " + d.toString());
				//typeTextByXpath(".//*[@id='ckeditorContentSidebarText']",pageContent + " " + d.toString());
				typeTextById("ckeditorContentHotspotText0", siText + " " + d.toString());
				/*if (audioFile != "")
				{
					
					clickIdentifierXpath(".//*[@id='widget1_uploadAudio']/img");
					uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\audio\\l1p01_1.mp3");
					Thread.sleep(3000);
					Log.info("uploaded Hotspot1 audio");
				}*/
				
				
				
				if(imagePlacement =="DesktopSamrtphones")
				{	
				/*desktop or tablets*/
					placementX=7+placementX;
					String PlacementX=String.valueOf(placementX);
				//typeTextByXpath(".//*[@id='hotSpotDesktopPositionX0']",placementX);
				typeTextById("hotSpotDesktopPositionX0", PlacementX);
				//typeTextByXpath(".//*[@id='hotSpotDesktopPositionY0']",placementY);
				
				placementY=4+placementY;
				String PlacementY=String.valueOf(placementY);
				typeTextById("hotSpotDesktopPositionY0", PlacementY);
				
				/*Smart phones*/
				
				//typeTextByXpath(".//*[@id='hotSpotSmartphonePositionX0']",placementX);
				typeTextById("hotSpotSmartphonePositionX0", PlacementX);
				//typeTextByXpath(".//*[@id='hotSpotSmartphonePositionY0']",placementY);
				typeTextById("hotSpotSmartphonePositionY0", PlacementY);
				
				/*driver.findElement(By.xpath(".//*[@id='hotSpotDesktopPositionX0']")).clear();
				driver.findElement(By.xpath(".//*[@id='hotSpotDesktopPositionX0']")).sendKeys("12");*/
				}
				else{
				/*--POPUP desktop or tablets Placement--*/
				
				clickIdentifierXpath(".//*[@id='placeDesktopHotSpot0']");

				typeTextById("popUpX", glPlacementX);
				
				typeTextById("popUpY", glPlacementY);
				
				//clickIdentifierXpath(".//*[@id='hotSpotPoint']"); Placement in popup image
				clickIdentifierXpath(".//*[@id='hotspotPopUpApplyButton']");
				//clickIdentifierXpath(".//*[@id='hotspotPopUpResetButton']"); //reset button in popup
				clickIdentifierXpath(".//*[@id='hotspotPopUpSaveButton']");
				
				//clickIdentifierXpath(".//*[@id='hotspotPopUpCancelButton']"); //Cancel popup 
				
				/*--POPUP SmartPhone Placement--*/
				
				clickIdentifierXpath(".//*[@id='placeSmartphoneHotSpot0']");

				typeTextById("popUpX", glPlacementX);
				
				typeTextById("popUpY", glPlacementY);
				
				clickIdentifierXpath(".//*[@id='hotspotPopUpApplyButton']");
				clickIdentifierXpath(".//*[@id='hotspotPopUpSaveButton']");
				
				}
				
				//uplaod active image
				String activeImage1 = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-content-active-image-main-div-revealHotspot_hotspot0']/img");
				WebElement file12 = driver.findElement(By.xpath(".//div[@id='hotspot-content-active-image-main-div-revealHotspot_hotspot0']/input"));
				file12.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + activeImage1 + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + activeImage1 + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded Active image");
				
				String normalImage1 = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-normal-image-main-div-revealHotspot_hotspot0']/img");
				WebElement file13 = driver.findElement(By.xpath(".//div[@id='hotspot-normal-image-main-div-revealHotspot_hotspot0']/input[2]"));
				file13.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + normalImage1 + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + normalImage1 + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded normal image");
				
				String hoverImage1 = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-hover-image-main-div-revealHotspot_hotspot0']/img");
				WebElement file14 = driver.findElement(By.xpath(".//div[@id='hotspot-hover-image-main-div-revealHotspot_hotspot0']/input[2]"));
				file14.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + hoverImage1 + ".jpg");
		        //uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + hoverImage1 + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded hover image");
				
				String closeImage1 = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-active-image-main-div-revealHotspot_hotspot0']/img");
				WebElement file15 = driver.findElement(By.xpath(".//div[@id='hotspot-active-image-main-div-revealHotspot_hotspot0']/input[2]"));
				file15.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + closeImage1 + ".jpg");
		        //uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + closeImage1 + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded close image");
				
				String closeHoverImage1 = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-close-image-main-div-revealHotspot_hotspot0']/img");
				WebElement file16 = driver.findElement(By.xpath(".//div[@id='hotspot-close-image-main-div-revealHotspot_hotspot0']/input[2]"));
				file16.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + closeHoverImage1 + ".jpg");
		        //uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + closeHoverImage1 + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded closehover image");
				
				String completeImage1 = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-complete-image-main-div-revealHotspot_hotspot0']/img");
				WebElement file17 = driver.findElement(By.xpath(".//div[@id='hotspot-complete-image-main-div-revealHotspot_hotspot0']/input[2]"));
				file17.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + completeImage1 + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + completeImage1 + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded complete image");
				
				/* to click on + to add New panel */
				clickIdentifierXpath(".//*[@id='revealHotspot_hotspot']/div[2]/div[1]");
				String ImagePanel =driver.findElement(By.xpath(".//*[@id='fieldset-panel0']/legend/label")).getText();
				System.out.println("ImagePanel default Name ="  + ImagePanel); 
				
				/* Image panel2*/
				
				
				typeTextById("ckeditorContentHotspotTitle1", siTitle + " " + d.toString());
				//typeTextByXpath(".//*[@id='ckeditorContentSidebarText']",pageContent + " " + d.toString());
				typeTextById("ckeditorContentHotspotText1", siText + " " + d.toString());
				/*if (audioFile != "")
				{
					
					clickIdentifierXpath(".//*[@id='widget1_uploadAudio']/img");
					uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\audio\\l1p01_1.mp3");
					Thread.sleep(3000);
					Log.info("uploaded Hotspot1 audio");
				}*/
				
				
				
				if(imagePlacement =="DesktopSamrtphones")
				{	
				/*desktop or tablets*/
					placementX=8+placementX;
					String PlacementX=String.valueOf(placementX);
				//typeTextByXpath(".//*[@id='hotSpotDesktopPositionX0']",placementX);
				typeTextById("hotSpotDesktopPositionX1", PlacementX);
				//typeTextByXpath(".//*[@id='hotSpotDesktopPositionY0']",placementY);
				placementY=9+placementY;
				String PlacementY=String.valueOf(placementY);
				typeTextById("hotSpotDesktopPositionY1", PlacementY);
				
				/*Smart phones*/
				
				//typeTextByXpath(".//*[@id='hotSpotSmartphonePositionX0']",placementX);
				typeTextById("hotSpotSmartphonePositionX1", PlacementX);
				//typeTextByXpath(".//*[@id='hotSpotSmartphonePositionY0']",placementY);
				typeTextById("hotSpotSmartphonePositionY1", PlacementY);
				
				/*driver.findElement(By.xpath(".//*[@id='hotSpotDesktopPositionX0']")).clear();
				driver.findElement(By.xpath(".//*[@id='hotSpotDesktopPositionX0']")).sendKeys("12");*/
				}
				else{
				/*--POPUP desktop or tablets Placement--*/
				
				clickIdentifierXpath(".//*[@id='placeDesktopHotSpot1']");

				typeTextById("popUpX", glPlacementX);
				
				typeTextById("popUpY", glPlacementY);
				
				//clickIdentifierXpath(".//*[@id='hotSpotPoint']"); Placement in popup image
				clickIdentifierXpath(".//*[@id='hotspotPopUpApplyButton']");
				//clickIdentifierXpath(".//*[@id='hotspotPopUpResetButton']"); //reset button in popup
				clickIdentifierXpath(".//*[@id='hotspotPopUpSaveButton']");
				
				//clickIdentifierXpath(".//*[@id='hotspotPopUpCancelButton']"); //Cancel popup 
				
				/*--POPUP SmartPhone Placement--*/
				
				clickIdentifierXpath(".//*[@id='placeSmartphoneHotSpot1']");

				typeTextById("popUpX", glPlacementX);
				
				typeTextById("popUpY", glPlacementY);
				
				clickIdentifierXpath(".//*[@id='hotspotPopUpApplyButton']");
				clickIdentifierXpath(".//*[@id='hotspotPopUpSaveButton']");
				
				}
				
				String activeImage2 = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-content-active-image-main-div-revealHotspot_hotspot1']/img");
				WebElement file18 = driver.findElement(By.xpath(".//div[@id='hotspot-content-active-image-main-div-revealHotspot_hotspot1']/input"));
				file18.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + activeImage2 + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + activeImage2 + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded Active image");
				
				String normalImage2 = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-normal-image-main-div-revealHotspot_hotspot1']/img");
				WebElement file19 = driver.findElement(By.xpath(".//div[@id='hotspot-normal-image-main-div-revealHotspot_hotspot1']/input[2]"));
				file19.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + normalImage2 + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + normalImage2 + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded normal image");
				
				String hoverImage2 = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-hover-image-main-div-revealHotspot_hotspot1']/img");
				WebElement file20 = driver.findElement(By.xpath(".//div[@id='hotspot-hover-image-main-div-revealHotspot_hotspot1']/input[2]"));
				file20.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + hoverImage2 + ".jpg");
		        //uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + hoverImage2 + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded hover image");
				
				String closeImage2 = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-active-image-main-div-revealHotspot_hotspot1']/img");
				WebElement file21 = driver.findElement(By.xpath(".//div[@id='hotspot-active-image-main-div-revealHotspot_hotspot1']/input[2]"));
				file21.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + closeImage2 + ".jpg");
		        //uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + closeImage2 + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded close image");
				
				String closeHoverImage2 = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-close-image-main-div-revealHotspot_hotspot1']/img");
				WebElement file22 = driver.findElement(By.xpath(".//div[@id='hotspot-close-image-main-div-revealHotspot_hotspot1']/input[2]"));
				file22.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + closeHoverImage2 + ".jpg");
		        //uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + closeHoverImage2 + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded closehover image");
				
				String completeImage2 = getRandomHotSpotImage();
				clickIdentifierXpath(".//div[@id='hotspot-complete-image-main-div-revealHotspot_hotspot1']/img");
				WebElement file23 = driver.findElement(By.xpath(".//div[@id='hotspot-complete-image-main-div-revealHotspot_hotspot1']/input[2]"));
				file23.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + completeImage2 + ".jpg");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + completeImage2 + ".jpg");
				Thread.sleep(10000);
				Log.info("uploaded complete image");
				}
				
				else if(RevealBox=="Customizable Location")
				{

				
					clickIdentifierXpath("//input[@id='customizableLocation']");
					
					Log.info("reveal box is selected as Customizable Location ");
					
					String normalImage = getRandomHotSpotImage();
					clickIdentifierXpath(".//*[@id='hotspot-normal-image-main-div-hotspot_image']/img");
					WebElement file = driver.findElement(By.xpath(".//*[@id='hotspot-normal-image-main-div-hotspot_image']/input[2]"));
					file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + normalImage + ".jpg");
					//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + normalImage + ".jpg");
					Thread.sleep(10000);
					Log.info("uploaded normal image");
					
					String hoverImage = getRandomHotSpotImage();
					clickIdentifierXpath(".//div[@id='hotspot-hover-image-main-div-hotspot_image']/img");
					WebElement file1 = driver.findElement(By.xpath(".//div[@id='hotspot-hover-image-main-div-hotspot_image']/input[2]"));
					file1.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + hoverImage + ".jpg");
					//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + hoverImage + ".jpg");
					Thread.sleep(10000);
					Log.info("uploaded hover image");
					
					String completeImage = getRandomHotSpotImage();
					clickIdentifierXpath(".//div[@id='hotspot-complete-image-main-div-hotspot_image']/img");
					WebElement file2 = driver.findElement(By.xpath(".//div[@id='hotspot-complete-image-main-div-hotspot_image']/input[2]"));
					file2.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + completeImage + ".jpg");
					//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + completeImage + ".jpg");
					Thread.sleep(10000);
					Log.info("uploaded complete image");
					
					
					
					
					//typeTextByXpath(".//*[@id='ckeditorContentSidebarTitle']",sbTitle + " " + d.toString());
					typeTextById("ckeditorContentHotspotTitle0", siTitle + " " + d.toString());
					//typeTextByXpath(".//*[@id='ckeditorContentSidebarText']",pageContent + " " + d.toString());
					typeTextById("ckeditorContentHotspotText0", siText + " " + d.toString());
					/*if (audioFile != "")
					{
						
						clickIdentifierXpath(".//*[@id='widget1_uploadAudio']/img");
						uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\audio\\l1p01_1.mp3");
						Thread.sleep(3000);
						Log.info("uploaded Hotspot1 audio");
					}*/
					
					
					
					if(imagePlacement =="DesktopSamrtphones")
					{	
					/*desktop or tablets*/
						placementX=4+placementX;
						String PlacementX=String.valueOf(placementX);
					
					//typeTextByXpath(".//*[@id='hotSpotDesktopPositionX0']",placementX);
					typeTextById("hotSpotDesktopPositionX0", PlacementX);
					
					placementY=10+placementY;
					String PlacementY=String.valueOf(placementY);
					//typeTextByXpath(".//*[@id='hotSpotDesktopPositionY0']",placementY);
					typeTextById("hotSpotDesktopPositionY0", PlacementY);
					
					/*Smart phones*/
					
					//typeTextByXpath(".//*[@id='hotSpotSmartphonePositionX0']",placementX);
					typeTextById("hotSpotSmartphonePositionX0", PlacementX);
					//typeTextByXpath(".//*[@id='hotSpotSmartphonePositionY0']",placementY);
					typeTextById("hotSpotSmartphonePositionY0", PlacementY);
					
					/*driver.findElement(By.xpath(".//*[@id='hotSpotDesktopPositionX0']")).clear();
					driver.findElement(By.xpath(".//*[@id='hotSpotDesktopPositionX0']")).sendKeys("12");*/
					}
					else{
					/*--POPUP desktop or tablets Placement--*/
					
					clickIdentifierXpath(".//*[@id='placeDesktopHotSpot0']");

					typeTextById("popUpX", glPlacementX);
					
					typeTextById("popUpY", glPlacementY);
					
					//clickIdentifierXpath(".//*[@id='hotSpotPoint']"); Placement in popup image
					clickIdentifierXpath(".//*[@id='hotspotPopUpApplyButton']");
					//clickIdentifierXpath(".//*[@id='hotspotPopUpResetButton']"); //reset button in popup
					clickIdentifierXpath(".//*[@id='hotspotPopUpSaveButton']");
					
					//clickIdentifierXpath(".//*[@id='hotspotPopUpCancelButton']"); //Cancel popup 
					
					/*--POPUP SmartPhone Placement--*/
					
					clickIdentifierXpath(".//*[@id='placeSmartphoneHotSpot0']");

					typeTextById("popUpX", glPlacementX);
					
					typeTextById("popUpY", glPlacementY);
					
					clickIdentifierXpath(".//*[@id='hotspotPopUpApplyButton']");
					clickIdentifierXpath(".//*[@id='hotspotPopUpSaveButton']");
					
					}
					
				
					String normalImage1 = getRandomHotSpotImage();
					clickIdentifierXpath(".//div[@id='hotspot-normal-image-main-div-revealHotspot_hotspot0']/img");
					WebElement file3 = driver.findElement(By.xpath(".//div[@id='hotspot-normal-image-main-div-revealHotspot_hotspot0']/input[2]"));
					file3.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + normalImage1 + ".jpg");
					//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + normalImage1 + ".jpg");
					Thread.sleep(10000);
					Log.info("uploaded normal image");
					
					String hoverImage1 = getRandomHotSpotImage();
					clickIdentifierXpath(".//div[@id='hotspot-hover-image-main-div-revealHotspot_hotspot0']/img");
					WebElement file4 = driver.findElement(By.xpath(".//div[@id='hotspot-hover-image-main-div-revealHotspot_hotspot0']/input[2]"));
					file4.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + hoverImage1 + ".jpg");
			        //uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + hoverImage1 + ".jpg");
					Thread.sleep(10000);
					Log.info("uploaded hover image");
					
					String completeImage1 = getRandomHotSpotImage();
					clickIdentifierXpath(".//div[@id='hotspot-complete-image-main-div-revealHotspot_hotspot0']/img");
					WebElement file5 = driver.findElement(By.xpath(".//div[@id='hotspot-complete-image-main-div-revealHotspot_hotspot0']/input[2]"));
					file5.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + completeImage1 + ".jpg");
					//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + completeImage1 + ".jpg");
					Thread.sleep(10000);
					Log.info("uploaded complete image");
					
					/* to click on + to add New panel */
					clickIdentifierXpath(".//*[@id='revealHotspot_hotspot']/div[2]/div[1]");
					String ImagePanel =driver.findElement(By.xpath(".//*[@id='fieldset-panel0']/legend/label")).getText();
					System.out.println("ImagePanel default Name ="  + ImagePanel); 
					
					/* Image panel2*/
					
					
					typeTextById("ckeditorContentHotspotTitle1", siTitle + " " + d.toString());
					//typeTextByXpath(".//*[@id='ckeditorContentSidebarText']",pageContent + " " + d.toString());
					typeTextById("ckeditorContentHotspotText1", siText + " " + d.toString());
					/*if (audioFile != "")
					{
						
						clickIdentifierXpath(".//*[@id='widget1_uploadAudio']/img");
						uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\audio\\l1p01_1.mp3");
						Thread.sleep(3000);
						Log.info("uploaded Hotspot1 audio");
					}*/
					
					
					
					if(imagePlacement =="DesktopSamrtphones")
					{	
					/*desktop or tablets*/
					
					//typeTextByXpath(".//*[@id='hotSpotDesktopPositionX0']",placementX);
					typeTextById("hotSpotDesktopPositionX1", glPlacementX);
					//typeTextByXpath(".//*[@id='hotSpotDesktopPositionY0']",placementY);
					typeTextById("hotSpotDesktopPositionY1", glPlacementY);
					
					/*Smart phones*/
					
					//typeTextByXpath(".//*[@id='hotSpotSmartphonePositionX0']",placementX);
					typeTextById("hotSpotSmartphonePositionX1", glPlacementX);
					//typeTextByXpath(".//*[@id='hotSpotSmartphonePositionY0']",placementY);
					typeTextById("hotSpotSmartphonePositionY1", glPlacementY);
					
					/*driver.findElement(By.xpath(".//*[@id='hotSpotDesktopPositionX0']")).clear();
					driver.findElement(By.xpath(".//*[@id='hotSpotDesktopPositionX0']")).sendKeys("12");*/
					}
					else{
					/*--POPUP desktop or tablets Placement--*/
					
					clickIdentifierXpath(".//*[@id='placeDesktopHotSpot1']");

					typeTextById("popUpX", glPlacementX);
					
					typeTextById("popUpY", glPlacementY);
					
					//clickIdentifierXpath(".//*[@id='hotSpotPoint']"); Placement in popup image
					clickIdentifierXpath(".//*[@id='hotspotPopUpApplyButton']");
					//clickIdentifierXpath(".//*[@id='hotspotPopUpResetButton']"); //reset button in popup
					clickIdentifierXpath(".//*[@id='hotspotPopUpSaveButton']");
					
					//clickIdentifierXpath(".//*[@id='hotspotPopUpCancelButton']"); //Cancel popup 
					
					/*--POPUP SmartPhone Placement--*/
					
					clickIdentifierXpath(".//*[@id='placeSmartphoneHotSpot1']");

					typeTextById("popUpX", glPlacementX);
					
					typeTextById("popUpY", glPlacementY);
					
					clickIdentifierXpath(".//*[@id='hotspotPopUpApplyButton']");
					clickIdentifierXpath(".//*[@id='hotspotPopUpSaveButton']");
					
					}
					
					String activeImage2 = getRandomHotSpotImage();
					//clickIdentifierXpath(".//div[@id='hotspot-content-active-image-main-div-revealHotspot_hotspot1']/img");
					WebElement file8 = driver.findElement(By.xpath(".//div[@id='hotspot-content-active-image-main-div-revealHotspot_hotspot1']/input"));
					file8.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + activeImage2 + ".jpg");
					//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + activeImage2 + ".jpg");
					Thread.sleep(10000);
					Log.info("uploaded Active image");//
					
					String normalImage2 = getRandomHotSpotImage();
					clickIdentifierXpath(".//div[@id='hotspot-normal-image-main-div-revealHotspot_hotspot1']/img");
					WebElement file9 = driver.findElement(By.xpath(".//div[@id='hotspot-normal-image-main-div-revealHotspot_hotspot1']/input[2]"));
					file9.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + normalImage2 + ".jpg");
					//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + normalImage2 + ".jpg");
					Thread.sleep(10000);
					Log.info("uploaded normal image");
					
					String hoverImage2 = getRandomHotSpotImage();
					clickIdentifierXpath(".//div[@id='hotspot-hover-image-main-div-revealHotspot_hotspot1']/img");
					WebElement file10 = driver.findElement(By.xpath(".//div[@id='hotspot-hover-image-main-div-revealHotspot_hotspot1']/input[2]"));
					file10.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + hoverImage2 + ".jpg");
			        //uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + hoverImage2 + ".jpg");
					Thread.sleep(10000);
					Log.info("uploaded hover image");
					
					String closeImage2 = getRandomHotSpotImage();
					//clickIdentifierXpath(".//div[@id='hotspot-active-image-main-div-revealHotspot_hotspot1']/img");
					WebElement file11 = driver.findElement(By.xpath(".//div[@id='hotspot-active-image-main-div-revealHotspot_hotspot1']/input[2]"));
					file11.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + closeImage2 + ".jpg");
			        //uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + closeImage2 + ".jpg");
					Thread.sleep(10000);
					Log.info("uploaded close image");//
					
					String closeHoverImage2 = getRandomHotSpotImage();
					//clickIdentifierXpath(".//div[@id='hotspot-close-image-main-div-revealHotspot_hotspot1']/img");
					WebElement file12 = driver.findElement(By.xpath(".//div[@id='hotspot-close-image-main-div-revealHotspot_hotspot1']/input[2]"));
					file12.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + closeHoverImage2 + ".jpg");
			        //uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + closeHoverImage2 + ".jpg");
					Thread.sleep(10000);
					Log.info("uploaded closehover image");//
					
					String completeImage2 = getRandomHotSpotImage();
					clickIdentifierXpath(".//div[@id='hotspot-complete-image-main-div-revealHotspot_hotspot1']/img");
					WebElement file13 = driver.findElement(By.xpath(".//div[@id='hotspot-complete-image-main-div-revealHotspot_hotspot1']/input[2]"));
					file13.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + completeImage2 + ".jpg");
					//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + completeImage2 + ".jpg");
					Thread.sleep(10000);
					Log.info("uploaded complete image");
				}	
					
			}	
			
			
			//Bulletin 
			String bulletinstatus =driver.findElement(By.xpath(".//div[@id='tab1']/div/div[1]/div[2]/div/div/label[2]")).getText();
			System.out.println("Add Bulletin to pgae toggle Button Status="  + bulletinstatus); 
			
			String addBstatus = "NO";
			
			if (bulletinstatus.equals(addBstatus))
			{
				clickIdentifierXpath(".//*[@id='tab1']/div/div[1]/div[2]/div/div");
				System.out.println("Add Bulletin to pgae toggle Button Status to yes" ); 
				String largeBstatus =driver.findElement(By.xpath(".//*[@id='tab1']/div/div[2]/div/div[2]/div/div/label[2]")).getText();
				System.out.println("large Bulletin toggle Button Status="  + largeBstatus);
				String lbStatus = "NO";
				
				if(largeBstatus.equals(lbStatus)){
					clickIdentifierXpath(".//*[@id='tab1']/div/div[2]/div/div[2]/div/div");
					System.out.println("large Bulletin toggle Button Set to yes" ); 
					
				String mBstatus =driver.findElement(By.xpath(".//div[@id='tab1']/div/div[3]/div[1]/div[1]/div[2]/div/div/label[2]")).getText();
				System.out.println("large Bulletin toggle Button Status="  + mBstatus);
				String bmand = "NO";
				if(mBstatus.equals(bmand)){
					clickIdentifierXpath(".//*[@id='tab1']/div/div[3]/div[1]/div[1]/div[2]");
					System.out.println("Add Bulletin to pgae toggle Button Status to yes" ); 
					
					//clickIdentifierXpath(".//*[@id='tab1']/div/div[3]/div[1]/div[1]/div[2]");
					//if (selectbulletintype != "")
					
								clickIdentifierByID(selectbulletintype);
								
								typeTextById("ckeditorContentBulletinTitle", bulletinTitle + " " + d.toString());
								//typeTextByXpath(".//*[@id='ckeditorContentSidebarText']",pageContent + " " + d.toString());
								typeTextById("ckeditorContentBulletin", bulletinText + " " + d.toString());
				
								addNewTemplateBackgroundImage();
			}
			else
			{
								
					
				}
				
				}
				else{
					
				}
				
			
			}
			else{
				
			}
					
			clickIdentifierByID("saveIconId");
			
			String pageSaved = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			Thread.sleep(3000);
			
			if (pageSaved.contains("Page saved"))
				Log.pass("page saved");
			else
				Log.fail("page failed to save for reason: " + pageSaved);
			if (audioFile != "")
			{
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,-500)", "");
				
				
				String audio = getRandomAudio();
				clickIdentifierXpath("//div[@id='widget2_uploadAudio']/img");
				WebElement file = driver.findElement(By.xpath(".//*[@id='widget2_audioFile']"));
				file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\audio\\" + audio + ".mp3");
				//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\audio\\" + audio + ".mp3");
				Thread.sleep(3000);
				Log.info("uploaded audio");
			}
			clickIdentifierByID("saveIconId");
			
			String pageSaved1 = getValueByXpath("//*[@id='messageDialog']/tr/td[2]");
			
			Thread.sleep(3000);
			
			if (pageSaved1.contains("Page saved"))
				Log.pass("page saved");
			else
				Log.fail("page failed to save for reason: " + pageSaved1);
		
			}
			catch(Exception e){  
			       Log.fail("Failed to edit text template");
			       e.printStackTrace();
			       throw e;                                        
			} catch(AssertionError e)
			{
			       Log.fail("Failed to edit text template");
			       e.printStackTrace();
			       throw e;

			}
			}
			
}
