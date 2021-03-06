import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;

public class AccountRepoImpl implements AccountRepo {

    private final ArrayList<Account> accounts;

    public AccountRepoImpl(ArrayList<Account> accounts){
        this.accounts = accounts;
    }

    @Override
    public ArrayList<Account> getAllAccounts() {
        return accounts;
    }

    @Override
    public double getAverageBalance() {
        int total = 0;
        int count = accounts.size();
        for (Account current : accounts) {
            total += current.balance;
        }
        return (double) total / count;
    }

    @Override
    public ArrayList<Account> get5Richest() {
        ArrayList<Account> fiveRichest = new ArrayList<Account>();
        int lowestBalanceOfTheFive = -1;
        for (Account current : accounts) {
            boolean addToList = fiveRichest.size() < 5 || current.balance > lowestBalanceOfTheFive;
            if(addToList){
                boolean replace = fiveRichest.size() == 5;

                if(replace){
                    fiveRichest.set(0, current);
                }else{
                    fiveRichest.add(current);
                }

                fiveRichest.sort(Comparator.comparingInt(a -> a.balance));
                lowestBalanceOfTheFive = fiveRichest.get(0).balance;
            }
        }
        return fiveRichest;
    }

    @Override
    public ArrayList<Account> get5Poorest() {
        ArrayList<Account> fivePoorest = new ArrayList<Account>();
        int highestBalanceOfTheFive = -1;
        for (Account current : accounts) {
            boolean addToList = fivePoorest.size() < 5 || current.balance < highestBalanceOfTheFive;
            if(addToList){
                boolean replace = fivePoorest.size() == 5;
                boolean setBalanceAsNewHighest = current.balance > highestBalanceOfTheFive || highestBalanceOfTheFive == -1;
                if(setBalanceAsNewHighest){
                    highestBalanceOfTheFive = current.balance;
                }
                if(replace){
                    fivePoorest.set(4, current);
                }else{
                    fivePoorest.add(current);
                }

                fivePoorest.sort(Comparator.comparingInt(a -> a.balance));
                highestBalanceOfTheFive = fivePoorest.get(Math.min(4, fivePoorest.size()-1)).balance;
            }
        }
        return fivePoorest;
    }

    @Override
    public Account getAccountByOwner(String owner) {
        Account accountToReturn = null;
        for(Account account: accounts){
            if(account.owner.equals(owner)){
                accountToReturn = account;
            }
        }
        return accountToReturn;
    }

    @Override
    public Account getRichestAccount() {
        Account currentRichest = null;
        for(Account account: accounts){
            boolean replace = currentRichest == null || account.balance > currentRichest.balance;
            if(replace){
                currentRichest = account;
            }
        }
        return currentRichest;
    }

    @Override
    public Account getPoorestAccount() {
        Account currentPoorest = null;
        for(Account account: accounts){
            boolean replace = currentPoorest == null || account.balance < currentPoorest.balance;
            if(replace){
                currentPoorest = account;
            }
        }
        return currentPoorest;
    }

    @Override
    public void robinHood() {
        Account richest = getRichestAccount();
        Account poorest = getPoorestAccount();

        int amount = richest.balance;
        richest.withdraw(amount);
        poorest.deposit(amount);
    }

    @Override
    public Account hackBank() {
        Account steinBagger = new Account("Stein Bagger");

        for(Account account: accounts){
            int amount = account.balance;
            account.withdraw(amount);
            steinBagger.deposit(amount);
        }

        accounts.add(steinBagger);

        return steinBagger;
    }

    @Override
    public Account terminateAccount(String name) {
        Account removedAcc = null;
        for(Account acc: accounts){
            if(acc.owner.equals(name)){
                removedAcc = acc;

            }
        }

        if(removedAcc != null){
            accounts.remove(removedAcc);
        }
        return removedAcc;
    }
}
