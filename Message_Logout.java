import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Message_Logout extends baseClass {
    //WebDriver driver = new ChromeDriver();
    //WebDriver driver = getDriver();
    @Test(priority = 1) void Message() throws InterruptedException {

        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"global-enhancements-search-query\"]"));
        searchBox.sendKeys("Wooden Tables");
        WebElement searchButton = driver.findElement(By.cssSelector("#gnav-search > div > div.wt-input-btn-group.global-enhancements-search-input-btn-group.emphasized_search_bar.emphasized_search_bar_grey_bg.search-bar-container > button.wt-input-btn-group__btn.global-enhancements-search-input-btn-group__btn > span > svg"));
        searchButton.click();
        Thread.sleep(3000);
        WebElement listing = driver.findElement(By.xpath("//*[@id=\"listing-title-1028007759\"]"));
        listing.click();
        Thread.sleep(3000);
        JavascriptExecutor exe = (JavascriptExecutor) driver;
        exe.executeScript("window.scroll(0,200)", "");

        WebElement MessageSeller = driver.findElement(By.cssSelector("#desktop_shop_owners_parent > a"));
        MessageSeller.click();

        WebElement messageBox = driver.findElement(By.xpath("//*[@id=\"chat-ui-composer\"]/div[1]/div[1]/textarea"));
        messageBox.sendKeys("nice table..");
        Thread.sleep(5000);
    }
    @Test(priority = 2) void singOUt() throws InterruptedException{
        WebElement Profile_dropDown = driver.findElement(By.cssSelector("#gnav-header-inner > div.wt-flex-shrink-xs-0 > nav > ul > li:nth-child(5) > div > button > span.wt-menu__trigger__label"));
        Profile_dropDown.click();
        Thread.sleep(3000);
        WebElement Signout = driver.findElement(By.cssSelector("#gnav-header-inner > div.wt-flex-shrink-xs-0 > nav > ul > li:nth-child(5) > div > div > ul > li:nth-child(11) > a > div:nth-child(1) > span > svg"));
        Signout.click();
        Thread.sleep(5000);
        driver.close();
    }
}
