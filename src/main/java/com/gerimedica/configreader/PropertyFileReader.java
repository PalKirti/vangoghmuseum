package com.gerimedica.configreader;

import com.gerimedica.configuration.browser.BrowserType;
import com.gerimedica.interfaces.IconfigReader;
import com.gerimedica.utility.ResourceHelper;

import java.util.Properties;

public class PropertyFileReader implements IconfigReader {

    private Properties prop = null;

    /**
     * load config.properties
     */
    public PropertyFileReader() {
        prop = new Properties();
        try {
            prop.load(ResourceHelper
                    .getResourcePathInputStream("configfile/"
                            + "config.properties"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * get Website url from config.properties file
     *
     * @return website url
     */
    public String getWebsite() {
        return prop.getProperty("Website");
    }

    /**
     * get PageLoadTimeOut value from config.properties file
     *
     * @return PageLoadTimeOut
     */
    public int getPageLoadTimeOut() {
        return Integer.parseInt(prop.getProperty("PageLoadTimeOut"));
    }

    /**
     * get Browser value from config.properties file
     *
     * @return Browsertype value
     */
    public BrowserType getBrowser() {
        return BrowserType.valueOf(prop.getProperty("Browser"));
    }

    /**
     * get ImplcitWait value from config.properties file
     *
     * @return ImplcitWait time
     */
    public int getImplicitWait() {
        return Integer.parseInt(prop.getProperty("ImplcitWait"));
    }

    /**
     * get ExplicitWait value from config.properties file
     *
     * @return ExplicitWait time
     */
    public int getExplicitWait() {
        return Integer.parseInt(prop.getProperty("ExplicitWait"));
    }
}
