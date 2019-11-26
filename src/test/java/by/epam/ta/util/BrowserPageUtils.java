package by.epam.ta.util;

import org.openqa.selenium.JavascriptExecutor;

public class BrowserPageUtils {
    public static void openNewWindow() {
        ((JavascriptExecutor) driver).executeScript("window.open();");
    }
}
