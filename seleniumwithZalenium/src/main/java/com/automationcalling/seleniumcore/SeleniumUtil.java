package com.automationcalling.seleniumcore;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;

public class SeleniumUtil{
	
    private WebDriver driver;

    public WebDriver returnDriver(String browserType,String executionType) throws IOException {
        DriverFactory driverFactory = new DriverFactory();
        driver=driverFactory.getBrowserInit(browserType, executionType);
        return driver;
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void closeBrowser() {
        try {
            if (driver != null)
                driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void clickOn(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}

