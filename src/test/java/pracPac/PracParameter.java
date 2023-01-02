package pracPac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class PracParameter {
	WebDriver driver;

	@Test
	@Parameters({"browser","url","un","pw"})
	public void loginToApp(String browser,String url,String un,String pw)
	{
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(un);
		driver.findElement(By.name("pwd")).sendKeys(pw);
		driver.findElement(By.xpath("//div[text()='Login ']")).click();
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "actiTIME - Login","login successfull");
		System.out.println(actualTitle);
		driver.quit();
	}
}
