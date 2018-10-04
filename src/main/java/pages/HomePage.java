package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePage {
	public WebDriver driver;

	public void launchBrowser(String browser) {
		if (browser.contains("mozilla")) {
			System.setProperty("webdriver.gecko.driver",
					"D:\\OnBench\\drivers\\geckodriver-v0.22.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browser.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\OnBench\\drivers\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.contains("explorer")) {
			System.setProperty("webdriver.ie.driver",
					"D:\\OnBench\\drivers\\IEDriverServer_x64_3.14.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			System.out.println("Invalid Choice");
		}
	}

	public void openApplication() throws InterruptedException {
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		String baseUrl = "https://www.google.com/";
		driver.get(baseUrl);
	}

	public void closeDriver() {
		driver.close();

	}

	@Test(groups = { "test" })
	@Parameters("browser")
	public void test(String browser) throws InterruptedException {
		launchBrowser(browser);
		openApplication();
		closeDriver();
	}
}
