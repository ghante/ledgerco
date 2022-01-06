package com.ledgerco.domain;

public class Loan {
    private static final int MONTHS_IN_YEAR = 12;
    private final String bankName;
    private final String borrowerName;
    private final double principal;
    private final double term;
    private final double rateOfInterest;

    public Loan(String bankName, String borrowerName, double principal, double term, double rateOfInterest) {
        this.bankName = bankName;
        this.borrowerName = borrowerName;
        this.principal = principal;
        this.term = term;
        this.rateOfInterest = rateOfInterest;
    }

    public int remainingInstallmentsAfter(int installments) {
        if (installments <= termInMonths() && totalDebt() > 0) {
            return ceilToInt(termInMonths() - installments);
        }
        return 0;
    }

    public int amountPaidAfterInstallments(int installments) {
        int totalAmountInInstallments = installmentAmount() * Math.min(installments, termInMonths());
        if (totalAmountInInstallments > totalDebt()) {
            return ceilToInt(totalDebt());
        }
        return totalAmountInInstallments;
    }

    private int termInMonths() {
        return ceilToInt(term * MONTHS_IN_YEAR);
    }

    private int installmentAmount() {
        return ceilToInt(totalDebt() / termInMonths());
    }

    private double totalDebt() {
        return principal + interest();
    }

    private double interest() {
        return principal * term * rateOfInterest / 100;
    }

    private int ceilToInt(double number) {
        return (int) Math.ceil(number);
    }
}
