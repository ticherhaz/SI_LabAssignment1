/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.ticherhaz.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.ticherhaz.model.Bank;
import net.ticherhaz.model.Common;
import net.ticherhaz.model.Loan;

/**
 *
 * @author Hazman
 */
@WebServlet(name = "LoanServlet", urlPatterns = {"/LoanServlet"})
public class LoanServlet extends HttpServlet {

    private double loanAmount;
    private long numberOfYear;
    private String bankName;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType(Common.CONTENT_TYPE);

        //1st. Check if empty or not for both loan amount input and number of year input
        if (isEmpty(request.getParameter(Common.LOAN_AMOUNT)) && isEmpty(request.getParameter(Common.NUMBER_OF_YEAR))) {

            request.setAttribute(Common.ERROR_MESSAGE_LOAN_AMOUNT_NUMBER_OF_YEAR, Common.TEXT_ERROR_EMPTY_LOAN_AMOUNT_NUMBER_OF_YEAR);
            //Forward
            RequestDispatcher rd = request.getRequestDispatcher(Common.PAGE_INDEX);
            rd.forward(request, response);

        } //2nd. Check if loan amount has input and check if number of year is empty
        else if (isEmpty(request.getParameter(Common.LOAN_AMOUNT)) && !isEmpty(request.getParameter(Common.NUMBER_OF_YEAR))) {

            request.setAttribute(Common.ERROR_MESSAGE_LOAN_AMOUNT, Common.TEXT_ERROR_EMPTY_LOAN_AMOUNT);
            request.setAttribute(Common.NUMBER_OF_YEAR, request.getParameter(Common.NUMBER_OF_YEAR));
            //Forward
            RequestDispatcher rd = request.getRequestDispatcher(Common.PAGE_INDEX);
            rd.forward(request, response);

        } //3rd. Check if number of year has input and check if loan is empty
        else if (isEmpty(request.getParameter(Common.NUMBER_OF_YEAR)) && !isEmpty(request.getParameter(Common.LOAN_AMOUNT))) {

            request.setAttribute(Common.ERROR_MESSAGE_NUMBER_OF_YEAR, Common.TEXT_ERROR_EMPTY_NUMBER_OF_YEAR);
            request.setAttribute(Common.LOAN_AMOUNT, request.getParameter(Common.LOAN_AMOUNT));
            //Forward
            RequestDispatcher rd = request.getRequestDispatcher(Common.PAGE_INDEX);
            rd.forward(request, response);

        } else {
            //All success and we try catch if number format or not
            try {
                //Get the value of parameter
                loanAmount = Double.parseDouble(request.getParameter(Common.LOAN_AMOUNT));
                numberOfYear = Long.parseLong(request.getParameter(Common.NUMBER_OF_YEAR));
                bankName = request.getParameter(Common.BANK_NAME);

                //Make calculation
                Loan loan = new Loan(loanAmount, new Loan().calculation(Common.CALCULATOR, bankName, loanAmount, numberOfYear), numberOfYear, bankName);
                Bank bank = new Bank();

                //Add data in request
                request.setAttribute(Common.LOAN, loan);
                request.setAttribute(Common.BANK_NAME, bankName);
                request.setAttribute(Common.INTEREST_RATE, bank.getValueInterestRate(bankName));
                request.setAttribute(Common.MONTHLY_PAYMENT, new Loan().calculation(Common.MONTHLY_PAYMENT, bankName, loanAmount, numberOfYear));

                //Forward
                RequestDispatcher rd = request.getRequestDispatcher(Common.PAGE_RESULT);
                rd.forward(request, response);
            } catch (NumberFormatException ex) {
                notNumberType(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private boolean isEmpty(final String s) {
        return s == null || s.trim().length() == 0;
    }

    private void notNumberType(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute(Common.ERROR_MESSAGE_NUMBER_FORMAT, Common.TEXT_ERROR_EMPTY_NUMBER_FORMAT);
        //Forward
        RequestDispatcher rd = request.getRequestDispatcher(Common.PAGE_INDEX);
        rd.forward(request, response);
    }
}
