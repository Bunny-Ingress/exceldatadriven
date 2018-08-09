package packageTwo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class searchgoogle {

	WebDriver driver;
	
	testScripts excel = new testScripts();
	
@BeforeTest
	public void setup() throws IOException
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Prabhani\\Downloads\\Selinium\\chrome\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(excel.readExcel(1,0, ".\\Data\\Book1.xlsx","Sheet1"));
	}

@Test

	public void testSearch() throws IOException
	{
		driver.findElement(By.id("lst-ib")).sendKeys(excel.readExcel(1,1, ".\\Data\\Book1.xlsx","Sheet1"));
		driver.findElement(By.name("btnK")).click();
		driver.findElement(By.linkText(excel.readExcel(1,2, ".\\Data\\Book1.xlsx","Sheet1"))).click();
		
		String webTitle = driver.getTitle();
		
		Assert.assertEquals(webTitle, excel.readExcel(1,2, ".\\Data\\Book1.xlsx","Sheet1"));
	}

@AfterTest
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}
	
}
