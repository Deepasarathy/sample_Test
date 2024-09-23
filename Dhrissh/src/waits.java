import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class waits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\NewChromedriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.leafground.com/waits.xhtml");
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver, 11);
		//Explicit wait
		try {
	/*	driver.findElement(By.cssSelector("button[id='j_idt87:j_idt89']")).click();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[id='j_idt87:j_idt90']")));
		WebElement buttn=driver.findElement(By.cssSelector("button[id='j_idt87:j_idt90']"));
		Thread.sleep(2000);
		System.out.println(buttn.getText()); */
		
		//Implicit wait
		//Thread.sleep(2000);
	/*	WebElement visitxt=driver.findElement(By.cssSelector("button[id='j_idt87:j_idt93']"));
		driver.findElement(By.cssSelector("button[id='j_idt87:j_idt92']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		boolean d2=visitxt.isDisplayed();
		if(d2==true)
			System.out.println("button is disabled");
		Thread.sleep(5000); */
		driver.findElement(By.cssSelector("button[id='j_idt87:j_idt98']")).click();	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println(driver.findElement(By.xpath("//span[text()='Did you notice?']")).getText());
		Thread.sleep(2000);
		
	}		
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			driver.close();
		}
	}
	

}
