package com.gerimedica.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ResourceHelper {

	/**
	 * creates resource path from the root directory
	 * @param resource
	 * @return path of the resource passed
	 */
	public static String getResourcePath(String resource) {
		String path = System.getProperty("user.dir")+"/src/main/resources/" + resource;
		return path;
	}


	/**
	 * Read stream of data of the resource file
	 * @param resource
	 * @return an Instance of InputStream of the filepath
	 * @throws FileNotFoundException
	 */
	public static InputStream getResourcePathInputStream(String resource) throws FileNotFoundException {
		return new FileInputStream(ResourceHelper.getResourcePath(resource));
	}

	
}
