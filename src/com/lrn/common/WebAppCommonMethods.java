package com.lrn.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.lrn.html5.common.ObjectMap;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
/*import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedInputStream;*/

public class WebAppCommonMethods {

	public static ObjectMap objmap = new ObjectMap (System.getProperty("user.dir")+"\\resource\\objects\\CommonMethods.properties");

	//Log4j via .properties
	public static Logger logger = Logger.getLogger(WebAppCommonMethods.class.getName());
	public static final String logProperttFilePath = System.getProperty("user.dir")+"\\resource\\objects\\log4j.properties";

	//ExtentReports
	public static ExtentReports extent;
	public static ExtentTest testlog;

	public static WebDriver driver = null;
	public static String catalogID;
	public static String failImagePath = null;
	public static String siteName;
	public static String enviornment;
	public static String userName;
	public static String password;
	public static String systemID;
	public static String ExcelName;
	public static String ExcelSheetName;
	public static int ExcelRowNumber;
	public static String BrowserName = "Chrome";
	public static String FullScreenYesNo = "No";
	public static String FastYesNo = "Yes";
	public static String ScreenshotYesNo = "No";
	public static String Quiz = "No";
	public static String BranchingLesson = "No";
	public static String AdaptiveLesson = "No";
	public static String TileMenu = "No";
	public static String SAQYesNo = "No";
	public static String JumptoCoursePage = "No";
	public static String JumptoTileNum = "1";
	public static String baseUrl;
	public static StringBuffer verificationErrors = new StringBuffer();
	//public static ATUTestRecorder recorder;


	
	// Log messages and ExtentReports status & Message
	
	public static void logINFO(String message) {
		logger.info(message);
		testlog.log(LogStatus.INFO, message);
	}

	public static void logPASS(String message) {
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		logger.info(methodName + " :: " + message);
		testlog.log(LogStatus.PASS, methodName + " :: " + message);
	}
	
	public static void logFAIL(String message) {
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		if (JumptoCoursePage.equals("No"))
		{
			logger.info(methodName + " :: " + message);
			testlog.log(LogStatus.INFO, methodName + " :: " + message);
		} else 
		{
			if ((ScreenshotYesNo.contains("Yes")) || (ScreenshotYesNo.contains("Fail")) && !ScreenshotYesNo.equals("No"))
			{
				if (failImagePath.equals("") || failImagePath.equals("null") || failImagePath.equals("undefined"))
				{
					logger.info(methodName + " :: " + message);
					testlog.log(LogStatus.FAIL, methodName + " :: " + message);
				} else
				{
					logger.info(methodName + " :: " + message);
					testlog.log(LogStatus.FAIL, message + testlog.addScreenCapture(failImagePath));
				}
			} else {
				logger.info(methodName + " :: " + message);
				testlog.log(LogStatus.FAIL, methodName + " :: " + message);
			}
		} 
	}

	public static void logFAILED(String message) {
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		if ((ScreenshotYesNo.contains("Yes")) || (ScreenshotYesNo.contains("Fail")) && !ScreenshotYesNo.equals("No"))
		{
			if (failImagePath.equals("") || failImagePath.equals("null") || failImagePath.equals("undefined"))
			{
				logger.info(methodName + " :: " + message);
				testlog.log(LogStatus.FAIL, methodName + " :: " + message);
			} else
			{
				logger.info(methodName + " :: " + message);
				testlog.log(LogStatus.FAIL, message + testlog.addScreenCapture(failImagePath));
			}
		} else {
			logger.info(methodName + " :: " + message);
			testlog.log(LogStatus.FAIL, methodName + " :: " + message);
		}
	}

	public static void logSKIP(String message) {
		String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		if (JumptoCoursePage.equals("No") || JumptoCoursePage.equals("Yes"))
		{
			logger.info(methodName + " :: " + message);
			testlog.log(LogStatus.INFO, methodName + " :: " + message);
		} else {
			logger.info(methodName + " :: " + message);
			testlog.log(LogStatus.SKIP, methodName + " :: " + message);
		}
	}
	
	// Assert Fail method

	public static void assertFail() throws Exception {
		if (!JumptoCoursePage.equals("No") && !JumptoCoursePage.equals("Yes"))
		{
			Assert.fail();
		} else if (BranchingLesson.equals("Yes"))
		{
			Assert.fail();
		}
	}
	
	
	// WebAppCommon Methods


	public static void waitforElement(String Element) throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 1); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(objmap.getLocator(Element)));
	}

	public static boolean verifyElementPresent(String Element) throws Exception {
		try {
			waitforElement(Element);
			WebElement element = driver.findElement(objmap.getLocator(Element));
			Coordinates coordinate = ((Locatable)element).getCoordinates(); 
			coordinate.inViewPort();
			isElementPresent(objmap.getLocator(Element));
			driver.findElement(objmap.getLocator(Element)).isDisplayed();
			//logINFO(Element + " : Present");
		} catch (Exception e) {
			//TakeScreenshot("Fail-"+Element+"-Method-verifyElementPresent");
			//logFAIL(Element + ": The method verifyElementPresent failed (error)");
			return false;
		}
		return true;
	}

	protected static boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static boolean verifyElementTextPresent(String Element) throws Exception {
		try {
			if (FastYesNo.equals("No"))
			{
				waitforElement(Element);
				WebElement element = driver.findElement(objmap.getLocator(Element));
				Coordinates coordinate = ((Locatable)element).getCoordinates(); 
				coordinate.inViewPort();
				String Text = driver.findElement(objmap.getLocator(Element)).getText();
				if (Text.equals("") || Text.equals("null") || Text.equals("undefined") || Text.equals("00:00"))
				{
					TakeScreenshot("Fail-"+Element+"-TextNotPresent");
					logFAIL(Element + " = ["+ Text +"] : Not-Present (error)");
					assertFail();
				} else
				{
					//logINFO(Element + " = ["+ Text +"] : Present");
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-"+Element+"-Method-verifyElementTextPresent");
			logFAIL(Element + ": The method verifyElementTextPresent failed (error)");
			assertFail();
			return false;
		}
		return true;
	}

	public static void verifyElementImagePresent(String Element) throws Exception {
		try{
			if (FastYesNo.equals("No"))
			{
				waitforElement(Element);
				WebElement element = driver.findElement(objmap.getLocator(Element));
				Coordinates coordinate = ((Locatable)element).getCoordinates(); 
				coordinate.inViewPort();
				String Image = driver.findElement(objmap.getLocator(Element)).getAttribute("src");
				if (Image.contains("placeholder") || Image.equals("null") || Image.equals("") || Image.contains("errorSource") || Image.contains("dnd_icons"))
				{
					logINFO(Element + " = ["+ Image +"] Plcaeholder-Image: Present");
					WebElement ImageFile = driver.findElement(objmap.getLocator(Element));
					Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
					if (ImagePresent)
					{
						TakeScreenshot("Fail-"+Element+"-PlcaeholderImageLoaded");	
						logFAIL(Element + " Plcaeholder-Image: Loaded (error)");
						assertFail();
					} else
					{
						TakeScreenshot("Fail-"+Element+"-PlcaeholderImageNotLoaded");
						logFAIL(Element + " Plcaeholder-Image: Not-Loaded (error)");
						assertFail();
					}
				} else
				{
					//logINFO(Element + " = ["+ Image +"] : Present");
					WebElement ImageFile = driver.findElement(objmap.getLocator(Element));
					Boolean ImagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", ImageFile);
					if (ImagePresent)
					{
						//logINFO(Element + " Image: Loaded");
					} else
					{
						TakeScreenshot("Fail-"+Element+"-ImageNotLoaded");
						logFAIL(Element + " Image: Not-Loaded (error)");
						assertFail();
					}
				}
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-"+Element+"-Method-verifyElementImagePresent");
			logFAIL(Element + ": The method verifyElementImagePresent failed (error)");
			assertFail();
		}
	}

	public static void clickElementText(String Element) throws Exception {
		try {
			verifyElementTextPresent(Element);

			movetoElement(Element);

			WebElement element1 = driver.findElement(objmap.getLocator(Element));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
			Thread.sleep(500);

			WebElement element2 = driver.findElement(objmap.getLocator(Element));
			Coordinates coordinate = ((Locatable)element2).getCoordinates();
			coordinate.onPage();
			coordinate.inViewPort();

			String Disabled = driver.findElement(objmap.getLocator(Element)).getText();
			String disabled = driver.findElement(objmap.getLocator(Element)).getAttribute("class");
			if (Disabled.contains("dimmed") || disabled.contains("disabled"))
			{
				TakeScreenshot("Fail-"+Element+"-ButtonDisabled");
				logFAIL(Element + ": Button Disabled  (error)");
				assertFail();
			} else
			{
				//logINFO(Element + ": Button Enabled");
				driver.findElement(objmap.getLocator(Element)).click();
				//logINFO(Element + ": Clicked");
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-"+Element+"-Method-clickElementText");
			logFAIL(Element + ": The method clickElementText failed (error)");
			assertFail();
		}
	}

	public static void clickElement(String Element) throws Exception {
		try {
			waitforElement(Element);

			movetoElement(Element);

			WebElement element1 = driver.findElement(objmap.getLocator(Element));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
			Thread.sleep(500);

			WebElement element2 = driver.findElement(objmap.getLocator(Element));
			Coordinates coordinate = ((Locatable)element2).getCoordinates();
			coordinate.onPage();
			coordinate.inViewPort();

			String Disabled = driver.findElement(objmap.getLocator(Element)).getText();
			String disabled = driver.findElement(objmap.getLocator(Element)).getAttribute("class");
			if (Disabled.contains("dimmed") || disabled.contains("disabled"))
			{
				TakeScreenshot("Fail-"+Element+"-ButtonDisabled");
				logFAIL(Element + ": Button Disabled (error)");
				//CloseBrowser();
				assertFail();
			} else
			{
				//logINFO(Element + ": Button Enabled");
				driver.findElement(objmap.getLocator(Element)).click();
				//logINFO(Element + ": Clicked");
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-"+Element+"-Method-clickElement");
			logFAIL(Element + ": The method clickElement failed (error)");
			assertFail();
		}
	}

	public static void clickInvisibleElement(String Element) throws Exception {
		//Clicking an invisible or hidden Element on page
		//style="Display:none;" | style="Display:block;" | style="visibility:hidden;" | type="hidden"
		try {
			WebElement invisibleelement= driver.findElement(objmap.getLocator(Element)); 
			JavascriptExecutor executor = (JavascriptExecutor)driver;  
			executor.executeScript("arguments[0].click();", invisibleelement);
		} catch (Exception e) {
			TakeScreenshot("Fail-"+Element+"-Method-clickInvisibleElement");
			logFAIL(Element + ": The method clickInvisibleElement failed (error)");
			assertFail();
		}
	}


	public static void getAttribute(String Element, String Attribute) throws Exception {
		try {
			waitforElement(Element);
			WebElement element = driver.findElement(objmap.getLocator(Element));
			Coordinates coordinate = ((Locatable)element).getCoordinates(); 
			coordinate.inViewPort();
			String AttributeValue = driver.findElement(objmap.getLocator(Element)).getAttribute(Attribute);
			if (AttributeValue.equals("") || AttributeValue.equals("null"))
			{
				TakeScreenshot("Fail-"+Element+"-AttributeValueNotPresent");
				logFAIL(Element + " = ["+ AttributeValue +"] : Not-Present (error)");
				assertFail();
			} else
			{
				//logINFO(Element + " = ["+ AttributeValue +"] : Present");
			}
		} catch (Exception e) {
			TakeScreenshot("Fail-"+Element+"-Method-getAttribute");
			logFAIL(Element + ": The method getAttribute failed (error)");
			assertFail();
		}
	} 

	public static boolean verifyElementTextDisplayed(String Element) throws Exception {
		try {
			waitforElement(Element);
			driver.findElement(objmap.getLocator(Element)).isDisplayed();
			WebElement element = driver.findElement(objmap.getLocator(Element));
			Coordinates coordinate = ((Locatable)element).getCoordinates(); 
			coordinate.inViewPort();
			String Text = driver.findElement(objmap.getLocator(Element)).getText();
			if (Text.equals("") || Text.equals("null") || Text.equals("00:00") || Text.equals("  ") || Text.contains("   "))
			{
				TakeScreenshot("Fail-"+Element+"-TextNotDisplayed");	
				logFAIL(Element + " = ["+ Text +"] : Not-Displayed (error)");
				assertFail();
			} else
			{
				//logINFO(Element + " = ["+ Text +"] : Displayed");
			}

		} catch (Exception e) {
			TakeScreenshot("Fail-"+Element+"-Method-verifyElementTextDisplayed");
			logFAIL(Element + ": The method verifyElementTextDisplayed failed (error)");
			assertFail();
			return false;
		}
		return true;
	}

	public static void DragandDrop(String Element, String Target) throws Exception {
		try {
			WebElement ELEMENT = driver.findElement(objmap.getLocator(Element));
			WebElement TARGET = driver.findElement(objmap.getLocator(Target));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", TARGET);
			Thread.sleep(500);
			(new Actions(driver)).dragAndDrop(ELEMENT, TARGET).perform();
			Thread.sleep(2000);
			//logINFO(""+Element+" - DROPPPED IN - "+ Target +"");
			TakeScreenshot("Pass");
		} catch (Exception e) {
			TakeScreenshot("Fail-"+Element+"-Method-DragandDrop");
			logFAIL(Element + ": The method DragandDrop failed (error)");
			assertFail();
		}
	}

	public static void dragSlider(String Element, int X, int Y) throws Exception {
		try {
			waitforElement(Element);
			WebElement element = driver.findElement(objmap.getLocator(Element));
			Coordinates coordinate = ((Locatable)element).getCoordinates(); 
			coordinate.inViewPort();
			WebElement Slider = driver.findElement(objmap.getLocator(Element));
			Actions moveSlider = new Actions(driver);
			Action action = moveSlider.dragAndDropBy(Slider, X, Y).build();
			action.perform();
			//logINFO(Element + "Slider Drag " + X +" to " + Y +" Position");
		} catch (Exception e) {
			TakeScreenshot("Fail-"+Element+"-Method-dragSlider");
			logFAIL(Element + ": The method dragSlider failed (error)");
			assertFail();
		}
	}

	public static void checkInvisibilityOfElement(int X, String Element) throws Exception {
		try {
			WebElement element = driver.findElement(objmap.getLocator(Element));
			Coordinates coordinate = ((Locatable)element).getCoordinates(); 
			coordinate.inViewPort();
			WebDriverWait wait = new WebDriverWait(driver, X);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(objmap.getLocator(Element)));
		} catch (Exception e) {
			TakeScreenshot("Fail-"+Element+"-Method-checkInvisibilityOfElement");
			logFAIL(Element + ": The method checkInvisibilityOfElement failed (error)");
			assertFail();
		}
	}

	public static void checkVisibilityOfElement(int X, String Element) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, X);
			wait.until(ExpectedConditions.visibilityOfElementLocated(objmap.getLocator(Element)));
			WebElement element = driver.findElement(objmap.getLocator(Element));
			Coordinates coordinate = ((Locatable)element).getCoordinates(); 
			coordinate.inViewPort();
		} catch (Exception e) {
			TakeScreenshot("Fail-"+Element+"-Method-checkVisibilityOfElement");
			logFAIL(Element + ": The method checkVisibilityOfElement failed (error)");
			assertFail();
		}
	}

	public static boolean checkVisibilityOfTemplate(int X, String Element) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, X);
			wait.until(ExpectedConditions.visibilityOfElementLocated(objmap.getLocator(Element)));
		} catch (Exception e) {
			//TakeScreenshot("Fail-"+Element+"-Method-checkVisibilityOfTemplate");
			//logFAIL(Element + ": The method checkVisibilityOfTemplate failed (error)");
			//assertFail();
			return false;
		}
		return true;
	}

	public static void movetoElement(String Element) throws Exception {
		try{
			WebElement HotSpot = driver.findElement(objmap.getLocator(Element));
			Actions action = new Actions(driver);
			action.moveToElement(HotSpot).perform();
		} catch (Exception e) {
			TakeScreenshot("Fail-"+Element+"-Method-movetoElement");
			logFAIL(Element + ": The method movetoElement failed (error)");
			assertFail();
		}
	}




	/*public static void ScrollDownToEnd(String Element) throws Exception {
		try {
			driver.findElement(objmap.getLocator(Element)).click();
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.END).perform();
			TakeScreenshot("Pass");
		} catch (Exception e) {
			TakeScreenshot("Fail-"+Element+"-Method-ScrollDownToEnd");
			//logFAIL(Element + ": The method ScrollDownToEnd failed (error)");
			assertFail();
		}
	}*/

	/*public static void ScrollUpToTop(String Element) throws Exception {
		try {
			driver.findElement(objmap.getLocator(Element)).click();
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.HOME).perform();
			TakeScreenshot("Pass");
		} catch (Exception e) {
			TakeScreenshot("Fail-"+Element+"-Method-ScrollUpToTop");
			//logFAIL(Element + ": The method ScrollUpToTop failed (error)");
			assertFail();
		}
	}*/

	/*public static void ScrollToFindElement(String Element) throws Exception {
		try {
			WebElement element = driver.findElement(objmap.getLocator(Element));
			Coordinates coordinate = ((Locatable)element).getCoordinates(); 
			coordinate.inViewPort();
		} catch (Exception e) {
			TakeScreenshot("Fail-"+Element+"-Method-ScrollToFindElement");
			logFAIL(Element + ": The method ScrollToFindElement failed (error)");
			assertFail();
		}
	}*/

	/*public static void checkVerticalScrollBarPresent() throws Exception {
		try {
			driver.findElement(By.cssSelector("div.page.ng-scope.slideIn")).click();
			String execScript = "return document.documentElement.scrollHeight>document.documentElement.clientHeight;";
	  		JavascriptExecutor scrollBarPresent = (JavascriptExecutor) driver;
	  		Boolean test = (Boolean) (scrollBarPresent.executeScript(execScript));
	  		if (test == true) {
	  			System.out.print("Vertical Scrollbar is present.");
	  		} else if (test == false){
	  			System.out.print("Vertical Scrollbar is not present.");
	  		}
		} catch (Exception e) {
			TakeScreenshot("Fail-"+Element+"-Method-checkVerticalScrollBarPresent");
			//logFAIL(Element + ": The method checkVerticalScrollBarPresent failed (error)");
			assertFail();
		}

	}*/

	/*public static void checkHorizontalScrollBarPresent() throws Exception {
		try {
			driver.findElement(By.cssSelector("div.page.ng-scope.slideIn")).click();
			String execScript = "return document.documentElement.scrollWidth>document.documentElement.clientWidth;";
	  		JavascriptExecutor scrollBarPresent = (JavascriptExecutor) driver;
	  		Boolean test = (Boolean) (scrollBarPresent.executeScript(execScript));
	  		if (test == true) {
	  			System.out.print("Vertical Scrollbar is present.");
	  		} else if (test == false){
	  			System.out.print("Vertical Scrollbar is not present.");
	  		}
		} catch (Exception e) {
			TakeScreenshot("Fail-"+Element+"-Method-checkHorizontalScrollBarPresent");
			//logFAIL(Element + ": The method checkHorizontalScrollBarPresent failed (error)");
			assertFail();
		}
	}*/

	public static void TakeScreenshot(String PassORFail) throws Exception {
		String path = null;
		try {
			if ((PassORFail.contains(ScreenshotYesNo) || ScreenshotYesNo.contains("Yes")) && !ScreenshotYesNo.equals("No"))
			{
				Thread.sleep(2000);
				File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				Calendar currentDate = Calendar.getInstance();
				java.io.File currentDir = new java.io.File("");                
				//String workingDirectory = System.getProperty("user.dir");
				//get today's date without Time stamp
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
				Date today = dateFormat.parse(dateFormat.format(new Date()));
				String todaysDate = dateFormat.format(today).replace("/", "");
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MMM/yyyy_HH:mm:ss");
				//Get Full Class name 
				//String fullClassName = Thread.currentThread().getStackTrace()[2].getClassName();
				//Get Method name 
				//String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
				//Get Class short name 
				//int firstChar = fullClassName.lastIndexOf('.') +1;
				//int firstChar1 = methodName.lastIndexOf('.') +1;
				//String className = fullClassName.substring(firstChar);
				String dateN = formatter.format(currentDate.getTime()).replace("/","_");
				String dateNow = dateN.replace(":",".");
				//logINFO("printing datenow---------"+dateNow);
				String strAppPath = currentDir.getAbsolutePath()+ "/testresult/screenshots/"+catalogID+"_"+BrowserName+"_"+todaysDate; // Screenshots in Local Machine
				//String strAppPath = "Q:/ContentQA-FluidX-Automation-Results/screenshots/"+catalogID+"_"+BrowserName+"_"+todaysDate; // Screenshots in Q drive
				String strAppPathPass = strAppPath+"/Passed";
				String strAppPathFail = strAppPath+"/Failed";
				//     String strAppPath = currentDir.getAbsolutePath();
				//     int count = 1;
				String fileName = catalogID+"_"+BrowserName+"_"+PassORFail+"_"+dateNow+".jpeg"; 
				//     count++;
				//     String fileName = dateNow+".png"; 
				//String snapShotDirectory = strAppPath;
				String snapShotDirectoryPass = strAppPathPass;
				String snapShotDirectoryFail = strAppPathFail;
				//logINFO("Im here-------------"+snapShotDirectory);
				File Pass = new File(snapShotDirectoryPass);
				File Fail = new File(snapShotDirectoryFail);
				//check for snapshot having folder with today date if not then create one
				if (PassORFail.contains("Pass"))
				{
					if(Pass.exists()){
						//logINFO("SnapshotDirectory Already Exists");
					}
					else {
						Pass.mkdir();
					}                     
					path = Pass.getAbsolutePath() + "\\" + fileName;
					//logINFO("Path------------------"+path);
					FileUtils.copyFile(source, new File(path));
				}
				else if (PassORFail.contains("Fail"))
				{
					if(Fail.exists()){
						//logINFO("SnapshotDirectory Already Exists");
					}
					else {
						Fail.mkdir();
					}                     
					path = Fail.getAbsolutePath() + "\\" + fileName;
					failImagePath = path;
					//logINFO("Path------------------"+path);
					FileUtils.copyFile(source, new File(path));
				}
			}
		}
		catch(IOException e) {
			path = "Failed to capture screenshot: " + e.getMessage();
			logINFO("The method TakeScreenshot failed (error)");
			assertFail();
		}
	}

	public static void createLogfiles() throws Exception {
		try {
			Calendar currentDate = Calendar.getInstance();
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy_HH.mm.ss");
			String dateTime = formatter.format(currentDate.getTime());
			String FileName = catalogID + "-" + BrowserName + "-" + dateTime + ".log";
			File file = new File(System.getProperty("user.dir")+"\\testresult\\logs\\" + FileName); // Logs on Local Machine
			//File file = new File("Q:/ContentQA-FluidX-Automation-Results/logs/" + FileName); // Logs on Q drive for ContentQA team


			if (file.createNewFile()) {
				Properties props = new Properties();
				props.load(new FileInputStream(logProperttFilePath));
				//props.setProperty("log4j.appender.R.File", "Q:/ContentQA-FluidX-Automation-Results/logs/" + FileName); // Logs on Q drive for ContentQA team
				props.setProperty("log4j.appender.R.File", System.getProperty("user.dir")+"\\testresult\\logs\\" + FileName); // Logs on Local Machine
				LogManager.resetConfiguration();
				PropertyConfigurator.configure(props);
				logINFO("logs =" + FileName);
				//System.out.print("logs = Q:/ContentQA-FluidX-Automation-Results/logs/" + FileName);
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.print("IO Exception in static method of Logger Class. " + e.getMessage());
			logINFO("The method createLogfiles failed (error)");
			//System.exit(-1);
		}
	}
	
	/*public boolean verifyPDFContent(String strURL, String reqTextInPDF) throws Exception {
		
		boolean flag = false;
		
		PDFTextStripper pdfStripper = null;
		PDDocument pdDoc = null;
		COSDocument cosDoc = null;
		String parsedText = null;

		try {
			URL url = new URL(strURL);
			BufferedInputStream file = new BufferedInputStream(url.openStream());
			PDDocument parser = PDDocument.load(file);
			
			cosDoc = parser.getDocument();
			pdfStripper = new PDFTextStripper();
			pdfStripper.setStartPage(2);
			pdfStripper.setEndPage(2);
			
			pdDoc = new PDDocument(cosDoc);
			parsedText = pdfStripper.getText(pdDoc);
			
			parser.close();
			file.close();
		} catch (MalformedURLException e2) {
			System.err.println("URL string could not be parsed "+e2.getMessage());
		} catch (IOException e) {
			System.err.println("Unable to open PDF Parser. " + e.getMessage());
			try {
				if (cosDoc != null)
					cosDoc.close();
				if (pdDoc != null)
					pdDoc.close();
			} catch (Exception e1) {
				e.printStackTrace();
			}
		}
		
		System.out.println("+++++++++++++++++");
		System.out.println(parsedText);
		System.out.println("+++++++++++++++++");

		if(parsedText.contains(reqTextInPDF)) {
			flag=true;
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.END).perform();
			TakeScreenshot("Pass");
			logPASS("Pass");
		} else {
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.END).perform();
			TakeScreenshot("Fail-PDFBlank");
			logFAILED("Fail");
		}
		
		return flag;
	}*/

}
