package com.zjc.bs.base;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by anxpp.com on 2018/6/23.
 */
@Component
public class JsonHelper {

    @Resource
    private ObjectMapper objectMapper;

    /**
     * 对象转字符串
     */
    public String string(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 字符串转对象
     */
    public <T> T entity(Class<T> clazz, String json) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * json 转list
     *
     * @param json
     * @param valueType
     * @param <T>
     * @return
     */
    public <T> List<T> list(String json, Class<T> valueType) {
        if (json == null)
            return new ArrayList<>();
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(List.class, valueType);
        try {
            return objectMapper.readValue(json, javaType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
