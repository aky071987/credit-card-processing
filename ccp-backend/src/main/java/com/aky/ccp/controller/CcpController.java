package com.aky.ccp.controller;

import com.aky.ccp.api.Response;
import com.aky.ccp.entity.CreditCardListModal;
import com.aky.ccp.entity.CreditCardModal;
import com.aky.ccp.service.CcpService;
import com.aky.ccp.validation.CreditCardValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/api")
public class CcpController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CcpController.class);
    private final CcpService ccpService;
    private final CreditCardValidator creditCardValidator;

    public CcpController(CcpService ccpService, CreditCardValidator creditCardValidator) {
        this.ccpService = ccpService;
        this.creditCardValidator = creditCardValidator;
    }


    @GetMapping("/creditCards")
    public Response<List<CreditCardListModal>> getAllCreditCards() {
        return new Response<>("success", null, ccpService.getAllCreditCard());
    }

    @PostMapping(value = "/addCreditCard", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public Response createCreditCard(@RequestBody CreditCardModal creditCard) {
        Response response = null;
        Map<String, String> validationResult = creditCardValidator.validate(creditCard);
        if(Objects.isNull(validationResult)){
            try {
                ccpService.addCreditCard(creditCard);
                response = new Response<>("success", null, creditCard);
            } catch (DuplicateKeyException e) {
                LOGGER.info("exception saving credit card", e);
                response = new Response<>("success", Map.of("cardNumber","Card number already exists!"), null);
            }
        } else {
            response = new Response<>("success", validationResult, null);;
        }
        return response;
    }
}
