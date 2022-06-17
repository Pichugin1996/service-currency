package com.dimastik.servicecurrency.service;

import com.dimastik.servicecurrency.client.CurrencyClient;
import com.dimastik.servicecurrency.dto.CurrencyApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {

    private final String key;
    private final CurrencyClient currencyClient;

    @Autowired
    public CurrencyService(@Value("${currency.key}") String key,
                           CurrencyClient currencyClient) {
        this.key = key;
        this.currencyClient = currencyClient;
    }

    public CurrencyApiResponse getCurrency() {
        return currencyClient.getCurrencies(key);

    }
}