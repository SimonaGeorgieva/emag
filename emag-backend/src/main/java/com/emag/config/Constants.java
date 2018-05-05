package com.emag.config;

import java.util.regex.Pattern;

public class Constants {
    public static final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    public static final String SUCCESS = "Success";
    public static final int PHONE_NUMBER_LENGTH = 10;
    public static final String ERROR = "Error";
    public static final String PHONE_NUMBER_PREFIX = "08";
    public static final int MIN_CITY_NAME_LENGTH = 3;
    public static final int MAX_CITY_NAME_LENGTH = 20;
    public static final int MAX_RECEIVER_NAME_LENGTH = 45;
    public static final int MAX_CATEGORY_NAME_LENGTH = 45;
    public static final int MAX_STREET_INFO_LENGTH = 50;
    public static final int MIN_PASSWORD_LENGTH = 5;
    public static final int MIN_EMAIL_LENGTH = 5;
    public static final int MAX_DISCOUNT_VALUE = 100;
    public static final int MAX_PRODUCT_DESCRIPTION_LENGTH = 1000;
    public static final int MAX_PRODUCT_NAME_LENGTH = 45;
    public static final int MAX_PRODUCT_PICTURE_URL_LENGTH = 100;
    public static final int MAX_USER_NAME_LENGTH = 45;
    public static final int MAX_USER_PASSWORD_LENGTH = 45;
    public static final int MAX_EMAIL_LENGTH = 45;
    public static final int MAX_USER_PROFILE_PICTURE_URL_LENGTH = 100;
    public static final int MAX_USER_GENDER_VALUE_LENGTH = 45;
    public static final String SENDER_EMAIL = "emag.7377@gmail.com";
    public static final String EMAIL_SUBJECT_SUBSCRIPTION = "Subscription for eMAG.bg";
    public static final String EMAIL_TEXT_SUCCESSFUL_SUBSCRIPTION = "Congratulations!\nYou have successfully subscribed to eMAG.bg";
}
