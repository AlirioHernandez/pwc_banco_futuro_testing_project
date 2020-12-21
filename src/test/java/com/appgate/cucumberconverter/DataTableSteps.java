package com.appgate.cucumberconverter;

import com.appgate.requestproduct.entities.CustomerInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import io.cucumber.java.DataTableType;
import io.cucumber.java.DefaultDataTableCellTransformer;
import io.cucumber.java.DefaultDataTableEntryTransformer;
import io.cucumber.java.DefaultParameterTransformer;
import org.junit.Assert;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Map;

public class DataTableSteps {

    private final ObjectMapper objectMapper =
            new ObjectMapper().registerModule(new JavaTimeModule());

    @DefaultParameterTransformer
    @DefaultDataTableEntryTransformer(replaceWithEmptyString = "[blank]")
    @DefaultDataTableCellTransformer
    public Object defaultTransformer(Object fromValue, Type toValueType) {
        JavaType javaType = objectMapper.constructType(toValueType);
        return objectMapper
                .convertValue(fromValue, javaType);
    }

    @DataTableType(replaceWithEmptyString = "[blank]" )
    public CustomerInfo customerInfoTransform(Map<String, String> map) throws JsonProcessingException {
       return new CustomerInfo(Integer.parseInt(map.get("id")), map.get("name"),Arrays.asList(map.get("products").split(",")));
    }

}
