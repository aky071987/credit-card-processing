package com.aky.ccp.entity;

public class CreditCardModal {
    private String userName;
    private String cardNumber;
    private int cardLimit;

    public CreditCardModal(String userName, String number, int limit) {
        this.userName = userName;
        this.cardNumber = number;
        this.cardLimit = limit;
    }

    public CreditCardModal() {}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCardLimit() {
        return cardLimit;
    }

    public void setCardLimit(int cardLimit) {
        this.cardLimit = cardLimit;
    }

    public static class CreditCardQuery {
        public static enum COLUMN_NAMES {
            user_name, card_number, card_limit, balance
        }
        public static final String GET_ALL_CARD = "SELECT * FROM CREDIT_CARD";
        public static final String INSERT_CREDIT_CARD = "INSERT INTO CREDIT_CARD (user_name, card_number, card_limit, balance) VALUES (?, ?, ?, ?)";
        public static final String CREATE_CREDIT_CARD_TABLE = "DROP TABLE IF EXISTS credit_card; " +
                "CREATE TABLE credit_card" +
                " (id INTEGER auto_increment PRIMARY KEY," +
                " user_name VARCHAR(255), " +
                " card_number VARCHAR(19) unique, " +
                " card_limit INTEGER, " +
                " balance INTEGER)";
    }
}
