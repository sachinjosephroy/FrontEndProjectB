package com.frontendprojb.qa.utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;

public class FakerUtils {
    public static String date() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM_dd_yyyy");
        Faker faker = new Faker();
        return faker.date().toString();
    }
}
