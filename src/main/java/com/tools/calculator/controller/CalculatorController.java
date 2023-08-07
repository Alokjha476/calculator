package com.tools.calculator.controller;

import com.tools.calculator.dto.CalculatorRequestDto;
import com.tools.calculator.dto.CalculatorResponseDto;
import com.tools.calculator.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    List<String> ops = Arrays.asList("Under-root", "cube-root");

    @PostMapping(value = "/calculate")
    public ResponseEntity<Object> calculate(@RequestBody CalculatorRequestDto payload) {
        if (payload.getOperand1() == null || (!ops.contains(payload.getOperator()) && payload.getOperand2() == null) || payload.getOperator() == null) {
            Map<String, Object> res = new HashMap<>();
            res.put("total", "No field should be empty");
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        CalculatorResponseDto response = calculatorService.calculate(payload);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}