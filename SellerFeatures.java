import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.util.Scanner;

public class SellerFeatures {
    @Test (priority = 1) void listing_new_item () throws InterruptedException {
        //Open the Chrome browser and go to the etsy website
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\cathe\\Documents\\Testing\\Drivers\\Chrome_driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.googleadservices.com/pagead/aclk?sa=L&ai=DChcSEwierub5-qSFAxUOn1oFHRlhBk8YABAAGgJ2dQ&ase=2&gclid=Cj0KCQjw2a6wBhCVARIsABPeH1sfuhVbZE_b9BrKlckbud9VjqBSGe15DwfrI0hn6kgRwkdNoTjNou4aAj75EALw_wcB&ohost=www.google.com&cid=CAESVuD2PB8LpVaZa1SP5nl-MoSI6PLNZdqlku3d0SYjojTWUmBJ_5LsbpYRzYx-d47nIQVuLHPo1V1Dp0W8qPAvLrh2o0gBQOAD2zig5sPDXpTAsZzt7QRk&sig=AOD64_3GUgvUkzl90PYmkNQrTlodwBXDJg&q&nis=4&adurl&ved=2ahUKEwjNk9_5-qSFAxVaVTABHVlADfUQ0Qx6BAgGEAE");
        //Maximize the window that the driver opened
        driver.manage().window().maximize();
        //Sleep for 4 seconds before continuing
        Thread.sleep(4000);
        System.out.println("This opens the etsy browser");

        //Click on Profile button (top right)
        driver.findElement(By.xpath("//*[@id=\"gnav-header-inner\"]/div[4]/nav/ul/li[4]/div/button/span[1]\n")).click();
        Thread.sleep(3000);

        //click on "sell on Etsy"
        driver.findElement(By.xpath("//*[@id=\"gnav-header-inner\"]/div[4]/nav/ul/li[4]/div/div/ul/li[10]/a/div[2]/p")).click();
        Thread.sleep(3000);

        //click on "open your Etsy shop"
        driver.findElement(By.id("id=\"intro-section-open-etsy-shop-button\"")).click();

    }

    @Test (priority = 2) void edit_listing () {

    }

    @Test (priority = 3) void seller_dashboard () {

    }
}
