package com.cafeto.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Request with input object
 * @author Edwin Hidalgo
 */
@Data
public class Request {
    @JsonProperty(value = "property")
    @NotNull @NotEmpty(message = "property can't be empty")
    private String property;

    @JsonProperty(value = "value")
    @NotNull @NotEmpty(message = "value can't be empty")
    private String value;
}
