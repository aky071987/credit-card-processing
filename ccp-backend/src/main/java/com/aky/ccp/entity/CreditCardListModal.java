package com.aky.ccp.entity;

public class CreditCardListModal extends CreditCardModal {
    private int balance;
    public CreditCardListModal(){}
    public CreditCardListModal(String userName, String number, int limit, int balance) {
        super(userName, number, limit);
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
