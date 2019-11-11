package by.epam.ta.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage{

//    @FindBy(xpath = "//a[contains(text(), 'See all products')]")
//    private WebElement seeAllProductsButton;

    @FindBy(xpath = "//*[@id='searchbox']")
    private WebElement searchFieldButton;

    @FindBy(xpath = "//*[@id='searchbox']/input")
    private WebElement searchField;

    public MainPage(WebDriver driver) {
        super(driver);
//        PageFactory.initElements(driver, this);
    }

    public MainPage openMainPage() {
        driver.get("https://cloud.google.com");
        return this;
    }

//    public ProductsAndServicesPage openProductsAndServicesPage() {
//        seeAllProductsButton.click();
//        return new ProductsAndServicesPage(driver);
//    }

    public SearchResultsPage searchForTerms(String searchTerm) {
        searchFieldButton.click();
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);
        return new SearchResultsPage(driver);
    }
}
