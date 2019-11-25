package by.epam.ta.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultsPage extends AbstractPage {

    private final By locator = By.xpath("//a//b[text()='Google Cloud Platform Pricing Calculator']");

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public PricingCalculatorPage chooseSearchTermLink() {
        List<WebElement> link = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        link.get(0).click();
        return new PricingCalculatorPage(driver);
    }
}
