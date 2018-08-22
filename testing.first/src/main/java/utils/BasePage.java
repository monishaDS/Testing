package utils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BasePage extends UtilsPage {

	public static WebDriver driver;

	@BeforeTest(alwaysRun = true)
	public void setup() throws IOException {
		System.setProperty("webdriver.chrome.driver", "path");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.navigate().to(readPropertyFile("URL"));
		driver.manage().window().maximize();

	}

	@AfterTest(alwaysRun = true)
	public void tearDown() {
		driver.close();
	}

	public void failedTest(String methodName) {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcFile,
					new File("path" + methodName + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
