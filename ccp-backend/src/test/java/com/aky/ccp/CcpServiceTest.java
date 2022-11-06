package com.aky.ccp;

import com.aky.ccp.entity.CreditCardListModal;
import com.aky.ccp.entity.CreditCardModal;
import com.aky.ccp.service.CcpService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ActiveProfiles("test")
@ContextConfiguration(classes = CcpTestConfig.class)
public class CcpServiceTest {

    @Autowired
    CcpService ccpService;

    @BeforeAll
    public static void init(@Autowired JdbcTemplate jdbcTemplate) {
        jdbcTemplate.execute(CreditCardModal.CreditCardQuery.CREATE_CREDIT_CARD_TABLE);
    }


    @Test
    public void addCrediCard() {
        String cardNumber = "75196307901855697";
        CreditCardModal cd = new CreditCardModal("Test Card", cardNumber, 1000);
        ccpService.addCreditCard(cd);

        CreditCardListModal cardModal = ccpService.getAllCreditCard()
                .stream()
                .filter(card -> cardNumber.equals(card.getCardNumber()))
                .findFirst()
                .get();

        Assertions.assertEquals(cardModal.getBalance(), 100);
    }

    @Test
    public void addCrediCard_DuplicateKeyException() {
        String cardNumber = "19770618179789232";
        CreditCardModal cd = new CreditCardModal("Test Card", cardNumber, 1000);
        ccpService.addCreditCard(cd);
        DuplicateKeyException thrown = Assertions.assertThrows(DuplicateKeyException.class, () -> {
            ccpService.addCreditCard(cd);
        }, "DuplicateKeyException was expected");

        Assertions.assertTrue(thrown.getMessage().contains("Unique index or primary key violation"));
    }
}
