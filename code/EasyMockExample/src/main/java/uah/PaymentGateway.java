package uah;

/**
 *  Simulates a bank gateway interface.
 */
public interface PaymentGateway {

    /**
     * Checks whether the account has enough credit balance
     */
    public boolean hasCredit(double amount);

    /**
     * An account is blocked if user tries to withdraw more than 
     * what is available in the account
     */
    public boolean isBlocked();

    /**
     * Withdraw amount
     * Precondition: the account must have enough credit.
     * @param amount to withdraw
     */
    public void withdraw(double amount);

}
