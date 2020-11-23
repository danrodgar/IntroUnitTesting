package uah;

/**
 * Simulates an ATM.
 */
public class ATM {

    private String code = null;

    /**
     * Account used in a session.
     */
    private String acc;

    public ATM(String code) {
        this.code = code;
    }

    public void startSession(String acc) {
        assert (this.acc == null);
        this.acc = acc;
    }

    public void closeSession() {
        assert (acc != null);
        acc = null;
    }

    public boolean withdraw(double amount, PaymentGateway p) {
        assert (acc != null);
        boolean isSuccessful = false;
        if (!p.isBlocked() && p.hasCredit(amount)) {
            p.withdraw(amount);
            isSuccessful = true;
        }
        return isSuccessful;
    }
}
