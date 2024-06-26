import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckoutProcess extends baseClass {
    //WebDriver driver = new ChromeDriver();

    @Test (priority = 1) void shipping () throws InterruptedException {

        //go to cart and check that item saved
        driver.findElement(By.cssSelector("#gnav-header-inner > div.wt-flex-shrink-xs-0 > nav > ul > li:nth-child(6) > span > a")).click();
        Thread.sleep(3000);

        //Begin checkout
        driver.findElement(By.cssSelector("#multi-shop-cart-list > div.wt-mt-xs-1.wt-mt-lg-0.wt-mb-xs-5.wt-position-relative > div.wt-grid.wt-position-relative.wt-pl-xs-0.wt-pr-xs-0 > div > div > div.multi-shop-cart-payment.wt-p-md-3 > form > div:nth-child(6) > div.wt-pb-xs-2 > button")).click();
        //click "ship here"
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#shipping-address-list > form > div > div > ul > li > div.wt-radio > label > div > div:nth-child(2) > div > div.wt-grid__item-xs-12.wt-p-xs-0.wt-mb-xs-2 > button")).click();
    }

    @Test (priority = 2) void payment_method () throws InterruptedException {

        //go to cart and check that item saved
        driver.findElement(By.cssSelector("#gnav-header-inner > div.wt-flex-shrink-xs-0 > nav > ul > li:nth-child(6) > span > a")).click();
        Thread.sleep(3000);

        //Begin checkout
        driver.findElement(By.cssSelector("#multi-shop-cart-list > div.wt-mt-xs-1.wt-mt-lg-0.wt-mb-xs-5.wt-position-relative > div.wt-grid.wt-position-relative.wt-pl-xs-0.wt-pr-xs-0 > div > div > div.multi-shop-cart-payment.wt-p-md-3 > form > div:nth-child(6) > div.wt-pb-xs-2 > button")).click();
        //click "ship here"
        driver.findElement(By.cssSelector("#shipping-address-list > form > div > div > ul > li > div.wt-radio > label > div > div:nth-child(2) > div > div.wt-grid__item-xs-12.wt-p-xs-0.wt-mb-xs-2 > button")).click();

        //put in "card info"
        Thread.sleep(3000);
        WebElement nameOnCard = driver.findElement(By.xpath("//*[@id=\"cc-name--paymentstep\"]"));
        nameOnCard.sendKeys("Remy Rat");
        Thread.sleep(3000);
        WebElement cardNumber = driver.findElement(By.xpath("//*[@id=\"cc-num--paymentstep\"]"));
        cardNumber.sendKeys("1234567890000000");
        Thread.sleep(3000);
        WebElement CCV = driver.findElement(By.id("cc-ccv--paymentstep"));
        CCV.sendKeys("123");

    }

    @Test (priority = 3) void discounts () throws InterruptedException {

        //go to cart and check that item saved
        driver.findElement(By.cssSelector("#gnav-header-inner > div.wt-flex-shrink-xs-0 > nav > ul > li:nth-child(6) > span > a")).click();
        Thread.sleep(3000);

        //Begin checkout
        driver.findElement(By.cssSelector("#multi-shop-cart-list > div.wt-mt-xs-1.wt-mt-lg-0.wt-mb-xs-5.wt-position-relative > div.wt-grid.wt-position-relative.wt-pl-xs-0.wt-pr-xs-0 > div > div > div.multi-shop-cart-payment.wt-p-md-3 > form > div:nth-child(6) > div.wt-pb-xs-2 > button")).click();
        //click "ship here"
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#shipping-address-list > form > div > div > ul > li > div.wt-radio > label > div > div:nth-child(2) > div > div.wt-grid__item-xs-12.wt-p-xs-0.wt-mb-xs-2 > button")).click();

        //put in discount promo code
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[4]/div/div/div[3]/div[2]/div/button")).click();
        Thread.sleep(3000);
        WebElement promoCode = driver.findElement(By.xpath("//*[@id=\"payment-redeem-gc\"]"));
        Thread.sleep(3000);
        promoCode.sendKeys("PROMOCODE123");
    }
}
