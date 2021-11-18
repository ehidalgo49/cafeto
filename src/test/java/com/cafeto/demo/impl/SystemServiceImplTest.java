package com.cafeto.demo.impl;

import com.cafeto.demo.dto.Request;
import com.cafeto.demo.exception.InvalidRequestException;
import com.cafeto.demo.service.SystemService;
import com.cafeto.demo.service.impl.SystemServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;

/**
 * Test implementation for SystemService class
 * @author Edwin Hidalgo
 */
@ContextConfiguration(classes = SystemServiceImplTest.Config.class)
@RunWith(SpringRunner.class)
public class SystemServiceImplTest {

    @Autowired
    private SystemService systemService;

    @Configuration
    public static class Config {
        @Bean
        public SystemService systemService(){
            return new SystemServiceImpl();
        }
    }

    @Test
    public void success_getProperty_validation(){
        Request request = new Request();
        request.setProperty("os.version");
        request.setValue("10.0");

        boolean response = systemService.getProperty(request);
        assertTrue(response);
    }

    @Test(expected = InvalidRequestException.class)
    public void failed_getProperty_does_not_exist(){
        Request request = new Request();
        request.setProperty("os.vertion");
        request.setValue("10.0");

        boolean response = systemService.getProperty(request);
    }
}
