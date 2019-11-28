package by.epam.ta.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PricingCalculatorPage extends AbstractPage {

    @FindBy(xpath = "//md-tab-item/div[@title='Compute Engine' and @class='tab-holder compute']")
    private WebElement computeEngineOptionButton;

    public PricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public ComputeEngineComponent chooseComputeEngineOption() {
        waitForFrameAndSwitchToIt("myFrame");
        computeEngineOptionButton.click();
        return new ComputeEngineComponent(driver);
    }
}
