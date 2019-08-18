package TestNG;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FacebookLogin {
	
WebDriver driver;
    
    @BeforeClass
    public void StartBrowser()
    {
	
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kanchan\\Downloads\\chromedriver_win32\\chromedriver.exe");	
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	System.out.println("============Browser started===================");
	
    }
	
    @Test(priority=1)
	public void Login()
	{
	driver.get("https://www.facebook.com/");
	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("7387427077");
	driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Suhas8020");
	driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//input[@id='u_0_a']")).click();
    Boolean b =	driver.findElement(By.xpath("//a[contains(text(),'Home')]")).isDisplayed();
    Assert.assertTrue(b);
	System.out.println("===============Login seccessfull=============");

	}
    
	@Test(priority=2,dependsOnMethods="Login")
	public void LogOut()
	{
	
    driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);
    driver.manage().deleteAllCookies();
	driver.findElement(By.xpath("//div[@id='logoutMenu']")).click();
    List<WebElement> list = driver.findElements(By.xpath("//ul[@class='_54nf']"));
	
	for(WebElement e : list)
	{
		System.out.println("All elements are === "+e.getText());
		if(e.getText().trim().contains("Log Out"))
		{
		e.click();
		break;
		}}
		
    Boolean b = driver.findElement(By.xpath("//input[@id='u_0_a']")).isDisplayed();		//to see whethere LOG IN button displed or not
    Assert.assertSame(b, true);//this is validation point thought the Asser
   // Assert.assertTrue(b, "Home Button is not displed");
    System.out.println("===================LogOut is Successful================");
    
}
	@AfterClass
	public void CloseBrowser()
	{
	
	driver.quit();
	}
	
}