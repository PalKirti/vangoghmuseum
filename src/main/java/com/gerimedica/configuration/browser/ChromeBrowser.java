package com.gerimedica.configuration.browser;

import com.gerimedica.utility.DateTimeHelper;
import com.gerimedica.utility.ResourceHelper;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;


public class ChromeBrowser {

	/**
	 * Set chromeoptions and add required arguments
	 * @return ChromeOptions instance
	 */
	public ChromeOptions getChromeCapabilities() {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		option.addArguments("--enable-javascript");
		return option;
	}

	/**
	 * set ChromeDriver property
	 * @param cap
	 * @return ChromeDriver instance
	 */
	public WebDriver getChromeDriver(ChromeOptions cap) {
		System.setProperty("webdriver.chrome.driver",
				ResourceHelper.getResourcePath("driver/chromedriver.exe"));
		System.setProperty("webdriver.chrome.logfile",
				ResourceHelper.getResourcePath("logs/chromelogs/")
						+ "chromelog" + DateTimeHelper.getCurrentDateTime()
						+ ".log");
	return new ChromeDriver(cap);
	}

	/**
	 * Instantiate remote webdriver
	 * @param hubUrl
	 * @param cap
	 * @return
	 * @throws MalformedURLException
	 */
	public WebDriver getChromeDriver(String hubUrl,Capabilities cap) throws MalformedURLException {
		return new RemoteWebDriver(new URL(hubUrl), cap);
	}

}
