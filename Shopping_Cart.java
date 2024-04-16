import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.IOException;


public class ShoppingCart extends baseClass {
   // WebDriver driver = new ChromeDriver();
   //WebDriver driver = getDriver();
    @Test(priority = 1) void add_to_cart () throws InterruptedException {

        WebElement searchBox = driver.findElement(By.xpath("//*[@id=\"global-enhancements-search-query\"]"));
        searchBox.sendKeys("Wooden Tables");
        WebElement searchButton = driver.findElement(By.cssSelector("#gnav-search > div > div.wt-input-btn-group.global-enhancements-search-input-btn-group.emphasized_search_bar.emphasized_search_bar_grey_bg.search-bar-container > button.wt-input-btn-group__btn.global-enhancements-search-input-btn-group__btn > span > svg"));
        searchButton.click();
        Thread.sleep(4000);

        //Select a wooden table
        driver.findElement(By.cssSelector("#content > div > div.wt-bg-white.wt-grid__item-md-12.wt-pl-xs-1.wt-pr-xs-0.wt-pr-md-1.wt-pl-lg-0.wt-pr-lg-0.wt-bb-xs-1 > div > div.wt-mt-xs-3.wt-text-black > div.wt-grid.wt-pl-xs-0.wt-pr-xs-0.search-listings-group > div:nth-child(2) > div.wt-bg-white.wt-display-block.wt-pb-xs-2.wt-mt-xs-0 > div:nth-child(1) > div > div > ol > li:nth-child(1) > div > div > div.search-half-unit-mt > span.wt-mr-xs-2 > form > button")).click();
        Thread.sleep(4000);

        //go to cart
        driver.findElement(By.cssSelector("#add-to-cart-large-flyout-overlay-content > div > div.wt-position-sticky.wt-position-bottom.wt-display-flex-xs.wt-flex-direction-column-xs.wt-p-xs-5.wt-bg-white.wt-shadow-01 > a.wt-btn.wt-btn--primary.wt-width-full.wt-mt-sm-2")).click();

        //switch to new tab
        String currentTab = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
            }
        }
        Thread.sleep(3000);

        //Choose Options
        Select objSelect = new Select(driver.findElement(By.id("wt-cart-select-tablesize")));
        objSelect.selectByIndex(2);
        Thread.sleep(3000);
        Select objSelect2 = new Select(driver.findElement(By.id("wt-cart-select-tablelegs")));
        objSelect2.selectByIndex(2);
        Thread.sleep(3000);
        //personalize
        WebElement personalization = driver.findElement(By.id("cart-edit-panel-personalization-textarea"));
        personalization.sendKeys("TEST");
        //save
        driver.findElement(By.xpath("//*[@id=\"cart-edit-panel-overlay\"]/div/button[2]")).click();
        Thread.sleep(3000);

        //close driver
        driver.close();
    }


    @Test (priority = 2) void update_quantity () throws InterruptedException {

        //go to cart
        driver.findElement(By.cssSelector("#gnav-header-inner > div.wt-flex-shrink-xs-0 > nav > ul > li:nth-child(6) > span > a > span.wt-z-index-1.wt-no-wrap.ge-cart-badge.wt-badge.wt-badge--notificationPrimary.wt-badge--small.wt-badge--outset-top-right")).click();

        //switch to new tab
        String currentTab = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
            }
        }
        Thread.sleep(3000);


        //Update quantity
        Select objSelect3 = new Select(driver.findElement(By.cssSelector("#multi-shop-cart-list > div.wt-mt-xs-1.wt-mt-lg-0.wt-mb-xs-5.wt-position-relative > div.wt-grid.wt-position-relative.wt-pl-xs-0.wt-pr-xs-0 > ul > li > div > div > ul > li > div > div.wt-flex-xs-3.wt-pl-xs-2.wt-break-word.simplified-cart-min-width-0.wt-pl-md-3 > div > div.wt-grid__item-xs-12.wt-grid__item-md-7 > div.wt-display-flex-xs.wt-justify-content-space-between > div > div > div.wt-grid.wt-align-items-center > div:nth-child(1) > div > div > select")));
        objSelect3.selectByIndex(1);
        Thread.sleep(3000);
    }

    @Test (priority = 3) void remove_item () throws InterruptedException, IOException {

        //go to cart
        driver.findElement(By.cssSelector("#gnav-header-inner > div.wt-flex-shrink-xs-0 > nav > ul > li:nth-child(6) > span > a")).click();

        //switch to new tab
        String currentTab = driver.getWindowHandle();
        for (String tab : driver.getWindowHandles()) {
            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
            }
        }
        Thread.sleep(3000);

        //remove item
        driver.findElement(By.cssSelector("#multi-shop-cart-list > div.wt-mt-xs-1.wt-mt-lg-0.wt-mb-xs-5.wt-position-relative > div.wt-grid.wt-position-relative.wt-pl-xs-0.wt-pr-xs-0 > ul > li > div > div > ul > li > div > div.wt-flex-xs-3.wt-pl-xs-2.wt-break-word.simplified-cart-min-width-0.wt-pl-md-3 > div > div:nth-child(3) > ul > li.wt-list-inline__item.wt-pb-xs-2.wt-pr-xs-1 > a > span")).click();
        Thread.sleep(4000);


        //close driver
        driver.close();
    }
}
