import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AccountRepoImplTest {



    @org.junit.jupiter.api.Test
    void readAccountsFromFile() {
        AccountRepo accountRepo = new AccountRepoImpl();
        accountRepo.readAccountsFromFile();
        assertEquals(50, accountRepo.getAllAccounts().size());
    }

    @org.junit.jupiter.api.Test
    void getAllAccounts() {
        AccountRepo accountRepo = new AccountRepoImpl();
        accountRepo.readAccountsFromFile();
        assertEquals(50, accountRepo.getAllAccounts().size());
    }

    @org.junit.jupiter.api.Test
    void getAverageBalance() {
        AccountRepo accountRepo = new AccountRepoImpl();
        accountRepo.readAccountsFromFile();

        System.out.println("average");
        System.out.println("");
    }

    @org.junit.jupiter.api.Test
    void get5Richest() {
        AccountRepo accountRepo = new AccountRepoImpl();
        accountRepo.readAccountsFromFile();

        ArrayList<Account> expectedAccounts = new ArrayList<>(){{
            add(new Account("Rico Muhammad"));
            add(new Account("Cecile Hearne"));
            add(new Account("Denae Amy"));
            add(new Account("Lesia Schanz"));
            add(new Account("Annis Cowling"));
        }};

        ArrayList<Account> richestArrayList = accountRepo.get5Poorest();

        for(Account account: richestArrayList){
            int matchCount = 0;
            for(Account expAcc: richestArrayList){
                if(expAcc.equals(account)) matchCount ++;
            }
            assertEquals(1, matchCount);
        }
    }

    @org.junit.jupiter.api.Test
    void get5Poorest() {
        AccountRepo accountRepo = new AccountRepoImpl();
        accountRepo.readAccountsFromFile();

        ArrayList<Account> expectedAccounts = new ArrayList<>(){{
            add(new Account("Devon Penton"));
            add(new Account("Norris Labarre"));
            add(new Account("Dominique Collier"));
            add(new Account("Ronna Kitson"));
            add(new Account("Bella Pangborn"));
        }};

        ArrayList<Account> richestArrayList = accountRepo.get5Poorest();

        for(Account account: richestArrayList){
            int matchCount = 0;
            for(Account expAcc: richestArrayList){
                if(expAcc.equals(account)) matchCount ++;
            }
            assertEquals(1, matchCount);
        }
    }

    @org.junit.jupiter.api.Test
    void getAccountByOwner() {
        AccountRepo accountRepo = new AccountRepoImpl();
        accountRepo.readAccountsFromFile();

        String someOwnerIdk = "Sabrina Valvo";

        Account sabrinasAccountProbably = accountRepo.getAccountByOwner(someOwnerIdk);
        assertEquals("Sabrina Valvo", sabrinasAccountProbably.owner);
    }

    @org.junit.jupiter.api.Test
    void getRichestAccount() {
        AccountRepo accountRepo = new AccountRepoImpl();
        accountRepo.readAccountsFromFile();

        assertEquals("Annis Cowling", accountRepo.getRichestAccount().owner);
    }

    @org.junit.jupiter.api.Test
    void getPoorestAccount() {
        AccountRepo accountRepo = new AccountRepoImpl();
        accountRepo.readAccountsFromFile();

        assertEquals("Devon Penton", accountRepo.getPoorestAccount().owner);
    }

    @org.junit.jupiter.api.Test
    void robinHood() {
        AccountRepo accountRepo = new AccountRepoImpl();
        accountRepo.readAccountsFromFile();

        Account preRichest = accountRepo.getRichestAccount();
        Account prePoorest = accountRepo.getPoorestAccount();

        accountRepo.robinHood();

        assertEquals(preRichest, accountRepo.getPoorestAccount());
        assertEquals(prePoorest, accountRepo.getRichestAccount());
    }

    @org.junit.jupiter.api.Test
    void hackBank() {
        AccountRepo accountRepo = new AccountRepoImpl();
        accountRepo.readAccountsFromFile();

        Account stein = accountRepo.hackBank();

        assertEquals(stein, accountRepo.getRichestAccount());
    }
}