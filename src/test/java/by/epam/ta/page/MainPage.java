package by.epam.ta.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {
    private static final String BASE_URL = "https://cloud.google.com";

    @FindBy(id = "searchbox")
    private WebElement searchFieldButton;

    @FindBy(xpath = "//*[@id='searchbox']/input")
    private WebElement searchField;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage openMainPage() {
        driver.get(BASE_URL);
        return this;
    }

    public SearchResultsPage searchForTerms(String searchTerm) {
        searchFieldButton.click();
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        return new SearchResultsPage(driver);
    }
}
