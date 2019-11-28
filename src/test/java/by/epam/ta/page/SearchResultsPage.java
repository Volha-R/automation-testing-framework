package by.epam.ta.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends AbstractPage {

    @FindBy(xpath = "//a//b[text()='Google Cloud Platform Pricing Calculator']")
    private WebElement searchLink;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public PricingCalculatorPage chooseSearchTermLink() {
        waitForElementToBeClickable(searchLink)
                .click();
        return new PricingCalculatorPage(driver);
    }
}
