package com.ledgerco.io.input;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CommandFactoryTest {

    @Test
    void shouldCreateCorrectCommands() throws IOException {
        assertThat(CommandFactory.create("loan")).isInstanceOf(LoanCommand.class);
        assertThat(CommandFactory.create("payment")).isInstanceOf(PaymentCommand.class);
        assertThat(CommandFactory.create("balance")).isInstanceOf(BalanceCommand.class);
        assertThatThrownBy(() -> CommandFactory.create("invalid")).isInstanceOf(IOException.class);
    }
}