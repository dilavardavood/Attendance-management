package models;

import com.fasterxml.jackson.databind.JsonNode;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class DataTypeValidator {

    public Map<String, String> isValid(JsonNode json, Object object) {
        Class<?> objectClass = object.getClass();
        Map<String, String> errors = new HashMap<>();
        for (Field field : objectClass.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Class<?> type = field.getType();
                String name = field.getName();
                JsonNode value = json.get(name);
                if (value == null || value.isNull()) {
                    errors.put(name, name + " cant be null");
                    break;
                }

                if (type.equals(String.class) && !value.isTextual()) {
                    errors.put(name, name + " not string");
                    break;
                }
                if (type.equals(Integer.class) && !value.isInt()) {
                    errors.put(name, name + " not integer");
                    break;
                }
                if (type.equals(Double.class) && !value.isDouble()) {
                    errors.put(name, name + " not double");
                    break;
                }
                if (type.equals(Boolean.class) && !value.isBoolean()) {
                    errors.put(name, name + " not boolean");
                    break;
                }
            } catch (Exception e) {
                errors.put("ERROR", "Value not boolean");
            }
        }
        return errors;
    }
}

