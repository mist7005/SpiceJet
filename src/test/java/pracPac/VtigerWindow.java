package pracPac;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.mysql.cj.x.protobuf.MysqlxExpect.Open.Condition.Key;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VtigerWindow {

	public static void main(String[] args) throws AWTException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://crmaccess.vtiger.com/log-in/?mode=continue");
		String parentWindow = driver.getWindowHandle();
		Actions a=new Actions(driver);
		Robot r=new Robot();
		
		WebElement googleW = driver.findElement(By.id("not_signed_inayoyyvuhj9i7"));
		a.contextClick(googleW).perform();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		WebElement officeW = driver.findElement(By.xpath("//a[@title='Sign in with Office 365']"));
		a.contextClick(officeW).perform();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		WebElement twitterW = driver.findElement(By.xpath("//a[@title='Sign in with Twitter']"));
		a.contextClick(twitterW).perform();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		String expW = windowHandles.stream().filter(x -> driver.switchTo().window(x).getTitle().equals("Sign in to your account")).findAny().orElse(parentWindow);
		driver.switchTo().window(expW);
	}

}
