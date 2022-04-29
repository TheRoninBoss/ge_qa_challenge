package com.ge.core;

import com.google.common.base.Verify;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestData {

    private static final String NULL_PROPERTY_ERROR =
            "- Property [%s] was not found! Check your spelling!";
    private static TestData instance;
    private Properties properties;

    private TestData() {
        loadProperties();
    }

    public static synchronized TestData getInstance() {
        if (instance == null) {
            instance = new TestData();
        }
        return instance;
    }

    private void loadProperties() {
        Properties properties = new Properties();
        String location = "testdata";
        try (InputStream resource = getClass().getClassLoader()
                .getResourceAsStream(location)) {
            properties.load(resource);
        } catch (IOException e) {
            throw new IllegalStateException(
                    String.format("Unable to load test data file at []",
                            location));
        }
        this.properties = properties;
    }

    private String getProperty(String property) {
        return Verify.verifyNotNull(properties.getProperty(property),
                NULL_PROPERTY_ERROR, property);
    }

    public String getBaseUrl() {
        return getProperty("base_url");
    }

    public String getStandardUserName() {
        return getProperty("standard_username");
    }

    public String getValidPassword() {
        return getProperty("valid_password");
    }

    public String getInvalidPassword() {
        return getProperty("invalid_password");
    }

    public String getIncorrectLoginErrorMessage() {
        return getProperty("incorrect_login_error_msg");
    }

    public String getTestProductOne() {
        return getProperty("product_1");
    }

    public String getTestProductTwo() {
        return getProperty("product_2");
    }

    public String getTestProductThree() {
        return getProperty("product_3");
    }

    public String getTestProductOnesie() {
        return getProperty("product_onesie");
    }

    public String getCustomerFirstName() {
        return getProperty("first_name");
    }

    public String getCustomerLastName() {
        return getProperty("last_name");
    }

    public String getCuctomerPostalCode() {
        return getProperty("postal_code");
    }

    public String getConfirmationPageTitle() {
        return getProperty("confirmation_title");
    }

}
