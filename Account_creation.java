import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Account_creation {
        @Test(priority = 1)
        void InValid_Cred() throws InterruptedException {
                System.setProperty("web driver.chrome.driver", "C:\\Users\\USER\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
                WebDriver driver = new ChromeDriver();
                driver.get("https://www.etsy.com/");
                driver.manage().window().maximize();

                WebElement SingInButton = driver.findElement(By.cssSelector("#gnav-header-inner > div.wt-flex-shrink-xs-0 > nav > ul > li:nth-child(1) > button"));
                SingInButton.click();

                Thread.sleep(3000);
                WebElement RegistrationButton = driver.findElement(By.cssSelector("#join-neu-form > div.wt-grid.wt-grid--block > div > div:nth-child(1) > div > button"));
                RegistrationButton.click();

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
                driver.close();
        }
        @Test(priority = 2) void Valid_Cred() throws InterruptedException {
                System.setProperty("web driver.chrome.driver", "C:\\Users\\USER\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
                WebDriver driver = new ChromeDriver();
                driver.get("https://www.etsy.com/");
                driver.manage().window().maximize();

                WebElement SingInButton = driver.findElement(By.cssSelector("#gnav-header-inner > div.wt-flex-shrink-xs-0 > nav > ul > li:nth-child(1) > button"));
                SingInButton.click();

                Thread.sleep(3000);
                WebElement RegistrationButton = driver.findElement(By.cssSelector("#join-neu-form > div.wt-grid.wt-grid--block > div > div:nth-child(1) > div > button"));
                RegistrationButton.click();

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
                System.setProperty("web driver.chrome.driver", "C:\\Users\\USER\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
                WebDriver driver = new ChromeDriver();
                driver.get("https://www.etsy.com/");
                driver.manage().window().maximize();
                //driver.manage().window().maximize();
                String originalTab = driver.getWindowHandle();
                ((JavascriptExecutor)driver).executeScript("window.open()");
                ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(tabs.get(1));
                driver.get("https://outlook.live.com/mail/0/");

                Thread.sleep(5000);
                WebElement signInButton = driver.findElement(By.xpath("//*[@id=\"feature-oc387eee\"]/div/div/div[1]/div/div[3]/div[1]/a"));
                signInButton.click();

                Thread.sleep(3000);
                ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
                driver.switchTo().window(tab.get(2));
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
                WebElement emailView = driver.findElement(By.xpath("//*[@id=\"AQAAAAAAAQABAAAAAGBdmQAAAAA=\"]"));
                emailView.click();
                //WebElement confirm = driver.findElement(By.xpath("//*[@id=\"UniqueMessageBody\"]/div/div/div/div/table/tbody/tr[3]/th/table/tbody/tr/td/table/tbody/tr/td/table[1]/tbody/tr/td/div/a"));
                //confirm.click();
                //driver.switchTo().window(originalTab);

        }










}

