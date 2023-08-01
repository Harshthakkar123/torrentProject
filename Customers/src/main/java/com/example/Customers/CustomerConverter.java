package com.example.Customers;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {

    @Autowired
    private ModelMapper modelMapper;

    public CustomerModel convertDtoToEntity(PaymentDto filtersDto){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        CustomerModel filters= new CustomerModel();
        modelMapper.map(filtersDto, filters);
        return filters;
    }

//    public CustomerDto convertEntityToDto(CustomerModel filters) {
//        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
//        CustomerDto filtersDto = new CustomerDto();
//        modelMapper.map(filters, filtersDto);
//        return filtersDto;
//    }
}
