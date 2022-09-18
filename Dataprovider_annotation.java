package Datadriven_testing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
//check another new changes
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


// github la kelele changes distet ka
public class Dataprovider_annotation {
	WebDriver driver;
	String project_path;
	String File_path;
	@BeforeTest
	public void setup_browser()
	{
		project_path = System.getProperty("user.dir");
		String chrome_path = project_path+"\\Driver\\chromedriver.exe";
	    File_path = project_path+"\\Driver\\practise of xssfworkbook.xlsx";
		System.setProperty("webdriver.chrome.driver", chrome_path);
	    driver=new ChromeDriver();
	    driver.get("https://opensource-demo.orangehrmlive.com/");
		
	}
	@Test(dataProvider="Exceldataprovider")
	public void login(String username, String password) throws InterruptedException
	{
		driver.findElement(By.id("txtUsername")).sendKeys("username");
		Thread.sleep(5000);
		driver.findElement(By.id("txtPassword")).sendKeys("password");
		Thread.sleep(5000);
		driver.findElement(By.id("btnLogin")).submit();
	}
	
	/*@DataProvider
	public Object[][] DP1()
	{
		Object A[][]= {{"shivaji","shivaji@123"}};
		//A[0][0]="shivaji";
		//A[0][1]="shivaji@123";
		return A;
	}*/
	
	
	@DataProvider
	public String[][] Exceldataprovider() throws IOException
	{
		String B[][]=null;
		
		File f=new File(File_path);
		FileInputStream Fin=new FileInputStream(f);
		XSSFWorkbook workbook=new XSSFWorkbook(Fin);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		int m = sheet.getPhysicalNumberOfRows();
		int n = sheet.getRow(0).getLastCellNum();
		
		for(int i=0;i<m;i++)
		{
			for(int j=0;j<n;j++)
			{
				 B[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return B;
	}
}
