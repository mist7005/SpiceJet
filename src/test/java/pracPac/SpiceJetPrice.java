package pracPac;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

class SpiceJetPrice1 {
	@FindBy(xpath = "//img[@class='css-9pa8cd' and @src='https://www.spicejet.com/public/loader.gif']")
	private WebElement logo;
	
	public SpiceJetPrice1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getLogo()
	{
		return logo;
	}
}
	
public class SpiceJetPrice 
{
	@Test
	public void test1() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(op);
//		PageFactory.initElements(driver,logo);
		SpiceJetPrice1 j=new SpiceJetPrice1(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		driver.get("https://www.spicejet.com/search?from=DEL&to=BLR&tripType=2&departure=2022-12-29&adult=1&child=2&srCitizen=0&infant=0&return=2023-01-07&currency=INR&redirectTo=/");
		
//		WebElement logo = driver.findElement(By.xpath("//img[@class='css-9pa8cd' and @src='https://www.spicejet.com/public/loader.gif']"));
		wait.until(ExpectedConditions.invisibilityOf(j.getLogo()));
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//div[text()='Select your' and text()='Departure to']/../../../following-sibling::div/descendant::div/../../../following-sibling::div//span/..)[2]")).click();
		
		
		wait.until(ExpectedConditions.invisibilityOf(j.getLogo()));
		
		driver.findElement(By.xpath("(//div[text()='Select your' and text()='Return Flight to']/../../../following-sibling::div/descendant::div/../../../following-sibling::div//span/..)[4]")).click();
		
		
		
	}

}
