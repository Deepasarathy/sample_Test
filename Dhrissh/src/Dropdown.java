import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\NewChromedriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.leafground.com/input.xhtml");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		//move to element menu
		driver.findElement(By.xpath("//i[@class='pi pi-server layout-menuitem-icon']")).click();
		Thread.sleep(2000);
		//select dropdown menu
		driver.findElement(By.xpath("//i[@class='pi pi-fw pi-chevron-down layout-menuitem-icon']")).click();
		Thread.sleep(2000);
		
		//create object select class
		Select se= new Select(driver.findElement(By.xpath("//select[@class='ui-selectonemenu']")));
		//Select cntry = new Select(driver.findElement(By.xpath("//select[@name='j_idt87:country_input']")));
		// select by visibletext
		se.selectByVisibleText("Playwright");
		Thread.sleep(2000);
		List<WebElement> options1 = se.getOptions();
		for(int i=0;i<options1.size();i++)
		{
			
			System.out.println(options1.get(i).getText());
		}
		System.out.println("Length of options:"+ options1.size());
		/*select by index
		//cntry.selectByIndex(1);
		//Thread.sleep(2000);
		//cntry.deselectAll();
		//cntry.selectByVisibleText("USA");
		
		WebElement we1 = driver.findElement(By.xpath("//div[@id='j_idt87:country']/div/select"));
		
		we1.click();
		
		Select s1 = new Select(we1);
		s1.deselectByVisibleText("India");*/
		
		driver.close();
}

}