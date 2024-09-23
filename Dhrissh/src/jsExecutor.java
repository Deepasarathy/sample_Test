import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class jsExecutor {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\NewChromedriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		//driver.get("https://accounts.google.com/v3/signin/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ifkv=AeDOFXhD8WWHGi6hoAn9gQ_Y_9_rV_USWcXpwrzBSmJPXooeTOqbuUWUELsXEZ2o1K1v1ELyYi5Rpg&rip=1&sacu=1&service=mail&flowName=GlifWebSignIn&flowEntry=ServiceLogin&dsh=S-1727152082%3A1690877976369731");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		
		//javascript executor initialization
		JavascriptExecutor js= (JavascriptExecutor) driver;
		js.executeScript("window.location='https://demo.guru99.com/V4/'");
		//js.executeScript("window.scrollBy(0,600)");
		/*Scrolling down the page till the element is found		
        js.executeScript("arguments[0].scrollIntoView();", Element);*/
		/*//to perform scroll on an application using Selenium

   JavascriptExecutor js = (JavascriptExecutor) driver;
   js.executeScript("window.scrollBy(0,document.body.scrollHeight)");*/

		//driver.findElement(By.name("uid")).sendKeys("Deepa");
		js.executeScript("document.getElementByName('uid').value='Deepa';");
		WebElement password = driver.findElement(By.name("password"));

		js.executeScript("argument[0].value='pwd';",password);

		//driver.findElement(By.name("password")).sendKeys("pwd");
		WebElement button = driver.findElement(By.name("btnLogin"));
		js.executeScript("argument[0].click();",button);

	}

}
