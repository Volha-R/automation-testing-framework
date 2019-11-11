package by.epam.ta.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailEstimationWindow extends EstimationResultComponent {

    public EmailEstimationWindow(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ("//label[contains(text(), 'Email')]/following-sibling::input"))
    private WebElement emailField;

   @FindBy(xpath = ("//*[@aria-label='Send Email']"))
    private WebElement sendEmailButton;

    public EmailEstimationWindow pasteEmailAddress(String emailAddress) {
        new WebDriverWait(driver, 5).until(ExpectedConditions.or(
                ExpectedConditions.frameToBeAvailableAndSwitchToIt("idIframe"),
                ExpectedConditions.elementToBeClickable(emailField)));
        emailField.sendKeys(emailAddress);
        return this;
    }
//    idIframe

    public void sendEmail() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", sendEmailButton);
    }
}
