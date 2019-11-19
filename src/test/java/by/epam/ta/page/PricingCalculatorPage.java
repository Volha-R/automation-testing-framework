package by.epam.ta.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PricingCalculatorPage extends AbstractPage {

    @FindBy(xpath = "//md-tab-item/div[@title='Compute Engine' and @class='tab-holder compute']")
    private WebElement computeEngineOptionButton;

    public PricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public ComputeEngineComponent chooseComputeEngineOption() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.frameToBeAvailableAndSwitchToIt("myFrame"));
        computeEngineOptionButton.click();
        return new ComputeEngineComponent(driver);
    }
}
