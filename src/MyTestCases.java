import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {
	WebDriver driver = new ChromeDriver();
	String WebsiteURL = "https://global.almosafer.com/en";
	Random rand = new Random();
		
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
		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		String ActualValue = HotelTab.getAttribute("aria-selected");
		String ExpextedValue = "false";
		org.testng.Assert.assertEquals(ActualValue, ExpextedValue);
		
	}
	
	@Test(priority = 6)
	public void CheckDepatureDate() {
		int Tommorw = LocalDate.now().plusDays(1).getDayOfMonth();
		String ActualDepature = driver.findElement(By.cssSelector("div[class='sc-OxbzP sc-lnrBVv gKbptE'] span[class='sc-fvLVrH hNjEjT']")).getText();
		String ExpextedDepature = Integer.toString(Tommorw);
		org.testng.Assert.assertEquals(ActualDepature, ExpextedDepature);
					
	}
	
	@Test(priority = 7)
	public void CheckReturnDate() {
		int AfterTommorw = LocalDate.now().plusDays(2).getDayOfMonth();
		if(AfterTommorw < 10) {
			String ActualReturn = driver.findElement(By.cssSelector("div[class='sc-OxbzP sc-bYnzgO bojUIa'] span[class='sc-fvLVrH hNjEjT']")).getText();
			String ExpextedReturn = "0" + Integer.toString(AfterTommorw);
			org.testng.Assert.assertEquals(ActualReturn, ExpextedReturn);

		}
		else {
		String ActualReturn = driver.findElement(By.cssSelector("div[class='sc-OxbzP sc-bYnzgO bojUIa'] span[class='sc-fvLVrH hNjEjT']")).getText();
		String ExpextedReturn = Integer.toString(AfterTommorw);
		org.testng.Assert.assertEquals(ActualReturn, ExpextedReturn);

		}
		
	}
	
	@Test(priority = 8)
	public void RandomlyChangeTheLanguage() throws InterruptedException {
		String [] MyWebsites = {"https://www.almosafer.com/en", "https://www.almosafer.com/ar"};
		String [] ArabicCitiesNames = {"جدة","دبي"};
		String [] EnglishCitiesName = {"Dubai", "Riyadh", "Jeddah"};
		
		int randomArabicCity = rand.nextInt(ArabicCitiesNames.length);
		int randomEnglishCity = rand.nextInt(EnglishCitiesName.length);
		int randomIndex = rand.nextInt(MyWebsites.length);
		
		driver.get(MyWebsites[randomIndex]);
		
		WebElement SelectHotel = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		SelectHotel.click();
		WebElement HotelInput = driver.findElement(By.cssSelector(".sc-phbroq-2.uQFRS.AutoComplete__Input"));
		
		if(driver.getCurrentUrl().equals("https://www.almosafer.com/ar")) {
			String ActualLanguage = driver.findElement(By.tagName("html")).getAttribute("lang");
			String ExpectedLanguage = "ar";
			org.testng.Assert.assertEquals(ActualLanguage, ExpectedLanguage);
			HotelInput.sendKeys(ArabicCitiesNames[randomArabicCity]);
		}
		else {
			String ActualLanguage = driver.findElement(By.tagName("html")).getAttribute("lang");
			String ExpectedLanguage = "en";
			org.testng.Assert.assertEquals(ActualLanguage, ExpectedLanguage);
			HotelInput.sendKeys(EnglishCitiesName[randomEnglishCity]);
		}
		
		Thread.sleep(2000);
		WebElement CityList = driver.findElement(By.cssSelector(".sc-phbroq-4.gGwzVo.AutoComplete__List"));
		WebElement SelectNumberofVisitor = driver.findElement(By.cssSelector(".sc-tln3e3-1.gvrkTi"));
		CityList.findElements(By.tagName("li")).get(1).click(); 
		Select select = new Select(SelectNumberofVisitor);
		int RandomVisitor = rand.nextInt(2);
		select.selectByIndex(randomIndex);
		
		WebElement SearchClick = driver.findElement(By.cssSelector(".sc-1vkdpp9-5.btwWVk"));
		SearchClick.click();
		
		Thread.sleep(25000);
		

	}
	
	@Test(priority = 9)
	public void checkPageIsFullyLoading() {
		
		WebElement SearchResult = driver.findElement(By.xpath("//span[@data-testid='srp_properties_found']"));
		boolean ActualResult = SearchResult.getText().contains("found") || SearchResult.getText().contains("مكان");
		boolean ExpectedResult = true;
		
		org.testng.Assert.assertEquals(ActualResult, ExpectedResult);
	}
	
	@Test(priority = 10)
	public void CheackTheSortOption() throws InterruptedException {
		Thread.sleep(25000);
		
		WebElement LowestPriceButton = driver.findElement(By.xpath("//div[@data-testid='srp_sort_LOWEST_PRICE']"));
		LowestPriceButton.click();
		List<WebElement> allPrices = driver.findElements(By.cssSelector(".__ds__comp.undefined.MuiBox-root.muiltr-1nylpq2"));
		
	}
}




