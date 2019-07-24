package com.automation.pagefactory;

import com.automationcalling.seleniumcore.SeleniumUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.io.IOException;

public class Automationcallinghome extends SeleniumUtil {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='menu-item-35']/a")
    private WebElement articleLink;
    
    private By articleLink1=By.xpath("//*[@id='menu-item-35']/a");

    public Automationcallinghome(String browserType, String executionType) throws IOException {
        this.driver=returnDriver(browserType,executionType);
        //PageFactory.initElements(driver, this);
        System.out.println("maximize");
        maximizeWindow();
    }

    public void clickArticlelink() {
       // articleLink.click();
        driver.findElement(articleLink1).click();
    }

    public void destroyPage() {
        closeBrowser();
    }

    public WebElement returnDynamicXpath(String identifier)
    {
        return driver.findElement(By.xpath("//*[@id=\"menu-item-103\"]/"+identifier+""));
    }

}
