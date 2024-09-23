import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


public class Actionfile {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\NewChromedriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.com");
		Thread.sleep(1000);
		driver.manage().window().maximize();

		//sendkeys
		WebElement text=driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
		Actions actions= new Actions(driver);
		actions.keyDown(text,Keys.SHIFT).sendKeys(text, "movies").sendKeys(Keys.ENTER).build().perform();
		
		Thread.sleep(2000);
		
		//mouseclick
		/*WebElement elementclick=driver.findElement(By.xpath("//a[text()='Gmail']"));
		actions.click(elementclick).perform();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);*/
		
		//Doubleclick and Contextclick
		//actions.contextClick().doubleClick(text).build().perform();
		//text.sendKeys(Keys.ESCAPE);
		Thread.sleep(2000);
		
		//clickAndHold, moveToElement & Release
		driver.navigate().to("https://www.leafground.com/drag.xhtml");
		WebElement source=driver.findElement(By.xpath("//div[@id='form:drag_content']"));
		WebElement target=driver.findElement(By.xpath("//div[@id='form:drop_content']"));
		actions.clickAndHold(source).moveToElement(target).release().build().perform();
		Thread.sleep(3000);
		
		//DragAndDrop
		driver.navigate().refresh();
		//actions.dragAndDrop(source, target).build().perform();
		
		
		
		driver.quit();
		
	}

}
