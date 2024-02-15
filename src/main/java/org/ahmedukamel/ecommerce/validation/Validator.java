package org.ahmedukamel.ecommerce.validation;

import java.util.regex.Pattern;

public class Validator {
    public static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static final String URL_PATTERN = "^https?://(www\\.)?[-a-zA-Z0-9@:%._+~#=]{1,256}\\.[a-zA-Z0-9()]{1,6}\\b([-a-zA-Z0-9()@:%_+.~#?&/=]*)$";
    public static final String PHONE_PATTERN = "^\\+?[0-9]\\d{1,20}$";

    public static boolean EMAIL(String email) {
        return NOT_NULL_NOT_BLANK(email) && Pattern.matches(EMAIL_PATTERN, email);
    }

    public static boolean URL(String url) {
        return NOT_NULL_NOT_BLANK(url) && Pattern.matches(URL_PATTERN, url);
    }

    public static boolean PHONE(String phone) {
        return NOT_NULL_NOT_BLANK(phone) && Pattern.matches(PHONE_PATTERN, phone);
    }

    public static boolean RATE(Double rate) {
        return rate != null && 1 <= rate && rate <= 5;
    }

    public static boolean NOT_NULL_NOT_BLANK(String sentence) {
        return sentence != null && !sentence.isBlank();
    }

    public static boolean NOT_NULL_NOT_NEGATIVE(Integer number) {
        return number != null && number >= 0;
    }

    public static boolean NOT_NULL_NOT_NEGATIVE(Double number) {
        return number != null && number >= 0;
    }

    public static boolean NOT_NULL_NEGATIVE_ONE(Double number) {
        return number != null && number >= -1;
    }
}
