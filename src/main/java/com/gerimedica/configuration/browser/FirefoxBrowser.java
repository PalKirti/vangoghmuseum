package com.gerimedica.configuration.browser;
import com.gerimedica.utility.ResourceHelper;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class FirefoxBrowser {
	/**
	 * Set capabilities to FirefoxOptions
	 *
	 * @return FirefoxOptions Instance
	 */
	public FirefoxOptions getFirefoxCapabilities() {
		DesiredCapabilities firefox = DesiredCapabilities.firefox();
		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(true);
		firefox.setCapability(FirefoxDriver.PROFILE, profile);
		firefox.setCapability("marionette", true);
		FirefoxOptions firefoxOptions = new FirefoxOptions(firefox);
		return firefoxOptions;
	}

	/**
	 * set FirefoxDriver property
	 * @param cap
	 * @return FirefoxDriver instance
	 */
	public WebDriver getFirefoxDriver(FirefoxOptions cap) {
		System.setProperty("webdriver.gecko.driver", ResourceHelper.getResourcePath("driver/geckodriver.exe"));
		return new FirefoxDriver(cap);
	}

	/**
	 * Instantiate remote webdriver
	 * @param hubUrl
	 * @param cap
	 * @return
	 * @throws MalformedURLException
	 */
	public WebDriver getFirefoxDriver(String hubUrl,Capabilities cap) throws MalformedURLException {
		return new RemoteWebDriver(new URL(hubUrl),cap);
	}

}
