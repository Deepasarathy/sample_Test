import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class windows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\NewChromedriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		// String url = "https://www.leafground.com/window.xhtml";
		String url = "https://www.hyrtutorials.com/p/window-handles-practice.html";
		driver.navigate().to(url);
		driver.manage().window().maximize();
		int count = 1;

		try {
			// multiple tabs
			String parent = driver.getWindowHandle();
			System.out.println("Parent window:" + parent + "parent title: " + driver.getTitle());
			Thread.sleep(5000);
			driver.findElement(By.xpath("//button[@id='newTabsBtn']")).click();
			Thread.sleep(3000);
			// String child= driver.getWindowHandle();
			// System.out.println("child window:"+child);
			Set<String> allhandles = driver.getWindowHandles();
			for (String tab : allhandles) {
				if (!tab.equalsIgnoreCase(parent)) {
					driver.switchTo().window(tab);
					Thread.sleep(4000);
					System.out.println(driver.getTitle());
				}
		}
				// multiple windows
				driver.switchTo().window(parent);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[@id='newWindowsBtn']")).click();
				driver.findElement(By.xpath("//button[@id='newWindowsBtn']")).click();
				Thread.sleep(3000);
				Set<String> allwindos = driver.getWindowHandles();
				for (String mulwindow : allwindos) {
					if (count == 1 || count == 3) {
						Thread.sleep(5000);
						driver.switchTo().window(mulwindow);
						Thread.sleep(5000);
						System.out.println("Window" + count + " - " + mulwindow);
					}

					count++;
				}

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			driver.quit();
		}
	}
}
