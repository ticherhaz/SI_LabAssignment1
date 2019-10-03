/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ticherhaz.model;

/**
 *
 * @author Hazman
 */
public class Bank {

    private final static String[] BANK_UID = {Common.BANK_CLIMB_UID, Common.BANK_CIMP_UID, Common.BANK_CIMB_UID, Common.BANK_MBB_UID};
    private final static String[] BANK_NAME = {Common.BANK_CLIMB, Common.BANK_CIMP, Common.BANK_CIMB, Common.BANK_MBB};
    private final static double[] INTEREST_RATE = {Common.INTEREST_RATE_CLIMB, Common.INTEREST_RATE_CIMP, Common.INTEREST_RATE_CIMB, Common.INTEREST_RATE_MBB};

    private String[] bankUid, bankName;
    private double[] interestRate;
    private static Bank instance;

    public Bank() {
    }

    public static synchronized Bank getInstance() {
        if (instance == null) {
            instance = new Bank(BANK_UID, BANK_NAME, INTEREST_RATE);
        }
        return instance;
    }

    public double getValueInterestRate(final String bankName) {
        for (int i = 0; i < BANK_NAME.length; i++) {
            if (bankName.equals(BANK_NAME[i])) {
                return INTEREST_RATE[i];
            }
        }
        return 0;
    }

    public Bank(String[] bankUid, String[] bankName, double[] interestRate) {
        this.bankUid = bankUid;
        this.bankName = bankName;
        this.interestRate = interestRate;
    }

    public String[] getBankUid() {
        return bankUid;
    }

    public void setBankUid(String[] bankUid) {
        this.bankUid = bankUid;
    }

    public String[] getBankName() {
        return bankName;
    }

    public void setBankName(String[] bankName) {
        this.bankName = bankName;
    }

    public double[] getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double[] interestRate) {
        this.interestRate = interestRate;
    }
}
