package com.gerimedica.helper.pageobject;


import com.gerimedica.helper.logger.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PageBase {

    private final Logger log = LoggerHelper.getLogger(PageBase.class);
    private WebDriver driver;

    /**
     * Checks if driver instance is not null then
     * initialize WebElement with a reference to a corresponding element on the webpage based on “locators”
     *
     * @param driver
     */
    public PageBase(WebDriver driver) {
        if (driver == null)
            throw new IllegalArgumentException("Driver object is null");
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
        this.driver = driver;
    }

    /**
     * Compare pagetitle with the actual title pass in parameter
     *
     * @param title
     * @return true if title match of false if mismatch
     */
    public boolean checkForTitle(String title) {
        log.info(title);
        if (title == null || title.isEmpty())
            throw new IllegalArgumentException(title);
        return driver.getTitle().trim().equalsIgnoreCase(title);
    }

    /**
     * Accept or reject website cookies
     *
     * @param cookies
     * @return true if webelement is not null and displayed else return false
     */
    public boolean cookies(WebElement cookies) {
        try {
            if (!(cookies == null) || cookies.isDisplayed())
                cookies.click();
            log.info("Cookies are accepted");
            return true;
        } catch (Exception e) {
            log.info("WebElement to accept cookies is not found");
            e.printStackTrace();
            return false;
        }
    }
}
