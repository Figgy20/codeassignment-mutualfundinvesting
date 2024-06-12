package fami.com.ph.view;

import fami.com.ph.err.InvalidFundSelectionException;
import fami.com.ph.err.InvalidInvestmentAmountInputException;
import fami.com.ph.model.MutualFund;
import fami.com.ph.model.ValidateUserData;

public class FamiPaymentProcess extends MutualFund implements ValidateUserData{

	@Override
	public double computeSalesLoad(double rawAmountInvested) {
		return rawAmountInvested*0.02;
	}

	@Override
	public double netAmountInvested(double rawAmountInvested, double salesLoadAmount) {
		return rawAmountInvested-salesLoadAmount;
	}

	@Override
	public double purchasedShares(double netAmountInvested, String chosenFund) {
		switch (chosenFund) {
		case "SALEF": {
			return netAmountInvested/SALEF_VALUE;
		}
		case "SALBF": {
			return netAmountInvested/SALBF_VALUE;
		}
		default:
			return netAmountInvested/SALFIF_VALUE;
		}
	}

	@Override
	public boolean isValidInvestmentAmount(double rawAmountInvested) throws InvalidInvestmentAmountInputException {
		if (rawAmountInvested>=1000) {
			return true;
		}
		throw new InvalidInvestmentAmountInputException("Invalid Investment Amount!");
	}

	@Override
	public boolean isValidFundSelection(String chosenFund) throws InvalidFundSelectionException {
		if (chosenFund.equals("SALBF")||chosenFund.equals("SALEF")||chosenFund.equals("SALFIF")) {
			return true;
		}
		throw new InvalidFundSelectionException("Invalid Fund Selection!");
	}

}
