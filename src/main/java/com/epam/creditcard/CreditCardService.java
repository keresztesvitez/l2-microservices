package com.epam.creditcard;

import com.epam.helper.LoggingRequestInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.BufferingClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;

@Service
public class CreditCardService {

    private final RestTemplate restTemplate;

    @Autowired
    public CreditCardService() {
        restTemplate = new RestTemplate(new BufferingClientHttpRequestFactory(new SimpleClientHttpRequestFactory()));
        restTemplate.setInterceptors(Collections.singletonList(new LoggingRequestInterceptor()));
    }

    public PaymentResponse pay(PaymentRequest request) {
        //TODO move url to application.yml
        PaymentResponse paymentResponse = restTemplate.postForObject("http://localhost:8085/pay", request, PaymentResponse.class);
        return paymentResponse;
    }

}
