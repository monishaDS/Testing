package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UtilsPage {
	Properties prop = new Properties();

	public String readPropertyFile(String data) throws IOException {

		FileInputStream fileIo = new FileInputStream("src//test//resources//property//details.properties");
		prop.load(fileIo);
		return prop.getProperty(data);

	}

	public String readCredentials(String data) throws IOException {
		FileInputStream fileIo = new FileInputStream("src//test//resources//property//credentials.properties");
		prop.load(fileIo);
		return prop.getProperty(data);

	}

}
