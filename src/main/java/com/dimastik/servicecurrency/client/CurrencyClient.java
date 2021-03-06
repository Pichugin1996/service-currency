package com.dimastik.servicecurrency.client;

import com.dimastik.servicecurrency.dto.CurrencyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "currencyClient", url = "${currency.url}")
public interface CurrencyClient {

    @RequestMapping(method = RequestMethod.GET, value = "/api/latest.json")
    CurrencyResponse getCurrencies(@RequestParam("app_id") String key);
}
