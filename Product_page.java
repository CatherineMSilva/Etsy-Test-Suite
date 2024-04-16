import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

public class Product_page extends baseClass {
  //  WebDriver driver = new ChromeDriver();


    @Test(priority = 1) void infoDisplay() throws InterruptedException, IOException {
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"global-enhancements-search-query\"]"));
        searchBox.sendKeys("Wooden Tables");
        WebElement searchButton = driver.findElement(By.cssSelector("#gnav-search > div > div.wt-input-btn-group.global-enhancements-search-input-btn-group.emphasized_search_bar.emphasized_search_bar_grey_bg.search-bar-container > button.wt-input-btn-group__btn.global-enhancements-search-input-btn-group__btn > span > svg"));
        searchButton.click();
        Thread.sleep(3000);
        WebElement listing = driver.findElement(By.xpath("//*[@id=\"listing-title-1028007759\"]"));
        listing.click();
        Thread.sleep(3000);
        //WebElement popUp = driver.findElement(By.cssSelector("#favorite-listing-nudge > span.wt-display-flex-xs > button > span > svg > path"));
        //popUp.click();


        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        exe.executeScript("window.scroll(0,200)", "");

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        File des = new File("C:\\Users\\USER\\Downloads\\stuff\\tmp\\test3.png");
        FileHandler.copy(src, des);
    }
    @Test(priority = 2) void productReviews() throws InterruptedException{
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"global-enhancements-search-query\"]"));
        searchBox.sendKeys("Wooden Tables");
        WebElement searchButton = driver.findElement(By.cssSelector("#gnav-search > div > div.wt-input-btn-group.global-enhancements-search-input-btn-group.emphasized_search_bar.emphasized_search_bar_grey_bg.search-bar-container > button.wt-input-btn-group__btn.global-enhancements-search-input-btn-group__btn > span > svg"));
        searchButton.click();
        Thread.sleep(3000);
        WebElement listing = driver.findElement(By.xpath("//*[@id=\"listing-title-1028007759\"]"));
        listing.click();
        Thread.sleep(3000);

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)", "");
        WebElement sortDropdown = driver.findElement(By.cssSelector("#sort-reviews-menu > button > span.wt-menu__trigger__label"));
        sortDropdown.click();
        Thread.sleep(3000);
        WebElement mostRecent = driver.findElement(By.xpath("//*[@id=\"sort-reviews-menu\"]/div/button[2]"));
        mostRecent.click();
    }
    @Test(priority = 3) void likeProduct()throws InterruptedException{
        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"global-enhancements-search-query\"]"));
        searchBox.sendKeys("Wooden Tables");
        WebElement searchButton = driver.findElement(By.cssSelector("#gnav-search > div > div.wt-input-btn-group.global-enhancements-search-input-btn-group.emphasized_search_bar.emphasized_search_bar_grey_bg.search-bar-container > button.wt-input-btn-group__btn.global-enhancements-search-input-btn-group__btn > span > svg"));
        searchButton.click();
        Thread.sleep(3000);
        WebElement listing = driver.findElement(By.xpath("//*[@id=\"listing-title-1028007759\"]"));
        listing.click();
        Thread.sleep(3000);

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"favorite-listing-button-tooltip--container\"]/button/div/span[1]/svg/path")));

        WebElement likeButton = driver.findElement(By.xpath("//*[@id=\"listing-page-cart\"]/div[7]/div[2]/div/button"));
        likeButton.click();
        Thread.sleep(3000);
        WebElement doneButton = driver.findElement(By.xpath("//*[@id=\"user-lists-overlay\"]/div/div/div[1]/div[4]/div/div/button"));
        doneButton.click();
    }
}
