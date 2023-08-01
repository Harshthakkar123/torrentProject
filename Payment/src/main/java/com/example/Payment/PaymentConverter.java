package com.example.Payment;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentConverter {

    @Autowired
    private ModelMapper modelMapper;

    public PaymentModel convertDtoToEntity(PaymentDto filtersDto){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        PaymentModel filters= new PaymentModel();
        modelMapper.map(filtersDto, filters);
        return filters;
    }

    public PaymentDto convertEntityToDto(PaymentModel filters) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        PaymentDto filtersDto = new PaymentDto();
        modelMapper.map(filters, filtersDto);
        return filtersDto;
    }

}
