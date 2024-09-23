import java.awt.Window;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class alerts {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\NewChromedriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		String url="https://www.leafground.com/alert.xhtml";
		driver.navigate().to(url);
		driver.manage().window().maximize();
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		try {
			//simple alert -accept
			driver.findElement(By.cssSelector("button[id='j_idt88:j_idt91']")).click();
			System.out.println("Alert ==>"+driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
			Thread.sleep(5000);
			
			//Confirmation alert
			driver.findElement(By.cssSelector("button[id='j_idt88:j_idt93']")).click();
			System.out.println("Alert ==>"+driver.switchTo().alert().getText());
			driver.switchTo().alert().accept();
			Thread.sleep(5000);
			driver.navigate().refresh();
			
			driver.findElement(By.cssSelector("button[id='j_idt88:j_idt93']")).click();
			System.out.println("Alert ==>"+driver.switchTo().alert().getText());
			driver.switchTo().alert().dismiss();
			Thread.sleep(5000);
			
			//simple alert -dismiss
			driver.findElement(By.cssSelector("button[id='j_idt88:j_idt100']")).click();
			Thread.sleep(4000);
			driver.findElement(By.xpath("(//a[@aria-label='Close'])[2]")).click();
			//System.out.println("Alert ==>"+driver.switchTo().alert().getText());
			//driver.switchTo().alert().accept();
			
			//prompt alert
			driver.findElement(By.cssSelector("button[id='j_idt88:j_idt104']")).click();
			Thread.sleep(4000);
			System.out.println("Alert ==>"+driver.switchTo().alert().getText());
			driver.switchTo().alert().sendKeys("Deepa");
			driver.switchTo().alert().accept();
			
			driver.navigate().refresh();
			driver.findElement(By.cssSelector("button[id='j_idt88:j_idt104']")).click();
			Thread.sleep(4000);
			System.out.println("Alert ==>"+driver.switchTo().alert().getText());	
			driver.switchTo().alert().dismiss();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally{
			driver.close();
		}
		
		
		
		
		
	}

}
