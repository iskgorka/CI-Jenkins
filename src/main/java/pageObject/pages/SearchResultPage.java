package pageObject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultPage extends BasePage {

    public SearchResultPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private By searchInput = new By.ByXPath("//input[@class=\"gLFyf gsfi\"]");

    @FindBy(xpath = "//h3[@class=\"LC20lb MBeuO DKV0Md\"]")
    private List<WebElement> searchResults;

    @FindBy(xpath = "//a[@class=\"menu-categories__link\"]")
    private List<WebElement> mainCategories;

    public SearchResultPage openGoogle() {
        driver.get("https://www.google.com.ua/");
        return this;
    }

    public SearchResultPage search(String searchString) {
        WebElement searchInputElement = driver.findElement(searchInput);
        searchInputElement.clear();
        searchInputElement.sendKeys(searchString);
        driver.findElement(searchInput).submit();
        return this;
    }

    public SearchResultPage clickSearchResultByIndex(int index) {
        String result = searchResults.get(index).getText();
        searchResults.get(index).click();
        System.out.println(result);
        return this;
    }

    public HomePage clickOnMainCategories(int index) {
        softAssert.assertEquals(mainCategories.get(index).getText(),"Ноутбуки и компьютеры");
        softAssert.assertAll();
        mainCategories.get(index).click();
        return new HomePage(driver);
    }

}
