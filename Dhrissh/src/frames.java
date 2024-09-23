import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\NewChromedriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		String url = "https://www.leafground.com/frame.xhtml";
		driver.navigate().to(url);
		driver.manage().window().maximize();
		try {
			// frame by index
			driver.switchTo().frame(0);
			driver.findElement(By.xpath(
					"//button[@style='color:#ffffff;background: linear-gradient(240deg, #ff7295 0%, #fe875d 100%);border: 0 none;width:15%;height:40%']"))
					.click();
			Thread.sleep(3000);

			// no. of frames
			driver.switchTo().defaultContent();
			System.out.println("Total no. of frames:" + driver.findElements(By.tagName("iframe")).size());

			// frame by webelemet & nested frames
			WebElement frms = driver.findElement(By.xpath("//iframe[@src='page.xhtml']"));
			driver.switchTo().frame(frms);
			Thread.sleep(3000);
			// frame by name
			driver.switchTo().frame("frame2");
			driver.findElement(By.xpath(
					"//button[@style='background: linear-gradient(240deg, #4b7ecf 0%, #8e70ee 100%); color:#ffffff;border: 0 none;width:15%;height:40%']"))
					.click();
			Thread.sleep(4000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}

	}

}
