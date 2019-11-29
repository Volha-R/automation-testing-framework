package by.epam.ta.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected static final int WAIT_TIMEOUT_SECONDS = 10;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    protected WebElement waitForElementToBeClickable(By by) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.elementToBeClickable(by));
    }

    protected WebElement waitForElementToBeClickable(WebElement webElement) {
        return waitForElementToBeClickable(webElement, WAIT_TIMEOUT_SECONDS);
    }

    protected WebElement waitForElementToBeClickable(WebElement webElement, int timeoutSeconds) {
        return new WebDriverWait(driver, timeoutSeconds).until(
                ExpectedConditions.elementToBeClickable(webElement));
    }

    protected WebElement waitForElementToBeVisible(WebElement webElement) {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.visibilityOf(webElement));
    }

    protected void waitForFrameAndSwitchToIt(String frameName) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(
                ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
    }

    protected void waitForFrameOrElementToBeClickable(String frameName, WebElement webElement) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.or(
                ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName),
                ExpectedConditions.elementToBeClickable(webElement)));
    }

    protected void triggerClickEvent(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }
}
