package com.dimastik.servicecurrency.service;

import com.dimastik.servicecurrency.client.CurrencyClient;
import com.dimastik.servicecurrency.dto.CurrencyResponse;
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

    public CurrencyResponse getCurrency(String codCurrency) {
        CurrencyResponse response = currencyClient.getCurrencies(key);
        if (codCurrency != null) {
            if (codCurrency == "") {
                codCurrency = "RUB";
            } else if (!response.getRates().containsKey(codCurrency)) {
                codCurrency = "RUB";
            }
            response.setValue(response.getRates().get(codCurrency));
            response.setCodCurrency(codCurrency);
        }
        return response;

    }
}
