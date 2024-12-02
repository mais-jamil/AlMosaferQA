import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parameters {
	WebDriver driver = new ChromeDriver();
	String WebsiteURL = "https://global.almosafer.com/en";
	Random rand = new Random();
	
	public void WebsiteSetUp() {
		driver.manage().window().maximize();
		driver.get(WebsiteURL);
		WebElement CurrencyBtn = driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));
		CurrencyBtn.click();
	}

}
