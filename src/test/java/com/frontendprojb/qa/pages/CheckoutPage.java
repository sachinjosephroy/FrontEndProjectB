package com.frontendprojb.qa.pages;

import com.frontendprojb.qa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    private final By productName = By.xpath("//td[@class='product-name']");
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void load() {
        load("/checkout");
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }
}
