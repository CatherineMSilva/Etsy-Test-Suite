import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Search_Functionality {

    @Test(priority = 1) void searchTest() throws InterruptedException {
        System.setProperty("web driver.chrome.driver", "C:\\Users\\USER\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.etsy.com/");
        driver.manage().window().maximize();

        WebElement SingInButton = driver.findElement(By.cssSelector("#gnav-header-inner > div.wt-flex-shrink-xs-0 > nav > ul > li:nth-child(1) > button"));
        SingInButton.click();
        Thread.sleep(3000);
        WebElement emailTexbox = driver.findElement(By.xpath("//*[@id=\"join_neu_email_field\"]"));
        emailTexbox.sendKeys("Velveeta_Cheese@outlook.com");
        WebElement passTextbox = driver.findElement(By.xpath("//*[@id=\"join_neu_password_field\"]"));
        passTextbox.sendKeys("Cheese!");

        WebElement logInButton = driver.findElement(By.xpath("//*[@id=\"join-neu-form\"]/div[1]/div/div[7]/div/button"));
        logInButton.click();
        Thread.sleep(3000);

        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"global-enhancements-search-query\"]"));
        searchBox.sendKeys("Wooden Tables");
        WebElement searchButton = driver.findElement(By.cssSelector("#gnav-search > div > div.wt-input-btn-group.global-enhancements-search-input-btn-group.emphasized_search_bar.emphasized_search_bar_grey_bg.search-bar-container > button.wt-input-btn-group__btn.global-enhancements-search-input-btn-group__btn > span > svg"));
        searchButton.click();
        Thread.sleep(3000);
        WebElement searchBox2 = driver.findElement(By.xpath("//*[@id=\"global-enhancements-search-query\"]"));
        searchBox2.clear();
        searchBox2.sendKeys("cool socks");
        WebElement searchButton2 = driver.findElement(By.cssSelector("#gnav-search > div > div.wt-input-btn-group.global-enhancements-search-input-btn-group.emphasized_search_bar.emphasized_search_bar_grey_bg.search-bar-container > button.wt-input-btn-group__btn.global-enhancements-search-input-btn-group__btn > span > svg"));
        searchButton2.click();
    }
    @Test(priority = 2) void filterSearch() throws InterruptedException{
        System.setProperty("web driver.chrome.driver", "C:\\Users\\USER\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.etsy.com/");
        driver.manage().window().maximize();

        WebElement SingInButton = driver.findElement(By.cssSelector("#gnav-header-inner > div.wt-flex-shrink-xs-0 > nav > ul > li:nth-child(1) > button"));
        SingInButton.click();
        Thread.sleep(3000);
        WebElement emailTexbox = driver.findElement(By.xpath("//*[@id=\"join_neu_email_field\"]"));
        emailTexbox.sendKeys("Velveeta_Cheese@outlook.com");
        WebElement passTextbox = driver.findElement(By.xpath("//*[@id=\"join_neu_password_field\"]"));
        passTextbox.sendKeys("Cheese!");

        WebElement logInButton = driver.findElement(By.xpath("//*[@id=\"join-neu-form\"]/div[1]/div/div[7]/div/button"));
        logInButton.click();
        Thread.sleep(3000);

        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"global-enhancements-search-query\"]"));
        searchBox.sendKeys("Wooden Tables");
        WebElement searchButton = driver.findElement(By.cssSelector("#gnav-search > div > div.wt-input-btn-group.global-enhancements-search-input-btn-group.emphasized_search_bar.emphasized_search_bar_grey_bg.search-bar-container > button.wt-input-btn-group__btn.global-enhancements-search-input-btn-group__btn > span > svg"));
        searchButton.click();
        Thread.sleep(3000);
        WebElement filterButton = driver.findElement(By.xpath("//*[@id=\"search-filter-button\"]/span[2]"));
        filterButton.click();
        Thread.sleep(3000);
        WebElement locationRadio = driver.findElement(By.xpath("//*[@id=\"search-filter-form\"]/div/div[1]/div[2]/fieldset/div/div/div[2]/label"));
        locationRadio.click();
        //WebElement locationBox = driver.findElement(By.xpath("//*[@id=\"shop-location-input\"]"));
        //locationBox.sendKeys("florida");
        Thread.sleep(3000);
        WebElement saleCheckBox = driver.findElement(By.xpath("//*[@id=\"search-filter-form\"]/div/div[1]/div[1]/fieldset/div/div/div[2]/div/label"));
        saleCheckBox.click();
        Thread.sleep(3000);
        WebElement resetButton = driver.findElement(By.xpath("//*[@id=\"search-filter-form\"]/div/div[1]/div[2]/fieldset/div/div/div[2]/div/label"));
        resetButton.click();
        WebElement exitButton = driver.findElement(By.xpath("//*[@id=\"search-filters-overlay\"]/div/button/span/svg"));
        exitButton.click();
    }
    @Test(priority = 3) void autoSuggestion() throws InterruptedException, IOException {
        System.setProperty("web driver.chrome.driver", "C:\\Users\\USER\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.etsy.com/");
        driver.manage().window().maximize();

        WebElement SingInButton = driver.findElement(By.cssSelector("#gnav-header-inner > div.wt-flex-shrink-xs-0 > nav > ul > li:nth-child(1) > button"));
        SingInButton.click();
        Thread.sleep(3000);
        WebElement emailTexbox = driver.findElement(By.xpath("//*[@id=\"join_neu_email_field\"]"));
        emailTexbox.sendKeys("Velveeta_Cheese@outlook.com");
        WebElement passTextbox = driver.findElement(By.xpath("//*[@id=\"join_neu_password_field\"]"));
        passTextbox.sendKeys("Cheese!");

        WebElement logInButton = driver.findElement(By.xpath("//*[@id=\"join-neu-form\"]/div[1]/div/div[7]/div/button"));
        logInButton.click();
        Thread.sleep(3000);

        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"global-enhancements-search-query\"]"));
        searchBox.sendKeys("Wooden Tables");
        Thread.sleep(5000);

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        File des = new File("C:\\Users\\USER\\Downloads\\stuff\\tmp\\test3.png");
        FileHandler.copy(src, des);


    }
}
