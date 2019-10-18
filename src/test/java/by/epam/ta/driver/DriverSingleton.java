package by.epam.ta.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverSingleton {

    private static WebDriver driver;


    private DriverSingleton(){}

    public static WebDriver getDriver(){
        if (null == driver){
            switch (System.getProperty("browser")){
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.setHeadless(true);
                    firefoxOptions.addArguments("--start-maximized");
                    firefoxOptions.addArguments("--width=2560");
                    firefoxOptions.addArguments("--height=1440");
                    driver = new FirefoxDriver(firefoxOptions);
                    break;
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setHeadless(true);
                    chromeOptions.addArguments("--start-maximized");
                    chromeOptions.addArguments("--window-size=2560,1440");
                    driver = new ChromeDriver(chromeOptions);
                }
            }
        }
        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}
