import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.apache.commons.io.FileUtils;

public class Screenshotexple {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\NewChromedriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.leafground.com/input.xhtml");
		driver.manage().window().maximize();
		
		//screenshot method
		File fs=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(fs, new File("E:\\SeleniumDemo\\Dhrissh\\Screenshot_file\\img.png"));
			
		}
	}


