
package com.gerimedica.configuration.browser;

import com.gerimedica.utility.DateTimeHelper;
import com.gerimedica.utility.ResourceHelper;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.ElementScrollBehavior;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;


public class IExploreBrowser {
    /**
     * Set capabilities to InternetExplorerOptions
     *
     * @return InternetExplorerOptions Instance
     */
    public InternetExplorerOptions getIExplorerCapabilities() {
        DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
        cap.setCapability(InternetExplorerDriver.ELEMENT_SCROLL_BEHAVIOR,
                ElementScrollBehavior.BOTTOM);
        cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        cap.setCapability(
                InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
                true);
        cap.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
        cap.setJavascriptEnabled(true);
        InternetExplorerOptions options = new InternetExplorerOptions(cap);
        return options;
    }

    /**
     * set InternetExplorerDriver property
     *
     * @param opt
     * @return InternetExplorerDriver with capabilities set
     */
    public WebDriver getIExplorerDriver(InternetExplorerOptions opt) {
        System.setProperty("webdriver.ie.driver", ResourceHelper.getResourcePath("driver/IEDriverServer.exe"));
        System.setProperty("webdriver.ie.driver.logfile", ResourceHelper.getResourcePath("logs/iexplorerlogs/") + "ielog" + DateTimeHelper.getCurrentDateTime() + ".log");
        return new InternetExplorerDriver(opt);
    }

    /**
     * return remote driver instance, not used in this project
     *
     * @param hubUrl
     * @param cap
     * @return
     * @throws MalformedURLException
     */
    public WebDriver getIExplorerDriver(String hubUrl, Capabilities cap) throws MalformedURLException {
        return new RemoteWebDriver(new URL(hubUrl), cap);
    }

}
