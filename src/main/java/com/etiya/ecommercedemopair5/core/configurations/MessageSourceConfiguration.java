package com.etiya.ecommercedemopair5.core.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.Locale;

@Configuration
public class MessageSourceConfiguration {

    @Bean
    public ResourceBundleMessageSource bundleMessageSource(){
        //İlgili dosyanın mesaj kaynağının neresi olacağını belirtiriz. API, Veritabanı, Dosya
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("messages");
        return messageSource;
    }

    @Bean
    public LocaleResolver localeResolver(){
        //Clientten seçili dili hangi yöntemle almalıyım?
        //Header , QueryParam
        //Accept-language yöntemi kullanıyoruz.
        AcceptHeaderLocaleResolver acceptHeaderLocaleResolver = new AcceptHeaderLocaleResolver();
        acceptHeaderLocaleResolver.setDefaultLocale(Locale.US);

        return acceptHeaderLocaleResolver;
    }
}
