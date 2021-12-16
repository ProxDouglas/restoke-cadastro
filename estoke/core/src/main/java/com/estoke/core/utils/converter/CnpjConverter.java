package com.estoke.core.utils.converter;

import com.estoke.core.utils.CnpjUtils;

import javax.persistence.AttributeConverter;

/**
 * @author vitor.alves
 */
public class CnpjConverter implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String attribute) {
        return CnpjUtils.removeFormatacao(attribute);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return dbData;
    }
}
