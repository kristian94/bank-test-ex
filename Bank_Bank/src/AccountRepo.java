import java.util.ArrayList;

public interface AccountRepo {
    ArrayList<Account> getAllAccounts();
    double getAverageBalance();
    ArrayList<Account> get5Richest();
    ArrayList<Account> get5Poorest();
    Account getAccountByOwner(String owner);
    Account getRichestAccount();
    Account getPoorestAccount();
    void robinHood();
    Account hackBank();
    Account terminateAccount(String name);
}
