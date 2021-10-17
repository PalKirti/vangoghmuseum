package com.gerimedica.helper;

import com.gerimedica.configreader.PropertyFileReader;
import com.gerimedica.configuration.browser.*;
import com.gerimedica.exception.NoSutiableDriverFoundException;
import com.gerimedica.helper.generic.GenericHelper;
import com.gerimedica.helper.logger.LoggerHelper;
import com.gerimedica.utility.ObjectRepo;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class InitializeWebDrive {

    private Logger oLog = LoggerHelper.getLogger(InitializeWebDrive.class);


    public InitializeWebDrive(PropertyFileReader reader) {
        ObjectRepo.reader = reader;
    }

    /**
     * Create driver instances of the browser type passed in parameter
     *
     * @param bType is defined in enum BrowserType
     * @return driver instances
     * @throws Exception
     */
    public WebDriver standAloneStepUp(BrowserType bType) throws Exception {
        try {
            oLog.info(bType);

            switch (bType) {

                case Chrome:
                    ChromeBrowser chrome = ChromeBrowser.class.newInstance();
                    	return chrome.getChromeDriver(chrome.getChromeCapabilities());
                   // return chrome.getChromeDriver();

                case Firefox:
                    FirefoxBrowser firefox = FirefoxBrowser.class.newInstance();
                    return firefox.getFirefoxDriver(firefox
                            .getFirefoxCapabilities());


                case Iexplorer:
                    IExploreBrowser iExplore = IExploreBrowser.class.newInstance();
                    return iExplore.getIExplorerDriver(iExplore
                            .getIExplorerCapabilities());


                default:
                    throw new NoSutiableDriverFoundException(" Driver Not Found : "
                            + ObjectRepo.reader.getBrowser());
            }
        } catch (Exception e) {
            oLog.equals(e);
            throw e;
        }
    }

    /**
     * Cucumber hooks that get executed before the execution of every scenario to Setup driver
     *
     * @throws Exception
     */
    @Before
    public void before() throws Exception {
        setUpDriver(ObjectRepo.reader.getBrowser());
        oLog.info(ObjectRepo.reader.getBrowser());

    }

    /**
     * Cucumber hooks that get executed After the execution of every scenario to close the driver
     *
     * @param scenario , scenario is defined in .feature file
     * @throws Exception
     */
    @After
    public void after(Scenario scenario) throws Exception {
        tearDownDriver(scenario);
        oLog.info("");
    }

    /**
     * set pageLoadTimeout and Implicit wait limits, wait for page to be loaded before throwing an exception
     *
     * @param bType, is an enum defined in BrowserType
     * @throws Exception
     */
    public void setUpDriver(BrowserType bType) throws Exception {
        ObjectRepo.driver = standAloneStepUp(bType);
        oLog.debug("InitializeWebDrive : " + ObjectRepo.driver.hashCode());
        ObjectRepo.driver
                .manage()
                .timeouts()
                .pageLoadTimeout(ObjectRepo.reader.getPageLoadTimeOut(),
                        TimeUnit.SECONDS);
        ObjectRepo.driver
                .manage()
                .timeouts()
                .implicitlyWait(ObjectRepo.reader.getImplicitWait(),
                        TimeUnit.SECONDS);
        ObjectRepo.driver.manage().window().maximize();

    }

    /**
     * Captures screenshot if scenario is failed and close the all the browser
     *
     * @param scenario
     * @throws Exception
     */
    public void tearDownDriver(Scenario scenario) throws Exception {
        try {
            if (ObjectRepo.driver != null) {

                if (scenario.isFailed() == true)
                    scenario.write(new GenericHelper(ObjectRepo.driver).takeScreenShot(scenario.getName()));

                ObjectRepo.driver.quit();
                ObjectRepo.reader = null;
                ObjectRepo.driver = null;
                oLog.info("Shutting Down the driver");
            }
        } catch (Exception e) {
            oLog.error(e);
            throw e;
        }
    }

}
