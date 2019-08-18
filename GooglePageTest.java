package TestNG;

import java.util.concurrent.TimeUnit;





public class GooglePageTest {
	
    public static WebDriver driver;

    @BeforeClass	
	public void SetUp()
	{
				
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kanchan\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);

		
		driver.get("http://www.google.com");
		
	}
	
	@Test
	
	public void GoogleTitle() {
	
//	WebDriver driver = new ChromeDriver();
	
	System.out.println("driver ----- = "+ driver);		
		
	System.out.println(driver.getTitle());	
		
	
	}
	
	@Test
	
	public void GoogleLogo() {

	//WebDriver driver = new ChromeDriver();
	
	Boolean b = driver.findElement(By.xpath("//img[@id='hplogo']")).isDisplayed();	
		
	}
	
    @AfterMethod
    
    public void GoogleClose() {
    
    //WebDriver driver = new ChromeDriver();
    	
    driver.quit();	
    	
    	
    }
    }
	
	

