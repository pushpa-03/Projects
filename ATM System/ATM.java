import java.util.ArrayList;
import java.util.List;

public class ATM {

    private String atmId;
    private Location location;
    private CurrencyComposition currencyComposition;
    private long balance;
    private Condition condition;
    private List<Transaction> transactionList = new ArrayList<>();

    public ATM(String atmId, Location location, CurrencyComposition composition) {
        this.atmId = atmId;
        this.location = location;
        this.currencyComposition = composition;
        condition = Condition.WORKING;
        this.balance = getBalance(composition);
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setCurrencyComposition(CurrencyComposition composition) {
        this.currencyComposition = composition;
    }

    private long getBalance(CurrencyComposition composition) {
        return composition.getFiveHunderedNote() * 500 + composition.getTwoHunderedNote() * 200
                + composition.getTwoHunderedNote() * 100 + composition.getFiftyNote() * 50
                + composition.getTenNote() * 10;
    }

    public String getAtmId() {
        return this.atmId;
    }

    public Location getLocation() {
        return this.location;
    }

    public Condition geCondition() {
        return this.condition;
    }

    public long getBalance() {
        return this.balance;
    }

    public void setBalance(long bal) {
        this.balance = bal;
    }

    public List<Transaction> getTransactions() {
        return this.transactionList;
    }

    public CurrencyComposition getCurrencyComposition() {
        return this.currencyComposition;
    }

}
