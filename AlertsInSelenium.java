package alertsinselenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertsInSelenium {
	WebDriver driver;

//see the another new changes in github desktop
	public static void main(String[] args) throws InterruptedException  {
		// TODO Auto-generated method stub
		AlertsInSelenium a1=new AlertsInSelenium();
		a1.setup_browser();
		a1.locate_alerts();
	}
	public void setup_browser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\personal\\swaya\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(" https://demoqa.com/alerts");
	}
	public void locate_alerts() throws InterruptedException 
	{
		driver.findElement(By.id("confirmButton")).click();
		Alert a4=driver.switchTo().alert();
		System.out.println(a4.getText());
		a4.accept();
		 WebElement result1 = driver.findElement(By.id("confirmResult"));
		
		System.out.println(result1.getText());
		
		
		driver.findElement(By.id("promtButton")).click();		
		Alert a3=driver.switchTo().alert();
		System.out.println(a3.getText()); //for getting text vissible on alert
		a3.sendKeys("Enter text shown on alert text box");
		a3.accept();
		WebElement result = driver.findElement(By.id("promptResult"));
		//enter kelili text (Enter text shown on alert text box) hi alert var n disata driver chya page var 
		//nanter disate mnun driver cha object ghetala alert cha nahi
		System.out.println(result.getText());
		//driver chya object ni get text keli
		
		
		
		
		driver.findElement(By.id("alertButton")).click();
		Thread.sleep(3000);
		Alert a1=driver.switchTo().alert(); //alert he vegalya page var yetay mnun 
//driver chya page(object) varun alert chya (page)object var swicth hova lagel
	
		System.out.println(a1.getText());
		//tya alert ok mnun click karanyaadhi tyachi text apn adhi ghetoy
		//you clicked a button
		a1.accept(); //for clicking on ok button
		
		driver.findElement(By.id("timerAlertButton")).click();
		
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(10));
		//as alert is going appear after 05 sec so we need to use implicit wait
		wait.until(ExpectedConditions.alertIsPresent());
		Alert a2=driver.switchTo().alert();
		
		System.out.println(a2.getText());
		a2.accept();
		
	}
	
	public void close_browser()
	{
		 driver.close();
	}
	


}
