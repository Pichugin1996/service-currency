package com.dimastik.servicecurrency.controller;

import com.dimastik.servicecurrency.dto.CurrencyApiResponse;
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
    public CurrencyApiResponse getCurrency() {
       return currencyService.getCurrency();
    }

}
