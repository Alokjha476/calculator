package com.tools.calculator.controller;

import com.tools.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @PostMapping(value = "/calculate")
    public ResponseEntity<Object> calculate(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<>(HttpStatus.OK);
    }
}