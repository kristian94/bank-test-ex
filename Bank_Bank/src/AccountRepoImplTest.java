import org.hamcrest.Matchers;
import org.hamcrest.junit.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;


import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class AccountRepoImplTest {

    ArrayList<Account> accs;

    @BeforeEach
    void setUp() {
        accs = FIleHelper.readAccountsFromFile(FIleHelper.getDefaultPath());
    }

    @Test
    void readAccountsFromFile() {
        AccountRepo accountRepo = new AccountRepoImpl(accs);

        assertThat(accountRepo.getAllAccounts().size(), is(50));

        assertEquals(50, accountRepo.getAllAccounts().size());
    }

    @org.junit.jupiter.api.Test
    void getAllAccounts() {
        AccountRepo accountRepo = new AccountRepoImpl(accs);
        assertEquals(50, accountRepo.getAllAccounts().size());
    }

    @org.junit.jupiter.api.Test
    void getAverageBalance() {
        AccountRepo accountRepo = new AccountRepoImpl(accs);

        assertEquals(505060.5, accountRepo.getAverageBalance());
    }

    @org.junit.jupiter.api.Test
    void get5Richest() {
        AccountRepo accountRepo = new AccountRepoImpl(accs);

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
        AccountRepo accountRepo = new AccountRepoImpl(accs);

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
        AccountRepo accountRepo = new AccountRepoImpl(accs);

        Account account = accountRepo.getAccountByOwner("Sabrina Valvo");

        assertEquals("Sabrina Valvo", account.owner);
        MatcherAssert.assertThat(account.owner, is("Sabrina Valvo"));
    }

    @org.junit.jupiter.api.Test
    void getRichestAccount() {
        AccountRepo accountRepo = new AccountRepoImpl(accs);

        assertEquals("Annis Cowling", accountRepo.getRichestAccount().owner);
    }

    @org.junit.jupiter.api.Test
    void getPoorestAccount() {
        AccountRepo accountRepo = new AccountRepoImpl(accs);

        assertEquals("Devon Penton", accountRepo.getPoorestAccount().owner);
    }

    @org.junit.jupiter.api.Test
    void robinHood() {
        AccountRepo accountRepo = new AccountRepoImpl(accs);

        Account preRichest = accountRepo.getRichestAccount();
        Account prePoorest = accountRepo.getPoorestAccount();

        accountRepo.robinHood();

        assertEquals(preRichest, accountRepo.getPoorestAccount());
        assertEquals(prePoorest, accountRepo.getRichestAccount());
    }

    @org.junit.jupiter.api.Test
    void hackBank() {
        AccountRepo accountRepo = new AccountRepoImpl(accs);



        Account stein = accountRepo.hackBank();

        assertEquals(stein, accountRepo.getRichestAccount());
    }

    @org.junit.jupiter.api.Test
    void terminateAccount(){
        AccountRepo accountRepo = new AccountRepoImpl(accs);

        int sizeBefore = accountRepo.getAllAccounts().size();
        accountRepo.terminateAccount("Sabrina Valvo");
        int sizeAfter = accountRepo.getAllAccounts().size();

        assertEquals(sizeBefore - 1, sizeAfter);
    }
}