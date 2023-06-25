package com.frontendprojb.qa.pages;

import com.frontendprojb.qa.base.BasePage;
import com.frontendprojb.qa.objects.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class StorePage extends BasePage {
    private final By searchInput = By.id("woocommerce-product-search-field-0");
    private final By searchButton = By.xpath("//button[contains(text(), 'Search')]");
    private final By prodName = By.linkText("Dark Brown Jeans");
    private final By prodCategory = By.xpath("(//a[contains(text(), 'Add to cart')]/preceding-sibling::span[contains(text(), 'Men')])[1]");
    private final By prodPrice = By.xpath("//li[@class='ast-col-sm-12 ast-article-post astra-woo-hover-swap product type-product post-1211 status-publish first instock product_cat-men product_cat-mens-jeans has-post-thumbnail taxable shipping-taxable purchasable product-type-simple']/div[@class='astra-shop-summary-wrap']/span[@class='price']/span/bdi");

    public StorePage(WebDriver driver) {
        super(driver);
    }

    public StorePage searchProduct(String search_term) throws IOException {
        driver.findElement(searchInput).sendKeys(search_term);
        driver.findElement(searchButton).click();
        return this;
    }

    public String getProductName() {
        return driver.findElement(prodName).getText();
    }

    public String getProductCategory() {
        return driver.findElement(prodCategory).getText();
    }

    public String getProductPrice() {
        return driver.findElement(prodPrice).getText();
    }
}
