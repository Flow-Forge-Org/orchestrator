package com.flow.workflow.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Converter(autoApply = false)
public class JsonToMapConverter implements AttributeConverter<Map<String, Object>, String> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Map<String, Object> attribute) {
        if (Objects.isNull(attribute)) {
            return null;
        }

        try {
            return objectMapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting Map to JSON string", e);
        }
    }

    @Override
    public Map<String, Object> convertToEntityAttribute(String dbData) {
        if (Objects.isNull(dbData)) {
            return null;
        }
        try {
            return objectMapper.readValue(dbData, Map.class);
        } catch (IOException e) {
            throw new RuntimeException("Error converting JSON string to Map", e);
        }
    }
}
