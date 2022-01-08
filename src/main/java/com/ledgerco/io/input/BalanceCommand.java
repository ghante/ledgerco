package com.ledgerco.io.input;

import com.ledgerco.LedgerApp;

public class BalanceCommand implements ICommand {
    private final String input;

    public BalanceCommand(String input) {
        this.input = input;
    }

    @Override
    public void execute(LedgerApp ledgerApp) {
        String[] strings = input.split(" ");
        ledgerApp.balance(strings[1], strings[2], Integer.parseInt(strings[3]));
    }
}
