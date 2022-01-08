package com.ledgerco;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class AppIntegrationTest {

    private PrintStream printStream;
    private ByteArrayOutputStream byteArrayOutputStream;

    @BeforeEach
    void setUp() {
        byteArrayOutputStream = new ByteArrayOutputStream();
        printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);
    }

    @AfterEach
    void tearDown() {
        System.setOut(System.out);
    }

    @Test
    void shouldProcessInputWithLoans() throws Exception {
        App.main(new String[]{"src/test/data/test-integration-loans"});
        byteArrayOutputStream.flush();
        assertThat(byteArrayOutputStream.toString().split("\n"))
                .containsExactly(
                        "IDIDI Dale 1000 55",
                        "IDIDI Dale 8000 20",
                        "MBI Harry 1044 12",
                        "MBI Harry 0 24");
    }

    @Test
    void shouldProcessInputWithLoansAndPayments() throws Exception {
        App.main(new String[]{"src/test/data/test-integration-loans-with-payments"});
        byteArrayOutputStream.flush();
        assertThat(byteArrayOutputStream.toString().split("\n"))
                .containsExactly(
                        "IDIDI Dale 1326 9",
                        "IDIDI Dale 3652 4",
                        "UON Shelly 15856 3",
                        "MBI Harry 9044 10");
    }
}