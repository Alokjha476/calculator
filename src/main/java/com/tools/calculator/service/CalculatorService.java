package com.tools.calculator.service;

import com.tools.calculator.dto.CalculatorRequestDto;
import com.tools.calculator.dto.CalculatorResponseDto;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

@Service
public class CalculatorService {

    public CalculatorResponseDto calculate(CalculatorRequestDto requestDto) {
        BigDecimal total = calculation(requestDto);
        return new CalculatorResponseDto(total);
    }
    public static int fac(int n){
        int fac = 1;
        for (int i = 1; i <= n; i++) {  // Loop
            fac *= i;
        }
        return fac;
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
            case "Under-root":
                return BigDecimal.valueOf(Math.sqrt(requestDto.getOperand1().doubleValue()));
            case "cube-root":
                return BigDecimal.valueOf(Math.cbrt(requestDto.getOperand1().doubleValue()));
            case "sin":
                return BigDecimal.valueOf(Math.sin(requestDto.getOperand1().doubleValue()));
            case "cos":
                return BigDecimal.valueOf(Math.cos(requestDto.getOperand1().doubleValue()));
            case "tan":
                return BigDecimal.valueOf(Math.tan(requestDto.getOperand1().doubleValue()));
            case "cosh":
                return BigDecimal.valueOf(Math.cosh(requestDto.getOperand1().doubleValue()));
            case "sinh":
                return BigDecimal.valueOf(Math.sinh(requestDto.getOperand1().doubleValue()));
            case "tanh":
                return BigDecimal.valueOf(Math.tanh(requestDto.getOperand1().doubleValue()));
            case "factorial":
                return BigDecimal.valueOf(fac(requestDto.getOperand1().intValue()));
            case "log":
               return BigDecimal.valueOf(Math.log(requestDto.getOperand1().doubleValue()));

            default:
                return BigDecimal.ZERO;
        }
    }
}
