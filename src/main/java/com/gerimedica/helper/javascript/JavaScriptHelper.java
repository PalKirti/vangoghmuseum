/**
 * rsr 
 *
 *Aug 6, 2016
 */
package com.gerimedica.helper.javascript;


import com.gerimedica.helper.logger.LoggerHelper;
import com.gerimedica.interfaces.IconfigReader;
import com.gerimedica.utility.ObjectRepo;
import com.gerimedica.wait.WaitHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class JavaScriptHelper{

	private WebDriver driver;
	private Logger oLog = LoggerHelper.getLogger(JavaScriptHelper.class);
	private WaitHelper waitHelper =new WaitHelper(ObjectRepo.driver,ObjectRepo.reader);

	public JavaScriptHelper(WebDriver driver) {
		this.driver = driver;
		oLog.debug("JavaScriptHelper : " + this.driver.hashCode());
	}



	public Object executeScript(String script, Object... args) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		oLog.info(script);
		return exe.executeScript(script, args);
	}

	public void scrollToElemet(WebElement element) {
		executeScript("window.scrollTo(arguments[0],arguments[1])",
				element.getLocation().x, element.getLocation().y);
		oLog.info(element);
	}

	public void scrollToElemetAndClick(WebElement element) throws InterruptedException {
		scrollToElemet(element);
		//waitHelper.hardWait(5000);
		waitHelper.waitForElementVisible(element);
		element.click();
		oLog.info(element);
	}




}
