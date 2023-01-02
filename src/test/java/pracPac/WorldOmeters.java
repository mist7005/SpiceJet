package pracPac;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice.Local;

public class WorldOmeters {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.worldometers.info/world-population/");
		String pop = driver.findElement(By.xpath("//div[@class='maincounter-number']/span")).getText();
		String birthToday=driver.findElement(By.xpath("//div[text()='Births today ']/following-sibling::div[@class='sec-counter']/span")).getText();
		String deathsToday=driver.findElement(By.xpath("//div[text()='Deaths today ']/following-sibling::div[@class='sec-counter']/span")).getText();
		String populationGrowthToday=driver.findElement(By.xpath("//div[text()='Population Growth today ']/following-sibling::div[@class='sec-counter']/span")).getText();
		String birthsThisYear=driver.findElement(By.xpath("//div[text()='Births this year ']/following-sibling::div[@class='sec-counter']/span")).getText();
		String deathsThisYear=driver.findElement(By.xpath("//div[text()='Deaths this year ']/following-sibling::div[@class='sec-counter']/span")).getText();
		String populationGrowthThisYear=driver.findElement(By.xpath("//div[text()='Population Growth this year ']/following-sibling::div[@class='sec-counter']/span")).getText();
		System.out.println(pop);
		System.out.println(birthToday);
		System.out.println(deathsToday);
		System.out.println(populationGrowthToday);
		System.out.println(birthsThisYear);
		System.out.println(deathsThisYear);
		System.out.println(populationGrowthThisYear);
		
		
	}

}
