package com.tools.calculator.service;

import com.tools.calculator.dto.CalculatorRequestDto;
import com.tools.calculator.dto.CalculatorResponseDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalculatorService {

    public CalculatorResponseDto calculate(CalculatorRequestDto requestDto) {
        BigDecimal total = calculation(requestDto);
        return new CalculatorResponseDto(total);
    }

    public BigDecimal calculation(CalculatorRequestDto requestDto) {
        switch (requestDto.getOperator()) {
            case "+":
                return requestDto.getOperand1().add(requestDto.getOperand2());
            case "-":
                return requestDto.getOperand1().subtract(requestDto.getOperand2());
            case "/":
                return requestDto.getOperand1().divide(requestDto.getOperand2(), RoundingMode.HALF_UP);
            case "*":
                return requestDto.getOperand1().multiply(requestDto.getOperand2());
            case "pow":
                return BigDecimal.valueOf(Math.pow(requestDto.getOperand1().doubleValue(),
                        requestDto.getOperand2().doubleValue()));
            default:
                return BigDecimal.ZERO;
        }
    }
}
