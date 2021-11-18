package com.cafeto.demo.service;

import com.cafeto.demo.dto.Request;
import com.cafeto.demo.exception.InvalidRequestException;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * Service interface for set system properties
 * @author Edwin Hidalgo
 */
@Validated
@Component
public interface SystemService {

    /**
     * Try to get a system property
     *
     * @param request, object with body to get
     * @return {@link boolean}, validation is true or false
     * @throws InvalidRequestException when the input body is not correct
     */
    boolean getProperty(Request request) throws InvalidRequestException;
}
