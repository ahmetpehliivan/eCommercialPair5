package com.etiya.ecommercedemopair5;

import com.etiya.ecommercedemopair5.core.exceptions.types.BusinessException;
import com.etiya.ecommercedemopair5.core.exceptions.types.NotFoundException;
import com.etiya.ecommercedemopair5.core.utils.result.ErrorDataResult;
import com.etiya.ecommercedemopair5.core.utils.result.ErrorResult;
import com.etiya.ecommercedemopair5.core.utils.result.Result;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@SpringBootApplication
@RestControllerAdvice
public class EcommerceDemoPair5Application {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceDemoPair5Application.class, args);
	}

}
