package com.etiya.ecommercedemopair5.core.internationalization;

public interface MessageService {

    String getMessage(String keyword);
    String getMessageWithParams(String keyword, Object... params);
}
