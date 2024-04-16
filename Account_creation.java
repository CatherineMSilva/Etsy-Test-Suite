import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;

public class Account_creation {
       // public WebDriver driver;
       WebDriver driver = new ChromeDriver();
        @BeforeClass
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
        }

        @BeforeMethod
        public void navigateToHomePage() throws InterruptedException {


                Thread.sleep(3000);
                WebElement RegistrationButton = driver.findElement(By.cssSelector("#join-neu-form > div.wt-grid.wt-grid--block > div > div:nth-child(1) > div > button"));
                RegistrationButton.click();

        }

        @Test(priority = 1)
        void InValid_Cred() throws InterruptedException {
                Thread.sleep(3000);
                WebElement EmailTextBox = driver.findElement(By.xpath("//*[@id=\"join_neu_email_field\"]"));
                EmailTextBox.sendKeys("Hello.@gmail.com");

                Thread.sleep(3000);
                WebElement NameTextBox = driver.findElement(By.xpath("//*[@id=\"join_neu_first_name_field\"]"));
                NameTextBox.sendKeys("Velveeta");

                Thread.sleep(3000);
                WebElement PassTextBox = driver.findElement(By.xpath("//*[@id=\"join_neu_password_field\"]"));
                PassTextBox.sendKeys("Cheese!");

                WebElement subButton = driver.findElement(By.cssSelector("#join-neu-form > div.wt-grid.wt-grid--block > div > div:nth-child(10) > div > button"));
                subButton.click();
                Thread.sleep(3000);
        }
        @Test(priority = 2) void Valid_Cred() throws InterruptedException {
                Thread.sleep(3000);
                WebElement EmailTextBox = driver.findElement(By.xpath("//*[@id=\"join_neu_email_field\"]"));
                EmailTextBox.sendKeys("Velveeta_Cheese@outlook.com");

                Thread.sleep(3000);
                WebElement NameTextBox = driver.findElement(By.xpath("//*[@id=\"join_neu_first_name_field\"]"));
                NameTextBox.sendKeys("Velveeta");

                Thread.sleep(3000);
                WebElement PassTextBox = driver.findElement(By.xpath("//*[@id=\"join_neu_password_field\"]"));
                PassTextBox.sendKeys("Cheese!");

                WebElement subButton = driver.findElement(By.cssSelector("#join-neu-form > div.wt-grid.wt-grid--block > div > div:nth-child(10) > div > button"));
                subButton.click();

                Thread.sleep(3000);
                WebElement exitButton = driver.findElement(By. cssSelector("#join-neu-overlay > div > button > span > svg > path"));
                exitButton.click();
        }
        @Test(priority = 3) void Verify_email() throws InterruptedException{
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

                Thread.sleep(5000);
                WebElement emailView = driver.findElement(By.xpath("//*[@id=\"AQAAAAAAAQABAAAAAGBdmQAAAAA=\"]/div/div/div[2]/div[2]/div[2]/div/span"));
                emailView.click();
                Thread.sleep(5000);
                WebElement confirm = driver.findElement(By.cssSelector("#UniqueMessageBody > div > div > div > div > table > tbody > tr:nth-child(3) > th > table > tbody > tr > td > table > tbody > tr > td > table:nth-child(1) > tbody > tr > td > div > a"));
                confirm.click();
                Thread.sleep(5000);
                driver.switchTo().window(originalTab);
        }
}

