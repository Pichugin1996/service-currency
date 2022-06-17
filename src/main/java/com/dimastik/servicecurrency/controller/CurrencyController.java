package com.dimastik.servicecurrency.controller;

import com.dimastik.servicecurrency.dto.CurrencyResponse;
import com.dimastik.servicecurrency.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CurrencyController {

    private final CurrencyService currencyService;

    @Autowired
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/get")
    public CurrencyResponse getCurrency(@RequestParam(value = "codCurrency", required = false) String codCurrency) {
       return currencyService.getCurrency(codCurrency);
    }

}
