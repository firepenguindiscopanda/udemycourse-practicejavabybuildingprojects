package bankaccountapp;

public interface IBaseRate {
	
	// Write a method that returns the Base Interest Rate
	default double getBaseRate() {
		return 2.5;
	}
}
