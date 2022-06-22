package com.dimastik.servicecurrency;

import com.dimastik.servicecurrency.dto.CurrencyResponse;
import com.dimastik.servicecurrency.service.CurrencyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceCurrencyApplication.class)
@AutoConfigureMockMvc
public class CurrencyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CurrencyService currencyService;

    @Test
    @DisplayName("Проверка ответа")
    public void getResponse() throws Exception {
        String codCurrency = null;
        Mockito.when(currencyService.getCurrency(codCurrency)).thenReturn(buildCurrencyResponse());
        MvcResult mvcResult = mockMvc.perform(get("/api/getCurrency").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        CurrencyResponse currencyResponse = objectMapper.readValue(contentAsString, CurrencyResponse.class);
        Assertions.assertThat(currencyResponse.getValue()).isEqualTo(null);
        Assertions.assertThat(currencyResponse.getBase()).isEqualTo("USD");
    }

    @Test
    @DisplayName("Проверка ответа с параметром")
    public void getResponse_withParam() throws Exception {
        String codCurrency = "RUB";
        Mockito.when(currencyService.getCurrency(codCurrency)).thenReturn(buildCurrencyResponseWithParam());
        MvcResult mvcResult = mockMvc.perform(get("/api/getCurrency").contentType(MediaType.APPLICATION_JSON)
                        .param("codCurrency", codCurrency))
                .andExpect(status().isOk()).andReturn();

        String contentAsString = mvcResult.getResponse().getContentAsString();
        ObjectMapper objectMapper = new ObjectMapper();
        CurrencyResponse currencyResponse = objectMapper.readValue(contentAsString, CurrencyResponse.class);
        Assertions.assertThat(currencyResponse.getValue()).isEqualTo(25.15);
        Assertions.assertThat(currencyResponse.getBase()).isEqualTo("USD");
    }



    private CurrencyResponse buildCurrencyResponse() {
        CurrencyResponse response = new CurrencyResponse();
        Map<String, Double> rates = new HashMap<>();
        rates.put("USD", 1.0);
        rates.put("RUB", 25.15);

        response.setDisclaimer("Test disclaimer");
        response.setTimestamp("1655463600");
        response.setBase("USD");
        response.setRates(rates);

        return response;
    }

    private CurrencyResponse buildCurrencyResponseWithParam() {
        CurrencyResponse response = new CurrencyResponse();
        Map<String, Double> rates = new HashMap<>();
        rates.put("USD", 1.0);
        rates.put("RUB", 25.15);

        response.setDisclaimer("Test disclaimer");
        response.setTimestamp("1655463600");
        response.setBase("USD");
        response.setValue(rates.get("RUB"));
        response.setRates(rates);

        return response;
    }


}
