import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.*;

public class checkbox {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\NewChromedriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.leafground.com/checkbox.xhtml");
		driver.manage().window().maximize();
		
		// single Checkbox
		WebElement checkboxverify = driver.findElement(By.xpath("//div[@id='j_idt87:j_idt89']/span"));
		boolean b1 = checkboxverify.isSelected();
		Thread.sleep(2000);
		if(b1==true)
			System.out.println("checkbox selected");
		else
			System.out.println("checkbox not selected");
			checkboxverify.click();
			System.out.println("now checkbox selected");
			Thread.sleep(2000);
			
		// multiple checkbox
			List<WebElement> mulcheck = driver.findElements(By.xpath("//table[@id='j_idt87:basic']/tbody/tr/td"));
			mulcheck.size();
			System.out.println(mulcheck.size());
			for(int i=0;i<mulcheck.size();i++)
			{
				boolean b2=mulcheck.get(i).isSelected();
				if (b2==false)
				{
					mulcheck.get(i).click();
					System.out.println(mulcheck.get(i).getText()+" -checked now");
					Thread.sleep(1000);
				}
				else
					System.out.println(mulcheck.get(i).getText()+"already selected");
			}
			
			//toggler switch:
			WebElement togg = driver.findElement(By.xpath("//div[@class='ui-toggleswitch-slider']"));
			boolean b3=togg.isSelected();
			Thread.sleep(1000);
			if(b3==false)
			{
				togg.click();
				Thread.sleep(1000);
				System.out.println("toggler selected now");
				Thread.sleep(2000);
			}
				
			else
			{
				System.out.println("already toggler enabled");
			}	
			Thread.sleep(2000);
			driver.close();
	}
}