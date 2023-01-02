package pracPac;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SauceDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();

		List<WebElement> price = driver.findElements(By.className("inventory_item_price"));
		//		float cheap=Float.parseFloat(price.get(0).getText().trim().replace("$", ""));
		//		for (WebElement str : price) {
		//			float acPrc = Float.parseFloat(str.getText().trim().replace("$",""));
		//			if(acPrc<cheap)
		//			{
		//				cheap=acPrc;
		//			}
		//		}

		double maxPrice = price
				.stream()
				.mapToDouble(e -> Double.parseDouble(e.getText().trim().replace("$", "")))
				.max()
				.getAsDouble();
		//		System.out.println(cheap);
		//		String addtoCartLink="//div[normalize-space()='$%s']/following-sibling::button";
		String addtoCartLink="//div[normalize-space()='$"+maxPrice+"']/following-sibling::button";
		//		String acaddtoCartLink = String.format(addtoCartLink,cheap);
		driver.findElement(By.xpath(addtoCartLink)).click();
		//		driver.quit();
	}

}
