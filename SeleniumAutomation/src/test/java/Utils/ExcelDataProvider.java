package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelDataProvider {
	
	 WebDriver driver = null;
	
	@BeforeTest
	public void setUpTest() {
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 }
	
	@Test(dataProvider = "Test1data")
	public void test1(String username, String password) throws Exception {
		System.out.println(username+"  "+password);
		
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.name("pass")).sendKeys(password);
		Thread.sleep(2000);
	}
	
	@AfterTest
	public void teardownTest() {
		driver.close();
		driver.quit();
	}
	
	@DataProvider(name = "Test1data")
	
	public Object[][]  getData() {
		
		String excelPath = "D:\\Projects\\SeleniumAutomation\\excel\\Data.xlsx";
		Object data[][] = testData(excelPath, "Sheet1");
		return data;
		
	}
	
	public Object[][] testData(String excelPath, String sheetName) {
		
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
		Object data[][] = new Object[rowCount-1][colCount];
		
		
		for(int i=1;i<rowCount;i++) {
			for(int j=0; j<colCount; j++) {
				
				String cellData = excel.getCellDataString(i, j);
				//System.out.print(cellData+"  ");
				data[i-1][j] = cellData;
			}
			//System.out.println();
		}
		return data;
	}

}
