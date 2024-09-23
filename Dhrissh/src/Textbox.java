import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Textbox {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "E:\\Selenium\\Drivers\\NewChromedriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.leafground.com/input.xhtml");
		
		driver.manage().window().maximize();
		
		//write your name in the textbox
		driver.findElement(By.id("j_idt88:name")).sendKeys("Deepa");
		Thread.sleep(3000);
		//clear the above textbox and write your name using webelement xpath
		WebElement name= driver.findElement(By.xpath("//input[@id='j_idt88:name']"));
		name.clear();
		name.sendKeys("Ranjani");
		
		//append
		WebElement city= driver.findElement(By.id("j_idt88:j_idt91"));
		city.click();
		city.sendKeys(", India");
		
		//verify textbox disabled
		WebElement txt= driver.findElement(By.xpath("//input[@placeholder='Disabled']"));
		boolean b1=txt.isEnabled();
		if(b1==true)
			System.out.println("Text box is enabled");
		else
			System.out.println("Text box is disabled");
		
		
		boolean b2=txt.isDisplayed();
		if(b2==true)
			System.out.println("Text box is displayed");
		else
			System.out.println("Text box is not displayed");
		
		//Retrieve text
		WebElement rtvtxt= driver.findElement(By.id("j_idt88:j_idt97"));
		String val1=rtvtxt.getAttribute("value");
		System.out.println("The Retrieved text is:"+val1);
		
	//enter tab key
		WebElement email= driver.findElement(By.id("j_idt88:j_idt99"));
		email.sendKeys("test123@gmail.com");
		email.sendKeys(Keys.TAB);
		Thread.sleep(1000);
		
		
	//confirm error message
		WebElement age = driver.findElement(By.name("j_idt106:thisform:age"));
		age.sendKeys(Keys.ENTER);
		boolean d1 = driver.findElement(By.xpath("//span[text()='Age is mandatory']")).isDisplayed();
		if (d1==true)
			System.out.println(d1+"error displayed");
		else
			System.out.println("not displayed");
		
	//select 3rd option
		WebElement lst = driver.findElement(By.id("j_idt106:auto-complete_input"));
		lst.sendKeys("Deepa");
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[text()='Deepa'])[3]")).click();
		Thread.sleep(3000);
		
		
		
	/*type date and verify the calender
		WebElement dob = driver.findElement(By.id("j_idt106:j_idt116_input"));
		dob.sendKeys("11/04/1994");
		//driver.findElement(By.xpath("(//span[@class='ui-button-text'])")).click();
		WebElement cln=driver.findElement(By.xpath("//span[@class='ui-button-icon-left ui-icon ui-icon-calendar']"));
		cln.click();
		Thread.sleep(5000);
		WebElement calnd= driver.findElement(By.xpath("(//div[@id='j_idt106:j_idt116_panel'])/div/div/table/tbody/tr[1]/td[6]/a"));
		boolean cal1=calnd.isSelected();
		if (cal1==true)
			System.out.println("date selected");
		else
			System.out.println("date not selected");
		
		*/
		
		//spin value
		driver.findElement(By.name("j_idt106:j_idt118_input")).sendKeys("15");
		WebElement up=driver.findElement(By.xpath("(//span[@class='ui-icon ui-c ui-icon-triangle-1-n'])"));
		up.click();
		WebElement text1 = driver.findElement(By.xpath("//input[@id='j_idt106:j_idt118_input']"));
		System.out.println("current value after clicking up arrow:"+text1.getAttribute("value"));
		Thread.sleep(3000);
		WebElement down=driver.findElement(By.xpath("(//span[@class='ui-icon ui-c ui-icon-triangle-1-s'])"));
		down.click();
		Thread.sleep(3000);
		System.out.println("current value after clicking down arrow:"+text1.getAttribute("value"));
		driver.close();
		
		
	}
	

}
