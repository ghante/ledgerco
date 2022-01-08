package com.ledgerco.io.input;

import java.io.IOException;

public class CommandFactory {
    public static ICommand create(String input) throws IOException {
        String commandString = input.split(" ")[0];

        if (commandString.equalsIgnoreCase("loan")) {
            return new LoanCommand(input);
        }
        if (commandString.equalsIgnoreCase("payment")) {
            return new PaymentCommand(input);
        }
        if (commandString.equalsIgnoreCase("balance")) {
            return new BalanceCommand(input);
        }

        throw new IOException();
    }
}
