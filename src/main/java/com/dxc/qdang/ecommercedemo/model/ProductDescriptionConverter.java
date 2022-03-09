package com.dxc.qdang.ecommercedemo.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class ProductDescriptionConverter implements AttributeConverter<String[], String> {

    private static final String SEPARATOR = System.getProperty("line.separator");

    @Override
    public String convertToDatabaseColumn(String[] attribute) {
        if (attribute == null) {
            return null;
        }

        return String.join(SEPARATOR, attribute);
    }

    @Override
    public String[] convertToEntityAttribute(String dbData) {
        if (dbData == null) {
            return null;
        }

        return dbData.split(SEPARATOR);
    }

}