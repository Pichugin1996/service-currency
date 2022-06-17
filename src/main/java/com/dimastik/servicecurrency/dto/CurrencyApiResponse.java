package com.dimastik.servicecurrency.dto;

import lombok.Data;

import java.util.Map;

@Data
public class CurrencyApiResponse {

    private String disclaimer;
    private String timestamp;
    private String base;
    private Map<String, Double> rates;
}
