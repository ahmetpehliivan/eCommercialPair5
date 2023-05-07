package com.etiya.ecommercedemopair5.core.utils.mapping;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public interface ModelMapperService {
    ModelMapper forRequest();
    ModelMapper forResponse();

    //ModelMapper getMapper();

}
