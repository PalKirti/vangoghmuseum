package com.gerimedica.utility;

import com.gerimedica.interfaces.IconfigReader;
import org.openqa.selenium.WebDriver;
import java.util.LinkedHashMap;
import java.util.Map;


public class ObjectRepo {
	
	public static WebDriver driver;
	public static IconfigReader reader;
	public static Map<String, Object> data = new LinkedHashMap<String, Object>();
	
}

