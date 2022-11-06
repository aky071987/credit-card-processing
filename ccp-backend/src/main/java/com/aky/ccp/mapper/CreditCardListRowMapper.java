package com.aky.ccp.mapper;

import com.aky.ccp.entity.CreditCardListModal;
import com.aky.ccp.entity.CreditCardModal.CreditCardQuery.COLUMN_NAMES;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CreditCardListRowMapper implements RowMapper<CreditCardListModal> {
    public CreditCardListModal mapRow(ResultSet rs, int rowNum) throws SQLException {
        CreditCardListModal card= new CreditCardListModal();
        card.setId(rs.getInt("id"));
        card.setUserName(rs.getString(COLUMN_NAMES.user_name.name()));
        card.setCardNumber(rs.getString(COLUMN_NAMES.card_number.name()));
        card.setCardLimit(rs.getInt(COLUMN_NAMES.card_limit.name()));
        card.setBalance(rs.getInt(COLUMN_NAMES.balance.name()));
        return card;
    }
}