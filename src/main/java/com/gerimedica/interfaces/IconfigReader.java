package com.gerimedica.interfaces;


import com.gerimedica.configuration.browser.BrowserType;

public interface IconfigReader {
	String getWebsite();
	int getPageLoadTimeOut();
	public int getImplicitWait();
	public int getExplicitWait();
	BrowserType getBrowser();

}
