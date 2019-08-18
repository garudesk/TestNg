package TestNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FacebookPageTest

{
    WebDriver driver;
    
    @BeforeClass
    public void StartBrowser()
    {
	
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kanchan\\Downloads\\chromedriver_win32\\chromedriver.exe");	
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	System.out.println("============Browser started===================");
	
    }
	
    @Test(priority=1,groups="Login")
	public void Login()
	{
	driver.get("http://www.chummyclub.com/index.php");
	driver.findElement(By.xpath("//input[@id='username']")).sendKeys("garudesk");
	driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Suhas8020");
	driver.findElement(By.xpath("//tr[7]//td[1]//input[1]")).click();
    Boolean b =	driver.findElement(By.xpath("//a[contains(text(),'Radio Puja')]")).isDisplayed();
    Assert.assertTrue(b);
	System.out.println("===============Login seccessfull=====================");

	}
	
   @Test(priority=2,groups="HomePage",dependsOnMethods="Login") 
   public void Homapage() {
	   
	   driver.findElement(By.xpath("//a[contains(text(),'Find Match')]")).click();
	   driver.findElement(By.xpath("//li[@class='active']//a[contains(text(),'Perfect Match')]")).click();
	   List<WebElement> list = driver.findElements(By.xpath("//div[contains(@class,'tabberlive')]//div[contains(@class,'')]"));
	   System.out.println("Number of persons ---- = --- "+list.size());
	   
   }	   
   
   @Test(priority=3,groups="LogOut",dependsOnMethods="Login")
   public void LogOut()
   {

	   driver.findElement(By.xpath("//b[contains(text(),'Logout')]")).click();
	   
	   String st = driver.getCurrentUrl();
	   
	   Assert.assertEquals(st, "http://www.chummyclub.com/index.php","LogOut is not successfull");
	   
	   System.out.println("===============LogOut Is Successfull=====================");
    }
   @AfterClass
   public void CloseBrowser()
   {
   
   driver.quit();
	   
   }}