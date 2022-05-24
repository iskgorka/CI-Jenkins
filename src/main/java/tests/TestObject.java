package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pageObject.pages.BasePage;
import pageObject.pages.HomePage;
import pageObject.pages.SearchResultPage;

public class TestObject {

    @Test
    public void openNotebooksTest() {
        String searchString = "rozetka ua";
        WebDriverManager.chromedriver().setup();
        new SearchResultPage(new ChromeDriver())
                .openGoogle()
                .search(searchString)
                .clickSearchResultByIndex(0)
                .clickOnMainCategories(0);
    }

    @Test
    public void findIphone13Test() {
        String searchString = "iphone 13 pro max 256";
        WebDriverManager.chromedriver().setup();
        new HomePage(new ChromeDriver())
                .openRozetka()
                .searchProduct(searchString)
                .clickOnProduct(0);
    }

    @Test
    public void failTest() {
        String searchString = "selenium";
        WebDriverManager.chromedriver().setup();
        new SearchResultPage(new ChromeDriver())
                .openGoogle()
                .search(searchString)
                .clickSearchResultByIndex(0)
                .clickOnMainCategories(0);
    }

    @AfterMethod
    public void closeBrowser() {
        BasePage.setDown();
    }
}
