package com.frontendprojb.qa.api;

import com.frontendprojb.qa.objects.Product;
import com.frontendprojb.qa.utils.ConfigLoader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class AddToCartApi {
    private Cookies cookies;

    public AddToCartApi() {}

    public Cookies getCookies() {
        return cookies;
    }

    private static RequestSpecification getReqSpec() {
        return new RequestSpecBuilder().
                setBaseUri(ConfigLoader.getInstance().getBaseUrl()).
                log(LogDetail.ALL).
                build().headers("content-type", "application/x-www-form-urlencoded");
    }

    private static ResponseSpecification getResSpec() {
        return new ResponseSpecBuilder().
                log(LogDetail.ALL).
                build();
    }

    public Response addToCart(Product product) {
        HashMap<String, Object> payload = new HashMap<>();
        payload.put("product_sku", "");
        payload.put("product_id", product.getId());
        payload.put("quantity", 1);

        Response response = given().
                spec(getReqSpec()).
                formParams(payload).
        when().
                post("/?wc-ajax=add_to_cart").
        then().
                extract().
                response();
        System.out.println("Cookie is: " + response.getDetailedCookies());
        this.cookies = response.getDetailedCookies();
        return response;
    }
}
