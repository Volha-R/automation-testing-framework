package by.epam.ta.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailEstimationWindow extends EstimationResultComponent {

    public EmailEstimationWindow(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ("//label[contains(text(), 'Email')]/following-sibling::input"))
    private WebElement emailField;

    @FindBy(xpath = ("//*[@aria-label='Send Email']"))
    private WebElement sendEmailButton;

    public EmailEstimationWindow pasteEmailAddress(String emailAddress) {
        waitForFrameOrElementToBeClickable("myFrame", emailField);
        emailField.sendKeys(emailAddress);
        return this;
    }

    public void sendEmail() {
        triggerClickEvent(sendEmailButton);
    }
}
