import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

public class Search_Functionality extends baseClass {
    //WebDriver driver = new ChromeDriver();

    @Test(priority = 1) void searchTest() throws InterruptedException {

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

        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"global-enhancements-search-query\"]"));
        searchBox.sendKeys("Wooden Tables");
        Thread.sleep(5000);

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        File des = new File("C:\\Users\\USER\\Downloads\\stuff\\tmp\\test3.png");
        FileHandler.copy(src, des);


    }
}
