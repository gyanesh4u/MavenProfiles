package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	protected WebDriver driver;
	protected String env;
	protected String browser;

	@BeforeMethod
	public void setUp() {
		// Read properties based on Maven profile

		env = System.getProperty("env", "qa");// set default as qa if no environment is set.
		browser = System.getProperty("browser", "chrome");// default browser is chrome.

		switch (browser.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;

		case "safari":
			driver = new SafariDriver();
			break;

		default:
			driver = new ChromeDriver();
		}

		// Set baseURL based on environment.
		String url;

		switch (env.toLowerCase()) {
		case "dev":
			url = "https://asacentraldev.asacore.com/";
			break;

		case "qa":
			url = "https://asacentralqa.asacore.com/";
			break;
		case "uat":
			url = "https://asacentraluat.asacore.com/";
			break;
		case "prod":
			url = "https://asacentral.asacore.com/";
			break;

		default:
			url = "https://asacentralqa.asacore.com/";
			break;
		}
		driver.manage().window().maximize();
		driver.get(url);

	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
