package edw.edw.frameLib;

import org.testng.annotations.AfterMethod;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.remote.CapabilityType.ForSeleniumServer;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;

import java.net.URL;

public class Driver {

	/* Designed By Mehr */

	protected WebDriver driver;
	protected static WebDriver listenerDriver;
	public static List<String> browsers= new ArrayList<String>();
	public static List<String> browserVersions=new ArrayList<String>();
	protected String appURL;
	protected String mainWindowHandle;
	public static Connection connection;
	public static Statement stmt;
	public static ResultSet resultSet;
	public static String appUrl;
	public int time = 30;
	public static final String USERNAME = "mehrajsheik1";
	public static final String AUTOMATE_KEY = "7jQSNFSLoksmUVbezbio";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub.browserstack.com/wd/hub";

	@BeforeMethod
	@Parameters({ "browser", "url", "subStringURL", "maxWaitTimeToPOLLElement", "maxWaitTimeToFindElement",
			"operatingSystemType", "deviceType", "BstackBrowser", "BstackBrowserVersion", "BstackOperatingSystem",
			"BstackOperatingSystemVersion" })
	public void Initialize(@Optional("GoogleChrome") String browser,
			@Optional("https://everydaywell.dex.staginghealtheintent.com/pages/home") String url,
			@Optional("/wd/hub") String subStringURL, @Optional("100") int maxWaitTimeToPOLLElement,
			@Optional("150") int maxWaitTimeToFindElement, @Optional("64bit") String operatingSystemType,
			@Optional("desktop") String deviceType, @Optional("Chrome") String bStackBrowser,
			@Optional("63.0") String bStackBrowserVersion, @Optional("Windows") String bStackOperatingSystem,
			@Optional("10") String bStackOperatingSystemVersion) throws MalformedURLException {
		this.appURL = url;
		this.time = maxWaitTimeToFindElement;
		String projectPath = System.getProperty("user.dir"); // dynamic project
																// path
		String geckofilepath, chromeFilePath, operaFilePath, iEFilePath;

		if (operatingSystemType.equalsIgnoreCase("64bit")) {
			geckofilepath = projectPath + "\\resources\\64bit\\geckodriver.exe";
			chromeFilePath = projectPath + "\\resources\\64bit\\chromedriver.exe";
			operaFilePath = projectPath + "\\resources\\64bit\\operadriver.exe";
			iEFilePath = projectPath + "\\resources\\64bit\\IEDriverServer.exe";

		} else {
			geckofilepath = projectPath + "\\resources\\32bit\\geckodriver.exe";
			chromeFilePath = projectPath + "\\resources\\32bit\\chromedriver.exe";
			operaFilePath = projectPath + "\\resources\\32bit\\operadriver.exe";
			iEFilePath = projectPath + "\\resources\\32bit\\IEDriverServer.exe";

		}
		DesiredCapabilities capabilities = new DesiredCapabilities();

		appUrl = url;
		time = maxWaitTimeToFindElement;
		if (deviceType.equalsIgnoreCase("desktop")) {
			// Check the browser type:
			if (browser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", geckofilepath);
				capabilities.setBrowserName("firefox");
				driver = new FirefoxDriver(capabilities);
				Log.info("Gecko Driver Started.");
			} else if (browser.equalsIgnoreCase("GoogleChrome")) {
				System.setProperty("webdriver.chrome.driver", chromeFilePath);
				capabilities = DesiredCapabilities.chrome();
				driver = new ChromeDriver(capabilities);
				Log.info("Google Chrome Driver Started.");
			} else if (browser.equalsIgnoreCase("Opera")) {
				System.setProperty("webdriver.opera.driver", operaFilePath);
				capabilities = DesiredCapabilities.operaBlink();
				driver = new OperaDriver(capabilities);
				Log.info("Opera Driver Started.");
			} else if (browser.equalsIgnoreCase("IE") || browser.equalsIgnoreCase("InternetExplorer")) {
				System.setProperty("webdriver.ie.driver", iEFilePath);
				capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
						true);
				driver = new InternetExplorerDriver(capabilities);

				Log.info("IE Driver Started.");
			} else if(browser.equalsIgnoreCase("safari"))
			{
				capabilities = DesiredCapabilities.safari();
				driver = new SafariDriver(capabilities);
				Log.info("Safari Driver Started.");
			}
			
			else if (browser.equalsIgnoreCase("BS") || browser.equalsIgnoreCase("browserStack")) {
				capabilities.setCapability("os", bStackOperatingSystem);
				capabilities.setCapability("browser", bStackBrowser);
				capabilities.setCapability("browserVersion", bStackBrowserVersion);
				capabilities.setCapability("os_version", bStackOperatingSystemVersion);

				URL browserStackUrl = new URL(URL);

				driver = new RemoteWebDriver(browserStackUrl, capabilities);
			}

			capabilities.setCapability(ForSeleniumServer.PROXYING_EVERYTHING, true);
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
			capabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
			
			Capabilities cpblty = ((RemoteWebDriver) driver).getCapabilities();
			browsers.add(cpblty.getBrowserName());
			browserVersions.add(cpblty.getVersion());

			@SuppressWarnings("unused")
			org.openqa.selenium.Dimension defaultDim;
			@SuppressWarnings("unused")
			org.openqa.selenium.Dimension maximizeDim;
			// Display the current screen dimensions
			defaultDim = driver.manage().window().getSize();

			// Display the maximized window dimensions
			maximizeDim = driver.manage().window().getSize();

		} else {
			startAppiumServer();

			capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
			capabilities.setCapability("deviceName", "66b5250c");
			capabilities.setCapability("platformVersion", "6.0.1");
			capabilities.setCapability("platformName", "Android");

			driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		}
		driver.manage().timeouts().implicitlyWait(maxWaitTimeToPOLLElement, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();

	

//		activeBrowserName = cpblty.getBrowserName();
//		activeBrowserVersion = cpblty.getVersion();
		
		
		

		mainWindowHandle = driver.getWindowHandle();
		System.out.println("Launched new Window with handle:  " + mainWindowHandle);
		// driver.get(appURL);

		PageSetup();

		if (deviceType.equalsIgnoreCase("desktop")) {
			// Maximize the Window
			driver.manage().window().maximize();
		}

		listenerDriver = driver;
	}

	@BeforeSuite
	public void Database() throws Exception {
		try {
			DOMConfigurator.configure("log4j.xml");
			// Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			// connection =
			// DriverManager.getConnection("jdbc:sqlserver://ARLMSAGQA02:10433;user=webusercima;password=webusercima;database=DBS4PORTAL");
			// stmt =
			// connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
			// ResultSet.CONCUR_READ_ONLY);
			Log.info("Environment Configuration Ready");
		} catch (Exception e) {
			e.printStackTrace();
			Log.info("Environment Configuration error");
		}
	}

	public void PageSetup() {
	}

	public void WaitForExecution(Long timeInMicroSeconds) {
		try {
			Thread.sleep(timeInMicroSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void tearDown() throws Exception {
		stopAppiumServer();
	}

	public List<String> browserName() {
		return browsers;
	}

	public String getAppUrl() {
		return appUrl;
	}

	public List<String> browserVersion() {
		return browserVersions;
	}

	@BeforeClass
	public void beforeClass() {

		ReadExcel.setExcelFile("loginApplication");
	}

	@AfterMethod
	public void drop() {
		try {
			driver.quit();
		} catch (Exception e) {
			Log.info("Session already closed.");
		}

	}

	public void startAppiumServer() {
		CommandLine cmd = new CommandLine("C:\\Program Files\\Appium\\node.exe");
		cmd.addArgument("C:\\Program Files\\Appium\\node_modules\\appium\\bin\\Appium.js");
		cmd.addArgument("--address");
		cmd.addArgument("127.0.0.1");
		cmd.addArgument("--port");
		cmd.addArgument("4723");

		DefaultExecuteResultHandler handler = new DefaultExecuteResultHandler();
		DefaultExecutor executor = new DefaultExecutor();
		executor.setExitValue(1);
		try {
			executor.execute(cmd, handler);
			Thread.sleep(10000);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void stopAppiumServer() {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("taskkill /F /IM node.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
