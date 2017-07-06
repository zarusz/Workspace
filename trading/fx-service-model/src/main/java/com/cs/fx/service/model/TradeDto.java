package com.cs.fx.service.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Tomasz on 06.07.2017.
 */
@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = SpotTradeDto.class, name = "Spot"),
        @JsonSubTypes.Type(value = ForwardTradeDto.class, name = "Forward"),
        @JsonSubTypes.Type(value = VanillaOptionTradeDto.class, name = "VanillaOption")
})
public abstract class TradeDto {

    private String type;

    private String customer;
    private String legalEntity;
    private String trader;

    private TradeDirection direction;

    /**
     * Additional properties (not mapped by any known DTO class).
     */
    @Getter
    private Map<String, String> properties = new HashMap<>();

    @JsonAnyGetter
    public Map<String, String> any() {
        return properties;
    }

    @JsonAnySetter
    public void set(String name, String value) {
        properties.put(name, value);
    }
}

