package com.gerimedica.helper.pageobject;

import com.gerimedica.helper.javascript.JavaScriptHelper;
import com.gerimedica.helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class HomePage extends PageBase{

    private WebDriver driver;
    private final Logger log = LoggerHelper.getLogger(HomePage.class);
     JavaScriptHelper javascripthelper;

    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    @FindBy(how= How.XPATH,using="//a[contains(text(),'Ontdek de collectie')]")
  //@FindBy(how= How.XPATH,using="//font[contains(text(),'Discover the collection')]//ancestor::a")
    public WebElement discoverCollectionLink;

    @FindBy(how= How.CSS,using="button.scroll-indicator-button:last-of-type")
    public WebElement scrollRight;

    @FindBy(how= How.CSS,using="button.cookie-banner-button.btn-transparent")
    public WebElement rejectCookies;

    public void acceptOrRejectCookies(){
        cookies(rejectCookies);
    }

    public void discoverCollection(String discoverlink) throws InterruptedException {
        javascripthelper = new JavaScriptHelper(driver);
        javascripthelper.scrollToElemetAndClick(discoverCollectionLink);
        discoverCollectionLink.click();
        log.info(discoverlink);
    }

}
