import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Profile_Edit extends baseClass{
    //WebDriver driver = new ChromeDriver();


    @BeforeMethod
    public void navigateToHomePage() throws InterruptedException {
        WebElement Profile_dropDown = driver.findElement(By.cssSelector("#gnav-header-inner > div.wt-flex-shrink-xs-0 > nav > ul > li:nth-child(5) > div > button > span.wt-menu__trigger__label"));
        Profile_dropDown.click();
        Thread.sleep(3000);
        WebElement ViewYourProf = driver.findElement(By.cssSelector("#gnav-header-inner > div.wt-flex-shrink-xs-0 > nav > ul > li:nth-child(5) > div > div > ul > li:nth-child(1) > a > span > p"));
        ViewYourProf.click();
        Thread.sleep(3000);

    }

    @Test(priority = 1) void addProfilePicture() throws InterruptedException{

        WebElement EditPubProf = driver.findElement(By.cssSelector("#focused_search_large_header > div > div > div.wt-order-xs-2.wt-order-md-1.wt-grid__item-xs-12.wt-grid__item-md-11 > div > div > div > a"));
        EditPubProf.click();
        Thread.sleep(3000);

        String filePath = "C:\\Users\\USER\\Downloads\\stuff\\tmp";
        WebElement Choose_file = driver.findElement(By.cssSelector("#avatar"));
        Choose_file.sendKeys(filePath);
    }
    @Test(priority = 2) void genderRadio() throws InterruptedException{

        WebElement Popup = driver.findElement(By.cssSelector("#photo-upload-nudge > span.wt-display-flex-xs > button > span > svg"));
        Popup.click();
        Thread.sleep(3000);
        WebElement EditPubProf = driver.findElement(By.cssSelector("#focused_search_large_header > div > div > div.wt-order-xs-2.wt-order-md-1.wt-grid__item-xs-12.wt-grid__item-md-11 > div > div > div > a"));
        EditPubProf.click();

        WebElement genRadio = driver.findElement(By.xpath("//*[@id=\"male\"]"));
        genRadio.click();
    }
    @Test(priority = 3) void changeCity() throws InterruptedException {

        WebElement Popup = driver.findElement(By.cssSelector("#photo-upload-nudge > span.wt-display-flex-xs > button > span > svg"));
        Popup.click();
        Thread.sleep(3000);
        WebElement EditPubProf = driver.findElement(By.cssSelector("#focused_search_large_header > div > div > div.wt-order-xs-2.wt-order-md-1.wt-grid__item-xs-12.wt-grid__item-md-11 > div > div > div > a"));
        EditPubProf.click();

        WebElement cityTextbox = driver.findElement(By.xpath("//*[@id=\"city3\"]"));
        cityTextbox.sendKeys("Fort Myers, Florida, United States Of America");

    }
    @Test(priority = 4) void editBirthday() throws InterruptedException{

        WebElement Popup = driver.findElement(By.cssSelector("#photo-upload-nudge > span.wt-display-flex-xs > button > span > svg"));
        Popup.click();
        Thread.sleep(3000);
        WebElement EditPubProf = driver.findElement(By.cssSelector("#focused_search_large_header > div > div > div.wt-order-xs-2.wt-order-md-1.wt-grid__item-xs-12.wt-grid__item-md-11 > div > div > div > a"));
        EditPubProf.click();

        WebElement monthDrop = driver.findElement(By.xpath("//*[@id=\"birth-month\"]"));
        Select dropdown = new Select(monthDrop); //using select class create object dropdown.
        dropdown.selectByIndex(6); // select 2nd index in dropdown menu.
        WebElement dayDrop = driver.findElement(By.xpath("//*[@id=\"birth-day\"]"));
        dropdown = new Select(dayDrop); //using select class create object dropdown.
        dropdown.selectByIndex(11);

        WebElement saveChanges = driver.findElement(By.xpath("//*[@id=\"content\"]/div/form/div[2]/input"));
        saveChanges.click();
    }
}
