package fami.com.ph.controller;

import java.io.IOException;

import fami.com.ph.err.InvalidFundSelectionException;
import fami.com.ph.err.InvalidInvestmentAmountInputException;
import fami.com.ph.view.FamiPaymentProcess;
import uc.edu.ph.utility.Reader;

public class FamiPaymentCounter{

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		String investorName = Reader.readString("Investor Name");
        String mutualFundType = Reader.readString("Mutual Fund Type");
        mutualFundType = mutualFundType.toUpperCase();
        System.out.println(mutualFundType);
        double amountInvested = Reader.readDouble("Investment Amount");
        
        FamiPaymentProcess paymentProcess = new FamiPaymentProcess();
        
		String continueCheck = "y";
        
		while (continueCheck.equalsIgnoreCase("y")) {
			try {
				paymentProcess.isValidFundSelection(mutualFundType);
			} catch (InvalidFundSelectionException e) {
				System.err.println(e);
				break;
			}
			
			try {
				paymentProcess.isValidInvestmentAmount(amountInvested);
			} catch (InvalidInvestmentAmountInputException e) {
				System.err.println(e);
				break;
			}
			
			
			
			System.out.println("\n\nInvestor Name: " + investorName);
			
			switch (mutualFundType) {
				case "SALEF": {
					System.out.println("Investment Fund Type is Save and Learn " + paymentProcess.SALEF_NAME);
					System.out.println("NAVPS: " + paymentProcess.SALEF_VALUE);
					break;
				}
				case "SALBF": {
					System.out.println("Investment Fund Type is Save and Learn " + paymentProcess.SALBF_NAME);
					System.out.println("NAVPS: " + paymentProcess.SALBF_VALUE);
					break;
				}
				default:{
					System.out.println("Investment Fund Type is Save and Learn " + paymentProcess.SALFIF_NAME);
					System.out.println("NAVPS: " + paymentProcess.SALFIF_VALUE);
					break;
				}
			}

			double salesLoadAmount = paymentProcess.computeSalesLoad(amountInvested);
			double netAmountInvested = paymentProcess.netAmountInvested(amountInvested, salesLoadAmount);
			double totalSharesBought = paymentProcess.purchasedShares(netAmountInvested, mutualFundType);
			
			System.out.println("Amount Invested is " + amountInvested);
			System.out.println("Sales Load Amount: " + salesLoadAmount);
			System.out.println("Net Amount Invested: " + netAmountInvested); 
			System.out.println("Total Shares Bought: " + totalSharesBought);
			
			System.out.print("Do you want to continue? ");
			continueCheck = Reader.readString("[Y/N]");
		}
	}
}
