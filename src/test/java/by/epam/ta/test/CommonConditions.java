package by.epam.ta.test;

import by.epam.ta.driver.DriverSingleton;
import by.epam.ta.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class CommonConditions {
    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUpBrowser(){
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDownBrowser() {
        DriverSingleton.closeDriver();
    }
}
