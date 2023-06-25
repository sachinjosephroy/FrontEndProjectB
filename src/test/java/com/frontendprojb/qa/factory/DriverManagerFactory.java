package com.frontendprojb.qa.factory;

import com.frontendprojb.qa.constants.DriverType;

public class DriverManagerFactory {
    public static DriverInterface getDriverManager(DriverType driverType) {
        switch (driverType) {
            case CHROME: return new ChromeDriverManager();
            case FIREFOX: return new FirefoxDriverManager();
            default: throw new RuntimeException("Invalid Driver Type" + driverType);
        }
    }
}
