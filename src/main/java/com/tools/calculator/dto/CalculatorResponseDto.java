package com.tools.calculator.dto;


import java.math.BigDecimal;

public class CalculatorResponseDto {
    public BigDecimal total;

    public CalculatorResponseDto() {
    }

    public CalculatorResponseDto(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
