package com.epam.controller;

import com.epam.creditcard.CreditCardService;
import com.epam.creditcard.PaymentRequest;
import com.epam.creditcard.PaymentResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CreditCardController {

    @Autowired
    private CreditCardService service;


    @RequestMapping(value = "/creditcard", method = RequestMethod.POST)
    public PaymentResponse payWithCreditCard(@RequestBody PaymentRequest request) {
        log.info("=================");
        log.info("{}", request);
        return service.pay(request);
    }
}
