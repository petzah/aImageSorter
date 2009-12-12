package sk.amokk.imagesorter.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import sk.amokk.imagesorter.ImageSorter;

public class PropertiesHandler {
	
	private static File APP_PROP_FILE = new File("application.properties");
	private static InputStream defaultProperties = ImageSorter.class.getResourceAsStream("/resources/properties/default.properties");
	
	
	private static Properties defProp = new Properties();
	private static Properties appProp = new Properties(defProp);
	
	public static Properties properties;
	
	private PropertiesHandler() {}
	
	public static void store() {
		FileOutputStream out;
		try {
			out = new FileOutputStream(APP_PROP_FILE);
			appProp.store(out, "---No Comment---");
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void load() {
		
		FileInputStream propFile;
		try {
			defProp.load(defaultProperties);
			
			// now load properties from last invocation
			APP_PROP_FILE.createNewFile(); //if program is runned first time, create file
			propFile = new FileInputStream(APP_PROP_FILE);
			appProp.load(propFile);
			propFile.close();
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		properties = appProp;
	}


}


