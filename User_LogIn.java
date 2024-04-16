import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class User_Login {
    WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void setUp() throws InterruptedException {
       // WebDriver driver = new ChromeDriver();
        // Initialize the WebDriver and open the browser once before any tests start
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\USER\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");

        driver.manage().window().maximize();
        // Navigate to the website at the beginning of each test
        driver.get("https://www.etsy.com/");
        driver.manage().window().maximize();
        WebElement SingInButton = driver.findElement(By.cssSelector("#gnav-header-inner > div.wt-flex-shrink-xs-0 > nav > ul > li:nth-child(1) > button"));
        SingInButton.click();
        Thread.sleep(8000);
    }
    @Test(priority = 1) void LogIn_Unsuccess() throws InterruptedException{
        WebElement emailTexbox = driver.findElement(By.xpath("//*[@id=\"join_neu_email_field\"]"));
        emailTexbox.sendKeys("Velveeta_Cheese@outlook.com");
        WebElement passTextbox = driver.findElement(By.xpath("//*[@id=\"join_neu_password_field\"]"));
        passTextbox.sendKeys("Cheese$");

        WebElement logInButton = driver.findElement(By.xpath("//*[@id=\"join-neu-form\"]/div[1]/div/div[7]/div/button"));
        logInButton.click();
        Thread.sleep(3000);
    }
    @Test(priority = 2) void LogIn_success() throws InterruptedException{
        WebElement emailTexbox = driver.findElement(By.xpath("//*[@id=\"join_neu_email_field\"]"));
        emailTexbox.sendKeys("Velveeta_Cheese@outlook.com");
        WebElement passTextbox = driver.findElement(By.xpath("//*[@id=\"join_neu_password_field\"]"));
        passTextbox.sendKeys("Cheese!");

        WebElement logInButton = driver.findElement(By.xpath("//*[@id=\"join-neu-form\"]/div[1]/div/div[7]/div/button"));
        logInButton.click();
        Thread.sleep(3000);

    }
    @Test(priority = 3) void Forgot_Pass() throws InterruptedException, IOException {
        WebElement ForgotButton = driver.findElement(By.xpath("//*[@id=\"join-neu-form\"]/div[1]/div/div[6]/div[2]/a"));
        ForgotButton.click();

        WebElement emailBox = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        emailBox.sendKeys("Velveeta_Cheese@outlook.com");
        Thread.sleep(3000);
        WebElement email_LinkButton = driver.findElement(By.xpath("//*[@id=\"pw-reset-btn\"]"));
        email_LinkButton.click();

        String originalTab = driver.getWindowHandle();
        ((JavascriptExecutor)driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://outlook.live.com/mail/0/");

        Thread.sleep(5000);
        WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"action-oc5b26\"]/span"));
        signInButton.click();

        Thread.sleep(3000);
        ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(2));
        Thread.sleep(3000);
        WebElement signTexbox = driver.findElement(By.xpath("//*[@id=\"i0116\"]"));
        signTexbox.sendKeys("Velveeta_Cheese@outlook.com");
        WebElement nextButton = driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]"));
        nextButton.click();

        Thread.sleep(3000);
        WebElement PassTextbox = driver.findElement(By.xpath("//*[@id=\"i0118\"]"));
        PassTextbox.sendKeys("Velveeta1!");
        WebElement passButton = driver.findElement(By.xpath("//*[@id=\"idSIButton9\"]"));
        passButton.click();

        Thread.sleep(3000);
        WebElement NoButton = driver.findElement(By.id("declineButton"));
        NoButton.click();
        Thread.sleep(3000);

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        File des = new File("C:\\Users\\USER\\Downloads\\stuff\\tmp\\test3.png");
        FileHandler. copy(src, des);
    }
}
