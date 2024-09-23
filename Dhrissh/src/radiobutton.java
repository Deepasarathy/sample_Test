import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class radiobutton {
	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\NewChromedriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.leafground.com/radio.xhtml");
		driver.manage().window().maximize();
		
		//radio button
		List<WebElement> radbtn = driver.findElements(By.xpath("//table[@id='j_idt87:console1']/tbody/tr/td"));
		radbtn.size();
		System.out.println(radbtn.size());
		for(int i=0;i<radbtn.size();i++)
		{
			boolean r1=radbtn.get(i).isSelected();
			if(r1==false)
			{
			radbtn.get(i).click();
			Thread.sleep(1000);
			System.out.println(radbtn.get(i).getText()+" -is enabled");
			}
		}
		
		
		driver.close();
	}
	
}
