package com.ledgerco.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LoanTest {

    @Test
    void shouldCalculateCorrectNumberOfInstallmentsWithoutLumpSumPayments() {
        Loan loan = new Loan("bankName", "borrowerName",
                2000, 2, 2);

        assertThat(loan.remainingInstallmentsAfter(0)).isEqualTo(24);
        assertThat(loan.remainingInstallmentsAfter(24)).isEqualTo(0);
        assertThat(loan.remainingInstallmentsAfter(25)).isEqualTo(0);
        assertThat(loan.remainingInstallmentsAfter(26)).isEqualTo(0);
        assertThat(loan.remainingInstallmentsAfter(12)).isEqualTo(12);
    }

    @Test
    void shouldCalculateCorrectNumberOfInstallmentsWithoutLumpSumPaymentsWhenTermIsLessThanAnYear() {
        Loan loan = new Loan("bankName", "borrowerName",
                2000, 0.5, 2);

        assertThat(loan.remainingInstallmentsAfter(0)).isEqualTo(6);
        assertThat(loan.remainingInstallmentsAfter(6)).isEqualTo(0);
        assertThat(loan.remainingInstallmentsAfter(3)).isEqualTo(3);
    }

    @Test
    void shouldCalculateCorrectAmountPaidAfterNumberOfInstallmentsWithoutLumSumPayments() {
        Loan loan = new Loan("bankName", "borrowerName",
                2000, 0.5, 2);

        assertThat(loan.amountPaidAfterInstallments(0)).isEqualTo(0);
        assertThat(loan.amountPaidAfterInstallments(1)).isEqualTo(337);
        assertThat(loan.amountPaidAfterInstallments(2)).isEqualTo(337 * 2);
        assertThat(loan.amountPaidAfterInstallments(3)).isEqualTo(337 * 3);
        assertThat(loan.amountPaidAfterInstallments(4)).isEqualTo(337 * 4);
        assertThat(loan.amountPaidAfterInstallments(5)).isEqualTo(337 * 5);
        assertThat(loan.amountPaidAfterInstallments(6)).isEqualTo(2020);
        assertThat(loan.amountPaidAfterInstallments(7)).isEqualTo(2020);
    }

    @Test
    void ShouldCalculateNumberOfInstallmentsAs0IfTotalDebtIs0() {
        Loan zeroPrincipalLoan = new Loan("bankName", "borrowerName",
                0, 2, 2);
        assertThat(zeroPrincipalLoan.remainingInstallmentsAfter(0)).isEqualTo(0);
    }
}