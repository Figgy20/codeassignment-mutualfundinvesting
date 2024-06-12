package fami.com.ph.model;

public abstract class MutualFund implements ValidateUserData{
	public abstract double computeSalesLoad(double rawAmountInvested);
	public abstract double netAmountInvested(double rawAmountInvested, double salesLoadAmount);
	public abstract double purchasedShares(double netAmountInvested, String chosenFund);
	public final double SALEF_VALUE = 4.6125;
	public final double SALBF_VALUE = 2.4908;
	public final double SALFIF_VALUE = 2.4461;
	
	public final String SALEF_NAME = "Equity Fund";
	public final String SALBF_NAME = "Balanced Fund";
	public final String SALFIF_NAME = "Fixed Income Fund";
}
