package by.epam.ta.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchResultsPage extends AbstractPage {
    @FindBy(xpath = "//a[.//b[text()='Google Cloud Platform Pricing Calculator']]")
    private List<WebElement> generalSearchResults;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
//        PageFactory.initElements(driver, this);
    }

    public PricingCalculatorPage chooseSearchTermLink() {
        List <WebElement> link = new WebDriverWait(driver, 5)
                .until(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.xpath("//a[.//b[text()='Google Cloud Platform Pricing Calculator']]")));
        link.get(0).click();
        return new PricingCalculatorPage(driver);
    }
}
