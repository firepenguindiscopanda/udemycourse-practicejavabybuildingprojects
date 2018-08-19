package bankaccountapp;

import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {

	public static void main(String[] args) {
		List<Account> accounts = new LinkedList<Account>();
		
		//String[] names = {"test1", "test2"}; // An array of String objects
		
		
		String file = "C:\\Users\\User1\\Desktop\\NewBankAccounts.csv";

		List<String[]> newCustomers = utilities.CSV.read(file);
		
		for (String[] customer : newCustomers) {
			String name = customer[0];
			String sSn = customer[1];
			String accountType = customer[2];
			double initDeposit = Double.parseDouble(customer[3]);
			if (accountType.equals("Savings")) {
				accounts.add(new Savings(name, sSn, initDeposit));
			} else if (accountType.equals("Checking")) {
				accounts.add(new Checking(name, sSn, initDeposit));
			} else {
				System.out.println("Invalid account type!");
			}
		}
		
		for (Account acc : accounts) {
			System.out.println("\n*******************");
			acc.showInfo();
		}
		

	}

}
