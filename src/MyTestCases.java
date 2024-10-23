import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {

	WebDriver driver = new ChromeDriver();
	String WebsiteURL = "https://global.almosafer.com/en";
		
	@BeforeTest
	public void MySetUp() {
		
		driver.manage().window().maximize();
		driver.get(WebsiteURL);
		
		WebElement CurrencyBtn = driver.findElement(By.cssSelector(".sc-jTzLTM.hQpNle.cta__button.cta__saudi.btn.btn-primary"));
		CurrencyBtn.click();
	
	}
	
	
	@Test(priority = 1)
	public void CheckEnglishLangIsDefult() {
		String ActualLanguage = driver.findElement(By.tagName("html")).getAttribute("lang");
		String ExpectedLanguage = "en";
		org.testng.Assert.assertEquals(ActualLanguage, ExpectedLanguage);
		
	}
	
	@Test(priority = 2)
	public void CheckTheDefultCurrencyIsSAR() {
		String ActualCurrency = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']")).getText();
		String ExpectedCurrency = "SAR";
		org.testng.Assert.assertEquals(ActualCurrency, ExpectedCurrency);
				
	}
	
	@Test(priority = 3)
	public void CheckContactNumber() {
		String ActualContactNumber = driver.findElement(By.cssSelector(".sc-hUfwpO.bWcsTG")).getText();
		String ExpectedContactNumber = "+966554400000";
		org.testng.Assert.assertEquals(ActualContactNumber, ExpectedContactNumber);
		
	}
	
	@Test(priority = 4)
	public void ChickQitafLogo() {
		boolean ActualResult = driver.findElement(By.cssSelector(".sc-ghsgMZ.hIElfs")).isDisplayed();
		boolean ExpectedResult = true;
		org.testng.Assert.assertEquals(ActualResult, ExpectedResult);
	}
	
	@Test(priority = 5)
	public void CheckTheHotelNotSelected() {
		
	}
	
	@Test(priority = 6)
	public void CheckDepatureDate() {
		
	}
	
	@Test(priority = 7)
	public void CheckReturnDate() {
		
	}
	
	
	
}
