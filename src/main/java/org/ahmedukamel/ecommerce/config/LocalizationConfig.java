package org.ahmedukamel.ecommerce.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.List;
import java.util.Locale;

@Configuration
public class LocalizationConfig {

    private final List<Locale> supportedLocales = List.of(new Locale("en"), new Locale("ar"), new Locale("fr"));

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource source = new ReloadableResourceBundleMessageSource();
        source.setBasename("classpath:language/messages");
        source.setDefaultEncoding("UTF-8");
        return source;
    }

    @Bean
    public AcceptHeaderLocaleResolver localeResolver() {
        AcceptHeaderLocaleResolver localResolver = new AcceptHeaderLocaleResolver();
        localResolver.setSupportedLocales(supportedLocales);
        localResolver.setDefaultLocale(Locale.ENGLISH);
        return localResolver;
    }
}
