package org.ahmedukamel.ecommerce.util;

import org.springframework.context.i18n.LocaleContextHolder;

public class LocaleContextUtils {
    public static String getLanguage() {
        return LocaleContextHolder.getLocale().getLanguage();
    }
}
