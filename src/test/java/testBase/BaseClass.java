package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.module.Browser;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;   //log4j

public class BaseClass {
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	@Parameters({"os", "browser"})
	@BeforeClass(groups= {"Sanity", "Regression", "Master"})
	public void Setup(String os, String br) throws IOException {
		FileReader File = new FileReader("./src//test//resources//config.properties");
		p = new Properties();
		p.load(File);
		logger = LogManager.getLogger(this.getClass());
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote")) {
			DesiredCapabilities Cap = new DesiredCapabilities();
			
			if(os.equalsIgnoreCase("Windows")) {
				Cap.setPlatform(Platform.WIN11);
			}
			else if (os.equalsIgnoreCase("Mac")) {
				Cap.setPlatform(Platform.MAC);
			}
			else if (os.equalsIgnoreCase("Linux")) {
				Cap.setPlatform(Platform.LINUX);
			}
			else {
				System.out.println("Given OS is not exist");
				return;
			}
			switch (br.toLowerCase()) {
			case "chrome": Cap.setBrowserName("chrome");break;
			case "edge": Cap.setBrowserName("MicrosoftEdge");break;
			case "firefox": Cap.setBrowserName("firefox");break;
			default:System.out.println("Invalid Browser");return;
			}
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), Cap);
		}
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local")) {
			switch (br.toLowerCase()) {
			case "chrome": driver = new ChromeDriver(); break;
			case "edge": driver = new EdgeDriver(); break;
			default: System.out.println("Invalid browser name"); return;
			}
		}
		
		driver.manage().deleteAllCookies();
		driver.get(p.getProperty("appURL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	}
	   @AfterClass(groups= {"Sanity", "Regression", "Master"})
	   public void tearDown() {
	       driver.quit();
	   }
	
	public String randomString() {
		String GeneratedString = RandomStringUtils.randomAlphabetic(5);
		return GeneratedString;
	}
	public String randomalphanum() {
		String Generatedalphanum = RandomStringUtils.randomAlphanumeric(6);
		return Generatedalphanum;
	}
	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\Screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}
}
