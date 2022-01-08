package com.ledgerco.io.input;

import com.ledgerco.LedgerApp;

public class PaymentCommand implements ICommand {
    private final String input;

    public PaymentCommand(String input) {
        this.input = input;
    }

    @Override
    public void execute(LedgerApp ledgerApp) {
        String[] strings = input.split(" ");
        ledgerApp.addPayment(strings[1], strings[2], Integer.parseInt(strings[3]), Integer.parseInt(strings[4]));
    }
}
