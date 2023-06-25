package com.frontendprojb.qa.objects;

public class TestData {
    private String homepage_windowTitle;
    private String homepage_prodName;

    public String getHomepage_prodName() {
        return homepage_prodName;
    }

    public TestData() {}

    public TestData(String homepage_windowTitle) {
        this.homepage_windowTitle = homepage_windowTitle;
    }

    public String getHomepage_windowTitle() {
        return homepage_windowTitle;
    }

    public void setHomepage_windowTitle(String homepage_windowTitle) {
        this.homepage_windowTitle = homepage_windowTitle;
    }
}
