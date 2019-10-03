<%-- 
    Document   : result
    Created on : Sep 26, 2019, 7:52:09 AM
    Author     : Hazman
--%>

<%@page import="net.ticherhaz.model.Common"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.NumberFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="net.ticherhaz.model.Loan" %>
<%@page import="net.ticherhaz.model.Bank" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Result Loan</title>
    </head>
    <body>
        <%
            //Getting all the attributes
            Loan loan = (Loan) request.getAttribute(Common.LOAN);
            String bankName = (String) request.getAttribute(Common.BANK_NAME);
            double interestRate = (Double) request.getAttribute(Common.INTEREST_RATE);
            double monthlyPayment = (Double) request.getAttribute(Common.MONTHLY_PAYMENT);

            //Loan Amount
            NumberFormat number = NumberFormat.getCurrencyInstance(Locale.getDefault());
            final String loanAmount = number.format(loan.getLoanAmount());

            //Years
            String yearsString = String.format(Locale.getDefault(), Common.YEAR_STRING_FORMAT, loan.getNumberOfYear());

            //Interest
            final String interestString = String.format(Locale.getDefault(), Common.INTEREST_RATE_STRING_FORMAT, interestRate);

            //Monthyly Payment
            final String monthlyPaymentString = number.format(monthlyPayment);

            //Result
            final String resultString = number.format(loan.getResult());
        %>

        <h1>Calculate Loan Result:</h1>
        <p>
            Loan Amount: <%= loanAmount%>
        </p>
        <p>
            No. of Years: <%= yearsString%>
        </p>
        <p>
            Bank Name: <%= bankName%>
        </p>
        <p>
            Interest Rate: <%= interestString%>
        </p>
        <p>
            Monthly Payment: <%= monthlyPaymentString%>
        </p>
        <p>
           Total Payment: <%=  resultString%>    
        </p>
        <br>
    </body>
</html>
