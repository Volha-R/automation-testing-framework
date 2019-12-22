package by.epam.ta.driver;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverSingleton {

    private static WebDriver driver;

    private DriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (null == driver) {
            URL url;
            try {
                url = new URL("http://192.168.8.3:4444/wd/hub");
            } catch (MalformedURLException e) {
                throw new IllegalArgumentException();
            }

            switch (System.getProperty("browser")) {
                case "firefox": {
                    FirefoxOptions options = new FirefoxOptions();
                    driver = new RemoteWebDriver(url, options);
                    break;
                }
                default: {
                    ChromeOptions options = new ChromeOptions();
                    options.setCapability("platform", Platform.WINDOWS);
                    options.setCapability("version", "74");
                    driver = new RemoteWebDriver(url, options);
                }
            }
        }

        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}
