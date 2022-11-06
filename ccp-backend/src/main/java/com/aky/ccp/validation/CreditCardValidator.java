package com.aky.ccp.validation;

import com.aky.ccp.entity.CreditCardModal;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class CreditCardValidator implements Validator<CreditCardModal>{

    @Override
    public Map<String, String> validate(CreditCardModal entity) {
        Map<String, String> validationErrors = new HashMap<>();
        if(!StringUtils.hasText(entity.getCardNumber())){
            validationErrors.put("cardNumber", "Card number must not be empty!");
        } else if(isValidLength(entity.getCardNumber()) && !isValidLuhn10(entity.getCardNumber())){
            validationErrors.put("cardNumber", "should be valid as per Luhn 10 algorithm and must be a 16 to 19 digit number!");
        }

        if(!(entity.getCardLimit() > 0)){
            validationErrors.put("cardLimit", "Card Limit must be a valid number and greater than 0!");
        }
        return validationErrors.isEmpty() ? null : validationErrors;
    }

    private boolean isValidLength(String cardNumber) {
        String trimmedStr = StringUtils.trimAllWhitespace(cardNumber);
        return trimmedStr.length() >= 16 && trimmedStr.length()<=19;
    }
    private boolean isValidLuhn10(String cardNumber) {
        cardNumber = cardNumber.replaceAll("[ -]", "");
        int sum = 0;
        int len = cardNumber.length();
        int rem = len % 2;
        for (int i=0; i<len; i++){
            int digit = (int) cardNumber.charAt(i) - '0';
            if (i % 2 == rem) {
                digit *= 2;
                if (digit > 9)
                    digit -= 9;
            }
            sum += digit;
        }
        return (sum % 10) == 0;
    }
}
