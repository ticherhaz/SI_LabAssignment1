/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ticherhaz.model;

import java.lang.Math;

/**
 *
 * @author Hazman
 */
public class Loan {

    private double loanAmount, result;
    private long numberOfYear;
    private String loanUid;

    public Loan() {
    }

    public Loan(double loanAmount, double result, long numberOfYear, String loanUid) {
        this.loanAmount = loanAmount;
        this.result = result;
        this.numberOfYear = numberOfYear;
        this.loanUid = loanUid;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public long getNumberOfYear() {
        return numberOfYear;
    }

    public void setNumberOfYear(long numberOfYear) {
        this.numberOfYear = numberOfYear;
    }

    public String getLoanUid() {
        return loanUid;
    }

    public void setLoanUid(String loanUid) {
        this.loanUid = loanUid;
    }

    /**
     * Calculation
     *
     * @param typeCalculator
     * @param bankName different bank name
     * @param loanAmount from the user
     * @param numberOfYear from the user
     * @return
     */
    public double calculation(final String typeCalculator, final String bankName, final double loanAmount, final long numberOfYear) {
        Bank bank = Bank.getInstance();

        for (int i = 0; i < bank.getBankUid().length; i++) {
            if (bankName.equals(bank.getBankName()[i])) {

                this.loanAmount = loanAmount;
                this.numberOfYear = numberOfYear;
                double interestRate = bank.getInterestRate()[i];

                //Check type of payment
                if (typeCalculator.equals("calculator")) {
                    result = loanAmount * bank.getInterestRate()[i];
                }

                if (typeCalculator.equals("monthlyPayment")) {
                    // Convert interest rate into a decimal
                    // eg. 6.5% = 0.065

                    interestRate /= 100.0;

                    // Monthly interest rate 
                    // is the yearly rate divided by 12
                    double monthlyRate = interestRate / 12.0;

                    // The length of the term in months 
                    // is the number of years times 12
                    int termInMonths = (int) (numberOfYear * 12);

                    // Calculate the monthly payment
                    // Typically this formula is provided so 
                    // we won't go into the details
                    // The Math.pow() method is used calculate values raised to a power
                    result = (loanAmount * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -termInMonths));
                }

            }
        }
        return result;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
