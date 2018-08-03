package com.epam.agency.repository.mapper;

import com.epam.agency.domain.TourType;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class TourTypeConverter implements AttributeConverter<TourType, String> {

    @Override
    public String convertToDatabaseColumn(TourType tourType) {
        return tourType.getValue();
    }

    @Override
    public TourType convertToEntityAttribute(String tourType) {
        return TourType.valueOf(tourType.toUpperCase());
    }

}

