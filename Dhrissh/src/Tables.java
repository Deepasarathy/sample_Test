import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Tables {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\NewChromedriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.leafground.com/table.xhtml");
		Thread.sleep(1000);
		driver.manage().window().maximize();
		/*System.out.println(driver.findElement(By.xpath("//select[@id='form:j_idt89_reflowDD']/following-sibling::div[3]/table/tbody/tr[2]/td[3]/span[2]")).getText());
		driver.close();*/
		int i,j;
		//System.out.println(driver.findElement(By.xpath("//select[@id='form:j_idt89_reflowDD']/following-sibling::div[3]/table/tbody")).getText());
		WebElement table= driver.findElement(By.xpath("//select[@id='form:j_idt89_reflowDD']/following-sibling::div[3]/table/tbody"));
		List<WebElement> row = table.findElements(By.xpath("//select[@id='form:j_idt89_reflowDD']/following-sibling::div[3]/table/tbody/tr"));
		
		//System.out.println(table.getSize())
		for(i=1;i<row.size();i++)
		{
			List<WebElement> col=table.findElements(By.xpath("//select[@id='form:j_idt89_reflowDD']/following-sibling::div[3]/table/tbody/tr["+i+"]/td"));
			for(j=1;j<col.size();j++)
			{
				System.out.print(table.findElement(By.xpath("//tbody/tr["+i+"]/td["+j+"]")).getText()+"\t");
			}
			System.out.println("");
		}
		
		//example
		
		driver.close();
	}

}
