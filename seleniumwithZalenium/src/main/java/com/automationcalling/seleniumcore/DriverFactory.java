package com.automationcalling.seleniumcore;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.IOException;
import java.net.URL;

import static com.automationcalling.commonutil.Utils.returnProperties;

public class DriverFactory {
    WebDriver driver;
    DesiredCapabilities caps;
    public  String USERNAME = "suryakiran14";
    public  String AUTOMATE_KEY = "TWtczMYygyckEgLGz6ND";
    public String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    public WebDriver getBrowserInit(String browserType, String executionType) throws IOException {
        if (executionType.equalsIgnoreCase("remote")) {      	
            initializeRemoteDriver(browserType);
        } else if (executionType.equalsIgnoreCase("local")) {
            initializeLocalDriver(browserType);
        } else if (executionType.equalsIgnoreCase("cloud")) {
            initializeCloudDriver(browserType);
        }
        return driver;
    }

    public void initializeRemoteDriver(String browserType) throws IOException {
        if (browserType.equalsIgnoreCase("chrome")) {
          /*  caps = DesiredCapabilities.chrome();*/
        	FirefoxOptions options = new FirefoxOptions();
            System.out.println("chrome");
            driver = new RemoteWebDriver(new URL("http://192.168.1.191:4444/grid/console"), options);
        } else if (browserType.equalsIgnoreCase("firefox")) {
           /* caps = DesiredCapabilities.firefox();*/
            ChromeOptions options = new ChromeOptions();
            System.out.println("firefox");
            driver = new RemoteWebDriver(new URL("http://192.168.1.191:4444/grid/console"), options);
        }

      
        System.out.println("url");
        driver.get("https://automationcalling.com");
        System.out.println("url");
    }

    public void initializeCloudDriver(String browserType) throws IOException {
        if (browserType.equalsIgnoreCase("chrome")) {
            caps = DesiredCapabilities.chrome();
        } else if (browserType.equalsIgnoreCase("firefox")) {
            caps = DesiredCapabilities.firefox();
        } else if (browserType.equalsIgnoreCase("safari")) {
           /* caps = DesiredCapabilities.safari();
            caps.setCapability("platformName", "ANY");
            caps.setCapability("browserName", "safari");
            caps.setCapability("version", "latest");*/
        	System.out.println("safari");
        	caps = new DesiredCapabilities();
            caps.setCapability("browser", "Safari");
            caps.setCapability("browser_version", "12.0");
            caps.setCapability("os", "OS X");
            caps.setCapability("os_version", "Mojave");
            caps.setCapability("resolution", "1024x768");
            caps.setCapability("name", "Bstack-[Java] Sample Test");
        }
        driver =new RemoteWebDriver(new URL(URL), caps);
        driver.get("https://automationcalling.com");
    }


    public void initializeLocalDriver(String browserType) throws IOException {
        if (browserType.equalsIgnoreCase("chrome")) {
        	System.out.println("chrome");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            System.out.println("chrome1");
        } else if (browserType.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else if (browserType.equalsIgnoreCase("ie")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }else if (browserType.equalsIgnoreCase("edge")) {
        	System.out.println("edge");
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            System.out.println("edge");
        }else if (browserType.equalsIgnoreCase("headless"))
        	driver= new HtmlUnitDriver();       
        System.out.println("chrome2");
       // System.out.println("AppURL "+returnProperties("AppURL"));
        driver.get("https://automationcalling.com");
    }

}
