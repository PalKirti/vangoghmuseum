package com.gerimedica.helper.logger;

import com.gerimedica.utility.ResourceHelper;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class LoggerHelper {

    private static boolean root = false;

    /**
     * configure property configurator for logging
     *
     * @param clas
     * @return Logger class instance
     */
    public static Logger getLogger(Class clas) {
        if (root)
            return Logger.getLogger(clas);

        PropertyConfigurator.configure(ResourceHelper
                .getResourcePath("configfile/log4j.properties"));
        root = true;
        return Logger.getLogger(clas);
    }

}
