package sk.amokk.imagesorter.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHandle {
	
	private static String DEF_PROP_FILE = "default.properties";
	private static String APP_PROP_FILE = "application.properties";
	
	private static Properties defProp = new Properties();
	private static Properties appProp = new Properties(defProp);
	
	public static Properties properties;
	
	private PropertiesHandle() {}
	
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
			propFile = new FileInputStream(DEF_PROP_FILE);
			defProp.load(propFile);
			propFile.close();
			
			// now load properties from last invocation
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


