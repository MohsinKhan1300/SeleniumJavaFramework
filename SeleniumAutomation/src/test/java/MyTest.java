import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyTest {
	

	WebDriver driver = null;
	@BeforeTest
	public void setUpTest() {
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 }
	
	@Test
	public void FacebookLogin() {
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("kaka");
		driver.findElement(By.name("pass")).sendKeys("1234");
		driver.findElement(By.id("u_0_b")).click();
		 
	}
	@AfterTest
	public void teardownTest() {
		driver.close();
		driver.quit();
		 System.out.println("Test Completed");
		
	}

}
