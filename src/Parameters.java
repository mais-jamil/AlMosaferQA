import java.io.File;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Parameters {
	WebDriver driver = new ChromeDriver();
	String WebsiteURL = "https://global.almosafer.com/en";
	Random rand = new Random();
	
	String ExpectedLanguage = "en";
	String ExpectedCurrency = "SAR";
	String ExpectedContactNumber = "+966554400000";


	
	public void WebsiteSetUp() {
		driver.manage().window().maximize();
		driver.get(WebsiteURL);
		WebElement CurrencyBtn = driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));
		CurrencyBtn.click();
	}
	
	public void ScreenShot() throws IOException {
		java.util.Date myDate = new java.util.Date();
		String fileName = myDate.toString().replace(":", "-");
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./ScteenShots/"+ fileName +".jpg");
		FileUtils.copyFile(srcFile, destFile);
		
	}

}
