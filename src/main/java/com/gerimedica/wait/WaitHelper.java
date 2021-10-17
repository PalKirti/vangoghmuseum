/**
 * @author rahul.rathore
 *	
 *	06-Aug-2016
 */
package com.gerimedica.wait;


import com.gerimedica.helper.generic.GenericHelper;
import com.gerimedica.helper.javascript.JavaScriptHelper;
import com.gerimedica.helper.logger.LoggerHelper;
import com.gerimedica.interfaces.IconfigReader;
import com.gerimedica.utility.ObjectRepo;
import com.google.common.base.Function;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;


public class WaitHelper extends GenericHelper {
//public class WaitHelper {
	
	private WebDriver driver;
	private IconfigReader reader;
	private Logger oLog = LoggerHelper.getLogger(WaitHelper.class);

	public WaitHelper(WebDriver driver, IconfigReader reader) {
		super(driver);
		this.driver = driver;
		this.reader = reader;
		oLog.debug("WaitHelper : " + this.driver.hashCode());
	}


	public void setImplicitWait(long timeout,TimeUnit unit) {
		oLog.info(timeout);
		driver
		.manage()
		.timeouts()
		.implicitlyWait(timeout, unit == null ? TimeUnit.SECONDS : unit);
	}
	
	public void waitForElementVisible(WebElement element) {
		oLog.info(element);
		WebDriverWait wait = new WebDriverWait(ObjectRepo.driver,ObjectRepo.reader.getExplicitWait());
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void hardWait(int timeOutInMiliSec) throws InterruptedException {
		oLog.info(timeOutInMiliSec);
		Thread.sleep(timeOutInMiliSec);
	}


}
