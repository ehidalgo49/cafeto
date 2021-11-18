package com.cafeto.demo.controller;

import com.cafeto.demo.dto.Request;
import com.cafeto.demo.exception.InvalidRequestException;
import com.cafeto.demo.service.SystemService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.SwaggerDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Rest controller with a post method on REST endpoint
 * @author Edwin Hidalgo
 */
@RestController
@RequestMapping(value = "/cafeto")
@SwaggerDefinition()
public class SystemController {

    private final SystemService systemService;

    @Autowired
    public SystemController(SystemService systemService){
        this.systemService = systemService;
    }

    /**
     * Post Method in REST that returns HTTP status code 200 if a system property is set to true, or HTTP status code 404 otherwise
     *
     * @param request, object with dna chain to analyze
     * @return {@link Object}, return empty body, the HTTP status is valid or not
     * @throws InvalidRequestException return generated exception on some invalid request validation
     */
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Internal Server Error"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    @PostMapping(value = "/compareProperty/")
    @ResponseBody
    public ResponseEntity<Object> getProperty(@Validated @RequestBody Request request) throws InvalidRequestException {
        boolean isOk = systemService.getProperty(request);
        return isOk ? ResponseEntity.ok().build() : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
