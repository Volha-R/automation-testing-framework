package by.epam.ta.page;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {
    protected WebDriver driver;

    protected AbstractPage(WebDriver driver){
        this.driver = driver;
    }
}
