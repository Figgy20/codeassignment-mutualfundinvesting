package fami.com.ph.model;

import fami.com.ph.err.InvalidFundSelectionException;
import fami.com.ph.err.InvalidInvestmentAmountInputException;

public interface ValidateUserData {
	boolean isValidInvestmentAmount(double investmentAmount) throws InvalidInvestmentAmountInputException;
	boolean isValidFundSelection(String fundSelection) throws InvalidFundSelectionException;
}
