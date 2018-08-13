package com.epam.agency.repository.mapper;

import com.epam.agency.domain.Feature;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.ArrayList;
import java.util.List;

@Converter
public class FeatureListConverter implements AttributeConverter<List<Feature>, String> {

    @Override
    public String convertToDatabaseColumn(List<Feature> features) {
        StringBuilder feature = new StringBuilder();
        features.forEach(item -> {
            feature.append((item).getValue()).append(",");
        });
        return feature.toString();
    }

    @Override
    public List<Feature> convertToEntityAttribute(String joined) {
        String[] featuresStr = joined.split(",");
        List<Feature> features = new ArrayList<>();
        for (String feature : featuresStr) {
            features.add(Feature.valueOf(feature.toUpperCase().replace(' ', '_')));
        }
        return features;
    }

}

