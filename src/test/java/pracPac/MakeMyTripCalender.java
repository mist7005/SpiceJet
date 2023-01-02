package pracPac;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripCalender {
	static {
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
	}
	WebDriver driver;
	@Test
	public void mainTest() {
		String month="february";
		String year="2023";
		String date="10";
		
		String rMonth="April";
		String rYear="2023";
		String rDate="25";
			WebDriverManager.chromedriver().setup();
			FirefoxOptions options=new FirefoxOptions();
			options.addArguments("--disable-notifications");
			driver=new FirefoxDriver(options);
//		ChromeOptions option=new ChromeOptions();
//		option.addArguments("--disable-notifications");
//			driver=new ChromeDriver(option);
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			driver.get("https://www.makemytrip.com/flights/");
			
			driver.findElement(By.xpath("//a[normalize-space(@class)='active makeFlex hrtlCenter column']")).click();
			driver.findElement(By.xpath("//li[text()='Round Trip']")).click();
			
//		int value=getMonthValueInInt(month);
//		System.out.println(value);
		
			try
			{
			driver.findElement(By.id("departure")).click();
			}
			catch (Exception e) {
				driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
			}
			handleCalenderPopUp(date,month,year);
			handleCalenderPopUp(rDate,rMonth,rYear);

	}
	public int getMonthValueInInt(String month)
	{
		String ar[]= {"January","February","March","April","May","June","July","August","September","October","November","December"};
		for (int i = 0; i < ar.length; i++) {
			if(ar[i].equalsIgnoreCase(month))
			{
				return i+1;
			}

		}
		return 0;
	}

	public void handleCalenderPopUp(String expDate,String expMonth,String expYear)
	{
		String monthAndYear = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[1]")).getText();
		System.out.println(monthAndYear);
//		String acMonth=monthAndYear.split(" ")[0];
//		System.out.println(acMonth);
//		String acYear=monthAndYear.split(" ")[1];
//		System.out.println(acYear);
		while(!(monthAndYear.equalsIgnoreCase(expMonth+expYear)))
		{
			driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			monthAndYear = driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[1]")).getText();
//			acMonth=monthAndYear.split(" ")[0];
//			acYear=monthAndYear.split(" ")[1];
		}
		driver.findElement(By.xpath("(//div[@class='DayPicker-Caption'])[1]/following-sibling::div[@class='DayPicker-Body']//div[@class='DayPicker-Day']/div/p[text()='"+expDate+"']")).click();
	}
}
