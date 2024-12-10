import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases extends Parameters {
			
	@BeforeTest
	public void MySetUp() {
		
		WebsiteSetUp();
	}
		
	@Test(priority = 1)
	public void CheckEnglishLangIsDefult() throws IOException {
		String ActualLanguage = driver.findElement(By.tagName("html")).getAttribute("lang");
		org.testng.Assert.assertEquals(ActualLanguage, ExpectedLanguage);
		
		ScreenShot();
	}
	
	@Test(priority = 2, enabled = false)
	public void CheckTheDefultCurrencyIsSAR() throws IOException {
		String ActualCurrency = driver.findElement(By.xpath("//button[@data-testid='Header__CurrencySelector']")).getText();
		org.testng.Assert.assertEquals(ActualCurrency, ExpectedCurrency);
		
		ScreenShot();
	}
	
	@Test(priority = 3, enabled = false)
	public void CheckContactNumber() throws IOException {
		String ActualContactNumber = driver.findElement(By.cssSelector(".sc-hUfwpO.bWcsTG")).getText();
		org.testng.Assert.assertEquals(ActualContactNumber, ExpectedContactNumber);
		
		ScreenShot();
	}
	
	@Test(priority = 4, enabled = false)
	public void ChickQitafLogo() {
		boolean ActualResult = driver.findElement(By.cssSelector(".sc-ghsgMZ.hIElfs")).isDisplayed();
		boolean ExpectedResult = true;
		org.testng.Assert.assertEquals(ActualResult, ExpectedResult);
		
	}
	
	@Test(priority = 5, enabled = false)
	public void CheckTheHotelNotSelected() {
		WebElement HotelTab = driver.findElement(By.id("uncontrolled-tab-example-tab-hotels"));
		String ActualValue = HotelTab.getAttribute("aria-selected");
		String ExpextedValue = "false";
		org.testng.Assert.assertEquals(ActualValue, ExpextedValue);
		
	}
	
	@Test(priority = 6, enabled = false)
	public void CheckDepatureDate() {
		int Tommorw = LocalDate.now().plusDays(1).getDayOfMonth();
		String ActualDepature = driver.findElement(By.cssSelector("div[class='sc-OxbzP sc-lnrBVv gKbptE'] span[class='sc-fvLVrH hNjEjT']")).getText();
		String ExpextedDepature = String.format("%02d", Tommorw);
		org.testng.Assert.assertEquals(ActualDepature, ExpextedDepature);
					
	}
	
	@Test(priority = 7, enabled = false)
	public void CheckReturnDate() {
		int AfterTommorw = LocalDate.now().plusDays(2).getDayOfMonth();
		String ActualReturn = driver.findElement(By.cssSelector("div[class='sc-OxbzP sc-bYnzgO bojUIa'] span[class='sc-fvLVrH hNjEjT']")).getText();
		String ExpextedReturn = String.format("%02d", AfterTommorw);
		org.testng.Assert.assertEquals(ActualReturn, ExpextedReturn);

		}
		
	
	@Test(priority = 8, enabled = false)
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
				

	}
	
	@Test(priority = 9, enabled = false)
	public void checkPageIsFullyLoading() {
		
		WebElement SearchResult = driver.findElement(By.xpath("//span[@data-testid='srp_properties_found']"));
		boolean ActualResult = SearchResult.getText().contains("found") || SearchResult.getText().contains("مكان");
		boolean ExpectedResult = true;
		
		org.testng.Assert.assertEquals(ActualResult, ExpectedResult);
	}
	
	@Test(priority = 10, enabled = false)
	public void CheackTheSortOption() throws InterruptedException {
		Thread.sleep(25000);
		
		WebElement LowestPriceButton = driver.findElement(By.xpath("//div[@data-testid='srp_sort_LOWEST_PRICE']"));
		LowestPriceButton.click();
		List<WebElement> allPrices = driver.findElements(By.cssSelector(".__ds__comp.undefined.MuiBox-root.muiltr-1nylpq2"));
		
	}
}




