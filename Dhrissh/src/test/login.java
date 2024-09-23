package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class login {
	
	@BeforeTest
	public void webdriverSetup()  {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\NewChromedriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.leafground.com/input.xhtml");
		//driver.manage().window().maximize();
	}
	
	@Test
	public void WebdriverSetup()
	{
		System.out.println("Print out");
	}
}
