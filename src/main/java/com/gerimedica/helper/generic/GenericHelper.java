package com.gerimedica.helper.generic;


import com.gerimedica.helper.logger.LoggerHelper;
import com.gerimedica.utility.DateTimeHelper;
import com.gerimedica.utility.ResourceHelper;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import java.io.File;
import java.io.IOException;


public class GenericHelper {

	private WebDriver driver;
	private Logger oLog = LoggerHelper.getLogger(GenericHelper.class);

	public GenericHelper(WebDriver driver) {
		this.driver = driver;
		oLog.debug("GenericHelper : " + this.driver.hashCode());
	}

	/**
	 * Create folder if not present and set the file destination path and .jpg format
	 * @param name
	 * @return
	 * @throws IOException
	 */
	public String takeScreenShot(String name) throws IOException {
		File destDir = new File(ResourceHelper.getResourcePath("screenshots/")
				+ DateTimeHelper.getCurrentDate());
		if (!destDir.exists())
			destDir.mkdir();

		File destPath = new File(destDir.getAbsolutePath()
				+ System.getProperty("file.separator") + name + ".jpg");
		try {
			FileUtils
					.copyFile(((TakesScreenshot) driver)
							.getScreenshotAs(OutputType.FILE), destPath);
		} catch (IOException e) {
			oLog.error(e);
			throw e;
		}
		oLog.info(destPath.getAbsolutePath());
		return destPath.getAbsolutePath();
	}

	/**
	 * Obtain the screenshot as base64 data
	 * @return
	 */
/*
	public String takeScreenShot() {
		oLog.info("");
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	}
*/

}
