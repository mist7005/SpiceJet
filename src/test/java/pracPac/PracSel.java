package pracPac;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.spicejet.genericUtility.WebDriverUtility;

public class PracSel {
	WebDriverUtility wdu=new WebDriverUtility();
	WebDriver driver;
	

	public void handlingShadowElement()
	{
		
		
		
		driver = wdu.setApplication("chrome",10l, "chrome://downloads/");
		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript(" document.querySelector('body > downloads-manager').shadowRoot.querySelector('#toolbar').shadowRoot.querySelector('#toolbar').shadowRoot.querySelector('#search').shadowRoot.querySelector('#searchInput').value=arguments[0]","tyss");

		WebElement searchBox = (WebElement) js.executeScript("return document.querySelector('body > downloads-manager').shadowRoot.querySelector('#toolbar')"
				+ ".shadowRoot.querySelector('#toolbar').shadowRoot.querySelector('#search')"
				+ ".shadowRoot.querySelector('#searchInput')");
		searchBox.sendKeys("hello");
		
	}
	
	@Test
	public void handlingShadowElement1()
	{
		String url="https://shop.polymer-project.org/";
		driver = wdu.setApplication("chrome", 10l, url);
		JavascriptExecutor js=(JavascriptExecutor) driver;
		WebElement menFashionLink = (WebElement)js.executeScript("return document.querySelector('body > shop-app')"
				+ ".shadowRoot.querySelector('#tabContainer > shop-tabs > shop-tab:nth-child(1) > a')");
		menFashionLink.click();
		
	}
}
