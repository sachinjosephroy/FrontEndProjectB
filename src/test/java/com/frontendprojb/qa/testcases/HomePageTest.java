package com.frontendprojb.qa.testcases;

import com.frontendprojb.qa.base.BaseTest;
import com.frontendprojb.qa.objects.Product;
import com.frontendprojb.qa.objects.TestData;
import com.frontendprojb.qa.pages.HomePage;
import com.frontendprojb.qa.pages.StorePage;
import com.frontendprojb.qa.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends BaseTest {

    @Test
    public void getWindowTitle() throws IOException {
        TestData testData = JacksonUtils.deserializeJson("testdata.json", TestData.class);
        new HomePage(getDriver()).load();
        Assert.assertTrue(getDriver().getTitle().contains(testData.getHomepage_windowTitle()));
    }

    @Test
    public void getPageTitle() {
        Assert.assertTrue(new HomePage(getDriver()).load().getPageTitle().contains("AskOmDch"));
    }

    @Test
    public void getProduct() throws IOException {
        TestData testData = JacksonUtils.deserializeJson("testdata.json", TestData.class);
        Assert.assertEquals(new HomePage(getDriver()).load().getProductName(), testData.getHomepage_prodName());
    }

    @Test
    public void getTagFreeImg() {
        Assert.assertTrue(new HomePage(getDriver()).load().isProductImageDisplayed());
    }

    @Test
    public void searchProduct() throws IOException {
        Product product = new Product(1211);
        StorePage storepage = new HomePage(getDriver()).load().clickStoreLink();
        storepage.searchProduct(product.getSearch_term());
        Assert.assertEquals(storepage.getProductName(), product.getName());
        Assert.assertEquals(storepage.getProductCategory(), product.getCategory());
        Assert.assertEquals(storepage.getProductPrice(), "122");
    }
}
