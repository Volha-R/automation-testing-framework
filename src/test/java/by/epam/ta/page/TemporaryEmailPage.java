package by.epam.ta.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TemporaryEmailPage extends AbstractPage {
    private static final String EMAIL_PAGE_URL = "https://10minutemail.com";

    public TemporaryEmailPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "mailAddress")
    private WebElement emailAddressField;

    @FindBy(id = "messagesList")
    private WebElement emailReceivedField;

    @FindBy(xpath = "//h3[contains(text(), 'USD')]")
    private WebElement costField;

    public TemporaryEmailPage openPage() {
        driver.get(EMAIL_PAGE_URL);
        return this;
    }

    public String copyEmail() {
        return emailAddressField.getAttribute("value");
    }

    public TemporaryEmailPage openEmail() {
        waitForElementToBeClickable(emailReceivedField, 60)
                .click();
        return this;
    }

    public String getEstimatedCoast() {
        waitForElementToBeVisible(costField);
        return costField.getText();
    }
}
