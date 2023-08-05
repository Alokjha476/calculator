package com.tools.calculator.service;

import com.tools.calculator.dto.CalculatorRequestDto;
import com.tools.calculator.dto.CalculatorResponseDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalculatorService {

    public CalculatorResponseDto calculate(CalculatorRequestDto requestDto) {
        BigDecimal total;
        switch (requestDto.getOperator()) {
            case "+":
                total = requestDto.getOperand1().add(requestDto.getOperand2());
                break;
            case "-":
                total = requestDto.getOperand1().subtract(requestDto.getOperand2());
                break;
            case "/":
                total = requestDto.getOperand1().divide(requestDto.getOperand2(), RoundingMode.HALF_UP);
                break;
            case "*":
                total = requestDto.getOperand1().multiply(requestDto.getOperand2());
                break;
            default:
                total = BigDecimal.ZERO;
        }
        return new CalculatorResponseDto(total);
    }
}
