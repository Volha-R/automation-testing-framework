package by.epam.ta.util;

import by.epam.ta.driver.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class BrowserPageUtils {

    private static WebDriver driver = DriverSingleton.getDriver();

    public static void openNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open();");
    }

    public static void switchToTab(int tabNumber) {
        driver.switchTo().window(getOpenedTabs().get(tabNumber));
    }

    private static List<String> getOpenedTabs() {
        return new ArrayList<>(driver.getWindowHandles());
    }

}
