package com.frontendprojb.qa.testcases;

import com.frontendprojb.qa.api.AddToCartApi;
import com.frontendprojb.qa.base.BaseTest;
import com.frontendprojb.qa.objects.Product;
import com.frontendprojb.qa.pages.CheckoutPage;
import com.frontendprojb.qa.utils.CommonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckoutPageTest extends BaseTest {
    @Test
    public void getProductNameGuestCheckout() throws IOException {
        AddToCartApi addToCartApi = new AddToCartApi();
        Product product = new Product(1198);
        addToCartApi.addToCart(product);
        CheckoutPage checkoutPage = new CheckoutPage(getDriver());
        checkoutPage.load();
        injectCookiesToBrowser(addToCartApi.getCookies());
        checkoutPage.load();
        Assert.assertEquals(CommonUtils.usingSubstringMethod(checkoutPage.getProductName(), product.getName().length()), product.getName());
    }
}
