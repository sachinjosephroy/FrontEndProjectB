package com.frontendprojb.qa.pages;

import com.frontendprojb.qa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    private final By pageTitle = By.linkText("AskOmDch");
    private final By prodName = By.linkText("Basic Blue Jeans");
    private final By prodImg = By.xpath("//img[@src='https://askomdch.com/wp-content/uploads/2020/09/tag-free-img.png']");
    private final By storeLink = By.linkText("Store");
    protected JavascriptExecutor js;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage load() {
        load("/");
        return this;
    }

    public String getPageTitle() {
        return wait.until(ExpectedConditions.visibilityOf(driver.findElement(pageTitle))).getText();
    }

    public String getProductName() {
        return driver.findElement(prodName).getText();
    }

    public Boolean isProductImageDisplayed() {
        this.js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        WebElement e = wait.until(ExpectedConditions.visibilityOfElementLocated(prodImg));
        return e.isDisplayed();
    }

    public StorePage clickStoreLink() {
        driver.findElement(storeLink).click();
        return new StorePage(driver);
    }
}
