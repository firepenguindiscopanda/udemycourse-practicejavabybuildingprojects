package bankaccountapp;

public abstract class Account implements IBaseRate {
	// abstract means that we will not able to crate objects from the account class
	// but we will be able to make objects from the classes that inherit the abstract class
	
	// List common properties for both Savings and Checking accounts
	private String name;
	private String sSn;
	private double balance;
	protected double rate;
	protected String accountNumber;
	private static int index = 10000;
	
	
	// Constructor to set base properties and initialize an account
	public Account(String name, String sSn, double initDeposit) {
		this.name = name;
		this.sSn = sSn;
		this.balance = this.balance + initDeposit;

		// SUPER-CLASS GETS CALLED FIRST WHEN WE MAKE A NEW 'CHECKING' OBJECT
		// THIS MEANS THAT EVERYTHING IN THE CONSRUCTOR OF THE SUPER-CLASS (ACCOUNT) WILL 
		// ALSO BE CALLED FIRST BEFORE THE CODE IN THE CHECKING CLASS CONSTRUCTOR
		
		// Set account number
		index++;
		this.accountNumber = setAccountNumber();
		
		setRate();

	}
	
	public abstract void setRate();
	
	// List common methods
	public String setAccountNumber() {
		String lastTwoDigitsOfSSN = this.sSn.substring(sSn.length()-2, sSn.length());
		int uniqueID = index;
		int randomNumber = (int) (Math.random() * Math.pow(10, 3));
		return lastTwoDigitsOfSSN + uniqueID + randomNumber;
	}
	
	
	public void deposit(double amount) {
		balance = balance + amount;
		System.out.println("Depositing $" + amount + ".");
	}
	
	
	public void withdraw(double amount) {
		balance = balance - amount;
		System.out.println("Withdrawing $" + amount + ".");
	}
	
	public void printBalance() {
		System.out.println("The balance of the account is: " + balance);
	}
	
	
	public void transfer(String toWhere, double amount) {
		balance = balance - amount;
		System.out.println("Transfering $" + amount + " to " + toWhere);
	}
	
	public void compond() {
		double accruedInterest = balance * (rate/100);
		System.out.println("Accrued Interest: $" + accruedInterest);
	}
	
	
	public void showInfo() {
		System.out.println(
				"NAME: " + name +
				"\nACCOUNT NUMBER: " + accountNumber +
				"\nBALANCE: " + balance +
				"\nRATE: " + rate + "%"
				);
	}

}
