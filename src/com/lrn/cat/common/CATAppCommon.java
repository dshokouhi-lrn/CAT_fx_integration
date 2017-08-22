package com.lrn.cat.common;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.IClass;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;














import com.lrn.html5.common.GenericTemplateMethods;
import com.lrn.pp.utility.*;
import com.lrn.webdrivercommon.WebAppCommon;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;



public class CATAppCommon extends WebAppCommon {


	public static Properties configProperties = readPropertyFile("//resource//config//FrameworkConfig.properties");
	String query = "select cl.system_id,cl.catalog_id from course_lookup cl left join edition_data ed on cl.edition_id=ed.edition_id and ed.name='job_role' left join edition_data ed2 on cl.edition_id=ed2.edition_id and ed2.name='geographic_orientation' left join edition_data ed3 on cl.edition_id=ed3.edition_id and ed3.name='unit_weight' left join edition_data ed4 on cl.edition_id=ed4.edition_id and ed4.name='job_department' left join edition_data ed5 on cl.edition_id=ed5.edition_id and ed5.name='learning_level' left join edition_data ed6 on cl.edition_id=ed6.edition_id and ed6.name='course_type' left join edition_data ed7 on cl.edition_id=ed7.edition_id and ed7.name='estimated_time' left join edition_data ed8 on cl.edition_id=ed8.edition_id and ed8.name='risk_area' left join edition_data ed9 on cl.edition_id=ed9.edition_id and ed9.name='schema' left join edition_data ed10 on cl.edition_id=ed10.edition_id and ed10.name='vendor' left join edition_data ed11 on cl.edition_id=ed11.edition_id and ed11.name='issuing_body' left join edition_data ed12 on cl.edition_id=ed12.edition_id and ed12.name='industry' left join edition_data ed13 on cl.edition_id=ed13.edition_id and ed13.name='isLibrary'  left join edition_data ed15 on cl.edition_id=ed15.edition_id and ed15.name='laws' left join edition_data ed16 on cl.edition_id=ed16.edition_id and ed16.name='secondary_topic' left join edition_data ed17 on cl.edition_id=ed17.edition_id and ed17.name='pdfDocuments' left join edition_data ed18 on cl.edition_id=ed18.edition_id and ed18.name='userInterfaceList'left join course_category cate on cl.course_category_id=cate.id join module ml on cl.module_id=ml.id order by cl.updated desc";

	@Parameters("browser")
	@BeforeTest
	public void startWebDriver(String browser) throws Exception{
		try{
		//	makeDirectory();
			launchBrowser(browser);
			System.out.println("the chosen environment is: " + configProperties.getProperty("env"));
			
			if (configProperties.getProperty("env").contains("qa7"))
				openURL(configProperties.getProperty("pptUrl1"));
			else if (configProperties.getProperty("env").contains("prod"))
				openURL(configProperties.getProperty("pptUrl2"));
			else if (configProperties.getProperty("env").contains("qa4"))
				openURL(configProperties.getProperty("pptUrl4"));
			else if (configProperties.getProperty("env").contains("stg"))
				openURL(configProperties.getProperty("pptUrl6"));
		}
		catch(Exception e){
			throw e;
		}
	}





	@AfterMethod
	public void updateResult(ITestResult result) throws AWTException
	{
		String c=result.getName();
		if(result.getStatus()==ITestResult.FAILURE)
		{

			String screenshot_path=captureScreenshot3(driver,c);
			String image= logger1.addScreenCapture(screenshot_path);
			logger1.log(LogStatus.FAIL, "Title verification", image);


		}
		report.endTest(logger1);
		report.flush();

	}
	
	/**
	 * To be called while editing any page with old background image form,  will upload a random image and supply alt text
	 * @throws Exception
	 */
	static public void uploadBackgroundImage() throws Exception
	{
		try
		{
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,550)", "");
			
			Date d = new Date();
			
			Thread.sleep(1000);
			
			clickIdentifierXpath(".//*[@id='pageAccordian']/h5[2]");
			
			Thread.sleep(1000);
			
			clickIdentifierXpath("//*[@id='pageBackgroundSection']/div/div[1]/div[1]/img");
			
			String image = getRandomImage();
			WebElement file = driver.findElement(By.xpath("//*[@id='pageBackgroundSection']/div/div[1]/div[1]/input[2]"));
			file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
			//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
			
			Thread.sleep(60000);
			Log.info("uploaded background image");
			
			String success = driver.findElement(By.xpath(".//*[@id='pageBackgroundSection']/div[1]/div[1]/div[2]/div[1]/img")).getAttribute("src");
			
			if (success.contains(image))
				Log.pass("verified the background image uploaded");
		
			typeTextById("graphicDescriptionBackgroundImage", "test " + d.toString());
			
			typeTextById("altTextBackgroundImage", "test " + d.toString());
		}
		
		catch(Exception e){
			throw e;
		}
	}
	
	/**
	 * to be called while editing old template
	 * @throws Exception
	 */
	static public void uploadPageAudio() throws Exception
	{
		try
		{
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,550)", "");
			
			Thread.sleep(1000);
			
			clickIdentifierXpath(".//*[@id='pageAccordian']/h5[1]");
			
			Thread.sleep(1000);
			
			clickIdentifierXpath("//*[@id='audioUpload']/input[2]");
			
			String audio = getRandomAudio();
			WebElement file = driver.findElement(By.xpath("//*[@id='audioUpload']/input[3]"));
			file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\audio\\" + audio + ".mp3");
			//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\audio\\" + audio + ".mp3");
			Thread.sleep(3000);
			Log.info("uploaded audio");
			
			String success = driver.findElement(By.id("audioName")).getText();
			
			if (success.contains(audio))
				Log.pass("verified page audio upload successfully");
		}
		
		catch(Exception e){
			throw e;
		}
	}
	
	/**
	 * to be used on new templates: Text and Graphic, Sidebar, Video, Selectable Image 
	 * @throws Exception
	 */
	static public void addNewTemplateBackgroundImage() throws Exception
	{
		try
		{

			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,-500)", "");
			
			Date d = new Date();
			Log.info("begin adding background image");
			
			clickIdentifierXpath(".//*[@id='tabs']/ul/li[3]");
			
			Thread.sleep(2000);
			
			clickIdentifierXpath(".//*[@id='tabs']/ul/li[3]");
			
			Thread.sleep(2000);
			
			clickIdentifierXpath(".//*[@id='tab-desktop-image-main-div']/img");
			
			String image = getRandomImage();
			
			WebElement file = driver.findElement(By.xpath(".//*[@id='tab-desktop-image-main-div']/input[2]"));
			file.sendKeys("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
			
			//uploadFile("C:\\github\\CAT_fx_integration\\CAT_integration\\resource\\images\\" + image + ".jpg");
			
			Thread.sleep(60000);
			
			Log.info("uploaded background image");
			
			String success = driver.findElement(By.id("tab-desktop-hover-image")).getAttribute("src");
			
			if (success.contains(image))
				Log.pass("verified the background image uploaded");
			
			typeTextByXpath(".//*[@id='tab3']/div[1]/div[2]/div[1]/input", "test " + d.toString());
		}
		
		catch(Exception e){
			throw e;
		}
	}
	
	/**
	 * Navigate to coures features tab while editing a course
	 * @throws Exception
	 */
	static public void navigateToCourseFeaturesTab() throws Exception
	{
		try
		{
			clickIdentifierXpath(".//*[@id='menuTabs']/ul/li[5]");
		}
		
		catch(Exception e){
			throw e;
		}
	}
	
	/**
	 * Navigate to home page of CAT
	 * @throws Exception
	 */
	static public void navigateHome() throws Exception
	{
		try
		{
			clickIdentifierXpath("//ul[@class='nav navbar-nav nav-pills pull-right']/li[2]/a");
            
            clickIdentifierXpath(".//*[@id='homeDropDown']/a/span");
            Log.info("navigated to home page");
		}
		
		catch(Exception e){
			throw e;
		}
	}
	
	/**
	 * Get a random image to upload, to add more images add to the end of the array in this method
	 * @return returns a random image name, make sure to add path and extension around it
	 * @throws InterruptedException 
	 */
	static public String getRandomImage() throws InterruptedException
	{
		String [] arr = {"Hydrangeas", "bns999_p18", "Penguins", "Chrysanthemum", "Desert", "Tulips", "Lighthouse", "Koala"};
		Random r = new Random();
		
		int select = r.nextInt(arr.length);
		
		System.out.println("Random image selected: " + arr[select]);
		
		//Thread.sleep(30000);
		
		return arr[select];
	}
	
	/**
	 * Get a random hot spot image to upload, to add more hot spot images add to the end of the array in this method.  Make sure the image is small enough to be considered a hot spot image otherwise preview will fail
	 * @return returns a random image name, make sure to add path and extension around it
	 */
	static public String getRandomHotSpotImage()
	{
		String [] arr = {"venicewin", "venicecan", "gondala_pole"};
		Random r = new Random();
		
		int select = r.nextInt(arr.length);
		
		System.out.println("Random hot spot image selected: " + arr[select]);
		
		return arr[select];
	}
	
	/**
	 * Get a random audio to upload, to add more audio files add to the end of the array in this method
	 * @return returns a random audio name, make sure to add path and extension around it
	 * @throws InterruptedException 
	 */
	static public String getRandomAudio() throws InterruptedException
	{
		String [] arr = {"Ambianica", "FunkyDiva", "l1p01_1", "NewAgeTechno", "SaxyGroovy", "TechJam", "ThatAintRight"};
		Random r = new Random();
		
		int select = r.nextInt(arr.length);
		
		System.out.println("Random audio selected: " + arr[select]);
		
		//Thread.sleep(3000);
		
		return arr[select];
	}
	
	public static void previewPage(String template) throws Exception
	{
		try
		{
					
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollTo(0,0)", "");
			
			String pageNum = "";
			
			if (template == "old")
				pageNum = driver.findElement(By.xpath(".//*[@id='masterPage']/div[1]/div[2]/div[2]/label[2]")).getText();
			
			else if (template == "new")
				pageNum = driver.findElement(By.xpath(".//*[@id='masterPage']/div/div[1]/div/div[6]/label")).getText();

			System.out.println("the current page number is: " + pageNum);
			
			Log.startTestCase("Start previewing page: " + pageNum);
			
			Thread.sleep(3000);
			
			clickIdentifierXpath(".//*[@id='courseTreeOperationIcons']/li[4]");
			
			Thread.sleep(3000);
			
			Set<String> courseWindow = driver.getWindowHandles();
			System.out.println("count of windows open is: "  +courseWindow.size());
			System.out.println(courseWindow);
			Thread.sleep(2000);
			Iterator<String> ite1=courseWindow.iterator();
			//System.out.println("Title-------"+driver.switchTo().window(ite.next()));
			Thread.sleep(2000);
			String Mainwindow = ite1.next(); // window id of main CAT window
			String courseWindow1 = ite1.next();
			String thirdWindow = null;
			
			int windowCount = courseWindow.size();
			
			Thread.sleep(30000);
        
			if (windowCount == 3)
			{
				thirdWindow = ite1.next();
				driver.switchTo().window(thirdWindow);
			}

			else
				driver.switchTo().window(courseWindow1); //Switch to course window
			
			Log.info("switched to course window");
			Thread.sleep(5000);
			
			GenericTemplateMethods.catPreviewJumptToPage(pageNum);
			
			driver.close();
			
			//driver.switchTo().window(courseWindow1).close();
			
			if (windowCount == 3)
				driver.switchTo().window(courseWindow1);
			else
				driver.switchTo().window(Mainwindow);
			
			Log.pass("finised preview page and switched back to CAT");
			
			Thread.sleep(5000);
		}
		
		catch(Exception e){
			throw e;
		}
	}
	

	void makeDirectory() throws ParseException, IOException
	{
		try{
			System.out.println("Capturing Snapshot");
			Calendar currentDate = Calendar.getInstance();
			java.io.File currentDir = new java.io.File("");		        
			String workingDirectory = System.getProperty("user.dir");
			//get today's date without Time stamp
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			Date today = dateFormat.parse(dateFormat.format(new Date()));
			String todaysDate = dateFormat.format(today).replace("/", "_");

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MMM/dd HH:mm:ss");
			//Get Full Class name 
			String fullClassName = Thread.currentThread().getStackTrace()[2].getClassName();
			//Get Method name 
			String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
			//Get Class short name 
			int firstChar = fullClassName.lastIndexOf('.') +1; 
			String className = fullClassName.substring(firstChar);
			String dateN = formatter.format(currentDate.getTime()).replace("/","_");
			String dateNow = dateN.replace(":","_");
			//			System.out.println("printing datenow---------"+dateNow);
			String strAppPath = currentDir.getAbsolutePath()+ "/testresult/reports"+"_"+dateNow;
			//	String strAppPath = currentDir.getAbsolutePath();

			String fileName = strAppPath +"/"+"PartnerPortalReport"+"_"+dateNow+".html"; 
			System.out.println("html location-----------------"+fileName);
			//			String fileName = dateNow+".png"; 
			String snapShotDirectory = strAppPath;
			System.out.println("Im here-------------"+snapShotDirectory);
			File f = new File(snapShotDirectory);
			//check for snapshot having folder with today date if not then create one
			if(f.exists()){
				System.out.println("SnapshotDirectory Already Exists");
			}
			else{
				f.mkdir();
				File file=new File(fileName);
				BufferedWriter bw = new BufferedWriter(new FileWriter(file));
				/*bw.write("<html></html>");*/
				bw.close();
				System.out.println("Created Directory");
			
			}		        
			String path = f.getAbsolutePath() + "/" + fileName ;
			//			System.out.println("Path------------------"+path);
		} catch(Exception e)
		{
			throw e;
		}
	}



	public <C> C getObject(Class<C> c) throws Exception 
	{ 
		return c.newInstance(); 
	}

	/*public static String className()
	{
		return class.getName();

	}*/

	@AfterTest
	public void endClass() throws Exception
	{

		String chromeDriverPath="C:\\Jenkins\\workspace\\CAT_fx_integration-master\\resource\\drivers\\chromedriver.exe";	
	//	C:\Users\megha.thombre\Desktop\eclipse\CAT_fx_integration\\CAT_integration
		System.setProperty("webdriver.chrome.driver",chromeDriverPath);
		driver=new ChromeDriver();
		System.out.println("Opening Report +++++++++++++");
		driver.get("C:\\Jenkins\\workspace\\CAT_fx_integration-master\\CATExecutionReport.html");
		driver.manage().window().maximize();

	}

	// FOE NODE KIT

	public  String captureScreenshot3(WebDriver driver,String screenShotname) throws AWTException 
	{

		//	System.getProperty("user.dir")+"\\"+folderName+"\\"+fileName
		String desr=System.getProperty("user.dir")+"\\"+"screenshots"+ "\\"+ screenShotname+".png";

		try {
			Robot robot = new Robot();
			BufferedImage screenShot = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			ImageIO.write(screenShot, "JPG", new File(desr));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("screenshot Taken");
		return desr;

	}


	public String getMostRecentlyUpdated()
	{
		ResultSet mostRecentlyUpdated = null; 
		String value = null;

		try
		{ 
			mostRecentlyUpdated = getStmt().executeQuery(query); 
			System.out.println(mostRecentlyUpdated);		

			while(mostRecentlyUpdated.next())
			{

				value = mostRecentlyUpdated.getString("catalog_id");

				//	System.out.println("xxxxxxxxx" +value);
				//	count --;
			}

			//	strElement.getgetString("catalog_id");
		}
		catch(Exception e)
		{
			e.printStackTrace(); 
		}
		return value;  
	}


	/*	public static void launchBrowser(String browser) throws Exception
	{
		//DOMConfigurator.configure(logs);
	//	Log.info("# # # # # # # # # # # # # # # # # # # # # # # # # # # ");
		try{
			if (browser.equalsIgnoreCase("firefox"))
			{
				getFFDriver();
				Log.info("Exceuting on FireFox");
				System.out.println(" Executing on FireFox");
				driver = new FirefoxDriver();
				driver.get(URL);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
			}
			else if (browser.equalsIgnoreCase("chrome"))
			{
				getChromeDriver();
				Log.info("Executing on Chrome");
				System.out.println(" Executing on CHROME");
				System.out.println("Executing on IE");
				System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
				driver = new ChromeDriver();
				driver.get(URL);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
			}
			else if (browser.equalsIgnoreCase("ie"))
			{
				getIEDriver();
				Log.info("Executing on Internet Explorer");
				System.out.println("Executing on IE");
				System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				driver.get(URL);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().window().maximize();
			}
			else
			{
				throw new IllegalArgumentException("The Browser Type is Undefined");
			} 
		}
		catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}

	 */

}
