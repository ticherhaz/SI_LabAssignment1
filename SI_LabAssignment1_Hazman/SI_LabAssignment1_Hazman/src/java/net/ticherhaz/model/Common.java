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
public class Common {

    //Variable
    public final static String LOAN_AMOUNT = "loanAmount";
    public final static String NUMBER_OF_YEAR = "numberOfYear";
    public final static String BANK_NAME = "bankName";
    public final static String CALCULATOR = "calculator";
    public final static String MONTHLY_PAYMENT = "monthlyPayment";
    public final static String LOAN = "loan";
    public final static String INTEREST_RATE = "interestRate";

    //Bank
    public final static String BANK_CLIMB = "CLIMB";
    public final static String BANK_CIMP = "CIMP";
    public final static String BANK_CIMB = "CIMB";
    public final static String BANK_MBB = "MBB";

    //BankUid
    public final static String BANK_CLIMB_UID = "climb";
    public final static String BANK_CIMP_UID = "cimp";
    public final static String BANK_CIMB_UID = "cimb";
    public final static String BANK_MBB_UID = "mbb";

    //Interest Rate Bank
    public final static double INTEREST_RATE_CLIMB = 2.7;
    public final static double INTEREST_RATE_CIMP = 3.2;
    public final static double INTEREST_RATE_CIMB = 4.1;
    public final static double INTEREST_RATE_MBB = 2.6;

    //Error
    public final static String ERROR_MESSAGE_LOAN_AMOUNT = "errorMessageLoanAmount";
    public final static String ERROR_MESSAGE_NUMBER_OF_YEAR = "errorMessageNumberOfYear";
    public final static String ERROR_MESSAGE_LOAN_AMOUNT_NUMBER_OF_YEAR = "errorMessageLoanAmountNumberOfYear";
    public final static String ERROR_MESSAGE_NUMBER_FORMAT = "errorMessageNumberFormat";

    //Text Error Display
    public final static String TEXT_ERROR_EMPTY_LOAN_AMOUNT = "Please Enter Loan Amount";
    public final static String TEXT_ERROR_EMPTY_NUMBER_OF_YEAR = "Please Enter Number of Year";
    public final static String TEXT_ERROR_EMPTY_LOAN_AMOUNT_NUMBER_OF_YEAR = "Please Enter Loan Amount and Number of Year";
    public final static String TEXT_ERROR_EMPTY_NUMBER_FORMAT = "Please Enter Number Type Only";

    //Page
    public final static String PAGE_INDEX = "index.jsp";
    public final static String PAGE_RESULT = "result.jsp";

    //Content Type
    public final static String CONTENT_TYPE = "text/html;charset=UTF-8";

    //Format String
    public final static String YEAR_STRING_FORMAT = "%d year";
    public final static String INTEREST_RATE_STRING_FORMAT = "%.2f%%";
}
