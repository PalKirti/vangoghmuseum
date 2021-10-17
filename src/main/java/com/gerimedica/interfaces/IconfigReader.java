package com.gerimedica.interfaces;


import com.gerimedica.configuration.browser.BrowserType;

/**
 * Abstract methods of all the Object in configuration file
 */
public interface IconfigReader {
	String getWebsite();
	int getPageLoadTimeOut();
	public int getImplicitWait();
	public int getExplicitWait();
	BrowserType getBrowser();

}
