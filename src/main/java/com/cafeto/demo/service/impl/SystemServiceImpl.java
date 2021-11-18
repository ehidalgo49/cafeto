package com.cafeto.demo.service.impl;

import com.cafeto.demo.dto.Request;
import com.cafeto.demo.exception.InvalidRequestException;
import com.cafeto.demo.service.SystemService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;


/**
 * Service implementation for get System properties
 * @author Edwin Hidalgo
 */
@Service
public class SystemServiceImpl implements SystemService {

    private static final Logger logger = LogManager.getLogger(SystemServiceImpl.class);

    @Override
    public boolean getProperty(Request request) throws InvalidRequestException {
        return validateProperty(request);
    }

    /**
     * This method validate if the input is correct
     *
     * @param request, String with a property to compare
     * @throws InvalidRequestException when the Request is not valid
     */
    private boolean validateProperty(Request request) throws InvalidRequestException {
        String prop = System.getProperty(request.getProperty());
        if(prop == null || prop.isEmpty()){
            logger.error("Property does not exist");
            throw new InvalidRequestException("Property does not exist");
        }
        logger.log(Level.DEBUG, "Property exist with value: {0} ", prop);
        return prop.compareToIgnoreCase(request.getValue()) == 0;
    }
}
