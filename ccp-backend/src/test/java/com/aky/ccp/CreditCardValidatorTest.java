package com.aky.ccp;

import com.aky.ccp.entity.CreditCardModal;
import com.aky.ccp.validation.CreditCardValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class CreditCardValidatorTest {
    CreditCardValidator validator = new CreditCardValidator();

    @Test
    public void test_validateCardNumber(){
        String cardNumber = "19770618179789231";
        CreditCardModal cd = new CreditCardModal("Test Card", cardNumber, 1000);
        Map<String, String> validationResult = validator.validate(cd);
        Assertions.assertNotNull(validationResult);
        Assertions.assertNotNull(validationResult.get("cardNumber"));
    }

    @Test
    public void test_validateCardLimit(){
        String cardNumber = "75196307901855697";
        CreditCardModal cd = new CreditCardModal("Test Card", cardNumber, 0);
        Map<String, String> validationResult = validator.validate(cd);
        Assertions.assertNotNull(validationResult);
        Assertions.assertNull(validationResult.get("cardNumber"));
        Assertions.assertNotNull(validationResult.get("cardLimit"));
    }
}
