package com.dimastik.servicecurrency.dto;

import lombok.Data;

import java.util.Map;

@Data
public class CurrencyResponse {

    private String disclaimer;
    private String timestamp;
    private String base;
    private Double value;
    private Map<String, Double> rates;
}
