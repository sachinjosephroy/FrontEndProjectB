package com.frontendprojb.qa.base;

import com.frontendprojb.qa.constants.DriverType;
import com.frontendprojb.qa.factory.DriverManagerFactory;
import com.frontendprojb.qa.utils.CommonUtils;
import com.frontendprojb.qa.utils.CookieUtils;
import com.frontendprojb.qa.utils.FakerUtils;
import io.restassured.http.Cookies;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BaseTest {
    private ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver getDriver() {
        return driver.get();
    }

    public void setDriver(WebDriver driver) {
        this.driver.set(driver);
    }

    @Parameters("browser")
    @BeforeMethod
    public void setUp(@Optional String browser) {
        System.out.println("BROWSER NAME IS: " + browser);
        //this.driver = new DriverManager().initializeDriver("firefox");
        String browserName = browser.toUpperCase();
        setDriver(DriverManagerFactory.getDriverManager(DriverType.valueOf(browserName)).createDriver());
        System.out.println("CURRENT THREAD: " + Thread.currentThread().getId() + '\n' +
                "BROWSER: " + browser + "\n" + "DRIVER: " + getDriver());
    }

    @Parameters("browser")
    @AfterMethod
    public void tearDown(@Optional String browser, ITestResult result) throws IOException {
        if(result.getStatus() == ITestResult.FAILURE) {
            File destFile = new File("screenshots" + File.separator + browser + File.separator +
                    result.getTestClass().getRealClass().getSimpleName() + "_" +
                    result.getMethod().getMethodName() + "_" + CommonUtils.dateTime() + ".png");
            takeScreenshot(destFile);
        }
        getDriver().quit();
    }

    private void takeScreenshot(File destFile) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) getDriver();
        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, destFile);
    }

    public void injectCookiesToBrowser(Cookies cookies) {
        List<Cookie> seleniumCookies = new CookieUtils().convertRestAssuredCookiesToSeleniumCookies(cookies);
        for(Cookie cookie: seleniumCookies) {
            getDriver().manage().addCookie(cookie);
        }
    }
}
