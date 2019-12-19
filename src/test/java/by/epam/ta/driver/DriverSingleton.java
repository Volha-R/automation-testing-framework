package by.epam.ta.driver;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverSingleton {

    private static WebDriver driver;

    private DriverSingleton() {
    }

    public static WebDriver getDriver() {
        DesiredCapabilities capabilities = null;
        if (null == driver) {
            switch (System.getProperty("browser")) {
                case "firefox": {
                    capabilities = DesiredCapabilities.firefox();
                    break;
                }
                default: {
                    capabilities = DesiredCapabilities.chrome();
                }
            }
        }

        try {
            capabilities.setPlatform(Platform.WINDOWS);
            return new RemoteWebDriver(new URL("http://192.168.8.3:4444/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException();
        }
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}

/*
 java -jar selenium-server-standalone-3.141.59.jar -role hub
*/

/*
 java -Dwebdriver.chrome.driver=C:\Users\User\Downloads\chromedriver.exe -jar C:\Users\User\Downloads\selenium-server-standalone-3.141.59.jar  -role node -hub http://192.168.8.3:4444/grid/register -browser "browserName=chrome,platform=WINDOWS" -port 5557
 */

/*
 java -Dwebdriver.gecko.driver=C:\Users\User\Downloads\geckodriver.exe -jar C:\Users\User\Downloads\selenium-server-standalone-3.141.59.jar -role node -hub http://192.168.8.3:4444/grid/register -browser "browserName=firefox,platform=WINDOWS" -port 5558
 */