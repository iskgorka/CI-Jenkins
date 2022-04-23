package pageObject.pages;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public abstract class BasePage {
    public static WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    SoftAssert softAssert = new SoftAssert();

    public static void setDown() {
        driver.quit();
    }
}
