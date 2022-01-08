package com.ledgerco.io.input;

public interface ICommand {
    void execute(com.ledgerco.LedgerApp ledgerApp) throws Exception;
}
