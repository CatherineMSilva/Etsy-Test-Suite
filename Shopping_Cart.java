import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;


public class ShoppingCart {
    @Test(priority = 1) void add_and_remove () throws InterruptedException {
        System.setProperty("web driver.chrome.driver", "C:\\Users\\USER\\Downloads\\chromedriver-win32\\chromedriver-win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.etsy.com");
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
        Thread.sleep(4000);

        //Select a wooden table
        driver.findElement(By.cssSelector("#content > div > div.wt-bg-white.wt-grid__item-md-12.wt-pl-xs-1.wt-pr-xs-0.wt-pr-md-1.wt-pl-lg-0.wt-pr-lg-0.wt-bb-xs-1 > div > div.wt-mt-xs-3.wt-text-black > div.wt-grid.wt-pl-xs-0.wt-pr-xs-0.search-listings-group > div:nth-child(2) > div.wt-bg-white.wt-display-block.wt-pb-xs-2.wt-mt-xs-0 > div:nth-child(1) > div > div > ol > li:nth-child(1) > div > div > div.search-half-unit-mt > span.wt-mr-xs-2 > form > button")).click();
        Thread.sleep(4000);

        //go to cart
        driver.findElement(By.xpath("//*[@id=\"add-to-cart-large-flyout-overlay-content\"]/div/div[2]/a[2]")).click();


        //switch to new tab
        String currentTab = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
            }
        }
        Thread.sleep(3000);

        //Choose Options
        Select objSelect = new Select(driver.findElement(By.xpath("//*[@id=\"wt-cart-select-size\"]")));
        objSelect.selectByIndex(2);
        Thread.sleep(3000);
        Select objSelect2 = new Select(driver.findElement(By.xpath("//*[@id=\"wt-cart-select-add-on\"]")));
        objSelect2.selectByIndex(2);
        Thread.sleep(3000);
        //select
        driver.findElement(By.xpath("//*[@id=\"cart-edit-panel-overlay\"]/div/button[2]")).click();
        Thread.sleep(3000);

        //Remove item from cart
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"multi-shop-cart-list\"]/div[1]/div[1]/ul/li[1]/div/div/ul/li/div/div[2]/div/div[3]/ul/li[2]/a")).click();

        //close driver
        driver.close();
    }


    @Test (priority = 2) void update_quantity () throws InterruptedException {
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
        Thread.sleep(4000);

        //Select a wooden table
        driver.findElement(By.cssSelector("#content > div > div.wt-bg-white.wt-grid__item-md-12.wt-pl-xs-1.wt-pr-xs-0.wt-pr-md-1.wt-pl-lg-0.wt-pr-lg-0.wt-bb-xs-1 > div > div.wt-mt-xs-3.wt-text-black > div.wt-grid.wt-pl-xs-0.wt-pr-xs-0.search-listings-group > div:nth-child(2) > div.wt-bg-white.wt-display-block.wt-pb-xs-2.wt-mt-xs-0 > div:nth-child(1) > div > div > ol > li:nth-child(1) > div > div > div.search-half-unit-mt > span.wt-mr-xs-2 > form > button")).click();
        Thread.sleep(4000);

        //go to cart
        driver.findElement(By.cssSelector("#add-to-cart-flyout-footer > a > button")).click();

        //switch to new tab
        String currentTab = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
            }
        }
        Thread.sleep(3000);

        //Choose Options
        Select objSelect = new Select(driver.findElement(By.xpath("//*[@id=\"wt-cart-select-size\"]")));
        objSelect.selectByIndex(2);
        Thread.sleep(3000);
        Select objSelect2 = new Select(driver.findElement(By.xpath("//*[@id=\"wt-cart-select-add-on\"]")));
        objSelect2.selectByIndex(2);
        Thread.sleep(3000);
        //select
        driver.findElement(By.xpath("//*[@id=\"cart-edit-panel-overlay\"]/div/button[2]")).click();
        Thread.sleep(3000);

        //Update quantity
        Select objSelect3 = new Select(driver.findElement(By.cssSelector("#multi-shop-cart-list > div.wt-mt-xs-1.wt-mt-lg-0.wt-mb-xs-5.wt-position-relative > div.wt-grid.wt-position-relative.wt-pl-xs-0.wt-pr-xs-0 > ul > li > div > div > ul > li > div > div.wt-flex-xs-3.wt-pl-xs-2.wt-break-word.simplified-cart-min-width-0.wt-pl-md-3 > div > div.wt-grid__item-xs-12.wt-grid__item-md-7 > div.wt-display-flex-xs.wt-justify-content-space-between > div > div > div.wt-grid.wt-align-items-center > div:nth-child(1) > div > div > select")));
        objSelect3.selectByIndex(3);
        Thread.sleep(3000);
    }

    @Test (priority = 3) void save_cart () throws InterruptedException, IOException {
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

        //go to cart and check that item saved
        driver.findElement(By.cssSelector("#gnav-header-inner > div.wt-flex-shrink-xs-0 > nav > ul > li:nth-child(6) > span > a")).click();
        //take screenshot to make sure
        TakesScreenshot screenshot=(TakesScreenshot)driver;
        File src=screenshot.getScreenshotAs(OutputType.FILE);
        File des=new File("C:\\Users\\cathe\\Documents\\Testing\\Screenshot\\screenshot.png");
        FileHandler.copy(src,des);

    }
}
