import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class baseClass {
    WebDriver driver = new ChromeDriver();


@BeforeSuite

    public void setUp() throws InterruptedException {
// Initialize the WebDriver and open the browser once before any tests start
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

    driver.manage().window().maximize();
    // Navigate to the website at the beginning of each test
    driver.get("https://www.etsy.com/");
    driver.manage().window().maximize();
    WebElement SingInButton = driver.findElement(By.cssSelector("#gnav-header-inner > div.wt-flex-shrink-xs-0 > nav > ul > li:nth-child(1) > button"));
    SingInButton.click();
    Thread.sleep(8000);

        WebElement emailTexbox = driver.findElement(By.xpath("//*[@id=\"join_neu_email_field\"]"));
        emailTexbox.sendKeys("Velveeta_Cheese@outlook.com");
        WebElement passTextbox = driver.findElement(By.xpath("//*[@id=\"join_neu_password_field\"]"));
        passTextbox.sendKeys("Cheese!");

        WebElement logInButton = driver.findElement(By.xpath("//*[@id=\"join-neu-form\"]/div[1]/div/div[7]/div/button"));
        logInButton.click();
        Thread.sleep(12000);
    }
    @AfterSuite
    void closeDriver() throws InterruptedException{
    driver.close();
    }
}

