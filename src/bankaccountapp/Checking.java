package bankaccountapp;

public class Checking extends Account {
	// List common properties for a Checking account
	private int debitCardNumber;
	private int debitCardPIN;
	
	
	// Constructor to initialize our checking account properties
	public Checking(String name, String sSn, double initDeposit) {
		super(name, sSn, initDeposit);
		accountNumber = "2" + accountNumber;
		setDebitCard();
	}
	
	@Override
	public void setRate() {
		rate = getBaseRate() - .25;
	}
	
	private void setDebitCard() {
		// Private because we don't want this method to be available outside this class
		debitCardNumber = (int) (Math.random() * Math.pow(10, 12));
		debitCardPIN = (int) (Math.random() * Math.pow(10, 4));
	}
	
	public void showInfo() {
		System.out.println("ACCOUNT TYPE: Checking Account");
		super.showInfo();
		System.out.println("* Your Checking Account Features:" +
				"\n- Debit Card Number: " + debitCardNumber +
				"\n- Debit Card PIN: " + debitCardPIN
				);
	}
	
	// List any methods to the Checking account
}
