package com.gerimedica.configreader;

import com.gerimedica.configuration.browser.BrowserType;
import com.gerimedica.interfaces.IconfigReader;
import com.gerimedica.utility.ResourceHelper;
import java.util.Properties;

public class PropertyFileReader implements IconfigReader {

    private Properties prop = null;

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

    public String getWebsite() {
        return prop.getProperty("Website");
    }

    public int getPageLoadTimeOut() {
        return Integer.parseInt(prop.getProperty("PageLoadTimeOut"));
    }

    public BrowserType getBrowser() {
        return BrowserType.valueOf(prop.getProperty("Browser"));
    }
    public int getImplicitWait() {
        return Integer.parseInt(prop.getProperty("ImplcitWait"));
    }

    public int getExplicitWait() {
        return Integer.parseInt(prop.getProperty("ExplicitWait"));
    }
}
