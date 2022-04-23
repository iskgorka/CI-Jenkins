package pageObject.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name=\"search\"]")
    private WebElement searchInput;

    @FindBy(xpath = "//div[@class=\"goods-tile__inner\"]")
    private List<WebElement> products;

    public HomePage openRozetka() {
        driver.get("https://rozetka.com.ua/");
        return this;
    }

    public HomePage searchProduct(String searchString) {
        softAssert.assertTrue(searchInput.isDisplayed());
        softAssert.assertAll();
        searchInput.clear();
        searchInput.sendKeys(searchString);
        searchInput.sendKeys(Keys.ENTER);
        return this;
    }

    public HomePage clickOnProduct(int index){
        softAssert.assertTrue(products.get(index).isDisplayed());
        softAssert.assertAll();
        products.get(index).click();
        return this;
    }
}
