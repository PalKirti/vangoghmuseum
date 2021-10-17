package com.gerimedica.helper.javascript;


import com.gerimedica.helper.logger.LoggerHelper;
import com.gerimedica.utility.ObjectRepo;
import com.gerimedica.wait.WaitHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class JavaScriptHelper {

    private WebDriver driver;
    private Logger oLog = LoggerHelper.getLogger(JavaScriptHelper.class);
    private WaitHelper waitHelper = new WaitHelper(ObjectRepo.driver, ObjectRepo.reader);

    public JavaScriptHelper(WebDriver driver) {
        this.driver = driver;
        oLog.debug("JavaScriptHelper : " + this.driver.hashCode());
    }


    /**
     * execute javascript on the script and arguments passed in parameter
     *
     * @param script
     * @param args
     * @return
     */
    public Object executeScript(String script, Object... args) {
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        oLog.info(script);
        return exe.executeScript(script, args);
    }

    /**
     * get the webelement x and y location passed in parameter and scroll
     *
     * @param element
     */
    public void scrollToElemet(WebElement element) {
        executeScript("window.scrollTo(arguments[0],arguments[1])",
                element.getLocation().x, element.getLocation().y);
        oLog.info(element);
    }

    /**
     * Scroll to the element passed in param and click on that element
     *
     * @param element
     * @throws InterruptedException
     */
    public void scrollToElemetAndClick(WebElement element) throws InterruptedException {
        scrollToElemet(element);
        waitHelper.waitForElementVisible(element);
        element.click();
        oLog.info(element);
    }


}
