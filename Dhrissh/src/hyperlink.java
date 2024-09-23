import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class hyperlink {
	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\NewChromedriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.leafground.com/link.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(2000);
		
		HttpsURLConnection huc = null;
		String url="";
		int respcod;
		//click on url
	/*	driver.findElement(By.linkText("Go to Dashboard")).click();
		System.out.println("Current URL ==> "+driver.getCurrentUrl());
		System.out.println("Page Title ==> "+driver.getTitle());
		Thread.sleep(2000);
		
		driver.navigate().back();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.navigate().refresh();
		System.out.println("Current URL ==> "+driver.getCurrentUrl());
		System.out.println("Page Title ==> "+driver.getTitle());
		Thread.sleep(2000);
		
		driver.navigate().forward();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		System.out.println("Current URL ==> "+driver.getCurrentUrl());
		System.out.println("Page Title ==> "+driver.getTitle());
		Thread.sleep(2000);
		driver.quit(); */
		
		//link count
		List <WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("number of links: "+links.size());
		//System.out.println("Links"+links);
		
		//broken link
	
		for(WebElement wb:links) {
			//System.out.println(wb.getAttribute("href"));
			url = wb.getAttribute("href");
		
	try
	{
		huc = (HttpsURLConnection) (new URL(url).openConnection());
		huc.setRequestMethod("HEAD");
		huc.connect();
		Thread.sleep(1000);
		respcod = huc.getResponseCode();
		Thread.sleep(1000);
		
		if(respcod >=400)
			System.out.println(url+" - is broken url");
		else
			System.out.println(url+ "- is valid url");
	}
	catch (MalformedURLException e)
	{
        e.printStackTrace();
    } 
	catch (IOException e) 
	{
        
        e.printStackTrace();	
    }
		
	
	}
		
		driver.close();
	}
}
