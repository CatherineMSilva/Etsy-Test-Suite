import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


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
    }

    /*
    @Test (priority = 2) void update_quantity () throws InterruptedException {
        //Open the Chrome browser and go to the etsy website
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\cathe\\Documents\\Testing\\Drivers\\Chrome_driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.etsy.com/");
        //Maximize the window that the driver opened
        driver.manage().window().maximize();
        //Sleep for 4 seconds before continuing
        Thread.sleep(4000);
        System.out.println("This opens the etsy browser");

        //Add item to the cart
        //scroll down
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        exe.executeScript("window.scrollBy(0,450)");
        Thread.sleep(3000);
        //select item
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[5]/div/div[2]/div[1]/div")).click();

        //Save this windows page to come back to
        String oldTab = driver.getWindowHandle();
        Thread.sleep(4000);
        //switch focus to new tab
        String currentTab = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
            }
        }
        //choose color option
        Select objSelect = new Select(driver.findElement(By.xpath("//*[@id=\"variation-selector-0\"]")));
        objSelect.selectByIndex(2);
        Thread.sleep(3000);
        //choose font option
        Select objSelect2 = new Select(driver.findElement(By.xpath("//*[@id=\"variation-selector-1\"]")));
        objSelect2.selectByIndex(2);
        Thread.sleep(3000);
        //text option
        driver.findElement(By.xpath("//*[@id=\"listing-page-personalization-textarea\"]")).sendKeys("CAT");
        Thread.sleep(3000);
        //add to cart
        driver.findElement(By.xpath("//*[@id=\"listing-page-cart\"]/div[7]/div[1]/div[3]/div[2]/div/form/div")).click();

    }
    
    @Test (priority = 3) void save_cart () throws InterruptedException {
        //Open the Chrome browser and go to the etsy website
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\cathe\\Documents\\Testing\\Drivers\\Chrome_driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.etsy.com");
        //Maximize the window that the driver opened
        driver.manage().window().maximize();
        //Sleep for 4 seconds before continuing
        Thread.sleep(4000);
        System.out.println("This opens the etsy browser");

        //Add item to the cart
        //scroll down
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        exe.executeScript("window.scrollBy(0,450)");
        Thread.sleep(3000);
        //select item
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[5]/div/div[2]/div[1]/div")).click();

        //Save this windows page to come back to
        String oldTab = driver.getWindowHandle();
        Thread.sleep(4000);
        //switch focus to new tab
        String currentTab = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
            }
        }
        //choose color option
        driver.findElement(By.xpath("//*[@id=\"variation-selector-0\"]")).click();
        Select objSelect = new Select(driver.findElement(By.id("variation-selector-0")));
        objSelect.selectByIndex(2);
        Thread.sleep(3000);
        //choose font option
        driver.findElement(By.xpath("//*[@id=\"variation-selector-1\"]")).click();
        Select objSelect2 = new Select(driver.findElement(By.id("variation-selector-0")));
        objSelect2.selectByIndex(2);
        Thread.sleep(3000);
        //text option
        driver.findElement(By.id("//*[@id=\"listing-page-personalization-textarea\"]")).sendKeys("CAT"); //not applicable
        //add to cart
        driver.findElement(By.xpath("//*[@id=\"listing-page-cart\"]/div[7]/div[1]/div[4]/div[2]/div/form/div/button")).click();

    }
    
}
