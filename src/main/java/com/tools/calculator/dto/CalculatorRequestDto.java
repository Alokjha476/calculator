package com.tools.calculator.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CalculatorRequestDto {
    private BigDecimal operand1;
    private BigDecimal operand2;
    private String operator;
}
