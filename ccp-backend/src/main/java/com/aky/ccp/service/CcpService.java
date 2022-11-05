package com.aky.ccp.service;

import com.aky.ccp.entity.CreditCardListModal;
import com.aky.ccp.entity.CreditCardModal;
import com.aky.ccp.mapper.CreditCardListRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class CcpService {
    private JdbcTemplate jdbcTemplate;

    public CcpService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<CreditCardListModal> getAllCreditCard() {
        return jdbcTemplate.query(CreditCardModal.CreditCardQuery.GET_ALL_CARD, new CreditCardListRowMapper());
    }

    public void addCreditCard (CreditCardModal card) {
        jdbcTemplate.update(CreditCardModal.CreditCardQuery.INSERT_CREDIT_CARD,
                new Object[] { card.getUserName(), card.getCardNumber(), card.getCardLimit(), 100 });
    }
}
