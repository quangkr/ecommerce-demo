package com.dxc.qdang.ecommercedemo.util;

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
            return new String[0];
        }

        return dbData.split(SEPARATOR);
    }

}
