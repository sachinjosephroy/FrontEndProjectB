package com.frontendprojb.qa.factory;

import com.frontendprojb.qa.constants.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    private WebDriver driver;
    public WebDriver initializeDriver(String browser) {
        String localBrowser;
        localBrowser = System.getProperty("browser", browser).toUpperCase();
        switch (DriverType.valueOf(localBrowser)) {
            case CHROME: {
                driver = new ChromeDriver();
                break;
            }
            case FIREFOX: {
                driver = new FirefoxDriver();
                break;
            }
            default: {
                System.out.println("Invalid browser name: " + browser);
            }
        }
        driver.manage().window().maximize();
        return driver;
    }
}
